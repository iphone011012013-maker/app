// ===== إعدادات الـ Grid =====
final int COLUMNS = 3;

// ===== الألوان الثابتة =====
final int COLOR_BG         = 0xFF0A0A0A;
final int COLOR_CARD_IN    = 0xFF161616;
final int COLOR_GOLD       = 0xFFD4AF37;
final int COLOR_GOLD_DIM   = 0xFF8C7020;
final int COLOR_WA_TOP     = 0xFF0D5C47;
final int COLOR_WA_BOT     = 0xFF07413A;
final int COLOR_WA_BORDER  = 0xFF1A7A60;
final int COLOR_WA_TEXT    = 0xFF25D366;
final int COLOR_TEXT_WHITE = 0xFFEEEEEE;
final int COLOR_TEXT_DIM   = 0xFF888888;
final int COLOR_DIVIDER    = 0xFF252525;
final int COLOR_BTN_TOP    = 0xFF1E1E1E;
final int COLOR_BTN_BOT    = 0xFF161616;
final int COLOR_BTN_BOR    = 0xFF2E2E2E;

// ===== قائمة الأسماء =====
final String[] names = {
    "Abu Al-Fadl ", "Hassan Ibrahim ", "Dad ", "عيد سوبر ماركت ", "محمد مروه ",
    "خالته ام عمر ", "نورهان ", "خالد عبد المنعم ", "جوهر ", "جيمي ",
    "عمرو فرنسا ", "عم مجدي ", "عمتي ام امنيه ", "مينا زباله ", "Esraa ",
    "ممدوح نورهان ", "احمد ممدوح نورهان ", "ام احمد خاله نورهان ", "ام جيمي ",
    "مريم اخت جيمي ", "خالي حسن عبد المنعم ", "خالتي عزه ", "شيماء خالتي عزه ",
    "إيمان خالتي عزه ", "خالته وفاء ", "محمد يوسف ", "ميدو ", "ياسر ", "كرم ",
    "اسامه امن "
};

// ===== قائمة الأرقام =====
final String[][] phones = {
    {"01093650351 ", "01061809351 ", "01205420752 ", "01233389823 ", "01233389824 ", "01554436872 "},
    {"01097123179 "}, {"01001264955 ", "01110879051 "}, {"01146776074 "},
    {"01114709509 "}, {"01150489133 ", "01505160982 ", "0126090314 "},
    {"01124805850 ", "01020759399 "}, {"01014181816 ", "0111785503 "},
    {"01113897927 "}, {"01014647880 ", "01123193731 ", "01122420996 "},
    {"01002814406 ", "01112427052 "}, {"01064442246 "}, {"01070752120 ", "01149104245 "},
    {"01270030647 ", "01272551425 "}, {"01036761791 ", "01101583753 "},
    {"01229070608 "}, {"01117678673 "}, {"01116911345 "}, {"01127257609 ", "01284599693 "},
    {"01116723974 "}, {"01128774726 "}, {"01093490850 "}, {"01113398117 "},
    {"01064756329 "}, {"01283868783 ", "01559031969 "}, {"01277022656 "},
    {"01228270887 ", "+201028581681 ", "+201026219435 ", "01111797722 "},
    {"+201556861032 ", "+201114092882 "}, {"+201287617279 "},
    {"01112311955 ", "01099961478 "}
};

// ===== قائمة أسماء الصور =====
final String[] imageNames = {
    "abu ", "hassan ", "dad ", "eid ", "mohm ", "umm_amr ", "norhan ",
    "khalid ", "johar ", "gemy ", "amr ", "am_magdy ", "amty ",
    "mena ", "esraa ", "mamdouh ", "ahmed_mamdouh ", "om_ahmed ", "om_gemy ",
    "mariam ", "khaly_hassan ", "azza ", "shaima ", "eman ",
    "wafaa ", "moh ", "medo ", "yasser ", "karam ", "osama "
};

// ===== تخصيص الـ ActionBar =====
try {
    android.app.ActionBar actionBar = getActionBar();
    if (actionBar != null) {
        actionBar.setTitle("  ⚡ Fast Call");
        actionBar.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0xFF0A0A0A));
        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        android.widget.TextView tv = (android.widget.TextView) findViewById(titleId);
        if (tv != null) {
            tv.setTextColor(COLOR_GOLD);
            tv.setTextSize(20);
            tv.setTypeface(null, android.graphics.Typeface.BOLD);
        }
    }
} catch (Exception e) {}

// ===== ScrollView الرئيسي =====
ScrollView scrollView = new ScrollView(this);
scrollView.setLayoutParams(new ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
scrollView.setBackgroundColor(COLOR_BG);
scrollView.setVerticalScrollBarEnabled(false);

// ===== Layout الرئيسي =====
LinearLayout mainLayout = new LinearLayout(this);
mainLayout.setOrientation(LinearLayout.VERTICAL);
mainLayout.setLayoutParams(new ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
mainLayout.setPadding(12, 16, 12, 24);

// =====================================================
// ===== Quick Dial Bar (الخانة + الأزرار الثلاثة) =====
// =====================================================
android.graphics.drawable.GradientDrawable qdWrapperBg = new android.graphics.drawable.GradientDrawable();
qdWrapperBg.setCornerRadius(22);
qdWrapperBg.setColors(new int[]{0xFF1C1A10, 0xFF111008});
qdWrapperBg.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
qdWrapperBg.setStroke(2, COLOR_GOLD_DIM);

LinearLayout qdCard = new LinearLayout(this);
qdCard.setOrientation(LinearLayout.VERTICAL);
LinearLayout.LayoutParams qdCardP = new LinearLayout.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
qdCardP.setMargins(4, 0, 4, 20);
qdCard.setLayoutParams(qdCardP);
qdCard.setBackground(qdWrapperBg);
qdCard.setPadding(16, 16, 16, 16);

// --- عنوان البطاقة ---
LinearLayout qdTitleRow = new LinearLayout(this);
qdTitleRow.setOrientation(LinearLayout.HORIZONTAL);
qdTitleRow.setGravity(Gravity.CENTER_VERTICAL);
LinearLayout.LayoutParams qdTRP = new LinearLayout.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
qdTRP.setMargins(0, 0, 0, 14);
qdTitleRow.setLayoutParams(qdTRP);

TextView qdIco = new TextView(this);
qdIco.setText("⚡");
qdIco.setTextSize(15);
LinearLayout.LayoutParams qdIcoP = new LinearLayout.LayoutParams(
    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
qdIcoP.setMargins(0, 0, 8, 0);
qdIco.setLayoutParams(qdIcoP);
qdTitleRow.addView(qdIco);

TextView qdTitle = new TextView(this);
qdTitle.setText("اتصال سريع");
qdTitle.setTextColor(COLOR_GOLD);
qdTitle.setTextSize(13);
qdTitle.setTypeface(null, android.graphics.Typeface.BOLD);
qdTitle.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
qdTitle.setTextDirection(android.view.View.TEXT_DIRECTION_RTL);
qdTitleRow.addView(qdTitle);

qdCard.addView(qdTitleRow);

// --- 1. خانة إدخال الرقم ---
final android.widget.EditText qdInput = new android.widget.EditText(this);
qdInput.setHint("أدخل رقم الهاتف...");
qdInput.setHintTextColor(0xFF555555);
qdInput.setTextColor(COLOR_TEXT_WHITE);
qdInput.setTextSize(16);
qdInput.setTypeface(null, android.graphics.Typeface.BOLD);
qdInput.setInputType(android.text.InputType.TYPE_CLASS_PHONE);
qdInput.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
qdInput.setPadding(20, 16, 16, 16);
qdInput.setSingleLine(true);
qdInput.setTextDirection(android.view.View.TEXT_DIRECTION_LTR);

LinearLayout.LayoutParams qdInputP = new LinearLayout.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
qdInputP.setMargins(0, 0, 0, 12);
qdInput.setLayoutParams(qdInputP);

android.graphics.drawable.GradientDrawable qdInputBg = new android.graphics.drawable.GradientDrawable();
qdInputBg.setCornerRadius(14);
qdInputBg.setColor(0xFF181810);
qdInputBg.setStroke(1, 0xFF3A3218);
qdInput.setBackground(qdInputBg);

qdCard.addView(qdInput); // إضافة الخانة أولاً

// --- 2. صف الأزرار الثلاثة (أسفل الخانة مباشرة) ---
LinearLayout qdRow = new LinearLayout(this);
qdRow.setOrientation(LinearLayout.HORIZONTAL);
qdRow.setGravity(Gravity.CENTER_VERTICAL);
qdRow.setLayoutParams(new LinearLayout.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

// [زر اللصق]
LinearLayout pasteBtn = new LinearLayout(this);
pasteBtn.setOrientation(LinearLayout.VERTICAL);
pasteBtn.setGravity(Gravity.CENTER);
LinearLayout.LayoutParams pasteBtnP = new LinearLayout.LayoutParams(0, 56, 1f);
pasteBtnP.setMargins(0, 0, 8, 0);
pasteBtn.setLayoutParams(pasteBtnP);
android.graphics.drawable.GradientDrawable pasteBg = new android.graphics.drawable.GradientDrawable();
pasteBg.setCornerRadius(14);
pasteBg.setColors(new int[]{0xFF2A2410, 0xFF1A1808});
pasteBg.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
pasteBg.setStroke(1, COLOR_GOLD_DIM);
pasteBtn.setBackground(pasteBg);

TextView pasteIco = new TextView(this);
pasteIco.setText("📋");
pasteIco.setTextSize(20);
pasteIco.setGravity(Gravity.CENTER);
pasteIco.setLayoutParams(new LinearLayout.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
pasteBtn.addView(pasteIco);

pasteBtn.setOnTouchListener(new View.OnTouchListener() {
    public boolean onTouch(View vv, android.view.MotionEvent ev) {
        if (ev.getAction() == android.view.MotionEvent.ACTION_DOWN)
            vv.animate().scaleX(0.88f).scaleY(0.88f).setDuration(60).start();
        else if (ev.getAction() == android.view.MotionEvent.ACTION_UP || ev.getAction() == android.view.MotionEvent.ACTION_CANCEL)
            vv.animate().scaleX(1f).scaleY(1f).setDuration(120).start();
        return false;
    }
});
pasteBtn.setOnClickListener(new View.OnClickListener() {
    public void onClick(View vv) {
        android.content.ClipboardManager cm = (android.content.ClipboardManager) getSystemService(android.content.Context.CLIPBOARD_SERVICE);
        if (cm != null && cm.hasPrimaryClip()) {
            android.content.ClipData.Item item = cm.getPrimaryClip().getItemAt(0);
            if (item != null && item.getText() != null) {
                String pasted = item.getText().toString().trim();
                qdInput.setText(pasted);
                qdInput.setSelection(pasted.length());
                android.widget.Toast.makeText(MainActivity.this, "✓ تم اللصق", android.widget.Toast.LENGTH_SHORT).show();
            }
        } else {
            android.widget.Toast.makeText(MainActivity.this, "الحافظة فارغة", android.widget.Toast.LENGTH_SHORT).show();
        }
    }
});
qdRow.addView(pasteBtn);

// [زر فودافون كاش]
LinearLayout vcBtn = new LinearLayout(this);
vcBtn.setOrientation(LinearLayout.VERTICAL);
vcBtn.setGravity(Gravity.CENTER);
LinearLayout.LayoutParams vcBtnP = new LinearLayout.LayoutParams(0, 56, 1f);
vcBtnP.setMargins(0, 0, 8, 0);
vcBtn.setLayoutParams(vcBtnP);
android.graphics.drawable.GradientDrawable vcBg = new android.graphics.drawable.GradientDrawable();
vcBg.setCornerRadius(14);
vcBg.setColors(new int[]{0xFF8B0000, 0xFF5C0000});
vcBg.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
vcBg.setStroke(1, 0xFFBB0000);
vcBtn.setBackground(vcBg);

TextView vcIco = new TextView(this);
vcIco.setText("💸");
vcIco.setTextSize(18);
vcIco.setGravity(Gravity.CENTER);
vcIco.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
vcBtn.addView(vcIco);

TextView vcLbl = new TextView(this);
vcLbl.setText("V.Cash");
vcLbl.setTextColor(0xFFFF4444);
vcLbl.setTextSize(7.5f);
vcLbl.setGravity(Gravity.CENTER);
vcLbl.setTypeface(null, android.graphics.Typeface.BOLD);
LinearLayout.LayoutParams vcLblP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
vcLblP.setMargins(0, 2, 0, 0);
vcLbl.setLayoutParams(vcLblP);
vcBtn.addView(vcLbl);

vcBtn.setOnTouchListener(new View.OnTouchListener() {
    public boolean onTouch(View vv, android.view.MotionEvent ev) {
        if (ev.getAction() == android.view.MotionEvent.ACTION_DOWN)
            vv.animate().scaleX(0.88f).scaleY(0.88f).setDuration(60).start();
        else if (ev.getAction() == android.view.MotionEvent.ACTION_UP || ev.getAction() == android.view.MotionEvent.ACTION_CANCEL)
            vv.animate().scaleX(1f).scaleY(1f).setDuration(120).start();
        return false;
    }
});
vcBtn.setOnClickListener(new View.OnClickListener() {
    public void onClick(View vv) {
        final android.app.Dialog vcDlg = new android.app.Dialog(MainActivity.this);
        vcDlg.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
        vcDlg.setCanceledOnTouchOutside(true);

        LinearLayout vcRoot = new LinearLayout(MainActivity.this);
        vcRoot.setOrientation(LinearLayout.VERTICAL);
        vcRoot.setPadding(28, 28, 28, 24);

        android.graphics.drawable.GradientDrawable vcDlgBg = new android.graphics.drawable.GradientDrawable();
        vcDlgBg.setCornerRadius(28);
        vcDlgBg.setColors(new int[]{0xFF1A0505, 0xFF0F0000});
        vcDlgBg.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
        vcDlgBg.setStroke(2, 0xFF8B0000);
        vcRoot.setBackground(vcDlgBg);

        View vcInd = new View(MainActivity.this);
        LinearLayout.LayoutParams vcIndP = new LinearLayout.LayoutParams(44, 5);
        vcIndP.gravity = Gravity.CENTER_HORIZONTAL;
        vcIndP.setMargins(0, 0, 0, 20);
        vcInd.setLayoutParams(vcIndP);
        android.graphics.drawable.GradientDrawable vcIndBg = new android.graphics.drawable.GradientDrawable();
        vcIndBg.setColor(0xFFCC0000);
        vcIndBg.setCornerRadius(10);
        vcInd.setBackground(vcIndBg);
        vcRoot.addView(vcInd);

        TextView vcDlgTitle = new TextView(MainActivity.this);
        vcDlgTitle.setText("💸 فودافون كاش");
        vcDlgTitle.setTextColor(0xFFFF4444);
        vcDlgTitle.setTextSize(18);
        vcDlgTitle.setGravity(Gravity.CENTER);
        vcDlgTitle.setTypeface(null, android.graphics.Typeface.BOLD);
        LinearLayout.LayoutParams vcTitleP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vcTitleP.setMargins(0, 0, 0, 22);
        vcDlgTitle.setLayoutParams(vcTitleP);
        vcRoot.addView(vcDlgTitle);

        TextView vcPhLbl = new TextView(MainActivity.this);
        vcPhLbl.setText("رقم التليفون");
        vcPhLbl.setTextColor(0xFF999999);
        vcPhLbl.setTextSize(11);
        vcPhLbl.setTypeface(null, android.graphics.Typeface.BOLD);
        vcPhLbl.setTextDirection(android.view.View.TEXT_DIRECTION_RTL);
        LinearLayout.LayoutParams vcPhLblP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vcPhLblP.setMargins(4, 0, 0, 6);
        vcPhLbl.setLayoutParams(vcPhLblP);
        vcRoot.addView(vcPhLbl);

        final android.widget.EditText vcPhInput = new android.widget.EditText(MainActivity.this);
        vcPhInput.setHint("01XXXXXXXXX");
        vcPhInput.setHintTextColor(0xFF444444);
        vcPhInput.setTextColor(0xFFEEEEEE);
        vcPhInput.setTextSize(16);
        vcPhInput.setTypeface(null, android.graphics.Typeface.BOLD);
        vcPhInput.setInputType(android.text.InputType.TYPE_CLASS_PHONE);
        vcPhInput.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
        vcPhInput.setPadding(18, 16, 18, 16);
        vcPhInput.setSingleLine(true);
        vcPhInput.setTextDirection(android.view.View.TEXT_DIRECTION_LTR);

        String existingNum = qdInput.getText().toString().trim();
        if (!existingNum.isEmpty()) {
            vcPhInput.setText(existingNum);
            vcPhInput.setSelection(existingNum.length());
        }

        LinearLayout.LayoutParams vcPhInputP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vcPhInputP.setMargins(0, 0, 0, 16);
        vcPhInput.setLayoutParams(vcPhInputP);
        android.graphics.drawable.GradientDrawable vcPhBg = new android.graphics.drawable.GradientDrawable();
        vcPhBg.setCornerRadius(14);
        vcPhBg.setColor(0xFF1A0808);
        vcPhBg.setStroke(1, 0xFF5C0000);
        vcPhInput.setBackground(vcPhBg);
        vcRoot.addView(vcPhInput);

        TextView vcAmtLbl = new TextView(MainActivity.this);
        vcAmtLbl.setText("المبلغ (جنيه)");
        vcAmtLbl.setTextColor(0xFF999999);
        vcAmtLbl.setTextSize(11);
        vcAmtLbl.setTypeface(null, android.graphics.Typeface.BOLD);
        vcAmtLbl.setTextDirection(android.view.View.TEXT_DIRECTION_RTL);
        LinearLayout.LayoutParams vcAmtLblP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vcAmtLblP.setMargins(4, 0, 0, 6);
        vcAmtLbl.setLayoutParams(vcAmtLblP);
        vcRoot.addView(vcAmtLbl);

        final android.widget.EditText vcAmtInput = new android.widget.EditText(MainActivity.this);
        vcAmtInput.setHint("0");
        vcAmtInput.setHintTextColor(0xFF444444);
        vcAmtInput.setTextColor(0xFFEEEEEE);
        vcAmtInput.setTextSize(16);
        vcAmtInput.setTypeface(null, android.graphics.Typeface.BOLD);
        vcAmtInput.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        vcAmtInput.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
        vcAmtInput.setPadding(18, 16, 18, 16);
        vcAmtInput.setSingleLine(true);
        LinearLayout.LayoutParams vcAmtInputP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vcAmtInputP.setMargins(0, 0, 0, 24);
        vcAmtInput.setLayoutParams(vcAmtInputP);
        android.graphics.drawable.GradientDrawable vcAmtBg = new android.graphics.drawable.GradientDrawable();
        vcAmtBg.setCornerRadius(14);
        vcAmtBg.setColor(0xFF1A0808);
        vcAmtBg.setStroke(1, 0xFF5C0000);
        vcAmtInput.setBackground(vcAmtBg);
        vcRoot.addView(vcAmtInput);

        View vcDiv = new View(MainActivity.this);
        LinearLayout.LayoutParams vcDivP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        vcDivP.setMargins(0, 0, 0, 20);
        vcDiv.setLayoutParams(vcDivP);
        vcDiv.setBackgroundColor(0xFF3A0000);
        vcRoot.addView(vcDiv);

        LinearLayout vcBtnRow = new LinearLayout(MainActivity.this);
        vcBtnRow.setOrientation(LinearLayout.HORIZONTAL);
        vcBtnRow.setGravity(Gravity.CENTER);
        vcBtnRow.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView vcCancelBtn = new TextView(MainActivity.this);
        vcCancelBtn.setText("إلغاء");
        vcCancelBtn.setTextColor(0xFF777777);
        vcCancelBtn.setTextSize(14);
        vcCancelBtn.setGravity(Gravity.CENTER);
        vcCancelBtn.setTypeface(null, android.graphics.Typeface.BOLD);
        vcCancelBtn.setPadding(0, 18, 0, 18);
        LinearLayout.LayoutParams vcCancelP = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
        vcCancelP.setMargins(0, 0, 10, 0);
        vcCancelBtn.setLayoutParams(vcCancelP);
        android.graphics.drawable.GradientDrawable vcCancelBg = new android.graphics.drawable.GradientDrawable();
        vcCancelBg.setCornerRadius(14);
        vcCancelBg.setColor(0xFF1A1A1A);
        vcCancelBg.setStroke(1, 0xFF333333);
        vcCancelBtn.setBackground(vcCancelBg);
        vcCancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View vv) { vcDlg.dismiss(); }
        });
        vcBtnRow.addView(vcCancelBtn);

        TextView vcTransferBtn = new TextView(MainActivity.this);
        vcTransferBtn.setText("تحويل 💸");
        vcTransferBtn.setTextColor(0xFFFFFFFF);
        vcTransferBtn.setTextSize(14);
        vcTransferBtn.setGravity(Gravity.CENTER);
        vcTransferBtn.setTypeface(null, android.graphics.Typeface.BOLD);
        vcTransferBtn.setPadding(0, 18, 0, 18);
        LinearLayout.LayoutParams vcTransferP = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.5f);
        vcTransferBtn.setLayoutParams(vcTransferP);
        android.graphics.drawable.GradientDrawable vcTransferBg = new android.graphics.drawable.GradientDrawable();
        vcTransferBg.setCornerRadius(14);
        vcTransferBg.setColors(new int[]{0xFFCC0000, 0xFF880000});
        vcTransferBg.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
        vcTransferBg.setStroke(1, 0xFFEE0000);
        vcTransferBtn.setBackground(vcTransferBg);
        vcTransferBtn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View vv, android.view.MotionEvent ev) {
                if (ev.getAction() == android.view.MotionEvent.ACTION_DOWN)
                    vv.animate().scaleX(0.95f).scaleY(0.95f).setDuration(60).start();
                else if (ev.getAction() == android.view.MotionEvent.ACTION_UP || ev.getAction() == android.view.MotionEvent.ACTION_CANCEL)
                    vv.animate().scaleX(1f).scaleY(1f).setDuration(120).start();
                return false;
            }
        });
        vcTransferBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View vv) {
                String vcNum = vcPhInput.getText().toString().trim();
                String vcAmt = vcAmtInput.getText().toString().trim();
                if (vcNum.isEmpty()) {
                    android.widget.Toast.makeText(MainActivity.this, "أدخل رقم التليفون", android.widget.Toast.LENGTH_SHORT).show();
                    return;
                }
                if (vcAmt.isEmpty() || vcAmt.equals("0")) {
                    android.widget.Toast.makeText(MainActivity.this, "أدخل المبلغ", android.widget.Toast.LENGTH_SHORT).show();
                    return;
                }
                vcDlg.dismiss();
                String ussdCode = "*9*7*" + vcNum + "*" + vcAmt + "%23";
                Intent ussdIntent = new Intent(Intent.ACTION_CALL);
                ussdIntent.setData(Uri.parse("tel:" + ussdCode));
                startActivity(ussdIntent);
            }
        });
        vcBtnRow.addView(vcTransferBtn);
        vcRoot.addView(vcBtnRow);

        vcDlg.setContentView(vcRoot);
        android.view.Window vcW = vcDlg.getWindow();
        if (vcW != null) {
            vcW.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));
            vcW.setLayout((int)(getResources().getDisplayMetrics().widthPixels * 0.88f), ViewGroup.LayoutParams.WRAP_CONTENT);
            vcW.setGravity(Gravity.CENTER);
            vcW.getAttributes().windowAnimations = android.R.style.Animation_Dialog;
        }
        vcDlg.show();
    }
});
qdRow.addView(vcBtn);

// [زر الاتصال]
LinearLayout callNowBtn = new LinearLayout(this);
callNowBtn.setOrientation(LinearLayout.VERTICAL);
callNowBtn.setGravity(Gravity.CENTER);
callNowBtn.setLayoutParams(new LinearLayout.LayoutParams(0, 56, 1f));
android.graphics.drawable.GradientDrawable callNowBg = new android.graphics.drawable.GradientDrawable();
callNowBg.setCornerRadius(14);
callNowBg.setColors(new int[]{0xFF2A6B1A, 0xFF174010});
callNowBg.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
callNowBg.setStroke(1, 0xFF3A9022);
callNowBtn.setBackground(callNowBg);

TextView callNowIco = new TextView(this);
callNowIco.setText("📞");
callNowIco.setTextSize(20);
callNowIco.setGravity(Gravity.CENTER);
callNowIco.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
callNowBtn.addView(callNowIco);

TextView callNowLbl = new TextView(this);
callNowLbl.setText("اتصال");
callNowLbl.setTextColor(0xFF4ADE80);
callNowLbl.setTextSize(9f);
callNowLbl.setGravity(Gravity.CENTER);
callNowLbl.setTypeface(null, android.graphics.Typeface.BOLD);
LinearLayout.LayoutParams callNowLblP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
callNowLblP.setMargins(0, 2, 0, 0);
callNowLbl.setLayoutParams(callNowLblP);
callNowBtn.addView(callNowLbl);

callNowBtn.setOnTouchListener(new View.OnTouchListener() {
    public boolean onTouch(View vv, android.view.MotionEvent ev) {
        if (ev.getAction() == android.view.MotionEvent.ACTION_DOWN)
            vv.animate().scaleX(0.88f).scaleY(0.88f).setDuration(60).start();
        else if (ev.getAction() == android.view.MotionEvent.ACTION_UP || ev.getAction() == android.view.MotionEvent.ACTION_CANCEL)
            vv.animate().scaleX(1f).scaleY(1f).setDuration(120).start();
        return false;
    }
});
callNowBtn.setOnClickListener(new View.OnClickListener() {
    public void onClick(View vv) {
        String num = qdInput.getText().toString().trim();
        if (num.isEmpty()) {
            android.widget.Toast.makeText(MainActivity.this, "أدخل رقم أو الصقه أولاً", android.widget.Toast.LENGTH_SHORT).show();
            return;
        }
        Intent ci = new Intent(Intent.ACTION_CALL);
        ci.setData(Uri.parse("tel:" + num));
        startActivity(ci);
    }
});
qdRow.addView(callNowBtn);

qdCard.addView(qdRow); // إضافة صف الأزرار أسفل الخانة
mainLayout.addView(qdCard); // إضافة البطاقة كاملة للـ Layout الرئيسي

// =====================================================
// ===== Header: خط + عداد + خط =====
// =====================================================
LinearLayout headerRow = new LinearLayout(this);
headerRow.setOrientation(LinearLayout.HORIZONTAL);
headerRow.setGravity(Gravity.CENTER_VERTICAL);
LinearLayout.LayoutParams hrP = new LinearLayout.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
hrP.setMargins(8, 0, 8, 20);
headerRow.setLayoutParams(hrP);

View lineL = new View(this);
lineL.setLayoutParams(new LinearLayout.LayoutParams(0, 2, 1f));
lineL.setBackgroundColor(COLOR_GOLD_DIM);

TextView counterTv = new TextView(this);
counterTv.setText("  " + names.length + " جهة اتصال  ");
counterTv.setTextColor(COLOR_GOLD_DIM);
counterTv.setTextSize(11);
counterTv.setGravity(Gravity.CENTER);
counterTv.setTypeface(null, android.graphics.Typeface.BOLD);

View lineR = new View(this);
lineR.setLayoutParams(new LinearLayout.LayoutParams(0, 2, 1f));
lineR.setBackgroundColor(COLOR_GOLD_DIM);

headerRow.addView(lineL);
headerRow.addView(counterTv);
headerRow.addView(lineR);
mainLayout.addView(headerRow);

// =====================================================
// ===== بناء الـ Grid =====
// =====================================================
int totalItems = names.length;
int currentRowItems = 0;
LinearLayout rowLayout = null;

for (int i = 0; i < totalItems; i++) {
    if (currentRowItems == 0) {
        rowLayout = new LinearLayout(this);
        rowLayout.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    
    final int index = i;
    final String personName = names[i];
    final int numCount = phones[i].length;

    FrameLayout cardWrapper = new FrameLayout(this);
    LinearLayout.LayoutParams cwP = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
    cwP.setMargins(7, 7, 7, 7);
    cardWrapper.setLayoutParams(cwP);

    View shadowV = new View(this);
    FrameLayout.LayoutParams svP = new FrameLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    svP.setMargins(5, 7, 0, 0);
    shadowV.setLayoutParams(svP);
    android.graphics.drawable.GradientDrawable shadowShape = new android.graphics.drawable.GradientDrawable();
    shadowShape.setColor(0x33D4AF37);
    shadowShape.setCornerRadius(20);
    shadowV.setBackground(shadowShape);
    cardWrapper.addView(shadowV);

    final LinearLayout card = new LinearLayout(this);
    card.setOrientation(LinearLayout.VERTICAL);
    card.setGravity(Gravity.CENTER);
    card.setLayoutParams(new FrameLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    card.setPadding(10, 20, 10, 16);

    android.graphics.drawable.GradientDrawable cardBg = new android.graphics.drawable.GradientDrawable();
    cardBg.setCornerRadius(20);
    cardBg.setColors(new int[]{0xFF1C1C1C, 0xFF111111});
    cardBg.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
    cardBg.setStroke(2, COLOR_GOLD_DIM);
    card.setBackground(cardBg);

    FrameLayout avatarFrame = new FrameLayout(this);
    int avSize = 108;
    LinearLayout.LayoutParams afP = new LinearLayout.LayoutParams(avSize, avSize);
    afP.setMargins(0, 0, 0, 12);
    afP.gravity = Gravity.CENTER_HORIZONTAL;
    avatarFrame.setLayoutParams(afP);

    android.graphics.drawable.GradientDrawable ringBg = new android.graphics.drawable.GradientDrawable();
    ringBg.setShape(android.graphics.drawable.GradientDrawable.OVAL);
    ringBg.setStroke(3, COLOR_GOLD);
    ringBg.setColor(0x00000000);
    avatarFrame.setBackground(ringBg);
    avatarFrame.setPadding(5, 5, 5, 5);

    ImageView imgV = new ImageView(this);
    imgV.setLayoutParams(new FrameLayout.LayoutParams(
        FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
    imgV.setScaleType(ImageView.ScaleType.CENTER_CROP);

    boolean loaded = false;
    try {
        int rid = getResources().getIdentifier(imageNames[i], "drawable", getPackageName());
        if (rid != 0) { imgV.setImageResource(rid); loaded = true; }
    } catch (Exception e) {}

    if (!loaded) {
        android.graphics.drawable.GradientDrawable fbCircle = new android.graphics.drawable.GradientDrawable();
        fbCircle.setShape(android.graphics.drawable.GradientDrawable.OVAL);
        fbCircle.setColors(new int[]{0xFF2A2A2A, 0xFF181818});
        fbCircle.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TL_BR);
        imgV.setBackground(fbCircle);

        TextView initTv = new TextView(this);
        String fc = personName.length() > 0 ? String.valueOf(personName.charAt(0)).toUpperCase() : "?";
        initTv.setText(fc);
        initTv.setTextColor(COLOR_GOLD);
        initTv.setTextSize(26);
        initTv.setGravity(Gravity.CENTER);
        initTv.setTypeface(null, android.graphics.Typeface.BOLD);
        initTv.setLayoutParams(new FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        avatarFrame.addView(imgV);
        avatarFrame.addView(initTv);
    } else {
        imgV.setClipToOutline(true);
        imgV.setOutlineProvider(new android.view.ViewOutlineProvider() {
            public void getOutline(android.view.View view, android.graphics.Outline outline) {
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        });
        avatarFrame.addView(imgV);
    }
    card.addView(avatarFrame);

    TextView nameTv = new TextView(this);
    nameTv.setText(personName);
    nameTv.setTextColor(COLOR_TEXT_WHITE);
    nameTv.setTextSize(12f);
    nameTv.setGravity(Gravity.CENTER);
    nameTv.setMaxLines(1);
    nameTv.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
    nameTv.setMarqueeRepeatLimit(-1);
    nameTv.setSelected(true);
    nameTv.setSingleLine(true);
    nameTv.setHorizontallyScrolling(true);
    nameTv.setTypeface(null, android.graphics.Typeface.BOLD);
    
    boolean isAr = false;
    for (int c = 0; c < personName.length(); c++) {
        if (Character.UnicodeBlock.of(personName.charAt(c)) == Character.UnicodeBlock.ARABIC) {
            isAr = true; break;
        }
    }
    nameTv.setTextDirection(isAr ? android.view.View.TEXT_DIRECTION_RTL : android.view.View.TEXT_DIRECTION_LTR);
    card.addView(nameTv);

    if (numCount > 1) {
        TextView badgeTv = new TextView(this);
        badgeTv.setText(numCount + " أرقام");
        badgeTv.setTextColor(COLOR_GOLD_DIM);
        badgeTv.setTextSize(9f);
        badgeTv.setGravity(Gravity.CENTER);
        badgeTv.setPadding(10, 3, 10, 3);
        LinearLayout.LayoutParams badgeP = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        badgeP.gravity = Gravity.CENTER_HORIZONTAL;
        badgeP.setMargins(0, 6, 0, 0);
        badgeTv.setLayoutParams(badgeP);
        android.graphics.drawable.GradientDrawable badgeBg = new android.graphics.drawable.GradientDrawable();
        badgeBg.setColor(0xFF1F1A0A);
        badgeBg.setCornerRadius(20);
        badgeBg.setStroke(1, COLOR_GOLD_DIM);
        badgeTv.setBackground(badgeBg);
        card.addView(badgeTv);
    }

    card.setOnTouchListener(new View.OnTouchListener() {
        public boolean onTouch(View v, android.view.MotionEvent ev) {
            if (ev.getAction() == android.view.MotionEvent.ACTION_DOWN)
                v.animate().scaleX(0.94f).scaleY(0.94f).setDuration(80).start();
            else if (ev.getAction() == android.view.MotionEvent.ACTION_UP || ev.getAction() == android.view.MotionEvent.ACTION_CANCEL)
                v.animate().scaleX(1f).scaleY(1f).setDuration(150).start();
            return false;
        }
    });

    card.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            final android.app.Dialog dlg = new android.app.Dialog(MainActivity.this);
            dlg.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
            dlg.setCanceledOnTouchOutside(true);

            LinearLayout root = new LinearLayout(MainActivity.this);
            root.setOrientation(LinearLayout.VERTICAL);

            android.graphics.drawable.GradientDrawable dlgBg = new android.graphics.drawable.GradientDrawable();
            dlgBg.setCornerRadius(28);
            dlgBg.setColors(new int[]{0xFF1A1A1A, 0xFF0F0F0F});
            dlgBg.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
            dlgBg.setStroke(1, 0xFF2A2A2A);
            root.setBackground(dlgBg);

            LinearLayout dlgHeader = new LinearLayout(MainActivity.this);
            dlgHeader.setOrientation(LinearLayout.VERTICAL);
            dlgHeader.setGravity(Gravity.CENTER);
            dlgHeader.setPadding(28, 24, 28, 18);

            View indBar = new View(MainActivity.this);
            LinearLayout.LayoutParams ibP = new LinearLayout.LayoutParams(44, 5);
            ibP.gravity = Gravity.CENTER_HORIZONTAL;
            ibP.setMargins(0, 0, 0, 18);
            indBar.setLayoutParams(ibP);
            android.graphics.drawable.GradientDrawable indBg = new android.graphics.drawable.GradientDrawable();
            indBg.setColor(COLOR_GOLD);
            indBg.setCornerRadius(10);
            indBar.setBackground(indBg);
            dlgHeader.addView(indBar);

            TextView dlgName = new TextView(MainActivity.this);
            dlgName.setText(personName);
            dlgName.setTextColor(0xFFEEEEEE);
            dlgName.setTextSize(20);
            dlgName.setGravity(Gravity.CENTER);
            dlgName.setTypeface(null, android.graphics.Typeface.BOLD);
            dlgHeader.addView(dlgName);

            TextView dlgSub = new TextView(MainActivity.this);
            int pLen = phones[index].length;
            dlgSub.setText(pLen + (pLen > 1 ? " أرقام متاحة" : " رقم متاح"));
            dlgSub.setTextColor(0xFF777777);
            dlgSub.setTextSize(12);
            dlgSub.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams subP = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            subP.setMargins(0, 6, 0, 0);
            dlgSub.setLayoutParams(subP);
            dlgHeader.addView(dlgSub);

            root.addView(dlgHeader);

            View div1 = new View(MainActivity.this);
            div1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
            div1.setBackgroundColor(0xFF252525);
            root.addView(div1);

            LinearLayout numsCont = new LinearLayout(MainActivity.this);
            numsCont.setOrientation(LinearLayout.VERTICAL);
            numsCont.setPadding(20, 16, 20, 16);

            for (int p = 0; p < phones[index].length; p++) {
                final String ph = phones[index][p];
                final boolean notLast = (p < phones[index].length - 1);

                LinearLayout phRow = new LinearLayout(MainActivity.this);
                phRow.setOrientation(LinearLayout.HORIZONTAL);
                phRow.setGravity(Gravity.CENTER_VERTICAL);
                LinearLayout.LayoutParams phRowP = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                phRowP.setMargins(0, 0, 0, notLast ? 10 : 0);
                phRow.setLayoutParams(phRowP);

                final LinearLayout callBtn = new LinearLayout(MainActivity.this);
                callBtn.setOrientation(LinearLayout.HORIZONTAL);
                callBtn.setGravity(Gravity.CENTER_VERTICAL);
                callBtn.setPadding(16, 16, 16, 16);
                LinearLayout.LayoutParams cbP = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
                cbP.setMargins(0, 0, 8, 0);
                callBtn.setLayoutParams(cbP);

                android.graphics.drawable.GradientDrawable cbBg = new android.graphics.drawable.GradientDrawable();
                cbBg.setCornerRadius(14);
                cbBg.setColors(new int[]{COLOR_BTN_TOP, COLOR_BTN_BOT});
                cbBg.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
                cbBg.setStroke(1, COLOR_BTN_BOR);
                callBtn.setBackground(cbBg);

                TextView callIco = new TextView(MainActivity.this);
                callIco.setText("📞");
                callIco.setTextSize(18);
                LinearLayout.LayoutParams ciP = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                ciP.setMargins(0, 0, 12, 0);
                callIco.setLayoutParams(ciP);
                callBtn.addView(callIco);

                LinearLayout phTexts = new LinearLayout(MainActivity.this);
                phTexts.setOrientation(LinearLayout.VERTICAL);
                phTexts.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

                if (phones[index].length > 1) {
                    TextView phLabel = new TextView(MainActivity.this);
                    phLabel.setText("رقم " + (p + 1));
                    phLabel.setTextColor(0xFF666666);
                    phLabel.setTextSize(10);
                    phLabel.setTypeface(null, android.graphics.Typeface.BOLD);
                    phTexts.addView(phLabel);
                }

                TextView phNum = new TextView(MainActivity.this);
                phNum.setText(ph);
                phNum.setTextColor(0xFFEEEEEE);
                phNum.setTextSize(15);
                phNum.setTypeface(null, android.graphics.Typeface.BOLD);
                phTexts.addView(phNum);
                callBtn.addView(phTexts);

                callBtn.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View vv, android.view.MotionEvent ev) {
                        if (ev.getAction() == android.view.MotionEvent.ACTION_DOWN)
                            vv.animate().scaleX(0.96f).scaleY(0.96f).setDuration(60).start();
                        else if (ev.getAction() == android.view.MotionEvent.ACTION_UP || ev.getAction() == android.view.MotionEvent.ACTION_CANCEL)
                            vv.animate().scaleX(1f).scaleY(1f).setDuration(120).start();
                        return false;
                    }
                });

                callBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View vv) {
                        dlg.dismiss();
                        Intent ci = new Intent(Intent.ACTION_CALL);
                        ci.setData(Uri.parse("tel:" + ph));
                        startActivity(ci);
                    }
                });
                phRow.addView(callBtn);

                final LinearLayout waBtn = new LinearLayout(MainActivity.this);
                waBtn.setOrientation(LinearLayout.VERTICAL);
                waBtn.setGravity(Gravity.CENTER);
                waBtn.setPadding(0, 14, 0, 14);
                waBtn.setLayoutParams(new LinearLayout.LayoutParams(68, ViewGroup.LayoutParams.MATCH_PARENT));

                android.graphics.drawable.GradientDrawable waBg = new android.graphics.drawable.GradientDrawable();
                waBg.setCornerRadius(14);
                waBg.setColors(new int[]{COLOR_WA_TOP, COLOR_WA_BOT});
                waBg.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM);
                waBg.setStroke(1, COLOR_WA_BORDER);
                waBtn.setBackground(waBg);

                TextView waIco = new TextView(MainActivity.this);
                waIco.setText("💬");
                waIco.setTextSize(19);
                waIco.setGravity(Gravity.CENTER);
                waIco.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                waBtn.addView(waIco);

                TextView waLbl = new TextView(MainActivity.this);
                waLbl.setText("واتس");
                waLbl.setTextColor(COLOR_WA_TEXT);
                waLbl.setTextSize(9);
                waLbl.setGravity(Gravity.CENTER);
                waLbl.setTypeface(null, android.graphics.Typeface.BOLD);
                LinearLayout.LayoutParams waLP = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                waLP.setMargins(0, 4, 0, 0);
                waLbl.setLayoutParams(waLP);
                waBtn.addView(waLbl);

                waBtn.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View vv, android.view.MotionEvent ev) {
                        if (ev.getAction() == android.view.MotionEvent.ACTION_DOWN)
                            vv.animate().scaleX(0.93f).scaleY(0.93f).setDuration(60).start();
                        else if (ev.getAction() == android.view.MotionEvent.ACTION_UP || ev.getAction() == android.view.MotionEvent.ACTION_CANCEL)
                            vv.animate().scaleX(1f).scaleY(1f).setDuration(120).start();
                        return false;
                    }
                });

                waBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View vv) {
                        dlg.dismiss();
                        String wn = ph.trim().replaceAll("[\\s\\-]", "");
                        if (wn.startsWith("0") && !wn.startsWith("00")) wn = "20" + wn.substring(1);
                        else if (wn.startsWith("00")) wn = wn.substring(2);
                        else if (wn.startsWith("+")) wn = wn.substring(1);
                        final String finalNum = wn;
                        try {
                            Intent wi = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/" + finalNum));
                            wi.setPackage("com.whatsapp");
                            startActivity(wi);
                        } catch (Exception e) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/" + finalNum)));
                        }
                    }
                });
                phRow.addView(waBtn);
                numsCont.addView(phRow);
            }
            root.addView(numsCont);

            View div2 = new View(MainActivity.this);
            div2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
            div2.setBackgroundColor(0xFF252525);
            root.addView(div2);

            TextView closeBtn = new TextView(MainActivity.this);
            closeBtn.setText("إغلاق");
            closeBtn.setTextColor(0xFF777777);
            closeBtn.setTextSize(14);
            closeBtn.setGravity(Gravity.CENTER);
            closeBtn.setPadding(0, 20, 0, 22);
            closeBtn.setTypeface(null, android.graphics.Typeface.BOLD);
            closeBtn.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            closeBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View vv) { dlg.dismiss(); }
            });
            closeBtn.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View vv, android.view.MotionEvent ev) {
                    if (ev.getAction() == android.view.MotionEvent.ACTION_DOWN)
                        ((TextView) vv).setTextColor(0xFFEEEEEE);
                    else ((TextView) vv).setTextColor(0xFF777777);
                    return false;
                }
            });
            root.addView(closeBtn);

            dlg.setContentView(root);
            android.view.Window dw = dlg.getWindow();
            if (dw != null) {
                dw.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));
                dw.setLayout((int)(getResources().getDisplayMetrics().widthPixels * 0.88f), ViewGroup.LayoutParams.WRAP_CONTENT);
                dw.setGravity(Gravity.CENTER);
                dw.getAttributes().windowAnimations = android.R.style.Animation_Dialog;
            }
            dlg.show();
        }
    });

    cardWrapper.addView(card);
    rowLayout.addView(cardWrapper);
    currentRowItems++;

    if (currentRowItems == COLUMNS) {
        mainLayout.addView(rowLayout);
        currentRowItems = 0;
    }
}

if (currentRowItems > 0) {
    while (currentRowItems < COLUMNS) {
        View sp = new View(this);
        LinearLayout.LayoutParams spP = new LinearLayout.LayoutParams(0, 1, 1.0f);
        spP.setMargins(7, 7, 7, 7);
        sp.setLayoutParams(spP);
        rowLayout.addView(sp);
        currentRowItems++;
    }
    mainLayout.addView(rowLayout);
}

scrollView.addView(mainLayout);
setContentView(scrollView);

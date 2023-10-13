package com.xuchaoji.recycler.kk.activity;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends Activity {

    protected void requestScreenOn() {
        getWindow().getDecorView().setKeepScreenOn(true);
    }

    protected void hideActionStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
    }

    protected void hideBottomViews() {
        View decorView = getWindow().getDecorView();
        int uiOption = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOption);
    }
}

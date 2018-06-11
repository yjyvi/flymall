package com.whmnrc.flymall.ui;

import android.os.Handler;

import com.whmnrc.flymall.R;


/**
 * @author wen
 * @date 2016/12/1
 * 欢迎界面
 */
public class SplashActivity extends BaseActivity {
    public static Handler sHandler = new Handler();

    @Override
    protected void initViewData() {
        intoApp();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_splash;
    }


    public void intoApp() {
        sHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AdvertisingActivity.start(SplashActivity.this);
                finish();
            }
        }, 2000);
    }
}

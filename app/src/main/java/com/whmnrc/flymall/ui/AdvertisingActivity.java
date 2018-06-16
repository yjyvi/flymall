package com.whmnrc.flymall.ui;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.utils.SPUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/6/8.
 */

public class AdvertisingActivity extends BaseActivity {
    @BindView(R.id.iv_advertising)
    ImageView mIvAdvertising;

    private static long mAdvertisingTime = 5000;

    public static Handler sHandler = new Handler();

    @Override
    protected void initViewData() {
        sHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToHome();
            }
        }, mAdvertisingTime);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_advertising;
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, AdvertisingActivity.class);
        context.startActivity(starter);
    }

    @OnClick(R.id.iv_jump_home)
    public void onClick() {
        goToHome();
    }

    private void goToHome() {
        if (SPUtils.getBooleanToken(MyApplication.applicationContext, CommonConstant.Common.FIRST_LAUNCHER)) {
//            if (TextUtils.isEmpty(SPUtils.getString(getApplicationContext(), CommonConstant.Common.LAST_LOGIN_ID))) {
//                LoginSelectedActivity.start(AdvertisingActivity.this);
//            } else {
                HomeTableActivity.startHomeTableView(AdvertisingActivity.this, 0);
//            }
        } else {
            GuideActivity.startGuideActivity(AdvertisingActivity.this);
        }
        finish();
    }



    private static CountDownTimer mCountDownTimer;

    /**
     * 验证码倒计时
     */
    public static void countDown(final TextView textView) {
        mCountDownTimer = new CountDownTimer(mAdvertisingTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setEnabled(false);
                textView.setText(String.format("%ss", millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                textView.setEnabled(true);
            }
        };
        mCountDownTimer.start();
    }
}

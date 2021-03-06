package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.eventbus.HomeTableChangeEvent;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.ui.login.LoginSelectedActivity;
import com.whmnrc.flymall.utils.DataCleanManager;
import com.whmnrc.flymall.utils.HistoryGoodsBeanUtils;
import com.whmnrc.flymall.utils.SPUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.SHopCartEvent;
import com.whmnrc.flymall.views.ActionSheetDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/21.
 */

public class SettingActivity extends BaseActivity {
    @BindView(R.id.tv_cache)
    TextView mTvCache;

    @Override
    protected void initViewData() {
        EventBus.getDefault().register(this);
        setTitle("System settings");
        cleanUpCaching();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_setting;
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SettingActivity.class);
        context.startActivity(starter);
    }


    @OnClick({R.id.ll_tv_clear_cache, R.id.ll_about, R.id.tv_sign_out})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_tv_clear_cache:
                new ActionSheetDialog(this)
                        .builder()
                        .setTitle("Be sure to clear the cache")
                        .setCancelable(false)
                        .setCanceledOnTouchOutside(false)
                        .addSheetItem("confirm", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                mTvCache.post(new ClearCache());
                                HistoryGoodsBeanUtils.clearHistory();
                            }


                        }).show();

                break;
            case R.id.ll_about:
                AboutUsActivity.start(view.getContext());
                break;
            case R.id.tv_sign_out:
                finish();
                UserManager.clearUser();
                HistoryGoodsBeanUtils.clearHistory();
                SPUtils.put(SettingActivity.this, CommonConstant.Common.LAST_LOGIN_ID, "");
                LoginSelectedActivity.start(SettingActivity.this,true);
                EventBus.getDefault().post(new SHopCartEvent().setEventType(SHopCartEvent.ADD_SHOPPING_CART_SUCCESS));
                break;
            default:
                break;
        }
    }

    private void cleanUpCaching() {
        try {
            mTvCache.setText(DataCleanManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    ToastUtils.showToast("Clean up completed");
                    cleanUpCaching();
                    break;
                case 1:
                    ToastUtils.showToast("Cleaning failed");
                    break;
                default:
                    break;
            }

        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    class ClearCache implements Runnable {
        @Override
        public void run() {
            try {
                DataCleanManager.clearAllCache(SettingActivity.this);
                Thread.sleep(3000);
                if (DataCleanManager.getTotalCacheSize(SettingActivity.this).startsWith("0")) {
                    handler.sendEmptyMessage(0);
                }
            } catch (Exception e) {
                handler.sendEmptyMessage(1);
            }
        }
    }

    @Subscribe
    public void tabChangeEvent(HomeTableChangeEvent homeTableChangeEvent) {

    }
}

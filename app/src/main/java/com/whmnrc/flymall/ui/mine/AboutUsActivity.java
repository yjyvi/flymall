package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.ui.BaseActivity;

import butterknife.BindView;

/**
 *
 * @author yong hao zeng
 * @date 2017/12/9
 */

public class AboutUsActivity extends BaseActivity {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.version_name)
    TextView tvVersionName;


    @Override
    public int setLayoutId() {
        return R.layout.activity_about_us;
    }

    @Override
    public void initViewData() {
        setTitle("About Us");
        setAppVersionName(this);

    }

    public static void start(Context context) {
        Intent starter = new Intent(context, AboutUsActivity.class);
        context.startActivity(starter);
    }



    public void setAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            tvVersionName.setText(String.format("Flymall（%s）", versionName));
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
    }


}

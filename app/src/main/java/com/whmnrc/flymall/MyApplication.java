package com.whmnrc.flymall;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDexApplication;
import android.util.Log;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.whmnrc.flymall.views.MyClassicsHeader;

/**
 * @author yjyvi
 */
public class MyApplication extends MultiDexApplication {

    /**
     * 全局context
     */
    public static Context applicationContext;


    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                //全局设置主题颜色
                MyClassicsHeader classicsHeader = new MyClassicsHeader(context);
                return classicsHeader;
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                ClassicsFooter classicsFooter = new ClassicsFooter(context).setDrawableSize(20);
                classicsFooter.setVisibility(View.GONE);
                return classicsFooter;
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //-----------初始化applicationContext----------------
        applicationContext = getApplicationContext();





        //-----------内存泄漏检查工具初始化----------------
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);

        //-----------全局捕获异常日志----------------
//        if (!BuildConfig.DEBUG) {
//            CrashHandler crashHandler = CrashHandler.getInstance();
//            crashHandler.init(getApplicationContext());
//        }

        //友盟推送
        UMConfigure.init( this, "5b07c292f43e483b31000013", "", UMConfigure.DEVICE_TYPE_PHONE,"50194719f5daf7d21ae146523c86c2dc");
        UMConfigure.setLogEnabled(true);
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e("deviceToken",deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });

        //友盟登录
        UMShareAPI.get(this);
        PlatformConfig.setWeixin("wxdac79b5de8e5d7e2", "1558bf90a97d4bb6283835ad562340a7");
        PlatformConfig.setTwitter("wbwVZitQ6qheSbtPZwwk7rwKP", "cUt6epJiDYMXZdpJLZxRK9Uq6w8aKwqHQFf9Twsg6UtmFz2JlC");
    }

}

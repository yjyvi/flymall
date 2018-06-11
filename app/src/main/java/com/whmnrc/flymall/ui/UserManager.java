package com.whmnrc.flymall.ui;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.UserBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.login.LoginSelectedActivity;
import com.whmnrc.flymall.utils.SPUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.SHopCartEvent;
import com.whmnrc.flymall.utils.evntBusBean.UserInfoEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

/**
 * <pre>
 *     author : Think
 *     e-mail : 1007687534@qq.com
 *     time   : 2018/02/05
 *     desc   : 用户管理类
 *     version: 1.0
 * </pre>
 */
public class UserManager {

    private static UserBean.ResultdataBean sUser = null;

    public static UserBean.ResultdataBean getUser() {
        if (sUser == null) {
            String userJson = SPUtils.getString(MyApplication.applicationContext, "user_json");
            if (!TextUtils.isEmpty(userJson))
                sUser = JSON.parseObject(userJson, UserBean.ResultdataBean.class);
        }
        return sUser;
    }

    public static void refresh() {
        HashMap<String, String> paramters = new HashMap<>(1);
        paramters.put("UserInfo_ID", String.valueOf(getUser().getId()));
        OKHttpManager.get(MyApplication.applicationContext.getResources().getString(R.string.service_host_address).concat(MyApplication.applicationContext.getResources().getString(R.string.GetUserInfo)), paramters, new CommonCallBack<UserBean>() {
            @Override
            protected void onSuccess(UserBean data) {
                saveUser(data.getResultdata());
                EventBus.getDefault().post(new UserInfoEvent().setEventType(UserInfoEvent.UPDATE_USER_INFO));
                EventBus.getDefault().post(new SHopCartEvent().setEventType(SHopCartEvent.ADD_SHOPPING_CART_SUCCESS));
            }
        });
    }


    public static void clearUser() {
        SPUtils.put(MyApplication.applicationContext, "user_json", "");
        sUser = null;
    }

    public static void saveUser(UserBean.ResultdataBean user) {
        SPUtils.put(MyApplication.applicationContext, "user_json", JSON.toJSONString(user));
        sUser = user;
    }

    public static boolean isLogin() {
        return getUser() != null;
    }

    public static boolean getIsLogin(Context context) {
        if (TextUtils.isEmpty(SPUtils.getString(context, CommonConstant.Common.LAST_LOGIN_ID))) {
            ToastUtils.showToast("Please Login");
            LoginSelectedActivity.start(context);
            return false;
        }
        return true;
    }

}

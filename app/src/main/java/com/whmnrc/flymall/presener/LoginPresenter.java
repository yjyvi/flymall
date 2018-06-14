package com.whmnrc.flymall.presener;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.UserBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.SPUtils;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/29.
 */

public class LoginPresenter extends PresenterBase {

    private LoginListener mLoginListener;

    public LoginPresenter(LoginListener emailLoginListener) {
        this.mLoginListener = emailLoginListener;

    }

    public void emailLogin(String account, String pwd,String type,String headImg,String sex,String nickname) {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("Token", account);
        params.put("Password", pwd);
        params.put("Type", type);
        params.put("HeadImg", headImg);
        params.put("Sex", sex);
        params.put("NickName", nickname);
        params.put("DeviceID", SPUtils.getString(MyApplication.applicationContext, CommonConstant.Common.DEVICE_TOKEN));
        params.put("LoginDevice", "0");
        OKHttpManager.postString(getUrl(R.string.Login), JSON.toJSONString(params), new CommonCallBack<UserBean>() {
            @Override
            protected void onSuccess(UserBean data) {
                if (data.getType() == 1) {
                    mLoginListener.loginSuccess(data.getResultdata());
                }
                ToastUtils.showToast(data.getMessage());
            }
        });
    }


    public interface LoginListener {
        void loginSuccess(UserBean.ResultdataBean userBean);
    }

}

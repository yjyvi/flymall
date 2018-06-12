package com.whmnrc.flymall.presener;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.BaseBean;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;

import okhttp3.Call;

/**
 * @author yjyvi
 * @data 2018/5/30.
 * 上传头像
 */

public class UpdateImgFile extends PresenterBase {

    private UpdateHeadImgListener mUpdateHeadImgListener;

    public UpdateImgFile(UpdateHeadImgListener updateUpdateHeadImgListener) {
        this.mUpdateHeadImgListener = updateUpdateHeadImgListener;
    }

    public void updateHeadImg(File imgData) {

        if (OKHttpManager.getIsConnected()) {
            return;
        }

        OkHttpUtils.post()
                .addFile("photo", imgData.getName(), imgData)
                .addParams("userId", UserManager.getUser().getId())
                .addParams("userName", TextUtils.isEmpty(UserManager.getUser().getNick()) ? "img" : UserManager.getUser().getNick())
                .url(getUrl(R.string.UploadFile))
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                BaseBean<String> netBaseBean = JSON.parseObject(response, BaseBean.class);
                if (netBaseBean.getType() == 1) {

                    mUpdateHeadImgListener.loadSuccess(netBaseBean.getResultdata());
                } else {
                    ToastUtils.showToast(netBaseBean.getMessage());
                }
            }
        });


    }


    public interface UpdateHeadImgListener {
        void loadSuccess(String resultImgUrl);
    }
}

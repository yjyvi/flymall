package com.whmnrc.flymall.presener;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.BaseBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.ToastUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.Call;

/**
 * @author yjyvi
 * @data 2018/5/30.
 * 上传头像
 */

public class UpdateHeadImgPresenter extends PresenterBase {

    private UpdateHeadImgListener mUpdateHeadImgListener;

    public UpdateHeadImgPresenter(UpdateHeadImgListener updateUpdateHeadImgListener) {
        this.mUpdateHeadImgListener = updateUpdateHeadImgListener;
    }

    public void updateHeadImg(String imgData,String username) {

        Map<String, String> params = new HashMap<>(3);
        params.put("userId  ", UserManager.getUser().getId());
        params.put("userName", username);
        params.put("photo", imgData);

        OKHttpManager.post(getUrl(R.string.SetHeadPhoto), new TreeMap<String, String>(), new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {

            }
        });
//        OKHttpManager.uploadFile(params, new StringCallback() {
//            @Override
//            public void onError(Call call, Exception e, int id) {
//
//            }
//
//            @Override
//            public void onResponse(String response, int id) {
//                BaseBean<String> netBaseBean = JSON.parseObject(response, BaseBean.class);
//                if (netBaseBean.getType() == 1) {
//                    mUpdateHeadImgListener.loadSuccess(netBaseBean.getResultdata());
//                } else {
//                    ToastUtils.showToast(netBaseBean.getMessage());
//                }
//            }
//        });


    }


    public interface UpdateHeadImgListener {
        void loadSuccess(String resultImgUrl);
    }
}

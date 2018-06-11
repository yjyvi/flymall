package com.whmnrc.flymall.presener;

import android.text.TextUtils;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.BaseBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/30.
 * 上传头像
 */

public class UpdateUserInfoPresenter extends PresenterBase {

    private UpdateUserInfoListener mUpdateUserInfoListener;

    public UpdateUserInfoPresenter(UpdateUserInfoListener updateUserInfoListener) {
        this.mUpdateUserInfoListener = updateUserInfoListener;
    }

    public void updateUserInfo(String headImgUrl, String nickname, String sex) {
        HashMap<String, String> paramters = new HashMap<>(4);
        if (!TextUtils.isEmpty(headImgUrl)) {
            paramters.put("HeadImg", headImgUrl);
        }
        paramters.put("NickName", nickname);
        paramters.put("Sex", sex);
        paramters.put("UserInfo_ID", UserManager.getUser().getId());
        OKHttpManager.get(getUrl(R.string.UpdateUser), paramters, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mUpdateUserInfoListener.uploadUserInfoSuccess(data.getMessage());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface UpdateUserInfoListener {
        void uploadUserInfoSuccess(String resultMsg);
    }
}

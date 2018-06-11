package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.OneBrandsBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.views.LoadingDialog;

import java.util.HashMap;
import java.util.List;

/**
 * @author yjyvi
 * @date 2018/2/3
 * 获取分类
 */

public class OneBrandListPresenter extends PresenterBase {
    private LoadingDialog mloadingDialog;
    private OneBrandListListener mOneBrandListListener;

    public OneBrandListPresenter(OneBrandListListener oneBrandListListener, LoadingDialog loadingDialog) {
        this.mOneBrandListListener = oneBrandListListener;
        this.mloadingDialog = loadingDialog;
    }


    public void getOneBrans() {
        OKHttpManager.get(getUrl(R.string.GetSysCategory), new HashMap<String, String>(), new CommonCallBack<OneBrandsBean>() {
            @Override
            protected void onSuccess(OneBrandsBean data) {
                if (data.getType() == 1) {
                    mOneBrandListListener.getOneBrandListDataSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
                mloadingDialog.dismiss();
            }
        });
    }


    public interface OneBrandListListener {
        void getOneBrandListDataSuccess(List<OneBrandsBean.ResultdataBean> dataBean);

    }

}

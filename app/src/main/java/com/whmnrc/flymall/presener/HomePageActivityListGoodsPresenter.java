package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.ActivityGoodsListBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.views.LoadingDialog;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/29.
 */

public class HomePageActivityListGoodsPresenter extends PresenterBase {

    private HomeActivityGoodsListListener mHomeActivityGoodsListListener;

    public HomePageActivityListGoodsPresenter(HomeActivityGoodsListListener homeActivityGoodsListListener) {
        this.mHomeActivityGoodsListListener = homeActivityGoodsListListener;

    }

    public void getHomePageActivityGoodsList(String topicId, final LoadingDialog loadingDialog) {

        HashMap<String, String> params = new HashMap<>(1);
        params.put("topicId", topicId);
        OKHttpManager.get(getUrl(R.string.GetHomeActionProducts), params, new CommonCallBack<ActivityGoodsListBean>() {
            @Override
            protected void onSuccess(ActivityGoodsListBean data) {
                if (data.getType() == 1) {
                    mHomeActivityGoodsListListener.loadActivityGoodsSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }

                if (loadingDialog != null) {
                    loadingDialog.dismiss();
                }

            }

            @Override
            protected void onError(String msg) {
                super.onError(msg);
                if (loadingDialog != null) {
                    loadingDialog.dismiss();
                }
            }
        });


    }


    public interface HomeActivityGoodsListListener {
        void loadActivityGoodsSuccess(ActivityGoodsListBean.ResultdataBean resultdataBean);
    }

}

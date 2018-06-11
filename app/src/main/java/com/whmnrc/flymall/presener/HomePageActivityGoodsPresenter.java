package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.HomeActivityGoodsBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/29.
 */

public class HomePageActivityGoodsPresenter extends PresenterBase {

    private HomeActivityGoodsListener mHomeActivityGoodsListener;

    public HomePageActivityGoodsPresenter(HomeActivityGoodsListener emailLoginListener) {
        this.mHomeActivityGoodsListener = emailLoginListener;

    }

    public void getHomePageActivityGoods() {
        HashMap<String, String> params = new HashMap<>(1);
        OKHttpManager.get(getUrl(R.string.HomeActions), params, new CommonCallBack<HomeActivityGoodsBean>() {
            @Override
            protected void onSuccess(HomeActivityGoodsBean data) {
                if (data.getType() == 1) {
                    mHomeActivityGoodsListener.loadActivityGoodsSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface HomeActivityGoodsListener {
        void loadActivityGoodsSuccess(List<HomeActivityGoodsBean.ResultdataBean> resultdataBean);
    }

}

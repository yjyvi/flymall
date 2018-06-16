package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.HomeSaleGoodsBean;
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

public class HomePageSaleGoodsPresenter extends PresenterBase {

    private HomeSaleGoodsListener mHomeSaleGoodsListener;

    public HomePageSaleGoodsPresenter(HomeSaleGoodsListener homeSaleGoodsListener) {
        this.mHomeSaleGoodsListener = homeSaleGoodsListener;
    }

    public void getHomePageSaleGoods(int page,int rows) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("Page", String.valueOf(page));
        params.put("Rows", String.valueOf(rows));
        OKHttpManager.get(getUrl(R.string.GetCategoryProducts), params, new CommonCallBack<HomeSaleGoodsBean>() {
            @Override
            protected void onSuccess(HomeSaleGoodsBean data) {
                if (data.getType() == 1) {
                    mHomeSaleGoodsListener.loadHomeSaleGoodsSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                    mHomeSaleGoodsListener.laodHomeSaleField();
                }
            }

            @Override
            protected void onError(String msg) {
                super.onError(msg);
                mHomeSaleGoodsListener.laodHomeSaleField();
            }
        });
    }


    public interface HomeSaleGoodsListener {
        void loadHomeSaleGoodsSuccess(List<HomeSaleGoodsBean.ResultdataBean> resultdataBean);
        void laodHomeSaleField();
    }

}

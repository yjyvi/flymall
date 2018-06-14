package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.GoodsSpecificationsBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class GoodsSpecificationsPresenter extends PresenterBase {

    private GoodsSpecificationsListener mGoodsSpecificationsListener;

    public GoodsSpecificationsPresenter(GoodsSpecificationsListener goodsSpecificationsListener) {
        this.mGoodsSpecificationsListener = goodsSpecificationsListener;
    }


    public void getSpecificationsList(String mGoodsId, String mColorSkuId, String mSizeSkuId, String versionSkuId) {

        HashMap<String, String> params = new HashMap<>(1);
        params.put("skuGroup", mGoodsId + "_" + mColorSkuId + "_" + mSizeSkuId + "_" + versionSkuId);

        OKHttpManager.get(getUrl(R.string.GetSpecifications), params, new CommonCallBack<GoodsSpecificationsBean>() {
            @Override
            protected void onSuccess(GoodsSpecificationsBean data) {
                if (data.getType() == 1) {
                    mGoodsSpecificationsListener.getGoodsSpecificationsSuccess(data.getResultdata());
                }
            }
        });
    }


    public interface GoodsSpecificationsListener {
        void getGoodsSpecificationsSuccess(GoodsSpecificationsBean.ResultdataBean resultdataBean);
    }

}

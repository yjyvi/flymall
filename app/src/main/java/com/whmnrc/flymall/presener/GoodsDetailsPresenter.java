package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.GoodsDetailsBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class GoodsDetailsPresenter extends PresenterBase {

    private GoodsDetailsListener mGoodsDetailsListener;

    public GoodsDetailsPresenter(GoodsDetailsListener goodsDetailsListener) {
        this.mGoodsDetailsListener = goodsDetailsListener;
    }


    public void getGoodsDetial(String goodsId) {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("productId", goodsId);
        params.put("UserInfo_ID", UserManager.getUser() == null ? "" : UserManager.getUser().getId());

        OKHttpManager.get(getUrl(R.string.getProductDetails), params, new CommonCallBack<GoodsDetailsBean>() {
            @Override
            protected void onSuccess(GoodsDetailsBean data) {
                if (data.getType() == 1) {
                    mGoodsDetailsListener.getGoodsDetailsSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface GoodsDetailsListener {
        void getGoodsDetailsSuccess(GoodsDetailsBean.ResultdataBean goodsDetailsBean);
    }

}

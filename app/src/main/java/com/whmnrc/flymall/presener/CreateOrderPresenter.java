package com.whmnrc.flymall.presener;


import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.OrderDeitalsBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/23.
 */

public class CreateOrderPresenter extends PresenterBase {
    private CreateOrderListener mCreateOrderListener;

    public CreateOrderPresenter(CreateOrderListener createOrderListener) {
        this.mCreateOrderListener = createOrderListener;
    }

    public void shopCartCreateOrder(String productAttrIds, String addressId, String couponId, String remark) {
        HashMap<String, String> paramters = new HashMap<>(6);
        paramters.put("userId", UserManager.getUser().getId());
        paramters.put("cartItemIds", productAttrIds);
        paramters.put("recieveAddressId", addressId);
        paramters.put("couponIds", couponId);
        paramters.put("integral", "0");
        paramters.put("platformType", "2");
        paramters.put("payRemark", remark);
        OKHttpManager.postString(getUrl(R.string.CreateOrderFromShopCart), JSON.toJSONString(paramters), new CommonCallBack<OrderDeitalsBean>() {
            @Override
            protected void onSuccess(OrderDeitalsBean data) {
                if (data.getType() == 1) {
                    mCreateOrderListener.createMutOrderSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });

    }

    public void goodsDetailsCreateOrder(String skuIds, String addressId, String couponId, String goodCount, String productName, String remark) {
        HashMap<String, String> paramters = new HashMap<>(8);
        paramters.put("userId", UserManager.getUser().getId());
        paramters.put("skuIds", skuIds);
        paramters.put("counts", goodCount);
        paramters.put("recieveAddressId", addressId);
        paramters.put("platformType", "2");
        paramters.put("productName", productName);
        paramters.put("couponIds", couponId);
        paramters.put("payRemark", remark);
        OKHttpManager.postString(getUrl(R.string.CreateOrder), JSON.toJSONString(paramters), new CommonCallBack<OrderDeitalsBean>() {
            @Override
            protected void onSuccess(OrderDeitalsBean data) {
                if (data.getType() == 1) {
                    mCreateOrderListener.createOneOrderSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });

    }

    public interface CreateOrderListener {
        void createOneOrderSuccess(OrderDeitalsBean.ResultdataBean orderId);
        void createMutOrderSuccess(OrderDeitalsBean.ResultdataBean orderId);
    }


}

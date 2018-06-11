package com.whmnrc.flymall.presener;


import com.alibaba.fastjson.JSON;
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
 * @data 2018/5/23.
 */

public class CreateOrderPresenter extends PresenterBase {
    private CreateOrderListener mCreateOrderListener;

    public CreateOrderPresenter(CreateOrderListener createOrderListener) {
        this.mCreateOrderListener = createOrderListener;
    }

    public void createOrder(String productAttrIds, String addressId, String couponId,String remark) {
        HashMap<String, String> paramters = new HashMap<>(1);
        paramters.put("ProductAttrIds", productAttrIds);
        paramters.put("UserInfo_ID", UserManager.getUser().getId());
        paramters.put("Address_ID", addressId);
        paramters.put("Coupon_ID", couponId);
        paramters.put("Order_Remark", remark);
        OKHttpManager.postString(getUrl(R.string.AddOrder), JSON.toJSONString(paramters), new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mCreateOrderListener.createOrderSuccess((String) data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });

    }

    public interface CreateOrderListener {
        void createOrderSuccess(String orderId);
    }


}

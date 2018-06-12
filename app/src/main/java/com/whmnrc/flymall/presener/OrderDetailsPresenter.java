package com.whmnrc.flymall.presener;


import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.OrderDeitalsBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/23.
 */

public class OrderDetailsPresenter extends PresenterBase {
    private OrderDetailsListener mOrderDetailsListener;

    public OrderDetailsPresenter(OrderDetailsListener orderDetailsListener) {
        this.mOrderDetailsListener = orderDetailsListener;
    }

    public void getOrderDetails(String orderId) {
        HashMap<String, String> paramters = new HashMap<>(3);
        paramters.put("orderId", orderId);
//        paramters.put("Page", "1");
//        paramters.put("Rows", "1");
        OKHttpManager.get(getUrl(R.string.GetSomeOneOrder), paramters, new CommonCallBack<OrderDeitalsBean>() {
            @Override
            protected void onSuccess(OrderDeitalsBean data) {
                if (data.getType() == 1) {
                    mOrderDetailsListener.getOrderDetailsSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });


    }

    public interface OrderDetailsListener {
        void getOrderDetailsSuccess(OrderDeitalsBean.ResultdataBean resultdataBeans);
    }


}

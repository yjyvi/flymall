package com.whmnrc.flymall.presener;

import android.text.TextUtils;

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
 * @data 2018/6/4.
 */

public class PayPPPresenter extends PresenterBase {

    private PayPPListener mPayPPListener;

    public PayPPPresenter(PayPPListener payPPListener) {
        this.mPayPPListener = payPPListener;

    }

    public void payPalNotify(String orderId, int type, String payPalResultId) {
        HashMap<String, String> paramters = new HashMap<>(4);
        paramters.put("PayType", String.valueOf(type));
        paramters.put("Token", payPalResultId);
        paramters.put("OrderId", orderId);
        paramters.put("UserName", UserManager.getUser().getUserName());
        OKHttpManager.postString(getUrl(R.string.PayPalNotify), JSON.toJSONString(paramters), new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    String resultdata = (String) data.getResultdata();
                    mPayPPListener.getPayPalSuccess(TextUtils.equals(resultdata, "0"));
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface PayPPListener {
        void getPayPalSuccess(boolean token);
    }

}

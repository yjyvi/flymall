package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.BaseBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.TreeMap;

/**
 * @author yjyvi
 * @data 2018/6/14.
 */

public class CheckPaymentStatusForTTPresenter extends PresenterBase {

    private CheckPaymentStatusForTTListener mCheckPaymentStatusForTTListener;

    public CheckPaymentStatusForTTPresenter(CheckPaymentStatusForTTListener checkPaymentStatusForTTListener) {
        this.mCheckPaymentStatusForTTListener = checkPaymentStatusForTTListener;

    }

    public void getIsPayTT(final String orderId) {
        TreeMap<String, String> paramters = new TreeMap<>();
        paramters.put("orderId", orderId);
        paramters.put("userId", UserManager.getUser().getId());
        OKHttpManager.get(getUrl(R.string.CheckPaymentStatusForTT), paramters, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mCheckPaymentStatusForTTListener.getIsPayTTSuccess(orderId);
                } else {
                    ToastUtils.showToast("You have used TT to pay for this order without recurring payment");
                }
            }
        });
    }


    public interface CheckPaymentStatusForTTListener {
        void getIsPayTTSuccess(String orderId);
    }
}

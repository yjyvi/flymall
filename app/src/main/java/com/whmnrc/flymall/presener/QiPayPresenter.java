package com.whmnrc.flymall.presener;

import android.text.TextUtils;

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
 * @data 2018/6/29.
 */

public class QiPayPresenter extends PresenterBase {

    private QiPayListener mQiPayListener;

    public QiPayPresenter(QiPayListener qiPayListener) {
        this.mQiPayListener = qiPayListener;

    }

    public void getQiPay(String cardNumber, String year, String month, String cartCode, String email, String orderId, String ip) {
        TreeMap<String, String> params = new TreeMap<>();
        params.put("CreditCardNumber", cardNumber);
        params.put("ExpDateYear", year);
        params.put("ExpDateMonth", month);
        params.put("CardvNumber", cartCode);
        params.put("Email", email);
        params.put("OrderId", orderId);
        if (!TextUtils.isEmpty(ip)) {
            params.put("Ip", ip.substring(1, ip.length() - 1));
        }else {
            params.put("Ip", "59.172.109.120");
        }
        params.put("UserName", UserManager.getUser() == null ? "" : UserManager.getUser().getUserName());
        OKHttpManager.post(getUrl(R.string.YiXinPayment), params, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mQiPayListener.qiPaySuccess();
                } else {
                    mQiPayListener.qiPayField();
                }
                ToastUtils.showToast(data.getMessage());
            }
        });
    }


    public interface QiPayListener {
        void qiPaySuccess();

        void qiPayField();
    }
}

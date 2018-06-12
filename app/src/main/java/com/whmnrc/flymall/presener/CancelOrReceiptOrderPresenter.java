package com.whmnrc.flymall.presener;

import com.alibaba.fastjson.JSON;
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
 * @data 2018/6/12.
 */

public class CancelOrReceiptOrderPresenter extends PresenterBase {

    private OpertionOrderListener mOpertionOrderListener;

    public CancelOrReceiptOrderPresenter(OpertionOrderListener opertionOrderListener) {
        this.mOpertionOrderListener = opertionOrderListener;

    }

    public void cancelOrder(String orderId) {
        TreeMap<String, String> paramters = new TreeMap<>();
        paramters.put("orderId", orderId);
        paramters.put("userName", UserManager.getUser().getId());
        OKHttpManager.get(getUrl(R.string.MemberCloseOrder), paramters, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mOpertionOrderListener.cancelSuccess();
                }
                ToastUtils.showToast(data.getMessage());
            }
        });
    }

    public void receiptOrder(String orderId) {
        TreeMap<String, String> paramters = new TreeMap<>();
        paramters.put("orderId", orderId);
        paramters.put("userName", UserManager.getUser().getId());
        OKHttpManager.postString(getUrl(R.string.ConfirmOrder), JSON.toJSONString(paramters), new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mOpertionOrderListener.receiptSuccess();
                }

                ToastUtils.showToast(data.getMessage());
            }
        });
    }


    public interface OpertionOrderListener {
        void cancelSuccess();

        void receiptSuccess();
    }


}

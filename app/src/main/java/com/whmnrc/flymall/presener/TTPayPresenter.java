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
 * @data 2018/6/14.
 */

public class TTPayPresenter extends PresenterBase {

    private TTPayOrderListener mTTPayOrderListener;

    public TTPayPresenter(TTPayOrderListener ttPayOrderListener) {
        this.mTTPayOrderListener = ttPayOrderListener;

    }

    public void ttPayOrder(String orderId, int type) {
        TreeMap<String, String> params = new TreeMap<>();
        params.put("UserId", UserManager.getUser().getId());
        params.put("OrderId", orderId);
        params.put("TypeId", String.valueOf(type));
        OKHttpManager.postString(getUrl(R.string.TTPay), JSON.toJSONString(params), new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    int resultdata = (int) data.getResultdata();
                    mTTPayOrderListener.payOrderSuccess(resultdata == 0);
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }

    public interface TTPayOrderListener {
        void payOrderSuccess(boolean isSuccess);
    }
}

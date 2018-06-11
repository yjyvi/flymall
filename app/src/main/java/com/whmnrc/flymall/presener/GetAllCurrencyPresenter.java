package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.AllCurrencyBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class GetAllCurrencyPresenter extends PresenterBase {

    private GetAllCurrencyListener mGetAllCurrencyListener;

    public GetAllCurrencyPresenter(GetAllCurrencyListener getAllCurrencyListener) {
        this.mGetAllCurrencyListener = getAllCurrencyListener;
    }

    public void getAllCurrency() {
        HashMap<String, String> paramters = new HashMap<>(1);

        OKHttpManager.get(getUrl(R.string.GetAllCurrency), paramters, new CommonCallBack<AllCurrencyBean>() {
            @Override
            protected void onSuccess(AllCurrencyBean data) {
                if (data.getType() == 1) {
                    mGetAllCurrencyListener.loadSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface GetAllCurrencyListener {
        void loadSuccess(List<AllCurrencyBean.ResultdataBean> resultdataBean);
    }
}

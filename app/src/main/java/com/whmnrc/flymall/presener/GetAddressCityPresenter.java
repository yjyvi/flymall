package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.SelectAddressBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/4.
 */

public class GetAddressCityPresenter extends PresenterBase {

    private SelectAddressListener mSelectAddressListener;

    public GetAddressCityPresenter(SelectAddressListener selectAddressListener) {
        this.mSelectAddressListener = selectAddressListener;
    }

    public void getTheAddress(String parentId, final boolean isCountry) {
        HashMap<String, String> paramters = new HashMap<>(1);
        paramters.put("ParentId", parentId);
        OKHttpManager.get(getUrl(R.string.GetTheAddress), paramters, new CommonCallBack<SelectAddressBean>() {
            @Override
            protected void onSuccess(SelectAddressBean data) {
                if (data.getType() == 1) {
                    mSelectAddressListener.getTheAddressSuccess(data.getResultdata(), isCountry);
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface SelectAddressListener {
        void getTheAddressSuccess(List<SelectAddressBean.ResultdataBean> resultdataBeans, boolean isCountry);
    }

}

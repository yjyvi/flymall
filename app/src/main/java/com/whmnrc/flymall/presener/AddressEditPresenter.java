package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.AddressBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class AddressEditPresenter extends PresenterBase {

    private AddressEditListener mAddressEditListener;

    public AddressEditPresenter(AddressEditListener addressEditListener) {
        this.mAddressEditListener = addressEditListener;

    }

    public void delAddress(String addressId) {
        HashMap<String, String> paramters = new HashMap<>(1);
        paramters.put("Address_ID", addressId);
        OKHttpManager.get(getUrl(R.string.DelAddress), paramters, new CommonCallBack<AddressBean>() {
            @Override
            protected void onSuccess(AddressBean data) {
                if (data.getType() == 1) {
                    mAddressEditListener.delSuccess();
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public void setDefaultAddress(String addressId) {
        HashMap<String, String> paramters = new HashMap<>();
        paramters.put("UserInfoID", UserManager.getUser().getId());
        paramters.put("Address_ID", addressId);
        OKHttpManager.get(getUrl(R.string.SetDetaultAddress), paramters, new CommonCallBack<AddressBean>() {
            @Override
            protected void onSuccess(AddressBean data) {
                if (data.getType() == 1) {
                    mAddressEditListener.setDefaultSuccess();
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface AddressEditListener {

        void delSuccess();

        void setDefaultSuccess();
    }
}

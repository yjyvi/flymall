package com.whmnrc.flymall.presener;

import com.alibaba.fastjson.JSON;
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

public class AddressAddOrUpdatePresenter extends PresenterBase {

    private AddressAddOrUpdateListener mAddressAddOrUpdateListener;

    public AddressAddOrUpdatePresenter(AddressAddOrUpdateListener addressAddOrUpdateListener) {
        this.mAddressAddOrUpdateListener = addressAddOrUpdateListener;
    }


    public void addOrUpdateAddress(final boolean isAdd, String tel, String firstName, String lastName, String detail, String city, String provice, String region, String addressDetail2, String addressZipCode, int defaultAddress) {
        HashMap<String, String> paramters = new HashMap<>();
        paramters.put("UserId", UserManager.getUser().getId());
        paramters.put("Phone", tel);
        paramters.put("ShipTo", firstName);
        paramters.put("Address_LastName", lastName);
        paramters.put("Address", detail);
        paramters.put("Address_City", city);
        paramters.put("Address_Country", region);
        paramters.put("Address_Provice", provice);
        paramters.put("Address_Address2", addressDetail2);
        paramters.put("Address_ZipCode", addressZipCode);
        paramters.put("Address_IsDefault", String.valueOf(defaultAddress));
        String url= getUrl(R.string.AddAddress);
        OKHttpManager.postString(url, JSON.toJSONString(paramters), new CommonCallBack<AddressBean>() {
            @Override
            protected void onSuccess(AddressBean data) {
                if (data.getType() == 1) {
                    if (isAdd) {
                        mAddressAddOrUpdateListener.addSuccess();
                    } else {
                        mAddressAddOrUpdateListener.upadteSuccess();
                    }
                }

                ToastUtils.showToast(data.getMessage());

            }
        });
    }


    public interface AddressAddOrUpdateListener {
        void addSuccess();

        void upadteSuccess();
    }
}

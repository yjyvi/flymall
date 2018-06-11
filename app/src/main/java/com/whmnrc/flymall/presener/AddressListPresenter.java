package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.AddressBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class AddressListPresenter extends PresenterBase {

    private AddressListListener mAddressListListener;

    public AddressListPresenter(AddressListListener addressListListener) {
        this.mAddressListListener = addressListListener;

    }


    public void getAddressList() {
        HashMap<String, String> paramters = new HashMap<>();
        paramters.put("UserInfoID", UserManager.getUser().getId());
        OKHttpManager.get(getUrl(R.string.GetAllAddress), paramters, new CommonCallBack<AddressBean>() {
            @Override
            protected void onSuccess(AddressBean data) {
                if (data.getType() == 1) {
                    mAddressListListener.getListSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface AddressListListener {
        void getListSuccess(List<AddressBean.ResultdataBean> resultdataBeans);
    }
}

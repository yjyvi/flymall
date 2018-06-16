package com.whmnrc.flymall.presener;

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
 * @data 2018/5/30.
 */

public class UpdateDefaultCurrencyPresenter extends PresenterBase {

    private UpdateDefaultCurrencyListener mUpdateDefaultCurrencyListener;

    public UpdateDefaultCurrencyPresenter(UpdateDefaultCurrencyListener updateDefaultCurrencyListener) {
        this.mUpdateDefaultCurrencyListener = updateDefaultCurrencyListener;
    }

    public void updateDefaultCurrency(String currencyID) {
        if (UserManager.getUser() == null) {
            return;
        }
        HashMap<String, String> paramters = new HashMap<>(2);
        paramters.put("Currency_ID", currencyID);
        paramters.put("UserInfo_ID", UserManager.getUser().getId());
        OKHttpManager.get(getUrl(R.string.UpdateDefaultCurrency), paramters, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mUpdateDefaultCurrencyListener.updateSuccess(data.getMessage());
                }
                ToastUtils.showToast(data.getMessage());
            }
        });
    }


    public interface UpdateDefaultCurrencyListener {
        void updateSuccess(String msg);
    }
}

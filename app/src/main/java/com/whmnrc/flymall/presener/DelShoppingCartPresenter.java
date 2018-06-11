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
 * @data 2018/6/5.
 */

public class DelShoppingCartPresenter extends PresenterBase {

    private DelShoppingCartListListener mDelShoppingCartListListener;

    public DelShoppingCartPresenter(DelShoppingCartListListener delShoppingCartListListener) {
        this.mDelShoppingCartListListener = delShoppingCartListListener;

    }

    public void delShoppingCartList(String skuId) {
        HashMap<String, String> paramters = new HashMap<>(1);
        paramters.put("skuId", skuId);
        paramters.put("userId", UserManager.getUser().getId());
        OKHttpManager.get(getUrl(R.string.RemoveFromCart), paramters, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mDelShoppingCartListListener.delCartSuccess();
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }

    public interface DelShoppingCartListListener {
        void delCartSuccess();
    }

}

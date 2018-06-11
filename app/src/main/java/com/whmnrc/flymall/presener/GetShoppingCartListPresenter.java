package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.ShoppingCartListBean;
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

public class GetShoppingCartListPresenter extends PresenterBase {

    private GetShoppingCartListListener mGetShoppingCartListListener;

    public GetShoppingCartListPresenter(GetShoppingCartListListener getShoppingCartListListener) {
        this.mGetShoppingCartListListener = getShoppingCartListListener;

    }

    public void getShoppingCartList(int page) {
        HashMap<String, String> paramters = new HashMap<>(3);
        paramters.put("Page", String.valueOf(page));
        paramters.put("Rows", "10");
        paramters.put("userId", String.valueOf(UserManager.getUser().getId()));
        OKHttpManager.get(getUrl(R.string.GetCartList), paramters, new CommonCallBack<ShoppingCartListBean>() {
            @Override
            protected void onSuccess(ShoppingCartListBean data) {
                if (data.getType() == 1) {

                    mGetShoppingCartListListener.getListSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }

            }
        });
    }

    public interface GetShoppingCartListListener {
        void getListSuccess(ShoppingCartListBean.ResultdataBean resultdataBeans);
    }

}

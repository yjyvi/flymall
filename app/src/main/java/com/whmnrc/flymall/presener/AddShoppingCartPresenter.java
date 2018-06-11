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

public class AddShoppingCartPresenter extends PresenterBase {

    private AddShoppingCartListListener mAddShoppingCartListListener;

    public AddShoppingCartPresenter(AddShoppingCartListListener addShoppingCartListListener) {
        this.mAddShoppingCartListListener = addShoppingCartListListener;

    }

    public void addShoppingCartList( String goodsPriceId, String goodsNum) {
        HashMap<String, String> paramters = new HashMap<>(3);
        paramters.put("skuId", goodsPriceId);
        paramters.put("count", goodsNum);
        paramters.put("userId", UserManager.getUser().getId());
        OKHttpManager.get(getUrl(R.string.AddProductToCart), paramters, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mAddShoppingCartListListener.addCartSuccess();
                }
                ToastUtils.showToast(data.getMessage());
            }
        });
    }

    public interface AddShoppingCartListListener {
        void addCartSuccess();
    }

}

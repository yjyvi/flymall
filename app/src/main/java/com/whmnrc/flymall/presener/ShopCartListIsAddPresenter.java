package com.whmnrc.flymall.presener;

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
 * @data 2018/6/12.
 */

public class ShopCartListIsAddPresenter extends PresenterBase {

    private AddCartItemNumListener mAddCartItemNumListener;

    public ShopCartListIsAddPresenter(AddCartItemNumListener addCartItemNumListener) {
        this.mAddCartItemNumListener = addCartItemNumListener;
    }

    public void addCartItemNum(String skuId, String count) {
        TreeMap<String, String> paramters = new TreeMap<>();
        paramters.put("userId", UserManager.getUser().getId());
        paramters.put("skuId", skuId);
        paramters.put("count", count);
        OKHttpManager.get(getUrl(R.string.UpdateCartItem), paramters, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mAddCartItemNumListener.addSuceess();
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }

    public interface AddCartItemNumListener {
        void addSuceess();
    }
}

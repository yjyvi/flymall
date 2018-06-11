package com.whmnrc.flymall.presener;

import com.alibaba.fastjson.JSON;
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

    public void addShoppingCartList(String goodsId, String goodsPriceId, String goodsNum) {
        HashMap<String, String> paramters = new HashMap<>(3);
        paramters.put("Goods_ID", goodsId);
        paramters.put("GoodsPrice_ID", goodsPriceId);
        paramters.put("BuyCar_Num", goodsNum);
        paramters.put("UserInfo_ID", UserManager.getUser().getId());
        OKHttpManager.postString(getUrl(R.string.AddProductToCart), JSON.toJSONString(paramters), new CommonCallBack<BaseBean>() {
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

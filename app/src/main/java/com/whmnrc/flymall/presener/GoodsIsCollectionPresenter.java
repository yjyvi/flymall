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
 * @data 2018/6/11.
 */

public class GoodsIsCollectionPresenter extends PresenterBase {

    private GoodsIsCollectionListener mGoodsIsCollectionListener;

    public GoodsIsCollectionPresenter(GoodsIsCollectionListener goodsIsCollectionListener) {
        this.mGoodsIsCollectionListener = goodsIsCollectionListener;
    }

    public void getIsCollection(String productId) {
        TreeMap<String, String> paramters = new TreeMap<>();
        paramters.put("productId", productId);
        paramters.put("userId", UserManager.getUser() == null ? "" : UserManager.getUser().getId());
        OKHttpManager.get(getUrl(R.string.IsFavorite), paramters, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mGoodsIsCollectionListener.isCollection((Integer) data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }

    public interface GoodsIsCollectionListener {
        void isCollection(int isCollection);
    }
}

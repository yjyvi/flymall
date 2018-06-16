package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.BaseBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;

import java.util.TreeMap;

/**
 * @author yjyvi
 * @data 2018/6/14.
 */

public class MultipleDelCollectionPresenter extends PresenterBase {

    private  MultipleDelCollectionListener mMultipleDelCollectionListener;

    public MultipleDelCollectionPresenter(MultipleDelCollectionListener multipleDelCollectionListener) {
        this.mMultipleDelCollectionListener = multipleDelCollectionListener;
    }

    public void multipleDelCollection(String productIds) {
        TreeMap<String, String> paramters = new TreeMap<>();
        paramters.put("productIds", productIds);
        paramters.put("userId", UserManager.getUser().getId());
        OKHttpManager.get(getUrl(R.string.DeleteFavoriteMulty), paramters, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                mMultipleDelCollectionListener.delMultipleCollectionSuccess();
            }
        });
    }

    public interface MultipleDelCollectionListener {
        void delMultipleCollectionSuccess();
    }
}

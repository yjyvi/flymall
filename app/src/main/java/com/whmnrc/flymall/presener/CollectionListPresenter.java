package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.CollectionListBean;
import com.whmnrc.flymall.beans.GoodsListBean;
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

public class CollectionListPresenter extends PresenterBase {

    private CollectionListListener mCollectionListListener;

    public CollectionListPresenter(CollectionListListener collectionListListener) {

        this.mCollectionListListener = collectionListListener;
    }


    public void getCollectionList(int type, int page) {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("UserInfo_ID", UserManager.getUser().getId());
        params.put("SaveType", String.valueOf(type));
        params.put("PageIndex", String.valueOf(page));

        if (type == 1) {
            OKHttpManager.get(getUrl(R.string.ListCollectionAndFootMark), params, new CommonCallBack<CollectionListBean>() {
                @Override
                protected void onSuccess(CollectionListBean data) {
                    if (data.getType() == 1) {
                        mCollectionListListener.getCollectionListSuccess(data.getResultdata());
                    } else {
                        ToastUtils.showToast(data.getMessage());
                    }
                }
            });

        } else {
            OKHttpManager.get(getUrl(R.string.ListCollectionAndFootMark), params, new CommonCallBack<GoodsListBean>() {
                @Override
                protected void onSuccess(GoodsListBean data) {
                    if (data.getType() == 1) {
                        mCollectionListListener.getHistoryListSuccess(data.getResultdata());
                    } else {
                        ToastUtils.showToast(data.getMessage());
                    }
                }
            });
        }
    }


    public interface CollectionListListener {
        void getCollectionListSuccess(List<CollectionListBean.ResultdataBean> resultdataBeanList);

        void getHistoryListSuccess(List<GoodsListBean.ResultdataBean> resultdataBeanList);
    }

}

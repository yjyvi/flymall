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
 * @data 2018/6/13.
 */

public class GetCommentStatusPresenter extends PresenterBase {

    private GetCommentStatusListener mGetCommentStatusListener;

    public GetCommentStatusPresenter(GetCommentStatusListener getCommentStatusListener) {
        this.mGetCommentStatusListener = getCommentStatusListener;

    }

    public void getGetCommentStatus(String orderId, String productId, final int position) {
        TreeMap<String, String> paramters = new TreeMap<>();
        paramters.put("subOrderId", orderId);
        paramters.put("productId", productId);
        paramters.put("userId", UserManager.getUser().getId());

        OKHttpManager.get(getUrl(R.string.GetCommentStatus), paramters, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mGetCommentStatusListener.getState((int) data.getResultdata(), position);
                    if ((int) data.getResultdata() == 1) {
                        ToastUtils.showToast("The goods have been evaluated");
                    }
                }


            }
        });
    }

    public interface GetCommentStatusListener {
        void getState(int state, int position);
    }
}

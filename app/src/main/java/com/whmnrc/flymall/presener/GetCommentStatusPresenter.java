package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;

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

    public void getGetCommentStatus(String orderId) {
        TreeMap<String, String> paramters = new TreeMap<>();
        paramters.put("subOrderId", orderId);
        paramters.put("userId", UserManager.getUser().getId());

        OKHttpManager.get(getUrl(R.string.GetCommentStatus), paramters, new CommonCallBack() {
            @Override
            protected void onSuccess(Object data) {
                mGetCommentStatusListener.getState();
            }
        });
    }

    public interface GetCommentStatusListener {
        void getState();
    }
}

package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.LikeGoodsBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class GetLikeGoodsPresenter extends PresenterBase {

    private GetLikeGoodsListener mGetLikeGoodsListener;

    public GetLikeGoodsPresenter(GetLikeGoodsListener getLikeGoodsListener) {
        this.mGetLikeGoodsListener = getLikeGoodsListener;
    }

    public void getLikeGoods() {
        HashMap<String, String> paramters = new HashMap<>();
        OKHttpManager.get(getUrl(R.string.MayLike), paramters, new CommonCallBack<LikeGoodsBean>() {
            @Override
            protected void onSuccess(LikeGoodsBean data) {
                if (data.getType() == 1) {

                    mGetLikeGoodsListener.loadGoodsSucces(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }

    public interface GetLikeGoodsListener {
        void loadGoodsSucces(List<LikeGoodsBean.ResultdataBean> resultdataBean);
    }
}

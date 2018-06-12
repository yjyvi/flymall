package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.GoodsNoAttrBean;
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

public class GoodsCommitOrderPresenter extends PresenterBase {

    private  GoodsNoAttrCommitListener mGoodsNoAttrCommitListener;

    public GoodsCommitOrderPresenter(GoodsNoAttrCommitListener goodsNoAttrCommitListener) {
        this.mGoodsNoAttrCommitListener= goodsNoAttrCommitListener;

    }

    public void getGoodsNoAttrCommit(String skuIds, String counts, String collpids) {
        TreeMap<String, String> paramters = new TreeMap<>();
        paramters.put("userId", UserManager.getUser().getId());
        paramters.put("skuIds", skuIds);
        paramters.put("counts", counts);
        paramters.put("collpids", collpids);
        OKHttpManager.get(getUrl(R.string.SubmitOrderByProductId), paramters, new CommonCallBack<GoodsNoAttrBean>() {
            @Override
            protected void onSuccess(GoodsNoAttrBean data) {
                if (data.getType()==1) {
                    mGoodsNoAttrCommitListener.commitSuccess(data.getResultdata());
                }else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }

    public interface GoodsNoAttrCommitListener {
        void commitSuccess(GoodsNoAttrBean.ResultdataBean resultdata);
    }
}

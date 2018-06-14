package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.GoodsEvaluateListBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/30.
 * 商品评价列表
 */

public class EvaluateListPresenter extends PresenterBase {

    private EvaluateListListener mEvaluateListListener;

    public EvaluateListPresenter(EvaluateListListener evaluateListListener) {
        this.mEvaluateListListener = evaluateListListener;
    }


    public void getEvaluateList(String goodsId, int page, int rows, int type) {
        HashMap<String, String> params = new HashMap<>(4);
        params.put("productId", goodsId);
        params.put("pageNo", String.valueOf(page));
        params.put("pageSize", String.valueOf(rows));
        params.put("type", String.valueOf(type));

        OKHttpManager.get(getUrl(R.string.GetEvaluateItem), params, new CommonCallBack<GoodsEvaluateListBean>() {
            @Override
            protected void onSuccess(GoodsEvaluateListBean data) {
                if (data.getType() == 1) {
                    mEvaluateListListener.getEvaluateListSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface EvaluateListListener {
        void getEvaluateListSuccess(GoodsEvaluateListBean.ResultdataBean resultdataBean);
    }

}

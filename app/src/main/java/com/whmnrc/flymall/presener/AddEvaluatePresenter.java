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
 * @data 2018/5/30.
 * 评价商品
 */

public class AddEvaluatePresenter extends PresenterBase {

    private AddEvaluateListener mAddEvaluateListener;

    public AddEvaluatePresenter(AddEvaluateListener addEvaluateListener) {
        this.mAddEvaluateListener = addEvaluateListener;
    }


    public void addEvaluate(int star, String content, String imgs, String voides, String videoThum, String orderId, String goodsId) {
        HashMap<String, String> params = new HashMap<>(8);
        params.put("ProductId", goodsId);
        params.put("SubOrderId", orderId);
        params.put("UserId", UserManager.getUser().getId());
        params.put("Images", imgs);
        params.put("VideoUrl", voides);
        params.put("CommentContent", content);
        params.put("ThumImg", videoThum);
        params.put("Stars", String.valueOf(star));
        params.put("Status", "1");
        OKHttpManager.postString(getUrl(R.string.AddEvaluateItem), JSON.toJSONString(params), new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mAddEvaluateListener.addEvaluateSuccess();
                }

                ToastUtils.showToast(data.getMessage());
            }
        });
    }


    public interface AddEvaluateListener {
        void addEvaluateSuccess();
    }

}

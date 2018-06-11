package com.whmnrc.flymall.presener;

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
 */

public class AddEvaluatePresenter extends PresenterBase {

    private AddEvaluateListener mAddEvaluateListener;

    public AddEvaluatePresenter(AddEvaluateListener addEvaluateListener) {
        this.mAddEvaluateListener = addEvaluateListener;
    }


    public void addEvaluate(int star, String content, String imgs, String voides, String orderId, String goodsId) {
        HashMap<String, String> params = new HashMap<>(7);
        params.put("UserInfo_ID", UserManager.getUser().getId());
        params.put("Evaluate_Star", String.valueOf(star));
        params.put("Evaluate_Content", content);

        params.put("Imgs", imgs);
        params.put("Flashs", voides);

        params.put("Order_ID", orderId);
        params.put("Goods_ID", goodsId);

        OKHttpManager.get(getUrl(R.string.AddEvaluateItem), params, new CommonCallBack<BaseBean>() {
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

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
import java.util.Map;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class AddOrDelCollectionGoodsPresenter extends PresenterBase {

    private AddOrDelCollectionGoodsListener mAddOrDelCollectionGoodsListener;

    public AddOrDelCollectionGoodsPresenter(AddOrDelCollectionGoodsListener addOrDelCollectionGoodsListener) {
        this.mAddOrDelCollectionGoodsListener = addOrDelCollectionGoodsListener;

    }

    /**
     * 添加收藏
     *
     * @param goodsId
     * @param type    1-收藏  2-历史记录
     */
    public void addCollection(String goodsId, final int type) {
        Map<String, String> params = new HashMap<>(3);
        if (UserManager.getUser() == null) {
            return;
        }
        params.put("UserInfo_ID", UserManager.getUser().getId());
        params.put("Goods_ID", goodsId);
        params.put("SaveType", String.valueOf(type));
        OKHttpManager.postString(getUrl(R.string.AddCollection), JSON.toJSONString(params), new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mAddOrDelCollectionGoodsListener.addCollectionSuccess();
                }
                if (type == 1) {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }

    /**
     * 取消收藏
     *
     * @param goodsId
     */
    public void delCollection(String goodsId) {
        Map<String, String> params = new HashMap<>(1);
        params.put("Id", goodsId);
        OKHttpManager.get(getUrl(R.string.DeleteSingle), params, new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType() == 1) {
                    mAddOrDelCollectionGoodsListener.delCollectionSuccess();
                }
                ToastUtils.showToast(data.getMessage());
            }
        });
    }




    public interface AddOrDelCollectionGoodsListener {
        void addCollectionSuccess();

        void delCollectionSuccess();
    }
}

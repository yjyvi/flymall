package com.whmnrc.flymall.presener;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.SearchResultBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author yjyvi
 * @date 2018/2/3
 * 获取分类
 */

public class SearchGoodsListPresenter extends PresenterBase {
    private SearchGoodsListener mSearchGoodsListener;

    public SearchGoodsListPresenter(SearchGoodsListener searchGoodsListener) {
        this.mSearchGoodsListener = searchGoodsListener;
    }


    public void getSearchGoodsList(String searchContent, String cid, String bid, String aid, String orderKey, String orderType, int page, int rows) {

        HashMap<String, String> paramters = new HashMap<>(8);
        paramters.put("keywords", searchContent);
        paramters.put("cid", cid);
        paramters.put("b_id", bid);
        paramters.put("a_id", aid);
        paramters.put("orderKey", orderKey);
        paramters.put("orderType", orderType);
        paramters.put("pageNo", String.valueOf(page));
        paramters.put("pageSize", String.valueOf(rows));

        OKHttpManager.postString(getUrl(R.string.Search), JSON.toJSONString(paramters), new CommonCallBack<SearchResultBean>() {
            @Override
            protected void onSuccess(SearchResultBean data) {
                if (data.getType() == 1) {
                    mSearchGoodsListener.getSearchGoodsSuccess(data.getResultdata().getProductList());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface SearchGoodsListener {
        void getSearchGoodsSuccess(List<SearchResultBean.ResultdataBean.ProductListBean> dataBean);
    }

}

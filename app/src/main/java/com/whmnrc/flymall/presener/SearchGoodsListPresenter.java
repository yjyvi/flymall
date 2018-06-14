package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.SearchResultBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;

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
        paramters.put("keyword", searchContent);
        paramters.put("CategoryId", cid);
        paramters.put("BrandId", bid);
        paramters.put("AttrIds", aid);
        paramters.put("OrderKey", orderKey);
        paramters.put("OrderType", orderType);
        paramters.put("PageNo", String.valueOf(page));
        paramters.put("PageSize", String.valueOf(rows));

        OKHttpManager.get(getUrl(R.string.Search), paramters, new CommonCallBack<SearchResultBean>() {
            @Override
            protected void onSuccess(SearchResultBean data) {
                if (data.getType() == 1) {
                    mSearchGoodsListener.getSearchGoodsSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface SearchGoodsListener {
        void getSearchGoodsSuccess(SearchResultBean.ResultdataBean dataBean);
    }

}

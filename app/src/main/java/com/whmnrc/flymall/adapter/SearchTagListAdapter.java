package com.whmnrc.flymall.adapter;

import android.content.Context;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.SearchResultBean;

/**
 * @author yjyvi
 * @data 2018/5/23.
 */

public class SearchTagListAdapter extends CommonAdapter<SearchResultBean.ResultdataBean.CategoryBean.SubCategoryBean> {

    public SearchTagListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, SearchResultBean.ResultdataBean.CategoryBean.SubCategoryBean o, int position) {
        holder.setText(R.id.tv_content,o.getName());
    }
}

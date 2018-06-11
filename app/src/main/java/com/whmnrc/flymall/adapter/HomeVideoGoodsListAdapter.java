package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.HomeDataBean;
import com.whmnrc.flymall.utils.UIUtils;

/**
 * @author yjyvi
 * @data 2018/5/9.
 */

public class HomeVideoGoodsListAdapter extends CommonAdapter<HomeDataBean.ResultdataBean.VideosBean> {
    public HomeVideoGoodsListAdapter(Context context, int layoutId) {
        super(context, layoutId);
        this.mContext = context;
    }

    @Override
    public void convert(final ViewHolder holder, HomeDataBean.ResultdataBean.VideosBean allVideoBean, int position) {
        UIUtils.loadCommentImg((ImageView) holder.getView(R.id.iv_play),allVideoBean.getImageUrl());
    }


}

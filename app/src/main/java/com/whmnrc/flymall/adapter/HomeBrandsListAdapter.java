package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.HomeDataBean;
import com.whmnrc.flymall.ui.home.GoodsListActivity;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/9.
 */

public class HomeBrandsListAdapter extends CommonAdapter<HomeDataBean.ResultdataBean.BrandsBean> {
    public HomeBrandsListAdapter(Context context, int layoutId) {
        super(context, layoutId);
        this.mContext = context;
    }

    @Override
    public void convert(final ViewHolder holder, final HomeDataBean.ResultdataBean.BrandsBean resultdataBean, int position) {
        GlideUtils.LoadImage(mContext, resultdataBean.getLogo(), (ImageView) holder.getView(R.id.iv_play));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.getId()));
            }
        });
    }


}

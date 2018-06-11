package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.luck.picture.lib.PictureVideoPlayActivity;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.AllVideoBean;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;
import com.whmnrc.flymall.utils.GetViewHeightUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/21.
 */

public class VideoGoodsListAdapter extends CommonAdapter<AllVideoBean.ResultdataBean> {
    public VideoGoodsListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, final AllVideoBean.ResultdataBean data, int position) {
        int getWidth = (holder.itemView.getContext().getResources().getDisplayMetrics().widthPixels - holder.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.dm_40)) / 2;
        GetViewHeightUtils.changeViewHeight(holder.getView(R.id.rl_goods), getWidth);
        GlideUtils.LoadImage(mContext, data.getImageUrl(), (ImageView) holder.getView(R.id.iv_goods_img));
        holder.setText(R.id.tv_name, data.getVideoName());
        holder.setOnClickListener(R.id.iv_goods_img, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureVideoPlayActivity.start(v.getContext(), data.getVideoUrl());
            }
        });


        holder.setOnClickListener(R.id.tv_name, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsDetailsActivity.start(v.getContext(), String.valueOf(data.getId()));
            }
        });
    }


}

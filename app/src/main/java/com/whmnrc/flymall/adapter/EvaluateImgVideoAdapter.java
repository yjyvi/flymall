package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.luck.picture.lib.PictureVideoPlayActivity;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.MediaBean;
import com.whmnrc.flymall.utils.GetViewHeightUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;
import com.whmnrc.mylibrary.widget.photobigview.PhotoViewActivity;

/**
 * @author yjyvi
 * @data 2018/6/1.
 */

public class EvaluateImgVideoAdapter extends CommonAdapter<MediaBean> {
    public EvaluateImgVideoAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, final MediaBean evaluateItem, int position) {
        ImageView imageview = (ImageView) holder.getView(R.id.iv_img);

        int getWidth = (holder.itemView.getContext().getResources().getDisplayMetrics().widthPixels - holder.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.dm_40)) / 3;
        GetViewHeightUtils.changeViewHeight(holder.getView(R.id.iv_img), getWidth);

        if (evaluateItem.getType() == 1) {
            holder.setVisible(R.id.iv_video_img, true);
        } else {
            holder.setVisible(R.id.iv_video_img, false);
        }


        GlideUtils.LoadImage(mContext, evaluateItem.getNetimgPath(), imageview);
    }


}

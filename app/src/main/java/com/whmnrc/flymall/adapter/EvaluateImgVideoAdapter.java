package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.MediaBean;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/6/1.
 */

public class EvaluateImgVideoAdapter extends CommonAdapter<MediaBean> {
    public EvaluateImgVideoAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, MediaBean evaluateItem, int position) {
        holder.setVisible(R.id.iv_cancel,false);
        GlideUtils.LoadImage(mContext,evaluateItem.getNetimgPath(), (ImageView) holder.getView(R.id.iv_img));
    }


}

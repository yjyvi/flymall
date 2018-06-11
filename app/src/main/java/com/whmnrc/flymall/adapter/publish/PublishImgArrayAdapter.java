package com.whmnrc.flymall.adapter.publish;

import android.view.View;
import android.widget.ImageView;

import com.luck.picture.lib.entity.LocalMedia;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ItemViewDelegate;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.utils.UIUtils;

/**
 * Created by yong hao zeng on 2017/12/19.
 */

public class PublishImgArrayAdapter implements ItemViewDelegate<LocalMedia> {
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public PublishImgArrayAdapter(OnClick onClick) {
        this.onClick = onClick;
    }


    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_array_img;
    }

    @Override
    public boolean isForViewType(LocalMedia item, int position) {
        return item.getMimeType() != -2;
    }

    @Override
    public void convert(final ViewHolder holder, LocalMedia localMedia, int position) {

        UIUtils.loadRound((ImageView) holder.getView(R.id.iv_img), localMedia.getPath());

        holder.setVisible(R.id.iv_cancel, true);
        holder.setTag(R.id.iv_cancel, position);
        holder.setOnClickListener(R.id.iv_cancel, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
                if (onClick != null) {
                    onClick.onCancelClick(view, position);
                }
            }
        });
    }

    public interface OnClick {
        void onCancelClick(View view, int position);
    }
}

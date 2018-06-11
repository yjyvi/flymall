package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.GoodsListBean;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;
import com.whmnrc.flymall.utils.GetViewHeightUtils;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/18.
 */

public class GoodListAdapter extends CommonAdapter<GoodsListBean.ResultdataBean> {
    private boolean mIsVertical;

    public GoodListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    public GoodListAdapter(Context context, int layoutId, boolean isVertical) {
        super(context, layoutId);
        this.mIsVertical = isVertical;
    }

    @Override
    public void convert(ViewHolder holder, final GoodsListBean.ResultdataBean bean, int position) {
        if (!mIsVertical) {
            int getWidth = (holder.itemView.getContext().getResources().getDisplayMetrics().widthPixels - holder.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.dm_4)) / 2;
            GetViewHeightUtils.changeViewHeight(holder.getView(R.id.iv_goods_img), getWidth);
        }

        if (bean != null) {
            holder.setText(R.id.tv_goods_name, TextUtils.isEmpty(bean.getGoods_Name()) ? "" : bean.getGoods_Name());
            holder.setText(R.id.tv_price, PlaceholderUtils.pricePlaceholder(bean.getGoodsPrice_Price()));
            if (bean.getGoods_ImaPath() != null) {
                GlideUtils.LoadImage(mContext, bean.getGoods_ImaPath(), (ImageView) holder.getView(R.id.iv_goods_img));
            }
            if (!mIsVertical) {
                holder.setText(R.id.tv_source_price, PlaceholderUtils.pricePlaceholder(bean.getGoods_SourcePrice()));
                TextView tvSourcePrice = holder.getView(R.id.tv_source_price);
                tvSourcePrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                holder.setText(R.id.tv_sold, String.format("Sold: %s+ pis", bean.getGoods_MonthCount()));
            } else {
                holder.setText(R.id.tv_goods_spec, bean.getGoods_Describe());
            }

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsDetailsActivity.start(v.getContext(), bean.getGoods_ID());
            }
        });
    }


}

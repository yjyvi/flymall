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
import com.whmnrc.flymall.beans.SearchResultBean;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;
import com.whmnrc.flymall.utils.GetViewHeightUtils;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/18.
 */

public class SearchGoodListAdapter extends CommonAdapter<SearchResultBean.ResultdataBean.ProductListBean> {

    public SearchGoodListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }


    @Override
    public void convert(ViewHolder holder, final SearchResultBean.ResultdataBean.ProductListBean bean, int position) {
        int getWidth = (holder.itemView.getContext().getResources().getDisplayMetrics().widthPixels - holder.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.dm_4)) / 2;
        GetViewHeightUtils.changeViewHeight(holder.getView(R.id.iv_goods_img), getWidth);


        holder.setText(R.id.tv_goods_name, TextUtils.isEmpty(bean.getProductName()) ? "" : bean.getProductName());
        holder.setText(R.id.tv_price, PlaceholderUtils.pricePlaceholder(bean.getMinSalePrice()));
        String imagePath = bean.getImagePath();
        if (imagePath != null) {
            if (!imagePath.endsWith(".png") || !imagePath.endsWith(".jpg")) {
                imagePath += "/1.png";
            }
            GlideUtils.LoadImage(mContext, imagePath, (ImageView) holder.getView(R.id.iv_goods_img));
        }
        holder.setText(R.id.tv_source_price, PlaceholderUtils.pricePlaceholder(bean.getMarketPrice()));
        TextView tvSourcePrice = holder.getView(R.id.tv_source_price);
        tvSourcePrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.setText(R.id.tv_sold, String.format("Sold: %s+ pis", bean.getSaleCounts()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsDetailsActivity.start(v.getContext(), String.valueOf(bean.getId()));
            }
        });
    }


}

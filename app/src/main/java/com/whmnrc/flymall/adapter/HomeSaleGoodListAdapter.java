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
import com.whmnrc.flymall.beans.HomeSaleGoodsBean;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;
import com.whmnrc.flymall.utils.GetViewHeightUtils;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/18.
 */

public class HomeSaleGoodListAdapter extends CommonAdapter<HomeSaleGoodsBean.ResultdataBean.ProductsBean> {

    public HomeSaleGoodListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }


    @Override
    public void convert(ViewHolder holder, final HomeSaleGoodsBean.ResultdataBean.ProductsBean goodsBean, int position) {

        int getWidth = (holder.itemView.getContext().getResources().getDisplayMetrics().widthPixels - holder.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.dm_4)) / 2;
        GetViewHeightUtils.changeViewHeight(holder.getView(R.id.iv_goods_img), getWidth);

        if (goodsBean != null) {
            holder.setText(R.id.tv_goods_name, TextUtils.isEmpty(goodsBean.getProductName()) ? "" : goodsBean.getProductName());
            String imagePath = goodsBean.getImagePath();
            if (goodsBean.getImagePath() != null) {
                if (!goodsBean.getImagePath().endsWith(".png") || !goodsBean.getImagePath().endsWith(".jpg")) {
                    imagePath += "/1.png";
                }
                GlideUtils.LoadImage(mContext, imagePath, (ImageView) holder.getView(R.id.iv_goods_img));
            }

            holder.setText(R.id.tv_price, PlaceholderUtils.pricePlaceholder(goodsBean.getMinSalePrice()));
            TextView view = holder.getView(R.id.tv_source_price);
            view.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.setText(R.id.tv_source_price,PlaceholderUtils.pricePlaceholder(goodsBean.getMarketPrice()));
            holder.setText(R.id.tv_sold,String.format("Sold: %s+ pis",goodsBean.getSaleCounts()));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsDetailsActivity.start(v.getContext(), String.valueOf(goodsBean.getId()));
            }
        });
    }


}

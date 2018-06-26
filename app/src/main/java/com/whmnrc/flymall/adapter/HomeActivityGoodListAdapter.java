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
import com.whmnrc.flymall.beans.ActivityGoodsListBean;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;
import com.whmnrc.flymall.utils.GetViewHeightUtils;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/18.
 */

public class HomeActivityGoodListAdapter extends CommonAdapter<ActivityGoodsListBean.ResultdataBean.TopicModuleInfoBean.ModuleProductInfoBean> {

    public HomeActivityGoodListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, final ActivityGoodsListBean.ResultdataBean.TopicModuleInfoBean.ModuleProductInfoBean bean, int position) {
        final ActivityGoodsListBean.ResultdataBean.TopicModuleInfoBean.ModuleProductInfoBean.ProductInfoBean productInfo = bean.getProductInfo();

        int getWidth = (holder.itemView.getContext().getResources().getDisplayMetrics().widthPixels - holder.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.dm_4)) / 2;
        GetViewHeightUtils.changeViewHeight(holder.getView(R.id.iv_goods_img), getWidth);


        holder.setText(R.id.tv_goods_name, TextUtils.isEmpty(productInfo.getProductName()) ? "" : productInfo.getProductName());
        holder.setText(R.id.tv_price, PlaceholderUtils.pricePlaceholder(productInfo.getMinSalePrice()));

        String imagePath = productInfo.getImagePath();
        if (!imagePath.endsWith(".png") || !imagePath.endsWith(".jpg")) {
            imagePath += "/1.png";
        }
        GlideUtils.LoadImage(mContext, imagePath, (ImageView) holder.getView(R.id.iv_goods_img));


        holder.setText(R.id.tv_source_price, PlaceholderUtils.pricePlaceholder(productInfo.getMarketPrice()));
        TextView tvSourcePrice = holder.getView(R.id.tv_source_price);
        tvSourcePrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.setText(R.id.tv_sold, String.format("Sold: %s+ pis", productInfo.getSaleCounts()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsDetailsActivity.start(v.getContext(), String.valueOf(productInfo.getId()));
            }
        });
    }


}

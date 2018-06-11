package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.ConfirmBean;
import com.whmnrc.flymall.beans.OrderListBean;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/18.
 */

public class ConfirmOrderGoodListAdapter extends CommonAdapter {

    private boolean mIsOrder;

    public ConfirmOrderGoodListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    public ConfirmOrderGoodListAdapter(Context context, int layoutId, boolean isOrder) {
        super(context, layoutId);
        this.mIsOrder = isOrder;
    }


    @Override
    public void convert(ViewHolder holder, final Object bean, int position) {

        if (mIsOrder) {
            final OrderListBean.ResultdataBean.OrderItemBean beans = (OrderListBean.ResultdataBean.OrderItemBean) bean;
            holder.setText(R.id.tv_goods_name, TextUtils.isEmpty(beans.getProduct_Name()) ? "" : beans.getProduct_Name());
            holder.setText(R.id.tv_price, PlaceholderUtils.pricePlaceholder(beans.getOrderItem_Money()));
            if (beans.getProduct_ImgPath() != null) {
                GlideUtils.LoadImage(mContext, beans.getProduct_ImgPath(), (ImageView) holder.getView(R.id.iv_goods_img));
            }

            holder.setText(R.id.tv_goods_spec, beans.getSpecAttr_Name());
            holder.setText(R.id.tv_order_goods_num, String.valueOf("X" + beans.getOrderItem_Number()));

            holder.setOnClickListener(R.id.iv_goods_img, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GoodsDetailsActivity.start(v.getContext(),beans.getProduct_ID());
                }
            });
        } else {
            ConfirmBean beans = (ConfirmBean) bean;
            holder.setText(R.id.tv_goods_name, TextUtils.isEmpty(beans.getGoods_Name()) ? "" : beans.getGoods_Name());
            holder.setText(R.id.tv_price, PlaceholderUtils.pricePlaceholder(beans.getGoods_SourcePrice()));
            if (beans.getGoods_ImaPath() != null) {
                GlideUtils.LoadImage(mContext, beans.getGoods_ImaPath(), (ImageView) holder.getView(R.id.iv_goods_img));
            }

            holder.setText(R.id.tv_goods_spec, beans.getGoods_spec());
            holder.setText(R.id.tv_order_goods_num, String.valueOf("X" + beans.getGoodsNUm()));


        }




    }


}

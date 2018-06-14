package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.OrderDeitalsBean;
import com.whmnrc.flymall.beans.OrderListBean;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/18.
 */

public class OrderCommentGoodListAdapter extends CommonAdapter  {

    private String orderId;
        private boolean mIsOrderDetials;
        private  GoodsCommentListener mGoodsCommentListener;

    public void setGoodsCommentListener(GoodsCommentListener goodsCommentListener) {
        mGoodsCommentListener = goodsCommentListener;
    }

    public OrderCommentGoodListAdapter(Context context, int layoutId, boolean isOrderDetials, String orderId) {
        super(context, layoutId);
        this.mIsOrderDetials = isOrderDetials;
        this.orderId = orderId;
    }


    @Override
    public void convert(ViewHolder holder, final Object beans, final int position) {
        String prductName;
        double money;
        String imgs;
        String goodsId;
        boolean isComment;
        if (!mIsOrderDetials) {
            OrderListBean.ResultdataBean.ItemInfoBean orderBean = (OrderListBean.ResultdataBean.ItemInfoBean) beans;
            prductName = orderBean.getProductName();
            money = orderBean.getPrice();
            imgs = orderBean.getImage();
            goodsId = String.valueOf(orderBean.getProductId());
            isComment = orderBean.isComment();
        } else {
            OrderDeitalsBean.ResultdataBean.OrderItemInfoBean orderBean = (OrderDeitalsBean.ResultdataBean.OrderItemInfoBean) beans;
            prductName = orderBean.getProductName();
            money = orderBean.getCostPrice();
            imgs = orderBean.getThumbnailsUrl();
            goodsId = String.valueOf(orderBean.getProductId());
            isComment = orderBean.isComment();
        }

        holder.setText(R.id.tv_goods_name, TextUtils.isEmpty(prductName) ? "" : prductName);
        holder.setText(R.id.tv_price, PlaceholderUtils.pricePlaceholder(money));
        GlideUtils.LoadImage(mContext, imgs, (ImageView) holder.getView(R.id.iv_goods_img));

        TextView tvGoodEvaluate = holder.getView(R.id.tv_good_evaluate);
        if (!isComment) {
            tvGoodEvaluate.setBackgroundResource(R.color.normal_gray);
        } else {
            tvGoodEvaluate.setBackgroundResource(R.color.normal_color);
        }

        holder.setOnClickListener(R.id.tv_good_evaluate, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mGoodsCommentListener != null) {
                    mGoodsCommentListener.commentClick(position);
                }

            }
        });

    }

    public interface GoodsCommentListener{
        void commentClick(int position);
    }


}

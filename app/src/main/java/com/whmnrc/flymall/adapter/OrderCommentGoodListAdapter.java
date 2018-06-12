package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.text.TextUtils;
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

public class OrderCommentGoodListAdapter extends CommonAdapter {


    private boolean mIsOrderDetials;

    public OrderCommentGoodListAdapter(Context context, int layoutId, boolean isOrderDetials) {
        super(context, layoutId);
        this.mIsOrderDetials = isOrderDetials;
    }


    @Override
    public void convert(ViewHolder holder, final Object beans, int position) {
        String prductName;
        double money;
        String imgs;
        if (!mIsOrderDetials) {
            OrderListBean.ResultdataBean.ItemInfoBean orderBean = (OrderListBean.ResultdataBean.ItemInfoBean) beans;
            prductName = orderBean.getProductName();
            money = orderBean.getPrice();
            imgs = orderBean.getImage();

        } else {
            OrderDeitalsBean.ResultdataBean.OrderItemInfoBean orderBean = (OrderDeitalsBean.ResultdataBean.OrderItemInfoBean) beans;
            prductName = orderBean.getProductName();
            money = orderBean.getCostPrice();
            imgs = orderBean.getThumbnailsUrl();
        }

        holder.setText(R.id.tv_goods_name, TextUtils.isEmpty(prductName) ? "" : prductName);
        holder.setText(R.id.tv_price, PlaceholderUtils.pricePlaceholder(money));
        GlideUtils.LoadImage(mContext, imgs, (ImageView) holder.getView(R.id.iv_goods_img));


//        holder.setText(R.id.tv_goods_spec, beans.get());
        TextView tvGoodEvaluate = holder.getView(R.id.tv_good_evaluate);

    }


}

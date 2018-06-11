package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.OrderListBean;
import com.whmnrc.flymall.ui.home.GoodsCommentActivity;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/18.
 */

public class OrderCommentGoodListAdapter extends CommonAdapter<OrderListBean.ResultdataBean.OrderItemBean> {


    public OrderCommentGoodListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }


    @Override
    public void convert(ViewHolder holder, final OrderListBean.ResultdataBean.OrderItemBean beans, int position) {

        holder.setText(R.id.tv_goods_name, TextUtils.isEmpty(beans.getProduct_Name()) ? "" : beans.getProduct_Name());
        holder.setText(R.id.tv_price, PlaceholderUtils.pricePlaceholder(beans.getOrderItem_Money()));
        if (beans.getProduct_ImgPath() != null) {
            GlideUtils.LoadImage(mContext, beans.getProduct_ImgPath(), (ImageView) holder.getView(R.id.iv_goods_img));
        }

        holder.setText(R.id.tv_goods_spec, beans.getSpecAttr_Name());
        TextView tvGoodEvaluate = holder.getView(R.id.tv_good_evaluate);

        holder.setOnClickListener(R.id.tv_good_evaluate, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsCommentActivity.start(mContext, beans.getOrder_ID(), beans.getProduct_ID());
            }
        });
    }


}

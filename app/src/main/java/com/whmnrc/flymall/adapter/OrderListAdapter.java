package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.OrderListBean;
import com.whmnrc.flymall.ui.home.OderCommentListActivity;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.flymall.utils.TextColorChangeUtils;

import java.util.ArrayList;

/**
 * @author yjyvi
 * @data 2018/5/21.
 */

public class OrderListAdapter extends CommonAdapter<OrderListBean.ResultdataBean> {
    public OrderListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }


    private OrderListOpertionListener mOrderListOpertionListener;

    public void setOrderListOpertionListener(OrderListOpertionListener orderListOpertionListener) {
        mOrderListOpertionListener = orderListOpertionListener;
    }

    @Override
    public void convert(ViewHolder holder, final OrderListBean.ResultdataBean resultdataBean, final int position) {

        String orderNoText = String.format("Order Number:%s", resultdataBean.getId());
        TextColorChangeUtils.changeTextColor((TextView) holder.getView(R.id.tv_order_no), orderNoText, 13, orderNoText.length(), Color.BLACK);
//        holder.setText(R.id.tv_order_no, orderNoText);
        int goodsNum = 0;
        double goodsTotalPrice = 0;
        for (OrderListBean.ResultdataBean.ItemInfoBean itemInfoBean : resultdataBean.getItemInfo()) {
            goodsNum += itemInfoBean.getCount();
            goodsTotalPrice += itemInfoBean.getPrice() * itemInfoBean.getCount();
        }
        holder.setText(R.id.tv_total_num, String.format("A total of %s products", goodsNum));
        String price = String.format("Total:%s", PlaceholderUtils.pricePlaceholder(resultdataBean.getOrderTotalAmount()));
//        holder.setText(R.id.tv_total_price, price);
        TextColorChangeUtils.changeTextColor((TextView) holder.getView(R.id.tv_total_price), price, 6, price.length(), Color.RED);
        switch (resultdataBean.getOrderStatus()) {
            case 1:
                holder.setVisible(R.id.line3, true);
                holder.setVisible(R.id.tv_cancel, true);
                holder.setVisible(R.id.tv_order_pay, true);
                holder.setText(R.id.tv_order_state, resultdataBean.getStatus());
                holder.setText(R.id.tv_cancel, "Cancel");
                holder.setText(R.id.tv_order_pay, "Pay now");
                holder.setOnClickListener(R.id.tv_cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOrderListOpertionListener != null) {
                            mOrderListOpertionListener.cancelOrder(resultdataBean);
                        }
                    }
                });
                break;
            case 2:
                holder.setText(R.id.tv_order_state, resultdataBean.getStatus());
                holder.setVisible(R.id.tv_cancel, false);
                holder.setVisible(R.id.tv_order_pay, false);
                holder.setVisible(R.id.line3, false);
                break;
            case 4:
                holder.setText(R.id.tv_order_state, resultdataBean.getStatus());
                holder.setVisible(R.id.tv_cancel, false);
                holder.setVisible(R.id.line3, false);
                holder.setVisible(R.id.tv_order_pay, false);
                break;
            case 5:
                holder.setText(R.id.tv_order_state, resultdataBean.getStatus());
                holder.setVisible(R.id.tv_cancel, false);
                holder.setVisible(R.id.tv_order_pay, true);
                holder.setVisible(R.id.line3, true);
                holder.setText(R.id.tv_order_pay, "Evaluated");
                break;
            case 3:
                holder.setVisible(R.id.line3, true);
                holder.setText(R.id.tv_order_state, resultdataBean.getStatus());
                holder.setText(R.id.tv_order_pay, "Confirm receipt");
                holder.setVisible(R.id.tv_cancel, false);
                break;
            default:
                holder.setVisible(R.id.tv_cancel, false);
                holder.setVisible(R.id.tv_order_pay, false);
                holder.setVisible(R.id.line3, false);
                break;
        }


        RecyclerView rvGoodsList = holder.getView(R.id.rv_goods_list);
        rvGoodsList.setLayoutManager(new LinearLayoutManager(mContext));
        rvGoodsList.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                c.drawColor(ContextCompat.getColor(mContext, R.color.common_line));
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = 1;
            }
        });
        ConfirmOrderGoodListAdapter mOrderListAdapter = new ConfirmOrderGoodListAdapter(mContext, R.layout.item_goods_list_vertical, true, false, String.valueOf(resultdataBean.getId()));

        rvGoodsList.setAdapter(mOrderListAdapter);
        rvGoodsList.setNestedScrollingEnabled(false);
        rvGoodsList.setFocusableInTouchMode(false);

        mOrderListAdapter.setDataArray(resultdataBean.getItemInfo());

        holder.setOnClickListener(R.id.tv_order_pay, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (resultdataBean.getOrderStatus()) {
                    case 1:
                        if (mOrderListOpertionListener != null) {
                            mOrderListOpertionListener.payOrder(resultdataBean);
                        }
                        break;
                    case 5:
                        OderCommentListActivity.start(v.getContext(), (ArrayList<OrderListBean.ResultdataBean.ItemInfoBean>) resultdataBean.getItemInfo(), String.valueOf(resultdataBean.getId()));
                        break;
                    case 3:
                        if (mOrderListOpertionListener != null) {
                            mOrderListOpertionListener.receiptOrder(resultdataBean);
                        }
                        break;
                    default:
                        break;
                }
            }
        });

    }


    public interface OrderListOpertionListener {
        void cancelOrder(OrderListBean.ResultdataBean resultdataBean);

        void payOrder(OrderListBean.ResultdataBean resultdataBean);

        void receiptOrder(OrderListBean.ResultdataBean resultdataBean);
    }

}

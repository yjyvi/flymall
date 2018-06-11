package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.OrderListBean;
import com.whmnrc.flymall.ui.home.OderCommentListActivity;
import com.whmnrc.flymall.ui.mine.OrderDetailsActivity;
import com.whmnrc.flymall.utils.PlaceholderUtils;

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

        holder.setText(R.id.tv_order_no, resultdataBean.getOrder().getOrder_No());
        holder.setText(R.id.tv_total_num, String.format("A total of %s products", resultdataBean.getOrderItem().size()));
        holder.setText(R.id.tv_total_price, String.format("Total:%s", PlaceholderUtils.pricePlaceholder(resultdataBean.getOrder().getOrder_Money())));
        switch (resultdataBean.getOrder().getOrder_State()) {
            case 0:
                holder.setText(R.id.tv_order_state, "UNPAID");
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
            case 1:
                holder.setText(R.id.tv_order_state, "PAID");
                holder.setVisible(R.id.tv_cancel, false);
                holder.setVisible(R.id.tv_order_pay, false);
                break;
            case 2:
                holder.setText(R.id.tv_order_state, "UNSHIPPED");
                holder.setVisible(R.id.tv_cancel, false);
                holder.setVisible(R.id.tv_order_pay, false);
                break;
            case 3:
                holder.setText(R.id.tv_order_state, "BEEVALUATED");
                holder.setText(R.id.tv_order_pay, "evaluated");
                holder.setVisible(R.id.tv_cancel, false);

                break;
            case 4:
                holder.setText(R.id.tv_order_state, "CANCELLED");
                holder.setVisible(R.id.tv_cancel, false);
                holder.setVisible(R.id.tv_order_pay, false);
                break;
            case 5:
                holder.setText(R.id.tv_order_state, "EVALUATED");
                holder.setVisible(R.id.tv_cancel, false);
                holder.setVisible(R.id.tv_order_pay, false);
                break;
            case 7:
                holder.setText(R.id.tv_order_state, "RECEIPT");
                holder.setText(R.id.tv_order_pay, "Confirm receipt");
                holder.setVisible(R.id.tv_cancel, false);
                break;
            default:
                holder.setVisible(R.id.tv_cancel, false);
                holder.setVisible(R.id.tv_order_pay, false);
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
        ConfirmOrderGoodListAdapter mOrderListAdapter = new ConfirmOrderGoodListAdapter(mContext, R.layout.item_goods_list_vertical, true);

        rvGoodsList.setAdapter(mOrderListAdapter);
        rvGoodsList.setNestedScrollingEnabled(false);
        rvGoodsList.setFocusableInTouchMode(false);

        mOrderListAdapter.setDataArray(resultdataBean.getOrderItem());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDetailsActivity.start(v.getContext(), resultdataBean.getOrder().getOrder_ID());
            }
        });


        holder.setOnClickListener(R.id.tv_order_pay, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (resultdataBean.getOrder().getOrder_State()) {
                    case 0:
                        if (mOrderListOpertionListener != null) {
                            mOrderListOpertionListener.payOrder(resultdataBean);
                        }
                        break;
                    case 3:
                        OderCommentListActivity.start(v.getContext(), (ArrayList<OrderListBean.ResultdataBean.OrderItemBean>) resultdataBean.getOrderItem());
                        break;
                    case 7:
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

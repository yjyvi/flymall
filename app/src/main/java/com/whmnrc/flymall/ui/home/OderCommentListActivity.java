package com.whmnrc.flymall.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.OrderCommentGoodListAdapter;
import com.whmnrc.flymall.beans.OrderDeitalsBean;
import com.whmnrc.flymall.beans.OrderListBean;
import com.whmnrc.flymall.presener.GetCommentStatusPresenter;
import com.whmnrc.flymall.ui.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/6/7.
 */

public class OderCommentListActivity extends BaseActivity implements GetCommentStatusPresenter.GetCommentStatusListener {

    @BindView(R.id.rv_goods_list)
    RecyclerView mRvGoodsList;

    private String goodsId;
    private OrderCommentGoodListAdapter mAdapter;
    public ArrayList<OrderListBean.ResultdataBean.ItemInfoBean> mGoodsBean;
    public String mOrderId;
    private ArrayList<OrderDeitalsBean.ResultdataBean.OrderItemInfoBean> goodsBeanDeitals;


    public boolean mIsOrderDeitals;
    public GetCommentStatusPresenter mMGetCommentStatusPresenter;

    @Override
    protected void initViewData() {
        setTitle("Product list");
        mIsOrderDeitals = getIntent().getBooleanExtra("isOrderDeitals", false);
        if (mIsOrderDeitals) {
            goodsBeanDeitals = getIntent().getParcelableArrayListExtra("goodsBeanDeitals");
        } else {
            mGoodsBean = getIntent().getParcelableArrayListExtra("goodsBean");
        }

        mMGetCommentStatusPresenter = new GetCommentStatusPresenter(this);
        mOrderId = getIntent().getStringExtra("orderId");
        mRvGoodsList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new OrderCommentGoodListAdapter(this, R.layout.item_goods_list_vertical_order_comment, mIsOrderDeitals, mOrderId);
        RecyclerView.ItemDecoration mItemDecoration = new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = 20;
                outRect.left = 30;
                outRect.right = 30;
                outRect.bottom = 20;
            }
        };

        mRvGoodsList.addItemDecoration(mItemDecoration);
        mAdapter.setGoodsCommentListener(new OrderCommentGoodListAdapter.GoodsCommentListener() {
            @Override
            public void commentClick(int position) {

                if (mIsOrderDeitals) {
                    goodsId = String.valueOf(goodsBeanDeitals.get(position).getProductId());
                } else {
                    goodsId = String.valueOf(mGoodsBean.get(position).getProductId());
                }

                mMGetCommentStatusPresenter.getGetCommentStatus(mOrderId, goodsId, position);

            }
        });
        if (mIsOrderDeitals) {
            mAdapter.setDataArray(goodsBeanDeitals);
        } else {
            mAdapter.setDataArray(mGoodsBean);
        }
        mRvGoodsList.setAdapter(mAdapter);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_vertical_goods_list;
    }

    public static void start(Context context, ArrayList<OrderListBean.ResultdataBean.ItemInfoBean> goodsBean, String orderId) {
        Intent starter = new Intent(context, OderCommentListActivity.class);
        starter.putParcelableArrayListExtra("goodsBean", goodsBean);
        starter.putExtra("orderId", orderId);
        context.startActivity(starter);
    }


    public static void start(Context context, ArrayList<OrderDeitalsBean.ResultdataBean.OrderItemInfoBean> goodsBean, String orderId, boolean isOrderDeitals) {
        Intent starter = new Intent(context, OderCommentListActivity.class);
        starter.putParcelableArrayListExtra("goodsBeanDeitals", goodsBean);
        starter.putExtra("orderId", orderId);
        starter.putExtra("isOrderDeitals", isOrderDeitals);
        context.startActivity(starter);
    }

    @Override
    public void getState(int state, int position) {
        OrderDeitalsBean.ResultdataBean.OrderItemInfoBean deitals;
        OrderListBean.ResultdataBean.ItemInfoBean orderList;

        if (state == 0) {
            if (mIsOrderDeitals) {
                deitals = (OrderDeitalsBean.ResultdataBean.OrderItemInfoBean) mAdapter.getDatas().get(position);
                deitals.setComment(true);
            } else {
                orderList = (OrderListBean.ResultdataBean.ItemInfoBean) mAdapter.getDatas().get(position);
                orderList.setComment(true);
            }
            GoodsCommentActivity.start(OderCommentListActivity.this, mOrderId, goodsId);
        } else {
            if (mIsOrderDeitals) {
                deitals = (OrderDeitalsBean.ResultdataBean.OrderItemInfoBean) mAdapter.getDatas().get(position);
                deitals.setComment(false);
            } else {
                orderList = (OrderListBean.ResultdataBean.ItemInfoBean) mAdapter.getDatas().get(position);
                orderList.setComment(false);
            }
        }

        mAdapter.notifyItemChanged(position);
    }
}

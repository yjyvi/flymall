package com.whmnrc.flymall.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.OrderCommentGoodListAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
import com.whmnrc.flymall.beans.OrderDeitalsBean;
import com.whmnrc.flymall.beans.OrderListBean;
import com.whmnrc.flymall.ui.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/6/7.
 */

public class OderCommentListActivity extends BaseActivity {

    @BindView(R.id.rv_goods_list)
    RecyclerView mRvGoodsList;


    private OrderCommentGoodListAdapter mAdapter;
    public ArrayList<OrderListBean.ResultdataBean.ItemInfoBean> mGoodsBean;
    public String mOrderId;
    private ArrayList<OrderDeitalsBean.ResultdataBean.OrderItemInfoBean> goodsBeanDeitals;
    public boolean mIsOrderDeitals;

    @Override
    protected void initViewData() {
        setTitle("Product list");
        mIsOrderDeitals = getIntent().getBooleanExtra("isOrderDeitals", false);
        if (mIsOrderDeitals) {
            goodsBeanDeitals = getIntent().getParcelableArrayListExtra("goodsBeanDeitals");
        } else {
            mGoodsBean = getIntent().getParcelableArrayListExtra("goodsBean");
        }
        mOrderId = getIntent().getStringExtra("orderId");
        mRvGoodsList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new OrderCommentGoodListAdapter(this, R.layout.item_goods_list_vertical_order_comment, mIsOrderDeitals);
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

        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                GoodsCommentActivity.start(view.getContext(), mOrderId, String.valueOf(mGoodsBean.get(position).getProductId()));
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
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
}

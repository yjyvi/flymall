package com.whmnrc.flymall.ui.mine;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.LikeGoodListAdapter;
import com.whmnrc.flymall.adapter.OrderListAdapter;
import com.whmnrc.flymall.beans.AddressBean;
import com.whmnrc.flymall.beans.LikeGoodsBean;
import com.whmnrc.flymall.beans.OrderDeitalsBean;
import com.whmnrc.flymall.beans.OrderListBean;
import com.whmnrc.flymall.presener.CancelOrReceiptOrderPresenter;
import com.whmnrc.flymall.presener.GetLikeGoodsPresenter;
import com.whmnrc.flymall.presener.OrderDetailsPresenter;
import com.whmnrc.flymall.presener.OrderListPresenter;
import com.whmnrc.flymall.ui.HomeTableActivity;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.evntBusBean.OrderListEvent;
import com.whmnrc.flymall.views.AlertDialog;
import com.whmnrc.flymall.views.LoadingDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/5/21.
 */

public class OrderFragment extends LazyLoadFragment implements OrderListPresenter.OrderListListener, OnRefreshLoadMoreListener, GetLikeGoodsPresenter.GetLikeGoodsListener, OrderListAdapter.OrderListOpertionListener, OrderDetailsPresenter.OrderDetailsListener, CancelOrReceiptOrderPresenter.OpertionOrderListener {
    @BindView(R.id.rv_order_list)
    RecyclerView mRvOrderList;
    @BindView(R.id.rv_goods_list)
    RecyclerView mRvGoodsList;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.ll_empty_goods)
    LinearLayout mLlEmptyGoods;

    private OrderListAdapter mOrderListAdapter;
    private int page = 1;
    private LoadingDialog mLoadingDialog;
    public int mOrderType;
    private OrderListPresenter mOrderListPresenter;
    private GetLikeGoodsPresenter mGetLikeGoodsPresenter;
    private LikeGoodListAdapter mAdapter;
    public OrderDetailsPresenter mOrderDetailsPresenter;
    private CancelOrReceiptOrderPresenter mCancelOrReceiptOrderPresenter;

    @Override
    protected int contentViewLayoutID() {
        return R.layout.fagment_order;
    }

    @Override
    protected void initViewData() {

        EventBus.getDefault().register(this);
        mOrderType = getArguments().getInt("orderType");
        mOrderListPresenter = new OrderListPresenter(this);
        mLoadingDialog = new LoadingDialog(getActivity());

        mRvOrderList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mOrderListAdapter = new OrderListAdapter(mRvOrderList.getContext(), R.layout.item_order_list);

        mGetLikeGoodsPresenter = new GetLikeGoodsPresenter(this);

        mRvOrderList.setFocusableInTouchMode(false);
        mRvOrderList.setNestedScrollingEnabled(false);
        mRvOrderList.setAdapter(mOrderListAdapter);
        mRefresh.setOnRefreshLoadMoreListener(this);

        showLoadingDialog();
        getOrder(mOrderType);

        mCancelOrReceiptOrderPresenter = new CancelOrReceiptOrderPresenter(this);
        mRvGoodsList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new LikeGoodListAdapter(getActivity(), R.layout.item_goods_list);
        mRvGoodsList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int childLayoutPosition = parent.getChildLayoutPosition(view);
                if (childLayoutPosition % 2 == 0) {
                    outRect.right = getResources().getDimensionPixelOffset(R.dimen.dm_2);
                } else {
                    outRect.left = getResources().getDimensionPixelOffset(R.dimen.dm_2);
                }
                outRect.bottom = getResources().getDimensionPixelOffset(R.dimen.dm_4);
            }
        });

        mRvGoodsList.setNestedScrollingEnabled(false);
        mRvGoodsList.setFocusableInTouchMode(false);

        mRvGoodsList.setAdapter(mAdapter);

        mOrderListAdapter.setOrderListOpertionListener(this);
        mOrderDetailsPresenter = new OrderDetailsPresenter(this);

        mLlEmptyGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    getActivity().finish();
                }
                HomeTableActivity.startHomeTableView(getActivity(), 0);
            }
        });
    }

    public static OrderFragment newInstance(int orderType) {
        Bundle args = new Bundle();
        OrderFragment fragment = new OrderFragment();
        args.putInt("orderType", orderType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void showLoadingDialog() {
        if (!mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }
    }

    @Subscribe
    public void orderListEvent(OrderListEvent orderListEvent) {
        page = 1;
        switch (orderListEvent.getEventType()) {
            case OrderListEvent.UNPAID:
                getOrder(1);
                break;
            case OrderListEvent.UNSHIPPED:
                getOrder(2);
                break;
            case OrderListEvent.RECEIPT:
                getOrder(3);
                break;
            case OrderListEvent.ALL:
                getOrder(0);
                break;
            default:
                break;
        }
    }

    private void getOrder(int type) {
        if (mOrderType == type) {
            showLoadingDialog();
            mOrderListPresenter.getOrderList(mOrderType, page);
        }
    }

    @Override
    public void getOrderListSuccess(List<OrderListBean.ResultdataBean> data) {
        if (page == 1) {
            mOrderListAdapter.setDataArray(data);
        } else {
            List<OrderListBean.ResultdataBean> datas = mOrderListAdapter.getDatas();
            datas.addAll(data);
            mOrderListAdapter.setDataArray(datas);
        }

        mOrderListAdapter.notifyDataSetChanged();

        mLoadingDialog.dismiss();
        showEmpty();
    }

    @Override
    public void getOrderListField() {
        mLoadingDialog.dismiss();
    }


    public void showEmpty() {
        if (mOrderListAdapter != null && mOrderListAdapter.getDatas().size() == 0) {
            mRvGoodsList.setVisibility(View.VISIBLE);
            mLlEmptyGoods.setVisibility(View.VISIBLE);
            mGetLikeGoodsPresenter.getLikeGoods();
            EmptyListUtils.loadEmpty(true, "No order", R.mipmap.no_order, mVsEmpty);
        } else {
            mRvGoodsList.setVisibility(View.GONE);
            mLlEmptyGoods.setVisibility(View.GONE);
            if (mVsEmpty != null) {
                mVsEmpty.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        refreshLayout.finishLoadMore();
        page++;
        mOrderListPresenter.getOrderList(mOrderType, page);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        refreshLayout.finishRefresh();
        page = 1;
        mOrderListPresenter.getOrderList(mOrderType, page);
    }

    @Override
    public void loadGoodsSucces(List<LikeGoodsBean.ResultdataBean> resultdataBean) {
        mAdapter.setDataArray(resultdataBean);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void cancelOrder(final OrderListBean.ResultdataBean resultdataBean) {
        new AlertDialog(view.getContext()).builder().setTitle("Warning!")
                .setMsg("Are you sure you want to Cancel the order?")
                .setCancelable(true)
                .setPositiveButton("agree", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mCancelOrReceiptOrderPresenter.cancelOrder(String.valueOf(resultdataBean.getId()));
                    }
                })
                .setNegativeButton("cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
    }

    @Override
    public void payOrder(OrderListBean.ResultdataBean resultdataBean) {
        mOrderDetailsPresenter.getOrderDetails(String.valueOf(resultdataBean.getId()));
    }

    @Override
    public void receiptOrder(final OrderListBean.ResultdataBean resultdataBean) {
        new AlertDialog(view.getContext()).builder().setTitle("Warning!")
                .setMsg("Do you want to confirm receipt?")
                .setCancelable(true)
                .setPositiveButton("agree", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mCancelOrReceiptOrderPresenter.receiptOrder(String.valueOf(resultdataBean.getId()));
                    }
                })
                .setNegativeButton("cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
    }

    @Override
    public void getOrderDetailsSuccess(OrderDeitalsBean.ResultdataBean resultdataBeans) {
        AddressBean.ResultdataBean addressBean = new AddressBean.ResultdataBean();
        addressBean.setShipTo(resultdataBeans.getShipTo());
        addressBean.setPhone(resultdataBeans.getCellPhone());
        addressBean.setAddress(resultdataBeans.getAddress());
        ConfirmPaymentActivity.start(getActivity(), String.valueOf(resultdataBeans.getId()), String.valueOf(resultdataBeans.getProductTotalAmount()), JSON.toJSONString(addressBean));
    }

    @Override
    public void cancelSuccess() {
        mRefresh.autoRefresh();
    }

    @Override
    public void receiptSuccess() {
        mRefresh.autoRefresh();
    }


}

package com.whmnrc.flymall.ui.table;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.LikeGoodListAdapter;
import com.whmnrc.flymall.adapter.ShoppingCartAdapter;
import com.whmnrc.flymall.beans.ConfirmBean;
import com.whmnrc.flymall.beans.LikeGoodsBean;
import com.whmnrc.flymall.beans.ShoppingCartListBean;
import com.whmnrc.flymall.eventbus.HomeTableChangeEvent;
import com.whmnrc.flymall.presener.DelShoppingCartPresenter;
import com.whmnrc.flymall.presener.GetLikeGoodsPresenter;
import com.whmnrc.flymall.presener.GetShoppingCartListPresenter;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.ui.mine.ConfirmOrderActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.SHopCartEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/8.
 */

public class ShoppingCartFragment extends LazyLoadFragment implements GetLikeGoodsPresenter.GetLikeGoodsListener, GetShoppingCartListPresenter.GetShoppingCartListListener, DelShoppingCartPresenter.DelShoppingCartListListener, OnRefreshLoadMoreListener {

    @BindView(R.id.rl_right_title)
    RelativeLayout mRlRightTitle;
    @BindView(R.id.rv_in_goods)
    RecyclerView mRvInGoods;
    @BindView(R.id.rv_other_goods)
    RecyclerView mRvOtherGoods;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    @BindView(R.id.iv_all_check)
    ImageView mIvAllCheck;
    @BindView(R.id.tv_entry)
    TextView mTvEntry;
    @BindView(R.id.tv_sum_prices)
    TextView mTvSumPrices;
    @BindView(R.id.ll_money)
    LinearLayout mLlMoney;
    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.tv_to_home)
    TextView mTvToHome;

    public ShoppingCartAdapter mShoppingCartAdapter;
    public LikeGoodListAdapter mGoodListAdapter;
    private GetLikeGoodsPresenter mGetLikeGoodsPresenter;
    private boolean isAllChecked;
    public GetShoppingCartListPresenter mGetShoppingCartListPresenter;
    private int page = 1;
    public DelShoppingCartPresenter mDelShoppingCartPresenter;
    private Map<String, Integer> cartIds = new TreeMap<>();
    private List<Integer> removePosition = new ArrayList<>();
    public boolean mIsActivity;

    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_shopping_cart;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        cartIds = null;
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initViewData() {

        mIsActivity = getArguments().getBoolean("isActivity", false);

        EventBus.getDefault().register(this);

        setTitle("Shopping Cart");
        rightVisible("Complete");
        mRefresh.setOnRefreshLoadMoreListener(this);
        mGetLikeGoodsPresenter = new GetLikeGoodsPresenter(this);
        mGetShoppingCartListPresenter = new GetShoppingCartListPresenter(this);
        mGetShoppingCartListPresenter.getShoppingCartList(page);
        mGetLikeGoodsPresenter.getLikeGoods();

        mDelShoppingCartPresenter = new DelShoppingCartPresenter(this);


        mRvInGoods.setLayoutManager(new LinearLayoutManager(getActivity()));
        mShoppingCartAdapter = new ShoppingCartAdapter(getActivity(), R.layout.item_shopping_cart);
        mRvInGoods.setAdapter(mShoppingCartAdapter);


        mRvOtherGoods.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRvOtherGoods.addItemDecoration(new RecyclerView.ItemDecoration() {
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
        mGoodListAdapter = new LikeGoodListAdapter(getActivity(), R.layout.item_goods_list);
        mRvOtherGoods.setAdapter(mGoodListAdapter);

        mRvInGoods.setNestedScrollingEnabled(false);
        mRvOtherGoods.setNestedScrollingEnabled(false);
        mRvOtherGoods.setFocusableInTouchMode(false);
        mRvOtherGoods.requestFocus();


        mRlRightTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editShopCart(!mRlRightTitle.isSelected());

            }
        });

        mShoppingCartAdapter.setOperationShoppingCartListener(new ShoppingCartAdapter.OperationShoppingCartListener() {
            @Override
            public void delItem(int position) {
                removePosition.add(position);

                cartIds.put(String.valueOf(mShoppingCartAdapter.getDatas().get(position).getId()), position);
                mDelShoppingCartPresenter.delShoppingCartList(String.valueOf(mShoppingCartAdapter.getDatas().get(position).getSkuId()));

                String trim = mTvSumPrices.getText().toString().trim();
                trim = trim.substring(1, trim.length());
                double goodsPricePrice = mShoppingCartAdapter.getDatas().get(position).getPrice() * mShoppingCartAdapter.getDatas().get(position).getCount();
                double currentPrice = Double.parseDouble(trim);
                mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(currentPrice - goodsPricePrice));
            }

            @Override
            public void selectToPrice(int position, double goodsPrice, boolean isAdd, String cartId) {

                String currentPrice = mTvSumPrices.getText().toString().trim();
                String substring = currentPrice.substring(1, currentPrice.length());
                double price = Double.parseDouble(substring);
                double totalPrice;

                if (isAdd) {
                    cartIds.put(cartId, position);
                    totalPrice = price + goodsPrice;
                } else {
                    cartIds.remove(cartId);
                    totalPrice = price - goodsPrice;
                }

                mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(totalPrice));
            }
        });


    }

    private void editShopCart(boolean isSelect) {
        if (isSelect) {
            rightVisible("Edit");
            mLlMoney.setVisibility(View.GONE);
            mRlRightTitle.setSelected(true);
            mTvEntry.setText("Delete");
        } else {
            rightVisible("Complete");
            mLlMoney.setVisibility(View.VISIBLE);
            mRlRightTitle.setSelected(false);

            if (mShoppingCartAdapter != null && mShoppingCartAdapter.getDatas() != null) {
                mTvEntry.setText(String.format("Bill(%s)", mShoppingCartAdapter.getDatas().size()));
            } else {
                mTvEntry.setText(String.format("Bill(%s)", 0));
            }
        }
    }


    /**
     * 初始化实例
     *
     * @return
     */
    public static ShoppingCartFragment newInstance(boolean isActivity) {
        Bundle bundle = new Bundle();
        ShoppingCartFragment shoppingCartFragment = new ShoppingCartFragment();
        shoppingCartFragment.setArguments(bundle);
        bundle.putBoolean("isActivity", isActivity);
        return shoppingCartFragment;
    }


    @OnClick({R.id.iv_all_check, R.id.tv_entry, R.id.tv_to_home})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_all_check:
                checkedAll();
                break;
            case R.id.tv_entry:
                if (mRlRightTitle.isSelected()) {
                    if (cartIds.size() <= 0) {
                        ToastUtils.showToast("请选择要删除的商品");
                        return;
                    }
                    StringBuilder cartIdSt = new StringBuilder();
                    for (String cartId : cartIds.keySet()) {
                        cartIdSt.append(cartId).append(",");
                    }

                    String result;
                    if (cartIds.size() > 1) {
                        result = cartIdSt.toString().substring(0, cartIdSt.toString().length());
                    } else {
                        result = cartIdSt.toString();
                    }

                    mDelShoppingCartPresenter.delShoppingCartList(result);
                    editShopCart(false);
                } else {
                    if (cartIds.size() <= 0) {
                        ToastUtils.showToast("请选择要购买的商品");
                        return;
                    }
                    ArrayList<ConfirmBean> confirmBeans = new ArrayList<>();
                    for (int i = 0; i < mShoppingCartAdapter.getDatas().size(); i++) {
                        if (mShoppingCartAdapter.getDatas().get(i).isSelect()) {
                            ConfirmBean confirmBean = new ConfirmBean();
                            ShoppingCartListBean.ResultdataBean.ProductsBean resultdataBean = mShoppingCartAdapter.getDatas().get(i);
                            confirmBean.setGoodsPrice_Price(0);
                            confirmBean.setGoods_spec(resultdataBean.getColor() + resultdataBean.getSize() + resultdataBean.getVersion());
                            confirmBean.setGoods_SourcePrice(resultdataBean.getPrice() * resultdataBean.getCount());
                            confirmBean.setPriceIds(resultdataBean.getSkuId());
                            confirmBean.setGoodsNUm(resultdataBean.getCount());
                            confirmBean.setGoods_ImaPath(resultdataBean.getImgUrl());
                            confirmBean.setGoods_Name(resultdataBean.getName());
                            confirmBean.setGoods_Describe(resultdataBean.getColor() + resultdataBean.getSize() + resultdataBean.getVersion());
                            confirmBeans.add(confirmBean);
                        }
                    }

                    ConfirmOrderActivity.start(view.getContext(), confirmBeans, false);

                }
                break;
            case R.id.tv_to_home:
                if (mIsActivity) {
                    EventBus.getDefault().post(new HomeTableChangeEvent().setEventType(HomeTableChangeEvent.GO_TO_HOME));
                } else {
                    EventBus.getDefault().post(new HomeTableChangeEvent().setEventType(HomeTableChangeEvent.CHANGE_TAB).setData(0));
                }
                break;

            default:
                break;
        }
    }

    /**
     * 选中所有商品
     */
    private void checkedAll() {
        if (mGoodListAdapter.getDatas() != null) {
            isAllChecked = !isAllChecked;
            mIvAllCheck.setSelected(isAllChecked);
            selectedFalse();
            double totalPrice = 0;
            if (isAllChecked) {
                for (int i = 0; i < mShoppingCartAdapter.getDatas().size(); i++) {
                    cartIds.put(String.valueOf(mShoppingCartAdapter.getDatas().get(i).getId()), i);
                    mShoppingCartAdapter.getDatas().get(i).setSelect(true);
                    totalPrice += mShoppingCartAdapter.getDatas().get(i).getPrice();
                }
                mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(totalPrice));
            } else {
                cartIds.clear();
                mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(0.00));
            }
        }
        mGoodListAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadGoodsSucces(List<LikeGoodsBean.ResultdataBean> resultdataBean) {
        mGoodListAdapter.setDataArray(resultdataBean);
        mGoodListAdapter.notifyDataSetChanged();
    }


    @Override
    public void getListSuccess(ShoppingCartListBean.ResultdataBean resultdataBeans) {
        if (page == 1) {
            mShoppingCartAdapter.setDataArray(resultdataBeans.getProducts());
        } else {
            List<ShoppingCartListBean.ResultdataBean.ProductsBean> datas = mShoppingCartAdapter.getDatas();
            datas.addAll(resultdataBeans.getProducts());
            mShoppingCartAdapter.setDataArray(datas);
        }
        mShoppingCartAdapter.notifyDataSetChanged();

        EventBus.getDefault().post(new SHopCartEvent().setEventType(SHopCartEvent.SHOPPING_CARR_NUM).setData(mShoppingCartAdapter.getDatas().size()));

        if (mShoppingCartAdapter != null && mShoppingCartAdapter.getDatas() != null) {
            mTvEntry.setText(String.format("Bill(%s)", mShoppingCartAdapter.getDatas().size()));
        } else {
            mTvEntry.setText(String.format("Bill(%s)", 0));
        }

        showEmpty();
    }

    @Override
    public void delCartSuccess() {


        RecyclerView.LayoutManager layoutManager = mRvInGoods.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            layoutManager.getChildAt(i).setSelected(false);
        }

        for (ShoppingCartListBean.ResultdataBean.ProductsBean resultdataBean : mShoppingCartAdapter.getDatas()) {
            resultdataBean.setSelect(false);
        }

        mIvAllCheck.setSelected(false);


        cartIds.clear();

        mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(0.00));

        mShoppingCartAdapter.notifyDataSetChanged();

        page = 1;
        mGetShoppingCartListPresenter.getShoppingCartList(page);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        page++;
        mGetShoppingCartListPresenter.getShoppingCartList(page);
        refreshLayout.finishLoadMore();
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        refreshLayout.finishRefresh();
        page = 1;
        mGetShoppingCartListPresenter.getShoppingCartList(page);
        mGetLikeGoodsPresenter.getLikeGoods();
    }


    public void showEmpty() {
        if (mShoppingCartAdapter != null && mShoppingCartAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, mVsEmpty);
            mTvToHome.setVisibility(View.VISIBLE);
        } else {
            mTvToHome.setVisibility(View.GONE);
            if (mVsEmpty != null) {
                mVsEmpty.setVisibility(View.GONE);
            }
        }
    }


    @Subscribe
    public void shoppingCartEvent(SHopCartEvent sHopCartEvent) {
        if (sHopCartEvent.getEventType() == SHopCartEvent.ADD_SHOPPING_CART_SUCCESS) {
            page = 1;
            mGetShoppingCartListPresenter.getShoppingCartList(page);
        }
    }


    private void selectedFalse() {
        RecyclerView.LayoutManager layoutManager = mRvInGoods.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            layoutManager.getChildAt(i).setSelected(!layoutManager.getChildAt(i).isSelected());
        }
    }

}

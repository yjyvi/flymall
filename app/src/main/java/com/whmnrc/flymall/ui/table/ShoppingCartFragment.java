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
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
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
import com.whmnrc.flymall.presener.ShopCartListIsAddPresenter;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.ui.mine.ConfirmOrderActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.GoodsCommentEvent;
import com.whmnrc.flymall.utils.evntBusBean.SHopCartEvent;
import com.whmnrc.flymall.views.AlertDialog;
import com.whmnrc.flymall.views.LoadingDialog;

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

public class ShoppingCartFragment extends LazyLoadFragment implements GetLikeGoodsPresenter.GetLikeGoodsListener, GetShoppingCartListPresenter.GetShoppingCartListListener, DelShoppingCartPresenter.DelShoppingCartListListener, OnRefreshListener, ShopCartListIsAddPresenter.AddCartItemNumListener {

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
    @BindView(R.id.common_title_back)
    RelativeLayout mCommonTitleBack;

    public ShoppingCartAdapter mShoppingCartAdapter;
    public LikeGoodListAdapter mGoodListAdapter;
    private GetLikeGoodsPresenter mGetLikeGoodsPresenter;
    private boolean isAllChecked;
    public GetShoppingCartListPresenter mGetShoppingCartListPresenter;
    private int page = 1;
    public DelShoppingCartPresenter mDelShoppingCartPresenter;
    private Map<String, Integer> delCartIds = new TreeMap<>();
    private Map<String, Integer> goToBuyCartItemIds = new TreeMap<>();
    public boolean mIsActivity;
    public ShopCartListIsAddPresenter mShopCartListIsAddPresenter;
    private LoadingDialog mLoadingDialog;
    private double totalPrice = 0.0;

    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_shopping_cart;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        delCartIds = null;
        goToBuyCartItemIds = null;
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initViewData() {
        mLoadingDialog = new LoadingDialog(getActivity());
        mLoadingDialog.show();

        mIsActivity = getArguments().getBoolean("isActivity", false);

        EventBus.getDefault().register(this);
        if (mIsActivity) {
            leftVisible(R.mipmap.back);
            mCommonTitleBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getActivity() != null) {
                        getActivity().finish();
                    }
                }
            });
        }

        setTitle("Shopping Cart");
        rightVisible("Edit");

        mRefresh.setOnRefreshListener(this);
        mRefresh.setEnableLoadMore(false);

        mGetLikeGoodsPresenter = new GetLikeGoodsPresenter(this);
        mGetShoppingCartListPresenter = new GetShoppingCartListPresenter(this);
        mShopCartListIsAddPresenter = new ShopCartListIsAddPresenter(this);
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


        mShoppingCartAdapter.setOperationShoppingCartListener(new ShoppingCartAdapter.OperationShoppingCartListener() {
            @Override
            public void delItem(int position) {
                delCartIds.put(String.valueOf(mShoppingCartAdapter.getDatas().get(position).getId()), position);
                mDelShoppingCartPresenter.delShoppingCartList(String.valueOf(mShoppingCartAdapter.getDatas().get(position).getSkuId()));
            }

            @Override
            public void selectToPrice(int position, double goodsPrice, boolean isAdd, String cartId, String cartItemId) {

                if (isAdd) {
                    delCartIds.put(cartId, position);
                    goToBuyCartItemIds.put(cartItemId, position);
                    totalPrice += goodsPrice;
                } else {
                    delCartIds.remove(cartId);
                    goToBuyCartItemIds.remove(cartItemId);
                    if (totalPrice > 0) {
                        totalPrice -= goodsPrice;
                    }
                }


                mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(totalPrice));

                changeTotalCartNum();

                if (delCartIds.size() == mShoppingCartAdapter.getDatas().size()) {
                    mIvAllCheck.setSelected(true);
                    isAllChecked = true;
                } else {
                    mIvAllCheck.setSelected(false);
                    isAllChecked = false;
                }

            }

            @Override
            public void addOrMinus(String skuId, String count) {
                mShopCartListIsAddPresenter.addCartItemNum(skuId, count);
                changeTotalCartNum();
            }
        });


    }

    private void editShopCart(boolean isSelect) {
        if (isSelect) {
            rightVisible("Complete");
            mLlMoney.setVisibility(View.GONE);
            mRlRightTitle.setSelected(true);
            mTvEntry.setText("Delete");
        } else {
            rightVisible("Edit");
            mLlMoney.setVisibility(View.VISIBLE);
            mRlRightTitle.setSelected(false);

            changeTotalCartNum();
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


    @OnClick({R.id.iv_all_check, R.id.tv_entry, R.id.tv_to_home, R.id.rl_right_title})
    public void onClick(View view) {

        if (!UserManager.getIsLogin(getActivity())) {
            return;
        }

        switch (view.getId()) {
            case R.id.rl_right_title:
                editShopCart(!mRlRightTitle.isSelected());
                break;
            case R.id.iv_all_check:
                checkedAll();
                break;
            case R.id.tv_entry:
                if (mRlRightTitle.isSelected()) {

                    if (delCartIds.size() <= 0) {
                        ToastUtils.showToast("Please select the item to be deleted");
                        return;
                    }

                    new AlertDialog(getActivity()).builder().setTitle("Warning!")
                            .setMsg("Are you sure you want to delete the goods?")
                            .setCancelable(true)
                            .setPositiveButton("confirm", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    StringBuilder cartIdSt = new StringBuilder();
                                    for (String cartId : delCartIds.keySet()) {
                                        cartIdSt.append(cartId).append(",");
                                    }

                                    String result;
                                    if (delCartIds.size() > 1) {
                                        result = cartIdSt.toString().substring(0, cartIdSt.toString().length() - 1);
                                    } else {
                                        result = cartIdSt.toString();
                                    }

                                    mDelShoppingCartPresenter.delShoppingCartList(result);
                                    editShopCart(false);
                                }
                            })
                            .setNegativeButton("cancel", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            }).show();


                } else {
                    if (goToBuyCartItemIds.size() <= 0) {
                        ToastUtils.showToast("Please select the product to be purchased");
                        return;
                    }
                    ArrayList<ConfirmBean> confirmBeans = new ArrayList<>();
                    for (int i = 0; i < mShoppingCartAdapter.getDatas().size(); i++) {
                        if (mShoppingCartAdapter.getDatas().get(i).isSelect()) {
                            ConfirmBean confirmBean = new ConfirmBean();
                            ShoppingCartListBean.ResultdataBean.ProductsBean resultdataBean = mShoppingCartAdapter.getDatas().get(i);
                            confirmBean.setGoodsPrice_Price(resultdataBean.getPrice());
                            confirmBean.setGoods_spec(resultdataBean.getColor() + resultdataBean.getSize() + resultdataBean.getVersion());
                            confirmBean.setGoods_SourcePrice(resultdataBean.getPrice());
                            confirmBean.setPriceIds(String.valueOf(resultdataBean.getCartItemId()));
                            confirmBean.setGoodsNUm(resultdataBean.getCount());
                            confirmBean.setGoods_ImaPath(resultdataBean.getImgUrl());
                            confirmBean.setGoods_Name(resultdataBean.getName());
                            confirmBean.setGoods_Describe(resultdataBean.getColor() + resultdataBean.getSize() + resultdataBean.getVersion());
                            confirmBeans.add(confirmBean);
                        }
                    }

                    if (confirmBeans.size() > 0) {
                        ConfirmOrderActivity.start(view.getContext(), confirmBeans, false);
                        page = 1;
                        mGetShoppingCartListPresenter.getShoppingCartList(page);
                    } else {
                        ToastUtils.showToast("Please select the product to be purchased");
                    }
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
        if (mShoppingCartAdapter.getDatas() != null) {
            isAllChecked = !isAllChecked;
            mIvAllCheck.setSelected(isAllChecked);
            totalPrice = 0.0;
            if (isAllChecked) {
                for (int i = 0; i < mShoppingCartAdapter.getDatas().size(); i++) {
                    ShoppingCartListBean.ResultdataBean.ProductsBean productsBean = mShoppingCartAdapter.getDatas().get(i);
                    delCartIds.put(String.valueOf(productsBean.getSkuId()), i);
                    goToBuyCartItemIds.put(String.valueOf(productsBean.getCartItemId()), i);
                    productsBean.setSelect(false);
                }


            } else {
                for (int i = 0; i < mShoppingCartAdapter.getDatas().size(); i++) {
                    ShoppingCartListBean.ResultdataBean.ProductsBean productsBean = mShoppingCartAdapter.getDatas().get(i);
                    productsBean.setSelect(true);
                }
                initCartData();
            }
        }
        changeTotalCartNum();

        mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(totalPrice));

        mShoppingCartAdapter.notifyDataSetChanged();

    }

    /**
     * 初始化显示
     */
    private void initCartData() {
        delCartIds.clear();
        goToBuyCartItemIds.clear();
        if (!mIvAllCheck.isSelected()) {
            mTvEntry.setText("Delete");
        } else {
            mTvEntry.setText(String.format("Bill(%s)", 0));
        }
    }

    @Override
    public void loadGoodsSucces(List<LikeGoodsBean.ResultdataBean> resultdataBean) {
        mGoodListAdapter.setDataArray(resultdataBean);
        mGoodListAdapter.notifyDataSetChanged();
        mLoadingDialog.dismiss();
    }


    @Override
    public void getListSuccess(ShoppingCartListBean.ResultdataBean resultdataBeans) {
        mShoppingCartAdapter.setDataArray(resultdataBeans.getProducts());
        mShoppingCartAdapter.notifyDataSetChanged();
        UserManager.getUser().setShoppingCartNum(mShoppingCartAdapter.getDatas().size());

        EventBus.getDefault().post(new SHopCartEvent().setEventType(SHopCartEvent.SHOPPING_CARR_NUM).setData(mShoppingCartAdapter.getDatas().size()));
        initCartData();
        changeTotalCartNum();
        isAllChecked = true;
        totalPrice = 0.0;
        showEmpty();
        checkedAll();
    }

    private void changeTotalCartNum() {
        if (!mRlRightTitle.isSelected()) {
            if (mShoppingCartAdapter != null && mShoppingCartAdapter.getDatas() != null) {
                int goodsNum = 0;
                for (ShoppingCartListBean.ResultdataBean.ProductsBean productsBean : mShoppingCartAdapter.getDatas()) {
                    if (productsBean.isSelect()) {
                        goodsNum += productsBean.getCount();
                    }
                }
                mTvEntry.setText(String.format("Bill(%s)", goodsNum));
            } else {
                mTvEntry.setText(String.format("Bill(%s)", 0));
            }
        }
    }

    @Override
    public void delCartSuccess() {

        UserManager.refresh();
        page = 1;
        mGetShoppingCartListPresenter.getShoppingCartList(page);

        int size = mShoppingCartAdapter.getDatas().size();
        for (int i = 0; i < size; i++) {
            ShoppingCartListBean.ResultdataBean.ProductsBean productsBean = mShoppingCartAdapter.getDatas().get(i);
            if (productsBean.isSelect()) {
                delCartIds.remove(String.valueOf(productsBean.getCartItemId()));
                goToBuyCartItemIds.remove(productsBean.getSkuId());
            }
        }


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
            EmptyListUtils.loadEmpty(true, "No shopping cart", R.mipmap.no_shopping_cart, mVsEmpty);
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


    /**
     * 选择重置
     */
    private void selectedFalse() {
        RecyclerView.LayoutManager layoutManager = mRvInGoods.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            layoutManager.getChildAt(i).setSelected(layoutManager.getChildAt(i).isSelected());
        }
    }

    @Override
    public void addSuceess() {

    }

    /**
     * 修改货币显示
     *
     * @param goodsCommentEvent
     */
    @Subscribe
    public void changePrice(GoodsCommentEvent goodsCommentEvent) {
        if (goodsCommentEvent.getEventType() == GoodsCommentEvent.CHANGE_CURRENCY) {
            mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(totalPrice));
            mShoppingCartAdapter.notifyDataSetChanged();
            mGoodListAdapter.notifyDataSetChanged();
        }
    }
}

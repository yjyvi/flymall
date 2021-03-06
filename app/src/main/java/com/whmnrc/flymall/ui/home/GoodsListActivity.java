package com.whmnrc.flymall.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.SearchGoodListAdapter;
import com.whmnrc.flymall.adapter.SearchTagListAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
import com.whmnrc.flymall.beans.SearchResultBean;
import com.whmnrc.flymall.presener.SearchGoodsListPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.ui.shop.ShoppingCartActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.evntBusBean.SHopCartEvent;
import com.whmnrc.flymall.views.FilterPop;
import com.whmnrc.flymall.views.LoadingDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class GoodsListActivity extends BaseActivity implements SearchGoodsListPresenter.SearchGoodsListener, OnRefreshLoadMoreListener {
    @BindView(R.id.rv_goods_list)
    RecyclerView mRvGoodsList;
    @BindView(R.id.rv_tga_list)
    RecyclerView mRvTgaList;
    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.tv_cart_num)
    TextView mTvCartNum;
    @BindView(R.id.ll_tab)
    LinearLayout mLlTab;
    @BindView(R.id.tv_tab_synthesize)
    TextView mTvTabSynthesize;
    @BindView(R.id.tv_tab_sales_volume)
    TextView mTvTabSalesVolume;
    @BindView(R.id.tv_tab_new)
    TextView mTvTabNew;
    @BindView(R.id.tv_tab_price)
    TextView mTvTabPrice;
    @BindView(R.id.iv_arrow)
    ImageView mIvArrow;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;


    private SearchGoodListAdapter mAdapter;
    private SearchTagListAdapter mSearchTagListAdapter;
    public SearchGoodsListPresenter mSearchGoodsListPresenter;
    private int rows = 10;
    private int page = 1;
    public Map<String, String> mCids = new TreeMap();
    public String mCid = "";
    private String aid = "";
    private String orderKey = "";
    private String orderType = "";
    private List<SearchResultBean.ResultdataBean.CategoryBean> mCategoryList;
    private LoadingDialog mLoadingDialog;
    private String mBid = "";
    public String mSearchContent;
    public int mTotalPages;

    @Override
    protected void initViewData() {

        EventBus.getDefault().register(this);

        mLoadingDialog = new LoadingDialog(this);
        mLoadingDialog.show();

        mCid = getIntent().getStringExtra("Cid");
        mBid = getIntent().getStringExtra("Bid");
        mSearchGoodsListPresenter = new SearchGoodsListPresenter(this);
        initGoodsList();
        initTgaList();

        selectedView(mTvTabSynthesize);
        mIvArrow.setSelected(false);

        mSearchGoodsListPresenter.getSearchGoodsList("", mCid, mBid, "", "", "", page, rows);

        mEtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int keyCode, KeyEvent event) {
                if (keyCode == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(getCurrentFocus()
                                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    mSearchContent = view.getText().toString().trim();

                    if (!TextUtils.isEmpty(mSearchContent)) {

                        getCids();

                        mSearchGoodsListPresenter.getSearchGoodsList(mSearchContent, mCid, mBid, aid, orderKey, orderType, page, rows);
                        return true;
                    }
                }
                return false;
            }
        });
        if (UserManager.getUser() != null) {
            updateCartNum(UserManager.getUser().getShoppingCartNum());
        } else {
            mTvCartNum.setVisibility(View.GONE);
        }

        refresh.setOnRefreshLoadMoreListener(this);
    }

    private void initGoodsList() {
        mRvGoodsList.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new SearchGoodListAdapter(this, R.layout.item_goods_list);
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


    }

    private void initTgaList() {
        mRvTgaList.setVisibility(View.GONE);
        mRvTgaList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mSearchTagListAdapter = new SearchTagListAdapter(this, R.layout.item_search_tag_list);
        mRvTgaList.setAdapter(mSearchTagListAdapter);
        mSearchTagListAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if (mCids.size() > 0) {
                    mCids.remove(mSearchTagListAdapter.getDatas().get(position).getId());
                }

                mSearchTagListAdapter.getDatas().remove(position);
                mSearchTagListAdapter.notifyDataSetChanged();
                if (mSearchTagListAdapter.getDatas().size() == 0) {
                    mRvTgaList.setVisibility(View.GONE);
                }

                mLoadingDialog.show();

                refresh.autoRefresh();

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private void getCids() {


        if (mCids.size() == 0) {
            if (TextUtils.isEmpty(mCid)) {
                mCid = "0";
            }
        } else {
            mCid = "";

            for (String cid : mCids.keySet()) {
                mCid = mCid + mCids.get(cid) + ",";
            }

            if (mCid.contains(",")) {
                mCid = mCid.substring(0, mCid.length() - 1);
            }
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_search_goods_list;
    }

    public static void start(Context context, String brandId) {
        Intent starter = new Intent(context, GoodsListActivity.class);
        starter.putExtra("Cid", brandId);
        context.startActivity(starter);
    }


    public static void startBid(Context context, String brandId) {
        Intent starter = new Intent(context, GoodsListActivity.class);
        starter.putExtra("Bid", brandId);
        context.startActivity(starter);
    }

    public void showEmpty() {
        if (mAdapter.getDatas() == null || mAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, "Can't find products", R.mipmap.no_search, mVsEmpty);
        } else {
            if (mVsEmpty != null) {
                mVsEmpty.setVisibility(View.GONE);
            }
        }
    }


    @OnClick({R.id.iv_back, R.id.ll_to_cart, R.id.tv_tab_synthesize, R.id.tv_tab_sales_volume, R.id.tv_tab_new, R.id.tab_price, R.id.iv_filter_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_to_cart:
                if (!UserManager.getIsLogin(this)) {
                    return;
                }
                ShoppingCartActivity.start(view.getContext());
                break;
            case R.id.tv_tab_synthesize:
                selectedView(mTvTabSynthesize);
                orderKey = "1";
                orderType = "1";
                updateOrderKeyData(orderKey, orderType);
                break;
            case R.id.tv_tab_sales_volume:
                selectedView(mTvTabSalesVolume);
                orderKey = "2";
                orderType = "1";
                updateOrderKeyData(orderKey, orderType);
                break;
            case R.id.tv_tab_new:
                orderKey = "3";
                orderType = "1";
                selectedView(mTvTabNew);
                updateOrderKeyData(orderKey, orderType);
                break;
            case R.id.tab_price:
                orderKey = "4";
                selectedView(mTvTabPrice);
                if (!mIvArrow.isSelected()) {
                    mIvArrow.setSelected(true);
                    orderType = "1";
                } else {
                    mIvArrow.setSelected(false);
                    orderType = "2";
                }
                updateOrderKeyData(orderKey, orderType);
                break;
            case R.id.iv_filter_layout:
                if (mCategoryList != null) {
                    FilterPop filterPop = new FilterPop();
                    filterPop.imPopWindow(this, mCategoryList);
                    filterPop.showPopupWindow(mLlTab);
                    filterPop.setOnConfirmClickListener(new FilterPop.OnConfirmClickListener() {
                        @Override
                        public void onConfirm(String selectCid, List<SearchResultBean.ResultdataBean.CategoryBean.SubCategoryBean> noNullCid) {
                            for (SearchResultBean.ResultdataBean.CategoryBean.SubCategoryBean cid : noNullCid) {
                                mCids.put(cid.getId(), cid.getId());
                            }
                            mLoadingDialog.show();
                            mSearchGoodsListPresenter.getSearchGoodsList(mSearchContent, selectCid, "", aid, orderKey, orderType, page, rows);
                            setTab(noNullCid);
                        }
                    });
                }
                break;
            default:
                break;
        }
        if (UserManager.getUser() != null) {
            mTvCartNum.setText(String.valueOf(UserManager.getUser().getShoppingCartNum()));
        } else {
            mTvCartNum.setText(String.valueOf(0));
        }
    }

    private void setTab(List<SearchResultBean.ResultdataBean.CategoryBean.SubCategoryBean> noNullCid) {
        mRvTgaList.setVisibility(View.VISIBLE);
        mSearchTagListAdapter.setDataArray(noNullCid);
        mSearchTagListAdapter.notifyDataSetChanged();
    }

    private void updateOrderKeyData(String orderKey, String orderType) {
        this.orderType = orderType;
        this.orderKey = orderKey;
        refresh.autoRefresh();
    }


    private TextView lastView;

    private void selectedView(TextView view) {
        if (lastView != null) {
            lastView.setSelected(false);
            lastView.setTextColor(ContextCompat.getColor(this, R.color.normal_gray));
        }
        if (!view.isSelected()) {
            view.setSelected(true);
            lastView = view;
            view.setTextColor(ContextCompat.getColor(this, R.color.normal_red));
        } else {
            view.setTextColor(ContextCompat.getColor(this, R.color.black));
            view.setSelected(false);
        }

    }


    @Override
    public void getSearchGoodsSuccess(SearchResultBean.ResultdataBean dataBean) {

        if (page == 1) {
            if (dataBean == null) {
                if (mAdapter.getDatas() != null) {
                    mAdapter.getDatas().clear();
                }
            } else {
                mAdapter.setDataArray(dataBean.getProductList());
                mRvGoodsList.setAdapter(mAdapter);
            }
        } else {
            List<SearchResultBean.ResultdataBean.ProductListBean> datas = mAdapter.getDatas();
            if (datas != null && dataBean != null && dataBean.getProductList() != null) {
                datas.addAll(dataBean.getProductList());
            }
            mAdapter.setDataArray(datas);
        }

        if (dataBean != null) {
            mTotalPages = dataBean.getPagingInfo().getTotalPages();
            mCategoryList = dataBean.getCategory();
        }
        mAdapter.notifyDataSetChanged();
        mLoadingDialog.dismiss();
        showEmpty();
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        refreshLayout.finishLoadMore();

        if (mTotalPages == page) {
            refreshLayout.setNoMoreData(true);
            return;
        }

        page++;
        getNewData();

    }

    /**
     * 获取新数据
     */
    private void getNewData() {
        rows = 10;
        getCids();
        mSearchGoodsListPresenter.getSearchGoodsList(mSearchContent, mCid, mBid, aid, orderKey, orderType, page, rows);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        refreshLayout.finishRefresh();
        refreshLayout.setNoMoreData(false);
        page = 1;
        getNewData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void shoppingCartEvent(SHopCartEvent sHopCartEvent) {
        if (sHopCartEvent.getEventType() == SHopCartEvent.SHOPPING_CARR_NUM) {
            updateCartNum((int) sHopCartEvent.getData());
        }
    }

    private void updateCartNum(int cartNum) {
        if (cartNum == 0) {
            mTvCartNum.setVisibility(View.GONE);
        } else {
            mTvCartNum.setVisibility(View.VISIBLE);
            mTvCartNum.setText(String.valueOf(cartNum));
        }
    }
}


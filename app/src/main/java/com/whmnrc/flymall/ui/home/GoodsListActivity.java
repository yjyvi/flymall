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

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.SearchGoodListAdapter;
import com.whmnrc.flymall.adapter.SearchTagListAdapter;
import com.whmnrc.flymall.beans.SearchResultBean;
import com.whmnrc.flymall.presener.SearchGoodsListPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.shop.ShoppingCartActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.views.FilterPop;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class GoodsListActivity extends BaseActivity implements SearchGoodsListPresenter.SearchGoodsListener {
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


    private SearchGoodListAdapter mAdapter;
    private SearchTagListAdapter mSearchTagListAdapter;
    private int currentPrice = 0;
    public SearchGoodsListPresenter mSearchGoodsListPresenter;
    private int rows = 10;
    private int page = 1;
    public String mBrandId="";

    @Override
    protected void initViewData() {

        mBrandId = getIntent().getStringExtra("brandId");
        mSearchGoodsListPresenter = new SearchGoodsListPresenter(this);
        initGoodsList();
        initTgaList();

        selectedView(mTvTabSynthesize);
        mIvArrow.setSelected(false);

        mSearchGoodsListPresenter.getSearchGoodsList("", mBrandId, "", "", "", "1", page, rows);

        mEtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int keyCode, KeyEvent event) {
                if (keyCode == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(getCurrentFocus()
                                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    String trim = view.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        mSearchGoodsListPresenter.getSearchGoodsList(view.getText().toString().trim(),  mBrandId, "", "", "", "", page, rows);
                        return true;
                    }
                }
                return false;
            }
        });
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
        mRvTgaList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mSearchTagListAdapter = new SearchTagListAdapter(this, R.layout.item_search_tag_list);
        mRvTgaList.setNestedScrollingEnabled(false);
        mRvTgaList.setFocusableInTouchMode(false);
        mRvTgaList.requestFocus();
        mSearchTagListAdapter.setDataArray(initTestData(10));
        mRvTgaList.setAdapter(mSearchTagListAdapter);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_search_goods_list;
    }

    public static void start(Context context, String brandId) {
        Intent starter = new Intent(context, GoodsListActivity.class);
        starter.putExtra("brandId", brandId);
        context.startActivity(starter);
    }

    public void showEmpty() {
        if (mAdapter != null && mAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, "暂时没有信息", R.mipmap.no_data_list, mVsEmpty);
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
                ShoppingCartActivity.start(view.getContext());
                break;
            case R.id.tv_tab_synthesize:
                selectedView(mTvTabSynthesize);
                break;
            case R.id.tv_tab_sales_volume:
                selectedView(mTvTabSalesVolume);
                break;
            case R.id.tv_tab_new:
                selectedView(mTvTabNew);
                break;
            case R.id.tab_price:
                selectedView(mTvTabPrice);
                if (!mIvArrow.isSelected()) {
                    mIvArrow.setSelected(true);
                } else {
                    mIvArrow.setSelected(false);
                }
                break;
            case R.id.iv_filter_layout:
                FilterPop filterPop = new FilterPop();
                filterPop.imPopWindow(this);
                filterPop.showPopupWindow(mLlTab);
                break;
            default:
                break;
        }
    }


    private TextView lastView;

    private void selectedView(TextView view) {
        if (lastView != null) {
            lastView.setSelected(false);
            lastView.setTextColor(ContextCompat.getColor(this, R.color.black));
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
    public void getSearchGoodsSuccess(List<SearchResultBean.ResultdataBean.ProductListBean> dataBean) {

        if (page == 1) {
            mAdapter.setDataArray(dataBean);
            mRvGoodsList.setAdapter(mAdapter);
        } else {
            List<SearchResultBean.ResultdataBean.ProductListBean> datas = mAdapter.getDatas();
            datas.addAll(dataBean);
            mAdapter.setDataArray(datas);
        }

        mAdapter.notifyDataSetChanged();

        showEmpty();
    }
}

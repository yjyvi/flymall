package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.CollectionAdapter;
import com.whmnrc.flymall.beans.CollectionListBean;
import com.whmnrc.flymall.presener.AddOrDelCollectionGoodsPresenter;
import com.whmnrc.flymall.presener.CollectionListPresenter;
import com.whmnrc.flymall.presener.MultipleDelCollectionPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.views.AlertDialog;
import com.whmnrc.flymall.views.LoadingDialog;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/23.
 */

public class CollectionActivity extends BaseActivity implements AddOrDelCollectionGoodsPresenter.AddOrDelCollectionGoodsListener, CollectionAdapter.CollectionOpertionListener, CollectionListPresenter.CollectionListListener, OnRefreshLoadMoreListener, MultipleDelCollectionPresenter.MultipleDelCollectionListener {

    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.rv_goods_list)
    RecyclerView mRvGoodsList;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    @BindView(R.id.iv_all_check)
    ImageView mIvAllCheck;

    private CollectionAdapter mCollectionAdapter;
    public AddOrDelCollectionGoodsPresenter mAddOrDelCollectionGoodsPresenter;
    public CollectionListPresenter mCollectionListPresenter;
    private int page = 1;
    private CollectionListBean.ResultdataBean mDelGoodsBean;
    private Map<String, Integer> collections = new TreeMap<>();
    private boolean isAllChecked;
    public MultipleDelCollectionPresenter mMultipleDelCollectionPresenter;
    private boolean isPageMax;
    private LoadingDialog mLoadingDialog;

    @Override
    protected void initViewData() {
        setTitle("My favorite");
        mLoadingDialog = new LoadingDialog(this);
        mLoadingDialog.show();
        mMultipleDelCollectionPresenter = new MultipleDelCollectionPresenter(this);
        mAddOrDelCollectionGoodsPresenter = new AddOrDelCollectionGoodsPresenter(this);
        mCollectionListPresenter = new CollectionListPresenter(this);
        mCollectionListPresenter.getCollectionList(1, page);
        mRvGoodsList.setLayoutManager(new LinearLayoutManager(this));
        mCollectionAdapter = new CollectionAdapter(this, R.layout.item_collection_list);
        mRvGoodsList.setAdapter(mCollectionAdapter);
        mRefresh.setOnRefreshLoadMoreListener(this);

        mCollectionAdapter.setCollectionOpertionListener(this);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_collection;
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, CollectionActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void addCollectionSuccess() {

    }


    @Override
    public void delCollectionSuccess() {
        if (mDelGoodsBean != null) {
            mCollectionAdapter.getDatas().remove(mDelGoodsBean);
            showEmpty();
        } else {
            page = 1;
            mCollectionListPresenter.getCollectionList(1, page);
            checkedAll();
        }
        mRefresh.autoRefresh();
    }


    @OnClick({R.id.iv_all_check, R.id.tv_entry})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_all_check:
                checkedAll();
                break;
            case R.id.tv_entry:
                if (collections.size() <= 0) {
                    ToastUtils.showToast("Please select the item to be deleted");
                    return;
                }
                StringBuilder cartIdSt = new StringBuilder();
                for (String cartId : collections.keySet()) {
                    cartIdSt.append(cartId).append(",");
                }
                String result;
                if (collections.size() > 1) {
                    result = cartIdSt.toString().substring(0, cartIdSt.toString().length() - 1);
                } else {
                    result = cartIdSt.toString();
                }

                isCancelCollection(result, false);
                break;
            default:
                break;
        }
    }

    /**
     * 选中所有商品
     */
    private void checkedAll() {
        if (mCollectionAdapter.getDatas() != null) {
            isAllChecked = !isAllChecked;
            RecyclerView.LayoutManager layoutManager = mRvGoodsList.getLayoutManager();
            int childCount = layoutManager.getChildCount();
            for (int i = 0; i < childCount; i++) {
                layoutManager.getChildAt(i).setSelected(!layoutManager.getChildAt(i).isSelected());
            }
            mIvAllCheck.setSelected(isAllChecked);
            if (isAllChecked) {
                for (int i = 0; i < mCollectionAdapter.getDatas().size(); i++) {
                    collections.put(String.valueOf(mCollectionAdapter.getDatas().get(i).getId()), i);
                }
            } else {
                collections.clear();
            }
        }
        mCollectionAdapter.notifyDataSetChanged();
    }

    @Override
    public void delCollection(final CollectionListBean.ResultdataBean good) {
        mDelGoodsBean = good;
        isCancelCollection(String.valueOf(good.getId()), true);
    }

    private void isCancelCollection(final String collectionId, final boolean isOne) {
        new AlertDialog(this).builder().setTitle("Warning!")
                .setMsg("Are you sure you want to delete the collection goods?")
                .setCancelable(true)
                .setPositiveButton("confirm", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isOne) {
                            mAddOrDelCollectionGoodsPresenter.delCollection(collectionId);
                        } else {
                            mMultipleDelCollectionPresenter.multipleDelCollection(collectionId);
                        }
                    }
                })
                .setNegativeButton("cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
    }

    @Override
    public void selectCollection(int position, boolean isSelect, String collectionId) {
        if (isSelect) {
            collections.put(collectionId, position);
        } else {
            collections.remove(collectionId);
        }

        if (collections.size() == mCollectionAdapter.getDatas().size()) {
            mIvAllCheck.setSelected(true);
            isAllChecked = true;
        } else {
            mIvAllCheck.setSelected(false);
            isAllChecked = false;
        }
    }


    public void showEmpty() {
        if (mCollectionAdapter != null && mCollectionAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, "No Collections", R.mipmap.no_search, mVsEmpty);
        } else {
            mVsEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void getCollectionListSuccess(List<CollectionListBean.ResultdataBean> resultdataBeanList) {
        if (page == 1) {
            mCollectionAdapter.setDataArray(resultdataBeanList);
        } else {
            List<CollectionListBean.ResultdataBean> datas = mCollectionAdapter.getDatas();
            datas.addAll(resultdataBeanList);
            mCollectionAdapter.setDataArray(datas);
        }
        if (resultdataBeanList == null) {
            isPageMax = true;
        } else {
            isPageMax = false;
        }
        mCollectionAdapter.notifyDataSetChanged();

        showEmpty();

        mLoadingDialog.dismiss();
    }



    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        refreshLayout.finishLoadMore();
        if (isPageMax) {
            mRefresh.setNoMoreData(true);
            return;
        }
        page++;
        mCollectionListPresenter.getCollectionList(1, page);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        page = 1;
        mRefresh.setNoMoreData(false);
        mCollectionListPresenter.getCollectionList(1, page);
        refreshLayout.finishRefresh();
    }

    @Override
    public void delMultipleCollectionSuccess() {
        mRefresh.autoRefresh();
    }
}

package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.GoodListAdapter;
import com.whmnrc.flymall.beans.CollectionListBean;
import com.whmnrc.flymall.beans.GoodsListBean;
import com.whmnrc.flymall.presener.CollectionListPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;

import java.util.List;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class BrowsingHistoryActivity extends BaseActivity implements CollectionListPresenter.CollectionListListener {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.rv_browsing_history_list)
    RecyclerView mRvBrowsingHistoryList;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    private GoodListAdapter mAdapter;
    public CollectionListPresenter mCollectionListPresenter;
    private int page = 1;

    @Override
    protected void initViewData() {
        mCollectionListPresenter = new CollectionListPresenter(this);
        mCollectionListPresenter.getCollectionList(2, page);
        setTitle("Browsing history");
        mRvBrowsingHistoryList.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new GoodListAdapter(this, R.layout.item_goods_list);
        mRvBrowsingHistoryList.addItemDecoration(new RecyclerView.ItemDecoration() {
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
        mRvBrowsingHistoryList.setNestedScrollingEnabled(false);


        mRvBrowsingHistoryList.setAdapter(mAdapter);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, BrowsingHistoryActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_browsing_history;
    }

    @Override
    public void getCollectionListSuccess(List<CollectionListBean.ResultdataBean> resultdataBeanList) {

    }

    @Override
    public void getHistoryListSuccess(List<GoodsListBean.ResultdataBean> resultdataBeanList) {
        if (page == 1) {
            mAdapter.setDataArray(resultdataBeanList);
        } else {
            List<GoodsListBean.ResultdataBean> datas = mAdapter.getDatas();
            datas.addAll(resultdataBeanList);
            mAdapter.setDataArray(datas);
        }
        mAdapter.notifyDataSetChanged();
    }


    public void showEmpty() {
        if (mAdapter != null && mAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, mVsEmpty);
        } else {
            mVsEmpty.setVisibility(View.GONE);
        }
    }
}

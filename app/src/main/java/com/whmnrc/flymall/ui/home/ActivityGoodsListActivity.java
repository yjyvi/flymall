package com.whmnrc.flymall.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.HomeActivityGoodListAdapter;
import com.whmnrc.flymall.beans.ActivityGoodsListBean;
import com.whmnrc.flymall.beans.CollectionListBean;
import com.whmnrc.flymall.beans.GoodsListBean;
import com.whmnrc.flymall.presener.CollectionListPresenter;
import com.whmnrc.flymall.presener.HomePageActivityListGoodsPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;

import java.util.List;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class ActivityGoodsListActivity extends BaseActivity implements CollectionListPresenter.CollectionListListener, HomePageActivityListGoodsPresenter.HomeActivityGoodsListListener, OnRefreshListener {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.rv_browsing_history_list)
    RecyclerView mRvBrowsingHistoryList;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    private HomeActivityGoodListAdapter mAdapter;
    public CollectionListPresenter mCollectionListPresenter;
    private int page = 1;
    public String mTopActivityId;
    public HomePageActivityListGoodsPresenter mHomePageActivityListGoodsPresenter;

    @Override
    protected void initViewData() {
        mRefresh.setEnableLoadMore(true);
        mRefresh.setOnRefreshListener(this);
        mHomePageActivityListGoodsPresenter = new HomePageActivityListGoodsPresenter(this);

        mTopActivityId = getIntent().getStringExtra("topActivityId");
        mHomePageActivityListGoodsPresenter.getHomePageActivityGoodsList(mTopActivityId);
        setTitle("ActivityGoods");

        mRvBrowsingHistoryList.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new HomeActivityGoodListAdapter(this, R.layout.item_goods_list);
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

    public static void start(Context context, String topActivityId) {
        Intent starter = new Intent(context, ActivityGoodsListActivity.class);
        starter.putExtra("topActivityId", topActivityId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_home_activity_goods_list;
    }

    @Override
    public void getCollectionListSuccess(List<CollectionListBean.ResultdataBean> resultdataBeanList) {

    }

    @Override
    public void getHistoryListSuccess(List<GoodsListBean.ResultdataBean> resultdataBeanList) {

    }


    public void showEmpty() {
        if (mAdapter != null && mAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, mVsEmpty);
        } else {
            mVsEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void loadActivityGoodsSuccess(ActivityGoodsListBean.ResultdataBean resultdataBean) {
        if (resultdataBean.getTopicModuleInfo() != null && resultdataBean.getTopicModuleInfo().get(0) != null) {
            mAdapter.setDataArray(resultdataBean.getTopicModuleInfo().get(0).getModuleProductInfo());
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        mHomePageActivityListGoodsPresenter.getHomePageActivityGoodsList(mTopActivityId);
    }
}

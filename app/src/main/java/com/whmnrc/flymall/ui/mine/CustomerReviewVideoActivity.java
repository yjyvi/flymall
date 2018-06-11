package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.VideoGoodsListAdapter;
import com.whmnrc.flymall.beans.AllVideoBean;
import com.whmnrc.flymall.presener.AllVideoPresenter;
import com.whmnrc.flymall.ui.BaseActivity;

import java.util.List;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/5/21.
 */

public class CustomerReviewVideoActivity extends BaseActivity implements AllVideoPresenter.AllVideoListener, OnRefreshLoadMoreListener {

    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    private VideoGoodsListAdapter mVideoGoodsListAdapter;
    public AllVideoPresenter mAllVideoPresenter;
    private int page = 1;
    private int rows = 10;


    @Override
    protected int setLayoutId() {
        return R.layout.activity_customer_review_video;
    }


    @Override
    protected void initViewData() {
        setTitle("Customer Review Video");

        mAllVideoPresenter = new AllVideoPresenter(this);
        mAllVideoPresenter.getAllVideo(page, rows);

        mRvList.setLayoutManager(new GridLayoutManager(this, 2));
        mVideoGoodsListAdapter = new VideoGoodsListAdapter(this, R.layout.item_video_goods_list);
        mRvList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int childLayoutPosition = parent.getChildLayoutPosition(view);
                if (childLayoutPosition % 2 == 0) {
                    outRect.right = getResources().getDimensionPixelOffset(R.dimen.dm_5);
                } else {
                    outRect.left = getResources().getDimensionPixelOffset(R.dimen.dm_5);
                }
                outRect.bottom = getResources().getDimensionPixelOffset(R.dimen.dm_10);
            }
        });
        mRvList.setAdapter(mVideoGoodsListAdapter);
        mRefresh.setOnRefreshLoadMoreListener(this);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, CustomerReviewVideoActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void loadSuccess(AllVideoBean allVideoBean) {
        if (page == 1) {
            mVideoGoodsListAdapter.setDataArray(allVideoBean.getResultdata());
        } else {
            List<AllVideoBean.ResultdataBean> datas = mVideoGoodsListAdapter.getDatas();
            datas.addAll(allVideoBean.getResultdata());
            mVideoGoodsListAdapter.setDataArray(datas);
        }
        mVideoGoodsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        page++;
        mAllVideoPresenter.getAllVideo(page, rows);
        refreshLayout.finishLoadMore();
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        page = 1;
        mAllVideoPresenter.getAllVideo(page, rows);
        refreshLayout.finishRefresh();
    }
}

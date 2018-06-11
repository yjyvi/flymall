package com.whmnrc.flymall.ui.home.gooddetailsfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.GoodsCommentAdapter;
import com.whmnrc.flymall.beans.GoodsEvaluateListBean;
import com.whmnrc.flymall.presener.EvaluateListPresenter;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.utils.EmptyListUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/21.
 */

public class GoodsEvaluationFragment extends LazyLoadFragment implements EvaluateListPresenter.EvaluateListListener {

    @BindView(R.id.rv_evaluation_list)
    RecyclerView mRvEvaluationList;

    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;

    @BindView(R.id.tv_type_all)
    TextView mTvTypeAll;
    @BindView(R.id.tv_type_praise)
    TextView mTvTypePraise;
    @BindView(R.id.tv_average)
    TextView mTvAverage;
    @BindView(R.id.tv_bad_review)
    TextView mTvBadReview;
    @BindView(R.id.tv_images)
    TextView mTvImages;
    @BindView(R.id.refresh_like)
    SmartRefreshLayout mRefreshLike;


    private GoodsCommentAdapter mGoodsCommentAdapter;
    public String mGoodsId;
    public EvaluateListPresenter mEvaluateListPresenter;
    private int page = 1;
    private int rows = 10;
    private int mEvaluationType = 1;

    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_goods_evaluation;
    }

    @Override
    protected void initViewData() {
        mEvaluateListPresenter = new EvaluateListPresenter(this);
        mRvEvaluationList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mGoodsCommentAdapter = new GoodsCommentAdapter(getActivity(), R.layout.item_goods_comment);
        mGoodsId = getArguments().getString("goodsId");

        mRvEvaluationList.setAdapter(mGoodsCommentAdapter);
        selectedView(mTvTypeAll);
    }

    public static GoodsEvaluationFragment newInstance(String goodsId) {
        Bundle args = new Bundle();
        GoodsEvaluationFragment fragment = new GoodsEvaluationFragment();
        args.putString("goodsId", goodsId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void getEvaluateListSuccess(List<GoodsEvaluateListBean.ResultdataBean> resultdataBean) {
        mGoodsCommentAdapter.setDataArray(resultdataBean);
        mGoodsCommentAdapter.notifyDataSetChanged();
        showEmpty();
    }


    public void showEmpty() {
        if (mGoodsCommentAdapter != null && mGoodsCommentAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, mVsEmpty);
        } else {
            mVsEmpty.setVisibility(View.GONE);
        }
    }


    @OnClick({R.id.tv_type_all, R.id.tv_type_praise, R.id.tv_average, R.id.tv_bad_review, R.id.tv_images})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_type_all:
                mEvaluationType = 1;
                selectedView(mTvTypeAll);
                break;
            case R.id.tv_type_praise:
                mEvaluationType = 2;
                selectedView(mTvTypePraise);
                break;
            case R.id.tv_average:
                mEvaluationType = 3;
                selectedView(mTvAverage);
                break;
            case R.id.tv_bad_review:
                mEvaluationType = 4;
                selectedView(mTvBadReview);
                break;
            case R.id.tv_images:
                mEvaluationType = 5;
                selectedView(mTvImages);
                break;
            default:
                break;
        }
    }


    private View lastView;

    private void selectedView(View view) {
        if (lastView != null) {
            lastView.setSelected(false);
        }
        if (!view.isSelected()) {
            view.setSelected(true);
            lastView = view;
        } else {
            view.setSelected(false);
        }
        mEvaluateListPresenter.getEvaluateList(mGoodsId, page, rows, mEvaluationType);
    }
}

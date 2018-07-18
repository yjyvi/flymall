package com.whmnrc.flymall.ui.home.gooddetailsfragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.GoodsCommentAdapter;
import com.whmnrc.flymall.beans.GoodsEvaluateListBean;
import com.whmnrc.flymall.presener.EvaluateListPresenter;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.evntBusBean.GoodsCommentEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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
    @BindView(R.id.nsv_layout)
    NestedScrollView mNestedScrollView;


    private GoodsCommentAdapter mGoodsCommentAdapter;
    public String mGoodsId;
    public EvaluateListPresenter mEvaluateListPresenter;
    private int page = 1;
    private int rows = 10;
    private int mEvaluationType = 0;
    private int mSrollY = 0;


    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_goods_evaluation;
    }

    @Override
    protected void initViewData() {
        EventBus.getDefault().register(this);

        mEvaluateListPresenter = new EvaluateListPresenter(this);
        mRvEvaluationList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvEvaluationList.setNestedScrollingEnabled(false);
        mGoodsCommentAdapter = new GoodsCommentAdapter(getActivity(), R.layout.item_goods_comment);

        if (getArguments() != null) {
            mGoodsId = getArguments().getString("goodsId");
        }

        mRvEvaluationList.setAdapter(mGoodsCommentAdapter);
        selectedView(mTvTypeAll);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mNestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    mSrollY = scrollY;
                }
            });

            mNestedScrollView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_UP:
                            if (mSrollY == 0) {
                                EventBus.getDefault().post(new GoodsCommentEvent().setEventType(GoodsCommentEvent.CHANGE_TO_TOP));
                            }
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });
        }
    }

    public static GoodsEvaluationFragment newInstance(String goodsId) {
        Bundle args = new Bundle();
        GoodsEvaluationFragment fragment = new GoodsEvaluationFragment();
        args.putString("goodsId", goodsId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void getEvaluateListSuccess(GoodsEvaluateListBean.ResultdataBean resultdataBean) {
        if (resultdataBean != null) {
            mGoodsCommentAdapter.setDataArray(resultdataBean.getModels());
            mGoodsCommentAdapter.notifyDataSetChanged();
        }
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
                mEvaluationType = 0;
                selectedView(mTvTypeAll);
                break;
            case R.id.tv_type_praise:
                mEvaluationType = 1;
                selectedView(mTvTypePraise);
                break;
            case R.id.tv_average:
                mEvaluationType = 2;
                selectedView(mTvAverage);
                break;
            case R.id.tv_bad_review:
                mEvaluationType = 3;
                selectedView(mTvBadReview);
                break;
            case R.id.tv_images:
                mEvaluationType = 4;
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


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void changeToComment(GoodsCommentEvent goodsCommentEvent) {
        if (goodsCommentEvent.getEventType() == GoodsCommentEvent.CHANGE_TO_COMMENT) {
            mRvEvaluationList.scrollToPosition(0);
        }
    }
}

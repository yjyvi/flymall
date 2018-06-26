package com.whmnrc.flymall.ui.table;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.LikeGoodListAdapter;
import com.whmnrc.flymall.beans.LikeGoodsBean;
import com.whmnrc.flymall.eventbus.HomeTableChangeEvent;
import com.whmnrc.flymall.presener.GetLikeGoodsPresenter;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.ui.mine.AddressManagerActivity;
import com.whmnrc.flymall.ui.mine.BrowsingHistoryActivity;
import com.whmnrc.flymall.ui.mine.CollectionActivity;
import com.whmnrc.flymall.ui.mine.CouponsActivity;
import com.whmnrc.flymall.ui.mine.CurrencyActivity;
import com.whmnrc.flymall.ui.mine.CustomerReviewVideoActivity;
import com.whmnrc.flymall.ui.mine.OrderListActivity;
import com.whmnrc.flymall.ui.mine.PersonalInformationActivity;
import com.whmnrc.flymall.ui.mine.SettingActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.UIUtils;
import com.whmnrc.flymall.utils.evntBusBean.GoodsCommentEvent;
import com.whmnrc.flymall.utils.evntBusBean.UserInfoEvent;
import com.whmnrc.flymall.views.LoadingDialog;
import com.whmnrc.mylibrary.utils.GlideUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yjyvi on 2018/1/30.
 */

public class MineFragment extends LazyLoadFragment implements GetLikeGoodsPresenter.GetLikeGoodsListener, OnRefreshListener {

    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.rv_goods_list)
    RecyclerView mRvList;
    @BindView(R.id.iv_setting)
    ImageView iv_setting;
    @BindView(R.id.iv_cart)
    ImageView iv_cart;
    @BindView(R.id.iv_user_img)
    ImageView mIvUserImg;
    @BindView(R.id.tv_user_name)
    TextView mTvUserName;
    @BindView(R.id.tv_coupons)
    TextView mTvCoupons;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;

    private LikeGoodListAdapter mAdapter;
    public GetLikeGoodsPresenter mGetLikeGoodsPresenter;
    private LoadingDialog mLoadingDialog;

    /**
     * 初始化实例
     */
    public static MineFragment newInstance() {
        Bundle bundle = new Bundle();
        MineFragment mineFragment = new MineFragment();
        mineFragment.setArguments(bundle);
        return mineFragment;
    }

    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViewData() {
        mLoadingDialog = new LoadingDialog(getActivity());
        mLoadingDialog.show();
        mGetLikeGoodsPresenter = new GetLikeGoodsPresenter(this);
        mGetLikeGoodsPresenter.getLikeGoods();

        mRvList.setNestedScrollingEnabled(false);
        mRvList.setFocusableInTouchMode(false);
        mRvList.requestFocus();

        EventBus.getDefault().register(this);

        mRvList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new LikeGoodListAdapter(getActivity(), R.layout.item_goods_list);
        mRvList.addItemDecoration(new RecyclerView.ItemDecoration() {
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


        mRvList.setAdapter(mAdapter);

        mRefresh.setOnRefreshListener(this);


        if (UserManager.isLogin()) {
            mTvUserName.setText(UserManager.getUser().getNick());
            mTvCoupons.setText(String.format("%s Coupons", UserManager.getUser().getCouponNum()));
            UIUtils.loadCircleImg(mIvUserImg, UserManager.getUser().getPhoto());
        }


    }


    public void showEmpty() {
        if (mAdapter != null && mAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, mVsEmpty);
        } else {
            if (mVsEmpty != null) {
                mVsEmpty.setVisibility(View.GONE);
            }
        }
    }


    @OnClick({
            R.id.iv_setting, R.id.iv_cart, R.id.ll_date_edit,
            R.id.tv_more, R.id.tv_order_unpaid, R.id.tv_order_un_shipped,
            R.id.tv_order_receipt, R.id.tv_currency, R.id.tv_address,
            R.id.tv_record, R.id.tv_collection, R.id.tv_video, R.id.tv_coupons
    })
    public void onClick(View view) {

        if (!UserManager.getIsLogin(getActivity())) {
            return;
        }

        switch (view.getId()) {
            case R.id.iv_setting:
                SettingActivity.start(view.getContext());
                break;
            case R.id.iv_cart:
                EventBus.getDefault().post(new HomeTableChangeEvent().setEventType(HomeTableChangeEvent.CHANGE_TAB).setData(2));
                break;
            case R.id.ll_date_edit:
                PersonalInformationActivity.start(view.getContext());
                break;
            case R.id.tv_more:
                OrderListActivity.start(view.getContext(), 3);
                break;
            case R.id.tv_order_unpaid:
                OrderListActivity.start(view.getContext(), 0);
                break;
            case R.id.tv_order_un_shipped:
                OrderListActivity.start(view.getContext(), 1);
                break;
            case R.id.tv_order_receipt:
                OrderListActivity.start(view.getContext(), 2);
                break;
            case R.id.tv_currency:
                CurrencyActivity.start(view.getContext());
                break;
            case R.id.tv_address:
                AddressManagerActivity.start(view.getContext());
                break;
            case R.id.tv_record:
                BrowsingHistoryActivity.start(view.getContext());
                break;
            case R.id.tv_collection:
                CollectionActivity.start(view.getContext());
                break;
            case R.id.tv_video:
                CustomerReviewVideoActivity.start(view.getContext());
                break;
            case R.id.tv_coupons:
                CouponsActivity.start(view.getContext());
                break;
            default:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void tabChangeEvent(HomeTableChangeEvent homeTableChangeEvent) {

    }

    @Subscribe
    public void userUpdateEvent(UserInfoEvent userInfoEvent) {
        if (userInfoEvent.getEventType() == UserInfoEvent.UPDATE_USER_INFO) {
            mTvUserName.setText(UserManager.getUser().getNick());
            GlideUtils.LoadCircleImage(getActivity(), UserManager.getUser().getPhoto(), mIvUserImg);
            mTvCoupons.setText(String.format("%s Coupons", UserManager.getUser().getCouponNum()));
        }
    }

    /**
     * 修改货币显示
     *
     * @param goodsCommentEvent
     */
    @Subscribe
    public void changePrice(GoodsCommentEvent goodsCommentEvent) {
        if (goodsCommentEvent.getEventType() == GoodsCommentEvent.CHANGE_CURRENCY) {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void loadGoodsSucces(List<LikeGoodsBean.ResultdataBean> resultdataBean) {
        mAdapter.setDataArray(resultdataBean);
        mAdapter.notifyDataSetChanged();
        showEmpty();
        mLoadingDialog.dismiss();
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        mGetLikeGoodsPresenter.getLikeGoods();
        UserManager.refresh();
        refreshLayout.finishRefresh();
    }
}

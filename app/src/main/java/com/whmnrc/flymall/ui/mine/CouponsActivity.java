package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.CouponsAdapter;
import com.whmnrc.flymall.beans.CouponBean;
import com.whmnrc.flymall.presener.CouponListPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.evntBusBean.CouponsEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class CouponsActivity extends BaseActivity implements CouponListPresenter.CouponListListener {

    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.rv_coupons_list)
    RecyclerView mRvCouponsList;
    //    @BindView(R.id.refresh)
//    SmartRefreshLayout mRefresh;
    private CouponsAdapter mCouponsAdapter;
    public CouponListPresenter mCouponListPresenter;
    private int page = 1;
    private int rows = 10;
    public boolean mIsSelect;

    @Override
    protected void initViewData() {
        setTitle("Coupon");
        EventBus.getDefault().register(this);
        mCouponListPresenter = new CouponListPresenter(this);
        mCouponListPresenter.getCouponList(page, rows);
        mRvCouponsList.setLayoutManager(new LinearLayoutManager(this));
        mCouponsAdapter = new CouponsAdapter(this, R.layout.item_coupons);
        mRvCouponsList.setAdapter(mCouponsAdapter);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_coupons;
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, CouponsActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void getCouponListSuccess(List<CouponBean.ResultdataBean> resultdataBeans) {
        mCouponsAdapter.setDataArray(resultdataBeans);
        mCouponsAdapter.notifyDataSetChanged();
        showEmpty();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe
    public void selectCouponsEvent(CouponsEvent couponsEvent) {

    }


    public void showEmpty() {
        if (mCouponsAdapter != null && mCouponsAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, "No coupon", R.mipmap.no_coupon, mVsEmpty);
        } else {
            if (mVsEmpty != null) {
                mVsEmpty.setVisibility(View.GONE);
            }
        }
    }

}

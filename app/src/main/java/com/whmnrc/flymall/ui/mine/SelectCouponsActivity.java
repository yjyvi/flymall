package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.CouponsAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
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

public class SelectCouponsActivity extends BaseActivity implements CouponListPresenter.CouponListListener {

    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.rv_coupons_list)
    RecyclerView mRvCouponsList;
    private CouponsAdapter mCouponsAdapter;
    public CouponListPresenter mCouponListPresenter;

    @Override
    protected void initViewData() {
        setTitle("Select Coupon");

        String money = getIntent().getStringExtra("money");

        EventBus.getDefault().register(this);
        mCouponListPresenter = new CouponListPresenter(this);
        mCouponListPresenter.getSomeCouponList(money);
        mRvCouponsList.setLayoutManager(new LinearLayoutManager(this));
        mCouponsAdapter = new CouponsAdapter(this, R.layout.item_coupons);
        mRvCouponsList.setAdapter(mCouponsAdapter);

        mCouponsAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                selectedView(view);
                EventBus.getDefault().post(new CouponsEvent().setEventType(CouponsEvent.SELECT_COUPONS).setData(mCouponsAdapter.getDatas().get(position)));
                finish();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

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

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_coupons;
    }


    public static void start(Context context, String money) {
        Intent starter = new Intent(context, SelectCouponsActivity.class);
        starter.putExtra("money", money);
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
            EmptyListUtils.loadEmpty(true, mVsEmpty);
        } else {
            if (mVsEmpty != null) {
                mVsEmpty.setVisibility(View.GONE);
            }
        }
    }
}

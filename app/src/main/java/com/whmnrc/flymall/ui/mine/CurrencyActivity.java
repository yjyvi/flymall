package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.CurrencyAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
import com.whmnrc.flymall.beans.AllCurrencyBean;
import com.whmnrc.flymall.presener.GetAllCurrencyPresenter;
import com.whmnrc.flymall.presener.UpdateDefaultCurrencyPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.SPUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.GoodsCommentEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class CurrencyActivity extends BaseActivity implements GetAllCurrencyPresenter.GetAllCurrencyListener, UpdateDefaultCurrencyPresenter.UpdateDefaultCurrencyListener, OnRefreshListener {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.rv_currency_list)
    RecyclerView mRvCurrencyList;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    private CurrencyAdapter mCurrencyAdapter;
    private GetAllCurrencyPresenter mGetAllCurrencyPresenter;
    public UpdateDefaultCurrencyPresenter mUpdateDefaultCurrencyPresenter;
    public String mCurrencyId;
    private String  mCurrencyPrice;
    private String mCurrencyCode;

    @Override
    protected void initViewData() {
        setTitle("Currency conversion");
        mRefresh.setOnRefreshListener(this);

        mGetAllCurrencyPresenter = new GetAllCurrencyPresenter(this);
        mUpdateDefaultCurrencyPresenter = new UpdateDefaultCurrencyPresenter(this);
        mGetAllCurrencyPresenter.getAllCurrency();
        mRvCurrencyList.setLayoutManager(new GridLayoutManager(this, 3));
        mCurrencyAdapter = new CurrencyAdapter(this, R.layout.item_currency);
        mRvCurrencyList.setAdapter(mCurrencyAdapter);
        mCurrencyAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                selectedView(view);
                mCurrencyId = mCurrencyAdapter.getDatas().get(position).getCurrency_ID();
                mCurrencyPrice = String.valueOf(mCurrencyAdapter.getDatas().get(position).getCurrency_Price());
                mCurrencyCode = mCurrencyAdapter.getDatas().get(position).getCode();
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
        return R.layout.activity_currency;
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, CurrencyActivity.class);
        context.startActivity(starter);
    }

    @OnClick(R.id.tv_save)
    public void onClick() {
        if (TextUtils.isEmpty(mCurrencyId)) {
            ToastUtils.showToast("Please Select Currency");
            return;
        }
        mUpdateDefaultCurrencyPresenter.updateDefaultCurrency(mCurrencyId);
    }

    @Override
    public void loadSuccess(List<AllCurrencyBean.ResultdataBean> resultdataBean) {
        mCurrencyAdapter.setDataArray(resultdataBean);
        mCurrencyAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateSuccess(String msg) {
        ToastUtils.showToast(msg);
        SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.CURRENT_CURRENCY, mCurrencyPrice);
        SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.CURRENT_CURRENCY_CODE, mCurrencyCode);
        EventBus.getDefault().post(new GoodsCommentEvent().setEventType(GoodsCommentEvent.CHANGE_CURRENCY));
        finish();
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        mGetAllCurrencyPresenter.getAllCurrency();
        refreshLayout.finishRefresh();
    }
}

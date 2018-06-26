package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.AddressManagerAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
import com.whmnrc.flymall.beans.AddressBean;
import com.whmnrc.flymall.presener.AddressEditPresenter;
import com.whmnrc.flymall.presener.AddressListPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.evntBusBean.AddressEvent;
import com.whmnrc.flymall.views.AlertDialog;
import com.whmnrc.flymall.views.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class AddressManagerActivity extends BaseActivity implements AddressListPresenter.AddressListListener, AddressEditPresenter.AddressEditListener, OnRefreshListener {

    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.rv_address_list)
    RecyclerView mRvAddressList;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    public AddressManagerAdapter mAddressManagerAdapter;
    public AddressListPresenter mAddressListPresenter;
    public AddressEditPresenter mAddressEditPresenter;
    public boolean mIsSelect;
    private LoadingDialog mLoadingDialog;
    private String mAddressId = "";


    @Override
    protected void back() {
        if (mIsSelect) {
            EventBus.getDefault().post(new AddressEvent().setEventType(AddressEvent.ADD_ADDRESS_SUCCESS));
        }
        super.back();

    }

    @Override
    protected void initViewData() {
        mLoadingDialog = new LoadingDialog(this);
        mLoadingDialog.show();
        EventBus.getDefault().register(this);
        mIsSelect = getIntent().getBooleanExtra("isSelect", false);
        mAddressId = getIntent().getStringExtra("addressId");
        if (mIsSelect) {
            setTitle("Select address");
        } else {
            setTitle("Shipping address");
        }
        mAddressListPresenter = new AddressListPresenter(this);
        mAddressListPresenter.getAddressList();

        mAddressEditPresenter = new AddressEditPresenter(this);
        mRvAddressList.setLayoutManager(new LinearLayoutManager(this));
        mAddressManagerAdapter = new AddressManagerAdapter(this, R.layout.item_address, mIsSelect);
        mRvAddressList.setAdapter(mAddressManagerAdapter);

        mAddressManagerAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if (mIsSelect) {
                    for (AddressBean.ResultdataBean resultdataBean : mAddressManagerAdapter.getDatas()) {
                        resultdataBean.setSelect(false);
                    }
                    mAddressManagerAdapter.getDatas().get(position).setSelect(true);
                    mAddressManagerAdapter.notifyDataSetChanged();
                    AddressBean.ResultdataBean resultdataBean = mAddressManagerAdapter.getDatas().get(position);
                    EventBus.getDefault().post(new AddressEvent().setEventType(AddressEvent.ORDER_SELECT_ADDRESS).setData(resultdataBean));
                    finish();
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, final int position) {
                new AlertDialog(view.getContext()).builder().setTitle("Warning!")
                        .setMsg("Are you sure you want to delete the address?")
                        .setCancelable(true)
                        .setPositiveButton("agree", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mAddressEditPresenter.delAddress(String.valueOf(mAddressManagerAdapter.getDatas().get(position).getId()));
                            }
                        })
                        .setNegativeButton("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).show();
                return true;
            }
        });

        mRefresh.setOnRefreshListener(this);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_address_manager;
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, AddressManagerActivity.class);
        context.startActivity(starter);
    }

    public static void start(Context context, boolean isSelect) {
        Intent starter = new Intent(context, AddressManagerActivity.class);
        starter.putExtra("isSelect", isSelect);
        context.startActivity(starter);
    }

    public static void start(Context context, boolean isSelect, String addressId) {
        Intent starter = new Intent(context, AddressManagerActivity.class);
        starter.putExtra("isSelect", isSelect);
        starter.putExtra("addressId", addressId);
        context.startActivity(starter);
    }


    @OnClick(R.id.tv_commit)
    public void onClick() {
        AddAddressActivity.start(this, "", mAddressManagerAdapter.getDatas().size());
    }

    @Override
    public void getListSuccess(List<AddressBean.ResultdataBean> resultdataBeans) {
        if (mIsSelect) {
            for (AddressBean.ResultdataBean resultdataBean : resultdataBeans) {
                if (TextUtils.equals(String.valueOf(resultdataBean.getId()), mAddressId)) {
                    resultdataBean.setSelect(true);
                }
            }
        }
        mAddressManagerAdapter.setDataArray(resultdataBeans);
        mAddressManagerAdapter.notifyDataSetChanged();
        showEmpty();
        mLoadingDialog.dismiss();
    }


    @Override
    public void delSuccess() {
        mAddressListPresenter.getAddressList();
    }


    public void showEmpty() {
        if (mAddressManagerAdapter != null && mAddressManagerAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, "No Address", R.mipmap.no_address, mVsEmpty);
        } else {
            if (mVsEmpty != null) {
                mVsEmpty.setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @org.greenrobot.eventbus.Subscribe
    public void addressEvent(AddressEvent addressEvent) {
        if (addressEvent.getEventType() == AddressEvent.ADD_ADDRESS_SUCCESS) {
            mAddressListPresenter.getAddressList();
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        mAddressListPresenter.getAddressList();
        refreshLayout.finishRefresh();
    }
}

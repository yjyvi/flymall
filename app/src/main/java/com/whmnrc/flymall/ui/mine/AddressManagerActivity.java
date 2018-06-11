package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
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

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class AddressManagerActivity extends BaseActivity implements AddressListPresenter.AddressListListener, AddressEditPresenter.AddressEditListener {

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

    @Override
    protected void initViewData() {

        EventBus.getDefault().register(this);
        mIsSelect = getIntent().getBooleanExtra("isSelect", false);
        if (mIsSelect) {
            setTitle("Select address");
        } else {
            setTitle("Shipping address");
        }
        mAddressListPresenter = new AddressListPresenter(this);
        mAddressListPresenter.getAddressList();

        mAddressEditPresenter = new AddressEditPresenter(this);
        mRvAddressList.setLayoutManager(new LinearLayoutManager(this));
        mAddressManagerAdapter = new AddressManagerAdapter(this, R.layout.item_address);
        mRvAddressList.setAdapter(mAddressManagerAdapter);

        mAddressManagerAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if (mIsSelect) {
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


    @OnClick(R.id.tv_commit)
    public void onClick() {
        AddAddressActivity.start(this, "");
    }

    @Override
    public void getListSuccess(List<AddressBean.ResultdataBean> resultdataBeans) {
        mAddressManagerAdapter.setDataArray(resultdataBeans);
        mAddressManagerAdapter.notifyDataSetChanged();
        showEmpty();
    }


    @Override
    public void delSuccess() {
        mAddressListPresenter.getAddressList();
    }


    @Override
    public void setDefaultSuccess() {

    }


    public void showEmpty() {
        if (mAddressManagerAdapter != null && mAddressManagerAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, mVsEmpty);
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
}

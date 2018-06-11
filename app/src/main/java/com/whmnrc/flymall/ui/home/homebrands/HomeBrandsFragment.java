package com.whmnrc.flymall.ui.home.homebrands;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.HomeBrandsListAdapter;
import com.whmnrc.flymall.beans.HomeDataBean;
import com.whmnrc.flymall.ui.LazyLoadFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/5/22.
 */

public class HomeBrandsFragment extends LazyLoadFragment{

    @BindView(R.id.rv_brands_list)
    RecyclerView mRvBrandsList;

    private HomeBrandsListAdapter mAdapter;
    public ArrayList<HomeDataBean.ResultdataBean.BrandsBean> mVideosBeans;

    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_home_brands;
    }

    @Override
    protected void initViewData() {

        initBrandsList();


        mVideosBeans = getArguments().getParcelableArrayList("videosBeans");

        mRvBrandsList.requestFocus();
        mRvBrandsList.setFocusableInTouchMode(false);
        mRvBrandsList.setNestedScrollingEnabled(false);

        loadBrandSuccess();


    }

    public static HomeBrandsFragment newInstance(ArrayList<HomeDataBean.ResultdataBean.BrandsBean> videosBeans) {
        Bundle bundle = new Bundle();
        HomeBrandsFragment homeFragment = new HomeBrandsFragment();
        homeFragment.setArguments(bundle);
        bundle.putParcelableArrayList("videosBeans", videosBeans);
        return homeFragment;
    }

    private void initBrandsList() {
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 5);
        mRvBrandsList.setLayoutManager(layout);

        mRvBrandsList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.left = getResources().getDimensionPixelOffset(R.dimen.dm_15);
                outRect.bottom = getResources().getDimensionPixelOffset(R.dimen.dm_15);
            }
        });
        mAdapter = new HomeBrandsListAdapter(mRvBrandsList.getContext(), R.layout.item_home_brands);
        mRvBrandsList.setAdapter(mAdapter);


    }


    public void loadBrandSuccess() {
        if (mVideosBeans != null) {
            mAdapter.setDataArray(mVideosBeans);
            mAdapter.notifyDataSetChanged();
        }
    }
}

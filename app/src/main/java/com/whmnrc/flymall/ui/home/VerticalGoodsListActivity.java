package com.whmnrc.flymall.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.ConfirmOrderGoodListAdapter;
import com.whmnrc.flymall.beans.ConfirmBean;
import com.whmnrc.flymall.ui.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class VerticalGoodsListActivity extends BaseActivity {
    @BindView(R.id.rv_goods_list)
    RecyclerView mRvGoodsList;


    private ConfirmOrderGoodListAdapter mAdapter;
    public ArrayList<ConfirmBean> mGoodsBean;

    @Override
    protected void initViewData() {
        setTitle("Product list");
        mGoodsBean = getIntent().getParcelableArrayListExtra("goodsBean");
        mRvGoodsList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ConfirmOrderGoodListAdapter(this, R.layout.item_goods_list_vertical);
        RecyclerView.ItemDecoration mItemDecoration = new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = 20;
                outRect.left = 30;
                outRect.right = 30;
                outRect.bottom = 20;
            }
        };
        mRvGoodsList.addItemDecoration(mItemDecoration);
        mRvGoodsList.setNestedScrollingEnabled(false);

        mAdapter.setDataArray(mGoodsBean);
        mRvGoodsList.setAdapter(mAdapter);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_vertical_goods_list;
    }

    public static void start(Context context, ArrayList<ConfirmBean> goodsBean) {
        Intent starter = new Intent(context, VerticalGoodsListActivity.class);
        starter.putParcelableArrayListExtra("goodsBean", goodsBean);
        context.startActivity(starter);
    }




}

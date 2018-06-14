package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.HistoryGoodListAdapter;
import com.whmnrc.flymall.beans.HistoryGoodsBean;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class BrowsingHistoryActivity extends BaseActivity {


    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.rv_browsing_history_list)
    RecyclerView mRvBrowsingHistoryList;
    private HistoryGoodListAdapter mAdapter;
    public List<HistoryGoodsBean> mHistoryGoodsBean = new ArrayList<>();

    @Override
    protected void initViewData() {
        setTitle("Browsing history");

        String goods = SPUtils.getString(MyApplication.applicationContext, CommonConstant.Common.HISTORY_GOODS);
        if (!TextUtils.isEmpty(goods)) {
            Log.d("BrowsingHistoryActivity", goods);
            mHistoryGoodsBean = JSON.parseArray(goods, HistoryGoodsBean.class);
        }
        mRvBrowsingHistoryList.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new HistoryGoodListAdapter(this, R.layout.item_goods_list);
        mRvBrowsingHistoryList.addItemDecoration(new RecyclerView.ItemDecoration() {
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
        mRvBrowsingHistoryList.setNestedScrollingEnabled(false);
        mAdapter.setDataArray(mHistoryGoodsBean);
        mRvBrowsingHistoryList.setAdapter(mAdapter);

        showEmpty();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, BrowsingHistoryActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_browsing_history;
    }


    public void showEmpty() {
        if (mAdapter != null && mAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, mVsEmpty);
        } else {
            mVsEmpty.setVisibility(View.GONE);
        }
    }
}

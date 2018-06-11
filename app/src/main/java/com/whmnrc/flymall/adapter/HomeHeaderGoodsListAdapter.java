package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.HomeSaleGoodsBean;
import com.whmnrc.flymall.ui.home.GoodsListActivity;

/**
 * @author yjyvi
 * @data 2018/5/22.
 */

public class HomeHeaderGoodsListAdapter extends CommonAdapter<HomeSaleGoodsBean.ResultdataBean> {

    public RecyclerView.ItemDecoration mItemDecoration;

    public HomeHeaderGoodsListAdapter(Context context, int layoutId) {
        super(context, layoutId);
        mItemDecoration = new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int childLayoutPosition = parent.getChildLayoutPosition(view);
                if (childLayoutPosition % 2 == 0) {
                    outRect.right = mContext.getResources().getDimensionPixelOffset(R.dimen.dm_2);
                } else {
                    outRect.left = mContext.getResources().getDimensionPixelOffset(R.dimen.dm_2);
                }
                outRect.bottom = mContext.getResources().getDimensionPixelOffset(R.dimen.dm_4);
            }
        };
    }

    @Override
    public void convert(ViewHolder holder, final HomeSaleGoodsBean.ResultdataBean resultdataBean, int position) {

        holder.setIsRecyclable(false);

        holder.setText(R.id.tv_sale_name, resultdataBean.getCategoryName());

        holder.setOnClickListener(R.id.tv_more, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.getCategoryId()));
            }
        });

        RecyclerView mRvSaleList = holder.getView(R.id.rv_goods_list);
        mRvSaleList.setLayoutManager(new GridLayoutManager(mContext, 2));

        mRvSaleList.addItemDecoration(mItemDecoration);
        HomeSaleGoodListAdapter mGoodListAdapter = new HomeSaleGoodListAdapter(mContext, R.layout.item_goods_list);
        mGoodListAdapter.setDataArray(resultdataBean.getProducts());
        mRvSaleList.setAdapter(mGoodListAdapter);


    }

}

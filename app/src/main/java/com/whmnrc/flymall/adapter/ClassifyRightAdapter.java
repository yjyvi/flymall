package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.OneBrandsBean;

/**
 * @author yjyvi
 * @date 2018/1/31
 */

public class ClassifyRightAdapter extends CommonAdapter<OneBrandsBean.ResultdataBean.SubCategoriesBeanX> {

    private int mWithd;

    public ClassifyRightAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    public ClassifyRightAdapter(Context context, int layoutId, int withd) {
        super(context, layoutId);
        this.mWithd = withd;
    }


    @Override
    public void convert(ViewHolder holder, OneBrandsBean.ResultdataBean.SubCategoriesBeanX resultdataBean, int position) {
        holder.setIsRecyclable(false);
        RecyclerView rv_category = holder.getView(R.id.rv_3_list);
        GridLayoutManager layout = new GridLayoutManager(mContext, 2);
        layout.setAutoMeasureEnabled(true);
        rv_category.setLayoutManager(layout);
        ClassifyRightAdapter2   classifyRightAdapter2 = new ClassifyRightAdapter2(mContext, R.layout.item_brands2, mWithd);
        rv_category.setAdapter(classifyRightAdapter2);

        rv_category.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int childLayoutPosition = parent.getChildLayoutPosition(view);
                if (childLayoutPosition % 2 == 0) {
                    outRect.right = mContext.getResources().getDimensionPixelOffset(R.dimen.dm_4);
                } else {
                    outRect.left = mContext.getResources().getDimensionPixelOffset(R.dimen.dm_4);
                }
                outRect.bottom = mContext.getResources().getDimensionPixelOffset(R.dimen.dm_8);
            }
        });

        classifyRightAdapter2.setDataArray(resultdataBean.getSubCategories());

        holder.setText(R.id.tv_two_name, resultdataBean.getName());
    }


}

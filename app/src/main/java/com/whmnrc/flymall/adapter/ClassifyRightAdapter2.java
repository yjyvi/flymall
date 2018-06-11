package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.OneBrandsBean;
import com.whmnrc.flymall.ui.home.GoodsListActivity;
import com.whmnrc.flymall.utils.GetViewHeightUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @date 2018/1/31
 */

public class ClassifyRightAdapter2 extends CommonAdapter<OneBrandsBean.ResultdataBean.SubCategoriesBeanX.SubCategoriesBean> {

    private int mWithd;


    public ClassifyRightAdapter2(Context context, int layoutId, int withd) {
        super(context, layoutId);
        this.mWithd = withd;
    }


    @Override
    public void convert(ViewHolder holder, final OneBrandsBean.ResultdataBean.SubCategoriesBeanX.SubCategoriesBean resultdataBean, int position) {
        holder.setText(R.id.tv_brand_name, resultdataBean.getName());
        GetViewHeightUtils.changeViewHeight(holder.getView(R.id.iv_brand_img), (mWithd - mContext.getResources().getDimensionPixelOffset(R.dimen.dm_8)) / 2);
        GlideUtils.LoadImage(mContext, resultdataBean.getImage(), (ImageView) holder.getView(R.id.iv_brand_img));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsListActivity.start(mContext, String.valueOf(resultdataBean.getId()));
            }
        });
    }


}

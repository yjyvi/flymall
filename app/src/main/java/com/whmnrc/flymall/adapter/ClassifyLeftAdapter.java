package com.whmnrc.flymall.adapter;

import android.content.Context;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.OneBrandsBean;

/**
 * Created by yjyvi on 2018/1/31.
 */

public class ClassifyLeftAdapter extends CommonAdapter<OneBrandsBean.ResultdataBean> {


    public ClassifyLeftAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, OneBrandsBean.ResultdataBean resultdataBean, int position) {
        holder.setText(R.id.tv_name, resultdataBean.getName());
    }

}

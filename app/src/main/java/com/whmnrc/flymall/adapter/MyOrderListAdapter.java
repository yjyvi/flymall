package com.whmnrc.flymall.adapter;

import android.content.Context;

import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;

/**
 * @author yjyvi
 * @data 2018/5/9.
 */

public class MyOrderListAdapter extends CommonAdapter {
    public MyOrderListAdapter(Context context, int layoutId) {
        super(context, layoutId);
        this.mContext = context;
    }

    @Override
    public void convert(final ViewHolder holder, Object o, int position) {
    }


}

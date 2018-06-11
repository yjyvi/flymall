package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.AllCurrencyBean;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class CurrencyAdapter extends CommonAdapter<AllCurrencyBean.ResultdataBean> {
    public CurrencyAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, AllCurrencyBean.ResultdataBean data, int position) {
        final TextView view = holder.getView(R.id.tv_content);
        view.setText(data.getCurrency_Name());

    }





}

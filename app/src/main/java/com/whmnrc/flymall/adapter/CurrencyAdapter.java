package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.AllCurrencyBean;
import com.whmnrc.flymall.utils.SPUtils;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class CurrencyAdapter extends CommonAdapter<AllCurrencyBean.ResultdataBean.ModelsBean> {


    private CurrencyListener currencyListener;

    public CurrencyAdapter(Context context, int layoutId, CurrencyListener currencyListener) {
        super(context, layoutId);
        this.currencyListener = currencyListener;
    }

    @Override
    public void convert(ViewHolder holder, final AllCurrencyBean.ResultdataBean.ModelsBean data, int position) {
        holder.setIsRecyclable(false);
        final TextView view = holder.getView(R.id.tv_content);
        String selectCurrencyCode = SPUtils.getString(MyApplication.applicationContext, CommonConstant.Common.CURRENT_CURRENCY_CODE);
        if (TextUtils.equals(selectCurrencyCode, String.valueOf(data.getCode()))) {
            selectedView(view,data);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedView(view, data);
            }
        });

        view.setText(data.getCurrency_Name());

    }

    private View lastView;

    private void selectedView(View view,AllCurrencyBean.ResultdataBean.ModelsBean data) {
        if (lastView != null) {
            lastView.setSelected(false);
        }
        if (!view.isSelected()) {
            view.setSelected(true);
            lastView = view;
            if (currencyListener != null) {
                currencyListener.selectResult(data);
            }
        } else {
            view.setSelected(false);
        }

    }


    public interface CurrencyListener {
        void selectResult(AllCurrencyBean.ResultdataBean.ModelsBean data);
    }


}

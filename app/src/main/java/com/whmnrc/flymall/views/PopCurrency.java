package com.whmnrc.flymall.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.CurrencyAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
import com.whmnrc.flymall.beans.AllCurrencyBean;

import java.util.List;


/**
 * Created by guox on 2017/6/2 0002.
 * 分享弹窗
 */

public class PopCurrency {

    private List<AllCurrencyBean.ResultdataBean> currencyData;
    private CurrencyAdapter mCurrencyAdapter;
    private PopupWindow mPopupWindow;
    private Context mContext;

    private CurrencyClickListener mListener;
    private String mCurrencyId;
    private double mCurrencyPrice;
    private String mCurrencyCode;


    public void setListener(CurrencyClickListener listener) {
        mListener = listener;
    }

    public PopCurrency(Context context, List<AllCurrencyBean.ResultdataBean> currencyData) {
        this.mContext = context;
        this.currencyData = currencyData;
        View view = LayoutInflater.from(context).inflate(R.layout.item_pop_currency, null);
        RecyclerView rv_currency = (RecyclerView) view.findViewById(R.id.rv_currency);
        TextView tv_submit = (TextView) view.findViewById(R.id.tv_submit);
        rv_currency.setLayoutManager(new GridLayoutManager(mContext, 2));
        mCurrencyAdapter = new CurrencyAdapter(mContext, R.layout.item_currency);
        rv_currency.setAdapter(mCurrencyAdapter);
        mCurrencyAdapter.setDataArray(currencyData);
        mCurrencyAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                selectedView(view);
                mCurrencyId = mCurrencyAdapter.getDatas().get(position).getCurrency_ID();
                mCurrencyPrice = mCurrencyAdapter.getDatas().get(position).getCurrency_Price();
                mCurrencyCode = mCurrencyAdapter.getDatas().get(position).getCode();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        // 设置popwindow弹出大小
        mPopupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        // 设置允许在外点击消失
        mPopupWindow.setOutsideTouchable(true);

        // 设置PopupWindow以外部分的背景颜色  有一种变暗的效果
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        PopUtils.setBackgroundAlpha((Activity) mContext, 0.5f);
        // 使其聚集
        mPopupWindow.setFocusable(true);
        mPopupWindow.setTouchable(true);

        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(mCurrencyId, mCurrencyPrice, mCurrencyCode);
                }
            }
        });
    }

    private View lastView;

    private void selectedView(View view) {
        if (lastView != null) {
            lastView.setSelected(false);
        }
        if (!view.isSelected()) {
            view.setSelected(true);
            lastView = view;
        } else {
            view.setSelected(false);
        }

    }

    public void show() {
        // 设置弹出位置
        mPopupWindow.showAtLocation(((Activity) mContext).getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        // 刷新状态
        mPopupWindow.update();

        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                PopUtils.setBackgroundAlpha((Activity) mContext, 1f);
            }
        });
    }


    public boolean isShowing() {
        return mPopupWindow.isShowing();
    }


    public interface CurrencyClickListener {
        void onClick(String currencyId, double currencyPrice,String code);
    }

    /**
     * 隐藏菜单
     */
    public void dismiss() {
        mPopupWindow.dismiss();
    }


}

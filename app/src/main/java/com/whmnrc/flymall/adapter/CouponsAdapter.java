package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.widget.RelativeLayout;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.CouponBean;
import com.whmnrc.flymall.utils.PlaceholderUtils;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class CouponsAdapter extends CommonAdapter<CouponBean.ResultdataBean> {
    public CouponsAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, CouponBean.ResultdataBean resultdataBean, int position) {
        holder.setText(R.id.tv_coupons_title, resultdataBean.getCouponName());
        holder.setText(R.id.tv_coupons_money, PlaceholderUtils.pricePlaceholder(resultdataBean.getPrice()));
        holder.setText(R.id.tv_coupons_time, "Please use before" + resultdataBean.getEndTime());
        RelativeLayout rlCouponsBg = holder.getView(R.id.rl_coupons_bg);

        switch (resultdataBean.getUseStatus()) {
            case 0:
                rlCouponsBg.setBackgroundResource(R.mipmap.icon_coupon_select);
                break;
            case 1:
//                rlCouponsBg.setBackgroundResource(R.mipmap.icon_coupon_normal);
//                break;
            case 2:
                rlCouponsBg.setBackgroundResource(R.mipmap.icon_coupon_overdue);
                break;
            default:
                break;
        }

    }
}

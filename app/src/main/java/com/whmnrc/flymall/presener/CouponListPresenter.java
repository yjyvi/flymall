package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.CouponBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class CouponListPresenter extends PresenterBase {

    private CouponListListener mCouponListListener;

    public CouponListPresenter(CouponListListener couponListListener) {
        this.mCouponListListener = couponListListener;
    }


    public void getCouponList(int page, int rows) {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("userId", UserManager.getUser().getId());
        params.put("Page", String.valueOf(page));
        params.put("Rows", String.valueOf(rows));

        OKHttpManager.get(getUrl(R.string.GetCoupon), params, new CommonCallBack<CouponBean>() {
            @Override
            protected void onSuccess(CouponBean data) {
                if (data.getType() == 1) {
                    mCouponListListener.getCouponListSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }

    public void getSomeCouponList(String money) {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("userId", UserManager.getUser().getId());
        params.put("money", money);

        OKHttpManager.get(getUrl(R.string.GetSomesomeCoupons), params, new CommonCallBack<CouponBean>() {
            @Override
            protected void onSuccess(CouponBean data) {
                if (data.getType() == 1) {
                    mCouponListListener.getCouponListSuccess(data.getResultdata());
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface CouponListListener {
        void getCouponListSuccess(List<CouponBean.ResultdataBean> resultdataBeans);
    }

}

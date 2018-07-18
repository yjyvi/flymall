package com.whmnrc.flymall.ui.mine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.AddressBean;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.presener.CheckPaymentStatusForTTPresenter;
import com.whmnrc.flymall.presener.PayPPPresenter;
import com.whmnrc.flymall.presener.TTPayPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.OrderListEvent;
import com.whmnrc.flymall.utils.pay.PayPalUtils;
import com.whmnrc.flymall.utils.pay.PayUtils;
import com.whmnrc.flymall.views.LoadingDialog;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import butterknife.BindView;
import butterknife.OnClick;

import static com.whmnrc.flymall.CommonConstant.Common.PAY_METHOD_PP;
import static com.whmnrc.flymall.CommonConstant.Common.PAY_METHOD_REV;
import static com.whmnrc.flymall.CommonConstant.Common.PAY_METHOD_TT;
import static com.whmnrc.flymall.CommonConstant.Common.PAY_METHOD_WX;
import static com.whmnrc.flymall.CommonConstant.Common.PAY_METHOD_ZFB;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class ConfirmPaymentActivity extends BaseActivity implements PayPPPresenter.PayPPListener, TTPayPresenter.TTPayOrderListener, CheckPaymentStatusForTTPresenter.CheckPaymentStatusForTTListener {
    @BindView(R.id.tv_total_price)
    TextView mTvTotalPrice;
    @BindView(R.id.tv_order_no)
    TextView mTvOrderNo;
    @BindView(R.id.rl_add_address)
    RelativeLayout mRlAddAddress;
    @BindView(R.id.tv_address_name)
    TextView mTvAddressName;
    @BindView(R.id.tv_address_tel)
    TextView mTvAddressTel;
    @BindView(R.id.tv_address_desc)
    TextView mTvAddressDesc;
    @BindView(R.id.iv_pay_pp)
    ImageView mIvPayPp;
    @BindView(R.id.iv_pay_tt)
    ImageView mIvPayTt;
    @BindView(R.id.iv_pay_zfb)
    ImageView mIvPayZfb;
    @BindView(R.id.iv_pay_wx)
    ImageView mIvPayWx;
    @BindView(R.id.iv_pay_rev_letter)
    ImageView mIvPayRevLetter;
    @BindView(R.id.tv_pay)
    TextView mTvPay;
    private static final int REQUEST_CODE = 909;
    private int payType = PAY_METHOD_TT;
    public PayUtils mPayUtils;
    private PayPPPresenter mPayPPPresenter;
    public String mOrderId;
    private String mPaymentId;
    public double mTotalPrice;
    public TTPayPresenter mTtPayPresenter;
    private CheckPaymentStatusForTTPresenter mCheckPaymentStatusForTTPresenter;
    private LoadingDialog mLoadingDialog;
    private double mCouponsPrice;
    //    @BindView(R.id.iv_pay_up)
//    ImageView mIvPayUp;

    @Override
    protected void initViewData() {
        setTitle("Confirm payment");

        mLoadingDialog = new LoadingDialog(this);
        mOrderId = getIntent().getStringExtra("orderId");
        mTotalPrice = getIntent().getDoubleExtra("totalPrice", 0);
        mCouponsPrice = getIntent().getDoubleExtra("couponsPrice", 0);
        String addressBean = getIntent().getStringExtra("addressBean");
        AddressBean.ResultdataBean confirmAddressBean = JSON.parseObject(addressBean, AddressBean.ResultdataBean.class);
        mPayUtils = new PayUtils(this);
        mPayPPPresenter = new PayPPPresenter(this);
        mTtPayPresenter = new TTPayPresenter(this);
        mCheckPaymentStatusForTTPresenter = new CheckPaymentStatusForTTPresenter(this);
        mTvOrderNo.setText(String.format("Order number：%s", mOrderId));
        mTvTotalPrice.setText(String.format("Total merchandise：%s", PlaceholderUtils.pricePlaceholder(mTotalPrice)));

        if (confirmAddressBean != null) {
            mTvAddressDesc.setText(confirmAddressBean.getAddress());
            mTvAddressName.setText(String.format("Receiver：%s", confirmAddressBean.getShipTo() + confirmAddressBean.getAddress_LastName()));
            mTvAddressTel.setText(confirmAddressBean.getPhone());
        }

        selectedView(mIvPayTt);
        mTvPay.setText(String.format("Western Union %s ", PlaceholderUtils.pricePlaceholder(mTotalPrice - mCouponsPrice)));
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_confirm_payment;
    }

    public static void start(Context context, String orderId, double totalPrice, String addressBean) {
        Intent starter = new Intent(context, ConfirmPaymentActivity.class);
        starter.putExtra("orderId", orderId);
        starter.putExtra("addressBean", addressBean);
        starter.putExtra("totalPrice", totalPrice);
        context.startActivity(starter);
    }

    public static void start(Context context, String orderId, double totalPrice, double couponsPrice, String addressBean) {
        Intent starter = new Intent(context, ConfirmPaymentActivity.class);
        starter.putExtra("orderId", orderId);
        starter.putExtra("addressBean", addressBean);
        starter.putExtra("totalPrice", totalPrice);
        starter.putExtra("couponsPrice", couponsPrice);
        context.startActivity(starter);
    }

    public static void start(Context context, String orderId) {
        Intent starter = new Intent(context, ConfirmPaymentActivity.class);
        starter.putExtra("orderId", orderId);
        context.startActivity(starter);
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


    @OnClick({R.id.ll_pay_pp, R.id.ll_pay_tt, R.id.ll_pay_zfb, R.id.ll_pay_wx,
            R.id.ll_pay_qi,
            R.id.tv_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_pay_pp:
                selectedView(mIvPayPp);
                mTvPay.setText(String.format("Pay Pal %s ", PlaceholderUtils.pricePlaceholder(mTotalPrice)));
                payType = PAY_METHOD_PP;
                break;
            case R.id.ll_pay_tt:
                payType = PAY_METHOD_TT;
                mTvPay.setText(String.format("Western Union %s ", PlaceholderUtils.pricePlaceholder(mTotalPrice - mCouponsPrice)));
                selectedView(mIvPayTt);
                break;
            case R.id.ll_pay_zfb:
                mTvPay.setText(String.format("ALIPAY %s ", PlaceholderUtils.pricePlaceholder(mTotalPrice)));
                payType = PAY_METHOD_ZFB;
                selectedView(mIvPayZfb);
                break;
            case R.id.ll_pay_wx:
                mTvPay.setText(String.format("WeChat Pay %s ", PlaceholderUtils.pricePlaceholder(mTotalPrice)));
                payType = PAY_METHOD_WX;
                selectedView(mIvPayWx);
                break;
            case R.id.ll_pay_qi:
                selectedView(mIvPayRevLetter);
                payType = PAY_METHOD_REV;
                mTvPay.setText(String.format("Credit card %s ", PlaceholderUtils.pricePlaceholder(mTotalPrice)));
                break;
            case R.id.tv_pay:
                payTypeSelect();
                break;
            default:
                break;
        }
    }

    private void payTypeSelect() {
        switch (payType) {
            case PAY_METHOD_PP:
                PayPalUtils payPalUtils = new PayPalUtils();
                payPalUtils.initPayPalUtils(ConfirmPaymentActivity.this, mOrderId, String.valueOf(mTotalPrice));
                break;
            case PAY_METHOD_TT:
                mLoadingDialog.show();
                mCheckPaymentStatusForTTPresenter.getIsPayTT(mOrderId);
                break;
            case PAY_METHOD_ZFB:
                mPayUtils.playPay(PAY_METHOD_ZFB, 1, "123123", new OKHttpManager.ObjectCallback() {
                    @Override
                    public void onSuccess(String st) {

                    }

                    @Override
                    public void onFailure(int code, String errorMsg) {

                    }
                });
                break;
            case PAY_METHOD_WX:
                mPayUtils.playPay(PAY_METHOD_WX, 1, "123123", new OKHttpManager.ObjectCallback() {
                    @Override
                    public void onSuccess(String st) {

                    }

                    @Override
                    public void onFailure(int code, String errorMsg) {

                    }
                });
                break;
            case PAY_METHOD_REV:
                QiPayActivity.start(ConfirmPaymentActivity.this, mOrderId,mTotalPrice);
                finish();
                break;
            default:
                break;
        }

    }

    @Override
    public void getPayPalSuccess(boolean isSuccess) {
        finish();
        PayResultActivity.start(this, mOrderId, isSuccess);
        EventBus.getDefault().post(new OrderListEvent().setEventType(OrderListEvent.UNPAID));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PayPalUtils.REQUEST_CODE_PAYMENT) {
            if (resultCode == Activity.RESULT_OK) {
                PaymentConfirmation confirm =
                        data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirm != null) {
                    try {
                        Log.i(PayPalUtils.TAG, confirm.toJSONObject().toString(4));
                        Log.i(PayPalUtils.TAG, confirm.getPayment().toJSONObject().toString(4));
                        /**
                         *  TODO: send 'confirm' (and possibly confirm.getPayment() to your server for verification
                         * or consent completion.
                         * See https://developer.paypal.com/webapps/developer/docs/integration/mobile/verify-mobile-payment/
                         * for more details.
                         *
                         * For sample mobile backend interactions, see
                         * https://github.com/paypal/rest-api-sdk-python/tree/master/samples/mobile_backend
                         */
                        ToastUtils.showToast("PaymentConfirmation info received from PayPal");
                        // 得到回传的交易流水号
                        mPaymentId = confirm.toJSONObject().getJSONObject("response").getString("id");
                        mPayPPPresenter.payPalNotify(mOrderId, 2, mPaymentId);

                    } catch (JSONException e) {
                        Log.e(PayPalUtils.TAG, "an extremely unlikely failure occurred: ", e);
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i(PayPalUtils.TAG, "The user canceled.");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i(PayPalUtils.TAG, "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
            }
        }
    }

    @Override
    public void payOrderSuccess(boolean isSuccess) {
        mLoadingDialog.dismiss();
        finish();
        PayResultActivity.start(this, mOrderId, isSuccess);
    }


    @Override
    public void getIsPayTTSuccess(String orderId) {
        mTtPayPresenter.ttPayOrder(mOrderId, 1);
    }

    @Override
    public void getIsPayField() {
        mLoadingDialog.dismiss();
    }


}

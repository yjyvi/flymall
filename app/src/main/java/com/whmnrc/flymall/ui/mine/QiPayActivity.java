package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.presener.QiPayPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.IpUtils;
import com.whmnrc.flymall.utils.KeyboardUtils;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.OrderListEvent;
import com.whmnrc.flymall.views.LoadingDialog;
import com.whmnrc.flymall.views.PopUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class QiPayActivity extends BaseActivity implements  QiPayPresenter.QiPayListener {

    @BindView(R.id.tv_pay)
    TextView mTvPay;
    @BindView(R.id.tv_year)
    TextView mTvYear;
    @BindView(R.id.tv_month)
    TextView mTvMonth;
    @BindView(R.id.et_card_number)
    EditText mEtCardNumber;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.et_mial)
    EditText mEtMial;
    private LoadingDialog mLoadingDialog;
    public String mMCurrentIP;
    public QiPayPresenter mQiPayPresenter;
    public String mOrderId;
    public TimePickerView mPvTime;
    public int mYear = 0;
    public int mMonth = 0;
    private double mTotalPrice;


    @Override
    protected void initViewData() {

        EventBus.getDefault().register(this);
        setTitle("Confirm payment");
        mOrderId = getIntent().getStringExtra("orderId");
        mTotalPrice = getIntent().getDoubleExtra("totalPrice", 0);
        mLoadingDialog = new LoadingDialog(this);
        IpUtils.getNetIp(new IpUtils.IPListener() {
            @Override
            public void getIPSuccess(String ip) {
                mMCurrentIP = ip;
            }
        });
        mQiPayPresenter = new QiPayPresenter(this);
        mYear = Calendar.getInstance().get(Calendar.YEAR);
        mMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;


        Calendar startDate = Calendar.getInstance();
        //startDate.set(2013,1,1);
        Calendar endDate = Calendar.getInstance();
        //endDate.set(2020,1,1);

        //正确设置方式 原因：注意事项有说明
        startDate.set(mYear, mMonth, 1);
        endDate.set(2030, 11, 31);

        initDataSelect(startDate, endDate);

        mTvPay.setText(String.format("Credit card %s ", PlaceholderUtils.pricePlaceholder(mTotalPrice)));

//        mEtCardNumber.setText("4111111111111111");
//        mEtCode.setText("123");
//        mTvYear.setText("2022");
//        mTvMonth.setText("01");
//        mEtMial.setText("androidlk@aliyun.com");
    }

    private void initDataSelect(Calendar startDate, Calendar endDate) {
        mPvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                mYear = date.getYear() + 1900;
                mMonth = date.getMonth() + 1;

                mTvYear.setText(String.valueOf(mYear));
                mTvMonth.setText(String.valueOf(mMonth));
            }
        }).setType(new boolean[]{true, true, false, false, false, false})// 默认全部显示
                .setCancelText("Cancel")//取消按钮文字
                .setSubmitText("Sure")//确认按钮文字
                .setTitleSize(16)//标题文字大小
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTitleColor(Color.WHITE)//标题文字颜色
                .setSubmitColor(Color.RED)//确定按钮文字颜色
                .setCancelColor(Color.GRAY)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                        .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月���设定
                .setLabel("年", "月", "", "", "", "")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的 label 文字，false 则每项 item 全部都带有 label。
//                        .isDialog(true)//是否显示为对话框样式
                .build();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_qi_pay_payment;
    }


    public static void start(Context context, String orderId,double totalPrice) {
        Intent starter = new Intent(context, QiPayActivity.class);
        starter.putExtra("orderId", orderId);
        starter.putExtra("totalPrice", totalPrice);
        context.startActivity(starter);
    }


    @OnClick({R.id.iv_pay_hint, R.id.tv_year, R.id.tv_month, R.id.tv_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_year:
            case R.id.tv_month:
                KeyboardUtils.hideKeyBoard(QiPayActivity.this, mTvPay);
                mPvTime.show();
                break;
            case R.id.iv_pay_hint:
                PopUtils.showConfirmationReceiptPop(QiPayActivity.this, mTvPay, null);
                break;
            case R.id.tv_pay:
                String cardNumber = mEtCardNumber.getText().toString().trim();
                String year = mTvYear.getText().toString().trim();
                String month = mTvMonth.getText().toString().trim();
                String cartCode = mEtCode.getText().toString().trim();
                String email = mEtMial.getText().toString().trim();


                if (TextUtils.isEmpty(cardNumber)) {
                    ToastUtils.showToast("card number is Empty");
                    return;
                }

                if (!cardNumber.startsWith("4") && !cardNumber.startsWith("6")) {
                    ToastUtils.showToast("Please enter the correct credit card number");
                    return;
                }


                if (TextUtils.isEmpty(year)) {
                    ToastUtils.showToast("year is Empty");
                    return;
                }


                if (TextUtils.isEmpty(month)) {
                    ToastUtils.showToast("month is Empty");
                    return;
                }


                if (TextUtils.isEmpty(cartCode)) {
                    ToastUtils.showToast("cartCode is Empty");
                    return;
                }


                if (TextUtils.isEmpty(email)) {
                    ToastUtils.showToast("email is Empty");
                    return;
                }


                if (TextUtils.isEmpty(mOrderId)) {
                    ToastUtils.showToast("OrderId is Empty");
                    return;
                }

                mLoadingDialog.show();
                String monthSt;
                if (month.length() == 1) {
                    monthSt = "0" + month;
                } else {
                    monthSt = month;
                }

                mQiPayPresenter.getQiPay(
                        cardNumber,
                        year,
                        monthSt,
                        cartCode,
                        email,
                        mOrderId, mMCurrentIP

                );
                break;
            default:
                break;
        }
    }





    @Override
    public void qiPaySuccess() {
        mLoadingDialog.dismiss();
        finish();
        PayResultActivity.start(this,mOrderId,false);
        EventBus.getDefault().post(new OrderListEvent().setEventType(OrderListEvent.UNPAID));
    }

    @Override
    public void qiPayField() {
        mLoadingDialog.dismiss();
        finish();
        PayResultActivity.start(this,mOrderId,true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe
    public void orderListEvent(OrderListEvent orderListEvent) {

    }



}

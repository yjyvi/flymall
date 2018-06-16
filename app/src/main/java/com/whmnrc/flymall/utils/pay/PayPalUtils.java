package com.whmnrc.flymall.utils.pay;

import android.app.Activity;
import android.content.Intent;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalItem;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalPaymentDetails;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.whmnrc.flymall.presener.TTPayPresenter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/7.
 */

public class PayPalUtils implements TTPayPresenter.TTPayOrderListener {

    public static final String TAG = "paymentExample";
    /**
     * - Set to PayPalConfiguration.ENVIRONMENT_PRODUCTION to move real money.
     * <p>
     * - Set to PayPalConfiguration.ENVIRONMENT_SANDBOX to use your test credentials
     * from https://developer.paypal.com
     * <p>
     * - Set to PayPalConfiguration.ENVIRONMENT_NO_NETWORK to kick the tires
     * without communicating to PayPal's servers.
     */


    private static PayPalConfiguration paypalConfig = new PayPalConfiguration()
            .environment(Config.PAYPAL_ENVIRONMENT)
            .defaultUserEmail("sql_316-test@163.com")
            .sandboxUserPassword("1234567890")
            .clientId(Config.PAYPAL_CLIENT_ID);

    private Activity mContext;
    private String orderMoney;
    private String orderId;
    public static final int REQUEST_CODE_PAYMENT = 1;

    @Override
    public void payOrderSuccess(boolean isSuccess) {

    }


    public class Config {
        // PayPal app configuration
        public static final String PAYPAL_CLIENT_ID = "Ac-IqWBpbeR4mMtVIW6rQiNFbuWs1rI30zBlfn9ND7MX6j4HagcnGIIVu9KGsOzRr4-jVL7Nq0rx6KJn";
        public static final String PAYPAL_CLIENT_SECRET = "secret 前端用不到";
        //正式环境
        // private public final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_PRODUCTION;
        public static final String PAYPAL_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
        public static final String PAYMENT_INTENT = PayPalPayment.PAYMENT_INTENT_SALE;
        public static final String DEFAULT_CURRENCY = "USD";//美元




    }

    public  void initPayPalUtils(Activity context,String orderId,String orderMoney) {

        this.mContext = context;
        this.orderId = orderId;
        this.orderMoney= orderMoney;

        Intent intent = new Intent(context, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, paypalConfig);
        context.startService(intent);

        launchPayPalPayment();
    }

    private List<PayPalItem> productsInCart = new ArrayList<PayPalItem>();

    /**
     * 启动支付界面
     * Launching PalPay payment activity to complete the payment
     */
    private void launchPayPalPayment() {

//        PayPalPayment thingsToBuy = prepareFinalCart();

        PayPalPayment payment = new PayPalPayment(new BigDecimal(orderMoney), "USD", orderId,
                PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(mContext, PaymentActivity.class);

        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, paypalConfig);

        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);

        mContext.startActivityForResult(intent, REQUEST_CODE_PAYMENT);
    }


    /**
     * 添加商品信息
     * Preparing final cart amount that needs to be sent to PayPal for payment
     */
    private PayPalPayment prepareFinalCart() {
        PayPalItem[] items = new PayPalItem[productsInCart.size()];
        items = productsInCart.toArray(items);

        // Total amount
        BigDecimal subtotal = PayPalItem.getItemTotal(items);
        // If you have shipping cost, add it here
        BigDecimal shipping = new BigDecimal("0");
        // If you have tax, add it here赋税
        BigDecimal tax = new BigDecimal("0");
        PayPalPaymentDetails paymentDetails = new PayPalPaymentDetails(
                shipping, subtotal, tax);

        BigDecimal amount = subtotal.add(shipping).add(tax);

        PayPalPayment payment = new PayPalPayment(
                amount,
                Config.DEFAULT_CURRENCY,
                "Description about transaction. This will be displayed to the user.",
                Config.PAYMENT_INTENT);

        payment.items(items).paymentDetails(paymentDetails);

        // Custom field like invoice_number etc.,
        payment.custom("This is text that will be associated with the payment that the app can use.");

        return payment;
    }


}

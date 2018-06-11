package com.whmnrc.flymall.utils.pay;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import java.math.BigDecimal;

/**
 * @author yjyvi
 * @data 2018/6/7.
 */

public class PayPalUtils {

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
    //正式环境
//    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_PRODUCTION;
    //测试环境
    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;

    // note that these credentials will differ between live & sandbox environments.
    private static final String CONFIG_CLIENT_ID = "AUY01sO4jBJWL-fk8K0M55Zq_syV_9PTGlsMaJSydTMZ9yHJZ1V4kn7WguQSwuU9599lndppg_jjn2fS";

    public static final int REQUEST_CODE_PAYMENT = 1;


    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(CONFIG_ENVIRONMENT)
            .clientId(CONFIG_CLIENT_ID)
            // The following are only used in PayPalFuturePaymentActivity.
            .merchantName("Sandbox")
            .merchantPrivacyPolicyUri(Uri.parse("https://www.example.com/privacy"))
            .merchantUserAgreementUri(Uri.parse("https://www.example.com/legal"));
    private Activity mContext;


    public  void initPayPalUtils(Activity context) {
        this.mContext = context;
        Intent intent = new Intent(context, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        context.startService(intent);

        onBuyPressed();
    }


    private void onBuyPressed() {
        /*
         * PAYMENT_INTENT_SALE will cause the payment to complete immediately.
         * Change PAYMENT_INTENT_SALE to
         *   - PAYMENT_INTENT_AUTHORIZE to only authorize payment and capture funds later.
         *   - PAYMENT_INTENT_ORDER to create a payment for authorization and capture
         *     later via calls from your server.
         *
         * Also, to include additional payment details and an item list, see getStuffToBuy() below.
         */
        PayPalPayment thingToBuy = getThingToBuy(PayPalPayment.PAYMENT_INTENT_SALE);

        /*
         * See getStuffToBuy(..) for examples of some available payment options.
         */

        Intent intent = new Intent(mContext, PaymentActivity.class);

        // send the same configuration for restart resiliency
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);

        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);

        mContext.startActivityForResult(intent, REQUEST_CODE_PAYMENT);
    }

    private PayPalPayment getThingToBuy(String paymentIntent) {
        return new PayPalPayment(new BigDecimal("0.01"), "USD", "sample item", paymentIntent);
    }




}

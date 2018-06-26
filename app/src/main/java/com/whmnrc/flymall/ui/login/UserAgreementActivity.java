package com.whmnrc.flymall.ui.login;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.ui.BaseActivity;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/6/20.
 */

public class UserAgreementActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView mTvContent;

    @Override
    protected void initViewData() {
        setTitle("User Agreement");
        mTvContent.setText("Privacy Policy\n" +
                "This Privacy Statement explains how Wuhan HuiJu Agel Ecommerce Co., Ltd., Ltd (“FlyMall” “we,” “us,” or “our”) collects, uses, and discloses your personal information in connection with its operation of the FlyMall ecommerce platform.\n" +
                "What information do we collect?\n" +
                "Personal information is information that can be used to directly or indirectly identify you. Personal information also includes anonymous information that is linked to information that can be used to directly or indirectly identify you. Personal information does not include information that has been irreversibly anonymized or aggregated so that it can no longer enable us, whether in combination with other information or otherwise, to identify you.\n" +
                "We will only collect and use personal information which is necessary to comply with our legal obligations and to assist us to administer our business and provide you with the services you request.\n" +
                "We collect information from you when you register on our site, place an order, subscribe to our newsletter or respond to a survey.\n" +
                "When ordering or registering on our site, as appropriate, you may be asked to enter the following information: your name, e-mail address, mailing address and phone number. You may, however, also visit our site anonymously.\n" +
                "What do we use your information for?\n" +
                "We use the information you provide to us for the specific purposes for which you provide the information, as stated at the time of collection, and as otherwise permitted by law. The information we collect from you may be used in the following ways:\n" +
                "•\tTo personalize your experience(your information helps us to better respond to your individual needs)\n" +
                "•\tTo personalize your experience(your information helps us to better respond to your individual needs)\n" +
                "•\tTo personalize your experience(your information helps us to better respond to your individual needs)\n" +
                "•\tTo personalize your experience(your information helps us to better respond to your individual needs)\n" +
                "•\tTo personalize your experience(your information helps us to better respond to your individual needs)\n" +
                "Legal Basis for the Processing of Personal Information\n" +
                "If you are located in the European Economic Area (“EEA”), our processing of your personal information will be based on the following: To the extent that we obtain your consent for the processing of your personal information such processing will be justified pursuant to Article 6(1) lit. (a) of the General Data Protection Regulation (EU) 2016/679 (“GDPR”). If the processing of your personal information is necessary for the performance of a contract between you and us or for taking pre-contractual steps upon your request, such processing will be based on GDPR Article 6(1) lit. (b). Where the processing is necessary for us to comply with a legal obligation, we will process your personal information on basis of GDPR Article 6(1) lit. (c), and where the processing is necessary for the purposes of our legitimate interests, such processing will be made in accordance with GDPR Article 6(1) lit. (f).\n" +
                "Please note that where you have given your consent to the processing of your personal information you may withdraw your consent, for example by skyping us at any time which withdrawal will not affect the lawfulness of any processing previously made on basis of your consent.\n" +
                "Your rights\n" +
                "We take reasonable steps to ensure that your personal information is accurate, complete, and up to date. You have the right to access, correct, or delete the personal information that we collect. You are also entitled to restrict or object, at any time, to the further processing of your personal information. You have the right to receive your personal information in a structured and standard format and, where technically feasible, the right to have your personal information transmitted directly to a third party. You may lodge a complaint with the competent data protection authority regarding the processing of your personal information.\n" +
                "To protect the privacy and the security of your personal information, we may request information from you to enable us to confirm your identity and right to access such information, as well as to search for and provide you with the personal information we maintain. There are instances where applicable laws or regulatory requirements allow or require us to refuse to provide or delete some or all of the personal information that we maintain.\n" +
                "We will respond to your request in a reasonable timeframe. We will take all reasonable steps to ensure that your personal data is correct and up to date.\n" +
                "How do we protect your information?\n" +
                "You are responsible for your own username and password safety and security on FlyMall. We recommend choosing a strong password and changing it frequently. Please do not use the same login details (email and password) across multiple websites.\n" +
                "That said, we do implement a variety of security measures including offering the use of a secure server. All supplied sensitive/credit information is transmitted via Secure Socket Layer (SSL) technology and then encrypted into our Payment gateway providers database only to be accessible by those authorized with special access rights to such systems, and are required to keep the information confidential. After a transaction, your private information (credit cards, social security numbers, financials, etc.) will not be stored on our servers.\n" +
                "Our servers and website are security scanned and fully verified externally by McAfee Secure from Symantec on a daily basis to protect you online.\n" +
                "Do we use cookies?\n" +
                "Yes. Cookies are small files that a site or its service provider transfers to your computer's hard drive through your Web browser (if you have allowed it via your settings). This enables the sites or service providers systems to recognize your browser and capture and remember certain information.\n" +
                "We use cookies to help us remember and process the items in your shopping cart, understand and save your preferences for future visits and compile aggregate data about site traffic and site interaction so that we can offer better site experiences and tools for you in the future.\n" +
                "We may contract with third-party service providers to assist us in better understanding our site visitors. These service providers are however not permitted to use the information collected on our behalf except to help us directly conduct and improve our business. We use, for example, Google Analytics, a web analytics service provided by Google, Inc. (“Google”) to help us better understand how users engage with our website. Google Analytics uses cookies in order to collect information on the usage of our website. This information is used to compile reports and create services to help us improve our website and the services associated with it. The reports disclose website trends without identifying individual visitors. The information generated by the Google cookie about your use of our website (including your IP address) may be transmitted to and stored by Google on servers in the United States. Google may also transfer this information to third parties where required to do so by law, or where such third parties process the information on Google's behalf. Google will not associate your IP address with any other data held by Google.\n" +
                "On some pages of our website, third parties that provide applications through our website may set their own cookies in order to provide services, track the success of their applications or customize applications for you. For example, when you share content using a social media sharing button such as Facebook or Twitter, the social network that has created the button will record that you have done this. Because of how cookies work, we cannot access these cookies nor can the third parties access the data in cookies used by us.\n" +
                "If you prefer, you can choose to have your computer warn you each time a cookie is being sent, or you can choose to turn off all cookies via your browser settings. Like most websites, if you turn your cookies off, some of our services may not function properly.Do we disclose any information to outside parties?\n" +
                "We do not sell, trade, or otherwise transfer to outside parties your personal information. This does not include trusted third parties who assist us in operating our website, conducting our business, executing payments, delivering purchased products or services, sending you information or updates or otherwise servicing you, so long as those parties agree to keep this\n" +
                "information confidential. We may also release your information when we believe release is appropriate to comply with the law, enforce our site policies, or protect ours or others rights, property, or safety. However, non-personally identifiable visitor information may be provided to other parties for marketing, advertising, or other uses.\n" +
                "How long do we retain your information?\n" +
                "We will retain your personal information for as long as it is necessary to fulfil the purposes outlined in this Privacy Policy, unless a longer retention period is required or permitted by tax, accounting or other applicable laws.\n" +
                "Third party links\n" +
                "Occasionally, at our discretion, we may include or offer third party products or services on our website. These third party sites have separate and independent privacy policies. We therefore have no responsibility or liability for the content and activities of these linked sites. Nonetheless, we seek to protect the integrity of our site and welcome any feedback about these sites.\n" +
                "Terms and Conditions\n" +
                "Please also visit our Terms and Conditions section establishing the use, disclaimers, and limitations of liability governing the use of our website at Terms and Conditions.\n" +
                "Changes to our Privacy Policy\n" +
                "If we decide to change our privacy policy, we will post those changes on this page, and/or update the Privacy Policy modification date below.\n" +
                "Contact Us\n" +
                "If you would like to exercise one of your rights as set out above, or if you have a question or a complaint about this policy, the way your personal information is processed, please Skype us\n" +
                "\n");
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_user_agreement;
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, UserAgreementActivity.class);
        context.startActivity(starter);
    }
}

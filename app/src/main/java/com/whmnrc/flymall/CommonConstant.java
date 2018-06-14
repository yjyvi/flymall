package com.whmnrc.flymall;

/**
 * @author yjyvi
 * @date 2018/1/30
 */

public class CommonConstant {

    public static class Common {

        /**
         * 第一次启动
         */
        public static final String FIRST_LAUNCHER = "first_launcher";

        /**
         * 上次登录的用户ID
         */
        public static final String LAST_LOGIN_ID = "LastLoginId";

        /**
         * 支付方式-> PP
         */
        public static final int PAY_METHOD_PP = 1;

        /**
         * 支付方式-> TT
         */
        public static final int PAY_METHOD_TT = 2;

        /**
         * 支付方式-> 支付宝
         */
        public static final int PAY_METHOD_ZFB = 3;

        /**
         * 支付方式-> 微信
         */
        public static final int PAY_METHOD_WX = 4;


        /**
         * 微信APP ID
         */
        public static final String WX_APP_ID = "wxdac79b5de8e5d7e2";

        /**
         * 微信SECRET
         */
        public static final String WX_SECRET = "aa899e5be0e49b698e00d29c2b9db917";

        /**
         * 当前的选择的货币
         */
        public static final String CURRENT_CURRENCY = "current_currency";
        /**
         * 当前获取种类
         */
        public static final String CURRENT_CURRENCY_CODE = "currency_code";
        /**
         * 商品历史记录
         */
        public static final String HISTORY_GOODS = "history_goods";
        /**
         * 用户协议
         */
        public static final String AGREEMENT = "http://flymall.store/Agreement.html";
    }
}

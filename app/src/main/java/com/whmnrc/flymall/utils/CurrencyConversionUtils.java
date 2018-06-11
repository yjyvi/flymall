package com.whmnrc.flymall.utils;

import android.text.TextUtils;

import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;

/**
 * @author yjyvi
 * @data 2018/5/30.
 * 货币转换
 */

public class CurrencyConversionUtils {

    public static String chagePrice(double price) {
        String priceCurrency = SPUtils.getString(MyApplication.applicationContext, CommonConstant.Common.CURRENT_CURRENCY);
        if (!TextUtils.isEmpty(priceCurrency)) {
            double parseDouble = Double.parseDouble(priceCurrency);
            price = parseDouble * price;
        }

        return String.valueOf(price);
    }
}

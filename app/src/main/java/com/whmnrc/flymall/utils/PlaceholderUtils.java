package com.whmnrc.flymall.utils;


import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.R;

/**
 * 显示字符串占位工具类
 *
 * @author yjyvi
 * @data 2018/3/3.
 */

public class PlaceholderUtils {

    /**
     * 商品价格占位
     *
     * @param money
     * @return
     */
    public static String pricePlaceholder(double money) {
        if (money <= 0.0) {
            money = 0.0;
        }
        return String.format(MyApplication.applicationContext.getString(R.string.money_icon), money);
    }


    public static String pricePlaceholder(int money) {
        if (money <= 0) {
            money = 0;
        }
        return String.format(MyApplication.applicationContext.getString(R.string.money_icon), (double) money);
    }


}

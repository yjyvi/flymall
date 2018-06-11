package com.whmnrc.flymall.utils;

/**
 * @author yjyvi
 * @data 2018/6/4.
 */

public class CreateOrderUtils {

    public static String getProductAttrIds(String productAttrId, String goodsNum) {
        return String.format("%1s,%2s", productAttrId, goodsNum);
    }
}

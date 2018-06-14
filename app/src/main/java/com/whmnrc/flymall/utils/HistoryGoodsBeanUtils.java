package com.whmnrc.flymall.utils;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.beans.HistoryGoodsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/13.
 */

public class HistoryGoodsBeanUtils {

    private static List<HistoryGoodsBean> mHistoryGoodsBeans = new ArrayList<>();


    public static void saveGoods(HistoryGoodsBean historyGoodsBean) {
        if (historyGoodsBean != null) {
            if (!mHistoryGoodsBeans.contains(historyGoodsBean)) {
                mHistoryGoodsBeans.add(historyGoodsBean);
            }
            SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.HISTORY_GOODS, JSON.toJSONString(mHistoryGoodsBeans));
        }
    }


}

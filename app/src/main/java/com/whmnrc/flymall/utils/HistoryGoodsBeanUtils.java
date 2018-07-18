package com.whmnrc.flymall.utils;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.beans.HistoryGoodsBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yjyvi
 * @data 2018/6/13.
 */

public class HistoryGoodsBeanUtils {

    private static List<HistoryGoodsBean> mHistoryGoodsBeans = new ArrayList<>();
    private static Map<String, HistoryGoodsBean> mHistoryGoodsMap = new TreeMap<>();


    public static void saveGoods(HistoryGoodsBean historyGoodsBean) {
        if (historyGoodsBean != null) {
            mHistoryGoodsMap.put(historyGoodsBean.getGoodsId(), historyGoodsBean);
            mHistoryGoodsBeans.clear();
            for (String key : mHistoryGoodsMap.keySet()) {
                HistoryGoodsBean historyGoodsBean2 = mHistoryGoodsMap.get(key);
                mHistoryGoodsBeans.add(historyGoodsBean2);
            }
        }
        SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.HISTORY_GOODS, JSON.toJSONString(mHistoryGoodsBeans));
    }

    public static void clearHistory() {
        if (mHistoryGoodsBeans != null) {
            mHistoryGoodsBeans.clear();
        }

        if (mHistoryGoodsMap != null) {
            mHistoryGoodsMap.clear();
        }
        SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.HISTORY_GOODS, "");
    }


}

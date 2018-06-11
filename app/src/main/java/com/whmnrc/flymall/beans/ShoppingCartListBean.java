package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/5.
 */

public class ShoppingCartListBean {


    /**
     * type : 1
     * code : 0
     * message : 成功。
     * resultdata : [{"BuyCar_ID":"d1dfd7c4-3598-44c6-a5f8-ea0f23a34dfc","Goods_ID":"bd69ae37-02fe-41bc-bb85-337ec579e369","GoodsPrice_ID":"db13aa8c-d304-4091-a28b-6bb9fd534c1a","UserInfo_ID":"fb80d7ea-5667-4185-b8b8-4089b96542d0","BuyCar_Num":1,"BuyCar_CreateDate":"2018-06-05T09:56:15.423","GoodsPrice_Price":555,"Goods_Name":"这是商品名称","GoodsPrice_AttrName":"长裤","Goods_ImaPath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164361&di=40dcc97ef80aa6de3c2fbe2c6a9690f4&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F19%2F68%2F13%2F69C58PICRfS_1024.jpg","GoodsPrice_Stock":200,"GoodsPrice_Attribute":"白色"}]
     */

    private int type;
    private int code;
    private String message;
    private List<ResultdataBean> resultdata;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultdataBean> getResultdata() {
        return resultdata;
    }

    public void setResultdata(List<ResultdataBean> resultdata) {
        this.resultdata = resultdata;
    }

    public static class ResultdataBean {
        /**
         * BuyCar_ID : d1dfd7c4-3598-44c6-a5f8-ea0f23a34dfc
         * Goods_ID : bd69ae37-02fe-41bc-bb85-337ec579e369
         * GoodsPrice_ID : db13aa8c-d304-4091-a28b-6bb9fd534c1a
         * UserInfo_ID : fb80d7ea-5667-4185-b8b8-4089b96542d0
         * BuyCar_Num : 1
         * BuyCar_CreateDate : 2018-06-05T09:56:15.423
         * GoodsPrice_Price : 555
         * Goods_Name : 这是商品名称
         * GoodsPrice_AttrName : 长裤
         * Goods_ImaPath : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164361&di=40dcc97ef80aa6de3c2fbe2c6a9690f4&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F19%2F68%2F13%2F69C58PICRfS_1024.jpg
         * GoodsPrice_Stock : 200
         * GoodsPrice_Attribute : 白色
         */

        private String BuyCar_ID;
        private String Goods_ID;
        private String GoodsPrice_ID;
        private String UserInfo_ID;
        private int BuyCar_Num;
        private String BuyCar_CreateDate;
        private double GoodsPrice_Price;
        private String Goods_Name;
        private String GoodsPrice_AttrName;
        private String Goods_ImaPath;
        private int GoodsPrice_Stock;
        private String GoodsPrice_Attribute;
        private boolean isSelect;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public String getBuyCar_ID() {
            return BuyCar_ID;
        }

        public void setBuyCar_ID(String BuyCar_ID) {
            this.BuyCar_ID = BuyCar_ID;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getGoodsPrice_ID() {
            return GoodsPrice_ID;
        }

        public void setGoodsPrice_ID(String GoodsPrice_ID) {
            this.GoodsPrice_ID = GoodsPrice_ID;
        }

        public String getUserInfo_ID() {
            return UserInfo_ID;
        }

        public void setUserInfo_ID(String UserInfo_ID) {
            this.UserInfo_ID = UserInfo_ID;
        }

        public int getBuyCar_Num() {
            return BuyCar_Num;
        }

        public void setBuyCar_Num(int BuyCar_Num) {
            this.BuyCar_Num = BuyCar_Num;
        }

        public String getBuyCar_CreateDate() {
            return BuyCar_CreateDate;
        }

        public void setBuyCar_CreateDate(String BuyCar_CreateDate) {
            this.BuyCar_CreateDate = BuyCar_CreateDate;
        }

        public double getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(double GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoodsPrice_AttrName() {
            return GoodsPrice_AttrName;
        }

        public void setGoodsPrice_AttrName(String GoodsPrice_AttrName) {
            this.GoodsPrice_AttrName = GoodsPrice_AttrName;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

        public String getGoodsPrice_Attribute() {
            return GoodsPrice_Attribute;
        }

        public void setGoodsPrice_Attribute(String GoodsPrice_Attribute) {
            this.GoodsPrice_Attribute = GoodsPrice_Attribute;
        }
    }
}

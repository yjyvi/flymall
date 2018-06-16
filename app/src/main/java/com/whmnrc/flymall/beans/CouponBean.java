package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/31.
 */

public class CouponBean {


    /**
     * type : 1
     * code : 0
     * message : 请求成功
     * resultdata : [{"CouponId":59,"CouponName":"满500减100","CreateTime":"2018-06-14 12:52:00","EndTime":"2019-02-20 12:00:00","Num":10000,"OrderAmount":100,"OrderId":null,"PerMax":1,"Price":10,"ShopId":266,"ShopLogo":null,"ShopName":null,"StartTime":"2018-06-14 12:00:00","UserId":4109,"UseStatus":1,"UseTime":"2018-06-14 04:54:40","VShop":null,"VShopId":null},{"CouponId":58,"CouponName":"满100使用71","CreateTime":"2018-06-11 05:23:45","EndTime":"2019-03-29 12:00:00","Num":10000,"OrderAmount":10,"OrderId":null,"PerMax":1,"Price":5,"ShopId":266,"ShopLogo":null,"ShopName":null,"StartTime":"2018-06-11 12:00:00","UserId":4109,"UseStatus":1,"UseTime":"2018-06-14 04:59:22","VShop":null,"VShopId":null}]
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
         * CouponId : 59
         * CouponName : 满500减100
         * CreateTime : 2018-06-14 12:52:00
         * EndTime : 2019-02-20 12:00:00
         * Num : 10000
         * OrderAmount : 100.0
         * OrderId : null
         * PerMax : 1
         * Price : 10.0
         * ShopId : 266
         * ShopLogo : null
         * ShopName : null
         * StartTime : 2018-06-14 12:00:00
         * UserId : 4109
         * UseStatus : 1
         * UseTime : 2018-06-14 04:54:40
         * VShop : null
         * VShopId : null
         */

        private int CouponId;
        private String CouponName;
        private String CreateTime;
        private String EndTime;
        private int Num;
        private double OrderAmount;
        private Object OrderId;
        private int PerMax;
        private double Price;
        private int ShopId;
        private Object ShopLogo;
        private Object ShopName;
        private String StartTime;
        private int UserId;
        private int UseStatus;
        private String UseTime;
        private Object VShop;
        private Object VShopId;

        public int getCouponId() {
            return CouponId;
        }

        public void setCouponId(int CouponId) {
            this.CouponId = CouponId;
        }

        public String getCouponName() {
            return CouponName;
        }

        public void setCouponName(String CouponName) {
            this.CouponName = CouponName;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getNum() {
            return Num;
        }

        public void setNum(int Num) {
            this.Num = Num;
        }

        public double getOrderAmount() {
            return OrderAmount;
        }

        public void setOrderAmount(double OrderAmount) {
            this.OrderAmount = OrderAmount;
        }

        public Object getOrderId() {
            return OrderId;
        }

        public void setOrderId(Object OrderId) {
            this.OrderId = OrderId;
        }

        public int getPerMax() {
            return PerMax;
        }

        public void setPerMax(int PerMax) {
            this.PerMax = PerMax;
        }

        public double getPrice() {
            return Price;
        }

        public void setPrice(double Price) {
            this.Price = Price;
        }

        public int getShopId() {
            return ShopId;
        }

        public void setShopId(int ShopId) {
            this.ShopId = ShopId;
        }

        public Object getShopLogo() {
            return ShopLogo;
        }

        public void setShopLogo(Object ShopLogo) {
            this.ShopLogo = ShopLogo;
        }

        public Object getShopName() {
            return ShopName;
        }

        public void setShopName(Object ShopName) {
            this.ShopName = ShopName;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public int getUseStatus() {
            return UseStatus;
        }

        public void setUseStatus(int UseStatus) {
            this.UseStatus = UseStatus;
        }

        public String getUseTime() {
            return UseTime;
        }

        public void setUseTime(String UseTime) {
            this.UseTime = UseTime;
        }

        public Object getVShop() {
            return VShop;
        }

        public void setVShop(Object VShop) {
            this.VShop = VShop;
        }

        public Object getVShopId() {
            return VShopId;
        }

        public void setVShopId(Object VShopId) {
            this.VShopId = VShopId;
        }
    }
}

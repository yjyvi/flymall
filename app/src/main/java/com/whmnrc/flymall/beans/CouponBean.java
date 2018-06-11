package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/31.
 */

public class CouponBean {


    /**
     * type : 操作状态码
     * message : 返回消息
     * resultdata : [{"Coupon_ID":"优惠券主键","Goods_ID":"商品ID(暂时无用)","Coupon_Name":"优惠券名称","Coupon_FullQuota":"满多少额度减免","Coupon_ReduceQuota":"减免多少额度","Coupon_Time":"优惠券到期日期","Coupon_TimeNum":"优惠券使用天数（只针对模块优惠券有用）","Coupon_UserId":"使用者ID：管理员添加的模板默认为\u201c管理员\u201d。","Coupon_State":"使用状态：0：未使用；1：已使用；2：已过期；","Coupon_Num":"多少人使用（只针对管理员用户）","Coupon_ParentID":"优惠券模板ID"}]
     */

    private int type;
    private String message;
    private List<ResultdataBean> resultdata;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
         * Coupon_ID : 优惠券主键
         * Goods_ID : 商品ID(暂时无用)
         * Coupon_Name : 优惠券名称
         * Coupon_FullQuota : 满多少额度减免
         * Coupon_ReduceQuota : 减免多少额度
         * Coupon_Time : 优惠券到期日期
         * Coupon_TimeNum : 优惠券使用天数（只针对模块优惠券有用）
         * Coupon_UserId : 使用者ID：管理员添加的模板默认为“管理员”。
         * Coupon_State : 使用状态：0：未使用；1：已使用；2：已过期；
         * Coupon_Num : 多少人使用（只针对管理员用户）
         * Coupon_ParentID : 优惠券模板ID
         */

        private String Coupon_ID;
        private String Goods_ID;
        private String Coupon_Name;
        private double Coupon_FullQuota;
        private double Coupon_ReduceQuota;
        private String Coupon_Time;
        private String Coupon_TimeNum;
        private String Coupon_UserId;
        private int Coupon_State;
        private String Coupon_Num;
        private String Coupon_ParentID;

        public String getCoupon_ID() {
            return Coupon_ID;
        }

        public void setCoupon_ID(String Coupon_ID) {
            this.Coupon_ID = Coupon_ID;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getCoupon_Name() {
            return Coupon_Name;
        }

        public void setCoupon_Name(String Coupon_Name) {
            this.Coupon_Name = Coupon_Name;
        }

        public double getCoupon_FullQuota() {
            return Coupon_FullQuota;
        }

        public void setCoupon_FullQuota(double Coupon_FullQuota) {
            this.Coupon_FullQuota = Coupon_FullQuota;
        }

        public double getCoupon_ReduceQuota() {
            return Coupon_ReduceQuota;
        }

        public void setCoupon_ReduceQuota(double Coupon_ReduceQuota) {
            this.Coupon_ReduceQuota = Coupon_ReduceQuota;
        }

        public String getCoupon_Time() {
            return Coupon_Time;
        }

        public void setCoupon_Time(String Coupon_Time) {
            this.Coupon_Time = Coupon_Time;
        }

        public String getCoupon_TimeNum() {
            return Coupon_TimeNum;
        }

        public void setCoupon_TimeNum(String Coupon_TimeNum) {
            this.Coupon_TimeNum = Coupon_TimeNum;
        }

        public String getCoupon_UserId() {
            return Coupon_UserId;
        }

        public void setCoupon_UserId(String Coupon_UserId) {
            this.Coupon_UserId = Coupon_UserId;
        }

        public int getCoupon_State() {
            return Coupon_State;
        }

        public void setCoupon_State(int Coupon_State) {
            this.Coupon_State = Coupon_State;
        }

        public String getCoupon_Num() {
            return Coupon_Num;
        }

        public void setCoupon_Num(String Coupon_Num) {
            this.Coupon_Num = Coupon_Num;
        }

        public String getCoupon_ParentID() {
            return Coupon_ParentID;
        }

        public void setCoupon_ParentID(String Coupon_ParentID) {
            this.Coupon_ParentID = Coupon_ParentID;
        }
    }
}

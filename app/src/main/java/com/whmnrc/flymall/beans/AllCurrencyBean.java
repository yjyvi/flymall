package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class AllCurrencyBean {


    /**
     * code : 0
     * message : 请求成功
     * resultdata : {"Models":[{"Code":"￡","Currency_ID":5,"Currency_Name":"英镑","Currency_Price":10,"IsBase":0},{"Code":"¥ ","Currency_ID":4,"Currency_Name":"日元","Currency_Price":1.9,"IsBase":0},{"Code":"C$","Currency_ID":3,"Currency_Name":"加拿大元","Currency_Price":1.5,"IsBase":0},{"Code":"￥","Currency_ID":2,"Currency_Name":"人民币","Currency_Price":6.4,"IsBase":0},{"Code":"$","Currency_ID":1,"Currency_Name":"美元","Currency_Price":1,"IsBase":1}],"Total":5}
     * type : 1
     */

    private int code;
    private String message;
    private ResultdataBean resultdata;
    private int type;

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

    public ResultdataBean getResultdata() {
        return resultdata;
    }

    public void setResultdata(ResultdataBean resultdata) {
        this.resultdata = resultdata;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static class ResultdataBean {
        /**
         * Models : [{"Code":"￡","Currency_ID":5,"Currency_Name":"英镑","Currency_Price":10,"IsBase":0},{"Code":"¥ ","Currency_ID":4,"Currency_Name":"日元","Currency_Price":1.9,"IsBase":0},{"Code":"C$","Currency_ID":3,"Currency_Name":"加拿大元","Currency_Price":1.5,"IsBase":0},{"Code":"￥","Currency_ID":2,"Currency_Name":"人民币","Currency_Price":6.4,"IsBase":0},{"Code":"$","Currency_ID":1,"Currency_Name":"美元","Currency_Price":1,"IsBase":1}]
         * Total : 5
         */

        private int Total;
        private List<ModelsBean> Models;

        public int getTotal() {
            return Total;
        }

        public void setTotal(int Total) {
            this.Total = Total;
        }

        public List<ModelsBean> getModels() {
            return Models;
        }

        public void setModels(List<ModelsBean> Models) {
            this.Models = Models;
        }

        public static class ModelsBean {
            /**
             * Code : ￡
             * Currency_ID : 5
             * Currency_Name : 英镑
             * Currency_Price : 10.0
             * IsBase : 0
             */

            private String Code;
            private int Currency_ID;
            private String Currency_Name;
            private double Currency_Price;
            private int IsBase;

            public String getCode() {
                return Code;
            }

            public void setCode(String Code) {
                this.Code = Code;
            }

            public int getCurrency_ID() {
                return Currency_ID;
            }

            public void setCurrency_ID(int Currency_ID) {
                this.Currency_ID = Currency_ID;
            }

            public String getCurrency_Name() {
                return Currency_Name;
            }

            public void setCurrency_Name(String Currency_Name) {
                this.Currency_Name = Currency_Name;
            }

            public double getCurrency_Price() {
                return Currency_Price;
            }

            public void setCurrency_Price(double Currency_Price) {
                this.Currency_Price = Currency_Price;
            }

            public int getIsBase() {
                return IsBase;
            }

            public void setIsBase(int IsBase) {
                this.IsBase = IsBase;
            }
        }
    }
}

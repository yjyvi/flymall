package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class AllCurrencyBean {

    /**
     * type : 1
     * code : 0
     * message : 成功。
     * resultdata : [{"Currency_ID":"0aed0e03-a110-40ff-939f-87c52146a09d","Currency_Name":"软妹币","Currency_Price":1,"Code":null},{"Currency_ID":"39930947-50af-4385-ae61-33526808d566","Currency_Name":"美元","Currency_Price":7,"Code":null}]
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
         * Currency_ID : 0aed0e03-a110-40ff-939f-87c52146a09d
         * Currency_Name : 软妹币
         * Currency_Price : 1
         * Code : null
         */

        private String Currency_ID;
        private String Currency_Name;
        private double Currency_Price;
        private String Code;

        public String getCurrency_ID() {
            return Currency_ID;
        }

        public void setCurrency_ID(String Currency_ID) {
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

        public String  getCode() {
            return Code;
        }

        public void setCode(String Code) {
            this.Code = Code;
        }
    }
}

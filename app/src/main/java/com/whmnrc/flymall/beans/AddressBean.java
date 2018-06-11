package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class AddressBean {


    /**
     * type : 1
     * code : 0
     * message : 成功。
     * resultdata : [{"Address_ID":"06456df4-b9d5-433e-bb29-7f04976b870a","Address_Mobile":"13554542559","Address_Name":"string","Address_Provice":"string","Address_City":"string","Address_Region":"string","Address_Detail":"string","Address_CreateTime":"2018-05-30T17:46:10.37","UserInfo_ID":"fb80d7ea-5667-4185-b8b8-4089b96542d0","Address_IsDefault":0}]
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
         * Address_ID : 06456df4-b9d5-433e-bb29-7f04976b870a
         * Address_Mobile : 13554542559
         * Address_Name : string
         * Address_Provice : string
         * Address_City : string
         * Address_Region : string
         * Address_Detail : string
         * Address_CreateTime : 2018-05-30T17:46:10.37
         * UserInfo_ID : fb80d7ea-5667-4185-b8b8-4089b96542d0
         * Address_IsDefault : 0
         */

        private String Address_ID;
        private String Address_Mobile;
        private String Address_Name;
        private String Address_Provice;
        private String Address_City;
        private String Address_Region;
        private String Address_Detail;
        private String Address_CreateTime;
        private String UserInfo_ID;
        private int Address_IsDefault;

        public String getAddress_ID() {
            return Address_ID;
        }

        public void setAddress_ID(String Address_ID) {
            this.Address_ID = Address_ID;
        }

        public String getAddress_Mobile() {
            return Address_Mobile;
        }

        public void setAddress_Mobile(String Address_Mobile) {
            this.Address_Mobile = Address_Mobile;
        }

        public String getAddress_Name() {
            return Address_Name;
        }

        public void setAddress_Name(String Address_Name) {
            this.Address_Name = Address_Name;
        }

        public String getAddress_Provice() {
            return Address_Provice;
        }

        public void setAddress_Provice(String Address_Provice) {
            this.Address_Provice = Address_Provice;
        }

        public String getAddress_City() {
            return Address_City;
        }

        public void setAddress_City(String Address_City) {
            this.Address_City = Address_City;
        }

        public String getAddress_Region() {
            return Address_Region;
        }

        public void setAddress_Region(String Address_Region) {
            this.Address_Region = Address_Region;
        }

        public String getAddress_Detail() {
            return Address_Detail;
        }

        public void setAddress_Detail(String Address_Detail) {
            this.Address_Detail = Address_Detail;
        }

        public String getAddress_CreateTime() {
            return Address_CreateTime;
        }

        public void setAddress_CreateTime(String Address_CreateTime) {
            this.Address_CreateTime = Address_CreateTime;
        }

        public String getUserInfo_ID() {
            return UserInfo_ID;
        }

        public void setUserInfo_ID(String UserInfo_ID) {
            this.UserInfo_ID = UserInfo_ID;
        }

        public int getAddress_IsDefault() {
            return Address_IsDefault;
        }

        public void setAddress_IsDefault(int Address_IsDefault) {
            this.Address_IsDefault = Address_IsDefault;
        }
    }
}

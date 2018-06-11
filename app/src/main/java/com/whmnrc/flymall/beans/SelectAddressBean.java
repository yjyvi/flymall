package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/4.
 */

public class SelectAddressBean  {


    /**
     * code : 0
     * message : 请求成功
     * resultdata : [{"AreaCode":"0086","AreaName":"中国","Id":1,"Layer":1,"MobilePhoneCode":"+86","ParentId":0}]
     * type : 1
     */

    private int code;
    private String message;
    private int type;
    private List<ResultdataBean> resultdata;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ResultdataBean> getResultdata() {
        return resultdata;
    }

    public void setResultdata(List<ResultdataBean> resultdata) {
        this.resultdata = resultdata;
    }

    public static class ResultdataBean {
        /**
         * AreaCode : 0086
         * AreaName : 中国
         * Id : 1
         * Layer : 1
         * MobilePhoneCode : +86
         * ParentId : 0
         */

        private String AreaCode;
        private String AreaName;
        private int Id;
        private int Layer;
        private String MobilePhoneCode;
        private int ParentId;

        public String getAreaCode() {
            return AreaCode;
        }

        public void setAreaCode(String AreaCode) {
            this.AreaCode = AreaCode;
        }

        public String getAreaName() {
            return AreaName;
        }

        public void setAreaName(String AreaName) {
            this.AreaName = AreaName;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getLayer() {
            return Layer;
        }

        public void setLayer(int Layer) {
            this.Layer = Layer;
        }

        public String getMobilePhoneCode() {
            return MobilePhoneCode;
        }

        public void setMobilePhoneCode(String MobilePhoneCode) {
            this.MobilePhoneCode = MobilePhoneCode;
        }

        public int getParentId() {
            return ParentId;
        }

        public void setParentId(int ParentId) {
            this.ParentId = ParentId;
        }
    }
}

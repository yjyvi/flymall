package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class HomeActivityGoodsBean  {


    /**
     * type : 1
     * code : 0
     * message : 请求成功
     * resultdata : [{"Id":45,"Name":"每日逛","ImageUrl":"/Storage/Plat/Topic/45/201806081350105418540.jpg"},{"Id":44,"Name":"特色推荐","ImageUrl":"/Storage/Plat/Topic/44/201806081349049103030.jpg"},{"Id":43,"Name":"实惠好货","ImageUrl":"/Storage/Plat/Topic/43/201806081347430391620.jpg"},{"Id":42,"Name":"品质生活","ImageUrl":"/Storage/Plat/Topic/42/201806081344341519040.jpg"},{"Id":41,"Name":"潮玩先锋","ImageUrl":"/Storage/Plat/Topic/41/201806080903191388380.jpg"}]
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
         * Id : 45
         * Name : 每日逛
         * ImageUrl : /Storage/Plat/Topic/45/201806081350105418540.jpg
         */

        private int Id;
        private String Name;
        private String ImageUrl;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.ImageUrl = ImageUrl;
        }
    }
}

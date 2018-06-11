package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/29.
 */

public class AllVideoBean   {

    /**
     * type : 1
     * code : 0
     * message : 成功。
     * resultdata : [{"Video_ID":"5ff71e00-2d57-4e5b-a163-257d60ef40c3","Video_Path":"/Resource/PhotoFile/ab9a342f-8214-4bed-a619-d32d41754206.mp4","Goods_ID":null,"Goods_Name":"裤子","Video_IsHomePage":true,"Video_Thumbnail":""},{"Video_ID":"6c1dece3-77df-4e4d-ba38-147f6cca7487","Video_Path":"/Resource/PhotoFile/5ee5bc68-92b1-471b-b9ff-b2559fa9fa1c.mp4","Goods_ID":null,"Goods_Name":"衣服","Video_IsHomePage":true,"Video_Thumbnail":""},{"Video_ID":"6e0d4e5d-2630-44be-b557-b1314b1872f8","Video_Path":"/Resource/PhotoFile/fce4495c-c52b-4514-91e3-b6e824da65d4.mp4","Goods_ID":null,"Goods_Name":"裤子","Video_IsHomePage":true,"Video_Thumbnail":""},{"Video_ID":"75241b7d-7eec-4dad-a57b-1048ed7984eb","Video_Path":"/Resource/PhotoFile/32ba6ad1-5742-4134-b7d3-fa9419fe478e.mp4","Goods_ID":null,"Goods_Name":"鞋子","Video_IsHomePage":true,"Video_Thumbnail":""},{"Video_ID":"9aaa74a6-90df-4b2b-a5ac-e29225260af7","Video_Path":"/Resource/PhotoFile/6770f8ad-2574-4353-be14-5d75a5b328aa.mp4","Goods_ID":null,"Goods_Name":"裤子","Video_IsHomePage":true,"Video_Thumbnail":""},{"Video_ID":"c0c80996-38c3-4d40-8d41-1f6e30599c55","Video_Path":"/Resource/PhotoFile/beb6949c-b75b-4877-bb97-de681d5fcc2c.mp4","Goods_ID":null,"Goods_Name":"衣服","Video_IsHomePage":true,"Video_Thumbnail":""},{"Video_ID":"f5085884-7b3f-4ffe-9167-d549bf82c2f7","Video_Path":"/Resource/PhotoFile/4f83bd42-f62b-4800-b81f-6d3461b3940f.mp4","Goods_ID":null,"Goods_Name":"裤子","Video_IsHomePage":true,"Video_Thumbnail":""},{"Video_ID":"fa03e256-875e-4e9e-a2ba-12d944783600","Video_Path":"/Resource/PhotoFile/157f79df-087f-42a5-9fb7-5c109e4c9513.mp4","Goods_ID":null,"Goods_Name":"鞋子","Video_IsHomePage":false,"Video_Thumbnail":""}]
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
         * Video_ID : 5ff71e00-2d57-4e5b-a163-257d60ef40c3
         * Video_Path : /Resource/PhotoFile/ab9a342f-8214-4bed-a619-d32d41754206.mp4
         * Goods_ID : null
         * Goods_Name : 裤子
         * Video_IsHomePage : true
         * Video_Thumbnail :
         */

        private String Video_ID;
        private String Video_Path;
        private String  Goods_ID;
        private String Goods_Name;
        private int Video_IsHomePage;
        private String Video_Thumbnail;

        public String getVideo_ID() {
            return Video_ID;
        }

        public void setVideo_ID(String Video_ID) {
            this.Video_ID = Video_ID;
        }

        public String getVideo_Path() {
            return Video_Path;
        }

        public void setVideo_Path(String Video_Path) {
            this.Video_Path = Video_Path;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public int isVideo_IsHomePage() {
            return Video_IsHomePage;
        }

        public void setVideo_IsHomePage(int Video_IsHomePage) {
            this.Video_IsHomePage = Video_IsHomePage;
        }

        public String getVideo_Thumbnail() {
            return Video_Thumbnail;
        }

        public void setVideo_Thumbnail(String Video_Thumbnail) {
            this.Video_Thumbnail = Video_Thumbnail;
        }
    }
}

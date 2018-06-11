package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/29.
 */

public class AllVideoBean   {

    /**
     * code : 0
     * message : 请求成功
     * resultdata : [{"CreateDate":"2018-06-05 02:03:30","Description":"这是第一个视频描述","Id":1,"ImageUrl":"/Storage/Video/Thumbnail/780aabf4-38bf-46b5-a92c-ff7c428c4eea.jpg","IsShow":1,"ProductId":182,"VideoName":"这是第一个视频名称","VideoUrl":"/Storage/Video/Videos/9dcdc410-42db-4fd2-9ca8-d32bd21c073a.mp4"},{"CreateDate":"2018-06-08 02:03:36","Description":"这是第二个视频描述","Id":2,"ImageUrl":"/Storage/Video/Thumbnail/f413bae5-86e7-4490-b653-be55e60a1fcb.jpg","IsShow":0,"ProductId":181,"VideoName":"这是第二个视频名称","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4"}]
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
         * CreateDate : 2018-06-05 02:03:30
         * Description : 这是第一个视频描述
         * Id : 1
         * ImageUrl : /Storage/Video/Thumbnail/780aabf4-38bf-46b5-a92c-ff7c428c4eea.jpg
         * IsShow : 1
         * ProductId : 182
         * VideoName : 这是第一个视频名称
         * VideoUrl : /Storage/Video/Videos/9dcdc410-42db-4fd2-9ca8-d32bd21c073a.mp4
         */

        private String CreateDate;
        private String Description;
        private int Id;
        private String ImageUrl;
        private int IsShow;
        private int ProductId;
        private String VideoName;
        private String VideoUrl;

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.ImageUrl = ImageUrl;
        }

        public int getIsShow() {
            return IsShow;
        }

        public void setIsShow(int IsShow) {
            this.IsShow = IsShow;
        }

        public int getProductId() {
            return ProductId;
        }

        public void setProductId(int ProductId) {
            this.ProductId = ProductId;
        }

        public String getVideoName() {
            return VideoName;
        }

        public void setVideoName(String VideoName) {
            this.VideoName = VideoName;
        }

        public String getVideoUrl() {
            return VideoUrl;
        }

        public void setVideoUrl(String VideoUrl) {
            this.VideoUrl = VideoUrl;
        }
    }
}

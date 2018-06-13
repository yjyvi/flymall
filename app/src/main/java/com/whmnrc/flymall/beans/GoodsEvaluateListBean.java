package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/1.
 */

public class GoodsEvaluateListBean {

    /**
     * type : 1
     * code : 0
     * message : 请求成功
     * resultdata : {"Models":[{"Id":15,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:36","Stars":5},{"Id":14,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:35","Stars":5},{"Id":13,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:33","Stars":5},{"Id":12,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:31","Stars":5},{"Id":11,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:30","Stars":5},{"Id":10,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:28","Stars":5},{"Id":9,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:26","Stars":5},{"Id":8,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:24","Stars":5},{"Id":7,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:23","Stars":5},{"Id":6,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:21","Stars":5}],"Total":15}
     */

    private int type;
    private int code;
    private String message;
    private ResultdataBean resultdata;

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

    public ResultdataBean getResultdata() {
        return resultdata;
    }

    public void setResultdata(ResultdataBean resultdata) {
        this.resultdata = resultdata;
    }

    public static class ResultdataBean {
        /**
         * Models : [{"Id":15,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:36","Stars":5},{"Id":14,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:35","Stars":5},{"Id":13,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:33","Stars":5},{"Id":12,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:31","Stars":5},{"Id":11,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:30","Stars":5},{"Id":10,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:28","Stars":5},{"Id":9,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:26","Stars":5},{"Id":8,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:24","Stars":5},{"Id":7,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:23","Stars":5},{"Id":6,"ProductId":1452,"Nick":"专业电商五十年","Photo":"/Storage/Small/headPhoto/13554151871/20171208142511397.jpg","UserId":2034,"Images":"/Storage/Plat/Brand/logo_106.jpg","VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","CommentContent":null,"ThumImg":"/Storage/Plat/Brand/logo_106.jpg","Color":"","Size":"","Version":"","CreateDate":"2018-06-13 11:14:21","Stars":5}]
         * Total : 15
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
             * Id : 15
             * ProductId : 1452
             * Nick : 专业电商五十年
             * Photo : /Storage/Small/headPhoto/13554151871/20171208142511397.jpg
             * UserId : 2034
             * Images : /Storage/Plat/Brand/logo_106.jpg
             * VideoUrl : /Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4
             * CommentContent : null
             * ThumImg : /Storage/Plat/Brand/logo_106.jpg
             * Color :
             * Size :
             * Version :
             * CreateDate : 2018-06-13 11:14:36
             * Stars : 5
             */

            private int Id;
            private int ProductId;
            private String Nick;
            private String Photo;
            private int UserId;
            private String Images;
            private String VideoUrl;
            private String CommentContent;
            private String ThumImg;
            private String Color;
            private String Size;
            private String Version;
            private String CreateDate;
            private int Stars;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public int getProductId() {
                return ProductId;
            }

            public void setProductId(int ProductId) {
                this.ProductId = ProductId;
            }

            public String getNick() {
                return Nick;
            }

            public void setNick(String Nick) {
                this.Nick = Nick;
            }

            public String getPhoto() {
                return Photo;
            }

            public void setPhoto(String Photo) {
                this.Photo = Photo;
            }

            public int getUserId() {
                return UserId;
            }

            public void setUserId(int UserId) {
                this.UserId = UserId;
            }

            public String getImages() {
                return Images;
            }

            public void setImages(String Images) {
                this.Images = Images;
            }

            public String getVideoUrl() {
                return VideoUrl;
            }

            public void setVideoUrl(String VideoUrl) {
                this.VideoUrl = VideoUrl;
            }

            public String  getCommentContent() {
                return CommentContent;
            }

            public void setCommentContent(String CommentContent) {
                this.CommentContent = CommentContent;
            }

            public String getThumImg() {
                return ThumImg;
            }

            public void setThumImg(String ThumImg) {
                this.ThumImg = ThumImg;
            }

            public String getColor() {
                return Color;
            }

            public void setColor(String Color) {
                this.Color = Color;
            }

            public String getSize() {
                return Size;
            }

            public void setSize(String Size) {
                this.Size = Size;
            }

            public String getVersion() {
                return Version;
            }

            public void setVersion(String Version) {
                this.Version = Version;
            }

            public String getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(String CreateDate) {
                this.CreateDate = CreateDate;
            }

            public int getStars() {
                return Stars;
            }

            public void setStars(int Stars) {
                this.Stars = Stars;
            }
        }
    }
}

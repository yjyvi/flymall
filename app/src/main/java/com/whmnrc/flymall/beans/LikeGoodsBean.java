package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/11.
 */

public class LikeGoodsBean {


    /**
     * code : 0
     * message : 请求成功
     * resultdata : [{"CommentsCount":0,"Id":1349,"ImageUrl":"/Storage/Shop/266/Products/1349/1_350.png","MarketPrice":2424,"Name":"蜗牛净化润颜紧致6件套，光滑透亮，重现新生！","SalePrice":44},{"CommentsCount":0,"Id":739,"ImageUrl":"/Storage/Shop/266/Products/739/1_350.png","MarketPrice":360,"Name":"（6盒装）天地通远红外磁疗贴","SalePrice":180},{"CommentsCount":0,"Id":1450,"ImageUrl":"/Storage/Shop/266/Products/1450/1_350.png","MarketPrice":358,"Name":"（新、藏、蒙、琼不发货）燕山红甘栗仁礼盒600g*2盒/件","SalePrice":298},{"CommentsCount":0,"Id":899,"ImageUrl":"/Storage/Shop/266/Products/899/1_350.png","MarketPrice":85,"Name":"南极人3条礼盒装男士精品内裤 夏季冰丝中腰短裤衩U凸平角底裤头","SalePrice":65},{"CommentsCount":0,"Id":947,"ImageUrl":"/Storage/Shop/266/Products/947/1_350.png","MarketPrice":70,"Name":"纸巾抽纸卫生纸餐巾纸清风原木200抽取式整箱18包","SalePrice":55}]
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
         * CommentsCount : 0
         * Id : 1349
         * ImageUrl : /Storage/Shop/266/Products/1349/1_350.png
         * MarketPrice : 2424.0
         * Name : 蜗牛净化润颜紧致6件套，光滑透亮，重现新生！
         * SalePrice : 44.0
         */

        private int CommentsCount;
        private int Id;
        private String ImageUrl;
        private double MarketPrice;
        private String Name;
        private double SalePrice;

        public int getCommentsCount() {
            return CommentsCount;
        }

        public void setCommentsCount(int CommentsCount) {
            this.CommentsCount = CommentsCount;
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

        public double getMarketPrice() {
            return MarketPrice;
        }

        public void setMarketPrice(double MarketPrice) {
            this.MarketPrice = MarketPrice;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public double getSalePrice() {
            return SalePrice;
        }

        public void setSalePrice(double SalePrice) {
            this.SalePrice = SalePrice;
        }
    }
}

package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/4.
 */

public class CollectionListBean {


    /**
     * code : 0
     * message : 请求成功
     * resultdata : [{"Evaluation":0,"Id":1485,"Image":"/Storage/Shop/266/Products/1485/1_220.png","ProductName":"乔治汤米男短袖圆领T恤SQ081002","SalePrice":"96.00"},{"Evaluation":0,"Id":980,"Image":"/Storage/Shop/266/Products/980/1_220.png","ProductName":"荏仟堂 陶瓷粗陶一杯一壶快客杯旅行茶具单杯定制旅行包创意","SalePrice":"92.00"},{"Evaluation":0,"Id":1311,"Image":"/Storage/Shop/266/Products/1311/1_220.png","ProductName":"万利达8825吹风机","SalePrice":"160.00"},{"Evaluation":0,"Id":584,"Image":"/Storage/Shop/266/Products/584/1_220.png","ProductName":"草莓果茶整箱6瓶特惠","SalePrice":"105.00"}]
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
         * Evaluation : 0
         * Id : 1485
         * Image : /Storage/Shop/266/Products/1485/1_220.png
         * ProductName : 乔治汤米男短袖圆领T恤SQ081002
         * SalePrice : 96.00
         */

        private int Evaluation;
        private int Id;
        private String Image;
        private String ProductName;
        private String SalePrice;
        private  boolean isSelect;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public int getEvaluation() {
            return Evaluation;
        }

        public void setEvaluation(int Evaluation) {
            this.Evaluation = Evaluation;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String ProductName) {
            this.ProductName = ProductName;
        }

        public String getSalePrice() {
            return SalePrice;
        }

        public void setSalePrice(String SalePrice) {
            this.SalePrice = SalePrice;
        }
    }
}

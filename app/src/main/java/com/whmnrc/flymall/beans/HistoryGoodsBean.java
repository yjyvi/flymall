package com.whmnrc.flymall.beans;

/**
 * @author yjyvi
 * @data 2018/6/13.
 */

public class HistoryGoodsBean {


    private String goodsId;
    private String goodsName;
    private double goodsMinPrice;
    private double goodsMaxPrice;
    private String goodsSold;
    private String goodsImg;

    public HistoryGoodsBean() {
    }

    public HistoryGoodsBean(String goodsId,String goodsName,  double goodsMinPrice, double goodsMaxPrice, String goodsSold, String goodsImg) {
        this.goodsId  = goodsId;
        this.goodsName = goodsName;
        this.goodsMinPrice = goodsMinPrice;
        this.goodsMaxPrice = goodsMaxPrice;
        this.goodsSold = goodsSold;
        this.goodsImg = goodsImg;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    public double getGoodsMinPrice() {
        return goodsMinPrice;
    }

    public void setGoodsMinPrice(double goodsMinPrice) {
        this.goodsMinPrice = goodsMinPrice;
    }

    public double getGoodsMaxPrice() {
        return goodsMaxPrice;
    }

    public void setGoodsMaxPrice(double goodsMaxPrice) {
        this.goodsMaxPrice = goodsMaxPrice;
    }

    public String getGoodsSold() {
        return goodsSold;
    }

    public void setGoodsSold(String goodsSold) {
        this.goodsSold = goodsSold;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
}

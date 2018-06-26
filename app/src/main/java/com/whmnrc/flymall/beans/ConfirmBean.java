package com.whmnrc.flymall.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author yjyvi
 * @data 2018/6/5.
 */

public class ConfirmBean  implements Parcelable{

    private String priceIds;
    private int goodsNUm;
    private double Goods_SourcePrice;
    private double GoodsPrice_Price;
    private String Goods_ImaPath;
    private String Goods_Name;
    private String Goods_Describe;
    private String goods_spec;
    private String goodsId;


    protected ConfirmBean(Parcel in) {
        priceIds = in.readString();
        goodsNUm = in.readInt();
        Goods_SourcePrice = in.readDouble();
        GoodsPrice_Price = in.readDouble();
        Goods_ImaPath = in.readString();
        Goods_Name = in.readString();
        Goods_Describe = in.readString();
        goods_spec = in.readString();
        goodsId = in.readString();
    }

    public static final Creator<ConfirmBean> CREATOR = new Creator<ConfirmBean>() {
        @Override
        public ConfirmBean createFromParcel(Parcel in) {
            return new ConfirmBean(in);
        }

        @Override
        public ConfirmBean[] newArray(int size) {
            return new ConfirmBean[size];
        }
    };

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoods_spec() {
        return goods_spec;
    }

    public void setGoods_spec(String goods_spec) {
        this.goods_spec = goods_spec;
    }

    public ConfirmBean() {
    }



    public String getPriceIds() {
        return priceIds;
    }

    public void setPriceIds(String priceIds) {
        this.priceIds = priceIds;
    }

    public int getGoodsNUm() {
        return goodsNUm;
    }

    public void setGoodsNUm(int goodsNUm) {
        this.goodsNUm = goodsNUm;
    }

    public double getGoods_SourcePrice() {
        return Goods_SourcePrice;
    }

    public void setGoods_SourcePrice(double goods_SourcePrice) {
        Goods_SourcePrice = goods_SourcePrice;
    }

    public double getGoodsPrice_Price() {
        return GoodsPrice_Price;
    }

    public void setGoodsPrice_Price(double goodsPrice_Price) {
        GoodsPrice_Price = goodsPrice_Price;
    }

    public String getGoods_ImaPath() {
        return Goods_ImaPath;
    }

    public void setGoods_ImaPath(String goods_ImaPath) {
        Goods_ImaPath = goods_ImaPath;
    }

    public String getGoods_Name() {
        return Goods_Name;
    }

    public void setGoods_Name(String goods_Name) {
        Goods_Name = goods_Name;
    }

    public String getGoods_Describe() {
        return Goods_Describe;
    }

    public void setGoods_Describe(String goods_Describe) {
        Goods_Describe = goods_Describe;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(priceIds);
        dest.writeInt(goodsNUm);
        dest.writeDouble(Goods_SourcePrice);
        dest.writeDouble(GoodsPrice_Price);
        dest.writeString(Goods_ImaPath);
        dest.writeString(Goods_Name);
        dest.writeString(Goods_Describe);
        dest.writeString(goods_spec);
        dest.writeString(goodsId);
    }
}

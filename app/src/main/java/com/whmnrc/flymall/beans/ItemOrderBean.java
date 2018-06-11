package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * Created by yong hao zeng on 2017/12/18.
 */

public class ItemOrderBean {
    String Business_ID;
    String shopName;
    String shopID;
    double Order_Money;
    double Order_Freight;
    String UserInfo_ID;
    String Address_ID;
    private String carId;

    public String getShopID() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public String getAddress_ID() {
        return Address_ID;
    }

    public void setAddress_ID(String address_ID) {
        Address_ID = address_ID;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String userInfo_ID) {
        UserInfo_ID = userInfo_ID;
    }

    public double getOrder_Freight() {
        return Order_Freight;
    }

    public void setOrder_Freight(double order_Freight) {
        Order_Freight = order_Freight;
    }

    List<OrderItemList> OrderItemList;
    String Order_Remark = "";

    public String getOrder_Remark() {
        return Order_Remark;
    }

    public void setOrder_Remark(String order_Remark) {
        this.Order_Remark = order_Remark;
    }

    public String getBusiness_ID() {
        return Business_ID;
    }

    public void setBusiness_ID(String business_ID) {
        this.Business_ID = business_ID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public double getOrder_Money() {
        return Order_Money;
    }

    public void setOrder_Money(double order_Money) {
        this.Order_Money = order_Money;
    }



    public List<OrderItemList> getOrderItemList() {
        return OrderItemList;
    }

    public void setOrderItemList(List<OrderItemList> orderItemList) {
        this.OrderItemList = orderItemList;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public static class OrderItemList {
        String BuyCarID;
        private String bunninessId;

        public String getBuyCarID() {
            return BuyCarID;
        }

        public void setBuyCarID(String buyCarID) {
            BuyCarID = buyCarID;
        }



        double freight;
        String CommodityPrice_ID;
        String goodsName;
        String goodsImg;

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsImg() {
            return goodsImg;
        }

        public void setGoodsImg(String goodsImg) {
            this.goodsImg = goodsImg;
        }

        public String getCommodityPrice_ID() {
            return CommodityPrice_ID;
        }

        public void setCommodityPrice_ID(String commodityPrice_ID) {
            CommodityPrice_ID = commodityPrice_ID;
        }
        public double getFreight() {
            return freight;
        }

        public void setFreight(double freight) {
            this.freight = freight;
        }

        String DescriptionOne;
        String Commodity_ID;

        public String getCommodity_ID() {
            return Commodity_ID;
        }

        public void setCommodity_ID(String commodity_ID) {
            Commodity_ID = commodity_ID;
        }

        String DescriptionTwo;
   double unitPrice;
    double sum;
    int Number;

        public String getDescriptionOne() {
            return DescriptionOne;
        }

        public void setDescriptionOne(String descriptionOne) {
            this.DescriptionOne = descriptionOne;
        }

        public String getDescriptionTwo() {
            return DescriptionTwo;
        }

        public void setDescriptionTwo(String descriptionTwo) {
            this.DescriptionTwo = descriptionTwo;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }


        public String getBunninessId() {
            return bunninessId;
        }

        public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        this.Number = number;
    }


        public void setBunninessId(String bunninessId) {
            this.bunninessId = bunninessId;
        }
    }
}

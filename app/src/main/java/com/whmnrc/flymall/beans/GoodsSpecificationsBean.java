package com.whmnrc.flymall.beans;

/**
 * @author yjyvi
 * @data 2018/5/31.
 */

public class GoodsSpecificationsBean  {


    /**
     * type : 1
     * code : 0
     * message : 1
     * resultdata : {"AutoId":12184,"Color":"黑色","CostPrice":32,"Id":"1485_129_17_0","ProductId":1485,"SalePrice":96,"Size":"M","Sku":"","Stock":179999,"Version":""}
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
         * AutoId : 12184
         * Color : 黑色
         * CostPrice : 32.0
         * Id : 1485_129_17_0
         * ProductId : 1485
         * SalePrice : 96.0
         * Size : M
         * Sku :
         * Stock : 179999
         * Version :
         */

        private int AutoId;
        private String Color;
        private double CostPrice;
        private String Id;
        private int ProductId;
        private double SalePrice;
        private String Size;
        private String Sku;
        private int Stock;
        private String Version;

        public int getAutoId() {
            return AutoId;
        }

        public void setAutoId(int AutoId) {
            this.AutoId = AutoId;
        }

        public String getColor() {
            return Color;
        }

        public void setColor(String Color) {
            this.Color = Color;
        }

        public double getCostPrice() {
            return CostPrice;
        }

        public void setCostPrice(double CostPrice) {
            this.CostPrice = CostPrice;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public int getProductId() {
            return ProductId;
        }

        public void setProductId(int ProductId) {
            this.ProductId = ProductId;
        }

        public double getSalePrice() {
            return SalePrice;
        }

        public void setSalePrice(double SalePrice) {
            this.SalePrice = SalePrice;
        }

        public String getSize() {
            return Size;
        }

        public void setSize(String Size) {
            this.Size = Size;
        }

        public String getSku() {
            return Sku;
        }

        public void setSku(String Sku) {
            this.Sku = Sku;
        }

        public int getStock() {
            return Stock;
        }

        public void setStock(int Stock) {
            this.Stock = Stock;
        }

        public String getVersion() {
            return Version;
        }

        public void setVersion(String Version) {
            this.Version = Version;
        }
    }
}

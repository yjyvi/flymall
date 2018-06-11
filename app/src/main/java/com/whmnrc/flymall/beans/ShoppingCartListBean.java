package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/5.
 */

public class ShoppingCartListBean {


    /**
     * code : 0
     * message : 请求成功
     * resultdata : {"amount":384,"products":[{"cartItemId":657,"color":"白色","count":1,"id":1485,"imgUrl":"/Storage/Shop/266/Products/1485/1_350.png","name":"乔治汤米男短袖圆领T恤SQ081002","price":96,"shopId":266,"shopLogo":"","shopName":"百货商店","size":"2XL","skuId":"1485_131_621_0","status":1,"version":"","vshopId":0},{"cartItemId":658,"color":"灰色","count":1,"id":1485,"imgUrl":"/Storage/Shop/266/Products/1485/1_350.png","name":"乔治汤米男短袖圆领T恤SQ081002","price":96,"shopId":266,"shopLogo":"","shopName":"百货商店","size":"2XL","skuId":"1485_130_621_0","status":1,"version":"","vshopId":0},{"cartItemId":659,"color":"黑色","count":1,"id":1485,"imgUrl":"/Storage/Shop/266/Products/1485/1_350.png","name":"乔治汤米男短袖圆领T恤SQ081002","price":96,"shopId":266,"shopLogo":"","shopName":"百货商店","size":"2XL","skuId":"1485_129_621_0","status":1,"version":"","vshopId":0},{"cartItemId":660,"color":"白色","count":1,"id":1485,"imgUrl":"/Storage/Shop/266/Products/1485/1_350.png","name":"乔治汤米男短袖圆领T恤SQ081002","price":96,"shopId":266,"shopLogo":"","shopName":"百货商店","size":"XL","skuId":"1485_131_19_0","status":1,"version":"","vshopId":0}],"totalCount":4}
     * type : 1
     */

    private int code;
    private String message;
    private ResultdataBean resultdata;
    private int type;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static class ResultdataBean {
        /**
         * amount : 384.0
         * products : [{"cartItemId":657,"color":"白色","count":1,"id":1485,"imgUrl":"/Storage/Shop/266/Products/1485/1_350.png","name":"乔治汤米男短袖圆领T恤SQ081002","price":96,"shopId":266,"shopLogo":"","shopName":"百货商店","size":"2XL","skuId":"1485_131_621_0","status":1,"version":"","vshopId":0},{"cartItemId":658,"color":"灰色","count":1,"id":1485,"imgUrl":"/Storage/Shop/266/Products/1485/1_350.png","name":"乔治汤米男短袖圆领T恤SQ081002","price":96,"shopId":266,"shopLogo":"","shopName":"百货商店","size":"2XL","skuId":"1485_130_621_0","status":1,"version":"","vshopId":0},{"cartItemId":659,"color":"黑色","count":1,"id":1485,"imgUrl":"/Storage/Shop/266/Products/1485/1_350.png","name":"乔治汤米男短袖圆领T恤SQ081002","price":96,"shopId":266,"shopLogo":"","shopName":"百货商店","size":"2XL","skuId":"1485_129_621_0","status":1,"version":"","vshopId":0},{"cartItemId":660,"color":"白色","count":1,"id":1485,"imgUrl":"/Storage/Shop/266/Products/1485/1_350.png","name":"乔治汤米男短袖圆领T恤SQ081002","price":96,"shopId":266,"shopLogo":"","shopName":"百货商店","size":"XL","skuId":"1485_131_19_0","status":1,"version":"","vshopId":0}]
         * totalCount : 4
         */

        private double amount;
        private int totalCount;
        private List<ProductsBean> products;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            /**
             * cartItemId : 657
             * color : 白色
             * count : 1
             * id : 1485
             * imgUrl : /Storage/Shop/266/Products/1485/1_350.png
             * name : 乔治汤米男短袖圆领T恤SQ081002
             * price : 96.0
             * shopId : 266
             * shopLogo :
             * shopName : 百货商店
             * size : 2XL
             * skuId : 1485_131_621_0
             * status : 1
             * version :
             * vshopId : 0
             */

            private int cartItemId;
            private String color;
            private int count;
            private int id;
            private String imgUrl;
            private String name;
            private double price;
            private int shopId;
            private String shopLogo;
            private String shopName;
            private String size;
            private String skuId;
            private int status;
            private String version;
            private int vshopId;
            private boolean isSelect;

            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }

            public int getCartItemId() {
                return cartItemId;
            }

            public void setCartItemId(int cartItemId) {
                this.cartItemId = cartItemId;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getShopLogo() {
                return shopLogo;
            }

            public void setShopLogo(String shopLogo) {
                this.shopLogo = shopLogo;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getSkuId() {
                return skuId;
            }

            public void setSkuId(String skuId) {
                this.skuId = skuId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public int getVshopId() {
                return vshopId;
            }

            public void setVshopId(int vshopId) {
                this.vshopId = vshopId;
            }
        }
    }
}

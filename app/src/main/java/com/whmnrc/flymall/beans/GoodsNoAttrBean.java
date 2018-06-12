package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/12.
 */

public class GoodsNoAttrBean {


    /**
     * code : 0
     * message : 请求成功
     * resultdata : {"CollIds":"0","Freight":0,"OrderAmount":1120,"ShopCartItemModel":[{"CartItemModels":[{"count":1,"id":1482,"imgUrl":"/Storage/Shop/266/Products/1482/1_50.png","name":"钥胜魔盒语音智能 电视冰箱洗衣机音箱等全控制","price":1120,"productCode":"","shopId":266,"skuId":"1482_0_0_0"}],"Freight":0,"ShopName":"百货商店","UserBonus":[],"UserCoupons":[],"shopId":266}],"TotalAmount":1120}
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
         * CollIds : 0
         * Freight : 0.0
         * OrderAmount : 1120.0
         * ShopCartItemModel : [{"CartItemModels":[{"count":1,"id":1482,"imgUrl":"/Storage/Shop/266/Products/1482/1_50.png","name":"钥胜魔盒语音智能 电视冰箱洗衣机音箱等全控制","price":1120,"productCode":"","shopId":266,"skuId":"1482_0_0_0"}],"Freight":0,"ShopName":"百货商店","UserBonus":[],"UserCoupons":[],"shopId":266}]
         * TotalAmount : 1120.0
         */

        private String CollIds;
        private double Freight;
        private double OrderAmount;
        private double TotalAmount;
        private List<ShopCartItemModelBean> ShopCartItemModel;

        public String getCollIds() {
            return CollIds;
        }

        public void setCollIds(String CollIds) {
            this.CollIds = CollIds;
        }

        public double getFreight() {
            return Freight;
        }

        public void setFreight(double Freight) {
            this.Freight = Freight;
        }

        public double getOrderAmount() {
            return OrderAmount;
        }

        public void setOrderAmount(double OrderAmount) {
            this.OrderAmount = OrderAmount;
        }

        public double getTotalAmount() {
            return TotalAmount;
        }

        public void setTotalAmount(double TotalAmount) {
            this.TotalAmount = TotalAmount;
        }

        public List<ShopCartItemModelBean> getShopCartItemModel() {
            return ShopCartItemModel;
        }

        public void setShopCartItemModel(List<ShopCartItemModelBean> ShopCartItemModel) {
            this.ShopCartItemModel = ShopCartItemModel;
        }

        public static class ShopCartItemModelBean {
            /**
             * CartItemModels : [{"count":1,"id":1482,"imgUrl":"/Storage/Shop/266/Products/1482/1_50.png","name":"钥胜魔盒语音智能 电视冰箱洗衣机音箱等全控制","price":1120,"productCode":"","shopId":266,"skuId":"1482_0_0_0"}]
             * Freight : 0.0
             * ShopName : 百货商店
             * UserBonus : []
             * UserCoupons : []
             * shopId : 266
             */

            private double Freight;
            private String ShopName;
            private int shopId;
            private List<CartItemModelsBean> CartItemModels;
            private List<?> UserBonus;
            private List<?> UserCoupons;

            public double getFreight() {
                return Freight;
            }

            public void setFreight(double Freight) {
                this.Freight = Freight;
            }

            public String getShopName() {
                return ShopName;
            }

            public void setShopName(String ShopName) {
                this.ShopName = ShopName;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public List<CartItemModelsBean> getCartItemModels() {
                return CartItemModels;
            }

            public void setCartItemModels(List<CartItemModelsBean> CartItemModels) {
                this.CartItemModels = CartItemModels;
            }

            public List<?> getUserBonus() {
                return UserBonus;
            }

            public void setUserBonus(List<?> UserBonus) {
                this.UserBonus = UserBonus;
            }

            public List<?> getUserCoupons() {
                return UserCoupons;
            }

            public void setUserCoupons(List<?> UserCoupons) {
                this.UserCoupons = UserCoupons;
            }

            public static class CartItemModelsBean {
                /**
                 * count : 1
                 * id : 1482
                 * imgUrl : /Storage/Shop/266/Products/1482/1_50.png
                 * name : 钥胜魔盒语音智能 电视冰箱洗衣机音箱等全控制
                 * price : 1120.0
                 * productCode :
                 * shopId : 266
                 * skuId : 1482_0_0_0
                 */

                private int count;
                private int id;
                private String imgUrl;
                private String name;
                private double price;
                private String productCode;
                private int shopId;
                private String skuId;

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

                public String getProductCode() {
                    return productCode;
                }

                public void setProductCode(String productCode) {
                    this.productCode = productCode;
                }

                public int getShopId() {
                    return shopId;
                }

                public void setShopId(int shopId) {
                    this.shopId = shopId;
                }

                public String getSkuId() {
                    return skuId;
                }

                public void setSkuId(String skuId) {
                    this.skuId = skuId;
                }
            }
        }
    }
}

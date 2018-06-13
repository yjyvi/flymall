package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/12.
 */

public class ShopCartCreateOrderBean {


    /**
     * code : 0
     * message : 请求成功
     * resultdata : [{"ActiveType":0,"Address":"hddjdjjdjd","CellPhone":"13554542559","CommisTotalAmount":0,"DiscountAmount":0,"Freight":0,"Id":2018061257162343,"IntegralDiscount":0,"InvoiceType":0,"IsPrinted":false,"OrderDate":"2018-06-12 05:04:37","OrderItemInfo":[{"Color":"","CommisRate":0.01,"CostPrice":2240,"DiscountAmount":0,"Id":3597,"IsLimitBuy":false,"OrderId":2018061257162343,"ProductId":1357,"ProductName":"（10箱特惠）原浆酒10年浓香型52度整箱","Quantity":3,"RealTotalPrice":46296,"RefundPrice":0,"ReturnQuantity":0,"SKU":"","SalePrice":15432,"ShopId":266,"Size":"","SkuId":"1357_0_0_0","ThumbnailsUrl":"/Storage/Shop/266/Products/1357/1_100.png","Version":""},{"Color":"","CommisRate":0.01,"CostPrice":91,"DiscountAmount":0,"Id":3598,"IsLimitBuy":false,"OrderId":2018061257162343,"ProductId":982,"ProductName":"禅茗坊　整套青瓷泡红茶茶具　功夫商业礼品套装","Quantity":2,"RealTotalPrice":30864,"RefundPrice":0,"ReturnQuantity":0,"SKU":"","SalePrice":15432,"ShopId":266,"Size":"","SkuId":"982_0_0_0","ThumbnailsUrl":"/Storage/Shop/266/Products/982/1_100.png","Version":""}],"OrderStatus":1,"PayRemark":"","Platform":2,"ProductTotalAmount":15432,"RefundCommisAmount":0,"RefundTotalAmount":0,"RegionFullName":"hddjdjjdjd","RegionId":0,"ShipTo":"kskddk","ShopId":266,"ShopName":"百货商店","Tax":0,"TopRegionId":0,"UserId":4109,"UserName":"androidlk@aliyun.com"}]
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
         * ActiveType : 0
         * Address : hddjdjjdjd
         * CellPhone : 13554542559
         * CommisTotalAmount : 0.0
         * DiscountAmount : 0.0
         * Freight : 0.0
         * Id : 2018061257162343
         * IntegralDiscount : 0.0
         * InvoiceType : 0
         * IsPrinted : false
         * OrderDate : 2018-06-12 05:04:37
         * OrderItemInfo : [{"Color":"","CommisRate":0.01,"CostPrice":2240,"DiscountAmount":0,"Id":3597,"IsLimitBuy":false,"OrderId":2018061257162343,"ProductId":1357,"ProductName":"（10箱特惠）原浆酒10年浓香型52度整箱","Quantity":3,"RealTotalPrice":46296,"RefundPrice":0,"ReturnQuantity":0,"SKU":"","SalePrice":15432,"ShopId":266,"Size":"","SkuId":"1357_0_0_0","ThumbnailsUrl":"/Storage/Shop/266/Products/1357/1_100.png","Version":""},{"Color":"","CommisRate":0.01,"CostPrice":91,"DiscountAmount":0,"Id":3598,"IsLimitBuy":false,"OrderId":2018061257162343,"ProductId":982,"ProductName":"禅茗坊　整套青瓷泡红茶茶具　功夫商业礼品套装","Quantity":2,"RealTotalPrice":30864,"RefundPrice":0,"ReturnQuantity":0,"SKU":"","SalePrice":15432,"ShopId":266,"Size":"","SkuId":"982_0_0_0","ThumbnailsUrl":"/Storage/Shop/266/Products/982/1_100.png","Version":""}]
         * OrderStatus : 1
         * PayRemark :
         * Platform : 2
         * ProductTotalAmount : 15432.0
         * RefundCommisAmount : 0.0
         * RefundTotalAmount : 0.0
         * RegionFullName : hddjdjjdjd
         * RegionId : 0
         * ShipTo : kskddk
         * ShopId : 266
         * ShopName : 百货商店
         * Tax : 0.0
         * TopRegionId : 0
         * UserId : 4109
         * UserName : androidlk@aliyun.com
         */

        private int ActiveType;
        private String Address;
        private String CellPhone;
        private double CommisTotalAmount;
        private double DiscountAmount;
        private double Freight;
        private long Id;
        private double IntegralDiscount;
        private int InvoiceType;
        private boolean IsPrinted;
        private String OrderDate;
        private int OrderStatus;
        private String PayRemark;
        private int Platform;
        private double ProductTotalAmount;
        private double RefundCommisAmount;
        private double RefundTotalAmount;
        private String RegionFullName;
        private int RegionId;
        private String ShipTo;
        private int ShopId;
        private String ShopName;
        private double Tax;
        private int TopRegionId;
        private int UserId;
        private String UserName;
        private List<OrderItemInfoBean> OrderItemInfo;

        public int getActiveType() {
            return ActiveType;
        }

        public void setActiveType(int ActiveType) {
            this.ActiveType = ActiveType;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getCellPhone() {
            return CellPhone;
        }

        public void setCellPhone(String CellPhone) {
            this.CellPhone = CellPhone;
        }

        public double getCommisTotalAmount() {
            return CommisTotalAmount;
        }

        public void setCommisTotalAmount(double CommisTotalAmount) {
            this.CommisTotalAmount = CommisTotalAmount;
        }

        public double getDiscountAmount() {
            return DiscountAmount;
        }

        public void setDiscountAmount(double DiscountAmount) {
            this.DiscountAmount = DiscountAmount;
        }

        public double getFreight() {
            return Freight;
        }

        public void setFreight(double Freight) {
            this.Freight = Freight;
        }

        public long getId() {
            return Id;
        }

        public void setId(long Id) {
            this.Id = Id;
        }

        public double getIntegralDiscount() {
            return IntegralDiscount;
        }

        public void setIntegralDiscount(double IntegralDiscount) {
            this.IntegralDiscount = IntegralDiscount;
        }

        public int getInvoiceType() {
            return InvoiceType;
        }

        public void setInvoiceType(int InvoiceType) {
            this.InvoiceType = InvoiceType;
        }

        public boolean isIsPrinted() {
            return IsPrinted;
        }

        public void setIsPrinted(boolean IsPrinted) {
            this.IsPrinted = IsPrinted;
        }

        public String getOrderDate() {
            return OrderDate;
        }

        public void setOrderDate(String OrderDate) {
            this.OrderDate = OrderDate;
        }

        public int getOrderStatus() {
            return OrderStatus;
        }

        public void setOrderStatus(int OrderStatus) {
            this.OrderStatus = OrderStatus;
        }

        public String getPayRemark() {
            return PayRemark;
        }

        public void setPayRemark(String PayRemark) {
            this.PayRemark = PayRemark;
        }

        public int getPlatform() {
            return Platform;
        }

        public void setPlatform(int Platform) {
            this.Platform = Platform;
        }

        public double getProductTotalAmount() {
            return ProductTotalAmount;
        }

        public void setProductTotalAmount(double ProductTotalAmount) {
            this.ProductTotalAmount = ProductTotalAmount;
        }

        public double getRefundCommisAmount() {
            return RefundCommisAmount;
        }

        public void setRefundCommisAmount(double RefundCommisAmount) {
            this.RefundCommisAmount = RefundCommisAmount;
        }

        public double getRefundTotalAmount() {
            return RefundTotalAmount;
        }

        public void setRefundTotalAmount(double RefundTotalAmount) {
            this.RefundTotalAmount = RefundTotalAmount;
        }

        public String getRegionFullName() {
            return RegionFullName;
        }

        public void setRegionFullName(String RegionFullName) {
            this.RegionFullName = RegionFullName;
        }

        public int getRegionId() {
            return RegionId;
        }

        public void setRegionId(int RegionId) {
            this.RegionId = RegionId;
        }

        public String getShipTo() {
            return ShipTo;
        }

        public void setShipTo(String ShipTo) {
            this.ShipTo = ShipTo;
        }

        public int getShopId() {
            return ShopId;
        }

        public void setShopId(int ShopId) {
            this.ShopId = ShopId;
        }

        public String getShopName() {
            return ShopName;
        }

        public void setShopName(String ShopName) {
            this.ShopName = ShopName;
        }

        public double getTax() {
            return Tax;
        }

        public void setTax(double Tax) {
            this.Tax = Tax;
        }

        public int getTopRegionId() {
            return TopRegionId;
        }

        public void setTopRegionId(int TopRegionId) {
            this.TopRegionId = TopRegionId;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public List<OrderItemInfoBean> getOrderItemInfo() {
            return OrderItemInfo;
        }

        public void setOrderItemInfo(List<OrderItemInfoBean> OrderItemInfo) {
            this.OrderItemInfo = OrderItemInfo;
        }

        public static class OrderItemInfoBean {
            /**
             * Color :
             * CommisRate : 0.01
             * CostPrice : 2240.0
             * DiscountAmount : 0.0
             * Id : 3597
             * IsLimitBuy : false
             * OrderId : 2018061257162343
             * ProductId : 1357
             * ProductName : （10箱特惠）原浆酒10年浓香型52度整箱
             * Quantity : 3
             * RealTotalPrice : 46296.0
             * RefundPrice : 0.0
             * ReturnQuantity : 0
             * SKU :
             * SalePrice : 15432.0
             * ShopId : 266
             * Size :
             * SkuId : 1357_0_0_0
             * ThumbnailsUrl : /Storage/Shop/266/Products/1357/1_100.png
             * Version :
             */

            private String Color;
            private double CommisRate;
            private double CostPrice;
            private double DiscountAmount;
            private int Id;
            private boolean IsLimitBuy;
            private long OrderId;
            private int ProductId;
            private String ProductName;
            private int Quantity;
            private double RealTotalPrice;
            private double RefundPrice;
            private int ReturnQuantity;
            private String SKU;
            private double SalePrice;
            private int ShopId;
            private String Size;
            private String SkuId;
            private String ThumbnailsUrl;
            private String Version;

            public String getColor() {
                return Color;
            }

            public void setColor(String Color) {
                this.Color = Color;
            }

            public double getCommisRate() {
                return CommisRate;
            }

            public void setCommisRate(double CommisRate) {
                this.CommisRate = CommisRate;
            }

            public double getCostPrice() {
                return CostPrice;
            }

            public void setCostPrice(double CostPrice) {
                this.CostPrice = CostPrice;
            }

            public double getDiscountAmount() {
                return DiscountAmount;
            }

            public void setDiscountAmount(double DiscountAmount) {
                this.DiscountAmount = DiscountAmount;
            }

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public boolean isIsLimitBuy() {
                return IsLimitBuy;
            }

            public void setIsLimitBuy(boolean IsLimitBuy) {
                this.IsLimitBuy = IsLimitBuy;
            }

            public long getOrderId() {
                return OrderId;
            }

            public void setOrderId(long OrderId) {
                this.OrderId = OrderId;
            }

            public int getProductId() {
                return ProductId;
            }

            public void setProductId(int ProductId) {
                this.ProductId = ProductId;
            }

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String ProductName) {
                this.ProductName = ProductName;
            }

            public int getQuantity() {
                return Quantity;
            }

            public void setQuantity(int Quantity) {
                this.Quantity = Quantity;
            }

            public double getRealTotalPrice() {
                return RealTotalPrice;
            }

            public void setRealTotalPrice(double RealTotalPrice) {
                this.RealTotalPrice = RealTotalPrice;
            }

            public double getRefundPrice() {
                return RefundPrice;
            }

            public void setRefundPrice(double RefundPrice) {
                this.RefundPrice = RefundPrice;
            }

            public int getReturnQuantity() {
                return ReturnQuantity;
            }

            public void setReturnQuantity(int ReturnQuantity) {
                this.ReturnQuantity = ReturnQuantity;
            }

            public String getSKU() {
                return SKU;
            }

            public void setSKU(String SKU) {
                this.SKU = SKU;
            }

            public double getSalePrice() {
                return SalePrice;
            }

            public void setSalePrice(double SalePrice) {
                this.SalePrice = SalePrice;
            }

            public int getShopId() {
                return ShopId;
            }

            public void setShopId(int ShopId) {
                this.ShopId = ShopId;
            }

            public String getSize() {
                return Size;
            }

            public void setSize(String Size) {
                this.Size = Size;
            }

            public String getSkuId() {
                return SkuId;
            }

            public void setSkuId(String SkuId) {
                this.SkuId = SkuId;
            }

            public String getThumbnailsUrl() {
                return ThumbnailsUrl;
            }

            public void setThumbnailsUrl(String ThumbnailsUrl) {
                this.ThumbnailsUrl = ThumbnailsUrl;
            }

            public String getVersion() {
                return Version;
            }

            public void setVersion(String Version) {
                this.Version = Version;
            }
        }
    }
}

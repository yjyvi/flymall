package com.whmnrc.flymall.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/12.
 */

public class OrderDeitalsBean {


    /**
     * type : 1
     * code : 0
     * message : 请求成功
     * resultdata : {"OrderItemInfo":[{"Color":"??","CommisRate":0.02,"CostPrice":149,"DiscountAmount":0,"EnabledRefundAmount":null,"Id":3562,"IsLimitBuy":false,"OrderId":2018061155998180,"ProductCode":null,"ProductId":1512,"ProductName":"??????????????????????????????","Quantity":3,"RealTotalPrice":3582,"RefundPrice":0,"ReturnQuantity":0,"SalePrice":1194,"ShopId":266,"Size":"","SKU":"FG000023","SkuId":"1512_679_0_0","ThumbnailsUrl":"/Storage/Shop/266/Products/1512/1_100.png","Version":""}],"ActiveType":0,"Address":"?????4?","CellPhone":"13080650700","CloseReason":null,"CommisTotalAmount":0,"DiscountAmount":0,"ExpressCompanyName":null,"FinishDate":null,"Freight":0,"GatewayOrderId":null,"Id":2018061155998180,"IntegralDiscount":0,"InvoiceContext":null,"InvoiceTitle":null,"InvoiceType":0,"IsPrinted":false,"OrderDate":"2018-06-11 08:08:12","OrderStatus":1,"OrderType":null,"PayDate":null,"PaymentTypeGateway":null,"PaymentTypeName":null,"PayRemark":null,"Platform":2,"ProductTotalAmount":1194,"RefundCommisAmount":0,"RefundStats":null,"RefundTotalAmount":0,"RegionFullName":"??? ??? ????","RegionId":1538,"SellerAddress":null,"SellerPhone":null,"SellerRemark":null,"ShipOrderNumber":null,"ShippingDate":null,"ShipTo":"???","ShopId":266,"ShopName":"????","Tax":0,"TopRegionId":1529,"UserId":4109,"UserName":"androidlk@aliyun.com","UserRemark":null}
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

    public static class ResultdataBean implements Parcelable {
        public ResultdataBean() {
        }

        /**
         * OrderItemInfo : [{"Color":"??","CommisRate":0.02,"CostPrice":149,"DiscountAmount":0,"EnabledRefundAmount":null,"Id":3562,"IsLimitBuy":false,"OrderId":2018061155998180,"ProductCode":null,"ProductId":1512,"ProductName":"??????????????????????????????","Quantity":3,"RealTotalPrice":3582,"RefundPrice":0,"ReturnQuantity":0,"SalePrice":1194,"ShopId":266,"Size":"","SKU":"FG000023","SkuId":"1512_679_0_0","ThumbnailsUrl":"/Storage/Shop/266/Products/1512/1_100.png","Version":""}]
         * ActiveType : 0
         * Address : ?????4?
         * CellPhone : 13080650700
         * CloseReason : null
         * CommisTotalAmount : 0
         * DiscountAmount : 0
         * ExpressCompanyName : null
         * FinishDate : null
         * Freight : 0
         * GatewayOrderId : null
         * Id : 2018061155998180
         * IntegralDiscount : 0
         * InvoiceContext : null
         * InvoiceTitle : null
         * InvoiceType : 0
         * IsPrinted : false
         * OrderDate : 2018-06-11 08:08:12
         * OrderStatus : 1
         * OrderType : null
         * PayDate : null
         * PaymentTypeGateway : null
         * PaymentTypeName : null
         * PayRemark : null
         * Platform : 2
         * ProductTotalAmount : 1194
         * RefundCommisAmount : 0
         * RefundStats : null
         * RefundTotalAmount : 0
         * RegionFullName : ??? ??? ????
         * RegionId : 1538
         * SellerAddress : null
         * SellerPhone : null
         * SellerRemark : null
         * ShipOrderNumber : null
         * ShippingDate : null
         * ShipTo : ???
         * ShopId : 266
         * ShopName : ????
         * Tax : 0
         * TopRegionId : 1529
         * UserId : 4109
         * UserName : androidlk@aliyun.com
         * UserRemark : null
         */

        private int ActiveType;
        private String Address;
        private String CellPhone;
        private Object CloseReason;
        private int CommisTotalAmount;
        private int DiscountAmount;
        private Object ExpressCompanyName;
        private Object FinishDate;
        private int Freight;
        private Object GatewayOrderId;
        private long Id;
        private int IntegralDiscount;
        private Object InvoiceContext;
        private Object InvoiceTitle;
        private int InvoiceType;
        private boolean IsPrinted;
        private String OrderDate;
        private int OrderStatus;
        private Object OrderType;
        private Object PayDate;
        private Object PaymentTypeGateway;
        private Object PaymentTypeName;
        private Object PayRemark;
        private int Platform;
        private double ProductTotalAmount;
        private int RefundCommisAmount;
        private Object RefundStats;
        private int RefundTotalAmount;
        private String RegionFullName;
        private int RegionId;
        private Object SellerAddress;
        private Object SellerPhone;
        private Object SellerRemark;
        private Object ShipOrderNumber;
        private Object ShippingDate;
        private String ShipTo;
        private int ShopId;
        private String ShopName;
        private int Tax;
        private int TopRegionId;
        private int UserId;
        private String UserName;
        private Object UserRemark;
        private List<OrderItemInfoBean> OrderItemInfo;

        protected ResultdataBean(Parcel in) {
            ActiveType = in.readInt();
            Address = in.readString();
            CellPhone = in.readString();
            CommisTotalAmount = in.readInt();
            DiscountAmount = in.readInt();
            Freight = in.readInt();
            Id = in.readLong();
            IntegralDiscount = in.readInt();
            InvoiceType = in.readInt();
            IsPrinted = in.readByte() != 0;
            OrderDate = in.readString();
            OrderStatus = in.readInt();
            Platform = in.readInt();
            ProductTotalAmount = in.readDouble();
            RefundCommisAmount = in.readInt();
            RefundTotalAmount = in.readInt();
            RegionFullName = in.readString();
            RegionId = in.readInt();
            ShipTo = in.readString();
            ShopId = in.readInt();
            ShopName = in.readString();
            Tax = in.readInt();
            TopRegionId = in.readInt();
            UserId = in.readInt();
            UserName = in.readString();
            OrderItemInfo = in.createTypedArrayList(OrderItemInfoBean.CREATOR);
        }

        public static final Creator<ResultdataBean> CREATOR = new Creator<ResultdataBean>() {
            @Override
            public ResultdataBean createFromParcel(Parcel in) {
                return new ResultdataBean(in);
            }

            @Override
            public ResultdataBean[] newArray(int size) {
                return new ResultdataBean[size];
            }
        };

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

        public Object getCloseReason() {
            return CloseReason;
        }

        public void setCloseReason(Object CloseReason) {
            this.CloseReason = CloseReason;
        }

        public int getCommisTotalAmount() {
            return CommisTotalAmount;
        }

        public void setCommisTotalAmount(int CommisTotalAmount) {
            this.CommisTotalAmount = CommisTotalAmount;
        }

        public int getDiscountAmount() {
            return DiscountAmount;
        }

        public void setDiscountAmount(int DiscountAmount) {
            this.DiscountAmount = DiscountAmount;
        }

        public Object getExpressCompanyName() {
            return ExpressCompanyName;
        }

        public void setExpressCompanyName(Object ExpressCompanyName) {
            this.ExpressCompanyName = ExpressCompanyName;
        }

        public Object getFinishDate() {
            return FinishDate;
        }

        public void setFinishDate(Object FinishDate) {
            this.FinishDate = FinishDate;
        }

        public int getFreight() {
            return Freight;
        }

        public void setFreight(int Freight) {
            this.Freight = Freight;
        }

        public Object getGatewayOrderId() {
            return GatewayOrderId;
        }

        public void setGatewayOrderId(Object GatewayOrderId) {
            this.GatewayOrderId = GatewayOrderId;
        }

        public long getId() {
            return Id;
        }

        public void setId(long Id) {
            this.Id = Id;
        }

        public int getIntegralDiscount() {
            return IntegralDiscount;
        }

        public void setIntegralDiscount(int IntegralDiscount) {
            this.IntegralDiscount = IntegralDiscount;
        }

        public Object getInvoiceContext() {
            return InvoiceContext;
        }

        public void setInvoiceContext(Object InvoiceContext) {
            this.InvoiceContext = InvoiceContext;
        }

        public Object getInvoiceTitle() {
            return InvoiceTitle;
        }

        public void setInvoiceTitle(Object InvoiceTitle) {
            this.InvoiceTitle = InvoiceTitle;
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

        public Object getOrderType() {
            return OrderType;
        }

        public void setOrderType(Object OrderType) {
            this.OrderType = OrderType;
        }

        public Object getPayDate() {
            return PayDate;
        }

        public void setPayDate(Object PayDate) {
            this.PayDate = PayDate;
        }

        public Object getPaymentTypeGateway() {
            return PaymentTypeGateway;
        }

        public void setPaymentTypeGateway(Object PaymentTypeGateway) {
            this.PaymentTypeGateway = PaymentTypeGateway;
        }

        public Object getPaymentTypeName() {
            return PaymentTypeName;
        }

        public void setPaymentTypeName(Object PaymentTypeName) {
            this.PaymentTypeName = PaymentTypeName;
        }

        public Object getPayRemark() {
            return PayRemark;
        }

        public void setPayRemark(Object PayRemark) {
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

        public int getRefundCommisAmount() {
            return RefundCommisAmount;
        }

        public void setRefundCommisAmount(int RefundCommisAmount) {
            this.RefundCommisAmount = RefundCommisAmount;
        }

        public Object getRefundStats() {
            return RefundStats;
        }

        public void setRefundStats(Object RefundStats) {
            this.RefundStats = RefundStats;
        }

        public int getRefundTotalAmount() {
            return RefundTotalAmount;
        }

        public void setRefundTotalAmount(int RefundTotalAmount) {
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

        public Object getSellerAddress() {
            return SellerAddress;
        }

        public void setSellerAddress(Object SellerAddress) {
            this.SellerAddress = SellerAddress;
        }

        public Object getSellerPhone() {
            return SellerPhone;
        }

        public void setSellerPhone(Object SellerPhone) {
            this.SellerPhone = SellerPhone;
        }

        public Object getSellerRemark() {
            return SellerRemark;
        }

        public void setSellerRemark(Object SellerRemark) {
            this.SellerRemark = SellerRemark;
        }

        public Object getShipOrderNumber() {
            return ShipOrderNumber;
        }

        public void setShipOrderNumber(Object ShipOrderNumber) {
            this.ShipOrderNumber = ShipOrderNumber;
        }

        public Object getShippingDate() {
            return ShippingDate;
        }

        public void setShippingDate(Object ShippingDate) {
            this.ShippingDate = ShippingDate;
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

        public int getTax() {
            return Tax;
        }

        public void setTax(int Tax) {
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

        public Object getUserRemark() {
            return UserRemark;
        }

        public void setUserRemark(Object UserRemark) {
            this.UserRemark = UserRemark;
        }

        public List<OrderItemInfoBean> getOrderItemInfo() {
            return OrderItemInfo;
        }

        public void setOrderItemInfo(List<OrderItemInfoBean> OrderItemInfo) {
            this.OrderItemInfo = OrderItemInfo;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(ActiveType);
            dest.writeString(Address);
            dest.writeString(CellPhone);
            dest.writeInt(CommisTotalAmount);
            dest.writeInt(DiscountAmount);
            dest.writeInt(Freight);
            dest.writeLong(Id);
            dest.writeInt(IntegralDiscount);
            dest.writeInt(InvoiceType);
            dest.writeByte((byte) (IsPrinted ? 1 : 0));
            dest.writeString(OrderDate);
            dest.writeInt(OrderStatus);
            dest.writeInt(Platform);
            dest.writeDouble(ProductTotalAmount);
            dest.writeInt(RefundCommisAmount);
            dest.writeInt(RefundTotalAmount);
            dest.writeString(RegionFullName);
            dest.writeInt(RegionId);
            dest.writeString(ShipTo);
            dest.writeInt(ShopId);
            dest.writeString(ShopName);
            dest.writeInt(Tax);
            dest.writeInt(TopRegionId);
            dest.writeInt(UserId);
            dest.writeString(UserName);
            dest.writeTypedList(OrderItemInfo);
        }

        public static class OrderItemInfoBean implements Parcelable {

            public OrderItemInfoBean() {
            }

            /**
             * Color : ??
             * CommisRate : 0.02
             * CostPrice : 149
             * DiscountAmount : 0
             * EnabledRefundAmount : null
             * Id : 3562
             * IsLimitBuy : false
             * OrderId : 2018061155998180
             * ProductCode : null
             * ProductId : 1512
             * ProductName : ??????????????????????????????
             * Quantity : 3
             * RealTotalPrice : 3582
             * RefundPrice : 0
             * ReturnQuantity : 0
             * SalePrice : 1194
             * ShopId : 266
             * Size :
             * SKU : FG000023
             * SkuId : 1512_679_0_0
             * ThumbnailsUrl : /Storage/Shop/266/Products/1512/1_100.png
             * Version :
             */

            private String Color;
            private double CommisRate;
            private int CostPrice;
            private int DiscountAmount;
            private Object EnabledRefundAmount;
            private int Id;
            private boolean IsLimitBuy;
            private long OrderId;
            private Object ProductCode;
            private int ProductId;
            private String ProductName;
            private int Quantity;
            private int RealTotalPrice;
            private int RefundPrice;
            private int ReturnQuantity;
            private int SalePrice;
            private int ShopId;
            private String Size;
            private String SKU;
            private String SkuId;
            private String ThumbnailsUrl;
            private String Version;

            protected OrderItemInfoBean(Parcel in) {
                Color = in.readString();
                CommisRate = in.readDouble();
                CostPrice = in.readInt();
                DiscountAmount = in.readInt();
                Id = in.readInt();
                IsLimitBuy = in.readByte() != 0;
                OrderId = in.readLong();
                ProductId = in.readInt();
                ProductName = in.readString();
                Quantity = in.readInt();
                RealTotalPrice = in.readInt();
                RefundPrice = in.readInt();
                ReturnQuantity = in.readInt();
                SalePrice = in.readInt();
                ShopId = in.readInt();
                Size = in.readString();
                SKU = in.readString();
                SkuId = in.readString();
                ThumbnailsUrl = in.readString();
                Version = in.readString();
            }

            public static final Creator<OrderItemInfoBean> CREATOR = new Creator<OrderItemInfoBean>() {
                @Override
                public OrderItemInfoBean createFromParcel(Parcel in) {
                    return new OrderItemInfoBean(in);
                }

                @Override
                public OrderItemInfoBean[] newArray(int size) {
                    return new OrderItemInfoBean[size];
                }
            };

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

            public int getCostPrice() {
                return CostPrice;
            }

            public void setCostPrice(int CostPrice) {
                this.CostPrice = CostPrice;
            }

            public int getDiscountAmount() {
                return DiscountAmount;
            }

            public void setDiscountAmount(int DiscountAmount) {
                this.DiscountAmount = DiscountAmount;
            }

            public Object getEnabledRefundAmount() {
                return EnabledRefundAmount;
            }

            public void setEnabledRefundAmount(Object EnabledRefundAmount) {
                this.EnabledRefundAmount = EnabledRefundAmount;
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

            public Object getProductCode() {
                return ProductCode;
            }

            public void setProductCode(Object ProductCode) {
                this.ProductCode = ProductCode;
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

            public int getRealTotalPrice() {
                return RealTotalPrice;
            }

            public void setRealTotalPrice(int RealTotalPrice) {
                this.RealTotalPrice = RealTotalPrice;
            }

            public int getRefundPrice() {
                return RefundPrice;
            }

            public void setRefundPrice(int RefundPrice) {
                this.RefundPrice = RefundPrice;
            }

            public int getReturnQuantity() {
                return ReturnQuantity;
            }

            public void setReturnQuantity(int ReturnQuantity) {
                this.ReturnQuantity = ReturnQuantity;
            }

            public int getSalePrice() {
                return SalePrice;
            }

            public void setSalePrice(int SalePrice) {
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

            public String getSKU() {
                return SKU;
            }

            public void setSKU(String SKU) {
                this.SKU = SKU;
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(Color);
                dest.writeDouble(CommisRate);
                dest.writeInt(CostPrice);
                dest.writeInt(DiscountAmount);
                dest.writeInt(Id);
                dest.writeByte((byte) (IsLimitBuy ? 1 : 0));
                dest.writeLong(OrderId);
                dest.writeInt(ProductId);
                dest.writeString(ProductName);
                dest.writeInt(Quantity);
                dest.writeInt(RealTotalPrice);
                dest.writeInt(RefundPrice);
                dest.writeInt(ReturnQuantity);
                dest.writeInt(SalePrice);
                dest.writeInt(ShopId);
                dest.writeString(Size);
                dest.writeString(SKU);
                dest.writeString(SkuId);
                dest.writeString(ThumbnailsUrl);
                dest.writeString(Version);
            }
        }
    }
}

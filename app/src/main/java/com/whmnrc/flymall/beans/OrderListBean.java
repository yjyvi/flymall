package com.whmnrc.flymall.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/4.
 */

public class OrderListBean  {

    /**
     * type : 1
     * code : 0
     * message : 成功。
     * resultdata : [{"Order":{"Order_ID":"96fff514-b711-4593-9ed3-24eb2aea17c2","Order_No":"E7939845022638","UserInfo_ID":"fb80d7ea-5667-4185-b8b8-4089b96542d0","UserInfo_ParentID":null,"UserInfo_HeadImg":"http://hwscapi.whmnx.com/UserFile/Images/Resource/Qualification/27930ca4-4243-4e00-bfcb-35a676d8a51f.jpg","Order_PayNo":"P7939845022638","Order_CreateTime":"2018-06-04T19:02:48.963","Address_Name":"asdasdasdqweasd","Address_Mobile":"17754436736","Address_ID":"674e5a0b-93da-4163-9448-09f6de314c7e","Address_Provice":"0086","Address_City":"0086110000","Address_Region":"asddqweasd","Address_Detail":"asdqweasd","Address_FullAddress":"中国 北京  asdqweasd","Order_PayType":-1,"Order_State":0,"Order_Money":880,"ORder_Freight":0,"Order_Seed":2,"Order_Type":0,"OrderStartDate":null,"OrderEndDate":null,"Order_Integer":0,"Order_Remark":"","Order_IntegerMoney":0,"Order_IntegerMoneyRate":0,"Order_Number":1,"Order_WaybillCompany":null,"Order_WaybillNumber":null,"Order_DeliverGoodsUserInfoID":null,"Order_RebateMoney":880,"Order_RebateNumber":1,"Order_HasNewGoods":false,"Order_DeliverGoodsTime":null},"OrderItem":[{"OrderItem_ID":"53c3b72b-d195-41a6-94b4-f0de0db8876b","Product_ID":"1a4179e2-5555-46d0-aa62-0218369f211b","Product_Name":"裤子","Product_ImgPath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164363&di=5273719a0ec59feb189fdc864d79cfa6&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fback_pic%2Fqk%2Fback_origin_pic%2F00%2F03%2F14%2Fc0391a6c1efab3fe00911b04e8cedca4.jpg","Product_Price":0,"OrderItem_Number":1,"OrderItem_Money":900,"Order_ID":"96fff514-b711-4593-9ed3-24eb2aea17c2","DotProduct_ID":"","Spec_ID":"58410b32-92ae-4486-99f4-6b086be1a705","Spec_Name":"长袖","SpecAttr_ID":"","SpecAttr_Name":"蓝色","SpecAttr_Price":900,"SpecAttr_Integer":0,"OrderItem_Integer":0,"OrderItem_Discount":0,"OrderItem_Type":0,"OrderItem_UseCode":null}]}]
     */

    private int type;
    private int code;
    private String message;
    private List<ResultdataBean> resultdata;

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

    public List<ResultdataBean> getResultdata() {
        return resultdata;
    }

    public void setResultdata(List<ResultdataBean> resultdata) {
        this.resultdata = resultdata;
    }

    public static class ResultdataBean implements Parcelable{
        public ResultdataBean() {
        }

        /**
         * Order : {"Order_ID":"96fff514-b711-4593-9ed3-24eb2aea17c2","Order_No":"E7939845022638","UserInfo_ID":"fb80d7ea-5667-4185-b8b8-4089b96542d0","UserInfo_ParentID":null,"UserInfo_HeadImg":"http://hwscapi.whmnx.com/UserFile/Images/Resource/Qualification/27930ca4-4243-4e00-bfcb-35a676d8a51f.jpg","Order_PayNo":"P7939845022638","Order_CreateTime":"2018-06-04T19:02:48.963","Address_Name":"asdasdasdqweasd","Address_Mobile":"17754436736","Address_ID":"674e5a0b-93da-4163-9448-09f6de314c7e","Address_Provice":"0086","Address_City":"0086110000","Address_Region":"asddqweasd","Address_Detail":"asdqweasd","Address_FullAddress":"中国 北京  asdqweasd","Order_PayType":-1,"Order_State":0,"Order_Money":880,"ORder_Freight":0,"Order_Seed":2,"Order_Type":0,"OrderStartDate":null,"OrderEndDate":null,"Order_Integer":0,"Order_Remark":"","Order_IntegerMoney":0,"Order_IntegerMoneyRate":0,"Order_Number":1,"Order_WaybillCompany":null,"Order_WaybillNumber":null,"Order_DeliverGoodsUserInfoID":null,"Order_RebateMoney":880,"Order_RebateNumber":1,"Order_HasNewGoods":false,"Order_DeliverGoodsTime":null}
         * OrderItem : [{"OrderItem_ID":"53c3b72b-d195-41a6-94b4-f0de0db8876b","Product_ID":"1a4179e2-5555-46d0-aa62-0218369f211b","Product_Name":"裤子","Product_ImgPath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164363&di=5273719a0ec59feb189fdc864d79cfa6&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fback_pic%2Fqk%2Fback_origin_pic%2F00%2F03%2F14%2Fc0391a6c1efab3fe00911b04e8cedca4.jpg","Product_Price":0,"OrderItem_Number":1,"OrderItem_Money":900,"Order_ID":"96fff514-b711-4593-9ed3-24eb2aea17c2","DotProduct_ID":"","Spec_ID":"58410b32-92ae-4486-99f4-6b086be1a705","Spec_Name":"长袖","SpecAttr_ID":"","SpecAttr_Name":"蓝色","SpecAttr_Price":900,"SpecAttr_Integer":0,"OrderItem_Integer":0,"OrderItem_Discount":0,"OrderItem_Type":0,"OrderItem_UseCode":null}]
         */



        private OrderBean Order;
        private List<OrderItemBean> OrderItem;

        protected ResultdataBean(Parcel in) {
            Order = in.readParcelable(OrderBean.class.getClassLoader());
            OrderItem = in.createTypedArrayList(OrderItemBean.CREATOR);
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

        public OrderBean getOrder() {
            return Order;
        }

        public void setOrder(OrderBean Order) {
            this.Order = Order;
        }

        public List<OrderItemBean> getOrderItem() {
            return OrderItem;
        }

        public void setOrderItem(List<OrderItemBean> OrderItem) {
            this.OrderItem = OrderItem;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(Order, flags);
            dest.writeTypedList(OrderItem);
        }

        public static class OrderBean implements Parcelable {

            public OrderBean() {
            }

            /**
             * Order_ID : 96fff514-b711-4593-9ed3-24eb2aea17c2
             * Order_No : E7939845022638
             * UserInfo_ID : fb80d7ea-5667-4185-b8b8-4089b96542d0
             * UserInfo_ParentID : null
             * UserInfo_HeadImg : http://hwscapi.whmnx.com/UserFile/Images/Resource/Qualification/27930ca4-4243-4e00-bfcb-35a676d8a51f.jpg
             * Order_PayNo : P7939845022638
             * Order_CreateTime : 2018-06-04T19:02:48.963
             * Address_Name : asdasdasdqweasd
             * Address_Mobile : 17754436736
             * Address_ID : 674e5a0b-93da-4163-9448-09f6de314c7e
             * Address_Provice : 0086
             * Address_City : 0086110000
             * Address_Region : asddqweasd
             * Address_Detail : asdqweasd
             * Address_FullAddress : 中国 北京  asdqweasd
             * Order_PayType : -1
             * Order_State : 0
             * Order_Money : 880
             * ORder_Freight : 0
             * Order_Seed : 2
             * Order_Type : 0
             * OrderStartDate : null
             * OrderEndDate : null
             * Order_Integer : 0
             * Order_Remark :
             * Order_IntegerMoney : 0
             * Order_IntegerMoneyRate : 0
             * Order_Number : 1
             * Order_WaybillCompany : null
             * Order_WaybillNumber : null
             * Order_DeliverGoodsUserInfoID : null
             * Order_RebateMoney : 880
             * Order_RebateNumber : 1
             * Order_HasNewGoods : false
             * Order_DeliverGoodsTime : null
             */

            private String Order_ID;
            private String Order_No;
            private String UserInfo_ID;
            private Object UserInfo_ParentID;
            private String UserInfo_HeadImg;
            private String Order_PayNo;
            private String Order_CreateTime;
            private String Address_Name;
            private String Address_Mobile;
            private String Address_ID;
            private String Address_Provice;
            private String Address_City;
            private String Address_Region;
            private String Address_Detail;
            private String Address_FullAddress;
            private int Order_PayType;
            private int Order_State;
            private int Order_Money;
            private int ORder_Freight;
            private int Order_Seed;
            private int Order_Type;
            private Object OrderStartDate;
            private Object OrderEndDate;
            private int Order_Integer;
            private String Order_Remark;
            private int Order_IntegerMoney;
            private int Order_IntegerMoneyRate;
            private int Order_Number;
            private Object Order_WaybillCompany;
            private Object Order_WaybillNumber;
            private Object Order_DeliverGoodsUserInfoID;
            private int Order_RebateMoney;
            private int Order_RebateNumber;
            private boolean Order_HasNewGoods;
            private Object Order_DeliverGoodsTime;

            protected OrderBean(Parcel in) {
                Order_ID = in.readString();
                Order_No = in.readString();
                UserInfo_ID = in.readString();
                UserInfo_HeadImg = in.readString();
                Order_PayNo = in.readString();
                Order_CreateTime = in.readString();
                Address_Name = in.readString();
                Address_Mobile = in.readString();
                Address_ID = in.readString();
                Address_Provice = in.readString();
                Address_City = in.readString();
                Address_Region = in.readString();
                Address_Detail = in.readString();
                Address_FullAddress = in.readString();
                Order_PayType = in.readInt();
                Order_State = in.readInt();
                Order_Money = in.readInt();
                ORder_Freight = in.readInt();
                Order_Seed = in.readInt();
                Order_Type = in.readInt();
                Order_Integer = in.readInt();
                Order_Remark = in.readString();
                Order_IntegerMoney = in.readInt();
                Order_IntegerMoneyRate = in.readInt();
                Order_Number = in.readInt();
                Order_RebateMoney = in.readInt();
                Order_RebateNumber = in.readInt();
                Order_HasNewGoods = in.readByte() != 0;
            }

            public static final Creator<OrderBean> CREATOR = new Creator<OrderBean>() {
                @Override
                public OrderBean createFromParcel(Parcel in) {
                    return new OrderBean(in);
                }

                @Override
                public OrderBean[] newArray(int size) {
                    return new OrderBean[size];
                }
            };

            public String getOrder_ID() {
                return Order_ID;
            }

            public void setOrder_ID(String Order_ID) {
                this.Order_ID = Order_ID;
            }

            public String getOrder_No() {
                return Order_No;
            }

            public void setOrder_No(String Order_No) {
                this.Order_No = Order_No;
            }

            public String getUserInfo_ID() {
                return UserInfo_ID;
            }

            public void setUserInfo_ID(String UserInfo_ID) {
                this.UserInfo_ID = UserInfo_ID;
            }

            public Object getUserInfo_ParentID() {
                return UserInfo_ParentID;
            }

            public void setUserInfo_ParentID(Object UserInfo_ParentID) {
                this.UserInfo_ParentID = UserInfo_ParentID;
            }

            public String getUserInfo_HeadImg() {
                return UserInfo_HeadImg;
            }

            public void setUserInfo_HeadImg(String UserInfo_HeadImg) {
                this.UserInfo_HeadImg = UserInfo_HeadImg;
            }

            public String getOrder_PayNo() {
                return Order_PayNo;
            }

            public void setOrder_PayNo(String Order_PayNo) {
                this.Order_PayNo = Order_PayNo;
            }

            public String getOrder_CreateTime() {
                return Order_CreateTime;
            }

            public void setOrder_CreateTime(String Order_CreateTime) {
                this.Order_CreateTime = Order_CreateTime;
            }

            public String getAddress_Name() {
                return Address_Name;
            }

            public void setAddress_Name(String Address_Name) {
                this.Address_Name = Address_Name;
            }

            public String getAddress_Mobile() {
                return Address_Mobile;
            }

            public void setAddress_Mobile(String Address_Mobile) {
                this.Address_Mobile = Address_Mobile;
            }

            public String getAddress_ID() {
                return Address_ID;
            }

            public void setAddress_ID(String Address_ID) {
                this.Address_ID = Address_ID;
            }

            public String getAddress_Provice() {
                return Address_Provice;
            }

            public void setAddress_Provice(String Address_Provice) {
                this.Address_Provice = Address_Provice;
            }

            public String getAddress_City() {
                return Address_City;
            }

            public void setAddress_City(String Address_City) {
                this.Address_City = Address_City;
            }

            public String getAddress_Region() {
                return Address_Region;
            }

            public void setAddress_Region(String Address_Region) {
                this.Address_Region = Address_Region;
            }

            public String getAddress_Detail() {
                return Address_Detail;
            }

            public void setAddress_Detail(String Address_Detail) {
                this.Address_Detail = Address_Detail;
            }

            public String getAddress_FullAddress() {
                return Address_FullAddress;
            }

            public void setAddress_FullAddress(String Address_FullAddress) {
                this.Address_FullAddress = Address_FullAddress;
            }

            public int getOrder_PayType() {
                return Order_PayType;
            }

            public void setOrder_PayType(int Order_PayType) {
                this.Order_PayType = Order_PayType;
            }

            public int getOrder_State() {
                return Order_State;
            }

            public void setOrder_State(int Order_State) {
                this.Order_State = Order_State;
            }

            public int getOrder_Money() {
                return Order_Money;
            }

            public void setOrder_Money(int Order_Money) {
                this.Order_Money = Order_Money;
            }

            public int getORder_Freight() {
                return ORder_Freight;
            }

            public void setORder_Freight(int ORder_Freight) {
                this.ORder_Freight = ORder_Freight;
            }

            public int getOrder_Seed() {
                return Order_Seed;
            }

            public void setOrder_Seed(int Order_Seed) {
                this.Order_Seed = Order_Seed;
            }

            public int getOrder_Type() {
                return Order_Type;
            }

            public void setOrder_Type(int Order_Type) {
                this.Order_Type = Order_Type;
            }

            public Object getOrderStartDate() {
                return OrderStartDate;
            }

            public void setOrderStartDate(Object OrderStartDate) {
                this.OrderStartDate = OrderStartDate;
            }

            public Object getOrderEndDate() {
                return OrderEndDate;
            }

            public void setOrderEndDate(Object OrderEndDate) {
                this.OrderEndDate = OrderEndDate;
            }

            public int getOrder_Integer() {
                return Order_Integer;
            }

            public void setOrder_Integer(int Order_Integer) {
                this.Order_Integer = Order_Integer;
            }

            public String getOrder_Remark() {
                return Order_Remark;
            }

            public void setOrder_Remark(String Order_Remark) {
                this.Order_Remark = Order_Remark;
            }

            public int getOrder_IntegerMoney() {
                return Order_IntegerMoney;
            }

            public void setOrder_IntegerMoney(int Order_IntegerMoney) {
                this.Order_IntegerMoney = Order_IntegerMoney;
            }

            public int getOrder_IntegerMoneyRate() {
                return Order_IntegerMoneyRate;
            }

            public void setOrder_IntegerMoneyRate(int Order_IntegerMoneyRate) {
                this.Order_IntegerMoneyRate = Order_IntegerMoneyRate;
            }

            public int getOrder_Number() {
                return Order_Number;
            }

            public void setOrder_Number(int Order_Number) {
                this.Order_Number = Order_Number;
            }

            public Object getOrder_WaybillCompany() {
                return Order_WaybillCompany;
            }

            public void setOrder_WaybillCompany(Object Order_WaybillCompany) {
                this.Order_WaybillCompany = Order_WaybillCompany;
            }

            public Object getOrder_WaybillNumber() {
                return Order_WaybillNumber;
            }

            public void setOrder_WaybillNumber(Object Order_WaybillNumber) {
                this.Order_WaybillNumber = Order_WaybillNumber;
            }

            public Object getOrder_DeliverGoodsUserInfoID() {
                return Order_DeliverGoodsUserInfoID;
            }

            public void setOrder_DeliverGoodsUserInfoID(Object Order_DeliverGoodsUserInfoID) {
                this.Order_DeliverGoodsUserInfoID = Order_DeliverGoodsUserInfoID;
            }

            public int getOrder_RebateMoney() {
                return Order_RebateMoney;
            }

            public void setOrder_RebateMoney(int Order_RebateMoney) {
                this.Order_RebateMoney = Order_RebateMoney;
            }

            public int getOrder_RebateNumber() {
                return Order_RebateNumber;
            }

            public void setOrder_RebateNumber(int Order_RebateNumber) {
                this.Order_RebateNumber = Order_RebateNumber;
            }

            public boolean isOrder_HasNewGoods() {
                return Order_HasNewGoods;
            }

            public void setOrder_HasNewGoods(boolean Order_HasNewGoods) {
                this.Order_HasNewGoods = Order_HasNewGoods;
            }

            public Object getOrder_DeliverGoodsTime() {
                return Order_DeliverGoodsTime;
            }

            public void setOrder_DeliverGoodsTime(Object Order_DeliverGoodsTime) {
                this.Order_DeliverGoodsTime = Order_DeliverGoodsTime;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(Order_ID);
                dest.writeString(Order_No);
                dest.writeString(UserInfo_ID);
                dest.writeString(UserInfo_HeadImg);
                dest.writeString(Order_PayNo);
                dest.writeString(Order_CreateTime);
                dest.writeString(Address_Name);
                dest.writeString(Address_Mobile);
                dest.writeString(Address_ID);
                dest.writeString(Address_Provice);
                dest.writeString(Address_City);
                dest.writeString(Address_Region);
                dest.writeString(Address_Detail);
                dest.writeString(Address_FullAddress);
                dest.writeInt(Order_PayType);
                dest.writeInt(Order_State);
                dest.writeInt(Order_Money);
                dest.writeInt(ORder_Freight);
                dest.writeInt(Order_Seed);
                dest.writeInt(Order_Type);
                dest.writeInt(Order_Integer);
                dest.writeString(Order_Remark);
                dest.writeInt(Order_IntegerMoney);
                dest.writeInt(Order_IntegerMoneyRate);
                dest.writeInt(Order_Number);
                dest.writeInt(Order_RebateMoney);
                dest.writeInt(Order_RebateNumber);
                dest.writeByte((byte) (Order_HasNewGoods ? 1 : 0));
            }
        }

        public static class OrderItemBean implements Parcelable {

            public OrderItemBean() {
            }

            /**
             * OrderItem_ID : 53c3b72b-d195-41a6-94b4-f0de0db8876b
             * Product_ID : 1a4179e2-5555-46d0-aa62-0218369f211b
             * Product_Name : 裤子
             * Product_ImgPath : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164363&di=5273719a0ec59feb189fdc864d79cfa6&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fback_pic%2Fqk%2Fback_origin_pic%2F00%2F03%2F14%2Fc0391a6c1efab3fe00911b04e8cedca4.jpg
             * Product_Price : 0
             * OrderItem_Number : 1
             * OrderItem_Money : 900
             * Order_ID : 96fff514-b711-4593-9ed3-24eb2aea17c2
             * DotProduct_ID :
             * Spec_ID : 58410b32-92ae-4486-99f4-6b086be1a705
             * Spec_Name : 长袖
             * SpecAttr_ID :
             * SpecAttr_Name : 蓝色
             * SpecAttr_Price : 900
             * SpecAttr_Integer : 0
             * OrderItem_Integer : 0
             * OrderItem_Discount : 0
             * OrderItem_Type : 0
             * OrderItem_UseCode : null
             */

            private String OrderItem_ID;
            private String Product_ID;
            private String Product_Name;
            private String Product_ImgPath;
            private int Product_Price;
            private int OrderItem_Number;
            private int OrderItem_Money;
            private String Order_ID;
            private String DotProduct_ID;
            private String Spec_ID;
            private String Spec_Name;
            private String SpecAttr_ID;
            private String SpecAttr_Name;
            private int SpecAttr_Price;
            private int SpecAttr_Integer;
            private int OrderItem_Integer;
            private int OrderItem_Discount;
            private int OrderItem_Type;
            private Object OrderItem_UseCode;

            protected OrderItemBean(Parcel in) {
                OrderItem_ID = in.readString();
                Product_ID = in.readString();
                Product_Name = in.readString();
                Product_ImgPath = in.readString();
                Product_Price = in.readInt();
                OrderItem_Number = in.readInt();
                OrderItem_Money = in.readInt();
                Order_ID = in.readString();
                DotProduct_ID = in.readString();
                Spec_ID = in.readString();
                Spec_Name = in.readString();
                SpecAttr_ID = in.readString();
                SpecAttr_Name = in.readString();
                SpecAttr_Price = in.readInt();
                SpecAttr_Integer = in.readInt();
                OrderItem_Integer = in.readInt();
                OrderItem_Discount = in.readInt();
                OrderItem_Type = in.readInt();
            }

            public static final Creator<OrderItemBean> CREATOR = new Creator<OrderItemBean>() {
                @Override
                public OrderItemBean createFromParcel(Parcel in) {
                    return new OrderItemBean(in);
                }

                @Override
                public OrderItemBean[] newArray(int size) {
                    return new OrderItemBean[size];
                }
            };

            public String getOrderItem_ID() {
                return OrderItem_ID;
            }

            public void setOrderItem_ID(String OrderItem_ID) {
                this.OrderItem_ID = OrderItem_ID;
            }

            public String getProduct_ID() {
                return Product_ID;
            }

            public void setProduct_ID(String Product_ID) {
                this.Product_ID = Product_ID;
            }

            public String getProduct_Name() {
                return Product_Name;
            }

            public void setProduct_Name(String Product_Name) {
                this.Product_Name = Product_Name;
            }

            public String getProduct_ImgPath() {
                return Product_ImgPath;
            }

            public void setProduct_ImgPath(String Product_ImgPath) {
                this.Product_ImgPath = Product_ImgPath;
            }

            public int getProduct_Price() {
                return Product_Price;
            }

            public void setProduct_Price(int Product_Price) {
                this.Product_Price = Product_Price;
            }

            public int getOrderItem_Number() {
                return OrderItem_Number;
            }

            public void setOrderItem_Number(int OrderItem_Number) {
                this.OrderItem_Number = OrderItem_Number;
            }

            public int getOrderItem_Money() {
                return OrderItem_Money;
            }

            public void setOrderItem_Money(int OrderItem_Money) {
                this.OrderItem_Money = OrderItem_Money;
            }

            public String getOrder_ID() {
                return Order_ID;
            }

            public void setOrder_ID(String Order_ID) {
                this.Order_ID = Order_ID;
            }

            public String getDotProduct_ID() {
                return DotProduct_ID;
            }

            public void setDotProduct_ID(String DotProduct_ID) {
                this.DotProduct_ID = DotProduct_ID;
            }

            public String getSpec_ID() {
                return Spec_ID;
            }

            public void setSpec_ID(String Spec_ID) {
                this.Spec_ID = Spec_ID;
            }

            public String getSpec_Name() {
                return Spec_Name;
            }

            public void setSpec_Name(String Spec_Name) {
                this.Spec_Name = Spec_Name;
            }

            public String getSpecAttr_ID() {
                return SpecAttr_ID;
            }

            public void setSpecAttr_ID(String SpecAttr_ID) {
                this.SpecAttr_ID = SpecAttr_ID;
            }

            public String getSpecAttr_Name() {
                return SpecAttr_Name;
            }

            public void setSpecAttr_Name(String SpecAttr_Name) {
                this.SpecAttr_Name = SpecAttr_Name;
            }

            public int getSpecAttr_Price() {
                return SpecAttr_Price;
            }

            public void setSpecAttr_Price(int SpecAttr_Price) {
                this.SpecAttr_Price = SpecAttr_Price;
            }

            public int getSpecAttr_Integer() {
                return SpecAttr_Integer;
            }

            public void setSpecAttr_Integer(int SpecAttr_Integer) {
                this.SpecAttr_Integer = SpecAttr_Integer;
            }

            public int getOrderItem_Integer() {
                return OrderItem_Integer;
            }

            public void setOrderItem_Integer(int OrderItem_Integer) {
                this.OrderItem_Integer = OrderItem_Integer;
            }

            public int getOrderItem_Discount() {
                return OrderItem_Discount;
            }

            public void setOrderItem_Discount(int OrderItem_Discount) {
                this.OrderItem_Discount = OrderItem_Discount;
            }

            public int getOrderItem_Type() {
                return OrderItem_Type;
            }

            public void setOrderItem_Type(int OrderItem_Type) {
                this.OrderItem_Type = OrderItem_Type;
            }

            public Object getOrderItem_UseCode() {
                return OrderItem_UseCode;
            }

            public void setOrderItem_UseCode(Object OrderItem_UseCode) {
                this.OrderItem_UseCode = OrderItem_UseCode;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(OrderItem_ID);
                dest.writeString(Product_ID);
                dest.writeString(Product_Name);
                dest.writeString(Product_ImgPath);
                dest.writeInt(Product_Price);
                dest.writeInt(OrderItem_Number);
                dest.writeInt(OrderItem_Money);
                dest.writeString(Order_ID);
                dest.writeString(DotProduct_ID);
                dest.writeString(Spec_ID);
                dest.writeString(Spec_Name);
                dest.writeString(SpecAttr_ID);
                dest.writeString(SpecAttr_Name);
                dest.writeInt(SpecAttr_Price);
                dest.writeInt(SpecAttr_Integer);
                dest.writeInt(OrderItem_Integer);
                dest.writeInt(OrderItem_Discount);
                dest.writeInt(OrderItem_Type);
            }
        }
    }
}

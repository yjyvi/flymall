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
     * code : 0
     * message : 1
     * resultdata : [{"commentCount":0,"id":2018061155998180,"itemInfo":[{"Unit":"个","count":3,"image":"/Storage/Shop/266/Products/1512/1_100.png","isHuiProduct":0,"price":1194,"productId":1512,"productName":"??????????????????????????????"}],"orderStatus":1,"orderTotalAmount":"1194.00","productCount":3,"shopname":"????","status":"待付款"}]
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

    public static class ResultdataBean implements Parcelable {

        public ResultdataBean() {
        }

        /**
         * commentCount : 0
         * id : 2018061155998180
         * itemInfo : [{"Unit":"个","count":3,"image":"/Storage/Shop/266/Products/1512/1_100.png","isHuiProduct":0,"price":1194,"productId":1512,"productName":"??????????????????????????????"}]
         * orderStatus : 1
         * orderTotalAmount : 1194.00
         * productCount : 3
         * shopname : ????
         * status : 待付款
         */

        private int commentCount;
        private long id;
        private int orderStatus;
        private String orderTotalAmount;
        private int productCount;
        private String shopname;
        private String status;
        private List<ItemInfoBean> itemInfo;

        protected ResultdataBean(Parcel in) {
            commentCount = in.readInt();
            id = in.readLong();
            orderStatus = in.readInt();
            orderTotalAmount = in.readString();
            productCount = in.readInt();
            shopname = in.readString();
            status = in.readString();
            itemInfo = in.createTypedArrayList(ItemInfoBean.CREATOR);
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

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getOrderTotalAmount() {
            return orderTotalAmount;
        }

        public void setOrderTotalAmount(String orderTotalAmount) {
            this.orderTotalAmount = orderTotalAmount;
        }

        public int getProductCount() {
            return productCount;
        }

        public void setProductCount(int productCount) {
            this.productCount = productCount;
        }

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<ItemInfoBean> getItemInfo() {
            return itemInfo;
        }

        public void setItemInfo(List<ItemInfoBean> itemInfo) {
            this.itemInfo = itemInfo;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(commentCount);
            dest.writeLong(id);
            dest.writeInt(orderStatus);
            dest.writeString(orderTotalAmount);
            dest.writeInt(productCount);
            dest.writeString(shopname);
            dest.writeString(status);
            dest.writeTypedList(itemInfo);
        }

        public static class ItemInfoBean implements Parcelable {
            public ItemInfoBean() {
            }

            /**
             * Unit : 个
             * count : 3
             * image : /Storage/Shop/266/Products/1512/1_100.png
             * isHuiProduct : 0
             * price : 1194.0
             * productId : 1512
             * productName : ??????????????????????????????
             */

            private String Unit;
            private int count;
            private String image;
            private int isHuiProduct;
            private double price;
            private int productId;
            private String productName;

            private  boolean isComment;

            public boolean isComment() {
                return isComment;
            }

            public void setComment(boolean comment) {
                isComment = comment;
            }

            protected ItemInfoBean(Parcel in) {
                Unit = in.readString();
                count = in.readInt();
                image = in.readString();
                isHuiProduct = in.readInt();
                price = in.readDouble();
                productId = in.readInt();
                productName = in.readString();
            }

            public static final Creator<ItemInfoBean> CREATOR = new Creator<ItemInfoBean>() {
                @Override
                public ItemInfoBean createFromParcel(Parcel in) {
                    return new ItemInfoBean(in);
                }

                @Override
                public ItemInfoBean[] newArray(int size) {
                    return new ItemInfoBean[size];
                }
            };

            public String getUnit() {
                return Unit;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getIsHuiProduct() {
                return isHuiProduct;
            }

            public void setIsHuiProduct(int isHuiProduct) {
                this.isHuiProduct = isHuiProduct;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(Unit);
                dest.writeInt(count);
                dest.writeString(image);
                dest.writeInt(isHuiProduct);
                dest.writeDouble(price);
                dest.writeInt(productId);
                dest.writeString(productName);
            }
        }
    }
}

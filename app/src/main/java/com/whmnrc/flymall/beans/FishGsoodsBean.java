package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * Created by yong hao zeng on 2017/12/11.
 */

public class FishGsoodsBean  {




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



    public static class ResultdataBean {
        /**
         * userInfo : {"UserInfo_ID":"81cc81c4-3e70-4b4e-9519-85baf1c27f49","UserInfo_HeadImg":"http://lkyyzj.com//UserFile/Image/userhead.jpg","UserInfo_NickName":"测试","UserInfo_Pwd":"E10ADC3949BA59ABBE56E057F20F883E","UserInfo_Mobile":"18671232607","UserInfo_Sex":0,"UserInfo_Money":0,"UserInfo_Integer":0,"UserInfo_CreateTime":"2018-01-18T13:36:37.533","UserInfo_State":0,"UserInfo_IsApp":0,"UserInfo_Provice":"","UserInfo_City":"","UserInfo_Region":"","UserInfo_DetailAddress":"","UserInfo_Type":1,"UserInfo_ParentID":"","UserInfo_IdentityCard":"","UserInfo_RealName":"","UserInfo_Level":0,"UserInfo_FullAddress":"","UserInfo_TotalMoney":0,"UserInfo_Describe":"这家伙很懒，什么都没有留下。","UserInfo_UUAccount":"18671232607","UserInfo_UUID":"8d537530-fc11-11e7-9bd3-e5fb17d6a2b0","Business_ID":"0508aeb0-2083-4e72-824b-7a0c9a2d1e3e","UserInfo_QQID":null,"UserInfo_WeChatID":null,"UserInfo_WeiboID":null,"UserInfo_YuDou":5,"UserInfo_YuBi":0,"UserInfo_Experience":0,"UserInfo_Deposit":0,"UserInfo_TTDeposit":0,"UserInfo_YYDeposit":0,"UserInfo_IsAnchor":1}
         * CommodityAddList : []
         * standardName1 : 鱼缸
         * standardName2 : 鱼缸
         * CommodityPriceList : [{"CommodityPrice_ID":"9bea82d6-a4c2-48b6-bae7-8efef8f64570","Commodity_ID":"6703f4de-5b3c-4768-8bbc-42097fe25ab2","Name":"测试","Price":200,"Stock":11,"Parent_ID":"cd8c4cb9-51b3-4151-81f4-deb8578bad54","DiscountPrice":100,"IsDiscount":1},{"CommodityPrice_ID":"cd8c4cb9-51b3-4151-81f4-deb8578bad54","Commodity_ID":"6703f4de-5b3c-4768-8bbc-42097fe25ab2","Name":"测试","Price":0,"Stock":0,"Parent_ID":null,"DiscountPrice":0,"IsDiscount":0},{"CommodityPrice_ID":"e7b0e15e-fb9a-4fd1-9f9f-96170b411714","Commodity_ID":"6703f4de-5b3c-4768-8bbc-42097fe25ab2","Name":"测试12","Price":300,"Stock":10,"Parent_ID":"cd8c4cb9-51b3-4151-81f4-deb8578bad54","DiscountPrice":150,"IsDiscount":1}]
         * Like : []
         * isLike : 0
         * Comment : []
         * CommentCount : 0
         * TotalPage : 8
         * Commodity_ID : 6703f4de-5b3c-4768-8bbc-42097fe25ab2
         * Business_ID : 0508aeb0-2083-4e72-824b-7a0c9a2d1e3e
         * Price : 0.0
         * DiscountPrice : 0.0
         * Name : 测试商品
         * Stock : 0
         * Sales : 0
         * Freight : 10.0
         * CommodityCategory_ID : 1fd7bf8b-ab37-46c1-9b48-efb4b8fb8f4c
         * ShelvesTime : 2018-01-19T10:40:44
         * IsShelves : 1
         * Pageview : 0
         * LikeCount : 0
         * Conten : http://lkyyzj.com/BHome/CommodityDelity?CommodityID=6703f4de-5b3c-4768-8bbc-42097fe25ab2
         * IsDiscount : 1
         * Sort : 0
         * Address : null
         * Type : 1
         * IsHot : 0
         * DiscountPriceString : 100.00-150.00
         * PriceString : 200.00-300.00
         */

        private UserInfoBean userInfo;
        private String standardName1;
        private String standardName2;
        private int isLike;
        private int CommentCount;
        private int TotalPage;
        private String Commodity_ID;
        private String Business_ID;
        private double Price;
        private double DiscountPrice;
        private String Name;
        private int Stock;
        private int Sales;
        private double Freight;
        private String CommodityCategory_ID;
        private String ShelvesTime;
        private int IsShelves;
        private int Pageview;
        private int LikeCount;
        private String Conten;
        private int IsDiscount;
        private int Sort;
        private String Address;
        private int Type;
        private String  UUAccount;
        private String HeadImg;
        private String NickName;
        private int IsHot;
        private String Img;
        private List<String> Label;
        private String DiscountPriceString;
        private List<ParameteBean> Parameter;
        private String PriceString;
        private List<CommodityAddListBean> CommodityAddList;
        private List<CommodityPriceListBean> CommodityPriceList;

        private List<CommentBean> Comment;




        public String getImg() {
            return Img;
        }

        public void setImg(String img) {
            Img = img;
        }

        public String getHeadImg() {
            return HeadImg;
        }

        public void setHeadImg(String headImg) {
            HeadImg = headImg;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String nickName) {
            this.NickName = nickName;
        }

        public List<ParameteBean> getParameter() {
            return Parameter;
        }

        public void setParameter(List<ParameteBean> parameter) {
            Parameter = parameter;
        }

        public List<String> getLabel() {
            return Label;
        }

        public String getUUAccount() {
            return UUAccount;
        }

        public void setUUAccount(String UUAccount) {
            this.UUAccount = UUAccount;
        }




        public static class ParameteBean  {

           /**
            * CommodityParameter_ID : 7a98999b-efe0-40b5-b20d-a6d4fd1db90b
            * Commodity_ID : 6703f4de-5b3c-4768-8bbc-42097fe25ab2
            * ParameterName : 测试
            * ParameterContent : 测试第一排
            测试第二排
            测试第三排
            */

           private String CommodityParameter_ID;
           private String Commodity_ID;
           private String ParameterName;
           private String ParameterContent;



            public String getCommodityParameter_ID() {
               return CommodityParameter_ID;
           }

           public void setCommodityParameter_ID(String CommodityParameter_ID) {
               this.CommodityParameter_ID = CommodityParameter_ID;
           }

           public String getCommodity_ID() {
               return Commodity_ID;
           }

           public void setCommodity_ID(String Commodity_ID) {
               this.Commodity_ID = Commodity_ID;
           }

           public String getParameterName() {
               return ParameterName;
           }

           public void setParameterName(String ParameterName) {
               this.ParameterName = ParameterName;
           }

           public String getParameterContent() {
               return ParameterContent;
           }

           public void setParameterContent(String ParameterContent) {
               this.ParameterContent = ParameterContent;
           }


        }


        public void setLabel(List<String> label) {
            Label = label;
        }



        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public String getStandardName1() {
            return standardName1;
        }

        public void setStandardName1(String standardName1) {
            this.standardName1 = standardName1;
        }

        public String getStandardName2() {
            return standardName2;
        }

        public void setStandardName2(String standardName2) {
            this.standardName2 = standardName2;
        }

        public int getIsLike() {
            return isLike;
        }

        public void setIsLike(int isLike) {
            this.isLike = isLike;
        }

        public int getCommentCount() {
            return CommentCount;
        }

        public void setCommentCount(int CommentCount) {
            this.CommentCount = CommentCount;
        }

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public String getCommodity_ID() {
            return Commodity_ID;
        }

        public void setCommodity_ID(String Commodity_ID) {
            this.Commodity_ID = Commodity_ID;
        }

        public String getBusiness_ID() {
            return Business_ID;
        }

        public void setBusiness_ID(String Business_ID) {
            this.Business_ID = Business_ID;
        }

        public double getPrice() {
            return Price;
        }

        public void setPrice(double Price) {
            this.Price = Price;
        }

        public double getDiscountPrice() {
            return DiscountPrice;
        }

        public void setDiscountPrice(double DiscountPrice) {
            this.DiscountPrice = DiscountPrice;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getStock() {
            return Stock;
        }

        public void setStock(int Stock) {
            this.Stock = Stock;
        }

        public int getSales() {
            return Sales;
        }

        public void setSales(int Sales) {
            this.Sales = Sales;
        }

        public double getFreight() {
            return Freight;
        }

        public void setFreight(double Freight) {
            this.Freight = Freight;
        }

        public String getCommodityCategory_ID() {
            return CommodityCategory_ID;
        }

        public void setCommodityCategory_ID(String CommodityCategory_ID) {
            this.CommodityCategory_ID = CommodityCategory_ID;
        }

        public String getShelvesTime() {
            return ShelvesTime;
        }

        public void setShelvesTime(String ShelvesTime) {
            this.ShelvesTime = ShelvesTime;
        }

        public int getIsShelves() {
            return IsShelves;
        }

        public void setIsShelves(int IsShelves) {
            this.IsShelves = IsShelves;
        }

        public int getPageview() {
            return Pageview;
        }

        public void setPageview(int Pageview) {
            this.Pageview = Pageview;
        }

        public int getLikeCount() {
            return LikeCount;
        }

        public void setLikeCount(int LikeCount) {
            this.LikeCount = LikeCount;
        }

        public String getConten() {
            return Conten;
        }

        public void setConten(String Conten) {
            this.Conten = Conten;
        }

        public int getIsDiscount() {
            return IsDiscount;
        }

        public void setIsDiscount(int IsDiscount) {
            this.IsDiscount = IsDiscount;
        }

        public int getSort() {
            return Sort;
        }

        public void setSort(int Sort) {
            this.Sort = Sort;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public int getType() {
            return Type;
        }

        public void setType(int Type) {
            this.Type = Type;
        }

        public int getIsHot() {
            return IsHot;
        }

        public void setIsHot(int IsHot) {
            this.IsHot = IsHot;
        }

        public String getDiscountPriceString() {
            return DiscountPriceString;
        }

        public void setDiscountPriceString(String DiscountPriceString) {
            this.DiscountPriceString = DiscountPriceString;
        }

        public String getPriceString() {
            return PriceString;
        }

        public void setPriceString(String PriceString) {
            this.PriceString = PriceString;
        }

        public List<CommodityAddListBean> getCommodityAddList() {
            return CommodityAddList;
        }

        public void setCommodityAddList(List<CommodityAddListBean> CommodityAddList) {
            this.CommodityAddList = CommodityAddList;
        }

        public List<CommodityPriceListBean> getCommodityPriceList() {
            return CommodityPriceList;
        }

        public void setCommodityPriceList(List<CommodityPriceListBean> CommodityPriceList) {
            this.CommodityPriceList = CommodityPriceList;
        }



        public List<CommentBean> getComment() {
            return Comment;
        }

        public void setComment(List<CommentBean> Comment) {
            this.Comment = Comment;
        }
        public static class CommentBean  {
            /**
             * Comment_ID : 321312
             * CommentParent_ID :
             * UserInfo_ID : 14d24b07-8899-4971-96a2-cea033f26344
             * UserName : 曾永浩
             * PassiveUserName :
             * HeadImage : http://fweb.whmnx.com/Resource/Qualification/c5f2ca64-5f8b-4031-a108-e3aefd3193e1.jpg
             * Comment_Content : 评论啊啊啊
             * Other_ID : 95c643fd-99c8-4647-8392-14d97240954f
             * Time : 2017-11-08T00:00:00
             */

            private String Comment_ID;
            private String CommentParent_ID;
            private String UserInfo_ID;
            private String UserName;
            private String PassiveUserName;
            private String HeadImage;
            private String Comment_Content;
            private String Other_ID;
            private String Time;



            public String getComment_ID() {
                return Comment_ID;
            }

            public void setComment_ID(String Comment_ID) {
                this.Comment_ID = Comment_ID;
            }

            public String getCommentParent_ID() {
                return CommentParent_ID;
            }

            public void setCommentParent_ID(String CommentParent_ID) {
                this.CommentParent_ID = CommentParent_ID;
            }

            public String getUserInfo_ID() {
                return UserInfo_ID;
            }

            public void setUserInfo_ID(String UserInfo_ID) {
                this.UserInfo_ID = UserInfo_ID;
            }

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getPassiveUserName() {
                return PassiveUserName;
            }

            public void setPassiveUserName(String PassiveUserName) {
                this.PassiveUserName = PassiveUserName;
            }

            public String getHeadImage() {
                return HeadImage;
            }

            public void setHeadImage(String HeadImage) {
                this.HeadImage = HeadImage;
            }

            public String getComment_Content() {
                return Comment_Content;
            }

            public void setComment_Content(String Comment_Content) {
                this.Comment_Content = Comment_Content;
            }

            public String getOther_ID() {
                return Other_ID;
            }

            public void setOther_ID(String Other_ID) {
                this.Other_ID = Other_ID;
            }

            public String getTime() {
                return Time;
            }

            public void setTime(String Time) {
                this.Time = Time;
            }


        }

        public static class CommodityAddListBean    {
            /**
             * CommodityAdd_ID : 6e2114f2-7133-4980-a651-61b2e5e55da2
             * Commodity_ID : 95c643fd-99c8-4647-8392-14d97240954f
             * type : 2
             * FilePath : http://fweb.whmnx.com//Resource/Qualification/3653b4ce-e141-49ab-a073-9e2cad6b4633.jpg
             * Sort : 0
             */

            private String CommodityAdd_ID;
            private String Commodity_ID;
            private int type;
            private String FilePath;
            private int Sort;



            public String getCommodityAdd_ID() {
                return CommodityAdd_ID;
            }

            public void setCommodityAdd_ID(String commodityAdd_ID) {
                CommodityAdd_ID = commodityAdd_ID;
            }

            public String getCommodity_ID() {
                return Commodity_ID;
            }

            public void setCommodity_ID(String commodity_ID) {
                Commodity_ID = commodity_ID;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getFilePath() {
                return FilePath;
            }

            public void setFilePath(String filePath) {
                FilePath = filePath;
            }

            public int getSort() {
                return Sort;
            }

            public void setSort(int sort) {
                Sort = sort;
            }


        }

        public static class UserInfoBean  {
            /**
             * UserInfo_ID : 81cc81c4-3e70-4b4e-9519-85baf1c27f49
             * UserInfo_HeadImg : http://lkyyzj.com//UserFile/Image/userhead.jpg
             * UserInfo_NickName : 测试
             * UserInfo_Pwd : E10ADC3949BA59ABBE56E057F20F883E
             * UserInfo_Mobile : 18671232607
             * UserInfo_Sex : 0
             * UserInfo_Money : 0.0
             * UserInfo_Integer : 0
             * UserInfo_CreateTime : 2018-01-18T13:36:37.533
             * UserInfo_State : 0
             * UserInfo_IsApp : 0
             * UserInfo_Provice :
             * UserInfo_City :
             * UserInfo_Region :
             * UserInfo_DetailAddress :
             * UserInfo_Type : 1
             * UserInfo_ParentID :
             * UserInfo_IdentityCard :
             * UserInfo_RealName :
             * UserInfo_Level : 0
             * UserInfo_FullAddress :
             * UserInfo_TotalMoney : 0.0
             * UserInfo_Describe : 这家伙很懒，什么都没有留下。
             * UserInfo_UUAccount : 18671232607
             * UserInfo_UUID : 8d537530-fc11-11e7-9bd3-e5fb17d6a2b0
             * Business_ID : 0508aeb0-2083-4e72-824b-7a0c9a2d1e3e
             * UserInfo_QQID : null
             * UserInfo_WeChatID : null
             * UserInfo_WeiboID : null
             * UserInfo_YuDou : 5.0
             * UserInfo_YuBi : 0.0
             * UserInfo_Experience : 0
             * UserInfo_Deposit : 0.0
             * UserInfo_TTDeposit : 0.0
             * UserInfo_YYDeposit : 0.0
             * UserInfo_IsAnchor : 1
             */

            private String UserInfo_ID;
            private String UserInfo_HeadImg;
            private String UserInfo_NickName;
            private String UserInfo_Pwd;
            private String UserInfo_Mobile;
            private int UserInfo_Sex;
            private double UserInfo_Money;
            private int UserInfo_Integer;
            private String UserInfo_CreateTime;
            private int UserInfo_State;
            private int UserInfo_IsApp;
            private String UserInfo_Provice;
            private String UserInfo_City;
            private String UserInfo_Region;
            private String UserInfo_DetailAddress;
            private int UserInfo_Type;
            private String UserInfo_ParentID;
            private String UserInfo_IdentityCard;
            private String UserInfo_RealName;
            private int UserInfo_Level;
            private String UserInfo_FullAddress;
            private double UserInfo_TotalMoney;
            private String UserInfo_Describe;
            private String UserInfo_UUAccount;
            private String UserInfo_UUID;
            private String Business_ID;
            private String UserInfo_QQID;
            private String UserInfo_WeChatID;
            private String UserInfo_WeiboID;
            private double UserInfo_YuDou;
            private double UserInfo_YuBi;
            private int UserInfo_Experience;
            private double UserInfo_Deposit;
            private double UserInfo_TTDeposit;
            private double UserInfo_YYDeposit;
            private int UserInfo_IsAnchor;


            public String getUserInfo_ID() {
                return UserInfo_ID;
            }

            public void setUserInfo_ID(String UserInfo_ID) {
                this.UserInfo_ID = UserInfo_ID;
            }

            public String getUserInfo_HeadImg() {
                return UserInfo_HeadImg;
            }

            public void setUserInfo_HeadImg(String UserInfo_HeadImg) {
                this.UserInfo_HeadImg = UserInfo_HeadImg;
            }

            public String getUserInfo_NickName() {
                return UserInfo_NickName;
            }

            public void setUserInfo_NickName(String UserInfo_NickName) {
                this.UserInfo_NickName = UserInfo_NickName;
            }

            public String getUserInfo_Pwd() {
                return UserInfo_Pwd;
            }

            public void setUserInfo_Pwd(String UserInfo_Pwd) {
                this.UserInfo_Pwd = UserInfo_Pwd;
            }

            public String getUserInfo_Mobile() {
                return UserInfo_Mobile;
            }

            public void setUserInfo_Mobile(String UserInfo_Mobile) {
                this.UserInfo_Mobile = UserInfo_Mobile;
            }

            public int getUserInfo_Sex() {
                return UserInfo_Sex;
            }

            public void setUserInfo_Sex(int UserInfo_Sex) {
                this.UserInfo_Sex = UserInfo_Sex;
            }

            public double getUserInfo_Money() {
                return UserInfo_Money;
            }

            public void setUserInfo_Money(double UserInfo_Money) {
                this.UserInfo_Money = UserInfo_Money;
            }

            public int getUserInfo_Integer() {
                return UserInfo_Integer;
            }

            public void setUserInfo_Integer(int UserInfo_Integer) {
                this.UserInfo_Integer = UserInfo_Integer;
            }

            public String getUserInfo_CreateTime() {
                return UserInfo_CreateTime;
            }

            public void setUserInfo_CreateTime(String UserInfo_CreateTime) {
                this.UserInfo_CreateTime = UserInfo_CreateTime;
            }

            public int getUserInfo_State() {
                return UserInfo_State;
            }

            public void setUserInfo_State(int UserInfo_State) {
                this.UserInfo_State = UserInfo_State;
            }

            public int getUserInfo_IsApp() {
                return UserInfo_IsApp;
            }

            public void setUserInfo_IsApp(int UserInfo_IsApp) {
                this.UserInfo_IsApp = UserInfo_IsApp;
            }

            public String getUserInfo_Provice() {
                return UserInfo_Provice;
            }

            public void setUserInfo_Provice(String UserInfo_Provice) {
                this.UserInfo_Provice = UserInfo_Provice;
            }

            public String getUserInfo_City() {
                return UserInfo_City;
            }

            public void setUserInfo_City(String UserInfo_City) {
                this.UserInfo_City = UserInfo_City;
            }

            public String getUserInfo_Region() {
                return UserInfo_Region;
            }

            public void setUserInfo_Region(String UserInfo_Region) {
                this.UserInfo_Region = UserInfo_Region;
            }

            public String getUserInfo_DetailAddress() {
                return UserInfo_DetailAddress;
            }

            public void setUserInfo_DetailAddress(String UserInfo_DetailAddress) {
                this.UserInfo_DetailAddress = UserInfo_DetailAddress;
            }

            public int getUserInfo_Type() {
                return UserInfo_Type;
            }

            public void setUserInfo_Type(int UserInfo_Type) {
                this.UserInfo_Type = UserInfo_Type;
            }

            public String getUserInfo_ParentID() {
                return UserInfo_ParentID;
            }

            public void setUserInfo_ParentID(String UserInfo_ParentID) {
                this.UserInfo_ParentID = UserInfo_ParentID;
            }

            public String getUserInfo_IdentityCard() {
                return UserInfo_IdentityCard;
            }

            public void setUserInfo_IdentityCard(String UserInfo_IdentityCard) {
                this.UserInfo_IdentityCard = UserInfo_IdentityCard;
            }

            public String getUserInfo_RealName() {
                return UserInfo_RealName;
            }

            public void setUserInfo_RealName(String UserInfo_RealName) {
                this.UserInfo_RealName = UserInfo_RealName;
            }

            public int getUserInfo_Level() {
                return UserInfo_Level;
            }

            public void setUserInfo_Level(int UserInfo_Level) {
                this.UserInfo_Level = UserInfo_Level;
            }

            public String getUserInfo_FullAddress() {
                return UserInfo_FullAddress;
            }

            public void setUserInfo_FullAddress(String UserInfo_FullAddress) {
                this.UserInfo_FullAddress = UserInfo_FullAddress;
            }

            public double getUserInfo_TotalMoney() {
                return UserInfo_TotalMoney;
            }

            public void setUserInfo_TotalMoney(double UserInfo_TotalMoney) {
                this.UserInfo_TotalMoney = UserInfo_TotalMoney;
            }

            public String getUserInfo_Describe() {
                return UserInfo_Describe;
            }

            public void setUserInfo_Describe(String UserInfo_Describe) {
                this.UserInfo_Describe = UserInfo_Describe;
            }

            public String getUserInfo_UUAccount() {
                return UserInfo_UUAccount;
            }

            public void setUserInfo_UUAccount(String UserInfo_UUAccount) {
                this.UserInfo_UUAccount = UserInfo_UUAccount;
            }

            public String getUserInfo_UUID() {
                return UserInfo_UUID;
            }

            public void setUserInfo_UUID(String UserInfo_UUID) {
                this.UserInfo_UUID = UserInfo_UUID;
            }

            public String getBusiness_ID() {
                return Business_ID;
            }

            public void setBusiness_ID(String Business_ID) {
                this.Business_ID = Business_ID;
            }

            public Object getUserInfo_QQID() {
                return UserInfo_QQID;
            }

            public void setUserInfo_QQID(String UserInfo_QQID) {
                this.UserInfo_QQID = UserInfo_QQID;
            }

            public Object getUserInfo_WeChatID() {
                return UserInfo_WeChatID;
            }

            public void setUserInfo_WeChatID(String UserInfo_WeChatID) {
                this.UserInfo_WeChatID = UserInfo_WeChatID;
            }

            public Object getUserInfo_WeiboID() {
                return UserInfo_WeiboID;
            }

            public void setUserInfo_WeiboID(String UserInfo_WeiboID) {
                this.UserInfo_WeiboID = UserInfo_WeiboID;
            }

            public double getUserInfo_YuDou() {
                return UserInfo_YuDou;
            }

            public void setUserInfo_YuDou(double UserInfo_YuDou) {
                this.UserInfo_YuDou = UserInfo_YuDou;
            }

            public double getUserInfo_YuBi() {
                return UserInfo_YuBi;
            }

            public void setUserInfo_YuBi(double UserInfo_YuBi) {
                this.UserInfo_YuBi = UserInfo_YuBi;
            }

            public int getUserInfo_Experience() {
                return UserInfo_Experience;
            }

            public void setUserInfo_Experience(int UserInfo_Experience) {
                this.UserInfo_Experience = UserInfo_Experience;
            }

            public double getUserInfo_Deposit() {
                return UserInfo_Deposit;
            }

            public void setUserInfo_Deposit(double UserInfo_Deposit) {
                this.UserInfo_Deposit = UserInfo_Deposit;
            }

            public double getUserInfo_TTDeposit() {
                return UserInfo_TTDeposit;
            }

            public void setUserInfo_TTDeposit(double UserInfo_TTDeposit) {
                this.UserInfo_TTDeposit = UserInfo_TTDeposit;
            }

            public double getUserInfo_YYDeposit() {
                return UserInfo_YYDeposit;
            }

            public void setUserInfo_YYDeposit(double UserInfo_YYDeposit) {
                this.UserInfo_YYDeposit = UserInfo_YYDeposit;
            }

            public int getUserInfo_IsAnchor() {
                return UserInfo_IsAnchor;
            }

            public void setUserInfo_IsAnchor(int UserInfo_IsAnchor) {
                this.UserInfo_IsAnchor = UserInfo_IsAnchor;
            }


        }

        public static class CommodityPriceListBean   {
            /**
             * CommodityPrice_ID : 9bea82d6-a4c2-48b6-bae7-8efef8f64570
             * Commodity_ID : 6703f4de-5b3c-4768-8bbc-42097fe25ab2
             * Name : 测试
             * Price : 200.0
             * Stock : 11
             * Parent_ID : cd8c4cb9-51b3-4151-81f4-deb8578bad54
             * DiscountPrice : 100.0
             * IsDiscount : 1
             */

            private String CommodityPrice_ID;
            private String Commodity_ID;
            private String Name;
            private double Price;
            private int Stock;
            private String Parent_ID;
            private double DiscountPrice;
            private int IsDiscount;



            public String getCommodityPrice_ID() {
                return CommodityPrice_ID;
            }

            public void setCommodityPrice_ID(String CommodityPrice_ID) {
                this.CommodityPrice_ID = CommodityPrice_ID;
            }

            public String getCommodity_ID() {
                return Commodity_ID;
            }

            public void setCommodity_ID(String Commodity_ID) {
                this.Commodity_ID = Commodity_ID;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public double getPrice() {
                return Price;
            }

            public void setPrice(double Price) {
                this.Price = Price;
            }

            public int getStock() {
                return Stock;
            }

            public void setStock(int Stock) {
                this.Stock = Stock;
            }

            public String getParent_ID() {
                return Parent_ID;
            }

            public void setParent_ID(String Parent_ID) {
                this.Parent_ID = Parent_ID;
            }

            public double getDiscountPrice() {
                return DiscountPrice;
            }

            public void setDiscountPrice(double DiscountPrice) {
                this.DiscountPrice = DiscountPrice;
            }

            public int getIsDiscount() {
                return IsDiscount;
            }

            public void setIsDiscount(int IsDiscount) {
                this.IsDiscount = IsDiscount;
            }


        }
    }
}


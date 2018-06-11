package com.whmnrc.flymall.beans;

import java.util.List;

public class UserBean   {


    /**
     * code : 0
     * message : 请求成功
     * resultdata : {"AvailableIntegrals":0,"BannerUrl":"/Storage/Plat/Site/wxlogo.png","Code":"$","CouponNum":0,"CreateDate":"2018-06-09 04:14:33","CurrencyName":"美元","CurrencyPrice":1,"Disabled":false,"Expenditure":0,"FavoriteInfo":[[]],"HistoryIntegral":0,"Id":4109,"InviteUserId":0,"LastLoginDate":"2018-06-09 04:14:33","MemberGradeId":0,"MemberGradeName":"Vip0","MemeberType":0,"Nick":"","OrderNumber":1,"ParentSellerId":0,"Password":"5cde8c9e2dcd649d3868cb646fe428eb","PasswordSalt":"46cd8bcb88a05e42855f","Photo":"","Points":0,"RegionId":0,"RelationState":false,"ShoppingCartNum":0,"TopRegionId":0,"UserName":"androidlk@aliyun.com"}
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
         * AvailableIntegrals : 0
         * BannerUrl : /Storage/Plat/Site/wxlogo.png
         * Code : $
         * CouponNum : 0
         * CreateDate : 2018-06-09 04:14:33
         * CurrencyName : 美元
         * CurrencyPrice : 1.0
         * Disabled : false
         * Expenditure : 0.0
         * FavoriteInfo : [[]]
         * HistoryIntegral : 0
         * Id : 4109
         * InviteUserId : 0
         * LastLoginDate : 2018-06-09 04:14:33
         * MemberGradeId : 0
         * MemberGradeName : Vip0
         * MemeberType : 0
         * Nick :
         * OrderNumber : 1
         * ParentSellerId : 0
         * Password : 5cde8c9e2dcd649d3868cb646fe428eb
         * PasswordSalt : 46cd8bcb88a05e42855f
         * Photo :
         * Points : 0
         * RegionId : 0
         * RelationState : false
         * ShoppingCartNum : 0
         * TopRegionId : 0
         * UserName : androidlk@aliyun.com
         */

        private int AvailableIntegrals;
        private String BannerUrl;
        private String Code;
        private int CouponNum;
        private String CreateDate;
        private String CurrencyName;
        private double CurrencyPrice;
        private boolean Disabled;
        private double Expenditure;
        private int HistoryIntegral;
        private String Id;
        private int InviteUserId;
        private String LastLoginDate;
        private int MemberGradeId;
        private String MemberGradeName;
        private int MemeberType;
        private String Nick;
        private int OrderNumber;
        private int ParentSellerId;
        private String Password;
        private String PasswordSalt;
        private String Photo;
        private int Points;
        private int RegionId;
        private boolean RelationState;
        private int ShoppingCartNum;
        private int TopRegionId;
        private String UserName;
        private List<List<?>> FavoriteInfo;

        public int getAvailableIntegrals() {
            return AvailableIntegrals;
        }

        public void setAvailableIntegrals(int AvailableIntegrals) {
            this.AvailableIntegrals = AvailableIntegrals;
        }

        public String getBannerUrl() {
            return BannerUrl;
        }

        public void setBannerUrl(String BannerUrl) {
            this.BannerUrl = BannerUrl;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String Code) {
            this.Code = Code;
        }

        public int getCouponNum() {
            return CouponNum;
        }

        public void setCouponNum(int CouponNum) {
            this.CouponNum = CouponNum;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getCurrencyName() {
            return CurrencyName;
        }

        public void setCurrencyName(String CurrencyName) {
            this.CurrencyName = CurrencyName;
        }

        public double getCurrencyPrice() {
            return CurrencyPrice;
        }

        public void setCurrencyPrice(double CurrencyPrice) {
            this.CurrencyPrice = CurrencyPrice;
        }

        public boolean isDisabled() {
            return Disabled;
        }

        public void setDisabled(boolean Disabled) {
            this.Disabled = Disabled;
        }

        public double getExpenditure() {
            return Expenditure;
        }

        public void setExpenditure(double Expenditure) {
            this.Expenditure = Expenditure;
        }

        public int getHistoryIntegral() {
            return HistoryIntegral;
        }

        public void setHistoryIntegral(int HistoryIntegral) {
            this.HistoryIntegral = HistoryIntegral;
        }

        public String  getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public int getInviteUserId() {
            return InviteUserId;
        }

        public void setInviteUserId(int InviteUserId) {
            this.InviteUserId = InviteUserId;
        }

        public String getLastLoginDate() {
            return LastLoginDate;
        }

        public void setLastLoginDate(String LastLoginDate) {
            this.LastLoginDate = LastLoginDate;
        }

        public int getMemberGradeId() {
            return MemberGradeId;
        }

        public void setMemberGradeId(int MemberGradeId) {
            this.MemberGradeId = MemberGradeId;
        }

        public String getMemberGradeName() {
            return MemberGradeName;
        }

        public void setMemberGradeName(String MemberGradeName) {
            this.MemberGradeName = MemberGradeName;
        }

        public int getMemeberType() {
            return MemeberType;
        }

        public void setMemeberType(int MemeberType) {
            this.MemeberType = MemeberType;
        }

        public String getNick() {
            return Nick;
        }

        public void setNick(String Nick) {
            this.Nick = Nick;
        }

        public int getOrderNumber() {
            return OrderNumber;
        }

        public void setOrderNumber(int OrderNumber) {
            this.OrderNumber = OrderNumber;
        }

        public int getParentSellerId() {
            return ParentSellerId;
        }

        public void setParentSellerId(int ParentSellerId) {
            this.ParentSellerId = ParentSellerId;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        public String getPasswordSalt() {
            return PasswordSalt;
        }

        public void setPasswordSalt(String PasswordSalt) {
            this.PasswordSalt = PasswordSalt;
        }

        public String getPhoto() {
            return Photo;
        }

        public void setPhoto(String Photo) {
            this.Photo = Photo;
        }

        public int getPoints() {
            return Points;
        }

        public void setPoints(int Points) {
            this.Points = Points;
        }

        public int getRegionId() {
            return RegionId;
        }

        public void setRegionId(int RegionId) {
            this.RegionId = RegionId;
        }

        public boolean isRelationState() {
            return RelationState;
        }

        public void setRelationState(boolean RelationState) {
            this.RelationState = RelationState;
        }

        public int getShoppingCartNum() {
            return ShoppingCartNum;
        }

        public void setShoppingCartNum(int ShoppingCartNum) {
            this.ShoppingCartNum = ShoppingCartNum;
        }

        public int getTopRegionId() {
            return TopRegionId;
        }

        public void setTopRegionId(int TopRegionId) {
            this.TopRegionId = TopRegionId;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public List<List<?>> getFavoriteInfo() {
            return FavoriteInfo;
        }

        public void setFavoriteInfo(List<List<?>> FavoriteInfo) {
            this.FavoriteInfo = FavoriteInfo;
        }
    }
}

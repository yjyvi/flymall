package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/1.
 */

public class GoodsEvaluateListBean {

    /**
     * type : 1
     * code : 0
     * message : 成功。
     * resultdata : [{"Evaluate_ID":"9560954E-F44E-4DE3-8AA7-9326097A5745","Evaluate_Star":3,"Evaluate_Content":"这是评论内容","Evaluate_Img":"","Order_ID":"","Goods_ID":"bd69ae37-02fe-41bc-bb85-337ec579e369","UserInfo_ID":"0001b39e-3d49-4e43-8f6e-9ec433f116a4","Dy_EvaluateItem":[]},{"Evaluate_ID":"70AB8CCB-5789-4D68-B327-44EA06CF25DA","Evaluate_Star":2,"Evaluate_Content":"这是评论内容","Evaluate_Img":"","Order_ID":"","Goods_ID":"bd69ae37-02fe-41bc-bb85-337ec579e369","UserInfo_ID":"0001b39e-3d49-4e43-8f6e-9ec433f116a4","Dy_EvaluateItem":[]}]
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

    public static class ResultdataBean {
        /**
         * Evaluate_ID : 9560954E-F44E-4DE3-8AA7-9326097A5745
         * Evaluate_Star : 3
         * Evaluate_Content : 这是评论内容
         * Evaluate_Img :
         * Order_ID :
         * Goods_ID : bd69ae37-02fe-41bc-bb85-337ec579e369
         * UserInfo_ID : 0001b39e-3d49-4e43-8f6e-9ec433f116a4
         * Dy_EvaluateItem : []
         */

        private String Evaluate_ID;
        private int Evaluate_Star;
        private String Evaluate_Content;
        private String Evaluate_Img;
        private String Order_ID;
        private String Goods_ID;
        private String UserInfo_ID;
        private String Evaluate_Time;
        private String UserInfo_NickName;
        private String GoodsPrice_AttrName;
        private List<EvaluateItem> Dy_EvaluateItem;

        public String getEvaluate_Time() {
            return Evaluate_Time;
        }

        public void setEvaluate_Time(String evaluate_Time) {
            Evaluate_Time = evaluate_Time;
        }

        public String getUserInfo_NickName() {
            return UserInfo_NickName;
        }

        public void setUserInfo_NickName(String userInfo_NickName) {
            UserInfo_NickName = userInfo_NickName;
        }

        public String getGoodsPrice_AttrName() {
            return GoodsPrice_AttrName;
        }

        public void setGoodsPrice_AttrName(String goodsPrice_AttrName) {
            GoodsPrice_AttrName = goodsPrice_AttrName;
        }

        public String getEvaluate_ID() {
            return Evaluate_ID;
        }

        public void setEvaluate_ID(String Evaluate_ID) {
            this.Evaluate_ID = Evaluate_ID;
        }

        public int getEvaluate_Star() {
            return Evaluate_Star;
        }

        public void setEvaluate_Star(int Evaluate_Star) {
            this.Evaluate_Star = Evaluate_Star;
        }

        public String getEvaluate_Content() {
            return Evaluate_Content;
        }

        public void setEvaluate_Content(String Evaluate_Content) {
            this.Evaluate_Content = Evaluate_Content;
        }

        public String getEvaluate_Img() {
            return Evaluate_Img;
        }

        public void setEvaluate_Img(String Evaluate_Img) {
            this.Evaluate_Img = Evaluate_Img;
        }

        public String getOrder_ID() {
            return Order_ID;
        }

        public void setOrder_ID(String Order_ID) {
            this.Order_ID = Order_ID;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getUserInfo_ID() {
            return UserInfo_ID;
        }

        public void setUserInfo_ID(String UserInfo_ID) {
            this.UserInfo_ID = UserInfo_ID;
        }

        public List<EvaluateItem> getDy_EvaluateItem() {
            return Dy_EvaluateItem;
        }

        public void setDy_EvaluateItem(List<EvaluateItem> Dy_EvaluateItem) {
            this.Dy_EvaluateItem = Dy_EvaluateItem;
        }

        public class EvaluateItem{

            /**
             * EvaluateItem_ID : 09AF918D-9167-474B-AEF0-76096D5437AD
             * Evaluate_ID : 48F50AE4-BE50-427E-A55A-1AD62DA60D6C
             * EvaluateItem_FileType : 1
             * EvaluateItem_Thumbnail : http://ppt.downhot.com/d/file/p/2014/07/24/afd8b2135086cc9f2787d114bd73005a.png
             * EvaluateItem_FileUrl : http://ppt.downhot.com/d/file/p/2014/07/24/afd8b2135086cc9f2787d114bd73005a.png
             */

            private String EvaluateItem_ID;
            private String Evaluate_ID;
            private int EvaluateItem_FileType;
            private String EvaluateItem_Thumbnail;
            private String EvaluateItem_FileUrl;

            public String getEvaluateItem_ID() {
                return EvaluateItem_ID;
            }

            public void setEvaluateItem_ID(String EvaluateItem_ID) {
                this.EvaluateItem_ID = EvaluateItem_ID;
            }

            public String getEvaluate_ID() {
                return Evaluate_ID;
            }

            public void setEvaluate_ID(String Evaluate_ID) {
                this.Evaluate_ID = Evaluate_ID;
            }

            public int getEvaluateItem_FileType() {
                return EvaluateItem_FileType;
            }

            public void setEvaluateItem_FileType(int EvaluateItem_FileType) {
                this.EvaluateItem_FileType = EvaluateItem_FileType;
            }

            public String getEvaluateItem_Thumbnail() {
                return EvaluateItem_Thumbnail;
            }

            public void setEvaluateItem_Thumbnail(String EvaluateItem_Thumbnail) {
                this.EvaluateItem_Thumbnail = EvaluateItem_Thumbnail;
            }

            public String getEvaluateItem_FileUrl() {
                return EvaluateItem_FileUrl;
            }

            public void setEvaluateItem_FileUrl(String EvaluateItem_FileUrl) {
                this.EvaluateItem_FileUrl = EvaluateItem_FileUrl;
            }
        }
    }
}

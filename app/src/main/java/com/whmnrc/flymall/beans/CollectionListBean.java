package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/4.
 */

public class CollectionListBean {


    /**
     * type : 1
     * code : 0
     * message : 获取成功
     * resultdata : [{"Id":"ba457d8e-42bc-43a2-b6bb-c276e1427891","UserInfo_ID":"fb80d7ea-5667-4185-b8b8-4089b96542d0","Goods_ID":"452acc8f-c33b-4762-bd05-536a61c3c493","CreateTime":"2018-05-30T12:07:19.253","Goods_ImaPath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164362&di=d71eaf72832ba1ec278ada176eebc579&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201510%2F12%2F20151012101939_QwRPC.thumb.700_0.jpeg","Goods_Name":"鞋子","SaveType":1},{"Id":"aaf4ed73-a6ad-449b-825b-4351badcd366","UserInfo_ID":"fb80d7ea-5667-4185-b8b8-4089b96542d0","Goods_ID":"bd69ae37-02fe-41bc-bb85-337ec579e369","CreateTime":"2018-06-04T09:45:38.883","Goods_ImaPath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164361&di=40dcc97ef80aa6de3c2fbe2c6a9690f4&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F19%2F68%2F13%2F69C58PICRfS_1024.jpg","Goods_Name":"这是商品名称","SaveType":1},{"Id":"0d40c1f8-da6f-4577-b28a-6ecb2b2152be","UserInfo_ID":"fb80d7ea-5667-4185-b8b8-4089b96542d0","Goods_ID":"1a4179e2-5555-46d0-aa62-0218369f211b","CreateTime":"2018-06-04T10:27:39.51","Goods_ImaPath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164363&di=5273719a0ec59feb189fdc864d79cfa6&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fback_pic%2Fqk%2Fback_origin_pic%2F00%2F03%2F14%2Fc0391a6c1efab3fe00911b04e8cedca4.jpg","Goods_Name":"裤子","SaveType":1}]
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
         * Id : ba457d8e-42bc-43a2-b6bb-c276e1427891
         * UserInfo_ID : fb80d7ea-5667-4185-b8b8-4089b96542d0
         * Goods_ID : 452acc8f-c33b-4762-bd05-536a61c3c493
         * CreateTime : 2018-05-30T12:07:19.253
         * Goods_ImaPath : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164362&di=d71eaf72832ba1ec278ada176eebc579&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201510%2F12%2F20151012101939_QwRPC.thumb.700_0.jpeg
         * Goods_Name : 鞋子
         * SaveType : 1
         */

        private String Id;
        private String UserInfo_ID;
        private String Goods_ID;
        private String CreateTime;
        private String Goods_ImaPath;
        private String Goods_Name;
        private int SaveType;
        private boolean isSelect;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getUserInfo_ID() {
            return UserInfo_ID;
        }

        public void setUserInfo_ID(String UserInfo_ID) {
            this.UserInfo_ID = UserInfo_ID;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public int getSaveType() {
            return SaveType;
        }

        public void setSaveType(int SaveType) {
            this.SaveType = SaveType;
        }
    }
}

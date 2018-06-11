package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class GoodsListBean {

    /**
     * type : 1
     * code : 0
     * message : 成功。
     * resultdata : [{"Goods_ID":"1a4179e2-5555-46d0-aa62-0218369f211b","Goods_Name":"裤子","Goods_BrandName":"16b7b91c-fd29-4c61-bea7-a9f85807914b","Goods_Describe":"这是裤子","Goods_ImaPath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164363&di=5273719a0ec59feb189fdc864d79cfa6&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fback_pic%2Fqk%2Fback_origin_pic%2F00%2F03%2F14%2Fc0391a6c1efab3fe00911b04e8cedca4.jpg","Goods_Content":"<p>asdasdasdzxc全是但千万饿<\/p>","Goods_LookCount":6,"Goods_MonthCount":0,"Goods_Sort":99,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":0,"Goods_ClassificationName":"e2be8625-a19f-42f7-919b-de839912e99c","Goods_Thumbnail":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164361&di=5a89168168e66ea89bd6ef7736de784b&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F8ad4b31c8701a18bc296e2d2942f07082838fe2a.jpg","Goods_SourcePrice":null,"Goods_IsHomePage":false},{"Goods_ID":"09caef3d-f78d-4327-aa19-482736e96d1e","Goods_Name":"测试图片是否把缩略图保存到数据库","Goods_BrandName":"57c474bf-9bec-4ee8-94a3-e6366e2de693","Goods_Describe":"商品描述","Goods_ImaPath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164363&di=9872f93ecbeeceee8a4df9def3aeee1b&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa9d3fd1f4134970a8c52cb029ecad1c8a7865dfe.jpg","Goods_Content":"<p>测试图片是否把缩略图保存到数据库<\/p>","Goods_LookCount":0,"Goods_MonthCount":0,"Goods_Sort":99,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":0,"Goods_ClassificationName":"5c01c34a-de78-4829-b36b-8b491b989ca1","Goods_Thumbnail":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164361&di=c31b66e29862b57609d175f815d26b0b&imgtype=0&src=http%3A%2F%2Fp1.gexing.com%2FG1%2FM00%2F74%2FAB%2FrBACE1TMShKRNFi0AABLxExWQuo905.jpg","Goods_SourcePrice":null,"Goods_IsHomePage":true},{"Goods_ID":"bd69ae37-02fe-41bc-bb85-337ec579e369","Goods_Name":"这是商品名称","Goods_BrandName":"2b35ab06-6052-4134-be73-63d96e1c12f3","Goods_Describe":"这是商品描述","Goods_ImaPath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164361&di=40dcc97ef80aa6de3c2fbe2c6a9690f4&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F19%2F68%2F13%2F69C58PICRfS_1024.jpg","Goods_Content":"<p>这是商品详情<\/p>","Goods_LookCount":0,"Goods_MonthCount":0,"Goods_Sort":99,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":0,"Goods_ClassificationName":"fdf09e7b-6719-4113-a2b8-39306bedc3f5","Goods_Thumbnail":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164360&di=49ef089dcf06b2606fa803a258773b4a&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fwallpaper%2F1207%2F12%2Fc0%2F12307776_1342056969110.jpg","Goods_SourcePrice":null,"Goods_IsHomePage":false},{"Goods_ID":"c10f977b-f95e-4dbb-a2ae-b37e300da2cd","Goods_Name":"衣服","Goods_BrandName":"011e594b-e398-4b32-865a-db91360958c6","Goods_Describe":"这是衣服","Goods_ImaPath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164361&di=89b1d5a619cdd130e46de4a7c6988c85&imgtype=0&src=http%3A%2F%2Fimg02.tooopen.com%2Fimages%2F20160429%2Ftooopen_sy_161043959628.jpg","Goods_Content":"<p>驱蚊器翁<\/p>","Goods_LookCount":11,"Goods_MonthCount":12,"Goods_Sort":99,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":0,"Goods_ClassificationName":"5c01c34a-de78-4829-b36b-8b491b989ca1","Goods_Thumbnail":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164359&di=6f14d292b5c49c7ea4151a83a69ab2ce&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F8b82b9014a90f6038eed546a3212b31bb051edbb.jpg","Goods_SourcePrice":null,"Goods_IsHomePage":true}]
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
         * Goods_ID : 1a4179e2-5555-46d0-aa62-0218369f211b
         * Goods_Name : 裤子
         * Goods_BrandName : 16b7b91c-fd29-4c61-bea7-a9f85807914b
         * Goods_Describe : 这是裤子
         * Goods_ImaPath : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164363&di=5273719a0ec59feb189fdc864d79cfa6&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fback_pic%2Fqk%2Fback_origin_pic%2F00%2F03%2F14%2Fc0391a6c1efab3fe00911b04e8cedca4.jpg
         * Goods_Content : <p>asdasdasdzxc全是但千万饿</p>
         * Goods_LookCount : 6
         * Goods_MonthCount : 0
         * Goods_Sort : 99
         * Goods_IsOn : true
         * Goods_IsBuy : true
         * Goods_Type : 0
         * Goods_ClassificationName : e2be8625-a19f-42f7-919b-de839912e99c
         * Goods_Thumbnail : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164361&di=5a89168168e66ea89bd6ef7736de784b&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F8ad4b31c8701a18bc296e2d2942f07082838fe2a.jpg
         * Goods_SourcePrice : null
         * Goods_IsHomePage : false
         */

        private String Goods_ID;
        private String Goods_Name;
        private String Goods_BrandName;
        private String Goods_Describe;
        private String Goods_ImaPath;
        private String Goods_Content;
        private int Goods_LookCount;
        private int Goods_MonthCount;
        private int Goods_Sort;
        private boolean Goods_IsOn;
        private boolean Goods_IsBuy;
        private int Goods_Type;
        private String Goods_ClassificationName;
        private String Goods_Thumbnail;
        private double GoodsPrice_Price;
        private double Goods_SourcePrice;
        private boolean Goods_IsHomePage;

        public double getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(double goodsPrice_Price) {
            GoodsPrice_Price = goodsPrice_Price;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoods_BrandName() {
            return Goods_BrandName;
        }

        public void setGoods_BrandName(String Goods_BrandName) {
            this.Goods_BrandName = Goods_BrandName;
        }

        public String getGoods_Describe() {
            return Goods_Describe;
        }

        public void setGoods_Describe(String Goods_Describe) {
            this.Goods_Describe = Goods_Describe;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public String getGoods_Content() {
            return Goods_Content;
        }

        public void setGoods_Content(String Goods_Content) {
            this.Goods_Content = Goods_Content;
        }

        public int getGoods_LookCount() {
            return Goods_LookCount;
        }

        public void setGoods_LookCount(int Goods_LookCount) {
            this.Goods_LookCount = Goods_LookCount;
        }

        public int getGoods_MonthCount() {
            return Goods_MonthCount;
        }

        public void setGoods_MonthCount(int Goods_MonthCount) {
            this.Goods_MonthCount = Goods_MonthCount;
        }

        public int getGoods_Sort() {
            return Goods_Sort;
        }

        public void setGoods_Sort(int Goods_Sort) {
            this.Goods_Sort = Goods_Sort;
        }

        public boolean isGoods_IsOn() {
            return Goods_IsOn;
        }

        public void setGoods_IsOn(boolean Goods_IsOn) {
            this.Goods_IsOn = Goods_IsOn;
        }

        public boolean isGoods_IsBuy() {
            return Goods_IsBuy;
        }

        public void setGoods_IsBuy(boolean Goods_IsBuy) {
            this.Goods_IsBuy = Goods_IsBuy;
        }

        public int getGoods_Type() {
            return Goods_Type;
        }

        public void setGoods_Type(int Goods_Type) {
            this.Goods_Type = Goods_Type;
        }

        public String getGoods_ClassificationName() {
            return Goods_ClassificationName;
        }

        public void setGoods_ClassificationName(String Goods_ClassificationName) {
            this.Goods_ClassificationName = Goods_ClassificationName;
        }

        public String getGoods_Thumbnail() {
            return Goods_Thumbnail;
        }

        public void setGoods_Thumbnail(String Goods_Thumbnail) {
            this.Goods_Thumbnail = Goods_Thumbnail;
        }

        public double getGoods_SourcePrice() {
            return Goods_SourcePrice;
        }

        public void setGoods_SourcePrice(double Goods_SourcePrice) {
            this.Goods_SourcePrice = Goods_SourcePrice;
        }

        public boolean isGoods_IsHomePage() {
            return Goods_IsHomePage;
        }

        public void setGoods_IsHomePage(boolean Goods_IsHomePage) {
            this.Goods_IsHomePage = Goods_IsHomePage;
        }
    }
}

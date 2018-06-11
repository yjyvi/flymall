package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/29.
 */

public class HomeBrandBean {


    /**
     * type : 1
     * code : 0
     * message : 成功
     * resultdata : [[{"Brand_ID":"16b7b91c-fd29-4c61-bea7-a9f85807914b","Brand_Classification":"e2be8625-a19f-42f7-919b-de839912e99c","Brand_ClassificationName":"裤子","Brand_Name":"361°","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164358&di=ebc84f6f2776ff824df5b2509ff5e2c9&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201507%2F29%2F20150729231750_fktXS.jpeg","Brand_IsHomePage":true},{"Brand_ID":"8f965f0a-3d73-4ca5-bc18-a4c16f54a68e","Brand_Classification":"5c01c34a-de78-4829-b36b-8b491b989ca1","Brand_ClassificationName":"衣服","Brand_Name":"361°","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164394&di=385393da2291f03329724ec5f7679f18&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201509%2F16%2F20150916094701_VLCj2.jpeg","Brand_IsHomePage":true}],[{"Brand_ID":"de8672ec-5ee4-4601-bdd8-d52e16f9cb27","Brand_Classification":"e2be8625-a19f-42f7-919b-de839912e99c","Brand_ClassificationName":"裤子","Brand_Name":"address","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164393&di=66876c49259969d54634128248d727b6&imgtype=0&src=http%3A%2F%2Fimgwww.heiguang.net%2Fuploadfile%2F2017%2F0516%2F20170516115641106.jpg","Brand_IsHomePage":true}],[{"Brand_ID":"e1e139a5-734e-447f-a91e-e06036b7f64c","Brand_Classification":"5c01c34a-de78-4829-b36b-8b491b989ca1","Brand_ClassificationName":"衣服","Brand_Name":"H&M","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164393&di=3d1f525017b0b2f3b9e45323f9116a09&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201506%2F29%2F20150629090618_uzZcB.jpeg","Brand_IsHomePage":true}],[{"Brand_ID":"ea7e5d3f-dbfb-439d-b65c-f48bc682ae30","Brand_Classification":"5c01c34a-de78-4829-b36b-8b491b989ca1","Brand_ClassificationName":"衣服","Brand_Name":"阿尼玛","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164392&di=a7cfbd96f1391561b908cc6459cc5d8e&imgtype=0&src=http%3A%2F%2Fimgwww.heiguang.net%2Fuploadfile%2F2016%2F0407%2F20160407110908621.jpg","Brand_IsHomePage":true}],[{"Brand_ID":"2b35ab06-6052-4134-be73-63d96e1c12f3","Brand_Classification":"fdf09e7b-6719-4113-a2b8-39306bedc3f5","Brand_ClassificationName":"鞋子","Brand_Name":"安踏","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164357&di=723cfa0904932996e8a5d645d74ff9d4&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201409%2F19%2F20140919141717_awx8H.jpeg","Brand_IsHomePage":true}],[{"Brand_ID":"ea2994a2-2a90-4427-a339-0164e16f1a9c","Brand_Classification":"e2be8625-a19f-42f7-919b-de839912e99c","Brand_ClassificationName":"裤子","Brand_Name":"长裤","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164392&di=0bc78fd3e01bab045f816d0a7c568fe8&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F07%2F20140707231849_EMPaH.jpeg","Brand_IsHomePage":true}],[{"Brand_ID":"cd21e8f7-87b7-44d0-a614-6038b9efe24e","Brand_Classification":"5c01c34a-de78-4829-b36b-8b491b989ca1","Brand_ClassificationName":"衣服","Brand_Name":"长袖","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527598068373&di=659ba711cb419fe60ae11413241f4aaa&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D3328949232%2C4127194214%26fm%3D214%26gp%3D0.jpg","Brand_IsHomePage":true}],[{"Brand_ID":"108841a6-e6db-49df-b5b2-f5d129900f78","Brand_Classification":"e2be8625-a19f-42f7-919b-de839912e99c","Brand_ClassificationName":"裤子","Brand_Name":"短裤","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164358&di=e0cddc8df9c284825c64a9083f9c02d5&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fdcc451da81cb39db6749ac7bdb160924ab183016.jpg","Brand_IsHomePage":true}],[{"Brand_ID":"1d70995e-0a14-4805-beeb-5d5473b2e3d9","Brand_Classification":"5c01c34a-de78-4829-b36b-8b491b989ca1","Brand_ClassificationName":"衣服","Brand_Name":"短袖","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164358&di=0d032a9d4ebb04628e900029b3aec5c9&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ff7246b600c33874452749da85b0fd9f9d62aa0b5.jpg","Brand_IsHomePage":true}],[{"Brand_ID":"9477b2de-31ee-41d2-bbfd-8016baf8e83f","Brand_Classification":"5c01c34a-de78-4829-b36b-8b491b989ca1","Brand_ClassificationName":"衣服","Brand_Name":"海澜之家","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164394&di=7cd02689de4554812fcbb7234a186592&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01599b5548e27d0000019ae97f8cfd.jpg%401280w_1l_2o_100sh.jpg","Brand_IsHomePage":true}],[{"Brand_ID":"7819bf84-20c4-4347-b91e-d275f92dcc4c","Brand_Classification":"5c01c34a-de78-4829-b36b-8b491b989ca1","Brand_ClassificationName":"衣服","Brand_Name":"情侣装","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164394&di=96ece854beef9035e8845ba8530d03d5&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201510%2F16%2F20151016000647_8GM4J.thumb.700_0.jpeg","Brand_IsHomePage":true}],[{"Brand_ID":"61029705-1ea3-4435-8af2-90dd3fa59b4c","Brand_Classification":"e2be8625-a19f-42f7-919b-de839912e99c","Brand_ClassificationName":"裤子","Brand_Name":"裙子","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164394&di=053ecb6d8593a7709b7806339f7ed1a2&imgtype=0&src=http%3A%2F%2Fp4.gexing.com%2FG1%2FM00%2F74%2FAB%2FrBACE1TMShLCLqthAAChpD5_McA447.jpg","Brand_IsHomePage":true}],[{"Brand_ID":"8beb1d23-42dc-4402-b788-07694cb09b22","Brand_Classification":null,"Brand_ClassificationName":"裙子","Brand_Name":"以纯","Brand_Img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164394&di=4ea5faf2bb9a25ac7276ce2855f0a884&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201411%2F22%2F20141122112012_mXZ2R.jpeg","Brand_IsHomePage":true}]]
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

    public static class ResultdataBean  {
        /**
         * Brand_ID : 16b7b91c-fd29-4c61-bea7-a9f85807914b
         * Brand_Classification : e2be8625-a19f-42f7-919b-de839912e99c
         * Brand_ClassificationName : 裤子
         * Brand_Name : 361°
         * Brand_Img : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527597164358&di=ebc84f6f2776ff824df5b2509ff5e2c9&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201507%2F29%2F20150729231750_fktXS.jpeg
         * Brand_IsHomePage : true
         */

        private String Brand_ID;
        private String Brand_Classification;
        private String Brand_ClassificationName;
        private String Brand_Name;
        private String Brand_Img;
        private boolean Brand_IsHomePage;





        public String getBrand_ID() {
            return Brand_ID;
        }

        public void setBrand_ID(String Brand_ID) {
            this.Brand_ID = Brand_ID;
        }

        public String getBrand_Classification() {
            return Brand_Classification;
        }

        public void setBrand_Classification(String Brand_Classification) {
            this.Brand_Classification = Brand_Classification;
        }

        public String getBrand_ClassificationName() {
            return Brand_ClassificationName;
        }

        public void setBrand_ClassificationName(String Brand_ClassificationName) {
            this.Brand_ClassificationName = Brand_ClassificationName;
        }

        public String getBrand_Name() {
            return Brand_Name;
        }

        public void setBrand_Name(String Brand_Name) {
            this.Brand_Name = Brand_Name;
        }

        public String getBrand_Img() {
            return Brand_Img;
        }

        public void setBrand_Img(String Brand_Img) {
            this.Brand_Img = Brand_Img;
        }

        public boolean isBrand_IsHomePage() {
            return Brand_IsHomePage;
        }

        public void setBrand_IsHomePage(boolean Brand_IsHomePage) {
            this.Brand_IsHomePage = Brand_IsHomePage;
        }


    }
}

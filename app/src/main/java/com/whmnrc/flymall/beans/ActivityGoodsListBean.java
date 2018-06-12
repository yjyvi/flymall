package com.whmnrc.flymall.beans;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/6/11.
 */

public class ActivityGoodsListBean {


    /**
     * type : 1
     * code : 0
     * message : 请求成功
     * resultdata : {"TopicModuleInfo":[{"ModuleProductInfo":[{"ProductInfo":{"AddedDate":"2018-04-26 02:21:37","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1493,"ImagePath":"/Storage/Shop/266/Products/1493","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 菊花茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":1,"Id":535,"ModuleId":190,"ProductId":1493},{"ProductInfo":{"AddedDate":"2018-04-26 02:27:21","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1494,"ImagePath":"/Storage/Shop/266/Products/1494","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 莲子茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":2,"Id":536,"ModuleId":190,"ProductId":1494},{"ProductInfo":{"AddedDate":"2018-04-26 02:32:10","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1495,"ImagePath":"/Storage/Shop/266/Products/1495","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 木瓜茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":3,"Id":537,"ModuleId":190,"ProductId":1495},{"ProductInfo":{"AddedDate":"2018-04-26 02:40:22","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1496,"ImagePath":"/Storage/Shop/266/Products/1496","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 蒲公英茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":4,"Id":538,"ModuleId":190,"ProductId":1496},{"ProductInfo":{"AddedDate":"2018-04-26 02:53:22","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1497,"ImagePath":"/Storage/Shop/266/Products/1497","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":" 林老头 桑叶茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":5,"Id":539,"ModuleId":190,"ProductId":1497},{"ProductInfo":{"AddedDate":"2018-04-26 02:59:12","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1498,"ImagePath":"/Storage/Shop/266/Products/1498","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 山药茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":6,"Id":540,"ModuleId":190,"ProductId":1498},{"ProductInfo":{"AddedDate":"2018-04-26 03:22:04","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1499,"ImagePath":"/Storage/Shop/266/Products/1499","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 酸枣仁茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":7,"Id":541,"ModuleId":190,"ProductId":1499}],"Id":190,"Name":"????1","TopicId":43}],"Himall_MobileHomeTopics":[],"BackgroundImage":"","frontCoverImage":"","FrontCoverImage":"","Id":43,"IsRecommend":false,"Name":"实惠好货","PlatForm":99,"SelfDefineText":null,"ShopId":0,"Tags":"实惠好货","TopImage":"/Storage/Plat/Topic/43/201806081347430391620.jpg"}
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

    public static class ResultdataBean {
        /**
         * TopicModuleInfo : [{"ModuleProductInfo":[{"ProductInfo":{"AddedDate":"2018-04-26 02:21:37","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1493,"ImagePath":"/Storage/Shop/266/Products/1493","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 菊花茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":1,"Id":535,"ModuleId":190,"ProductId":1493},{"ProductInfo":{"AddedDate":"2018-04-26 02:27:21","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1494,"ImagePath":"/Storage/Shop/266/Products/1494","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 莲子茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":2,"Id":536,"ModuleId":190,"ProductId":1494},{"ProductInfo":{"AddedDate":"2018-04-26 02:32:10","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1495,"ImagePath":"/Storage/Shop/266/Products/1495","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 木瓜茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":3,"Id":537,"ModuleId":190,"ProductId":1495},{"ProductInfo":{"AddedDate":"2018-04-26 02:40:22","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1496,"ImagePath":"/Storage/Shop/266/Products/1496","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 蒲公英茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":4,"Id":538,"ModuleId":190,"ProductId":1496},{"ProductInfo":{"AddedDate":"2018-04-26 02:53:22","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1497,"ImagePath":"/Storage/Shop/266/Products/1497","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":" 林老头 桑叶茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":5,"Id":539,"ModuleId":190,"ProductId":1497},{"ProductInfo":{"AddedDate":"2018-04-26 02:59:12","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1498,"ImagePath":"/Storage/Shop/266/Products/1498","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 山药茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":6,"Id":540,"ModuleId":190,"ProductId":1498},{"ProductInfo":{"AddedDate":"2018-04-26 03:22:04","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1499,"ImagePath":"/Storage/Shop/266/Products/1499","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 酸枣仁茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":7,"Id":541,"ModuleId":190,"ProductId":1499}],"Id":190,"Name":"????1","TopicId":43}]
         * Himall_MobileHomeTopics : []
         * BackgroundImage :
         * frontCoverImage :
         * FrontCoverImage :
         * Id : 43
         * IsRecommend : false
         * Name : 实惠好货
         * PlatForm : 99
         * SelfDefineText : null
         * ShopId : 0
         * Tags : 实惠好货
         * TopImage : /Storage/Plat/Topic/43/201806081347430391620.jpg
         */

        private String BackgroundImage;
        private String frontCoverImage;
        private String FrontCoverImage;
        private int Id;
        private boolean IsRecommend;
        private String Name;
        private int PlatForm;
        private Object SelfDefineText;
        private int ShopId;
        private String Tags;
        private String TopImage;
        private List<TopicModuleInfoBean> TopicModuleInfo;
        private List<?> Himall_MobileHomeTopics;

        public String getBackgroundImage() {
            return BackgroundImage;
        }

        public void setBackgroundImage(String BackgroundImage) {
            this.BackgroundImage = BackgroundImage;
        }

        public void setFrontCoverImage(String frontCoverImage) {
            this.frontCoverImage = frontCoverImage;
        }

        public String getFrontCoverImage() {
            return FrontCoverImage;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public boolean isIsRecommend() {
            return IsRecommend;
        }

        public void setIsRecommend(boolean IsRecommend) {
            this.IsRecommend = IsRecommend;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getPlatForm() {
            return PlatForm;
        }

        public void setPlatForm(int PlatForm) {
            this.PlatForm = PlatForm;
        }

        public Object getSelfDefineText() {
            return SelfDefineText;
        }

        public void setSelfDefineText(Object SelfDefineText) {
            this.SelfDefineText = SelfDefineText;
        }

        public int getShopId() {
            return ShopId;
        }

        public void setShopId(int ShopId) {
            this.ShopId = ShopId;
        }

        public String getTags() {
            return Tags;
        }

        public void setTags(String Tags) {
            this.Tags = Tags;
        }

        public String getTopImage() {
            return TopImage;
        }

        public void setTopImage(String TopImage) {
            this.TopImage = TopImage;
        }

        public List<TopicModuleInfoBean> getTopicModuleInfo() {
            return TopicModuleInfo;
        }

        public void setTopicModuleInfo(List<TopicModuleInfoBean> TopicModuleInfo) {
            this.TopicModuleInfo = TopicModuleInfo;
        }

        public List<?> getHimall_MobileHomeTopics() {
            return Himall_MobileHomeTopics;
        }

        public void setHimall_MobileHomeTopics(List<?> Himall_MobileHomeTopics) {
            this.Himall_MobileHomeTopics = Himall_MobileHomeTopics;
        }

        public static class TopicModuleInfoBean {
            /**
             * ModuleProductInfo : [{"ProductInfo":{"AddedDate":"2018-04-26 02:21:37","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1493,"ImagePath":"/Storage/Shop/266/Products/1493","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 菊花茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":1,"Id":535,"ModuleId":190,"ProductId":1493},{"ProductInfo":{"AddedDate":"2018-04-26 02:27:21","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1494,"ImagePath":"/Storage/Shop/266/Products/1494","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 莲子茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":2,"Id":536,"ModuleId":190,"ProductId":1494},{"ProductInfo":{"AddedDate":"2018-04-26 02:32:10","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1495,"ImagePath":"/Storage/Shop/266/Products/1495","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 木瓜茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":3,"Id":537,"ModuleId":190,"ProductId":1495},{"ProductInfo":{"AddedDate":"2018-04-26 02:40:22","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1496,"ImagePath":"/Storage/Shop/266/Products/1496","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 蒲公英茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":4,"Id":538,"ModuleId":190,"ProductId":1496},{"ProductInfo":{"AddedDate":"2018-04-26 02:53:22","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1497,"ImagePath":"/Storage/Shop/266/Products/1497","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":" 林老头 桑叶茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":5,"Id":539,"ModuleId":190,"ProductId":1497},{"ProductInfo":{"AddedDate":"2018-04-26 02:59:12","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1498,"ImagePath":"/Storage/Shop/266/Products/1498","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 山药茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":6,"Id":540,"ModuleId":190,"ProductId":1498},{"ProductInfo":{"AddedDate":"2018-04-26 03:22:04","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1499,"ImagePath":"/Storage/Shop/266/Products/1499","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 酸枣仁茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0},"DisplaySequence":7,"Id":541,"ModuleId":190,"ProductId":1499}]
             * Id : 190
             * Name : ????1
             * TopicId : 43
             */

            private int Id;
            private String Name;
            private int TopicId;
            private List<ModuleProductInfoBean> ModuleProductInfo;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public int getTopicId() {
                return TopicId;
            }

            public void setTopicId(int TopicId) {
                this.TopicId = TopicId;
            }

            public List<ModuleProductInfoBean> getModuleProductInfo() {
                return ModuleProductInfo;
            }

            public void setModuleProductInfo(List<ModuleProductInfoBean> ModuleProductInfo) {
                this.ModuleProductInfo = ModuleProductInfo;
            }

            public static class ModuleProductInfoBean {
                /**
                 * ProductInfo : {"AddedDate":"2018-04-26 02:21:37","Address":null,"AuditStatus":2,"BrandId":0,"BrandName":null,"CategoryId":177,"CategoryPath":"150|165|177","ConcernedCount":0,"DisplaySequence":1,"EditStatus":0,"FreightTemplateId":129,"HasSKU":true,"Id":1493,"ImagePath":"/Storage/Shop/266/Products/1493","MarketPrice":2400,"MeasureUnit":"提","MinSalePrice":2400,"ProductCode":"","ProductName":"林老头 菊花茶 四盒装 每盒（6克/袋*30）","Quantity":1000,"SaleCounts":0,"SaleStatus":1,"ShopId":266,"ShortDescription":"","TypeId":41,"VistiCounts":0,"Volume":0,"Weight":0}
                 * DisplaySequence : 1
                 * Id : 535
                 * ModuleId : 190
                 * ProductId : 1493
                 */

                private ProductInfoBean ProductInfo;
                private int DisplaySequence;
                private int Id;
                private int ModuleId;
                private int ProductId;

                public ProductInfoBean getProductInfo() {
                    return ProductInfo;
                }

                public void setProductInfo(ProductInfoBean ProductInfo) {
                    this.ProductInfo = ProductInfo;
                }

                public int getDisplaySequence() {
                    return DisplaySequence;
                }

                public void setDisplaySequence(int DisplaySequence) {
                    this.DisplaySequence = DisplaySequence;
                }

                public int getId() {
                    return Id;
                }

                public void setId(int Id) {
                    this.Id = Id;
                }

                public int getModuleId() {
                    return ModuleId;
                }

                public void setModuleId(int ModuleId) {
                    this.ModuleId = ModuleId;
                }

                public int getProductId() {
                    return ProductId;
                }

                public void setProductId(int ProductId) {
                    this.ProductId = ProductId;
                }

                public static class ProductInfoBean {
                    /**
                     * AddedDate : 2018-04-26 02:21:37
                     * Address : null
                     * AuditStatus : 2
                     * BrandId : 0
                     * BrandName : null
                     * CategoryId : 177
                     * CategoryPath : 150|165|177
                     * ConcernedCount : 0
                     * DisplaySequence : 1
                     * EditStatus : 0
                     * FreightTemplateId : 129
                     * HasSKU : true
                     * Id : 1493
                     * ImagePath : /Storage/Shop/266/Products/1493
                     * MarketPrice : 2400
                     * MeasureUnit : 提
                     * MinSalePrice : 2400
                     * ProductCode :
                     * ProductName : 林老头 菊花茶 四盒装 每盒（6克/袋*30）
                     * Quantity : 1000
                     * SaleCounts : 0
                     * SaleStatus : 1
                     * ShopId : 266
                     * ShortDescription :
                     * TypeId : 41
                     * VistiCounts : 0
                     * Volume : 0
                     * Weight : 0
                     */

                    private String AddedDate;
                    private Object Address;
                    private int AuditStatus;
                    private int BrandId;
                    private Object BrandName;
                    private int CategoryId;
                    private String CategoryPath;
                    private int ConcernedCount;
                    private int DisplaySequence;
                    private int EditStatus;
                    private int FreightTemplateId;
                    private boolean HasSKU;
                    private int Id;
                    private String ImagePath;
                    private int MarketPrice;
                    private String MeasureUnit;
                    private int MinSalePrice;
                    private String ProductCode;
                    private String ProductName;
                    private int Quantity;
                    private int SaleCounts;
                    private int SaleStatus;
                    private int ShopId;
                    private String ShortDescription;
                    private int TypeId;
                    private int VistiCounts;
                    private int Volume;
                    private int Weight;

                    public String getAddedDate() {
                        return AddedDate;
                    }

                    public void setAddedDate(String AddedDate) {
                        this.AddedDate = AddedDate;
                    }

                    public Object getAddress() {
                        return Address;
                    }

                    public void setAddress(Object Address) {
                        this.Address = Address;
                    }

                    public int getAuditStatus() {
                        return AuditStatus;
                    }

                    public void setAuditStatus(int AuditStatus) {
                        this.AuditStatus = AuditStatus;
                    }

                    public int getBrandId() {
                        return BrandId;
                    }

                    public void setBrandId(int BrandId) {
                        this.BrandId = BrandId;
                    }

                    public Object getBrandName() {
                        return BrandName;
                    }

                    public void setBrandName(Object BrandName) {
                        this.BrandName = BrandName;
                    }

                    public int getCategoryId() {
                        return CategoryId;
                    }

                    public void setCategoryId(int CategoryId) {
                        this.CategoryId = CategoryId;
                    }

                    public String getCategoryPath() {
                        return CategoryPath;
                    }

                    public void setCategoryPath(String CategoryPath) {
                        this.CategoryPath = CategoryPath;
                    }

                    public int getConcernedCount() {
                        return ConcernedCount;
                    }

                    public void setConcernedCount(int ConcernedCount) {
                        this.ConcernedCount = ConcernedCount;
                    }

                    public int getDisplaySequence() {
                        return DisplaySequence;
                    }

                    public void setDisplaySequence(int DisplaySequence) {
                        this.DisplaySequence = DisplaySequence;
                    }

                    public int getEditStatus() {
                        return EditStatus;
                    }

                    public void setEditStatus(int EditStatus) {
                        this.EditStatus = EditStatus;
                    }

                    public int getFreightTemplateId() {
                        return FreightTemplateId;
                    }

                    public void setFreightTemplateId(int FreightTemplateId) {
                        this.FreightTemplateId = FreightTemplateId;
                    }

                    public boolean isHasSKU() {
                        return HasSKU;
                    }

                    public void setHasSKU(boolean HasSKU) {
                        this.HasSKU = HasSKU;
                    }

                    public int getId() {
                        return Id;
                    }

                    public void setId(int Id) {
                        this.Id = Id;
                    }

                    public String getImagePath() {
                        return ImagePath;
                    }

                    public void setImagePath(String ImagePath) {
                        this.ImagePath = ImagePath;
                    }

                    public int getMarketPrice() {
                        return MarketPrice;
                    }

                    public void setMarketPrice(int MarketPrice) {
                        this.MarketPrice = MarketPrice;
                    }

                    public String getMeasureUnit() {
                        return MeasureUnit;
                    }

                    public void setMeasureUnit(String MeasureUnit) {
                        this.MeasureUnit = MeasureUnit;
                    }

                    public int getMinSalePrice() {
                        return MinSalePrice;
                    }

                    public void setMinSalePrice(int MinSalePrice) {
                        this.MinSalePrice = MinSalePrice;
                    }

                    public String getProductCode() {
                        return ProductCode;
                    }

                    public void setProductCode(String ProductCode) {
                        this.ProductCode = ProductCode;
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

                    public int getSaleCounts() {
                        return SaleCounts;
                    }

                    public void setSaleCounts(int SaleCounts) {
                        this.SaleCounts = SaleCounts;
                    }

                    public int getSaleStatus() {
                        return SaleStatus;
                    }

                    public void setSaleStatus(int SaleStatus) {
                        this.SaleStatus = SaleStatus;
                    }

                    public int getShopId() {
                        return ShopId;
                    }

                    public void setShopId(int ShopId) {
                        this.ShopId = ShopId;
                    }

                    public String getShortDescription() {
                        return ShortDescription;
                    }

                    public void setShortDescription(String ShortDescription) {
                        this.ShortDescription = ShortDescription;
                    }

                    public int getTypeId() {
                        return TypeId;
                    }

                    public void setTypeId(int TypeId) {
                        this.TypeId = TypeId;
                    }

                    public int getVistiCounts() {
                        return VistiCounts;
                    }

                    public void setVistiCounts(int VistiCounts) {
                        this.VistiCounts = VistiCounts;
                    }

                    public int getVolume() {
                        return Volume;
                    }

                    public void setVolume(int Volume) {
                        this.Volume = Volume;
                    }

                    public int getWeight() {
                        return Weight;
                    }

                    public void setWeight(int Weight) {
                        this.Weight = Weight;
                    }
                }
            }
        }
    }
}

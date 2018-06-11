package com.whmnrc.flymall.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/30.
 */

public class OneBrandsBean {


    /**
     * code : 0
     * message : 请求成功
     * resultdata : [{"Depth":0,"DisplaySequence":1,"Id":9,"Image":"/Areas/Mobile/Templates/Default/Content/index/shop_btn.png","Name":"数字商品","SubCategories":[{"Depth":1,"DisplaySequence":1,"Id":10,"Image":"","Name":"数字音乐","SubCategories":[{"Depth":1,"DisplaySequence":1,"Id":48,"Image":"/Storage/Plat/Category/201709281335310821880.png","Name":"流行音乐","SubCategories":[]},{"Depth":1,"DisplaySequence":2,"Id":49,"Image":"/Storage/Plat/Category/201709281335440699310.png","Name":"爵士蓝调","SubCategories":[]},{"Depth":1,"DisplaySequence":3,"Id":85,"Image":"/Storage/Plat/Category/201709281335193195160.png","Name":"世界音乐","SubCategories":[]}]}]}]
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
         * Depth : 0
         * DisplaySequence : 1
         * Id : 9
         * Image : /Areas/Mobile/Templates/Default/Content/index/shop_btn.png
         * Name : 数字商品
         * SubCategories : [{"Depth":1,"DisplaySequence":1,"Id":10,"Image":"","Name":"数字音乐","SubCategories":[{"Depth":1,"DisplaySequence":1,"Id":48,"Image":"/Storage/Plat/Category/201709281335310821880.png","Name":"流行音乐","SubCategories":[]},{"Depth":1,"DisplaySequence":2,"Id":49,"Image":"/Storage/Plat/Category/201709281335440699310.png","Name":"爵士蓝调","SubCategories":[]},{"Depth":1,"DisplaySequence":3,"Id":85,"Image":"/Storage/Plat/Category/201709281335193195160.png","Name":"世界音乐","SubCategories":[]}]}]
         */

        private int Depth;
        private int DisplaySequence;
        private int Id;
        private String Image;
        private String Name;
        private List<SubCategoriesBeanX> SubCategories;

        protected ResultdataBean(Parcel in) {
            Depth = in.readInt();
            DisplaySequence = in.readInt();
            Id = in.readInt();
            Image = in.readString();
            Name = in.readString();
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

        public int getDepth() {
            return Depth;
        }

        public void setDepth(int Depth) {
            this.Depth = Depth;
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

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public List<SubCategoriesBeanX> getSubCategories() {
            return SubCategories;
        }

        public void setSubCategories(List<SubCategoriesBeanX> SubCategories) {
            this.SubCategories = SubCategories;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(Depth);
            dest.writeInt(DisplaySequence);
            dest.writeInt(Id);
            dest.writeString(Image);
            dest.writeString(Name);
        }

        public static class SubCategoriesBeanX implements Parcelable{
            public SubCategoriesBeanX() {
            }

            /**
             * Depth : 1
             * DisplaySequence : 1
             * Id : 10
             * Image :
             * Name : 数字音乐
             * SubCategories : [{"Depth":1,"DisplaySequence":1,"Id":48,"Image":"/Storage/Plat/Category/201709281335310821880.png","Name":"流行音乐","SubCategories":[]},{"Depth":1,"DisplaySequence":2,"Id":49,"Image":"/Storage/Plat/Category/201709281335440699310.png","Name":"爵士蓝调","SubCategories":[]},{"Depth":1,"DisplaySequence":3,"Id":85,"Image":"/Storage/Plat/Category/201709281335193195160.png","Name":"世界音乐","SubCategories":[]}]
             */

            private int Depth;
            private int DisplaySequence;
            private int Id;
            private String Image;
            private String Name;
            private List<SubCategoriesBean> SubCategories;

            protected SubCategoriesBeanX(Parcel in) {
                Depth = in.readInt();
                DisplaySequence = in.readInt();
                Id = in.readInt();
                Image = in.readString();
                Name = in.readString();
            }

            public static final Creator<SubCategoriesBeanX> CREATOR = new Creator<SubCategoriesBeanX>() {
                @Override
                public SubCategoriesBeanX createFromParcel(Parcel in) {
                    return new SubCategoriesBeanX(in);
                }

                @Override
                public SubCategoriesBeanX[] newArray(int size) {
                    return new SubCategoriesBeanX[size];
                }
            };

            public int getDepth() {
                return Depth;
            }

            public void setDepth(int Depth) {
                this.Depth = Depth;
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

            public String getImage() {
                return Image;
            }

            public void setImage(String Image) {
                this.Image = Image;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public List<SubCategoriesBean> getSubCategories() {
                return SubCategories;
            }

            public void setSubCategories(List<SubCategoriesBean> SubCategories) {
                this.SubCategories = SubCategories;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(Depth);
                dest.writeInt(DisplaySequence);
                dest.writeInt(Id);
                dest.writeString(Image);
                dest.writeString(Name);
            }

            public static class SubCategoriesBean  implements Parcelable{
                public SubCategoriesBean() {
                }

                /**
                 * Depth : 1
                 * DisplaySequence : 1
                 * Id : 48
                 * Image : /Storage/Plat/Category/201709281335310821880.png
                 * Name : 流行音乐
                 * SubCategories : []
                 */

                private int Depth;
                private int DisplaySequence;
                private int Id;
                private String Image;
                private String Name;
                private List<?> SubCategories;

                protected SubCategoriesBean(Parcel in) {
                    Depth = in.readInt();
                    DisplaySequence = in.readInt();
                    Id = in.readInt();
                    Image = in.readString();
                    Name = in.readString();
                }

                public static final Creator<SubCategoriesBean> CREATOR = new Creator<SubCategoriesBean>() {
                    @Override
                    public SubCategoriesBean createFromParcel(Parcel in) {
                        return new SubCategoriesBean(in);
                    }

                    @Override
                    public SubCategoriesBean[] newArray(int size) {
                        return new SubCategoriesBean[size];
                    }
                };

                public int getDepth() {
                    return Depth;
                }

                public void setDepth(int Depth) {
                    this.Depth = Depth;
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

                public String getImage() {
                    return Image;
                }

                public void setImage(String Image) {
                    this.Image = Image;
                }

                public String getName() {
                    return Name;
                }

                public void setName(String Name) {
                    this.Name = Name;
                }

                public List<?> getSubCategories() {
                    return SubCategories;
                }

                public void setSubCategories(List<?> SubCategories) {
                    this.SubCategories = SubCategories;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(Depth);
                    dest.writeInt(DisplaySequence);
                    dest.writeInt(Id);
                    dest.writeString(Image);
                    dest.writeString(Name);
                }
            }
        }
    }
}

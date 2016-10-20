package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Ishinagi_moeta on 2016/10/19.
 */
public class CategoryBean {

    /**
     * status : 1
     * content : [{"status":1,"category_id":162,"category_icon_small":"http://imgcdn.guoku.com/images/100/4f44ef52edc5a84c845135cac628d85c.png","category_title":"避孕套","category_icon_large":"http://imgcdn.guoku.com/images/200/4f44ef52edc5a84c845135cac628d85c.png"},{"status":1,"category_id":845,"category_icon_small":"http://imgcdn.guoku.com/images/100/8dbb893d92bbaea35ef8a34edd20b877.png","category_title":"按摩器材","category_icon_large":"http://imgcdn.guoku.com/images/200/8dbb893d92bbaea35ef8a34edd20b877.png"},{"status":1,"category_id":706,"category_icon_small":"http://imgcdn.guoku.com/images/100/ccbe5d195851297ad42d2e2347fac9cb.png","category_title":"复合维生素","category_icon_large":"http://imgcdn.guoku.com/images/200/ccbe5d195851297ad42d2e2347fac9cb.png"},{"status":1,"category_id":839,"category_icon_small":"http://imgcdn.guoku.com/images/100/18986f5fce4109fcce1b2f72ddea2a6c.png","category_title":"体温计","category_icon_large":"http://imgcdn.guoku.com/images/200/18986f5fce4109fcce1b2f72ddea2a6c.png"},{"status":0,"category_id":799,"category_title":"女用器具"},{"status":0,"category_id":800,"category_title":"情趣内衣"},{"status":0,"category_id":801,"category_title":"情趣用品"},{"status":0,"category_id":834,"category_title":"保健项圈手环"},{"status":0,"category_id":838,"category_title":"运动传感"},{"status":0,"category_id":840,"category_title":"血压血糖"},{"status":0,"category_id":841,"category_title":"助行器"},{"status":0,"category_id":843,"category_title":"矫姿"},{"status":0,"category_id":847,"category_title":"美体工具"},{"status":0,"category_id":855,"category_title":"常用药品"},{"status":0,"category_id":798,"category_title":"男用器具"},{"status":0,"category_id":797,"category_title":"润滑剂"},{"status":0,"category_id":753,"category_title":"蜂胶"},{"status":0,"category_id":672,"category_title":"体重秤"},{"status":0,"category_id":704,"category_title":"维生素C"},{"status":0,"category_id":705,"category_title":"钙铁锌硒"},{"status":0,"category_id":707,"category_title":"左旋肉碱"},{"status":0,"category_id":708,"category_title":"深海鱼油"},{"status":0,"category_id":709,"category_title":"胶原蛋白"},{"status":0,"category_id":710,"category_title":"酵素"},{"status":0,"category_id":711,"category_title":"膳食营养补充"},{"status":0,"category_id":712,"category_title":"膳食纤维"},{"status":0,"category_id":713,"category_title":"降脂"},{"status":0,"category_id":714,"category_title":"保健饮品"},{"status":0,"category_id":715,"category_title":"植物精华"},{"status":0,"category_id":922,"category_title":"保健 HEALTH "}]
     * category_count : 30
     * group_id : 37
     * title : 保健 HEALTH
     */

    private List<BeanBean> bean;

    public List<BeanBean> getBean() {
        return bean;
    }

    public void setBean(List<BeanBean> bean) {
        this.bean = bean;
    }

    public static class BeanBean {
        private int status;
        private int category_count;
        private int group_id;
        private String title;
        /**
         * status : 1
         * category_id : 162
         * category_icon_small : http://imgcdn.guoku.com/images/100/4f44ef52edc5a84c845135cac628d85c.png
         * category_title : 避孕套
         * category_icon_large : http://imgcdn.guoku.com/images/200/4f44ef52edc5a84c845135cac628d85c.png
         */

        private List<ContentBean> content;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getCategory_count() {
            return category_count;
        }

        public void setCategory_count(int category_count) {
            this.category_count = category_count;
        }

        public int getGroup_id() {
            return group_id;
        }

        public void setGroup_id(int group_id) {
            this.group_id = group_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public static class ContentBean implements Parcelable {
            private int status;
            private int category_id;
            private String category_icon_small;
            private String category_title;
            private String category_icon_large;

            public ContentBean() {}

            protected ContentBean(Parcel in) {
                status = in.readInt();
                category_id = in.readInt();
                category_icon_small = in.readString();
                category_title = in.readString();
                category_icon_large = in.readString();
            }

            public static final Creator<ContentBean> CREATOR = new Creator<ContentBean>() {
                @Override
                public ContentBean createFromParcel(Parcel in) {
                    return new ContentBean(in);
                }

                @Override
                public ContentBean[] newArray(int size) {
                    return new ContentBean[size];
                }
            };

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getCategory_icon_small() {
                return category_icon_small;
            }

            public void setCategory_icon_small(String category_icon_small) {
                this.category_icon_small = category_icon_small;
            }

            public String getCategory_title() {
                return category_title;
            }

            public void setCategory_title(String category_title) {
                this.category_title = category_title;
            }

            public String getCategory_icon_large() {
                return category_icon_large;
            }

            public void setCategory_icon_large(String category_icon_large) {
                this.category_icon_large = category_icon_large;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(status);
                dest.writeInt(category_id);
                dest.writeString(category_icon_small);
                dest.writeString(category_title);
                dest.writeString(category_icon_large);
            }
        }
    }
}

package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by DELL on 2016/10/22.
 */
public class LikeBean implements Parcelable{

    /**
     * timestamp : 1.47678577E9
     * entity_list : [{"detail_images":["http://imgcdn.guoku.com/images/d813527018fffa128df59e98003a7843.jpg","http://imgcdn.guoku.com/images/25d7d40c8fddc7842408e030c556c0c4.jpg"],"entity_id":4645627,"weight":0,"note_count":1,"price":"25.00","intro":"","created_time":1.476955016E9,"old_category_id":152,"chief_image":"http://imgcdn.guoku.com/images/bd8169831d9e2bd82a279cd924129b4d.jpg","entity_hash":"1d74c1d3","score_count":0,"novus_time":1.476955016E9,"title":"牛奶巧克力圈饼干","mark":"none","brand":"M&S","status":"1","item_list":[{"status":"2","entity_id":"4645627","foreign_price":"0.00","shop_link":"http://shop105614815.taobao.com","cid":"50002766","price":25,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-21 22:09:19","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/20168206012/?type=mobile","origin_id":"20168206012","id":"3415152"}],"total_score":0,"item_id_list":["54c21867a2128a0711d970da"],"mark_value":0,"like_already":1,"old_root_category_id":9,"updated_time":1.476955016E9,"creator_id":1993256,"like_count":25,"category_id":"124"},{"detail_images":["http://imgcdn.guoku.com/images/139de8ff56dd05725fc3210eebceab70.jpg","http://imgcdn.guoku.com/images/dbd481dab31c830d36fe2cc8cec1b797.jpg","http://imgcdn.guoku.com/images/df0213609a6907140cf520d84ab630e8.jpg","http://imgcdn.guoku.com/images/9c73c85e15be59bb7fd32af88eaf3db9.jpg"],"entity_id":4645587,"weight":0,"note_count":1,"price":"88.00","intro":"","created_time":1.47693769E9,"old_category_id":152,"chief_image":"http://imgcdn.guoku.com/images/236c6dc8c2013275d9c21e9330a8b80a.jpg","entity_hash":"0a848672","score_count":0,"novus_time":1.47693769E9,"title":"日式茶具","mark":"none","brand":"","status":"1","item_list":[{"status":"2","entity_id":"4645587","foreign_price":"0.00","shop_link":"http://shop162834095.taobao.com","cid":"122952001","price":88,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-21 02:00:12","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/534616764822/?type=mobile","origin_id":"534616764822","id":"3415112"}],"total_score":0,"item_id_list":["54c21867a2128a0711d970da"],"mark_value":0,"like_already":1,"old_root_category_id":9,"updated_time":1.47693769E9,"creator_id":1993256,"like_count":48,"category_id":"381"},{"detail_images":["http://imgcdn.guoku.com/images/bff246fb130cd7979f1b5636d39e1380.jpg","http://imgcdn.guoku.com/images/6a3b8cd457bb868a0d9c659973e799c4.jpg","http://imgcdn.guoku.com/images/6faf06b4783b5d138014e85ec8a33f83.jpg","http://imgcdn.guoku.com/images/ebfc4d948c6517a46d7451d6ff768f4f.jpg"],"entity_id":4645470,"weight":0,"note_count":2,"price":"980.00","intro":"","created_time":1.47676486E9,"old_category_id":152,"chief_image":"http://imgcdn.guoku.com/images/6c519fc8ce56c69752398dca7ec2ba8f.jpg","entity_hash":"11f0534b","score_count":0,"novus_time":1.47676486E9,"title":"灰色中跟鞋","mark":"none","brand":"Holy Rape","status":"1","item_list":[{"status":"2","entity_id":"4645470","foreign_price":"0.00","shop_link":"http://shop104149703.taobao.com","cid":"50006843","price":980,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-21 02:00:43","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/537539015471/?type=mobile","origin_id":"537539015471","id":"3414992"}],"total_score":0,"item_id_list":["54c21867a2128a0711d970da"],"mark_value":0,"like_already":1,"old_root_category_id":9,"updated_time":1.47676486E9,"creator_id":1993256,"like_count":37,"category_id":"915"},{"detail_images":["http://imgcdn.guoku.com/images/887f1120caf0f5a8ff3a2007ea67eaed.jpg","http://imgcdn.guoku.com/images/56507d6a647abbdd061b2133e96c8e4f.jpg","http://imgcdn.guoku.com/images/788bd1dca24a383219d404537c033b1a.jpg"],"entity_id":4645478,"weight":0,"note_count":3,"price":"58.00","intro":"","created_time":1.476767778E9,"old_category_id":152,"chief_image":"http://imgcdn.guoku.com/images/7c840faa3cabca8d28190c05c0310b7d.jpg","entity_hash":"b3fd300d","score_count":0,"novus_time":1.476767778E9,"title":"甜牙齿 姜糖组合","mark":"none","brand":"","status":"1","item_list":[{"status":"2","entity_id":"4645478","foreign_price":"0.00","shop_link":"http://shop112083988.taobao.com","cid":"50002766","price":58,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-21 02:00:31","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/539982831614/?type=mobile","origin_id":"539982831614","id":"3415000"}],"total_score":0,"item_id_list":["54c21867a2128a0711d970da"],"mark_value":0,"like_already":1,"old_root_category_id":9,"updated_time":1.476767778E9,"creator_id":1993256,"like_count":58,"category_id":"880"}]
     */

    private double timestamp;
    /**
     * detail_images : ["http://imgcdn.guoku.com/images/d813527018fffa128df59e98003a7843.jpg","http://imgcdn.guoku.com/images/25d7d40c8fddc7842408e030c556c0c4.jpg"]
     * entity_id : 4645627
     * weight : 0
     * note_count : 1
     * price : 25.00
     * intro :
     * created_time : 1.476955016E9
     * old_category_id : 152
     * chief_image : http://imgcdn.guoku.com/images/bd8169831d9e2bd82a279cd924129b4d.jpg
     * entity_hash : 1d74c1d3
     * score_count : 0
     * novus_time : 1.476955016E9
     * title : 牛奶巧克力圈饼干
     * mark : none
     * brand : M&S
     * status : 1
     * item_list : [{"status":"2","entity_id":"4645627","foreign_price":"0.00","shop_link":"http://shop105614815.taobao.com","cid":"50002766","price":25,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-21 22:09:19","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/20168206012/?type=mobile","origin_id":"20168206012","id":"3415152"}]
     * total_score : 0
     * item_id_list : ["54c21867a2128a0711d970da"]
     * mark_value : 0
     * like_already : 1
     * old_root_category_id : 9
     * updated_time : 1.476955016E9
     * creator_id : 1993256
     * like_count : 25
     * category_id : 124
     */

    private List<EntityListBean> entity_list;

    protected LikeBean(Parcel in) {
        timestamp = in.readDouble();
        entity_list = in.createTypedArrayList(EntityListBean.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(timestamp);
        dest.writeTypedList(entity_list);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LikeBean> CREATOR = new Creator<LikeBean>() {
        @Override
        public LikeBean createFromParcel(Parcel in) {
            return new LikeBean(in);
        }

        @Override
        public LikeBean[] newArray(int size) {
            return new LikeBean[size];
        }
    };

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public List<EntityListBean> getEntity_list() {
        return entity_list;
    }

    public void setEntity_list(List<EntityListBean> entity_list) {
        this.entity_list = entity_list;
    }

    public static class EntityListBean implements Parcelable{

        private int entity_id;
        private int weight;
        private int note_count;
        private String price;
        private String intro;
        private double created_time;
        private int old_category_id;
        private String chief_image;
        private String entity_hash;
        private int score_count;
        private double novus_time;
        private String title;
        private String mark;
        private String brand;
        private String status;
        private int total_score;
        private int mark_value;
        private int like_already;
        private int old_root_category_id;
        private double updated_time;
        private int creator_id;
        private int like_count;
        private String category_id;
        private List<String> detail_images;
        public EntityListBean(){}
        /**
         * status : 2
         * entity_id : 4645627
         * foreign_price : 0.00
         * shop_link : http://shop105614815.taobao.com
         * cid : 50002766
         * price : 25
         * origin_source : taobao.com
         * rank : 0
         * last_update : 2016-10-21 22:09:19
         * volume : 0
         * buy_link : http://api.guoku.com/mobile/v4/item/20168206012/?type=mobile
         * origin_id : 20168206012
         * id : 3415152
         */

        private List<ItemListBean> item_list;
        private List<String> item_id_list;

        protected EntityListBean(Parcel in) {
            entity_id = in.readInt();
            weight = in.readInt();
            note_count = in.readInt();
            price = in.readString();
            intro = in.readString();
            created_time = in.readDouble();
            old_category_id = in.readInt();
            chief_image = in.readString();
            entity_hash = in.readString();
            score_count = in.readInt();
            novus_time = in.readDouble();
            title = in.readString();
            mark = in.readString();
            brand = in.readString();
            status = in.readString();
            total_score = in.readInt();
            mark_value = in.readInt();
            like_already = in.readInt();
            old_root_category_id = in.readInt();
            updated_time = in.readDouble();
            creator_id = in.readInt();
            like_count = in.readInt();
            category_id = in.readString();
            detail_images = in.createStringArrayList();
            item_list = in.createTypedArrayList(ItemListBean.CREATOR);
            item_id_list = in.createStringArrayList();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(entity_id);
            dest.writeInt(weight);
            dest.writeInt(note_count);
            dest.writeString(price);
            dest.writeString(intro);
            dest.writeDouble(created_time);
            dest.writeInt(old_category_id);
            dest.writeString(chief_image);
            dest.writeString(entity_hash);
            dest.writeInt(score_count);
            dest.writeDouble(novus_time);
            dest.writeString(title);
            dest.writeString(mark);
            dest.writeString(brand);
            dest.writeString(status);
            dest.writeInt(total_score);
            dest.writeInt(mark_value);
            dest.writeInt(like_already);
            dest.writeInt(old_root_category_id);
            dest.writeDouble(updated_time);
            dest.writeInt(creator_id);
            dest.writeInt(like_count);
            dest.writeString(category_id);
            dest.writeStringList(detail_images);
            dest.writeTypedList(item_list);
            dest.writeStringList(item_id_list);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<EntityListBean> CREATOR = new Creator<EntityListBean>() {
            @Override
            public EntityListBean createFromParcel(Parcel in) {
                return new EntityListBean(in);
            }

            @Override
            public EntityListBean[] newArray(int size) {
                return new EntityListBean[size];
            }
        };

        public int getEntity_id() {
            return entity_id;
        }

        public void setEntity_id(int entity_id) {
            this.entity_id = entity_id;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getNote_count() {
            return note_count;
        }

        public void setNote_count(int note_count) {
            this.note_count = note_count;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public double getCreated_time() {
            return created_time;
        }

        public void setCreated_time(double created_time) {
            this.created_time = created_time;
        }

        public int getOld_category_id() {
            return old_category_id;
        }

        public void setOld_category_id(int old_category_id) {
            this.old_category_id = old_category_id;
        }

        public String getChief_image() {
            return chief_image;
        }

        public void setChief_image(String chief_image) {
            this.chief_image = chief_image;
        }

        public String getEntity_hash() {
            return entity_hash;
        }

        public void setEntity_hash(String entity_hash) {
            this.entity_hash = entity_hash;
        }

        public int getScore_count() {
            return score_count;
        }

        public void setScore_count(int score_count) {
            this.score_count = score_count;
        }

        public double getNovus_time() {
            return novus_time;
        }

        public void setNovus_time(double novus_time) {
            this.novus_time = novus_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getTotal_score() {
            return total_score;
        }

        public void setTotal_score(int total_score) {
            this.total_score = total_score;
        }

        public int getMark_value() {
            return mark_value;
        }

        public void setMark_value(int mark_value) {
            this.mark_value = mark_value;
        }

        public int getLike_already() {
            return like_already;
        }

        public void setLike_already(int like_already) {
            this.like_already = like_already;
        }

        public int getOld_root_category_id() {
            return old_root_category_id;
        }

        public void setOld_root_category_id(int old_root_category_id) {
            this.old_root_category_id = old_root_category_id;
        }

        public double getUpdated_time() {
            return updated_time;
        }

        public void setUpdated_time(double updated_time) {
            this.updated_time = updated_time;
        }

        public int getCreator_id() {
            return creator_id;
        }

        public void setCreator_id(int creator_id) {
            this.creator_id = creator_id;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public List<String> getDetail_images() {
            return detail_images;
        }

        public void setDetail_images(List<String> detail_images) {
            this.detail_images = detail_images;
        }

        public List<ItemListBean> getItem_list() {
            return item_list;
        }

        public void setItem_list(List<ItemListBean> item_list) {
            this.item_list = item_list;
        }

        public List<String> getItem_id_list() {
            return item_id_list;
        }

        public void setItem_id_list(List<String> item_id_list) {
            this.item_id_list = item_id_list;
        }

        public static class ItemListBean implements Parcelable{
            private String status;
            private String entity_id;
            private String foreign_price;
            private String shop_link;
            private String cid;
            private int price;
            private String origin_source;
            private String rank;
            private String last_update;
            private String volume;
            private String buy_link;
            private String origin_id;
            private String id;
            public ItemListBean(){}

            protected ItemListBean(Parcel in) {
                status = in.readString();
                entity_id = in.readString();
                foreign_price = in.readString();
                shop_link = in.readString();
                cid = in.readString();
                price = in.readInt();
                origin_source = in.readString();
                rank = in.readString();
                last_update = in.readString();
                volume = in.readString();
                buy_link = in.readString();
                origin_id = in.readString();
                id = in.readString();
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(status);
                dest.writeString(entity_id);
                dest.writeString(foreign_price);
                dest.writeString(shop_link);
                dest.writeString(cid);
                dest.writeInt(price);
                dest.writeString(origin_source);
                dest.writeString(rank);
                dest.writeString(last_update);
                dest.writeString(volume);
                dest.writeString(buy_link);
                dest.writeString(origin_id);
                dest.writeString(id);
            }

            @Override
            public int describeContents() {
                return 0;
            }

            public static final Creator<ItemListBean> CREATOR = new Creator<ItemListBean>() {
                @Override
                public ItemListBean createFromParcel(Parcel in) {
                    return new ItemListBean(in);
                }

                @Override
                public ItemListBean[] newArray(int size) {
                    return new ItemListBean[size];
                }
            };

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getEntity_id() {
                return entity_id;
            }

            public void setEntity_id(String entity_id) {
                this.entity_id = entity_id;
            }

            public String getForeign_price() {
                return foreign_price;
            }

            public void setForeign_price(String foreign_price) {
                this.foreign_price = foreign_price;
            }

            public String getShop_link() {
                return shop_link;
            }

            public void setShop_link(String shop_link) {
                this.shop_link = shop_link;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getOrigin_source() {
                return origin_source;
            }

            public void setOrigin_source(String origin_source) {
                this.origin_source = origin_source;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getLast_update() {
                return last_update;
            }

            public void setLast_update(String last_update) {
                this.last_update = last_update;
            }

            public String getVolume() {
                return volume;
            }

            public void setVolume(String volume) {
                this.volume = volume;
            }

            public String getBuy_link() {
                return buy_link;
            }

            public void setBuy_link(String buy_link) {
                this.buy_link = buy_link;
            }

            public String getOrigin_id() {
                return origin_id;
            }

            public void setOrigin_id(String origin_id) {
                this.origin_id = origin_id;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}

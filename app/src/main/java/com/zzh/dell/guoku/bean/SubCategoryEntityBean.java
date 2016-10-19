package com.zzh.dell.guoku.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ishinagi_moeta on 2016/10/19.
 */
public class SubCategoryEntityBean {

    /**
     * status : 1
     * detail_images : []
     * entity_id : 4641938
     * updated_time : 1472556135
     * title : 奶油苏打水
     * note_count : 2
     * brand : 玉泉忌廉
     * like_count : 86
     * item_list : [{"status":"2","entity_id":"4641938","foreign_price":"0.00","shop_link":"http://shop72895028.taobao.com","cid":"50026316","default":"True","price":35,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-10 02:05:49","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/521109090282/?type=mobile","origin_id":"521109090282","id":"3411440"}]
     * mark : 0
     * price : 35.00
     * created_time : 1472556135
     * creator_id : 1990882
     * intro :
     * chief_image : http://imgcdn.guoku.com/images/36d9490bc4eec9cf4ff6853af0e418ff.jpg
     * category_id : 727
     * like_already : 0
     * total_score : 0
     * entity_hash : fe33a781
     */

    private List<BeanBean> bean;

    public List<BeanBean> getBean() {
        return bean;
    }

    public void setBean(List<BeanBean> bean) {
        this.bean = bean;
    }

    public static class BeanBean {
        private String status;
        private int entity_id;
        private int updated_time;
        private String title;
        private int note_count;
        private String brand;
        private int like_count;
        private String mark;
        private String price;
        private int created_time;
        private int creator_id;
        private String intro;
        private String chief_image;
        private String category_id;
        private int like_already;
        private int total_score;
        private String entity_hash;
        private List<?> detail_images;
        /**
         * status : 2
         * entity_id : 4641938
         * foreign_price : 0.00
         * shop_link : http://shop72895028.taobao.com
         * cid : 50026316
         * default : True
         * price : 35
         * origin_source : taobao.com
         * rank : 0
         * last_update : 2016-10-10 02:05:49
         * volume : 0
         * buy_link : http://api.guoku.com/mobile/v4/item/521109090282/?type=mobile
         * origin_id : 521109090282
         * id : 3411440
         */

        private List<ItemListBean> item_list;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getEntity_id() {
            return entity_id;
        }

        public void setEntity_id(int entity_id) {
            this.entity_id = entity_id;
        }

        public int getUpdated_time() {
            return updated_time;
        }

        public void setUpdated_time(int updated_time) {
            this.updated_time = updated_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getNote_count() {
            return note_count;
        }

        public void setNote_count(int note_count) {
            this.note_count = note_count;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getCreated_time() {
            return created_time;
        }

        public void setCreated_time(int created_time) {
            this.created_time = created_time;
        }

        public int getCreator_id() {
            return creator_id;
        }

        public void setCreator_id(int creator_id) {
            this.creator_id = creator_id;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getChief_image() {
            return chief_image;
        }

        public void setChief_image(String chief_image) {
            this.chief_image = chief_image;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public int getLike_already() {
            return like_already;
        }

        public void setLike_already(int like_already) {
            this.like_already = like_already;
        }

        public int getTotal_score() {
            return total_score;
        }

        public void setTotal_score(int total_score) {
            this.total_score = total_score;
        }

        public String getEntity_hash() {
            return entity_hash;
        }

        public void setEntity_hash(String entity_hash) {
            this.entity_hash = entity_hash;
        }

        public List<?> getDetail_images() {
            return detail_images;
        }

        public void setDetail_images(List<?> detail_images) {
            this.detail_images = detail_images;
        }

        public List<ItemListBean> getItem_list() {
            return item_list;
        }

        public void setItem_list(List<ItemListBean> item_list) {
            this.item_list = item_list;
        }

        public static class ItemListBean {
            private String status;
            private String entity_id;
            private String foreign_price;
            private String shop_link;
            private String cid;
            @SerializedName("default")
            private String defaultX;
            private int price;
            private String origin_source;
            private String rank;
            private String last_update;
            private String volume;
            private String buy_link;
            private String origin_id;
            private String id;

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

            public String getDefaultX() {
                return defaultX;
            }

            public void setDefaultX(String defaultX) {
                this.defaultX = defaultX;
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

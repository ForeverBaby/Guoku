package com.zzh.dell.guoku.bean;

import java.util.List;

/**
 * 搜索的商品类
 * Created by Ishinagi_moeta on 2016/10/21.
 */
public class SearchEntityBean {

    /**
     * all_count : 211
     * like_count : 0
     */

    private StatBean stat;
    /**
     * detail_images : []
     * entity_id : 88795
     * weight : 0
     * note_count : 10
     * price : 49.90
     * intro :
     * created_time : 1.370402745E9
     * old_category_id : 152
     * chief_image : http://img03.taobaocdn.com/bao/uploaded/i3/19026020893795164/T1PlXTXxXXXXXXXXXX_!!0-item_pic.jpg
     * entity_hash : 129c110b
     * score_count : 0
     * novus_time : 1.370402745E9
     * title : 田园手工海草编 脏衣框
     * mark : none
     * brand :
     * status : 1
     * item_list : [{"status":"2","entity_id":"88795","buy_link":"http://api.guoku.com/mobile/v4/item/19534939521/?type=mobile","shop_link":"http://shop71380328.taobao.com","cid":"50023183","price":111,"origin_source":"taobao.com","rank":"0","seller":"865529026","volume":"0","last_update":"2016-08-30 04:03:29","origin_id":"19534939521","id":"143141"}]
     * total_score : 0
     * item_id_list : ["54c21867a2128a0711d970da"]
     * mark_value : 0
     * like_already : 0
     * old_root_category_id : 9
     * updated_time : 1.370402745E9
     * creator_id : 26688
     * like_count : 1396
     * category_id : 661
     */

    private List<EntityListBean> entity_list;

    public StatBean getStat() {
        return stat;
    }

    public void setStat(StatBean stat) {
        this.stat = stat;
    }

    public List<EntityListBean> getEntity_list() {
        return entity_list;
    }

    public void setEntity_list(List<EntityListBean> entity_list) {
        this.entity_list = entity_list;
    }

    public static class StatBean {
        private int all_count;
        private int like_count;

        public int getAll_count() {
            return all_count;
        }

        public void setAll_count(int all_count) {
            this.all_count = all_count;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }
    }

    public static class EntityListBean {
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
        private List<?> detail_images;
        /**
         * status : 2
         * entity_id : 88795
         * buy_link : http://api.guoku.com/mobile/v4/item/19534939521/?type=mobile
         * shop_link : http://shop71380328.taobao.com
         * cid : 50023183
         * price : 111
         * origin_source : taobao.com
         * rank : 0
         * seller : 865529026
         * volume : 0
         * last_update : 2016-08-30 04:03:29
         * origin_id : 19534939521
         * id : 143141
         */

        private List<ItemListBean> item_list;
        private List<String> item_id_list;

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

        public List<String> getItem_id_list() {
            return item_id_list;
        }

        public void setItem_id_list(List<String> item_id_list) {
            this.item_id_list = item_id_list;
        }

        public static class ItemListBean {
            private String status;
            private String entity_id;
            private String buy_link;
            private String shop_link;
            private String cid;
            private int price;
            private String origin_source;
            private String rank;
            private String seller;
            private String volume;
            private String last_update;
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

            public String getBuy_link() {
                return buy_link;
            }

            public void setBuy_link(String buy_link) {
                this.buy_link = buy_link;
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

            public String getSeller() {
                return seller;
            }

            public void setSeller(String seller) {
                this.seller = seller;
            }

            public String getVolume() {
                return volume;
            }

            public void setVolume(String volume) {
                this.volume = volume;
            }

            public String getLast_update() {
                return last_update;
            }

            public void setLast_update(String last_update) {
                this.last_update = last_update;
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

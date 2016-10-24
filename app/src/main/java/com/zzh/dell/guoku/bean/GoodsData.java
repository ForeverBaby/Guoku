package com.zzh.dell.guoku.bean;

import java.util.List;

/**商品页面数据的地址:http://api.guoku.com/mobile/v4/selection/?count=30&timestamp=1476710807&rcat=0&sign=22d3a06204b6b31376eca87a71982b0a&api_key=0b19c2b93687347e95c6b6f5cc91bb87
 * Created by 32014 on 2016/10/17.
 */
public class GoodsData{

    /**
     * content : {"note":{"entity_id":"4645416","post_time":"2016-10-17 17:08:23","user_id":"216902","is_selected":1,"poker_id_list":[],"creator":{"is_censor":false,"avatar_large":"http://imgcdn.guoku.com/avatar/large/b2c35883b8e3cf92715fd964b4394b58","following_count":0,"avatar_small":"http://imgcdn.guoku.com/avatar/large/b2c35883b8e3cf92715fd964b4394b58","entity_note_count":4182,"like_count":0,"relation":0,"dig_count":0,"authorized_author":false,"city":"朝阳","user_id":216902,"fan_count":496,"nick":"我不娘","location":"北京","email":"A@C.com","website":"","bio":"一筆到底","is_active":"2","nickname":"我不娘","tag_count":257,"gender":"M","mail_verified":false},"poke_already":0,"updated_time":1.476695303E9,"content":"专用朝天椒腌制的腊肉，黄里透红，吃起来味道香醇、肥而不腻，保持了四川腊肉独有的色、香、味、形等特点。","comment_count":0,"note_id":3860990,"poke_count":0,"created_time":1.476695303E9},"entity":{"detail_images":["http://imgcdn.guoku.com/images/2174d4ea18f380596539b3b8a259305b.jpg","http://imgcdn.guoku.com/images/2e1aac8d7714024dc084c34fff2a7a93.jpg","http://imgcdn.guoku.com/images/b90938e96a8a55e3915c459935f46c92.jpg","http://imgcdn.guoku.com/images/cfbed0002250c689004d093e3b0ff685.jpg"],"entity_id":4645416,"weight":0,"note_count":1,"price":"32.80","intro":"","created_time":1.476695303E9,"old_category_id":152,"chief_image":"http://imgcdn.guoku.com/images/aa9018f27c6015fb464493d6dca61858.jpg","entity_hash":"6058628b","score_count":0,"novus_time":1.476695303E9,"title":"烟熏腊肉","mark":"none","brand":"","status":"1","item_list":[{"status":"2","entity_id":"4645416","foreign_price":"0.00","shop_link":"http://shop116516374.taobao.com","cid":"50016422","price":32,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-17 08:38:10","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/540061925391/?type=mobile","origin_id":"540061925391","id":"3414938"}],"total_score":0,"item_id_list":["54c21867a2128a0711d970da"],"mark_value":0,"like_already":0,"old_root_category_id":9,"updated_time":1.476695303E9,"creator_id":1993256,"like_count":9,"category_id":"824"}}
     * post_time : 1.4767104E9
     * type : note_selection
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * note : {"entity_id":"4645416","post_time":"2016-10-17 17:08:23","user_id":"216902","is_selected":1,"poker_id_list":[],"creator":{"is_censor":false,"avatar_large":"http://imgcdn.guoku.com/avatar/large/b2c35883b8e3cf92715fd964b4394b58","following_count":0,"avatar_small":"http://imgcdn.guoku.com/avatar/large/b2c35883b8e3cf92715fd964b4394b58","entity_note_count":4182,"like_count":0,"relation":0,"dig_count":0,"authorized_author":false,"city":"朝阳","user_id":216902,"fan_count":496,"nick":"我不娘","location":"北京","email":"A@C.com","website":"","bio":"一筆到底","is_active":"2","nickname":"我不娘","tag_count":257,"gender":"M","mail_verified":false},"poke_already":0,"updated_time":1.476695303E9,"content":"专用朝天椒腌制的腊肉，黄里透红，吃起来味道香醇、肥而不腻，保持了四川腊肉独有的色、香、味、形等特点。","comment_count":0,"note_id":3860990,"poke_count":0,"created_time":1.476695303E9}
         * entity : {"detail_images":["http://imgcdn.guoku.com/images/2174d4ea18f380596539b3b8a259305b.jpg","http://imgcdn.guoku.com/images/2e1aac8d7714024dc084c34fff2a7a93.jpg","http://imgcdn.guoku.com/images/b90938e96a8a55e3915c459935f46c92.jpg","http://imgcdn.guoku.com/images/cfbed0002250c689004d093e3b0ff685.jpg"],"entity_id":4645416,"weight":0,"note_count":1,"price":"32.80","intro":"","created_time":1.476695303E9,"old_category_id":152,"chief_image":"http://imgcdn.guoku.com/images/aa9018f27c6015fb464493d6dca61858.jpg","entity_hash":"6058628b","score_count":0,"novus_time":1.476695303E9,"title":"烟熏腊肉","mark":"none","brand":"","status":"1","item_list":[{"status":"2","entity_id":"4645416","foreign_price":"0.00","shop_link":"http://shop116516374.taobao.com","cid":"50016422","price":32,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-17 08:38:10","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/540061925391/?type=mobile","origin_id":"540061925391","id":"3414938"}],"total_score":0,"item_id_list":["54c21867a2128a0711d970da"],"mark_value":0,"like_already":0,"old_root_category_id":9,"updated_time":1.476695303E9,"creator_id":1993256,"like_count":9,"category_id":"824"}
         */

        private ContentBean content;
        private double post_time;
        private String type;

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public double getPost_time() {
            return post_time;
        }

        public void setPost_time(double post_time) {
            this.post_time = post_time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static class ContentBean {
            /**
             * entity_id : 4645416
             * post_time : 2016-10-17 17:08:23
             * user_id : 216902
             * is_selected : 1
             * poker_id_list : []
             * creator : {"is_censor":false,"avatar_large":"http://imgcdn.guoku.com/avatar/large/b2c35883b8e3cf92715fd964b4394b58","following_count":0,"avatar_small":"http://imgcdn.guoku.com/avatar/large/b2c35883b8e3cf92715fd964b4394b58","entity_note_count":4182,"like_count":0,"relation":0,"dig_count":0,"authorized_author":false,"city":"朝阳","user_id":216902,"fan_count":496,"nick":"我不娘","location":"北京","email":"A@C.com","website":"","bio":"一筆到底","is_active":"2","nickname":"我不娘","tag_count":257,"gender":"M","mail_verified":false}
             * poke_already : 0
             * updated_time : 1.476695303E9
             * content : 专用朝天椒腌制的腊肉，黄里透红，吃起来味道香醇、肥而不腻，保持了四川腊肉独有的色、香、味、形等特点。
             * comment_count : 0
             * note_id : 3860990
             * poke_count : 0
             * created_time : 1.476695303E9
             */

            private NoteBean note;
            /**
             * detail_images : ["http://imgcdn.guoku.com/images/2174d4ea18f380596539b3b8a259305b.jpg","http://imgcdn.guoku.com/images/2e1aac8d7714024dc084c34fff2a7a93.jpg","http://imgcdn.guoku.com/images/b90938e96a8a55e3915c459935f46c92.jpg","http://imgcdn.guoku.com/images/cfbed0002250c689004d093e3b0ff685.jpg"]
             * entity_id : 4645416
             * weight : 0
             * note_count : 1
             * price : 32.80
             * intro :
             * created_time : 1.476695303E9
             * old_category_id : 152
             * chief_image : http://imgcdn.guoku.com/images/aa9018f27c6015fb464493d6dca61858.jpg
             * entity_hash : 6058628b
             * score_count : 0
             * novus_time : 1.476695303E9
             * title : 烟熏腊肉
             * mark : none
             * brand :
             * status : 1
             * item_list : [{"status":"2","entity_id":"4645416","foreign_price":"0.00","shop_link":"http://shop116516374.taobao.com","cid":"50016422","price":32,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-17 08:38:10","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/540061925391/?type=mobile","origin_id":"540061925391","id":"3414938"}]
             * total_score : 0
             * item_id_list : ["54c21867a2128a0711d970da"]
             * mark_value : 0
             * like_already : 0
             * old_root_category_id : 9
             * updated_time : 1.476695303E9
             * creator_id : 1993256
             * like_count : 9
             * category_id : 824
             */

            private EntityBean entity;

            public NoteBean getNote() {
                return note;
            }

            public void setNote(NoteBean note) {
                this.note = note;
            }

            public EntityBean getEntity() {
                return entity;
            }

            public void setEntity(EntityBean entity) {
                this.entity = entity;
            }

            public static class NoteBean {
                private String entity_id;
                private String post_time;
                private String user_id;
                private int is_selected;
                /**
                 * is_censor : false
                 * avatar_large : http://imgcdn.guoku.com/avatar/large/b2c35883b8e3cf92715fd964b4394b58
                 * following_count : 0
                 * avatar_small : http://imgcdn.guoku.com/avatar/large/b2c35883b8e3cf92715fd964b4394b58
                 * entity_note_count : 4182
                 * like_count : 0
                 * relation : 0
                 * dig_count : 0
                 * authorized_author : false
                 * city : 朝阳
                 * user_id : 216902
                 * fan_count : 496
                 * nick : 我不娘
                 * location : 北京
                 * email : A@C.com
                 * website :
                 * bio : 一筆到底
                 * is_active : 2
                 * nickname : 我不娘
                 * tag_count : 257
                 * gender : M
                 * mail_verified : false
                 */

                private CreatorBean creator;
                private int poke_already;
                private double updated_time;
                private String content;
                private int comment_count;
                private int note_id;
                private int poke_count;
                private double created_time;
                private List<?> poker_id_list;

                public String getEntity_id() {
                    return entity_id;
                }

                public void setEntity_id(String entity_id) {
                    this.entity_id = entity_id;
                }

                public String getPost_time() {
                    return post_time;
                }

                public void setPost_time(String post_time) {
                    this.post_time = post_time;
                }

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public int getIs_selected() {
                    return is_selected;
                }

                public void setIs_selected(int is_selected) {
                    this.is_selected = is_selected;
                }

                public CreatorBean getCreator() {
                    return creator;
                }

                public void setCreator(CreatorBean creator) {
                    this.creator = creator;
                }

                public int getPoke_already() {
                    return poke_already;
                }

                public void setPoke_already(int poke_already) {
                    this.poke_already = poke_already;
                }

                public double getUpdated_time() {
                    return updated_time;
                }

                public void setUpdated_time(double updated_time) {
                    this.updated_time = updated_time;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public int getComment_count() {
                    return comment_count;
                }

                public void setComment_count(int comment_count) {
                    this.comment_count = comment_count;
                }

                public int getNote_id() {
                    return note_id;
                }

                public void setNote_id(int note_id) {
                    this.note_id = note_id;
                }

                public int getPoke_count() {
                    return poke_count;
                }

                public void setPoke_count(int poke_count) {
                    this.poke_count = poke_count;
                }

                public double getCreated_time() {
                    return created_time;
                }

                public void setCreated_time(double created_time) {
                    this.created_time = created_time;
                }

                public List<?> getPoker_id_list() {
                    return poker_id_list;
                }

                public void setPoker_id_list(List<?> poker_id_list) {
                    this.poker_id_list = poker_id_list;
                }

                public static class CreatorBean {
                    private boolean is_censor;
                    private String avatar_large;
                    private int following_count;
                    private String avatar_small;
                    private int entity_note_count;
                    private int like_count;
                    private int relation;
                    private int dig_count;
                    private boolean authorized_author;
                    private String city;
                    private int user_id;
                    private int fan_count;
                    private String nick;
                    private String location;
                    private String email;
                    private String website;
                    private String bio;
                    private String is_active;
                    private String nickname;
                    private int tag_count;
                    private String gender;
                    private boolean mail_verified;

                    public boolean isIs_censor() {
                        return is_censor;
                    }

                    public void setIs_censor(boolean is_censor) {
                        this.is_censor = is_censor;
                    }

                    public String getAvatar_large() {
                        return avatar_large;
                    }

                    public void setAvatar_large(String avatar_large) {
                        this.avatar_large = avatar_large;
                    }

                    public int getFollowing_count() {
                        return following_count;
                    }

                    public void setFollowing_count(int following_count) {
                        this.following_count = following_count;
                    }

                    public String getAvatar_small() {
                        return avatar_small;
                    }

                    public void setAvatar_small(String avatar_small) {
                        this.avatar_small = avatar_small;
                    }

                    public int getEntity_note_count() {
                        return entity_note_count;
                    }

                    public void setEntity_note_count(int entity_note_count) {
                        this.entity_note_count = entity_note_count;
                    }

                    public int getLike_count() {
                        return like_count;
                    }

                    public void setLike_count(int like_count) {
                        this.like_count = like_count;
                    }

                    public int getRelation() {
                        return relation;
                    }

                    public void setRelation(int relation) {
                        this.relation = relation;
                    }

                    public int getDig_count() {
                        return dig_count;
                    }

                    public void setDig_count(int dig_count) {
                        this.dig_count = dig_count;
                    }

                    public boolean isAuthorized_author() {
                        return authorized_author;
                    }

                    public void setAuthorized_author(boolean authorized_author) {
                        this.authorized_author = authorized_author;
                    }

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }

                    public int getUser_id() {
                        return user_id;
                    }

                    public void setUser_id(int user_id) {
                        this.user_id = user_id;
                    }

                    public int getFan_count() {
                        return fan_count;
                    }

                    public void setFan_count(int fan_count) {
                        this.fan_count = fan_count;
                    }

                    public String getNick() {
                        return nick;
                    }

                    public void setNick(String nick) {
                        this.nick = nick;
                    }

                    public String getLocation() {
                        return location;
                    }

                    public void setLocation(String location) {
                        this.location = location;
                    }

                    public String getEmail() {
                        return email;
                    }

                    public void setEmail(String email) {
                        this.email = email;
                    }

                    public String getWebsite() {
                        return website;
                    }

                    public void setWebsite(String website) {
                        this.website = website;
                    }

                    public String getBio() {
                        return bio;
                    }

                    public void setBio(String bio) {
                        this.bio = bio;
                    }

                    public String getIs_active() {
                        return is_active;
                    }

                    public void setIs_active(String is_active) {
                        this.is_active = is_active;
                    }

                    public String getNickname() {
                        return nickname;
                    }

                    public void setNickname(String nickname) {
                        this.nickname = nickname;
                    }

                    public int getTag_count() {
                        return tag_count;
                    }

                    public void setTag_count(int tag_count) {
                        this.tag_count = tag_count;
                    }

                    public String getGender() {
                        return gender;
                    }

                    public void setGender(String gender) {
                        this.gender = gender;
                    }

                    public boolean isMail_verified() {
                        return mail_verified;
                    }

                    public void setMail_verified(boolean mail_verified) {
                        this.mail_verified = mail_verified;
                    }
                }
            }

            public static class EntityBean {
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
                /**
                 * status : 2
                 * entity_id : 4645416
                 * foreign_price : 0.00
                 * shop_link : http://shop116516374.taobao.com
                 * cid : 50016422
                 * price : 32
                 * origin_source : taobao.com
                 * rank : 0
                 * last_update : 2016-10-17 08:38:10
                 * volume : 0
                 * buy_link : http://api.guoku.com/mobile/v4/item/540061925391/?type=mobile
                 * origin_id : 540061925391
                 * id : 3414938
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

                public static class ItemListBean {
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
    }
}

package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 32014 on 2016/10/19.
 */
public class GoodsChildData {

    /**
     * status : 1
     * detail_images : []
     * entity_id : 4645530
     * updated_time : 1.476800106E9
     * title : 日本全国乡土玩具歌留多 纸牌游戏
     * note_count : 1
     * brand : 中川政七商店
     * like_count : 11
     * item_list : [{"status":"2","entity_id":"4645530","foreign_price":"0.00","shop_link":"http://shop64138755.taobao.com","cid":"124484008","default":"True","price":198,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-19 02:00:02","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/529548656150/?type=mobile","origin_id":"529548656150","id":"3415054"}]
     * mark : 0
     * price : 198.00
     * created_time : 1.476800106E9
     * creator_id : 19
     * intro :
     * chief_image : http://imgcdn.guoku.com/images/c699fa0cf42f2f424b0a757a2f113ff5.jpg
     * category_id : 920
     * like_already : 0
     * total_score : 0
     * entity_hash : d828e587
     */

    private EntityBean entity;
    /**
     * is_censor : false
     * avatar_large : http://imgcdn.guoku.com/avatar/large_171010_c2c09aaf718410c7b866f9107f47825c.jpe
     * following_count : 1
     * avatar_small : http://imgcdn.guoku.com/avatar/large_171010_c2c09aaf718410c7b866f9107f47825c.jpe
     * entity_note_count : 0
     * sina_screen_name : espialpig
     * like_count : 6648
     * relation : 0
     * dig_count : 29
     * authorized_author : false
     * city : 东城
     * user_id : 171010
     * fan_count : 2
     * nick : azhu123456789
     * location : 北京
     * email : lxz92578@sina.com
     * website : null
     * bio : null
     * is_active : 1
     * nickname : azhu123456789
     * tag_count : 0
     * gender : F
     * mail_verified : false
     */

    private List<LikeUserListBean> like_user_list;
    /**
     * entity_id : 4645530
     * post_time : 2016-10-18 22:15:06
     * user_id : 209071
     * creator : {"is_censor":false,"avatar_large":"http://imgcdn.guoku.com/avatar/large/82cfb16061b4e662d370106ee6b4814f","following_count":0,"avatar_small":"http://imgcdn.guoku.com/avatar/large/82cfb16061b4e662d370106ee6b4814f","entity_note_count":8009,"like_count":0,"relation":0,"dig_count":0,"authorized_author":false,"city":"其它地区","user_id":209071,"fan_count":760,"nick":"一小撮梨花","location":"海外","email":"jiazhipeng3@icloud.com","website":"","bio":"人类的朋友","is_active":"2","nickname":"一小撮梨花","tag_count":390,"gender":"O","mail_verified":false}
     * poker_id_list : []
     * is_selected : 1
     * poke_already : 0
     * updated_time : 1.476800106E9
     * content : 在游戏的同时，你可以感受到浓浓的日本文化气息。也许这就是有趣又轻松的传承尝试吧。
     * comment_count : 0
     * note_id : 3861140
     * poke_count : 0
     * created_time : 1.476800106E9
     */

    private List<NoteListBean> note_list;

    public EntityBean getEntity() {
        return entity;
    }

    public void setEntity(EntityBean entity) {
        this.entity = entity;
    }

    public List<LikeUserListBean> getLike_user_list() {
        return like_user_list;
    }

    public void setLike_user_list(List<LikeUserListBean> like_user_list) {
        this.like_user_list = like_user_list;
    }

    public List<NoteListBean> getNote_list() {
        return note_list;
    }

    public void setNote_list(List<NoteListBean> note_list) {
        this.note_list = note_list;
    }

    public static class EntityBean {
        private String status;
        private int entity_id;
        private double updated_time;
        private String title;
        private int note_count;
        private String brand;
        private int like_count;
        private String mark;
        private String price;
        private double created_time;
        private int creator_id;
        private String intro;
        private String chief_image;
        private String category_id;
        private int like_already;
        private int total_score;
        private String entity_hash;
        private List<String> detail_images;
        /**
         * status : 2
         * entity_id : 4645530
         * foreign_price : 0.00
         * shop_link : http://shop64138755.taobao.com
         * cid : 124484008
         * default : True
         * price : 198
         * origin_source : taobao.com
         * rank : 0
         * last_update : 2016-10-19 02:00:02
         * volume : 0
         * buy_link : http://api.guoku.com/mobile/v4/item/529548656150/?type=mobile
         * origin_id : 529548656150
         * id : 3415054
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

        public double getUpdated_time() {
            return updated_time;
        }

        public void setUpdated_time(double updated_time) {
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

        public double getCreated_time() {
            return created_time;
        }

        public void setCreated_time(double created_time) {
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

    public static class LikeUserListBean {
        private boolean is_censor;
        private String avatar_large;
        private int following_count;
        private String avatar_small;
        private int entity_note_count;
        private String sina_screen_name;
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
        private Object website;
        private Object bio;
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

        public String getSina_screen_name() {
            return sina_screen_name;
        }

        public void setSina_screen_name(String sina_screen_name) {
            this.sina_screen_name = sina_screen_name;
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

        public Object getWebsite() {
            return website;
        }

        public void setWebsite(Object website) {
            this.website = website;
        }

        public Object getBio() {
            return bio;
        }

        public void setBio(Object bio) {
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

    public static class NoteListBean implements Parcelable{
        private String entity_id;
        private String post_time;
        private String user_id;
        /**
         * is_censor : false
         * avatar_large : http://imgcdn.guoku.com/avatar/large/82cfb16061b4e662d370106ee6b4814f
         * following_count : 0
         * avatar_small : http://imgcdn.guoku.com/avatar/large/82cfb16061b4e662d370106ee6b4814f
         * entity_note_count : 8009
         * like_count : 0
         * relation : 0
         * dig_count : 0
         * authorized_author : false
         * city : 其它地区
         * user_id : 209071
         * fan_count : 760
         * nick : 一小撮梨花
         * location : 海外
         * email : jiazhipeng3@icloud.com
         * website :
         * bio : 人类的朋友
         * is_active : 2
         * nickname : 一小撮梨花
         * tag_count : 390
         * gender : O
         * mail_verified : false
         */

        private CreatorBean creator;
        private int is_selected;
        private int poke_already;
        private double updated_time;
        private String content;
        private int comment_count;
        private int note_id;
        private int poke_count;
        private double created_time;
        private List<?> poker_id_list;

        protected NoteListBean(Parcel in) {
            entity_id = in.readString();
            post_time = in.readString();
            user_id = in.readString();
            is_selected = in.readInt();
            poke_already = in.readInt();
            updated_time = in.readDouble();
            content = in.readString();
            comment_count = in.readInt();
            note_id = in.readInt();
            poke_count = in.readInt();
            created_time = in.readDouble();
        }

        public static final Creator<NoteListBean> CREATOR = new Creator<NoteListBean>() {
            @Override
            public NoteListBean createFromParcel(Parcel in) {
                return new NoteListBean(in);
            }

            @Override
            public NoteListBean[] newArray(int size) {
                return new NoteListBean[size];
            }
        };

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

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public int getIs_selected() {
            return is_selected;
        }

        public void setIs_selected(int is_selected) {
            this.is_selected = is_selected;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(entity_id);
            dest.writeString(post_time);
            dest.writeString(user_id);
            dest.writeInt(is_selected);
            dest.writeInt(poke_already);
            dest.writeDouble(updated_time);
            dest.writeString(content);
            dest.writeInt(comment_count);
            dest.writeInt(note_id);
            dest.writeInt(poke_count);
            dest.writeDouble(created_time);
        }

        public static class CreatorBean implements Parcelable{
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

            protected CreatorBean(Parcel in) {
                is_censor = in.readByte() != 0;
                avatar_large = in.readString();
                following_count = in.readInt();
                avatar_small = in.readString();
                entity_note_count = in.readInt();
                like_count = in.readInt();
                relation = in.readInt();
                dig_count = in.readInt();
                authorized_author = in.readByte() != 0;
                city = in.readString();
                user_id = in.readInt();
                fan_count = in.readInt();
                nick = in.readString();
                location = in.readString();
                email = in.readString();
                website = in.readString();
                bio = in.readString();
                is_active = in.readString();
                nickname = in.readString();
                tag_count = in.readInt();
                gender = in.readString();
                mail_verified = in.readByte() != 0;
            }

            public static final Creator<CreatorBean> CREATOR = new Creator<CreatorBean>() {
                @Override
                public CreatorBean createFromParcel(Parcel in) {
                    return new CreatorBean(in);
                }

                @Override
                public CreatorBean[] newArray(int size) {
                    return new CreatorBean[size];
                }
            };

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeByte((byte) (is_censor ? 1 : 0));
                dest.writeString(avatar_large);
                dest.writeInt(following_count);
                dest.writeString(avatar_small);
                dest.writeInt(entity_note_count);
                dest.writeInt(like_count);
                dest.writeInt(relation);
                dest.writeInt(dig_count);
                dest.writeByte((byte) (authorized_author ? 1 : 0));
                dest.writeString(city);
                dest.writeInt(user_id);
                dest.writeInt(fan_count);
                dest.writeString(nick);
                dest.writeString(location);
                dest.writeString(email);
                dest.writeString(website);
                dest.writeString(bio);
                dest.writeString(is_active);
                dest.writeString(nickname);
                dest.writeInt(tag_count);
                dest.writeString(gender);
                dest.writeByte((byte) (mail_verified ? 1 : 0));
            }
        }
    }
}

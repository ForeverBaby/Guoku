package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by DELL on 2016/10/24.
 */
public class Entity2 {

    /**
     * is_censor : false
     * avatar_large : http://imgcdn.guoku.com/avatar/82666b966b2cdf3f9525cc6a27f58da6.jpg
     * following_count : 9
     * avatar_small : http://imgcdn.guoku.com/avatar/82666b966b2cdf3f9525cc6a27f58da6.jpg
     * entity_note_count : 321
     * taobao_token_expires_in : 604800
     * sina_screen_name : chemorrisray
     * like_count : 2173
     * relation : 0
     * dig_count : 2
     * authorized_author : false
     * city : 西城
     * user_id : 184115
     * fan_count : 21
     * nick : 每季度生吃
     * location : 北京
     * wechat_nick : 宇宙之王
     * email : chemorrismystery@aol.com
     * website :
     * bio :
     * is_active : 1
     * nickname : 每季度生吃
     * tag_count : 11
     * taobao_nick : chemorrisray
     * gender : M
     * mail_verified : true
     */

    private UserBean user;
    /**
     * detail_images : ["http://gi3.md.alicdn.com/imgextra/i3/927669944/T2ALCEXhdbXXXXXXXX_!!927669944.jpg","http://gi4.md.alicdn.com/imgextra/i4/927669944/T2MtCIXixbXXXXXXXX_!!927669944.jpg","http://gi2.md.alicdn.com/imgextra/i2/927669944/T2wFdPXktdXXXXXXXX_!!927669944.jpg","http://gi2.md.alicdn.com/imgextra/i2/927669944/T2NDhAXmBNXXXXXXXX_!!927669944.jpg"]
     * entity_id : 1404703
     * weight : 0
     * note_count : 4
     * price : 1750.00
     * intro :
     * created_time : 1.400739151E9
     * old_category_id : 152
     * chief_image : http://gi4.md.alicdn.com/bao/uploaded/i4/T12lLzXh0lXXXuV7M2_044735.jpg
     * entity_hash : ad9d4096
     * score_count : 0
     * novus_time : 1.400739151E9
     * title : 木制拼图
     * mark : none
     * brand : Naef
     * status : 1
     * item_list : [{"status":"1","entity_id":"1404703","buy_link":"http://api.guoku.com/mobile/v4/item/19346332786/?type=mobile","shop_link":"http://shop72822597.taobao.com","cid":"25","price":1750,"origin_source":"taobao.com","rank":"0","seller":"927669944","volume":"0","last_update":"2016-08-30 06:47:54","origin_id":"19346332786","id":"45867"}]
     * total_score : 0
     * item_id_list : ["54c21867a2128a0711d970da"]
     * mark_value : 0
     * like_already : 0
     * old_root_category_id : 9
     * updated_time : 1.400739151E9
     * creator_id : 68310
     * like_count : 76
     * category_id : 337
     */

    private List<EntityListBean> entity_list;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<EntityListBean> getEntity_list() {
        return entity_list;
    }

    public void setEntity_list(List<EntityListBean> entity_list) {
        this.entity_list = entity_list;
    }

    public static class UserBean implements Parcelable{
        private boolean is_censor;
        private String avatar_large;
        private int following_count;
        private String avatar_small;
        private int entity_note_count;
        private int taobao_token_expires_in;
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
        private String wechat_nick;
        private String email;
        private String website;
        private String bio;
        private String is_active;
        private String nickname;
        private int tag_count;
        private String taobao_nick;
        private String gender;
        private boolean mail_verified;

        protected UserBean(Parcel in) {
            is_censor = in.readByte() != 0;
            avatar_large = in.readString();
            following_count = in.readInt();
            avatar_small = in.readString();
            entity_note_count = in.readInt();
            taobao_token_expires_in = in.readInt();
            sina_screen_name = in.readString();
            like_count = in.readInt();
            relation = in.readInt();
            dig_count = in.readInt();
            authorized_author = in.readByte() != 0;
            city = in.readString();
            user_id = in.readInt();
            fan_count = in.readInt();
            nick = in.readString();
            location = in.readString();
            wechat_nick = in.readString();
            email = in.readString();
            website = in.readString();
            bio = in.readString();
            is_active = in.readString();
            nickname = in.readString();
            tag_count = in.readInt();
            taobao_nick = in.readString();
            gender = in.readString();
            mail_verified = in.readByte() != 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte((byte) (is_censor ? 1 : 0));
            dest.writeString(avatar_large);
            dest.writeInt(following_count);
            dest.writeString(avatar_small);
            dest.writeInt(entity_note_count);
            dest.writeInt(taobao_token_expires_in);
            dest.writeString(sina_screen_name);
            dest.writeInt(like_count);
            dest.writeInt(relation);
            dest.writeInt(dig_count);
            dest.writeByte((byte) (authorized_author ? 1 : 0));
            dest.writeString(city);
            dest.writeInt(user_id);
            dest.writeInt(fan_count);
            dest.writeString(nick);
            dest.writeString(location);
            dest.writeString(wechat_nick);
            dest.writeString(email);
            dest.writeString(website);
            dest.writeString(bio);
            dest.writeString(is_active);
            dest.writeString(nickname);
            dest.writeInt(tag_count);
            dest.writeString(taobao_nick);
            dest.writeString(gender);
            dest.writeByte((byte) (mail_verified ? 1 : 0));
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
            @Override
            public UserBean createFromParcel(Parcel in) {
                return new UserBean(in);
            }

            @Override
            public UserBean[] newArray(int size) {
                return new UserBean[size];
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

        public int getTaobao_token_expires_in() {
            return taobao_token_expires_in;
        }

        public void setTaobao_token_expires_in(int taobao_token_expires_in) {
            this.taobao_token_expires_in = taobao_token_expires_in;
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

        public String getWechat_nick() {
            return wechat_nick;
        }

        public void setWechat_nick(String wechat_nick) {
            this.wechat_nick = wechat_nick;
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

        public String getTaobao_nick() {
            return taobao_nick;
        }

        public void setTaobao_nick(String taobao_nick) {
            this.taobao_nick = taobao_nick;
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
        /**
         * status : 1
         * entity_id : 1404703
         * buy_link : http://api.guoku.com/mobile/v4/item/19346332786/?type=mobile
         * shop_link : http://shop72822597.taobao.com
         * cid : 25
         * price : 1750
         * origin_source : taobao.com
         * rank : 0
         * seller : 927669944
         * volume : 0
         * last_update : 2016-08-30 06:47:54
         * origin_id : 19346332786
         * id : 45867
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

            protected ItemListBean(Parcel in) {
                status = in.readString();
                entity_id = in.readString();
                buy_link = in.readString();
                shop_link = in.readString();
                cid = in.readString();
                price = in.readInt();
                origin_source = in.readString();
                rank = in.readString();
                seller = in.readString();
                volume = in.readString();
                last_update = in.readString();
                origin_id = in.readString();
                id = in.readString();
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(status);
                dest.writeString(entity_id);
                dest.writeString(buy_link);
                dest.writeString(shop_link);
                dest.writeString(cid);
                dest.writeInt(price);
                dest.writeString(origin_source);
                dest.writeString(rank);
                dest.writeString(seller);
                dest.writeString(volume);
                dest.writeString(last_update);
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

package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by DELL on 2016/10/23.
 */
public class UserTagBean implements Parcelable{


    /**
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
     * article_count : 0
     * nick : 每季度生吃
     * location : 北京
     * wechat_nick : 宇宙之王
     * email : chemorrismystery@aol.com
     * website :
     * bio :
     * is_active : 1
     * authorized_seller : false
     * nickname : 每季度生吃
     * tag_count : 11
     * taobao_nick : chemorrisray
     * gender : M
     * mail_verified : true
     */

    private UserBean user;
    /**
     * tag_hash : 70b2443b510e1fc02b1d960a695d9493
     * tag : 我就看看我买不起
     * entity_count : 1
     * tag_id : 3973
     */

    private List<TagsBean> tags;

    protected UserTagBean(Parcel in) {
        tags = in.createTypedArrayList(TagsBean.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(tags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserTagBean> CREATOR = new Creator<UserTagBean>() {
        @Override
        public UserTagBean createFromParcel(Parcel in) {
            return new UserTagBean(in);
        }

        @Override
        public UserTagBean[] newArray(int size) {
            return new UserTagBean[size];
        }
    };

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class UserBean {
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
        private int article_count;
        private String nick;
        private String location;
        private String wechat_nick;
        private String email;
        private String website;
        private String bio;
        private String is_active;
        private boolean authorized_seller;
        private String nickname;
        private int tag_count;
        private String taobao_nick;
        private String gender;
        private boolean mail_verified;

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

        public int getArticle_count() {
            return article_count;
        }

        public void setArticle_count(int article_count) {
            this.article_count = article_count;
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

        public boolean isAuthorized_seller() {
            return authorized_seller;
        }

        public void setAuthorized_seller(boolean authorized_seller) {
            this.authorized_seller = authorized_seller;
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

    public static class TagsBean implements Parcelable{
        private String tag_hash;
        private String tag;
        private int entity_count;
        private int tag_id;

        protected TagsBean(Parcel in) {
            tag_hash = in.readString();
            tag = in.readString();
            entity_count = in.readInt();
            tag_id = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(tag_hash);
            dest.writeString(tag);
            dest.writeInt(entity_count);
            dest.writeInt(tag_id);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<TagsBean> CREATOR = new Creator<TagsBean>() {
            @Override
            public TagsBean createFromParcel(Parcel in) {
                return new TagsBean(in);
            }

            @Override
            public TagsBean[] newArray(int size) {
                return new TagsBean[size];
            }
        };

        public String getTag_hash() {
            return tag_hash;
        }

        public void setTag_hash(String tag_hash) {
            this.tag_hash = tag_hash;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getEntity_count() {
            return entity_count;
        }

        public void setEntity_count(int entity_count) {
            this.entity_count = entity_count;
        }

        public int getTag_id() {
            return tag_id;
        }

        public void setTag_id(int tag_id) {
            this.tag_id = tag_id;
        }
    }
}

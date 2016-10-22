package com.zzh.dell.guoku.bean;

import java.util.List;

/**
 * Created by Ishinagi_moeta on 2016/10/22.
 */
public class SearchUserBean {

    /**
     * is_censor : false
     * avatar_large : http://imgcdn.guoku.com/avatar/large_13508_00580dab156a7eb059a29cb6ff0e2d05.jpg
     * following_count : 1
     * avatar_small : http://imgcdn.guoku.com/avatar/large_13508_00580dab156a7eb059a29cb6ff0e2d05.jpg
     * entity_note_count : 11
     * sina_screen_name : Heather真真真
     * like_count : 137
     * relation : 0
     * dig_count : 0
     * authorized_author : false
     * city : 西安
     * user_id : 13508
     * fan_count : 29
     * nick : Heather919
     * location : 陕西
     * email : 345279058@qq.com
     * website : http://neishenmeyi.taobao.com/
     * bio : 内什么衣
     Under What Wear
     * is_active : 1
     * nickname : Heather919
     * tag_count : 1
     * gender : F
     * mail_verified : false
     */

    private List<BeanBean> bean;

    public List<BeanBean> getBean() {
        return bean;
    }

    public void setBean(List<BeanBean> bean) {
        this.bean = bean;
    }

    public static class BeanBean {
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

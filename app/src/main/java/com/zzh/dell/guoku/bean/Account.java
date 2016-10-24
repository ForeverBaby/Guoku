package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DELL on 2016/10/15.
 */
public class Account implements Parcelable {

    /**
     * session : 8a17420cb1df5c4ef7ffdec6af6d7eec
     * user : {"is_censor":false,"avatar_large":"http://static.guoku.com/static/v4/6e731caccdbfccc23e1b89db7748804c76c1832c/images/avatar/man.png","following_count":0,"avatar_small":"http://static.guoku.com/static/v4/6e731caccdbfccc23e1b89db7748804c76c1832c/images/avatar/man.png","entity_note_count":0,"like_count":0,"relation":0,"dig_count":0,"authorized_author":false,"city":"朝阳","user_id":2010848,"fan_count":0,"nick":"王立鹏4","location":"北京","email":"3201487189@qq.com","website":null,"bio":null,"is_active":"True","nickname":"王立鹏4","tag_count":0,"gender":"O","mail_verified":false}
     */

    private String session;
    /**
     * is_censor : false
     * avatar_large : http://static.guoku.com/static/v4/6e731caccdbfccc23e1b89db7748804c76c1832c/images/avatar/man.png
     * following_count : 0
     * avatar_small : http://static.guoku.com/static/v4/6e731caccdbfccc23e1b89db7748804c76c1832c/images/avatar/man.png
     * entity_note_count : 0
     * like_count : 0
     * relation : 0
     * dig_count : 0
     * authorized_author : false
     * city : 朝阳
     * user_id : 2010848
     * fan_count : 0
     * nick : 王立鹏4
     * location : 北京
     * email : 3201487189@qq.com
     * website : null
     * bio : null
     * is_active : True
     * nickname : 王立鹏4
     * tag_count : 0
     * gender : O
     * mail_verified : false
     */

    private UserBean user;

    public Account() {
    }

    protected Account(Parcel in) {
        session = in.readString();
        user = in.readParcelable(UserBean.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(session);
        dest.writeParcelable(user, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean implements Parcelable {
        private boolean is_censor;
        private String avatar_large;//
        private int following_count;//
        private String avatar_small;//
        private int entity_note_count;//
        private int like_count;//
        private int relation;//
        private int dig_count;//
        private boolean authorized_author;//
        private String city;
        private int user_id;//
        private int fan_count;//
        private String nick;//
        private String location;//
        private String email;//
        private Object website;
        private Object bio;//
        private String is_active;
        private String nickname;//
        private int tag_count;//
        private String gender;//
        private boolean mail_verified;//

        public UserBean(){};

        protected UserBean(Parcel in) {
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
            is_active = in.readString();
            nickname = in.readString();
            tag_count = in.readInt();
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
            dest.writeString(is_active);
            dest.writeString(nickname);
            dest.writeInt(tag_count);
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
}

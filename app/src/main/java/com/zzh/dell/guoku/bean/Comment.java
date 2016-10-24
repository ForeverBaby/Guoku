package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by DELL on 2016/10/22.
 */
public class Comment implements Parcelable{

    /**
     * note : {"entity_id":"4645470","post_time":"2016-10-18 18:18:08","user_id":"2010631","creator":{"is_censor":false,"avatar_large":"http://imgcdn.guoku.com/avatar/c687558aa4686ac725e0698678bb4e22.jpg","following_count":1,"avatar_small":"http://imgcdn.guoku.com/avatar/c687558aa4686ac725e0698678bb4e22.jpg","entity_note_count":2,"like_count":4,"relation":0,"dig_count":2,"authorized_author":false,"city":"朝阳","user_id":2010631,"fan_count":1,"nick":"Foreverbaby2","location":"北京","email":"337922184@qq.com","website":null,"bio":"(⊙o⊙)\u2026?","is_active":"1","nickname":"Foreverbaby2","tag_count":0,"gender":"M","mail_verified":false},"poker_id_list":[],"is_selected":0,"poke_already":0,"updated_time":1.476785888E9,"content":"不好","comment_count":0,"note_id":3861110,"poke_count":0,"created_time":1.476785888E9}
     * entity : {"detail_images":["http://imgcdn.guoku.com/images/bff246fb130cd7979f1b5636d39e1380.jpg","http://imgcdn.guoku.com/images/6a3b8cd457bb868a0d9c659973e799c4.jpg","http://imgcdn.guoku.com/images/6faf06b4783b5d138014e85ec8a33f83.jpg","http://imgcdn.guoku.com/images/ebfc4d948c6517a46d7451d6ff768f4f.jpg"],"entity_id":4645470,"weight":0,"note_count":2,"price":"980.00","intro":"","created_time":1.47676486E9,"old_category_id":152,"chief_image":"http://imgcdn.guoku.com/images/6c519fc8ce56c69752398dca7ec2ba8f.jpg","entity_hash":"11f0534b","score_count":0,"novus_time":1.47676486E9,"title":"灰色中跟鞋","mark":"none","brand":"Holy Rape","status":"1","item_list":[{"status":"2","entity_id":"4645470","foreign_price":"0.00","shop_link":"http://shop104149703.taobao.com","cid":"50006843","price":980,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-22 01:02:34","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/537539015471/?type=mobile","origin_id":"537539015471","id":"3414992"}],"total_score":0,"item_id_list":["54c21867a2128a0711d970da"],"mark_value":0,"like_already":0,"old_root_category_id":9,"updated_time":1.47676486E9,"creator_id":1993256,"like_count":37,"category_id":"915"}
     */

    private List<CommentBean> comment;

    protected Comment(Parcel in) {
        comment = in.createTypedArrayList(CommentBean.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(comment);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    public List<CommentBean> getComment() {
        return comment;
    }

    public void setComment(List<CommentBean> comment) {
        this.comment = comment;
    }

    public static class CommentBean implements Parcelable{
        /**
         * entity_id : 4645470
         * post_time : 2016-10-18 18:18:08
         * user_id : 2010631
         * creator : {"is_censor":false,"avatar_large":"http://imgcdn.guoku.com/avatar/c687558aa4686ac725e0698678bb4e22.jpg","following_count":1,"avatar_small":"http://imgcdn.guoku.com/avatar/c687558aa4686ac725e0698678bb4e22.jpg","entity_note_count":2,"like_count":4,"relation":0,"dig_count":2,"authorized_author":false,"city":"朝阳","user_id":2010631,"fan_count":1,"nick":"Foreverbaby2","location":"北京","email":"337922184@qq.com","website":null,"bio":"(⊙o⊙)\u2026?","is_active":"1","nickname":"Foreverbaby2","tag_count":0,"gender":"M","mail_verified":false}
         * poker_id_list : []
         * is_selected : 0
         * poke_already : 0
         * updated_time : 1.476785888E9
         * content : 不好
         * comment_count : 0
         * note_id : 3861110
         * poke_count : 0
         * created_time : 1.476785888E9
         */

        private NoteBean note;
        /**
         * detail_images : ["http://imgcdn.guoku.com/images/bff246fb130cd7979f1b5636d39e1380.jpg","http://imgcdn.guoku.com/images/6a3b8cd457bb868a0d9c659973e799c4.jpg","http://imgcdn.guoku.com/images/6faf06b4783b5d138014e85ec8a33f83.jpg","http://imgcdn.guoku.com/images/ebfc4d948c6517a46d7451d6ff768f4f.jpg"]
         * entity_id : 4645470
         * weight : 0
         * note_count : 2
         * price : 980.00
         * intro :
         * created_time : 1.47676486E9
         * old_category_id : 152
         * chief_image : http://imgcdn.guoku.com/images/6c519fc8ce56c69752398dca7ec2ba8f.jpg
         * entity_hash : 11f0534b
         * score_count : 0
         * novus_time : 1.47676486E9
         * title : 灰色中跟鞋
         * mark : none
         * brand : Holy Rape
         * status : 1
         * item_list : [{"status":"2","entity_id":"4645470","foreign_price":"0.00","shop_link":"http://shop104149703.taobao.com","cid":"50006843","price":980,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-22 01:02:34","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/537539015471/?type=mobile","origin_id":"537539015471","id":"3414992"}]
         * total_score : 0
         * item_id_list : ["54c21867a2128a0711d970da"]
         * mark_value : 0
         * like_already : 0
         * old_root_category_id : 9
         * updated_time : 1.47676486E9
         * creator_id : 1993256
         * like_count : 37
         * category_id : 915
         */

        private EntityBean entity;

        protected CommentBean(Parcel in) {
            note = in.readParcelable(NoteBean.class.getClassLoader());
            entity = in.readParcelable(EntityBean.class.getClassLoader());
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(note, flags);
            dest.writeParcelable(entity, flags);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<CommentBean> CREATOR = new Creator<CommentBean>() {
            @Override
            public CommentBean createFromParcel(Parcel in) {
                return new CommentBean(in);
            }

            @Override
            public CommentBean[] newArray(int size) {
                return new CommentBean[size];
            }
        };

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

        public static class NoteBean implements Parcelable{
            private String entity_id;
            private String post_time;
            private String user_id;
            /**
             * is_censor : false
             * avatar_large : http://imgcdn.guoku.com/avatar/c687558aa4686ac725e0698678bb4e22.jpg
             * following_count : 1
             * avatar_small : http://imgcdn.guoku.com/avatar/c687558aa4686ac725e0698678bb4e22.jpg
             * entity_note_count : 2
             * like_count : 4
             * relation : 0
             * dig_count : 2
             * authorized_author : false
             * city : 朝阳
             * user_id : 2010631
             * fan_count : 1
             * nick : Foreverbaby2
             * location : 北京
             * email : 337922184@qq.com
             * website : null
             * bio : (⊙o⊙)…?
             * is_active : 1
             * nickname : Foreverbaby2
             * tag_count : 0
             * gender : M
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

            protected NoteBean(Parcel in) {
                entity_id = in.readString();
                post_time = in.readString();
                user_id = in.readString();
                creator = in.readParcelable(CreatorBean.class.getClassLoader());
                is_selected = in.readInt();
                poke_already = in.readInt();
                updated_time = in.readDouble();
                content = in.readString();
                comment_count = in.readInt();
                note_id = in.readInt();
                poke_count = in.readInt();
                created_time = in.readDouble();
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(entity_id);
                dest.writeString(post_time);
                dest.writeString(user_id);
                dest.writeParcelable(creator, flags);
                dest.writeInt(is_selected);
                dest.writeInt(poke_already);
                dest.writeDouble(updated_time);
                dest.writeString(content);
                dest.writeInt(comment_count);
                dest.writeInt(note_id);
                dest.writeInt(poke_count);
                dest.writeDouble(created_time);
            }

            @Override
            public int describeContents() {
                return 0;
            }

            public static final Creator<NoteBean> CREATOR = new Creator<NoteBean>() {
                @Override
                public NoteBean createFromParcel(Parcel in) {
                    return new NoteBean(in);
                }

                @Override
                public NoteBean[] newArray(int size) {
                    return new NoteBean[size];
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
                private Object website;
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
                    bio = in.readString();
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
                    dest.writeString(bio);
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

                public Object getWebsite() {
                    return website;
                }

                public void setWebsite(Object website) {
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

        public static class EntityBean implements Parcelable{
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
             * entity_id : 4645470
             * foreign_price : 0.00
             * shop_link : http://shop104149703.taobao.com
             * cid : 50006843
             * price : 980
             * origin_source : taobao.com
             * rank : 0
             * last_update : 2016-10-22 01:02:34
             * volume : 0
             * buy_link : http://api.guoku.com/mobile/v4/item/537539015471/?type=mobile
             * origin_id : 537539015471
             * id : 3414992
             */

            private List<ItemListBean> item_list;
            private List<String> item_id_list;

            protected EntityBean(Parcel in) {
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

            public static final Creator<EntityBean> CREATOR = new Creator<EntityBean>() {
                @Override
                public EntityBean createFromParcel(Parcel in) {
                    return new EntityBean(in);
                }

                @Override
                public EntityBean[] newArray(int size) {
                    return new EntityBean[size];
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
}

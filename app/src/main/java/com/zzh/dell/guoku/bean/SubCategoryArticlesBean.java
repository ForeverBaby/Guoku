package com.zzh.dell.guoku.bean;

import java.util.List;

/**
 * Created by Ishinagi_moeta on 2016/10/18.
 */
public class SubCategoryArticlesBean {


    /**
     * all_count : 164
     * is_sub : false
     */

    private StatBean stat;
    /**
     * read_count : 804
     * showcover : False
     * title : 为了迎接夏天，TOM FORD 和 PRADA 都推出了新款香水
     * url : /articles/4232/
     * feed_read_count : 1171
     * tags : ["美容","香水"]
     * cover : images/499cb1278443c6ce54a5b17eab4d11c0.jpeg
     * comment_count : 0
     * publish : 2
     * is_dig : false
     * content : 虽说天气还没真的热起来，但大家肯定都已经开始筹划夏天的时候应该穿些什么新衣服了。不过光有新衣服怎么行，在开季来瓶新的香水更能让你感觉焕然一新。这不，有两个品牌就瞄准了这个时机推出了新款香水。 首先是最近在美妆圈几乎被封神的 TOM FORD ，在 Neroli Portofino 香水系列中新增了 Acqua 和 Forte 两款香水。Neroli Portofino 的名字即来源于意大利的度假胜地，那么这两款新香水也必定和意大利有着联系：它们以意大利的里维埃拉海滩为灵感来源，TOM FORD 把这两款气味形容为「松脆且起泡的」怎么理解这个形容词？似乎就是清爽的夏日气味。两款新香均以奈若利橙花为主，其中 Acqua 融入了琥珀，Forte 融入了皮革和木质香。充满地中海风味的香气再加上水蓝色的玻璃方瓶包装，恐怕足以令不少人为之心动了。TOM FORD 就是这样，让人一边想剁手一边忍不住买买买。 除了号召力极强的 TOM FORD，PRADA 的招牌香水线 Candy Kiss 也增添了新成员，这是 Prada 时隔两年后再度更新 Candy Kiss 香水线。这款香水依旧由 Candy Kiss 系列以往产品的调香师 Daniela Andrier 配制，以麝香为主调，并且融入了橙花和香草的香气，简单持续的香气是这款香水的主要特色，将令人心旷神怡的气味不断重复制造出令人上瘾的感觉。如果你和这款香水一样有着洁净柔软的特质却又不想泯然于众，那么这款 PRADA 新推出的 Candy Kiss 新成员还是蛮值得你尝试的。它将在 4 月份上架美国，国内的上架时间大家可以先期待下。 不管你是长草上面的新香还是想试试那些你没试过的已经面世的香水，在夏天这个最为炎热的季节，你都有足够的理由为自己换一个崭新的气味，让自己焕然一新。
     * source : 0
     * creator : {"is_censor":false,"avatar_large":"http://imgcdn.guoku.com/avatar/da21a861cc431e1e2e5547795753adf6.jpg","following_count":0,"avatar_small":"http://imgcdn.guoku.com/avatar/da21a861cc431e1e2e5547795753adf6.jpg","entity_note_count":0,"like_count":0,"relation":0,"dig_count":0,"authorized_author":true,"city":"成都","user_id":1982854,"fan_count":654,"nick":"理想生活实验室","location":"四川","email":"36.wu@toodaylab.com","website":"","bio":"www.toodaylab.com / 关注创意设计与生活消费的媒体","is_active":"3","nickname":"理想生活实验室","tag_count":421,"gender":"M","mail_verified":false}
     * dig_count : 2
     * article_id : 4232
     * digest : 虽说天气还没真的热起来，但大家肯定都已经开始筹划夏天的时候应该穿些什么新衣服了。不过光有新衣服怎么行
     * identity_code : 1982854_e0f11556b1edb159b909dedc0ce63ed140a9731e_2016-03-15 00:00:00
     */

    private List<ArticlesBean> articles;

    public StatBean getStat() {
        return stat;
    }

    public void setStat(StatBean stat) {
        this.stat = stat;
    }

    public List<SubCategoryArticlesBean.ArticlesBean> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesBean> articles) {
        this.articles = articles;
    }

    public static class StatBean {
        private int all_count;
        private boolean is_sub;

        public int getAll_count() {
            return all_count;
        }

        public void setAll_count(int all_count) {
            this.all_count = all_count;
        }

        public boolean isIs_sub() {
            return is_sub;
        }

        public void setIs_sub(boolean is_sub) {
            this.is_sub = is_sub;
        }
    }

    public static class ArticlesBean {
        private String read_count;
        private String showcover;
        private String title;
        private String url;
        private String feed_read_count;
        private String cover;
        private int comment_count;
        private String publish;
        private boolean is_dig;
        private String content;
        private String source;
        /**
         * is_censor : false
         * avatar_large : http://imgcdn.guoku.com/avatar/da21a861cc431e1e2e5547795753adf6.jpg
         * following_count : 0
         * avatar_small : http://imgcdn.guoku.com/avatar/da21a861cc431e1e2e5547795753adf6.jpg
         * entity_note_count : 0
         * like_count : 0
         * relation : 0
         * dig_count : 0
         * authorized_author : true
         * city : 成都
         * user_id : 1982854
         * fan_count : 654
         * nick : 理想生活实验室
         * location : 四川
         * email : 36.wu@toodaylab.com
         * website :
         * bio : www.toodaylab.com / 关注创意设计与生活消费的媒体
         * is_active : 3
         * nickname : 理想生活实验室
         * tag_count : 421
         * gender : M
         * mail_verified : false
         */

        private CreatorBean creator;
        private int dig_count;
        private int article_id;
        private String digest;
        private String identity_code;
        private List<String> tags;

        public String getRead_count() {
            return read_count;
        }

        public void setRead_count(String read_count) {
            this.read_count = read_count;
        }

        public String getShowcover() {
            return showcover;
        }

        public void setShowcover(String showcover) {
            this.showcover = showcover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFeed_read_count() {
            return feed_read_count;
        }

        public void setFeed_read_count(String feed_read_count) {
            this.feed_read_count = feed_read_count;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public String getPublish() {
            return publish;
        }

        public void setPublish(String publish) {
            this.publish = publish;
        }

        public boolean isIs_dig() {
            return is_dig;
        }

        public void setIs_dig(boolean is_dig) {
            this.is_dig = is_dig;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public int getDig_count() {
            return dig_count;
        }

        public void setDig_count(int dig_count) {
            this.dig_count = dig_count;
        }

        public int getArticle_id() {
            return article_id;
        }

        public void setArticle_id(int article_id) {
            this.article_id = article_id;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getIdentity_code() {
            return identity_code;
        }

        public void setIdentity_code(String identity_code) {
            this.identity_code = identity_code;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
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
}

package com.zzh.dell.guoku.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ishinagi_moeta on 2016/10/17.
 */
public class CategoryMainBean {

    /**
     * user : {"avatar_large":"http://imgcdn.guoku.com/avatar/da21a861cc431e1e2e5547795753adf6.jpg","following_count":0,"avatar_small":"http://imgcdn.guoku.com/avatar/da21a861cc431e1e2e5547795753adf6.jpg","entity_note_count":0,"like_count":0,"relation":0,"dig_count":0,"authorized_author":true,"city":"成都","user_id":1982854,"fan_count":653,"article_count":960,"nick":"理想生活实验室","location":"四川","email":"36.wu@toodaylab.com","website":"","bio":"www.toodaylab.com / 关注创意设计与生活消费的媒体","is_active":"3","authorized_seller":false,"nickname":"理想生活实验室","tag_count":410,"gender":"M","mail_verified":false}
     */

    private List<AuthorizeduserBean> authorizeduser;
    /**
     * article : {"read_count":731,"pub_time":null,"creator":{"avatar_large":"http://imgcdn.guoku.com/avatar/55ab15b11149bbc76b9b5de21a2cf387.jpg","following_count":0,"avatar_small":"http://imgcdn.guoku.com/avatar/55ab15b11149bbc76b9b5de21a2cf387.jpg","entity_note_count":0,"sina_screen_name":null,"like_count":3,"relation":0,"dig_count":0,"authorized_author":1,"city":"昌平","user_id":1998462,"fan_count":16,"article_count":171,"nick":"好奇心研究所","location":"北京","wechat_nick":null,"email":"haoqixinyanjiusuo@guoku.com","website":"","bio":"来自「好奇心日报」的一个常年发布突破性研究且颇具气质的公众号。","is_active":1,"authorized_seller":0,"nickname":"好奇心研究所","tag_count":48,"taobao_nick":null,"gender":"M","mail_verified":false},"url":"/articles/136101/","title":"如何在大型超市里找到最快的结账队伍？","cover":"images/924da6b77c9fe5dd9ae0b9e0967c98a3.jpeg","publish":2,"is_dig":false,"content":"<div class=\"rich_media_content \" id=\"js_content\">\r\n    <p style=\"line-height: 1.75em;\">去大超市购物最令人绝望的时刻就是，你以为进去随便买包厕纸最多只要 10 分钟就够了，结果总是在结账区遭遇国庆旅游景点入口的人流量，这种时候，你也只能一边懊恼怎么就又忘了上次的教训，一边迅速判断哪条队伍最快，寻找绝处逢生的机会。<br><\/p>\r\n    <p style=\"line-height: 1.75em;\">《纽约时报》的记者 Christopher Mele 依据一些「排队心理学/经济学」研究者们的调查结果提供了几条判断的方法 ，我们结合自己的观察为你整理了下面四条：<br><\/p>\r\n    <p style=\"line-height: 1.75em;\"><span style=\"font-weight: bold;\">排在一个购物车装满了的人后边<\/span><br><\/p>\r\n    <p style=\"line-height: 1.75em;\">\r\n\r\n        排队时我们通常会避开那些把购物车装得满满当当的大采购型顾客，跟在一个稍长一点的队伍后面似乎会更快些。不过数据显示这个感觉不一定对。\r\n\r\n    <\/p>\r\n    <p style=\"line-height: 1.75em;\">前高中数学老师，现在是 Desmos（一家致力于让数学变有趣的图表公司）学术总监的 Dan Meyer 做过一项调查，他发现，平均每个人顾客经过结账通道的时间是 41 秒，这包括了除了商品扫描，顾客收银员打招呼、付款、找零以及最后和收银员道谢说再见的一系列动作，而平均每个商品通过扫描的时间是 3 秒。<\/p>\r\n    <p style=\"line-height: 1.75em;\">\r\n\r\n        如果做个简单的计算，一个买了 100 样商品的人通过收银台的时间不到 6 分钟，而四个拿了 20 样商品的顾客需要的时间则是 7 分多钟。<\/p>\r\n    <p style=\"line-height: 1.75em;\">\r\n\r\n        当然，你很难预知那一个人会不会在结账的时候选择刷卡试了两张都发余额不足，终于付款成功时又因为名字特别长签了老半天，又或者这个麻烦的支付困难者会出现在那四个人里也不一定。这里只是提醒你，不用特意避开购物车太满的人，有时候可能跟在他们身后更快些。\r\n\r\n    <\/p>\r\n    <p style=\"line-height: 1.75em;\"><span style=\"font-weight: bold;\">去左边的收银台<\/span><br><\/p>\r\n    <p style=\"line-height: 1.75em;\">\r\n\r\n        大型超市里繁忙时段有二三十个收银台同时结账，别说进行上面的计算了，电光火石之间你恐怕都无法判断到底去哪个方向能找到短点的队伍。<\/p>\r\n    <p style=\"line-height: 1.75em;\">\r\n\r\n        Same Ole Line Dudes （一家提供代人排队业务的 app）的创始人 Robert Samuel 说，大部分人都是右撇子，而他们一般会下意识选择右转。所以在看不到两边排队形势的时候，不如先左转试试。\r\n\r\n    <\/p>\r\n    <p style=\"line-height: 1.75em;\"><span style=\"font-weight: bold;\">别去一眼看不到收银员的通道&nbsp;<\/span><br><\/p>\r\n    <p style=\"line-height: 1.75em;\">\r\n\r\n        如果有队伍和收银台之间有墙或货架什么的障碍物，收银员会看不到你，以及排在你身前身后的很多人，华盛顿大学的一项研究显示，收银员在准确知道顾客数目很多的时候手脚才会更麻利些。\r\n\r\n    <\/p>\r\n    <p style=\"line-height: 1.75em;\"><span style=\"font-weight: bold;\">研究排在你前面的人&nbsp;<\/span><br><\/p>\r\n    <p style=\"line-height: 1.75em;\">\r\n\r\n        不止是他们的人数，还包括他们的年龄以及他们买了些啥。\r\n\r\n    <\/p>\r\n    <p style=\"line-height: 1.75em;\">买了六瓶可乐的显然比买了六种不同商品的人结账快，上了些年纪的顾客会则可能会在支付时搞错刷卡的方式或者忘记密码什么的。不过这些显然你已经有经验应付并且也能充分体量了，根据好奇心研究所的观察，在手机支付的时代里另外一种人可能更值得警惕\u2014\u2014<br><\/p>\r\n    <p style=\"line-height: 1.75em;\">\r\n\r\n        他们会直到收银员收好所有商品说「一共四十五块七刷卡还是现金」的时候，才镇定地掏出手机解锁打开支付宝/微信找到支付页等待支付码刷出来、视身后十几个狂躁的顾客如过眼云烟。\r\n\r\n    <\/p>\r\n    <p style=\"line-height: 1.75em;\">快速结账的秘诀之一就是避开这种人，只有把钱包或手机捏在手里的人才是你可以信赖的小天使。啊对了，那种一直对着手机痴笑的人也要留意，他们恋恋不舍离开聊天界面/视频播放器/阅读进度 52% 的《校花的贴身高手》然后调出付款二维码的速度也不会快到哪里去。<br><\/p>\r\n    <p style=\"line-height: 1.75em;\">总得来说，除了运气之外，你可能还需要懂一点心算、博弈论和心理学。某种程度上看来，一切等待都是发生在你脑袋里的精神游戏，研究显示，人们平均会将自己的等待时长高估 36%。说起来也只是十几分钟的结账过程，但感觉上总是觉得等有半辈子那么久，而且仅是分秒的差距但我们还是会对自己队伍的缓慢行进感到痛心疾首，后悔两分钟前做出了错误的选择。<br><\/p>\r\n    <p style=\"line-height: 1.75em;\">\r\n\r\n        <br>\r\n\r\n    <\/p>\r\n    <p>\r\n        <img data-ratio=\"0.6072144288577155\" data-src=\"http://imgcdn.guoku.com/images/c90bdc8ef6313dc29e2426781a8f6c08.jpg\" data-type=\"gif\" data-w=\"499\" src=\"http://imgcdn.guoku.com/images/c90bdc8ef6313dc29e2426781a8f6c08.jpg\"><\/p>\r\n    <p><br><\/p>\r\n    <p>行进速度这事挺微妙的，根据欧洲工商管理学院 Ziv Carmon 教授和普林斯顿大学 Daniel Kahneman 教授的研究报告，面对一条快速移动的长队和一条相对短但是行进也相对慢的队伍，人们总是倾向于选短的而不是快的那条，尽管等待时间是差不多长的。<\/p>\r\n    <p style=\"line-height: 1.75em;\">关于排队的心理学还有一个不算新鲜的发现，当你的注意力没那么集中在排队这件事上时，等待时间就会显得短一点，觉得焦躁的时候，跟身边朋友（前提是得刚好有一个）聊聊天或者翻翻货架上的商品说明什么的，别管隔壁队伍那个跟你同时排队的人是不是已经比你靠前好几步了。<br><\/p>\r\n    <p style=\"line-height: 1.75em;\">最最重要的是，千万不要抱有「我的队伍总是最慢，我换了一排还是最慢，也没人排我后头」、「我就是拥有那种令人无语的倒霉体质」的念头，因为事实上那些顺滑的排队体验总是容易被忽略不计，而一旦你怀有这种被诅咒了的念头，事情总会向你想的那个方向发展的。真的。<br><\/p>\r\n<\/div>","comment_count":0,"tags":["居家","收银台","结账","超市"],"dig_count":3,"article_id":136101,"digest":"去大超市购物最令人绝望的时刻就是，你以为进去随便买包厕纸最多只要10分钟就够了，结果总是在结账区遭遇"}
     */

    private List<ArticlesBean> articles;
    /**
     * url : guoku://entity/4644664
     * img : http://imgcdn.guoku.com/images/4d7bac582d1e67cbbcc28634c10c0513.jpeg
     */

    private List<BannerBean> banner;
    /**
     * category : {"status":"True","id":"1","cover_url":"http://imgcdn.guoku.com/images/91cf56bcc708c6e68948a20f3442ed9a.jpeg","title":"居家 LIVING"}
     */

    private List<CategoriesBean> categories;
    /**
     * entity : {"status":"1","detail_images":["http://imgcdn.guoku.com/images/a77260d50553d0ac40fc6e7f8338c149.jpg","http://imgcdn.guoku.com/images/19703e5da952e562f79858329ac7cdad.jpg","http://imgcdn.guoku.com/images/77f6e2957644c3ee05f61f8f2cc69e77.jpg"],"entity_id":4645342,"updated_time":1.47660268E9,"title":"蓝色系腕表","note_count":1,"brand":"Simple Watch","like_count":68,"item_list":[{"status":"2","entity_id":"4645342","foreign_price":"0.00","shop_link":"http://shop68446316.taobao.com","cid":"50468001","default":"True","price":1108,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-17 02:00:06","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/539851629219/?type=mobile","origin_id":"539851629219","id":"3414864"}],"mark":"0","price":"1108.00","created_time":1.47660268E9,"creator_id":1993256,"intro":"","chief_image":"http://imgcdn.guoku.com/images/d57503f57d54f051e250e6d478384ff5.jpg","category_id":"655","like_already":0,"total_score":0,"entity_hash":"da92bba1"}
     */

    private List<EntitiesBean> entities;

    public List<AuthorizeduserBean> getAuthorizeduser() {
        return authorizeduser;
    }

    public void setAuthorizeduser(List<AuthorizeduserBean> authorizeduser) {
        this.authorizeduser = authorizeduser;
    }

    public List<ArticlesBean> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesBean> articles) {
        this.articles = articles;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public List<EntitiesBean> getEntities() {
        return entities;
    }

    public void setEntities(List<EntitiesBean> entities) {
        this.entities = entities;
    }

    public static class AuthorizeduserBean {
        /**
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
         * fan_count : 653
         * article_count : 960
         * nick : 理想生活实验室
         * location : 四川
         * email : 36.wu@toodaylab.com
         * website :
         * bio : www.toodaylab.com / 关注创意设计与生活消费的媒体
         * is_active : 3
         * authorized_seller : false
         * nickname : 理想生活实验室
         * tag_count : 410
         * gender : M
         * mail_verified : false
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
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
            private int article_count;
            private String nick;
            private String location;
            private String email;
            private String website;
            private String bio;
            private String is_active;
            private boolean authorized_seller;
            private String nickname;
            private int tag_count;
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

    public static class ArticlesBean implements Parcelable{
        /**
         * read_count : 731
         * pub_time : null
         * creator : {"avatar_large":"http://imgcdn.guoku.com/avatar/55ab15b11149bbc76b9b5de21a2cf387.jpg","following_count":0,"avatar_small":"http://imgcdn.guoku.com/avatar/55ab15b11149bbc76b9b5de21a2cf387.jpg","entity_note_count":0,"sina_screen_name":null,"like_count":3,"relation":0,"dig_count":0,"authorized_author":1,"city":"昌平","user_id":1998462,"fan_count":16,"article_count":171,"nick":"好奇心研究所","location":"北京","wechat_nick":null,"email":"haoqixinyanjiusuo@guoku.com","website":"","bio":"来自「好奇心日报」的一个常年发布突破性研究且颇具气质的公众号。","is_active":1,"authorized_seller":0,"nickname":"好奇心研究所","tag_count":48,"taobao_nick":null,"gender":"M","mail_verified":false}
         * url : /articles/136101/
         * title : 如何在大型超市里找到最快的结账队伍？
         * cover : images/924da6b77c9fe5dd9ae0b9e0967c98a3.jpeg
         * publish : 2
         * is_dig : false
         * content : <div class="rich_media_content " id="js_content">
         <p style="line-height: 1.75em;">去大超市购物最令人绝望的时刻就是，你以为进去随便买包厕纸最多只要 10 分钟就够了，结果总是在结账区遭遇国庆旅游景点入口的人流量，这种时候，你也只能一边懊恼怎么就又忘了上次的教训，一边迅速判断哪条队伍最快，寻找绝处逢生的机会。<br></p>
         <p style="line-height: 1.75em;">《纽约时报》的记者 Christopher Mele 依据一些「排队心理学/经济学」研究者们的调查结果提供了几条判断的方法 ，我们结合自己的观察为你整理了下面四条：<br></p>
         <p style="line-height: 1.75em;"><span style="font-weight: bold;">排在一个购物车装满了的人后边</span><br></p>
         <p style="line-height: 1.75em;">

         排队时我们通常会避开那些把购物车装得满满当当的大采购型顾客，跟在一个稍长一点的队伍后面似乎会更快些。不过数据显示这个感觉不一定对。

         </p>
         <p style="line-height: 1.75em;">前高中数学老师，现在是 Desmos（一家致力于让数学变有趣的图表公司）学术总监的 Dan Meyer 做过一项调查，他发现，平均每个人顾客经过结账通道的时间是 41 秒，这包括了除了商品扫描，顾客收银员打招呼、付款、找零以及最后和收银员道谢说再见的一系列动作，而平均每个商品通过扫描的时间是 3 秒。</p>
         <p style="line-height: 1.75em;">

         如果做个简单的计算，一个买了 100 样商品的人通过收银台的时间不到 6 分钟，而四个拿了 20 样商品的顾客需要的时间则是 7 分多钟。</p>
         <p style="line-height: 1.75em;">

         当然，你很难预知那一个人会不会在结账的时候选择刷卡试了两张都发余额不足，终于付款成功时又因为名字特别长签了老半天，又或者这个麻烦的支付困难者会出现在那四个人里也不一定。这里只是提醒你，不用特意避开购物车太满的人，有时候可能跟在他们身后更快些。

         </p>
         <p style="line-height: 1.75em;"><span style="font-weight: bold;">去左边的收银台</span><br></p>
         <p style="line-height: 1.75em;">

         大型超市里繁忙时段有二三十个收银台同时结账，别说进行上面的计算了，电光火石之间你恐怕都无法判断到底去哪个方向能找到短点的队伍。</p>
         <p style="line-height: 1.75em;">

         Same Ole Line Dudes （一家提供代人排队业务的 app）的创始人 Robert Samuel 说，大部分人都是右撇子，而他们一般会下意识选择右转。所以在看不到两边排队形势的时候，不如先左转试试。

         </p>
         <p style="line-height: 1.75em;"><span style="font-weight: bold;">别去一眼看不到收银员的通道&nbsp;</span><br></p>
         <p style="line-height: 1.75em;">

         如果有队伍和收银台之间有墙或货架什么的障碍物，收银员会看不到你，以及排在你身前身后的很多人，华盛顿大学的一项研究显示，收银员在准确知道顾客数目很多的时候手脚才会更麻利些。

         </p>
         <p style="line-height: 1.75em;"><span style="font-weight: bold;">研究排在你前面的人&nbsp;</span><br></p>
         <p style="line-height: 1.75em;">

         不止是他们的人数，还包括他们的年龄以及他们买了些啥。

         </p>
         <p style="line-height: 1.75em;">买了六瓶可乐的显然比买了六种不同商品的人结账快，上了些年纪的顾客会则可能会在支付时搞错刷卡的方式或者忘记密码什么的。不过这些显然你已经有经验应付并且也能充分体量了，根据好奇心研究所的观察，在手机支付的时代里另外一种人可能更值得警惕——<br></p>
         <p style="line-height: 1.75em;">

         他们会直到收银员收好所有商品说「一共四十五块七刷卡还是现金」的时候，才镇定地掏出手机解锁打开支付宝/微信找到支付页等待支付码刷出来、视身后十几个狂躁的顾客如过眼云烟。

         </p>
         <p style="line-height: 1.75em;">快速结账的秘诀之一就是避开这种人，只有把钱包或手机捏在手里的人才是你可以信赖的小天使。啊对了，那种一直对着手机痴笑的人也要留意，他们恋恋不舍离开聊天界面/视频播放器/阅读进度 52% 的《校花的贴身高手》然后调出付款二维码的速度也不会快到哪里去。<br></p>
         <p style="line-height: 1.75em;">总得来说，除了运气之外，你可能还需要懂一点心算、博弈论和心理学。某种程度上看来，一切等待都是发生在你脑袋里的精神游戏，研究显示，人们平均会将自己的等待时长高估 36%。说起来也只是十几分钟的结账过程，但感觉上总是觉得等有半辈子那么久，而且仅是分秒的差距但我们还是会对自己队伍的缓慢行进感到痛心疾首，后悔两分钟前做出了错误的选择。<br></p>
         <p style="line-height: 1.75em;">

         <br>

         </p>
         <p>
         <img data-ratio="0.6072144288577155" data-src="http://imgcdn.guoku.com/images/c90bdc8ef6313dc29e2426781a8f6c08.jpg" data-type="gif" data-w="499" src="http://imgcdn.guoku.com/images/c90bdc8ef6313dc29e2426781a8f6c08.jpg"></p>
         <p><br></p>
         <p>行进速度这事挺微妙的，根据欧洲工商管理学院 Ziv Carmon 教授和普林斯顿大学 Daniel Kahneman 教授的研究报告，面对一条快速移动的长队和一条相对短但是行进也相对慢的队伍，人们总是倾向于选短的而不是快的那条，尽管等待时间是差不多长的。</p>
         <p style="line-height: 1.75em;">关于排队的心理学还有一个不算新鲜的发现，当你的注意力没那么集中在排队这件事上时，等待时间就会显得短一点，觉得焦躁的时候，跟身边朋友（前提是得刚好有一个）聊聊天或者翻翻货架上的商品说明什么的，别管隔壁队伍那个跟你同时排队的人是不是已经比你靠前好几步了。<br></p>
         <p style="line-height: 1.75em;">最最重要的是，千万不要抱有「我的队伍总是最慢，我换了一排还是最慢，也没人排我后头」、「我就是拥有那种令人无语的倒霉体质」的念头，因为事实上那些顺滑的排队体验总是容易被忽略不计，而一旦你怀有这种被诅咒了的念头，事情总会向你想的那个方向发展的。真的。<br></p>
         </div>
         * comment_count : 0
         * tags : ["居家","收银台","结账","超市"]
         * dig_count : 3
         * article_id : 136101
         * digest : 去大超市购物最令人绝望的时刻就是，你以为进去随便买包厕纸最多只要10分钟就够了，结果总是在结账区遭遇
         */

        private ArticleBean article;

        protected ArticlesBean(Parcel in) {
            article = in.readParcelable(ArticleBean.class.getClassLoader());
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(article, flags);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<ArticlesBean> CREATOR = new Creator<ArticlesBean>() {
            @Override
            public ArticlesBean createFromParcel(Parcel in) {
                return new ArticlesBean(in);
            }

            @Override
            public ArticlesBean[] newArray(int size) {
                return new ArticlesBean[size];
            }
        };

        public ArticleBean getArticle() {
            return article;
        }

        public void setArticle(ArticleBean article) {
            this.article = article;
        }

        public static class ArticleBean implements Parcelable{
            private int read_count;
            private Object pub_time;
            /**
             * avatar_large : http://imgcdn.guoku.com/avatar/55ab15b11149bbc76b9b5de21a2cf387.jpg
             * following_count : 0
             * avatar_small : http://imgcdn.guoku.com/avatar/55ab15b11149bbc76b9b5de21a2cf387.jpg
             * entity_note_count : 0
             * sina_screen_name : null
             * like_count : 3
             * relation : 0
             * dig_count : 0
             * authorized_author : 1
             * city : 昌平
             * user_id : 1998462
             * fan_count : 16
             * article_count : 171
             * nick : 好奇心研究所
             * location : 北京
             * wechat_nick : null
             * email : haoqixinyanjiusuo@guoku.com
             * website :
             * bio : 来自「好奇心日报」的一个常年发布突破性研究且颇具气质的公众号。
             * is_active : 1
             * authorized_seller : 0
             * nickname : 好奇心研究所
             * tag_count : 48
             * taobao_nick : null
             * gender : M
             * mail_verified : false
             */

            private CreatorBean creator;
            private String url;
            private String title;
            private String cover;
            private int publish;
            private boolean is_dig;
            private String content;
            private int comment_count;
            private int dig_count;
            private int article_id;
            private String digest;
            private List<String> tags;

            protected ArticleBean(Parcel in) {
                read_count = in.readInt();
                creator = in.readParcelable(CreatorBean.class.getClassLoader());
                url = in.readString();
                title = in.readString();
                cover = in.readString();
                publish = in.readInt();
                is_dig = in.readByte() != 0;
                content = in.readString();
                comment_count = in.readInt();
                dig_count = in.readInt();
                article_id = in.readInt();
                digest = in.readString();
                tags = in.createStringArrayList();
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(read_count);
                dest.writeParcelable(creator, flags);
                dest.writeString(url);
                dest.writeString(title);
                dest.writeString(cover);
                dest.writeInt(publish);
                dest.writeByte((byte) (is_dig ? 1 : 0));
                dest.writeString(content);
                dest.writeInt(comment_count);
                dest.writeInt(dig_count);
                dest.writeInt(article_id);
                dest.writeString(digest);
                dest.writeStringList(tags);
            }

            @Override
            public int describeContents() {
                return 0;
            }

            public static final Creator<ArticleBean> CREATOR = new Creator<ArticleBean>() {
                @Override
                public ArticleBean createFromParcel(Parcel in) {
                    return new ArticleBean(in);
                }

                @Override
                public ArticleBean[] newArray(int size) {
                    return new ArticleBean[size];
                }
            };

            public int getRead_count() {
                return read_count;
            }

            public void setRead_count(int read_count) {
                this.read_count = read_count;
            }

            public Object getPub_time() {
                return pub_time;
            }

            public void setPub_time(Object pub_time) {
                this.pub_time = pub_time;
            }

            public CreatorBean getCreator() {
                return creator;
            }

            public void setCreator(CreatorBean creator) {
                this.creator = creator;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getPublish() {
                return publish;
            }

            public void setPublish(int publish) {
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

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
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

            public List<String> getTags() {
                return tags;
            }

            public void setTags(List<String> tags) {
                this.tags = tags;
            }

            public static class CreatorBean implements Parcelable{
                private String avatar_large;
                private int following_count;
                private String avatar_small;
                private int entity_note_count;
                private Object sina_screen_name;
                private int like_count;
                private int relation;
                private int dig_count;
                private int authorized_author;
                private String city;
                private int user_id;
                private int fan_count;
                private int article_count;
                private String nick;
                private String location;
                private Object wechat_nick;
                private String email;
                private String website;
                private String bio;
                private int is_active;
                private int authorized_seller;
                private String nickname;
                private int tag_count;
                private Object taobao_nick;
                private String gender;
                private boolean mail_verified;

                protected CreatorBean(Parcel in) {
                    avatar_large = in.readString();
                    following_count = in.readInt();
                    avatar_small = in.readString();
                    entity_note_count = in.readInt();
                    like_count = in.readInt();
                    relation = in.readInt();
                    dig_count = in.readInt();
                    authorized_author = in.readInt();
                    city = in.readString();
                    user_id = in.readInt();
                    fan_count = in.readInt();
                    article_count = in.readInt();
                    nick = in.readString();
                    location = in.readString();
                    email = in.readString();
                    website = in.readString();
                    bio = in.readString();
                    is_active = in.readInt();
                    authorized_seller = in.readInt();
                    nickname = in.readString();
                    tag_count = in.readInt();
                    gender = in.readString();
                    mail_verified = in.readByte() != 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(avatar_large);
                    dest.writeInt(following_count);
                    dest.writeString(avatar_small);
                    dest.writeInt(entity_note_count);
                    dest.writeInt(like_count);
                    dest.writeInt(relation);
                    dest.writeInt(dig_count);
                    dest.writeInt(authorized_author);
                    dest.writeString(city);
                    dest.writeInt(user_id);
                    dest.writeInt(fan_count);
                    dest.writeInt(article_count);
                    dest.writeString(nick);
                    dest.writeString(location);
                    dest.writeString(email);
                    dest.writeString(website);
                    dest.writeString(bio);
                    dest.writeInt(is_active);
                    dest.writeInt(authorized_seller);
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

                public Object getSina_screen_name() {
                    return sina_screen_name;
                }

                public void setSina_screen_name(Object sina_screen_name) {
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

                public int getAuthorized_author() {
                    return authorized_author;
                }

                public void setAuthorized_author(int authorized_author) {
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

                public Object getWechat_nick() {
                    return wechat_nick;
                }

                public void setWechat_nick(Object wechat_nick) {
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

                public int getIs_active() {
                    return is_active;
                }

                public void setIs_active(int is_active) {
                    this.is_active = is_active;
                }

                public int getAuthorized_seller() {
                    return authorized_seller;
                }

                public void setAuthorized_seller(int authorized_seller) {
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

                public Object getTaobao_nick() {
                    return taobao_nick;
                }

                public void setTaobao_nick(Object taobao_nick) {
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
        }
    }

    public static class BannerBean {
        private String url;
        private String img;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }

    public static class CategoriesBean {
        /**
         * status : True
         * id : 1
         * cover_url : http://imgcdn.guoku.com/images/91cf56bcc708c6e68948a20f3442ed9a.jpeg
         * title : 居家 LIVING
         */

        private CategoryBean category;

        public CategoryBean getCategory() {
            return category;
        }

        public void setCategory(CategoryBean category) {
            this.category = category;
        }

        public static class CategoryBean {
            private String status;
            private String id;
            private String cover_url;
            private String title;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCover_url() {
                return cover_url;
            }

            public void setCover_url(String cover_url) {
                this.cover_url = cover_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }

    public static class EntitiesBean {
        /**
         * status : 1
         * detail_images : ["http://imgcdn.guoku.com/images/a77260d50553d0ac40fc6e7f8338c149.jpg","http://imgcdn.guoku.com/images/19703e5da952e562f79858329ac7cdad.jpg","http://imgcdn.guoku.com/images/77f6e2957644c3ee05f61f8f2cc69e77.jpg"]
         * entity_id : 4645342
         * updated_time : 1.47660268E9
         * title : 蓝色系腕表
         * note_count : 1
         * brand : Simple Watch
         * like_count : 68
         * item_list : [{"status":"2","entity_id":"4645342","foreign_price":"0.00","shop_link":"http://shop68446316.taobao.com","cid":"50468001","default":"True","price":1108,"origin_source":"taobao.com","rank":"0","last_update":"2016-10-17 02:00:06","volume":"0","buy_link":"http://api.guoku.com/mobile/v4/item/539851629219/?type=mobile","origin_id":"539851629219","id":"3414864"}]
         * mark : 0
         * price : 1108.00
         * created_time : 1.47660268E9
         * creator_id : 1993256
         * intro :
         * chief_image : http://imgcdn.guoku.com/images/d57503f57d54f051e250e6d478384ff5.jpg
         * category_id : 655
         * like_already : 0
         * total_score : 0
         * entity_hash : da92bba1
         */

        private EntityBean entity;

        public EntityBean getEntity() {
            return entity;
        }

        public void setEntity(EntityBean entity) {
            this.entity = entity;
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
             * entity_id : 4645342
             * foreign_price : 0.00
             * shop_link : http://shop68446316.taobao.com
             * cid : 50468001
             * default : True
             * price : 1108
             * origin_source : taobao.com
             * rank : 0
             * last_update : 2016-10-17 02:00:06
             * volume : 0
             * buy_link : http://api.guoku.com/mobile/v4/item/539851629219/?type=mobile
             * origin_id : 539851629219
             * id : 3414864
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
    }
}

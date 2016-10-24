package com.zzh.dell.guoku.config;

import android.os.Environment;

/**
 * 接口类
 * Created by DELL on 2016/10/15.
 */
public final class Contants {

    public static final String API_KEY = "0b19c2b93687347e95c6b6f5cc91bb87";
    /**
     * 注册
     */
    public static final String REGISTER = "http://api.guoku.com/mobile/v4/register/";
    public static final String REGIDTERTYPE = "register";

    /**
     * 登录
     */
    public static final String LOGIN = "http://api.guoku.com/mobile/v4/login/";
    public static final String LOGINTYPE = "login";

    public static final String FORGET = "http://api.guoku.com/mobile/v4/forget/password/";
    public static final String FORGETTYPE = "forget";

    /**
     * 分类总接口
     * type:    CategoryGet
     */
    public static final String CATEGORY_PATH = "http://api.guoku.com/mobile/v4/category/";
    /**
     * 分类界面总接口
     * type:    CategoryFragment
     */
    public static final String CATEGORY_MAIN_PATH = "http://api.guoku.com/mobile/v4/discover/";

    /**
     * 子品类页面图文接口
     * type:    SubCategoryArticles
     */
    public static final String SUBCATEGORYARTICLES_PATH = "http://api.guoku.com/mobile/v4/category/sub/%s/articles/";

    /**
     * 子品类页面商品接口
     * type:    SubCategorySelection
     * SubCategorySelectionRefres
     * SubCategorySelectionUpdata
     */
    public static final String SUBCATEGORYSELECTION_PATH = "http://api.guoku.com/mobile/v4/category/%s/entity/";

    /**
     * 品类页面图文接口
     * type:    CategoryArticles
     * SubCategoryArticlesRefresh
     */
    public static final String CATEGORYARTICLES_PATH = "http://api.guoku.com/mobile/v4/category/%s/articles/";

    /**
     * 品类页面商品接口
     * type:    CategorySelection
     */
    public static final String CATEGORYSELECTION_PATH = "http://api.guoku.com/mobile/v4/category/%s/selection/";

    /**
     * 搜索商品接口
     */
    public static final String SEARCH_ENTITY_PATH = "http://api.guoku.com/mobile/v4/entity/search/";

    /**
     * 搜索图文接口
     */
    public static final String SEARCH_ARTICLES_PATH = "http://api.guoku.com/mobile/v4/articles/search/";

    /**
     * 搜索用户接口
     */
    public static final String SEARCH_USER_PATH = "http://api.guoku.com/mobile/v4/user/search/";

    /**
     * 果库的图片库
     */
    public static final String IMAGE_PATH = "http://imgcdn.guoku.com";
    /**
     * 邮箱
     */
    public static final String EMAIL_VER = "http://api.guoku.com/mobile/v4/user/email/verified/";
    public static final String EMAIL_VER_TYPE = "email_send";

    public static final String EMAIL_UPDATE = "http://api.guoku.com/mobile/v4/user/update/email/";
    public static final String EMAIL_UPDATE_T = "update";
    public static final String PASS_CHANGE = "http://api.guoku.com/mobile/v4/user/reset/password/";
    public static final String PASS_TYPE = "pass";

    public static String IMAGES_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/GuoKu/" + "/images/";


    /**
     * SharedPreferenced类
     */
    //用户信息
    public static final String SP_USERINFO = "sp_userinfo";
    public static final String SP_CODEPIC = "SP_CODEPIC";
    public static final String SP_FIRST_INTO = "sp_first_into";
    public static final String SP_KEY = "sp_key";

    /**
     * 动态的
     */
    public static final String DYNAMIC_PATH = "http://api.guoku.com/mobile/v4/feed/";

    public static final String IMAGE_TEXT_DETAIL = "http://m.guoku.com/articles/";


    /**
     * 消息的
     */
    public static final String MESSAGE_PATH = "http://api.guoku.com/mobile/v4/message/";

    /**
     * 商品界面
     */
    public static final String GOODS_PATH = "http://api.guoku.com/mobile/v4/selection/";
    /**
     * 图文界面
     */
    public static final String IMAGE_TEXT_PATH = "http://api.guoku.com/mobile/v4/articles/";

    /**
     * 图片地址（只有后半部分）的头部
     */
    public static final String IMAGE_TOP_PATH = "http://imgcdn.guoku.com/";

    /**
     * 商品详情页
     */
    public static final String GOODS_DETAIL = "http://api.guoku.com/mobile/v4/entity/";
    /**
     * 商品广告
     */
    public static final String GOODS_AD = "http://api.guoku.com/mobile/v4/entity/guess/";

}

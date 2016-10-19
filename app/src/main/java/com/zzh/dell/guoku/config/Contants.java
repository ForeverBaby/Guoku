package com.zzh.dell.guoku.config;

/**
 * Created by DELL on 2016/10/15.
 */
public final class Contants {
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

    public static final String  FORGET = "http://api.guoku.com/mobile/v4/forget/password/";
    public static final String FORGETTYPE = "forget";
    /**
     * 分类界面总接口
     */
    public static final String CATEGORY_MAIN_PATH = "http://api.guoku.com/mobile/v4/discover/?sign=%s&api_key=%s";

    /**
     * 子品类页面图文接口
     * type:    SubCategoryArticles
     */
    public static final String SUBCATEGORYARTICLES_PATH = "http://api.guoku.com/mobile/v4/category/sub/%s/articles/?page=%s&size=%s&sign=%s&api_key=%s";

    /**
     * 子品类页面商品接口
     * type:    SubCategorySelection
     *          SubCategorySelectionRefres
     *          SubCategorySelectionUpdata
     */
    public static final String SUBCATEGORYSELECTION_PATH = "http://api.guoku.com/mobile/v4/category/%s/entity/?offset=%s&count=%s&reverse=%s&sort=%s&sign=%s&api_key=%s";

    /**
     * 品类页面图文接口
     * type:    CategoryArticles
     *          SubCategoryArticlesRefresh
     */
    public static final String CATEGORYARTICLES_PATH = "http://api.guoku.com/mobile/v4/category/%s/articles/?page=%s&size=%s&sign=%s&api_key=%s";

    /**
     * 品类页面商品接口
     * type:    CategorySelection
     */
    public static final String CATEGORYSELECTION_PATH = "http://api.guoku.com/mobile/v4/category/%s/selection/?page=%s&sort=%s&sign=%s&api_key=%s";

    /**
     * 果库的图片库
     */
    public static final String IMAGE_PATH = "http://imgcdn.guoku.com";


    /**
     * SharedPreferenced类
     */
    //用户信息
    public static final String SP_USERINFO = "sp_userinfo";
    public static final String SP_CODEPIC = "SP_CODEPIC";
    public static final String  SP_FIRST_INTO = "sp_first_into";
    public static final String  SP_KEY = "sp_key";


}

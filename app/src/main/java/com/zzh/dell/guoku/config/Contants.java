package com.zzh.dell.guoku.config;

/**
 * Created by DELL on 2016/10/15.
 */
public final class Contants {
    /**
     * 注册
     */
    public static final String REGISTER = "http://api.guoku.com/mobile/v4/register/";
    /**
     * 登录
     */
    public static final String LOGIN = "http://api.guoku.com/mobile/v4/login/";
    /**
     * 分类界面总接口
     */
    public static final String CATEGORY_MAIN_PATH = "http://api.guoku.com/mobile/v4/discover/?sign=%s&api_key=%s";

    /**
     * 子品类页面图文接口
     */
    public static final String SUBCATEGORYARTICLES_PATH = "http://api.guoku.com/mobile/v4/category/%s/articles/?page=%s&size=%s&sign=%s&api_key=%s";

    public static final String SUBCATEGORYSELECTION_PATH = "http://api.guoku.com/mobile/v4/category/%s/selection/?page=%s&sort=%s&sign=%s&api_key=%s";

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
    //第一次启动该APP的判断
    public static final String  SP_FIRST_INTO = "sp_first_into";
    public static final String  SP_KEY = "sp_key";

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
    public static final String  GOODS_AD = "http://api.guoku.com/mobile/v4/entity/guess/";
}

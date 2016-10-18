package com.zzh.dell.guoku.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.config.Contants;

/**
 * Created by DELL on 2016/10/16.66666666666666666
 */
public class SharedPrefUtils {
    /**
     * 设置登录时候的Account
     * @param paramContext
     * @param paramAccountBean
     */
    public static void setUserBean(Context paramContext, Account paramAccountBean) {
        Gson gson = new Gson();
        for (String str = gson.toJson(paramAccountBean); ; str = "") {
            paramContext.getSharedPreferences(Contants.SP_USERINFO, Context.MODE_PRIVATE).edit().putString(Contants.SP_CODEPIC, str).commit();
            return;
        }
    }

    public static Account getUserBean(Context paramContext) {
        Gson gson = new Gson();
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(Contants.SP_USERINFO, Context.MODE_PRIVATE);
//        LoginInfo.type = paramContext.getSharedPreferences("userinfo_login_type", 0).getInt("userinfo_login_type_key", 0);
        if ((localSharedPreferences.getString(Contants.SP_CODEPIC, "") != null) && (!"".equals(localSharedPreferences.getString(Contants.SP_CODEPIC, ""))))
        {
            Account localAccountBean = gson.fromJson(localSharedPreferences.getString(Contants.SP_CODEPIC, ""), Account.class);
            return localAccountBean;
        }
        return null;
    }

}

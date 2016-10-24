package com.zzh.dell.guoku.app;

import android.app.Application;

import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.utils.SharedPrefUtils;

/**
 * Created by DELL on 2016/10/15.
 */
public class GuokuApp extends Application {

    private static GuokuApp intance = null;


    public static GuokuApp getIntance() {
        if (intance == null) {
            synchronized (GuokuApp.class) {
                if (intance == null) {
                    intance = new GuokuApp();
                }
            }
        }
        return intance;
    }

    private Account account;

    private String session;

    @Override
    public void onCreate() {
        super.onCreate();
        intance = this;
    }

    public Account getAccount() {
        return account;
    }

    public String getSession() {
        return session;
    }

    public void login(Account paramAccountBean) {
        this.session = paramAccountBean.getSession();
        this.account = paramAccountBean;
        SharedPrefUtils.setUserBean(intance, this.account);
    }

    public void logout() {
        this.account = null;
        this.session = null;
        SharedPrefUtils.setUserBean(intance, null);
    }

}

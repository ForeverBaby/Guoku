package com.zzh.dell.guoku.callback;

/**
 * Created by DELL on 2016/10/14.
 */
public interface HttpCallBack {
    /**
     * 传送str
     * @param str
     */
    void sendStr(String type,String str);

    /**
     * 传送前
     */
    void sendStrbefore(String type);

    /**
     * 传送后
     */
    void sendStrAfter(String type);
}

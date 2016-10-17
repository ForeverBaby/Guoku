package com.zzh.dell.guoku.utils;

import com.google.gson.Gson;

/**
 * Gson单元，整个项目只创建一个gson对象，需要时直接调用
 * Created by Ishinagi_moeta on 2016/9/21.
 */
public class GsonUtils {
    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

}

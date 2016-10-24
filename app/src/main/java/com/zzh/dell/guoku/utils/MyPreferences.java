package com.zzh.dell.guoku.utils;

import android.content.Context;

/**
 * Created by DELL on 2016/10/23.
 */
public class MyPreferences {

    private static final String KEY_GUIDE_ACTIVITY = "guide_activity";

    public static final String SHAREDPREFERENCES_NAME = "my_pref";

    public static boolean activityIsGuided(Context paramContext, String paramString) {
        if ((paramContext == null) || (paramString == null) || ("".equalsIgnoreCase(paramString))) {
            return false;
        }
        String[] arrayOfString = paramContext.getSharedPreferences("my_pref", Context.MODE_PRIVATE).getString("guide_activity", "").split("\\|");
        int j = arrayOfString.length;
        for (int k = 0; ; k++) {
            if (k >= j)
                return false;
            if (paramString.equalsIgnoreCase(arrayOfString[k]))
                break;
        }
        return false;
    }

    public static void setIsGuided(Context paramContext, String paramString) {
        if ((paramContext == null) || (paramString == null) || ("".equalsIgnoreCase(paramString)))
            return;
        StringBuilder localStringBuilder = new StringBuilder(paramContext.getSharedPreferences("my_pref", 1).getString("guide_activity", "")).append("|").append(paramString);
        paramContext.getSharedPreferences("my_pref", Context.MODE_PRIVATE).edit().putString("guide_activity", localStringBuilder.toString()).commit();
    }
}

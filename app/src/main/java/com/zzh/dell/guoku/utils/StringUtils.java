package com.zzh.dell.guoku.utils;

import android.content.Context;
import android.content.pm.PackageManager;

import com.zzh.dell.guoku.app.GuokuApp;

import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * Created by 朱张华  on 2016/10/14.
 */
public final class StringUtils {
    private static final String TAG = "StringUtil";

    /**
     * 获取注册时候的sign，如果是自己注册则里面有{}"nickname", "email", "password"}；
     * 如果是新浪用户注册为{"nickname", "email", "password", "screen_name", "sina_id", "sina_token"}
     *
     * @param paramMap 注册时候的信息包括
     * @return 一个MD5编码
     */
    public static String getSign(Map<String, String> paramMap) {
        StringBuffer localStringBuffer = new StringBuffer();
        paramMap.put("api_key", "0b19c2b93687347e95c6b6f5cc91bb87");
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            localStringBuffer.append(str).append("=").append(paramMap.get(str));
        }
        localStringBuffer.append("47b41864d64bd46");
        return md5(localStringBuffer.toString());
    }

    public static String setSubstring(String paramString, int paramInt1, int paramInt2) {
        return paramString.substring(-2 + paramString.length(), paramString.length());
    }

    /**
     * 获取get要的url
     *
     * @return
     */
    public static String getGetUrl(String path, Map<String, String> paramMap) {
        int size = paramMap.size();
        StringBuffer buffer = new StringBuffer(path).append("?");
        TreeMap<String, String> treeMap = new TreeMap<>();
        for (Map.Entry<String, String> header : paramMap.entrySet()) {
            buffer.append(header.getKey()).append("=").append(header.getValue()).append("&");
            treeMap.put(header.getKey(), header.getValue());
        }
        if (GuokuApp.getIntance().getAccount() != null) {
            buffer.append("session").append("=").append(GuokuApp.getIntance().getAccount().getSession()).append("&");
            treeMap.put("session", GuokuApp.getIntance().getAccount().getSession());
        }
        buffer.append("sign").append("=").append(StringUtils.getSign(treeMap)).append("&");
        buffer.append("api_key").append("=").append("0b19c2b93687347e95c6b6f5cc91bb87");
        return buffer.toString();
    }

    /**
     * md5算法
     *
     * @param paramString
     * @return
     */
    public static String md5(String paramString) {
        try {
            byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
            StringBuffer localStringBuffer = new StringBuffer();
            for (int i = 0; i < arrayOfByte.length; i++) {
                localStringBuffer.append(Integer.toHexString(0x100 | 0xFF & arrayOfByte[i]).substring(1, 3));
            }
            String str = localStringBuffer.toString();
            return str;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return null;
    }


    /**
     * nickname的型
     *
     * @param paramString
     * @return 返回是否是一个三个字符以上的
     */
    public static boolean isNickName(String paramString) {
        return Pattern.compile("^[^0-9][\\w-]{3,30}$").matcher(paramString).matches();
    }

    /**
     * 判断是否是邮箱
     *
     * @param paramString
     * @return 返回是否
     */
    public static boolean checkEmail(String paramString) {
        if ((paramString != null) && (!paramString.trim().equals("")))
            return Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(paramString).matches();
        return false;
    }

    /**
     * long型时间戳转换为Date
     *
     * @param paramLong
     * @return
     */
    public static Date longToDate(long paramLong) {
        return new Date(paramLong);
    }

    /**
     * 把时间转化为yyyy-MM-dd HH:mm:ss
     *
     * @param paramDate
     * @return 返回时间字符串
     */
    public static String date2String(Date paramDate) {
        try {
            String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramDate);
            return str;
        } catch (Exception localException) {
        }
        return null;
    }

    /**
     * 把double型转化为String
     *
     * @param paramDouble 要转化的都变了类型
     * @param paramInt    转化的位数
     * @return string
     */
    public static String double2String(double paramDouble, int paramInt) {
        DecimalFormat localDecimalFormat = new DecimalFormat();
        localDecimalFormat.setGroupingUsed(false);
        localDecimalFormat.setMaximumFractionDigits(paramInt);
        localDecimalFormat.setMinimumFractionDigits(paramInt);
        return localDecimalFormat.format(paramDouble);
    }


    public static String getViesion(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String isStringId(String paramString1, String paramString2) {
        String str = paramString1.replace(paramString2, "");
        return str.substring(0, -1 + str.length());
    }
}

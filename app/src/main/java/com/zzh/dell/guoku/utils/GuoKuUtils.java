package com.zzh.dell.guoku.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by DELL on 2016/10/17.
 */
public class GuoKuUtils {
    /**
     * 隐藏键盘
     * @param paramActivity
     */
    public static void hideKeyBoard(Activity paramActivity) {

        InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (isKeyShow(paramActivity)) {
            localInputMethodManager.hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    /**
     * 隐藏键盘并且删除指定EditText内容
     * @param paramContext
     * @param paramEditText
     */
    public static void hideKeyboard(Context paramContext, EditText paramEditText) {
        paramEditText.setText("");
        paramEditText.setHint("");
        ((InputMethodManager)paramContext.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
    }

    /**
     * 键盘是否展开
     * @param paramActivity
     * @return
     */
    public static boolean isKeyShow(Activity paramActivity)
    {
        return paramActivity.getWindow().getAttributes().softInputMode == 0;
    }

}

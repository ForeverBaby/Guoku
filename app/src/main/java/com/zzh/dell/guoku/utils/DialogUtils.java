package com.zzh.dell.guoku.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

/**
 * Created by DELL on 2016/10/21.
 */
public class DialogUtils {

    public static AlertDialog listDialgo(Context paramContext, CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
        localBuilder.setItems(paramArrayOfCharSequence, paramOnClickListener);
        return localBuilder.create();
    }

    public static AlertDialog getEDialog(Context paramContext, DialogInterface.OnClickListener paramOnClickListener, String paramString, EditText paramEditText) {
        return new AlertDialog.Builder(paramContext).setTitle(paramString).setIcon(android.R.drawable.ic_input_get).setView(paramEditText).setPositiveButton("确定", paramOnClickListener).setNegativeButton("取消", null).create();
    }

    public static AlertDialog getEDialog(Context paramContext, DialogInterface.OnClickListener paramOnClickListener, String paramString1, String paramString2, EditText paramEditText) {
        return new AlertDialog.Builder(paramContext).setTitle(paramString1).setMessage(paramString2).setIcon(android.R.drawable.ic_input_get).setView(paramEditText).setPositiveButton("确定", paramOnClickListener).setNegativeButton("取消", null).create();
    }


}

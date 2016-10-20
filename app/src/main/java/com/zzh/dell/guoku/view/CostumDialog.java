package com.zzh.dell.guoku.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zzh.dell.guoku.R;

/**
 * Created by DELL on 2016/10/18.
 */
public class CostumDialog extends Dialog {

    public CostumDialog(Context context) {
        super(context);
        setContentView(R.layout.costumdialog);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER;
        getWindow().setAttributes(attributes);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }


    public void setMessage(String paramString)
    {
        ((TextView)findViewById(R.id.id_tv_loadingmsg)).setText(paramString);
    }
}

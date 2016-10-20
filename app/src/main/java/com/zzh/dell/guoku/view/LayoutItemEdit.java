package com.zzh.dell.guoku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zzh.dell.guoku.R;

/**
 * Created by DELL on 2016/10/18.
 */
public class LayoutItemEdit extends RelativeLayout {
    public EditTextWithDel edDel;
    ImageView imageVie;
    public TextView tv1;

    public LayoutItemEdit(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        LayoutInflater.from(paramContext).inflate(R.layout.layout_item_edit,this);
        init();
    }

    private void init() {
        this.tv1 = ((TextView) findViewById(R.id.textView1));
        this.edDel = ((EditTextWithDel) findViewById(R.id.editView2));
        this.imageVie = ((ImageView) findViewById(R.id.imageView1));
    }

    public void hideDelBt() {
        this.edDel.isShowDel = false;
    }

    public void inputStyleEmail() {
        this.edDel.setInputType(208);
    }

    public void inputStyleNum() {
        this.edDel.setInputType(2);
    }

    public void inputStylePHONE() {
        this.edDel.setInputType(3);
    }

    public void showDelBt() {
        this.edDel.isShowDel = true;
    }

}

package com.zzh.dell.guoku.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zzh.dell.guoku.R;

/**
 * Created by DELL on 2016/10/18.
 */
public class LayoutItemView extends RelativeLayout {
    ImageView imageVie;
    public TextView tv1;
    public TextView tv2;

    public LayoutItemView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext, paramAttributeSet);
    }

    public LayoutItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramContext, paramAttributeSet);
    }

    private void init(Context paramContext, AttributeSet paramAttributeSet) {
        ((LayoutInflater)paramContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_item_view, this);
        this.tv1 = ((TextView)findViewById(R.id.textView1));
        this.tv2 = ((TextView)findViewById(R.id.textView2));
        this.imageVie = ((ImageView)findViewById(R.id.imageView1));
        TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LayoutItemView);
        this.tv1.setText(localTypedArray.getString(R.styleable.LayoutItemView_textLeft));
        this.tv1.setTextColor(localTypedArray.getInt(R.styleable.LayoutItemView_textColorLeft, R.color.black_body));
        localTypedArray.recycle();
    }
}

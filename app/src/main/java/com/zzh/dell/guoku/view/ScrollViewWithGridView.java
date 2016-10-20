package com.zzh.dell.guoku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by DELL on 2016/10/18.
 */
public class ScrollViewWithGridView extends GridView {
    public ScrollViewWithGridView(Context context) {
        super(context);
    }

    public ScrollViewWithGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewWithGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST));
    }
}

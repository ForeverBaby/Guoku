package com.zzh.dell.guoku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * Created by DELL on 2016/10/18.
 */
public class ScrollViewWithListView extends ListView {
    public ScrollViewWithListView(Context context) {
        super(context);
    }

    public ScrollViewWithListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewWithListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST));
    }
}

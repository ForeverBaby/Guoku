package com.zzh.dell.guoku.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.zzh.dell.guoku.R;

/**
 * Created by DELL on 2016/10/18.
 */
public class EditTextWithDel extends EditText {
    private Drawable imgInable;
    public boolean isShowDel = true;
    private Context mContext;

    public EditTextWithDel(Context paramContext) {
        super(paramContext);
        this.mContext = paramContext;
        init();
    }

    public EditTextWithDel(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.mContext = paramContext;
        init();
    }

    public EditTextWithDel(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.mContext = paramContext;
        init();
    }

    private void init() {
        this.imgInable = this.mContext.getResources().getDrawable(R.mipmap.button_clear);
        addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable paramEditable) {
                EditTextWithDel.this.setDrawable();
            }

            public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
            }

            public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
            }
        });
        setDrawable();
    }

    private void setDrawable() {
        if (length() < 1) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            return;
        }
        if (this.isShowDel) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, this.imgInable, null);
            setEnabled(true);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        setEnabled(false);
    }

    protected void finalize()
            throws Throwable {
        super.finalize();
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.isShowDel) {
            int i = (int) paramMotionEvent.getRawX();
            int j = (int) paramMotionEvent.getRawY();
            Rect localRect = new Rect();
            getGlobalVisibleRect(localRect);
            localRect.left = (-50 + localRect.right);
            if (localRect.contains(i, j))
                setText("");
        }
        return super.onTouchEvent(paramMotionEvent);
    }

    public void setSelection(int paramInt) {
        super.setSelection(length());
    }
}

package com.zzh.dell.guoku.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zzh.dell.guoku.R;

/**
 * Created by DELL on 2016/10/18.
 */
public class CustomShareBoard extends PopupWindow implements View.OnClickListener {

    private Activity mActivity;

    private View rootView;

    private String title;

    private String url;

    public CustomShareBoard(Activity paramActivity) {
        super(paramActivity);
        this.mActivity = paramActivity;
        initView(paramActivity);
    }

    LinearLayout share_wx_1;
    LinearLayout share_wx_2;
    LinearLayout share_sina;
    LinearLayout share_llq;
    LinearLayout share_mail;
    LinearLayout layout_refresh;
    LinearLayout layout_copy;
    LinearLayout layout_report;
    TextView cancel;

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_board, null, false);
        share_wx_1 = (LinearLayout) view.findViewById(R.id.share_wx_1);
        share_wx_2 = (LinearLayout) view.findViewById(R.id.share_wx_2);
        share_sina = (LinearLayout) view.findViewById(R.id.share_sina);
        share_llq = (LinearLayout) view.findViewById(R.id.share_llq);
        share_mail = (LinearLayout) view.findViewById(R.id.share_mail);
        layout_refresh = (LinearLayout) view.findViewById(R.id.layout_refresh);
        layout_copy = (LinearLayout) view.findViewById(R.id.layout_copy);
        layout_report = (LinearLayout) view.findViewById(R.id.layout_report);
        cancel = (TextView) view.findViewById(R.id.cancel);
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setTouchable(true);
        initListener();
    }

    private void initListener() {
        share_wx_1.setOnClickListener(this);
        share_wx_2.setOnClickListener(this);
        share_sina.setOnClickListener(this);
        share_llq.setOnClickListener(this);
        share_mail.setOnClickListener(this);
        layout_refresh.setOnClickListener(this);
        layout_copy.setOnClickListener(this);
        layout_report.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.share_wx_1:
                break;
            case R.id.share_wx_2:
                break;
            case R.id.share_sina:
                break;
            case R.id.share_llq:
                break;
            case R.id.share_mail:
                break;
            case R.id.layout_refresh:
                break;
            case R.id.layout_copy:
                break;
            case R.id.layout_report:
                break;
            case R.id.cancel:
                break;
        }
    }

    private void sendMail() {
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setType("plain/text");
        localIntent.putExtra("android.intent.extra.SUBJECT", this.mActivity.getResources().getString(R.string.tv_static_title));
        localIntent.putExtra("android.intent.extra.TEXT", this.title + this.url);
        this.mActivity.startActivity(localIntent);
    }

    /**
     *
     * @param paramContext 当前activity的Context
     * @param paramString1 副标题
     * @param paramString2 当前分享内容的url
     * @param paramString3 当前分享图片的url
     * @param paramString4 当前标题
     */
    public void setShareContext(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
//        configPlatforms(paramString1);
        this.url = paramString2;
        this.title = paramString4;
    }
}

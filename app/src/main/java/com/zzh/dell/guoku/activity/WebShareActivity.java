package com.zzh.dell.guoku.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.Sharebean;

public class WebShareActivity extends AppCompatActivity {
    private static final int DIG = 1003;
    private static final int INFO_GOOD = 1001;
    private static final int INFO_USER = 1002;
    private static final int UN_DIG = 1004;
    String IF_ARTICLES = "/articles/";
    String IF_ENTITY = "guoku://entity/";
    String IF_TAOBAO = "taobao.com";
    String IF_TMALL = "detail.tmall.com";
    String IF_USER = "guoku://user/";
    CheckBox checkZan;
    Sharebean sharebean = new Sharebean();
    String urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_share);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
        }
    }
}

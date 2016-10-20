package com.zzh.dell.guoku.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.user_info_ll_email)
    LinearLayout user_info_ll_email;

    @BindView(R.id.user_info_ll_pass)
    LinearLayout user_info_ll_pass;

    @BindView(R.id.setting_ll_weixin)
    LinearLayout setting_ll_weixin;

    @BindView(R.id.setting_ll_sina)
    LinearLayout setting_ll_sina;

    @BindView(R.id.setting_ll_clear)
    LinearLayout setting_ll_clear;

    @BindView(R.id.setting_ll_advice)
    LinearLayout setting_ll_advice;

    @BindView(R.id.set_logout)
    TextView set_logout;

    @BindView(R.id.set_login)
    Button set_login;

    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Window window = getWindow();
        if(Build.VERSION.SDK_INT>=21) {
            window.setStatusBarColor(getResources().getColor(R.color.colorbgBlack));
        }
        account = GuokuApp.getIntance().getAccount();
        title_bar_left_iv.setImageResource(R.drawable.back_selector);
        title_bar_centrt_tv.setText("设置");
        if (account == null) {
            user_info_ll_email.setVisibility(View.GONE);
            user_info_ll_pass.setVisibility(View.GONE);
            set_logout.setVisibility(View.GONE);
            set_login.setVisibility(View.VISIBLE);
        } else {
        }
    }
    @OnClick(R.id.title_bar_left_iv)
    void back(View view){
        finish();
    }
}

package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.utils.StringUtils;

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

    @BindView(R.id.user_info_tv_email)
    TextView user_info_tv_email;

    private Account account;

    @BindView(R.id.setting_tv_code)
    TextView setting_tv_code;

    @BindView(R.id.img_red_round)
    ImageView red_round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
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
        }else {
            if(account.getUser().isMail_verified()){
                isCheckEmail(true);
            }else {
                isCheckEmail(false);
            }
        }

        setting_tv_code.setText(StringUtils.getViesion(this));

    }

    @OnClick(R.id.title_bar_left_iv)
    void back(View view) {
        finish();
    }

    @OnClick(R.id.set_logout)
    public void LogOut(View paramView) {
        GuokuApp.getIntance().logout();
        Intent localIntent = new Intent(this, MainActivity.class);
        localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(localIntent);
    }

    private void isCheckEmail(boolean paramBoolean) {
        if (paramBoolean) {
            user_info_tv_email.setTextColor(getResources().getColor(R.color.g_main));
            user_info_tv_email.setText(account.getUser().getEmail());
            red_round.setVisibility(View.GONE);
            return;
        }
        user_info_tv_email.setText(account.getUser().getEmail() + getResources().getString(R.string.tv_email_uncheck));
        this.user_info_tv_email.setTextColor(getResources().getColor(R.color.gray_fzxx));
        this.red_round.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.user_info_ll_email)
    public void email(View paramView)
    { Intent intent = new Intent();
        if (account.getUser().isMail_verified())
        {
            intent.setClass(this,ChangeEmailActivity.class);

        }else {
            intent.setClass(this,EmailCheckActivity.class);
        }
        startActivity(intent);
    }

    @OnClick(R.id.set_login)
    public void Login(View paramView)
    {
        startActivity(new Intent(this, LoginActivity.class));
    }
    @OnClick(R.id.user_info_ll_pass)
    void ChangePass(){
        Intent intent = new Intent();
        intent.setClass(this,ChangePassActivity.class);
        startActivity(intent);
    }
}

package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CostumDialog;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmailCheckActivity extends AppCompatActivity implements HttpCallBack {

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.tv_email)
    TextView tv_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_check);
        ButterKnife.bind(this);
        initView();
        HttpUtils.getIntance().setCallBack(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initView();
    }

    private void initView() {
        Account account = GuokuApp.getIntance().getAccount();
        title_bar_left_iv.setImageResource(R.drawable.back_selector);
        title_bar_centrt_tv.setText("验证邮箱");
        if(account!=null){
            tv_email.setText(account.getUser().getEmail());
        }
    }
    @OnClick(R.id.title_bar_left_iv)
    void back(){
        finish();
    }
    @OnClick(R.id.send_num_bt)
    void sendEmail(View view){

        HttpUtils.getIntance().getStrGET(Contants.EMAIL_VER_TYPE, StringUtils.getGetUrl(Contants.EMAIL_VER,new HashMap<String, String>()));

    }
    @OnClick(R.id.modify_email)
    void modify_email(View view){
        startActivity(new Intent(this,ChangeEmailActivity.class));
    }
    @OnClick(R.id.title_bar_left_iv)
    void back(View view){
        finish();
    }

    @Override
    public void sendStr(String type, String str) {
        if(Contants.EMAIL_VER_TYPE.equals(type)){
            if("0".equals(str)) {
                Toast.makeText(EmailCheckActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
            }
        }

    }
    CostumDialog dialog;

    @Override
    public void sendStrbefore(String type) {
        dialog =  new CostumDialog(this);
        dialog.show();
    }

    @Override
    public void sendStrAfter(String type) {
        dialog.dismiss();
    }
}

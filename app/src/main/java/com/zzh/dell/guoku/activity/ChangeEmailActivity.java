package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CostumDialog;
import com.zzh.dell.guoku.view.LayoutItemEdit;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeEmailActivity extends AppCompatActivity implements HttpCallBack {
    @BindView(R.id.layout_emali_new)
    LayoutItemEdit tvEmailNew;

    @BindView(R.id.tv_emali_now)
    TextView tv_emali_now;

    @BindView(R.id.layout_email_psd)
    LayoutItemEdit layout_email_psd;

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    @BindView(R.id.title_bar_rigth_tv)
    TextView title_bar_rigth_tv;

    HttpUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        ButterKnife.bind(this);
        initView();
        utils = new HttpUtils();
        utils.setCallBack(this);
    }

    private void initView() {
        Account account = GuokuApp.getIntance().getAccount();
        tv_emali_now.setText(account.getUser().getEmail());
        title_bar_left_iv.setImageResource(R.drawable.back_selector);
        title_bar_centrt_tv.setText("修改邮箱");
        title_bar_rigth_tv.setText("保存");
        title_bar_rigth_tv.setVisibility(View.VISIBLE);
        title_bar_rigth_tv.setEnabled(false);
        tvEmailNew.tv1.setText(getResources().getString(R.string.tv_email_new));
        tvEmailNew.tv1.setTextAppearance(this, R.style.edit_item_left);
        layout_email_psd.tv1.setText(getResources().getString(R.string.tv_email_psd));
        layout_email_psd.tv1.setTextAppearance(this, R.style.edit_item_left);
        layout_email_psd.edDel.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.tvEmailNew.edDel.setInputType(32);
        this.tvEmailNew.edDel.addTextChangedListener(this.tWatcher1);
        layout_email_psd.edDel.addTextChangedListener(this.tWatcher2);
    }

    TextWatcher tWatcher1 = new TextWatcher() {
        public void afterTextChanged(Editable paramEditable) {
            if (paramEditable.length() > 0) {
                isSave();
            }
        }

        public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
        }

        public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
        }
    };
    TextWatcher tWatcher2 = new TextWatcher() {
        public void afterTextChanged(Editable paramEditable) {
            if (paramEditable.length() > 0) {
                isSave();
            }
        }

        public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
        }

        public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
        }
    };

    private void isSave() {

        if ((TextUtils.isEmpty(this.tvEmailNew.edDel.getText().toString())) || (TextUtils.isEmpty(this.layout_email_psd.edDel.getText().toString()))) {
            this.title_bar_rigth_tv.setEnabled(false);
            this.title_bar_rigth_tv.setTextColor(getResources().getColor(R.color.title_bar_gray));
            return;
        }
        this.title_bar_rigth_tv.setEnabled(true);
        this.title_bar_rigth_tv.setTextColor(getResources().getColor(R.color.title_bar_blue));
    }

    @OnClick(R.id.title_bar_rigth_tv)
    void change() {

        String pwd = layout_email_psd.edDel.getText().toString();
        String email = this.tvEmailNew.edDel.getText().toString();
        if (TextUtils.isEmpty(pwd) || TextUtils.isEmpty(email)) {
            Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!StringUtils.checkEmail(email)) {
            Toast.makeText(this, "请输入有效的邮件", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pwd.length() < 8 || pwd.length() > 16) {
            Toast.makeText(this, "密码必须为8-16位", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("password", pwd);
        utils.getStrPOST(Contants.EMAIL_UPDATE_T, Contants.EMAIL_UPDATE, map);

    }


    @Override
    public void sendStr(String type, String str) {
        JSONObject json;
        Gson gson = new Gson();
        if(str!=null){
            try {
                json = new JSONObject(str);
                if(json.has("messge")){
                    Toast.makeText(ChangeEmailActivity.this, str, Toast.LENGTH_SHORT).show();
                    return;
                }
                Account.UserBean account = gson.fromJson(str, Account.UserBean.class);
                Account user = new Account();
                user.setSession(GuokuApp.getIntance().getSession());
                user.setUser(account);
                GuokuApp.getIntance().login(user);
                Intent intent = new Intent();
                intent.setClass(this,EmailCheckActivity.class);
                startActivity(intent);
                finish();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    CostumDialog dialog;

    @Override
    public void sendStrbefore(String type) {
        dialog = new CostumDialog(this);
        dialog.show();

    }

    @Override
    public void sendStrAfter(String type) {
        dialog.dismiss();
    }
    @OnClick(R.id.title_bar_left_iv)
    void back(){
        finish();
    }

}


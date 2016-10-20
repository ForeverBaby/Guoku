package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
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

public class ChangePassActivity extends AppCompatActivity implements HttpCallBack{

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    @BindView(R.id.title_bar_rigth_tv)
    TextView title_bar_rigth_tv;

    @BindView(R.id.layout_psd_old)
    LayoutItemEdit layout_psd_old;
    @BindView(R.id.layout_psd_new)
    LayoutItemEdit layout_psd_new;
    @BindView(R.id.layout_psd_ok)
    LayoutItemEdit layout_psd_ok;

    HttpUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        ButterKnife.bind(this);
        initView();
        utils = new HttpUtils();
        utils.setCallBack(this);
    }

    private void initView() {
        title_bar_centrt_tv.setText("修改密码");
        title_bar_rigth_tv.setText("保存");
        title_bar_left_iv.setImageResource(R.drawable.back_selector);
        title_bar_rigth_tv.setVisibility(View.VISIBLE);
        title_bar_rigth_tv.setEnabled(false);
        layout_psd_old.tv1.setText(R.string.tv_psd_old);
        layout_psd_old.edDel.setTransformationMethod(PasswordTransformationMethod.getInstance());
        layout_psd_new.tv1.setText(R.string.tv_psd_new);
        layout_psd_new.edDel.setTransformationMethod(PasswordTransformationMethod.getInstance());
        layout_psd_ok.tv1.setText(R.string.tv_psd_ok);
        layout_psd_ok.edDel.setTransformationMethod(PasswordTransformationMethod.getInstance());
        layout_psd_old.tv1.setTextAppearance(this, R.style.edit_item_left);
        layout_psd_new.tv1.setTextAppearance(this,  R.style.edit_item_left);
        layout_psd_ok.tv1.setTextAppearance(this,  R.style.edit_item_left);
        layout_psd_old.edDel.addTextChangedListener(tWatcher1);
        layout_psd_new.edDel.addTextChangedListener(tWatcher2);
        layout_psd_ok.edDel.addTextChangedListener(tWatcher3);
    }
    TextWatcher tWatcher1 = new TextWatcher()
    {
        public void afterTextChanged(Editable paramEditable)
        {
            if (paramEditable.length() > 0)
              isSave();
        }

        public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
        {
        }

        public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
        {
        }
    };
    TextWatcher tWatcher2 = new TextWatcher()
    {
        public void afterTextChanged(Editable paramEditable)
        {
            if (paramEditable.length() > 0)
                isSave();
        }

        public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
        {
        }

        public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
        {
        }
    };
    TextWatcher tWatcher3 = new TextWatcher()
    {
        public void afterTextChanged(Editable paramEditable)
        {
            if (paramEditable.length() > 0)
               isSave();
        }

        public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
        {
        }

        public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
        {
        }
    };
    private void isSave()
    {
        if ((TextUtils.isEmpty(this.layout_psd_old.edDel.getText().toString())) || (TextUtils.isEmpty(this.layout_psd_new.edDel.getText().toString())) || (TextUtils.isEmpty(this.layout_psd_ok.edDel.getText().toString()))) {
            this.title_bar_rigth_tv.setEnabled(false);
            this.title_bar_rigth_tv.setTextColor(getResources().getColor(R.color.title_bar_gray));
            return;
        }
        this.title_bar_rigth_tv.setEnabled(true);
        this.title_bar_rigth_tv.setTextColor(getResources().getColor(R.color.title_bar_blue));
    }

    CostumDialog dialog;

    @Override
    public void sendStr(String type, String str) {
        JSONObject json;
        Gson gson = new Gson();
        if(str!=null){
            try {
                json = new JSONObject(str);
                if(json.has("message")){
                    Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                    return;
                }
                Account.UserBean userBean = gson.fromJson(str, Account.UserBean.class);
                if(userBean!=null){
                    Account account = new Account();
                    account.setSession(GuokuApp.getIntance().getSession());
                    account.setUser(userBean);
                    GuokuApp.getIntance().login(account);
                    Intent intent = new Intent(this,SettingActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "密码修改成功", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void sendStrbefore(String type) {
        dialog = new CostumDialog(this);
        dialog.show();
    }

    @Override
    public void sendStrAfter(String type) {
        dialog.dismiss();
    }
    @OnClick(R.id.title_bar_rigth_tv)
    void changePass(View view){
        String oldpas = layout_psd_old.edDel.getText().toString();
        String newpas = layout_psd_new.edDel.getText().toString();
        String okpass = layout_psd_ok.edDel.getText().toString();
        if(TextUtils.isEmpty(okpass)||TextUtils.isEmpty(oldpas)||TextUtils.isEmpty(newpas)){
            Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (newpas.length() < 8 || newpas.length() > 16) {
            Toast.makeText(this, "密码必须为8-16位", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!okpass.equals(newpas)){
            Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String,String> map = new HashMap<>();
        map.put("password",oldpas);
        map.put("new_password",newpas);
        map.put("confirm_password",okpass);
        utils.getStrPOST(Contants.PASS_TYPE,Contants.PASS_CHANGE,map);
    }

    @OnClick(R.id.title_bar_left_iv)
    void back(){
        finish();
    }
}

package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements HttpCallBack{
    @BindView(R.id.register_email)
    EditText register_email;

    @BindView(R.id.register_pass)
    EditText register_pass;

    @BindView(R.id.register_name)
    EditText register_name;

    MainActivity.ChangeListener change;
    @BindView(R.id.com)
    TextView com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initActivity();
        ButterKnife.bind(this);
        com.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG ); //下划线
        com.getPaint().setAntiAlias(true);//
    }

    private void initActivity() {
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        change = new MainActivity.ChangeListener();
        IntentFilter intentF = new IntentFilter();
        intentF.addAction("Main.Login.btn.type1");
        intentF.addAction("Main.Login.btn.type2");
        registerReceiver(change,intentF);
        HttpUtils.getIntance().setCallBack(this);

    }
    @OnClick(R.id.com)
    void com(View view){
        Intent localIntent = new Intent(this, WebActivity.class);
        localIntent.putExtra("data", "http://www.guoku.com/agreement/");
        startActivity(localIntent);
    }
    @OnClick(R.id.register_btn)
    void register(View view){
        String email = register_email.getText().toString().trim();
        String pass = register_pass.getText().toString().trim();
        String name = register_name.getText().toString().trim();
        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)||TextUtils.isEmpty(name)){
            Toast.makeText(RegisterActivity.this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!StringUtils.checkEmail(email)){
            Toast.makeText(RegisterActivity.this, "请输入有效的邮件", Toast.LENGTH_SHORT).show();
            return;
        }
        if((16 <= pass.length()) && (pass.length() <= 8)){
            Toast.makeText(RegisterActivity.this, "密码必须为8-16位", Toast.LENGTH_SHORT).show();
            return;
        }
        if((name.length() <= 3) && (name.length() >= 30)){
            Toast.makeText(RegisterActivity.this, "请输入3位以上－30位以下的文字或字母", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!StringUtils.isNickName(name)){
            Toast.makeText(RegisterActivity.this, "请输入合法昵称", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String,String> map = new ArrayMap<>();
        map.put("nickname",name);
        map.put("email",email);
        map.put("password",pass);
        HttpUtils.getIntance().getStrPOST(Contants.REGIDTERTYPE,Contants.REGISTER,map);
    }

    /**
     * 沉浸色
     *
     * @param on
     */
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    @OnClick(R.id.reg_tv_r)
    void login(View view) {
        finish();
    }

    @OnClick(R.id.reg_tv_l)
    void finished(View view) {
        finish();
    }

    @Override
    public void sendStr(String type, String str) {
        Gson gson = new Gson();
        JSONObject json;
        if(str!=null){
            switch (type){
                case Contants.REGIDTERTYPE:
                    try {
                        json = new JSONObject(str);
                        if(json.has("message")){
                            Toast.makeText(RegisterActivity.this, json.getString("message"), Toast.LENGTH_SHORT).show();
                        }else {
                            Account account = gson.fromJson(str, Account.class);
                            GuokuApp.getIntance().login(account);
                            Intent localIntent = new Intent(this, MainActivity.class);
                            localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(localIntent);
                            overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(change);
    }
}

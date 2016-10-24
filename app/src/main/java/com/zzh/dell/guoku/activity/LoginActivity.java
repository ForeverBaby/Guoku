package com.zzh.dell.guoku.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.utils.netutils.NetworkUtils;
import com.zzh.dell.guoku.view.CostumDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements HttpCallBack {

    @BindView(R.id.login_username)
    EditText login_username;

    @BindView(R.id.login_pass)
    EditText login_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initActivity();
        ButterKnife.bind(this);
    }

    MainActivity.ChangeListener change;

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
        registerReceiver(change, intentF);
        HttpUtils.getIntance().setCallBack(this);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAct();
    }

    @OnClick(R.id.reg_tv_r)
    void register(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.reg_tv_l)
    void finished(View view) {
        finishAct();
    }

    private void finishAct() {
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        finish();
    }

    @OnClick(R.id.login_btn_login)
    void login(View view) {
        String name = login_username.getText().toString().trim();
        String pwd = login_pass.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(LoginActivity.this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> map = new ArrayMap<>();
        map.put("email", name);
        map.put("password", pwd);
        SharedPreferences pwd1 = this.getSharedPreferences("pwd", MODE_PRIVATE);
        SharedPreferences.Editor edit = pwd1.edit();
        edit.putString("pass",pwd);
        edit.commit();
        HttpUtils.getIntance().getStrPOST(Contants.LOGINTYPE, Contants.LOGIN, map);
    }

    @OnClick(R.id.forget)
    void forgetPwd(View view) {
        final EditText localEditText = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("忘记密码");
        builder.setIcon(android.R.drawable.ic_menu_info_details);
        builder.setMessage("输入注册时的邮箱");
        builder.setView(localEditText);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Map<String, String> map = new ArrayMap<String, String>();
                String email = localEditText.getText().toString().trim();
                if (TextUtils.isEmpty(email) || !StringUtils.checkEmail(email)) {
                    Toast.makeText(LoginActivity.this, "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
                    return;
                }
                map.put("email", email);
                HttpUtils.getIntance().getStrPOST(Contants.FORGETTYPE, Contants.FORGET, map);
            }
        }).setNegativeButton("取消", null);
        builder.create().show();
    }

    @Override
    public void sendStr(String type, String str) {
        if(str!=null) {
            Gson gson = new Gson();
            JSONObject json;
            if (str != null) {
                switch (type) {
                    case Contants.FORGETTYPE:
                        try {
                            json = new JSONObject(str);
                            if (json.has("message")) {
                                Toast.makeText(LoginActivity.this, "您输入的邮箱不存在", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "已发送", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case Contants.LOGINTYPE:
                        getNetData(str, gson);
                        Log.e("===","==="+str);
                        break;
                }
            }
        }else {
            if(NetworkUtils.checkNetWork(this)) {
                Toast.makeText(LoginActivity.this, "你的网络出现问题", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(LoginActivity.this, "不好意思,未获得数据", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void getNetData(String str, Gson gson) {
        JSONObject json;
        try {
            json = new JSONObject(str);
            if (json.has("message")) {
                Toast.makeText(LoginActivity.this, json.getString("message"), Toast.LENGTH_SHORT).show();
            } else {
                Account account = gson.fromJson(str, Account.class);
                GuokuApp.getIntance().login(account);
                Intent intent2 = new Intent(this,MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
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

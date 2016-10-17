package com.zzh.dell.guoku.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.zzh.dell.guoku.R;

import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initActivity();
        ButterKnife.bind(this);
    }

    private void initActivity() {
        overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 沉浸色
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
        overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
        finish();
    }
    @OnClick(R.id.reg_tv_r)
    void register(View view){
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.reg_tv_l)
    void finished(View view){
        finish();
    }
    @OnClick(R.id.forget)
    void forgetPwd(View view){
        final EditText localEditText = new EditText(this);
//        DialogUtils.getEDialog(this, new DialogInterface.OnClickListener(localEditText)
//                {
//                    public void onClick(DialogInterface paramDialogInterface, int paramInt)
//                    {
//                        LoginActivity localLoginAct = this;
//                        String[] arrayOfString1 = { "email" };
//                        String[] arrayOfString2 = new String[1];
//                        arrayOfString2[0] = this.val$editText.getText().toString();
//                        localLoginAct.sendConnectionPOST("http://api.guoku.com/mobile/v4/forget/password/", arrayOfString1, arrayOfString2, 13, true);
//                    }
//                }
//                , "忘记密码", "输入注册时的邮箱", localEditText).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("忘记密码");
        builder.setIcon(android.R.drawable.ic_menu_info_details);
        builder.setMessage("输入注册时的邮箱");
        builder.setView(localEditText);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TreeMap<String,String> forgetMap = new TreeMap<String, String>();
//                forgetMap.put();
            }
        }).setNegativeButton("取消",null);
        builder.create().show();
    }
}

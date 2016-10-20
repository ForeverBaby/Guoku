package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.app.GuokuApp;
import com.google.gson.Gson;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.CategoryBean;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.fragment.CategoryFragment;
import com.zzh.dell.guoku.fragment.MeFragment;
import com.zzh.dell.guoku.fragment.MessageFragment;
import com.zzh.dell.guoku.fragment.RecommendFragment;
import com.zzh.dell.guoku.utils.CategoryDBManager;
import com.zzh.dell.guoku.utils.GsonUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 王立鹏 + 朱张华
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rl_content)
    RelativeLayout rl_content;

    @BindView(R.id.rl_bottom)
    RadioGroup rl_bottom;

    @BindView(R.id.me)
    RadioButton me_rb;

    static RadioButton me_rb;

    @BindView(R.id.selection)
    RadioButton selection;

    @BindView(R.id.discover)
    RadioButton discover;

    @BindView(R.id.notification)
    RadioButton notification;

    Handler handler = new Handler();
    CategoryDBManager dbManager;

    //标志1,2
    public int currentRb = 1;

    private boolean isExit = false;
    private boolean isRunningHead = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initColor();
        ButterKnife.bind(this);
        initView();
        initListener();
        initCategoryDB();
    }

    private void initCategoryDB() {
        dbManager = CategoryDBManager.getDbManager(MainActivity.this);
        Cursor cursor = dbManager.queryNoSelection();
        int num = cursor.getCount();

        if (num==0){
            HttpUtils httpUtils = new HttpUtils();
            httpUtils.setCallBack(new HttpCallBack() {
                @Override
                public void sendStr(String type, String str) {
                    if ("CategoryGet".equals(type)){
                        Gson gson = GsonUtils.getGson();
                        CategoryBean bean = gson.fromJson("{\"bean\":"+str+"}",CategoryBean.class);
                        for (int i = 0; i < bean.getBean().size(); i++) {
                            CategoryBean.BeanBean beanBean = bean.getBean().get(i);
                            dbManager.insert(MainActivity.this
                                    ,beanBean.getGroup_id()
                                    ,beanBean.getTitle());
                            for (int j = 0; j < beanBean.getContent().size(); j++) {
                                CategoryBean.BeanBean.ContentBean contentBean = beanBean.getContent().get(j);
                                dbManager.subInsert(MainActivity.this
                                        ,beanBean.getGroup_id()
                                        ,contentBean.getCategory_id()
                                        ,contentBean.getCategory_title()
                                        ,contentBean.getCategory_icon_small()
                                        ,contentBean.getCategory_icon_large());
                            }
                        }
                    }
                }

                @Override
                public void sendStrbefore(String type) {

                }

                @Override
                public void sendStrAfter(String type) {

                }
            });
            httpUtils.getStrGET("CategoryGet",
                    String.format(Contants.CATEGORY_PATH,
                            "b6fbc461c473452b1fa344ae6d1af2c2",
                            Contants.API_KEY));
        }
    }

    private void initColor() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
        if(Build.VERSION.SDK_INT>=21) {
            window.setStatusBarColor(getResources().getColor(R.color.colorbgBlack));
        }

    }

    private void initListener() {
        rl_bottom.setOnCheckedChangeListener(this);
        selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunningHead) {
                    Toast.makeText(MainActivity.this, "点击两次到第一页", Toast.LENGTH_SHORT).show();
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isRunningHead = false;
                    }
                }, 400);
                isRunningHead = true;
            }
        });
    }

    FragmentManager manager;
    RecommendFragment recommend;
    CategoryFragment category;
    MessageFragment message;
    MeFragment me;

    private void initView() {
        me_rb = (RadioButton) findViewById(R.id.me);
        recommend = new RecommendFragment();
        category = new CategoryFragment();
        message = new MessageFragment();
        me = new MeFragment();
        //组装fra
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.rl_content, me).hide(me);
        transaction.add(R.id.rl_content, message).hide(message);
        transaction.add(R.id.rl_content, category).hide(category);
        transaction.add(R.id.rl_content, recommend).show(recommend);
        transaction.add(R.id.rl_content, recommend);
        transaction.commit();
        chexBean();
    }

    /**
     * 检查是否登录
     */
    private boolean chexBean() {
        Drawable startDra;
        if (GuokuApp.getIntance().getAccount() == null) {
            startDra = getResources().getDrawable(R.drawable.main_btn05);
            startDra.setBounds(0, 0, startDra.getMinimumWidth(), startDra.getMinimumHeight());
            me_rb.setCompoundDrawables(null, startDra, null, null);
            return false;
        }
        startDra = getResources().getDrawable(R.drawable.main_btn04);
        startDra.setBounds(0, 0, startDra.getMinimumWidth(), startDra.getMinimumHeight());
        me_rb.setCompoundDrawables(null, startDra, null, null);
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hide(transaction);
        switch (checkedId) {
            case R.id.selection:
                if (recommend == null) {
                    recommend = new RecommendFragment();
                }
                currentRb = 1;
                transaction.show(recommend);
                break;
            case R.id.discover:
                if (category == null) {
                    category = new CategoryFragment();
                }
                currentRb = 2;
                transaction.show(category);
                break;
            case R.id.notification:
                if (message == null) {
                    message = new MessageFragment();
                }
                if (chexBean()) {
                    transaction.show(message);
                } else {
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    if (currentRb == 1) {
                        selection.setChecked(true);
                        transaction.show(recommend);
                    } else {
                        discover.setChecked(true);
                        transaction.show(category);
                    if(currentRb==1){
                        selection.setChecked(true);
                    }else {
                        discover.setChecked(true);
                    }
                }
                break;
            case R.id.me:
                if (me == null) {
                    me = new MeFragment();
                }
                if (chexBean()) {
                    transaction.show(me);
                    me.init();
                } else {
                    Intent intent = new Intent(this, SettingActivity.class);
                    startActivity(intent);
                    if (currentRb == 1) {
                        selection.setChecked(true);
                        transaction.show(recommend);

                    } else {
                        discover.setChecked(true);
                        transaction.show(category);
                } else {
                    Intent intent = new Intent(this, SettingActivity.class);
                    startActivity(intent);
                    if(currentRb==1){
                        selection.setChecked(true);
                    }else {
                        discover.setChecked(true);
                    }
                }
                break;
        }
        transaction.commit();

    }

    private void hide(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.hide(me);
        fragmentTransaction.hide(message);
        fragmentTransaction.hide(category);
        fragmentTransaction.hide(recommend);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_BACK:
                if (isExit) {
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "再次点击退出果库", Toast.LENGTH_SHORT).show();
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
                isExit = true;
                break;
        }
        return false;
    }

    public static class ChangeListener extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Drawable startDra;
            if ("Main.Login.btn.type1".equals(intent.getAction())) {
                startDra = context.getResources().getDrawable(R.drawable.main_btn04);
                startDra.setBounds(0, 0, startDra.getMinimumWidth(), startDra.getMinimumHeight());
                me_rb.setCompoundDrawables(null, startDra, null, null);
            } else if ("Main.Login.btn.type2".equals(intent.getAction())) {
                startDra = context.getResources().getDrawable(R.drawable.main_btn05);
                startDra.setBounds(0, 0, startDra.getMinimumWidth(), startDra.getMinimumHeight());
                me_rb.setCompoundDrawables(null, startDra, null, null);
            }

        }
    }


}

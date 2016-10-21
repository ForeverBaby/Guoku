package com.zzh.dell.guoku.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zzh.dell.guoku.R;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.SplashViewPagerAdapter;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.SharedPrefUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 朱张华
 */
public class SplashActivity extends AppCompatActivity {


    int[] img = new int[]{
            R.mipmap.android1,
            R.mipmap.android2,
            R.mipmap.android3,
            R.mipmap.android4
    };
   SharedPreferences preferences;

    @BindView(R.id.splash_viewpager)
    ViewPager viewPager;

    @BindView(R.id.splash_btn)
    Button btn;

    @BindView(R.id.splash_linear)
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        int flas = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flas,flas);
        setContentView(R.layout.activity_splash);
        initAccount();
        int flags = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flags,flags);
        setContentView(R.layout.activity_splash);

        //让状态栏去掉
        ButterKnife.bind(this);

        preferences = getSharedPreferences(Contants.SP_FIRST_INTO,MODE_PRIVATE);
        boolean aBoolean = preferences.getBoolean(Contants.SP_KEY, false);
        JudgeFirst(aBoolean);
    }

    private void initAccount() {
        Account userBean = SharedPrefUtils.getUserBean(this);
        if(userBean!=null){
            GuokuApp.getIntance().login(userBean);
        }

    }

    private void JudgeFirst(boolean aBoolean) {
        if (aBoolean){
            goToGuideActivity();
        }else{
            int len = img.length;
            List<ImageView> list = new ArrayList<>();
            for(int i=0;i<len;i++){
                ImageView image = new ImageView(this);
                image.setImageResource(img[i]);
                list.add(image);
                ImageView point = new ImageView(this);
                if(i==0){
                    point.setImageResource(R.drawable.splash_btn_selsct);
                }else{
                    point.setImageResource(R.drawable.splash_btn);
                }
                point.setPadding(10,0,10,0);
                linear.addView(point);
            }
            SplashViewPagerAdapter adapter = new SplashViewPagerAdapter(list);
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    int childCount = linear.getChildCount();
                    for(int i=0;i<childCount;i++){
                        ImageView image = (ImageView) linear.getChildAt(i);
                        if(i == position){
                            image.setImageResource(R.drawable.splash_btn_selsct);
                        }else{
                            image.setImageResource(R.drawable.splash_btn);
                        }
                    }
                    if(position == childCount-1){
                        btn.setVisibility(View.VISIBLE);
                    }else{
                        btn.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

    @OnClick(R.id.splash_btn)
    public void onClick(){
        if(preferences!=null){
            SharedPreferences.Editor edit = preferences.edit();
            edit.putBoolean(Contants.SP_KEY,true);
            edit.commit();
        }
        goToGuideActivity();
    }

    private void goToGuideActivity(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}

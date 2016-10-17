package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;

import com.zzh.dell.guoku.R;

/**
 * 王立鹏
 */
public class GuideActivity extends AppCompatActivity {

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorWhite));
        }
        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setFillAfter(true);
        animation.setDuration(2000);
        getWindow().getDecorView().setAnimation(animation);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                finish();
            }
        },1000);
    }
}

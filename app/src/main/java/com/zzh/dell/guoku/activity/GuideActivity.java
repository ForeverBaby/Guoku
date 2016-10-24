package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import com.zzh.dell.guoku.R;

/**
 * 王立鹏
 */
public class GuideActivity extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(getResources().getColor(R.color.category_background));
        }
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.guide_rl);
        AlphaAnimation animation = new AlphaAnimation(0.1f,1.0f);
        animation.setFillAfter(true);
        animation.setDuration(1000);
        rl.startAnimation(animation);
        animation.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        this.startActivity(new Intent(this,SplashActivity.class));
        overridePendingTransition(R.anim.activity_main_in,R.anim.activity_out);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

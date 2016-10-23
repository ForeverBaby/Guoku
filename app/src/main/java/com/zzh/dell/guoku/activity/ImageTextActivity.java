package com.zzh.dell.guoku.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zzh.dell.guoku.R;

public class ImageTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_text);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorbgBlack));
        }
    }

    public void back(View view) {
        finish();
    }
}

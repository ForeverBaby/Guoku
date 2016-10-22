package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.BitmapUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Picture2Activity extends AppCompatActivity {
    @BindView(R.id.img)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture2);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorbgBlack));
        }
        init();
    }

    private void init() {
        Intent intent = getIntent();
        final String path = intent.getStringExtra("path");
        overridePendingTransition(R.anim.act_fade_in, R.anim.push_down_out);
        img.setImageResource(R.mipmap.item240);
        final String fileName = BitmapUtils.getFileName(path);
        Picasso.with(this).load(path).transform(new Transformation() {
            @Override
            public Bitmap transform(Bitmap source) {
                String s = BitmapUtils.saveImageToSDCard(source, fileName);
                Bitmap bitmapByPath = BitmapUtils.getBitmapByPath(s);
                if(source!=null){
                    source.recycle();
                    source = null;
                }


                return bitmapByPath;
            }

            @Override
            public String key() {
                return path;
            }
        }).memoryPolicy(MemoryPolicy.NO_CACHE).fit().centerCrop().into(img);

//        Picasso.with(this).load(uri).fit().centerCrop().into(img);


    }

    @OnClick(R.id.img)
    void back(View view) {
        finish();
        overridePendingTransition(R.anim.act_fade_in, R.anim.push_down_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        overridePendingTransition(R.anim.act_fade_in, R.anim.push_down_out);
        return super.onKeyDown(keyCode, event);
    }
}

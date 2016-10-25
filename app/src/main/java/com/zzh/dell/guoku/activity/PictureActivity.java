package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.SplashViewPagerAdapter;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.http.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PictureActivity extends AppCompatActivity {

    @BindView(R.id.viewpager_img)
    ViewPager viewPager;

    @BindView(R.id.ll_img)
    LinearLayout ll;

    @BindView(R.id.heart_img)
    TextView text_heart;

    @BindView(R.id.heart_heart)
    ImageView heart_heart;

    @BindView(R.id.image_img)
    ImageView image_img;
    private int like_size = -1;
    private int like_already = -1;
    private int entity_id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
        }
        ButterKnife.bind(this);
        getAndSetData();
    }

    private void getAndSetData() {
        Intent intent = getIntent();
        boolean flag = intent.getBooleanExtra("flag", false);
        if(flag){
            //只有一张图片
            ll.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
            image_img.setVisibility(View.VISIBLE);
            String detail_image = intent.getStringExtra("detail_image");
            Picasso.with(this).load(detail_image)
                    .fit().centerCrop().into(image_img);
        }else {
            ll.setVisibility(View.VISIBLE);
            viewPager.setVisibility(View.VISIBLE);
            image_img.setVisibility(View.GONE);
        }
        like_size = intent.getIntExtra("like_size", -1);
        like_already = intent.getIntExtra("like_already",-1);
        entity_id = intent.getIntExtra("entity_id",-1);
        if (like_size != -1&&like_size!=0) {
            text_heart.setText(String.valueOf(like_size));
        }
        if(like_already == 0){
            heart_heart.setImageResource(R.mipmap.icon_like);
        }else{
            heart_heart.setImageResource(R.mipmap.icon_like_press);
        }
        ArrayList<String> pictureUrl = intent.getStringArrayListExtra("pictureUrl");
        final int pos = intent.getIntExtra("pos", -1);
        int size = pictureUrl.size();
        List<ImageView> imageViewList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ImageView image = new ImageView(this);
            Picasso.with(this).load(pictureUrl.get(i))
                    .fit().centerCrop().into(image);
            imageViewList.add(image);
            ImageView point = new ImageView(this);
            if (i == pos) {
                point.setImageResource(R.drawable.splash_btn_selsct);
            } else {
                point.setImageResource(R.drawable.splash_btn);
            }
            point.setPadding(10, 0, 10, 0);
            ll.addView(point);
        }

        SplashViewPagerAdapter adapter = new SplashViewPagerAdapter(imageViewList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(pos);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int childCount = ll.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ImageView point = (ImageView) ll.getChildAt(i);
                    if (i == position) {
                        point.setImageResource(R.drawable.splash_btn_selsct);
                    } else {
                        point.setImageResource(R.drawable.splash_btn);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.heart_heart)
    public void heartClick(){
        int parseInt = Integer.parseInt(text_heart.getText().toString());
        String path;
        if(like_already == 0 && entity_id!=-1){
            heart_heart.setImageResource(R.mipmap.icon_like_press);
            path = Contants.GOODS_DETAIL + entity_id +"/like/1/";
            text_heart.setText(String.valueOf(parseInt+1));
        }else{
            heart_heart.setImageResource(R.mipmap.icon_like);
            path = Contants.GOODS_DETAIL +entity_id +"/like/0/";
            text_heart.setText(String.valueOf(parseInt-1));
        }
        HttpUtils httpUtils = new HttpUtils();
        Map<String,String> map = new HashMap<>();
        httpUtils.getStrPOST("ggg",path,map);
    }

    @OnClick(R.id.close_img)
    public void onClick(){
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_main_in,R.anim.activity_out);
    }
}

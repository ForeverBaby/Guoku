package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.SplashViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

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
        int like_size = intent.getIntExtra("like_size", -1);
        if(like_size!=0) {
            text_heart.setText(String.valueOf(like_size));
        }

        ArrayList<String> pictureUrl = intent.getStringArrayListExtra("pictureUrl");
        final int pos = intent.getIntExtra("pos", -1);
        int size = pictureUrl.size();
        List<ImageView> imageViewList = new ArrayList<>();
        for(int i=0;i<size;i++){
            ImageView image = new ImageView(this);
            Picasso.with(this).load(pictureUrl.get(i))
                    .fit().centerCrop().into(image);
            imageViewList.add(image);
            ImageView point = new ImageView(this);
            if(i == pos){
                point.setImageResource(R.drawable.splash_btn_selsct);
            }else{
                point.setImageResource(R.drawable.splash_btn);
            }
            point.setPadding(10,0,10,0);
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
                for(int i=0;i<childCount;i++){
                    ImageView point = (ImageView) ll.getChildAt(i);
                    if(i == position){
                        point.setImageResource(R.drawable.splash_btn_selsct);
                    }else{
                        point.setImageResource(R.drawable.splash_btn);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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

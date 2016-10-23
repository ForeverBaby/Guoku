package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.MyGoodsListAdapter;
import com.zzh.dell.guoku.bean.GoodsChildData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 点评的activity 王立鹏
 */
public class CommentActivity extends AppCompatActivity {

    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorbgBlack));
        }
        initView();
        getData();
    }

    private void initView() {
        rl = (RelativeLayout) findViewById(R.id.comment_rl);
    }

    public void back(View view) {
        finish();
    }

    @BindView(R.id.note_circle)
    ImageView note_circle;

    @BindView(R.id.note_name)
    TextView note_name;

    @BindView(R.id.note_content)
    TextView note_content;

    @BindView(R.id.note_text_time)
    TextView note_time;

    @BindView(R.id.note_image_good)
    ImageView good;

    @BindView(R.id.note_image_pop)
    ImageView pop;
    public void getData() {
        Intent intent = getIntent();
        View view = LayoutInflater.from(this).inflate(R.layout.goods_child_list,null);
        ButterKnife.bind(this,view);
        Picasso.with(this).load(intent.getStringExtra("circle"))
                .fit().centerCrop().into(note_circle);
        note_name.setText(intent.getStringExtra("name"));
        note_content.setText(intent.getStringExtra("content"));
        note_time.setText(intent.getStringExtra("time"));
        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("====","==点赞===");
            }
        });
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("====","==评论===");
            }
        });
        rl.addView(view);
    }
}

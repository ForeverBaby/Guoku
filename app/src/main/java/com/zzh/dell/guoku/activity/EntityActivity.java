package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.EntitysAdapter;
import com.zzh.dell.guoku.bean.Entity2;
import com.zzh.dell.guoku.bean.MeEntity;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by DELL on 2016/10/23.
 */
public class EntityActivity extends AppCompatActivity implements HttpCallBack {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entity_act);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
        }
        utils = new HttpUtils();
        utils.setCallBack(this);
        setupData();


    }
    HttpUtils utils;
    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    @OnClick(R.id.title_bar_left_iv)
    void back() {
        finish();
    }
    @BindView(R.id.entity_act_lv)
    PullToRefreshListView entity_act_lv;

    private String tag;
    private String uid;
    EntitysAdapter adapter;
    List<Entity2.EntityListBean> list;

    protected void setupData() {
        Intent intent = getIntent();
        this.tag = intent.getStringExtra("name");
        this.uid = intent.getStringExtra("data");
        list = new ArrayList<>();
        title_bar_centrt_tv.setText("#" + this.tag);
        title_bar_left_iv.setImageResource(R.drawable.back_selector);
        adapter = new EntitysAdapter(this,list);
        entity_act_lv.setMode(PullToRefreshBase.Mode.DISABLED);
        entity_act_lv.setAdapter(adapter);
        entity_act_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
                EntityActivity localEntityAct = EntityActivity.this;
                String str = "http://api.guoku.com/mobile/v4/entity/" + adapter.getItem(paramInt - 1).getEntity_id() + "/";
                String[] arrayOfString1 = {"entity_id"};
                String[] arrayOfString2 = new String[1];
                Map<String,String> map = new ArrayMap<String, String>();
                map.put("entity_id", String.valueOf(adapter.getItem(paramInt - 1).getEntity_id()));
                String getUrl = StringUtils.getGetUrl(str, map);

                utils.getStrGET("Entity2",getUrl);
            }
        });
        getData();
    }

    private void getData(){
        String path ="http://api.guoku.com/mobile/v4/user/" + this.uid + "/tag/" + this.tag.trim() + "/";
        String getUrl = StringUtils.getGetUrl(path, new Hashtable<String, String>());
        Log.e("===","==="+getUrl);
        utils.getStrGET("entity",getUrl);
    }

    @Override
    public void sendStr(String type, String str) {
        Gson gson = new Gson();
       switch (type){
           case "Entity2":
               Intent intent = new Intent();
               intent.setClass(this, GoodsChildActivity.class);
               MeEntity entityListBean = gson.fromJson(str, MeEntity.class);
               intent.putExtra("cid", entityListBean.getEntity().getCategory_id());
               intent.putExtra("id", entityListBean.getEntity().getEntity_id());
               intent.putExtra("imagePath", entityListBean.getEntity().getChief_image());
               startActivity(intent);
               break;
           case "entity":
               list.clear();
               Entity2 entity2 = gson.fromJson(str, Entity2.class);
               list.addAll(entity2.getEntity_list());
               adapter.notifyDataSetChanged();
               break;
       }
    }

    @Override
    public void sendStrbefore(String type) {

    }

    @Override
    public void sendStrAfter(String type) {

    }
}

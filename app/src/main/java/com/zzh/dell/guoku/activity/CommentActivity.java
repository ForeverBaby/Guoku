package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.MyGoodsListAdapter;
import com.zzh.dell.guoku.bean.GoodsChildData;

import java.util.ArrayList;

/**
 * 点评的activity 王立鹏
 */
public class CommentActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
        getData();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.comment_lv);
    }

    public void back(View view) {
        finish();
    }

    public void getData() {
        Intent intent = getIntent();
        ArrayList<GoodsChildData.NoteListBean> listBean = intent.getParcelableArrayListExtra("listBean");
        Log.e("=====","====="+listBean.get(0).getEntity_id());
    }
}

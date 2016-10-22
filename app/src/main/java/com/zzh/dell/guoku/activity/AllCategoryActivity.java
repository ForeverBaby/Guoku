package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.CategoryBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllCategoryActivity extends AppCompatActivity {

    String title;
    List<CategoryBean.BeanBean.ContentBean> list;
    List<Map<String, String>> stringList;

    @BindView(R.id.all_category_title)
    TextView tv_title;
    @BindView(R.id.all_category_grid)
    GridView gridView;

    @OnClick(R.id.all_category_back)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        list = intent.getParcelableArrayListExtra("category");
        title = intent.getStringExtra("title");
        stringList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("string", list.get(i).getCategory_title());
            stringList.add(map);
        }

        tv_title.setText(title);

        SimpleAdapter adapter = new SimpleAdapter(AllCategoryActivity.this
                , stringList
                , R.layout.allcategoryactivity_text
                , new String[]{"string"}
                , new int[]{R.id.all_category_text});

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int cid = list.get(position).getCategory_id();
                String title = list.get(position).getCategory_title();
                Intent intent = new Intent(AllCategoryActivity.this, SubCategoryActivity.class);
                intent.putExtra("id", String.valueOf(cid));
                intent.putExtra("title",title);
                startActivity(intent);
            }
        });

    }
}

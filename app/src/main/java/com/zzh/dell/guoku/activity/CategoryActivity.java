package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.SubCategoryArticlesAdapter;
import com.zzh.dell.guoku.adapter.SubCategorySelectionAdapter;
import com.zzh.dell.guoku.bean.CategoryBean;
import com.zzh.dell.guoku.bean.SubCategoryArticlesBean;
import com.zzh.dell.guoku.bean.SubCategorySelectionBean;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.CategoryDBInfo;
import com.zzh.dell.guoku.utils.CategoryDBManager;
import com.zzh.dell.guoku.utils.GsonUtils;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CostumDialog;
import com.zzh.dell.guoku.view.CustomMeasureGridView;
import com.zzh.dell.guoku.view.CustomMeasureListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryActivity extends AppCompatActivity implements HttpCallBack {

    private int page = 1;
    private int tag = 0;
    private String id;
    private String title;
    private String api_key = "0b19c2b93687347e95c6b6f5cc91bb87";
    HttpUtils httpUtils;

    SubCategoryArticlesBean articlesBean;
    SubCategorySelectionBean selectionBean;
    CategoryDBManager dbManager;

    SubCategoryArticlesAdapter articlesAdapter;
    SubCategorySelectionAdapter entityAdapter;

    @BindView(R.id.category_title)
    TextView tv_title;

    @BindView(R.id.category_linearlayout)
    LinearLayout linearLayout;

    @BindView(R.id.category_more)
    TextView tv_more;

    @BindView(R.id.category_pulltorefresh)
    PullToRefreshScrollView pullView;

    @BindView(R.id.category_relative)
    RelativeLayout relativeLayout;

    @BindView(R.id.category_articles_more)
    TextView tv_articles_more;

    @BindView(R.id.category_articles_list)
    CustomMeasureListView listView;

    @BindView(R.id.category_entity_grid)
    CustomMeasureGridView gridView;

    @OnClick(R.id.category_back)
    void back() {
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        initGetIntent();
        HttpUtilsInit();
        pullToRefreshInit();
        linearLayoutInit();
    }

    private void linearLayoutInit() {
        final List<CategoryBean.BeanBean.ContentBean> list = new ArrayList<>();
        dbManager = CategoryDBManager.getDbManager(CategoryActivity.this);
        Cursor cursor = dbManager.subQueryByGroupId(Integer.parseInt(id));
        while (cursor.moveToNext()) {
            CategoryBean.BeanBean.ContentBean contentBean = new CategoryBean.BeanBean.ContentBean();
            int id = cursor.getInt(cursor.getColumnIndex(CategoryDBInfo.CATEGORY_ID));
            String title = cursor.getString(cursor.getColumnIndex(CategoryDBInfo.CATEGORY_TITLE));
            contentBean.setCategory_id(id);
            contentBean.setCategory_title(title);
            list.add(contentBean);
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                , LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        params.setMargins(10, 15, 10, 15);
        for (int i = 0; i < list.size(); i++) {
            Button btn = new Button(CategoryActivity.this);
            btn.setLayoutParams(params);
            btn.setPadding(0, 0, 0, 0);
            btn.setBackgroundResource(R.drawable.category_btn_background);
            btn.setText(list.get(i).getCategory_title());
            btn.setTextSize(12);
            final int pos = i;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = list.get(pos).getCategory_id();
                    String title = list.get(pos).getCategory_title();
                    Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                    intent.putExtra("id", String.valueOf(id));
                    intent.putExtra("title", title);
                    startActivity(intent);
                }
            });
            linearLayout.addView(btn);
        }

        tv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, AllCategoryActivity.class);
                intent.putParcelableArrayListExtra("category", (ArrayList<? extends Parcelable>) list);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }

    private void initGetIntent() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        title = intent.getStringExtra("title");
        tv_title.setText(title);
    }

    private void HttpUtilsUpdata() {
        page++;
        Map<String, String> map = new TreeMap<>();
        map.put("page", String.valueOf(page));
        map.put("sort", "time");
        String str = StringUtils.getGetUrl(Contants.CATEGORYSELECTION_PATH, map);
        httpUtils.getStrGET("CategorySelectionUpdata", String.format(str, id));
    }

    private void HttpUtilsRefresh() {
        page = 1;
        Map<String, String> map = new TreeMap<>();
        map.put("page", String.valueOf(page));
        map.put("size", "3");
        String str = StringUtils.getGetUrl(Contants.CATEGORYARTICLES_PATH, map);
        httpUtils.getStrGET("CategoryArticlesRefresh", String.format(str, id));

        map.clear();
        map.put("page", String.valueOf(page));
        map.put("sort", "time");
        str = StringUtils.getGetUrl(Contants.CATEGORYSELECTION_PATH, map);
        httpUtils.getStrGET("CategorySelectionRefresh", String.format(str, id));
    }

    private void HttpUtilsInit() {
        page = 1;
        httpUtils = new HttpUtils();
        httpUtils.setCallBack(this);

        Map<String, String> map = new TreeMap<>();
        map.put("page", String.valueOf(page));
        map.put("size", "4");
        String str = StringUtils.getGetUrl(Contants.CATEGORYARTICLES_PATH, map);
        httpUtils.getStrGET("CategoryArticles", String.format(str, id));

        map.clear();
        map.put("page", String.valueOf(page));
        map.put("sort", "time");
        str = StringUtils.getGetUrl(Contants.CATEGORYSELECTION_PATH, map);
        httpUtils.getStrGET("CategorySelection", String.format(str, id));
    }

    private void pullToRefreshInit() {
        pullView.setMode(PullToRefreshBase.Mode.BOTH);


        pullView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                HttpUtilsRefresh();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                HttpUtilsUpdata();
            }
        });
    }

    @Override
    public void sendStr(String type, String str) {
        switch (type) {
            case "CategoryArticles":
                ArticlesInit(str);
                break;
            case "CategorySelection":
                SelectionInit(str);
                break;
            case "CategoryArticlesRefresh":
                ArticlesRefresh(str);
                break;
            case "CategorySelectionRefresh":
                SelectionRefresh(str);
                break;
            case "CategorySelectionUpdata":
                SelectionUpdata(str);
                break;
        }
    }

    private void SelectionUpdata(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategorySelectionBean new_entityBean = gson.fromJson("{\"bean\": " + str + "}", SubCategorySelectionBean.class);
        if (new_entityBean != null && new_entityBean.getBean().size() != 0) {
            selectionBean.getBean().addAll(new_entityBean.getBean());
            entityAdapter.notifyDataSetChanged();
        }
        pullView.onRefreshComplete();
    }

    private void SelectionRefresh(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategorySelectionBean new_entityBean = gson.fromJson("{\"bean\": " + str + "}", SubCategorySelectionBean.class);
        if (new_entityBean != null) {
            selectionBean.getBean().clear();
            selectionBean.getBean().addAll(new_entityBean.getBean());
            entityAdapter.notifyDataSetChanged();
        }
        tag++;
        if (tag == 2) {
            pullView.onRefreshComplete();
            tag = 0;
        }
    }

    private void ArticlesRefresh(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategoryArticlesBean new_articlesBean = gson.fromJson(str, SubCategoryArticlesBean.class);
        if (new_articlesBean != null && new_articlesBean.getArticles().size() != 0) {
            articlesBean.getArticles().clear();
            articlesBean.getArticles().addAll(new_articlesBean.getArticles());
            articlesAdapter.notifyDataSetChanged();
        }
        tag++;
        if (tag == 2) {
            pullView.onRefreshComplete();
            tag = 0;
        }
    }

    int flag = 0;
    private void SelectionInit(String str) {
        Gson gson = GsonUtils.getGson();
        selectionBean = gson.fromJson("{\"bean\": " + str + "}", SubCategorySelectionBean.class);
        if (selectionBean != null) {
            entityAdapter = new SubCategorySelectionAdapter(CategoryActivity.this, selectionBean.getBean());
            gridView.setAdapter(entityAdapter);
            gridView.setListViewHeightBasedOnChildren(gridView, 2);
        } else {
            Toast.makeText(CategoryActivity.this, "当前没有网络，数据加载失败", Toast.LENGTH_SHORT).show();
        }
        flag++;
        if (flag==2){
            dialog.dismiss();
        }
    }

    private void ArticlesInit(String str) {
        Gson gson = GsonUtils.getGson();
        articlesBean = gson.fromJson(str, SubCategoryArticlesBean.class);
        if (articlesBean != null) {
            if (articlesBean.getArticles().size() == 0) {
                relativeLayout.setVisibility(View.GONE);
                listView.setVisibility(View.GONE);
            } else {
                if (articlesBean.getArticles().size() > 3) {
                    articlesBean.getArticles().remove(3);
                    tv_articles_more.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(CategoryActivity.this, CategoryMoreArticlesActivity.class);
                            intent.putExtra("id", id);
                            intent.putExtra("title", title);
                            intent.putExtra("path", Contants.CATEGORYARTICLES_PATH);
                            startActivity(intent);
                        }
                    });
                } else {
                    tv_articles_more.setVisibility(View.GONE);
                }

                articlesAdapter = new SubCategoryArticlesAdapter(CategoryActivity.this, articlesBean.getArticles());
                listView.setAdapter(articlesAdapter);
                listView.setListViewHeightBasedOnChildren(listView);
            }
        }
        flag++;
        if (flag==2){
            dialog.dismiss();
        }
    }
    CostumDialog dialog;
    boolean isFirst = true;
    @Override
    public void sendStrbefore(String type) {
        if (isFirst) {
            dialog = new CostumDialog(CategoryActivity.this);
            dialog.show();
            isFirst = false;
        }
    }

    @Override
    public void sendStrAfter(String type) {
        dialog.dismiss();
    }
}

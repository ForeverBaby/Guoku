package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.SubCategoryArticlesAdapter;
import com.zzh.dell.guoku.adapter.SubCategoryEntityAdapter;
import com.zzh.dell.guoku.bean.SubCategoryArticlesBean;
import com.zzh.dell.guoku.bean.SubCategoryEntityBean;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.GsonUtils;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CostumDialog;
import com.zzh.dell.guoku.view.CustomMeasureGridView;
import com.zzh.dell.guoku.view.CustomMeasureListView;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SubCategoryActivity extends AppCompatActivity implements HttpCallBack {

    private int offset = 0;
    private int tag = 0;
    private int page = 1;
    private String id;
    private String title;
    private String sign = "2a42c35005f57af37a930629b5e00aa5";
    private String api_key = "0b19c2b93687347e95c6b6f5cc91bb87";
    HttpUtils httpUtils;


    SubCategoryArticlesBean articlesBean;
    SubCategoryEntityBean entityBean;

    @BindView(R.id.sub_category_pulltorefresh)
    PullToRefreshScrollView pullView;

    @BindView(R.id.sub_category_title)
    TextView tv_title;

    @BindView(R.id.sub_category_more)
    TextView tv_more;

    @BindView(R.id.sub_category_articles_list)
    CustomMeasureListView listView;

    @BindView(R.id.sub_category_entity_grid)
    CustomMeasureGridView gridView;

    @BindView(R.id.sub_category_articles_relative)
    RelativeLayout relativeLayout;

    @OnClick(R.id.sub_category_back)
    void back() {
        finish();
    }

    SubCategoryArticlesAdapter articlesAdapter;
    SubCategoryEntityAdapter entityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        ButterKnife.bind(this);

        initGetIntent();
        HttpUtilsInit();
        pullToRefreshInit();


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

    private void HttpUtilsUpdata() {
        offset += 30;
        Map<String, String> map = new TreeMap<>();
        map.put("offset", String.valueOf(offset));
        map.put("count", "30");
        map.put("reverse", "0");
        map.put("sort", "time");
        String str = StringUtils.getGetUrl(Contants.SUBCATEGORYSELECTION_PATH, map);
        httpUtils.getStrGET("SubCategorySelectionUpdata", String.format(str, id));
    }

    private void HttpUtilsRefresh() {
        page = 1;
        offset = 0;
        Map<String, String> map = new TreeMap<>();
        map.put("page", String.valueOf(page));
        map.put("size", "3");
        String str = StringUtils.getGetUrl(Contants.SUBCATEGORYARTICLES_PATH, map);
        httpUtils.getStrGET("SubCategoryArticlesRefresh", String.format(str, id));

        map.clear();
        map.put("offset", String.valueOf(offset));
        map.put("count", "30");
        map.put("reverse", "0");
        map.put("sort", "time");
        str = StringUtils.getGetUrl(Contants.SUBCATEGORYSELECTION_PATH, map);
        httpUtils.getStrGET("SubCategorySelectionRefres", String.format(str, id));
    }

    private void HttpUtilsInit() {
        httpUtils = new HttpUtils();
        httpUtils.setCallBack(this);

        page = 1;
        offset = 0;
        Map<String, String> map = new TreeMap<>();
        map.put("page", String.valueOf(page));
        map.put("size", "4");
        String str = StringUtils.getGetUrl(Contants.SUBCATEGORYARTICLES_PATH, map);
        httpUtils.getStrGET("SubCategoryArticles", String.format(str, id));

        map.clear();
        map.put("offset", String.valueOf(offset));
        map.put("count", "30");
        map.put("reverse", "0");
        map.put("sort", "time");
        str = StringUtils.getGetUrl(Contants.SUBCATEGORYSELECTION_PATH, map);
        httpUtils.getStrGET("SubCategorySelection", String.format(str, id));
    }

    private void initGetIntent() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        title = intent.getStringExtra("title");
        tv_title.setText(title);
    }

    @Override
    public void sendStr(String type, String str) {
        switch (type) {
            case "SubCategoryArticles":
                ArticlesInit(str);
                break;
            case "SubCategorySelection":
                SelectionInit(str);
                break;
            case "SubCategoryArticlesRefresh":
                ArticlesRefresh(str);
                break;
            case "SubCategorySelectionRefres":
                SelectionRefresh(str);
                break;
            case "SubCategorySelectionUpdata":
                SelectionUpdata(str);
                break;
        }
    }

    private void SelectionUpdata(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategoryEntityBean new_entityBean = gson.fromJson("{\"bean\": " + str + "}", SubCategoryEntityBean.class);
        if (new_entityBean != null && new_entityBean.getBean().size() != 0) {
            entityBean.getBean().addAll(new_entityBean.getBean());
            entityAdapter.notifyDataSetChanged();
        }
        pullView.onRefreshComplete();
    }

    private void SelectionRefresh(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategoryEntityBean new_entityBean = gson.fromJson("{\"bean\": " + str + "}", SubCategoryEntityBean.class);
        if (new_entityBean != null) {
            entityBean.getBean().clear();
            entityBean.getBean().addAll(new_entityBean.getBean());
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
        entityBean = gson.fromJson("{\"bean\": " + str + "}", SubCategoryEntityBean.class);
        if (entityBean != null) {
            entityAdapter = new SubCategoryEntityAdapter(SubCategoryActivity.this, entityBean.getBean());
            gridView.setAdapter(entityAdapter);
            gridView.setListViewHeightBasedOnChildren(gridView, 2);
        } else {
            Toast.makeText(SubCategoryActivity.this, "当前没有网络，数据加载失败", Toast.LENGTH_SHORT).show();
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
                    tv_more.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(SubCategoryActivity.this, CategoryMoreArticlesActivity.class);
                            intent.putExtra("id", id);
                            intent.putExtra("title", title);
                            intent.putExtra("path", Contants.SUBCATEGORYARTICLES_PATH);
                            startActivity(intent);
                        }
                    });
                } else {
                    tv_more.setVisibility(View.GONE);
                }

                articlesAdapter = new SubCategoryArticlesAdapter(SubCategoryActivity.this, articlesBean.getArticles());
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
            dialog = new CostumDialog(SubCategoryActivity.this);
            dialog.show();
            isFirst = false;
        }
    }

    @Override
    public void sendStrAfter(String type) {

    }
}

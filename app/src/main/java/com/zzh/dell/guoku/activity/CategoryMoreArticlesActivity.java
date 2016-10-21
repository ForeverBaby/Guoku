package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.SubCategoryArticlesAdapter;
import com.zzh.dell.guoku.bean.SubCategoryArticlesBean;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.utils.GsonUtils;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryMoreArticlesActivity extends AppCompatActivity implements HttpCallBack {

    @BindView(R.id.category_more_articles_title)
    TextView tv_title;
    private SubCategoryArticlesBean articlesBean;
    private SubCategoryArticlesAdapter articlesAdapter;

    @OnClick(R.id.category_more_articles_back)
    void back() {
        finish();
    }

    @BindView(R.id.category_more_articles_list)
    PullToRefreshListView listView;

    String id;
    String title;
    String path;

    private HttpUtils httpUtils;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_more_articles);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        title = intent.getStringExtra("title");
        path = intent.getStringExtra("path");

        tv_title.setText(title+" 全部图文");
        pulltorefreshInit();
        HttpUtilsInit();
    }

    private void pulltorefreshInit() {
        listView.setMode(PullToRefreshBase.Mode.BOTH);


        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                HttpUtilsRefresh();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                HttpUtilsUpdata();
            }
        });
    }

    private void HttpUtilsUpdata() {
        page++;
        Map<String, String> map = new TreeMap<>();
        map.put("page", String.valueOf(page));
        map.put("size", "30");
        String str = StringUtils.getGetUrl(path , map);
        httpUtils.getStrGET("MoreCategoryArticlesUpdate", String.format(str, id));
    }

    private void HttpUtilsRefresh() {
        page = 1;
        Map<String, String> map = new TreeMap<>();
        map.put("page", String.valueOf(page));
        map.put("size", "30");
        String str = StringUtils.getGetUrl(path , map);
        httpUtils.getStrGET("MoreSubCategoryArticlesRefresh", String.format(str, id));
    }

    private void HttpUtilsInit() {
        httpUtils = new HttpUtils();
        httpUtils.setCallBack(this);

        page = 1;
        Map<String, String> map = new TreeMap<>();
        map.put("page", String.valueOf(page));
        map.put("size", "30");
        String str = StringUtils.getGetUrl(path , map);
        httpUtils.getStrGET("MoreSubCategoryArticles", String.format(str, id));
    }

    @Override
    public void sendStr(String type, String str) {
        switch (type) {
            case "MoreSubCategoryArticles":
                ArticlesInit(str);
                break;
            case "MoreSubCategoryArticlesRefresh":
                ArticlesRefresh(str);
                break;
            case "MoreCategoryArticlesUpdate":
                SelectionUpdata(str);
                break;
        }
    }

    private void SelectionUpdata(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategoryArticlesBean new_articlesBean = gson.fromJson(str, SubCategoryArticlesBean.class);
        if (new_articlesBean != null && new_articlesBean.getArticles().size() != 0) {
            articlesBean.getArticles().addAll(new_articlesBean.getArticles());
            articlesAdapter.notifyDataSetChanged();
        }
        listView.onRefreshComplete();
    }

    private void ArticlesRefresh(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategoryArticlesBean new_articlesBean = gson.fromJson(str, SubCategoryArticlesBean.class);
        if (new_articlesBean != null && new_articlesBean.getArticles().size() != 0) {
            articlesBean.getArticles().clear();
            articlesBean.getArticles().addAll(new_articlesBean.getArticles());
            articlesAdapter.notifyDataSetChanged();
        }
        listView.onRefreshComplete();
    }

    private void ArticlesInit(String str) {
        Gson gson = GsonUtils.getGson();
        articlesBean = gson.fromJson(str, SubCategoryArticlesBean.class);
        if (articlesBean != null && articlesBean.getArticles().size() != 0) {
            articlesAdapter = new SubCategoryArticlesAdapter(CategoryMoreArticlesActivity.this, articlesBean.getArticles());
            listView.setAdapter(articlesAdapter);
        }else{
            Toast.makeText(CategoryMoreArticlesActivity.this, "当前没有网络，数据加载失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void sendStrbefore(String type) {

    }

    @Override
    public void sendStrAfter(String type) {

    }
}

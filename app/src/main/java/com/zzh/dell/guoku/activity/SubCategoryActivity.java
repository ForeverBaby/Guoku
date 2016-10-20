package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CustomMeasureGridView;
import com.zzh.dell.guoku.view.CustomMeasureListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SubCategoryActivity extends AppCompatActivity implements HttpCallBack {

    private int offset = 0;
    private int tag = 0;
    private String id;
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
        httpUtils.setCallBack(this);
        httpUtils.getStrGET("SubCategorySelectionUpdata",
                String.format(Contants.SUBCATEGORYSELECTION_PATH, id, "0", "30", "0", "time",
                        "2a10b080ae6a172a3bbf1e28662894d4",
                        api_key));
    }

    private void HttpUtilsRefresh() {
        httpUtils.setCallBack(this);
        httpUtils.getStrGET("SubCategoryArticlesRefresh",
                String.format(Contants.SUBCATEGORYARTICLES_PATH, id, "1", "3",
                        "7f45ec66700b30a54fb30c30cfaf72b4",
                        api_key));
        offset = 0;
        httpUtils.getStrGET("SubCategorySelectionRefres",
                String.format(Contants.SUBCATEGORYSELECTION_PATH, id, String.valueOf(offset), "30", "0", "time",
                        "2a10b080ae6a172a3bbf1e28662894d4",
                        api_key));
    }

    private void HttpUtilsInit() {
        id = "125";
        httpUtils = new HttpUtils();
        httpUtils.setCallBack(this);
        httpUtils.getStrGET("SubCategoryArticles",
                String.format(Contants.SUBCATEGORYARTICLES_PATH, id, "1", "3",
                        "7f45ec66700b30a54fb30c30cfaf72b4",
                        api_key));
        offset = 0;
        httpUtils.getStrGET("SubCategorySelection",
                String.format(Contants.SUBCATEGORYSELECTION_PATH, id, String.valueOf(offset), "30", "0", "time",
                        "2a10b080ae6a172a3bbf1e28662894d4",
                        api_key));
    }

    private void initGetIntent() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
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
        entityBean.getBean().addAll(new_entityBean.getBean());
        entityAdapter.notifyDataSetChanged();
        pullView.onRefreshComplete();
    }

    private void SelectionRefresh(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategoryEntityBean new_entityBean = gson.fromJson("{\"bean\": " + str + "}", SubCategoryEntityBean.class);
        entityBean.getBean().clear();
        entityBean.getBean().addAll(new_entityBean.getBean());
        entityAdapter.notifyDataSetChanged();
        tag++;
        if (tag == 2) {
            pullView.onRefreshComplete();
            tag = 0;
        }
    }

    private void ArticlesRefresh(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategoryArticlesBean new_articlesBean = gson.fromJson(str, SubCategoryArticlesBean.class);

        articlesBean.getArticles().clear();
        articlesBean.getArticles().addAll(new_articlesBean.getArticles());
        articlesAdapter.notifyDataSetChanged();
        tag++;
        if (tag == 2) {
            pullView.onRefreshComplete();
            tag = 0;
        }
    }

    private void SelectionInit(String str) {
        Gson gson = GsonUtils.getGson();
        entityBean = gson.fromJson("{\"bean\": " + str + "}", SubCategoryEntityBean.class);
        entityAdapter = new SubCategoryEntityAdapter(SubCategoryActivity.this, entityBean.getBean());
        gridView.setAdapter(entityAdapter);
        gridView.setListViewHeightBasedOnChildren(gridView, 2);

    }

    private void ArticlesInit(String str) {
        Gson gson = GsonUtils.getGson();
        articlesBean = gson.fromJson(str, SubCategoryArticlesBean.class);
        if (articlesBean.getArticles().size() == 0) {
            relativeLayout.setVisibility(View.GONE);
            listView.setVisibility(View.GONE);
        } else {
            if (articlesBean.getArticles().size() > 3) {
                articlesBean.getArticles().remove(3);
            } else {
                tv_more.setVisibility(View.GONE);
            }

            articlesAdapter = new SubCategoryArticlesAdapter(SubCategoryActivity.this, articlesBean.getArticles());
            listView.setAdapter(articlesAdapter);
            listView.setListViewHeightBasedOnChildren(listView);
        }

    }


    @Override
    public void sendStrbefore(String type) {

    }

    @Override
    public void sendStrAfter(String type) {

    }
}

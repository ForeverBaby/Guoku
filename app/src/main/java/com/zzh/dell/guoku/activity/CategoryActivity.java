package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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
import com.zzh.dell.guoku.utils.GsonUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CustomMeasureGridView;
import com.zzh.dell.guoku.view.CustomMeasureListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryActivity extends AppCompatActivity implements HttpCallBack {

    private int page = 1;
    private int tag = 0;
    private String id;
    private String api_key = "0b19c2b93687347e95c6b6f5cc91bb87";

    SubCategoryArticlesBean articlesBean;
    SubCategorySelectionBean selectionBean;
    CategoryBean categoryBean;

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
    }

    private void linearLayoutInit(String str) {
        Gson gson = GsonUtils.getGson();
//        categoryBean = gson.fromJson("{\"bean\": " + str + "}", CategoryBean.class);

    }

    private void initGetIntent() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        tv_title.setText(title);
    }

    private void HttpUtilsUpdata() {
        HttpUtils httpUtils = HttpUtils.getIntance();
        httpUtils.setCallBack(this);
        httpUtils.getStrGET("CategorySelectionUpdata",
                String.format(Contants.CATEGORYSELECTION_PATH, id, "1", "time",
                        "2a42c35005f57af37a930629b5e00aa5",
                        api_key));
    }

    private void HttpUtilsRefresh() {
        HttpUtils httpUtils = HttpUtils.getIntance();
        httpUtils.setCallBack(this);
        httpUtils.getStrGET("CategoryArticlesRefresh",
                String.format(Contants.CATEGORYARTICLES_PATH, id, "1", "3",
                        "7f45ec66700b30a54fb30c30cfaf72b4",
                        api_key));
        httpUtils.getStrGET("CategorySelectionRefresh",
                String.format(Contants.CATEGORYSELECTION_PATH, id, "1", "time",
                        "2a42c35005f57af37a930629b5e00aa5",
                        api_key));
    }

    private void HttpUtilsInit() {
        HttpUtils httpUtils = HttpUtils.getIntance();
        httpUtils.setCallBack(this);
        httpUtils.getStrGET("CategoryArticles",
                String.format(Contants.CATEGORYARTICLES_PATH, id, "1", "3",
                        "7f45ec66700b30a54fb30c30cfaf72b4",
                        api_key));
        httpUtils.getStrGET("CategorySelection",
                String.format(Contants.CATEGORYSELECTION_PATH, id, "1", "time",
                        "2a42c35005f57af37a930629b5e00aa5",
                        api_key));
        httpUtils.getStrGET("CategoryGet", String.format(Contants.CATEGORY_MAIN_PATH
                , "b6fbc461c473452b1fa344ae6d1af2c2"
                , api_key));
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
            case "CategoryGet":
                linearLayoutInit(str);
                break;
        }
    }

    private void SelectionUpdata(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategorySelectionBean new_entityBean = gson.fromJson("{\"bean\": " + str + "}", SubCategorySelectionBean.class);
        selectionBean.getBean().addAll(new_entityBean.getBean());
        entityAdapter.notifyDataSetChanged();
        pullView.onRefreshComplete();
    }

    private void SelectionRefresh(String str) {
        Gson gson = GsonUtils.getGson();
        SubCategorySelectionBean new_entityBean = gson.fromJson("{\"bean\": " + str + "}", SubCategorySelectionBean.class);
        selectionBean.getBean().clear();
        selectionBean.getBean().addAll(new_entityBean.getBean());
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
        selectionBean = gson.fromJson("{\"bean\": " + str + "}", SubCategorySelectionBean.class);
        entityAdapter = new SubCategorySelectionAdapter(CategoryActivity.this, selectionBean.getBean());
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
                tv_articles_more.setVisibility(View.GONE);
            }

            articlesAdapter = new SubCategoryArticlesAdapter(CategoryActivity.this, articlesBean.getArticles());
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
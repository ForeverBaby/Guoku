package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.SubCategoryArticlesAdapter;
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


public class SubCategoryActivity extends AppCompatActivity implements HttpCallBack {

    private String id;
    SubCategoryArticlesBean articlesBean;
    SubCategorySelectionBean selectionBean;

    @BindView(R.id.sub_category_pulltorefresh)
    PullToRefreshScrollView pullView;

    @BindView(R.id.sub_category_more)
    TextView tv_more;

    @BindView(R.id.sub_category_articles_list)
    CustomMeasureListView listView;

    @BindView(R.id.sub_category_entity_grid)
    CustomMeasureGridView gridView;

    SubCategoryArticlesAdapter articlesAdapter;

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
    }

    private void HttpUtilsInit() {
        HttpUtils httpUtils = HttpUtils.getIntance();
        httpUtils.setCallBack(this);
        httpUtils.getStrGET("SubCategoryArticles",
                String.format(Contants.SUBCATEGORYARTICLES_PATH, id, "1", "3",
                        "7f45ec66700b30a54fb30c30cfaf72b4",
                        "0b19c2b93687347e95c6b6f5cc91bb87"));

        httpUtils.getStrGET("SubCategorySelection",
                String.format(Contants.SUBCATEGORYSELECTION_PATH, id, "1", "time",
                        "2a42c35005f57af37a930629b5e00aa5",
                        "0b19c2b93687347e95c6b6f5cc91bb87"));
    }

    private void initGetIntent() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
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
        }
    }

    private void SelectionInit(String str) {
        Gson gson = GsonUtils.getGson();
        selectionBean = gson.fromJson("{\"bean\": " + str + "}", SubCategorySelectionBean.class);
//        Log.e("moeta", String.valueOf(selectionBean.getBean().size()));

    }

    private void ArticlesInit(String str) {
        Gson gson = GsonUtils.getGson();
        articlesBean = gson.fromJson(str, SubCategoryArticlesBean.class);
//        Log.e("moeta", String.valueOf(articlesBean.getArticles().size()));
        articlesAdapter = new SubCategoryArticlesAdapter(SubCategoryActivity.this,articlesBean.getArticles());
        listView.setAdapter(articlesAdapter);
        listView.setListViewHeightBasedOnChildren(listView);
    }


    @Override
    public void sendStrbefore(String type) {

    }

    @Override
    public void sendStrAfter(String type) {

    }
}

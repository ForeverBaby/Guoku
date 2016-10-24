package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.ArticlesCategoryAdapter;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.bean.CategoryMainBean;
import com.zzh.dell.guoku.bean.MyLikeActBean;
import com.zzh.dell.guoku.bean.Sharebean;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.fragment.MeFragment;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CostumDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserArticleListActivity extends AppCompatActivity implements HttpCallBack {
    @BindView(R.id.pull_listview)
    PullToRefreshListView pull_listview;

    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    HttpUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_article_list);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
        }
        utils = new HttpUtils();
        utils.setCallBack(this);
        init();

    }


    Account.UserBean user;

    @OnClick(R.id.title_bar_left_iv)
    void back() {
        finish();
    }

    public void isDataEmpty(boolean paramBoolean, View paramView1, View paramView2) {
        if (paramBoolean) {
            paramView2.setVisibility(View.VISIBLE);
            paramView1.setVisibility(View.GONE);
        } else {
            paramView1.setVisibility(View.VISIBLE);
            paramView2.setVisibility(View.GONE);
        }
    }


    String str;
    protected void setupData() {
        Bundle data = getIntent().getBundleExtra("data");
        str = data.getString(MeFragment.class.getName());
        user = data.getParcelable("INTENT_CODE");
        title_bar_centrt_tv.setText(str);
        title_bar_left_iv.setImageResource(R.drawable.back_selector);
        if (data.getBoolean("IS_EMPTY")) {
            isDataEmpty(true, pull_listview, this.tvEmpty);
            TextView localTextView = this.tvEmpty;
            Resources localResources = getResources();
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = StringUtils.setSubstring(str, -2 + str.length(), str.length());
            localTextView.setText(localResources.getString(R.string.tv_empty_other, arrayOfObject));
        } else {
            isDataEmpty(false, pull_listview, this.tvEmpty);
            getData(page, "1001");
        }
    }

    ArticlesCategoryAdapter articlesCategoryAdapter;
    List<MyLikeActBean.ArticlesBean> list;
    int page = 1;
    int countValue = 30;


    private void init() {
        list = new ArrayList<>();
        this.articlesCategoryAdapter = new ArticlesCategoryAdapter(list, this);
        pull_listview.setAdapter(articlesCategoryAdapter);
        setupData();
        pull_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
                Bundle localBundle = new Bundle();
                Sharebean localSharebean = new Sharebean();
                localSharebean.setTitle(articlesCategoryAdapter.getItem(paramInt - 1).getTitle());
                if (articlesCategoryAdapter.getItem(paramInt - 1).getContent().length() > 50) {
                    localSharebean.setContext(articlesCategoryAdapter.getItem(paramInt - 1).getContent().substring(0, 50));
                }
                localSharebean.setAricleUrl(articlesCategoryAdapter.getItem(paramInt - 1).getUrl());
                localSharebean.setImgUrl(articlesCategoryAdapter.getItem(paramInt - 1).getCover());
                localSharebean.setIs_dig(articlesCategoryAdapter.getItem(paramInt - 1).isIs_dig());
                localSharebean.setAricleId(String.valueOf(articlesCategoryAdapter.getItem(paramInt-1).getArticle_id()));
                localSharebean.setContext(articlesCategoryAdapter.getItem(paramInt-1).getContent());
                localBundle.putParcelable(WebShareActivity.class.getName(), localSharebean);
                Intent intent = new Intent(UserArticleListActivity.this, WebShareActivity.class);
                intent.putExtra("share", localBundle);
                startActivity(intent);
                finish();
            }
        });
        pull_listview.setPullToRefreshOverScrollEnabled(false);
        pull_listview.setScrollingWhileRefreshingEnabled(false);
        pull_listview.setMode(PullToRefreshBase.Mode.BOTH);
        pull_listview.setRefreshing();
        pull_listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase refreshView) {
                page = 1;
                getData(page, "1001");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
                UserArticleListActivity localUserArticleListAct = UserArticleListActivity.this;
                localUserArticleListAct.page = (1 + localUserArticleListAct.page);
                getData(localUserArticleListAct.page, "1002");
            }
        });

    }

    private void getData(int paramInt1, String type) {
        String str = "http://api.guoku.com/mobile/v4/user/" + user.getUser_id() + "/dig/articles/";
        Map<String, String> map = new ArrayMap<>();
        map.put("size", String.valueOf(this.countValue));
        map.put("page", paramInt1 + "");
        String getUrl = StringUtils.getGetUrl(str, map);
        utils.getStrGET(type, getUrl);
    }


    @Override
    public void sendStr(String type, String str) {
        this.pull_listview.onRefreshComplete();
        Gson gson = new Gson();
        if (str != null&&str.length()>20) {
            switch (type) {
                case "1001":
                    list.clear();
                    MyLikeActBean myLikeActBean = gson.fromJson(str, MyLikeActBean.class);
                    list.addAll(myLikeActBean.getArticles());
                    break;
                case "1002":
                    MyLikeActBean myLikeActBean2 = gson.fromJson(str, MyLikeActBean.class);
                    list.addAll(list.size(), myLikeActBean2.getArticles());
                    break;
            }
            articlesCategoryAdapter.notifyDataSetChanged();
        }

    }

    CostumDialog dialog;

    @Override
    public void sendStrbefore(String type) {
        dialog = new CostumDialog(this);
        dialog.show();

    }

    @Override
    public void sendStrAfter(String type) {
        dialog.dismiss();
    }
}

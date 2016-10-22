package com.zzh.dell.guoku.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.MyGoodsAdapter;
import com.zzh.dell.guoku.adapter.SearchArticlesAdapter;
import com.zzh.dell.guoku.adapter.SearchEntityAdapter;
import com.zzh.dell.guoku.bean.SearchArticlesBean;
import com.zzh.dell.guoku.bean.SearchEntityBean;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.callback.SearchListCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.fragment.SearchListFragment;
import com.zzh.dell.guoku.utils.GsonUtils;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity implements SearchListCallBack, HttpCallBack {

    @BindView(R.id.cancel)
    TextView tv_cancel;

    @OnClick(R.id.cancel)
    void cancel() {
        finish();
    }

    @BindView(R.id.search_edit)
    EditText editText;

    @BindView(R.id.img_delete)
    ImageView img_delete;

    @OnClick(R.id.img_delete)
    void delete() {
        editText.setText("");
    }

    @BindView(R.id.tab_layout)
    TabLayout indicator;

    @BindView(R.id.pager)
    ViewPager viewPage;

    String search;
    int prePos = 0;

    @BindView(R.id.main_line)
    LinearLayout main_line;
    private SearchListFragment entityFragment;
    private SearchListFragment articlesFragment;
    private SearchListFragment categoryFragment;
    private SearchListFragment userFragment;
    HttpUtils httpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        search = intent.getStringExtra("search");

        initView();
        initFragment();
        addFraToPager();
        initListener();
        searchString(search);
    }

    int width = 0;

    private void initFragment() {
        DisplayMetrics m = new DisplayMetrics();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        defaultDisplay.getMetrics(m);
        width = m.widthPixels / 4;
        main_line.setLayoutParams(new LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT));

        entityFragment = new SearchListFragment(SearchListFragment.ENTITYFRAGMENT);
        entityFragment.setCallBack(this);
        articlesFragment = new SearchListFragment(SearchListFragment.ARTICLESFRAGMENT);
        articlesFragment.setCallBack(this);
        categoryFragment = new SearchListFragment(SearchListFragment.CATEGORYFRAGMENT);
        categoryFragment.setCallBack(this);
        userFragment = new SearchListFragment(SearchListFragment.USERFRAGMENT);
        userFragment.setCallBack(this);
    }

    private void initView() {
        editText.setText(search);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {// 修改回车键功能
                    editText.clearFocus();
                    search = editText.getText().toString();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm.isActive()) {
                        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                    searchString(search);
                    return true;
                }
                return false;
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    tv_cancel.setVisibility(View.VISIBLE);
                    img_delete.setVisibility(View.VISIBLE);
                } else {
                    tv_cancel.setVisibility(View.GONE);
                    img_delete.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initListener() {
        viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                startAnima(position, prePos);
                prePos = position;
            }

            void startAnima(int pos, int prePos) {
                Animation anim = new TranslateAnimation(prePos * width, pos * width, 0, 0);
                anim.setDuration(300);
                anim.setFillAfter(true);
                main_line.startAnimation(anim);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addFraToPager() {
        List<Fragment> listFragment = new ArrayList<>();
        String[] str = new String[]{
                "商品", "图文", "分类", "用户"
        };
        listFragment.add(entityFragment);
        listFragment.add(articlesFragment);
        listFragment.add(categoryFragment);
        listFragment.add(userFragment);

        FragmentManager fm = getSupportFragmentManager();
        MyGoodsAdapter adapter = new MyGoodsAdapter(fm, listFragment, str);
        viewPage.setAdapter(adapter);

        indicator.setSelectedTabIndicatorColor(getResources().getColor(android.R.color.transparent));
        indicator.setupWithViewPager(viewPage);
    }

    int entityOffset = 0;
    int articlesPage = 1;
    int userOffset = 0;
    SearchEntityBean entityBean;
    SearchEntityAdapter entityAdapter;
    SearchArticlesBean articlesBean;
    SearchArticlesAdapter articlesAdapter;

    void searchString(String searchStr) {
        entityOffset = 0;
        articlesPage = 1;
        userOffset = 0;

        httpUtils = new HttpUtils();
        httpUtils.setCallBack(this);
        Map<String, String> map = new TreeMap<>();
        map.put("count", "30");
        map.put("offset", String.valueOf(entityOffset));
        map.put("q", searchStr);
        map.put("type", "all");

        String str = StringUtils.getGetUrl(Contants.SEARCH_ENTITY_PATH, map);
        httpUtils.getStrGET("EntitySearch", str);

        map.clear();
        map.put("q", searchStr);
        map.put("page", String.valueOf(articlesPage));
        map.put("size", "30");

        str = StringUtils.getGetUrl(Contants.SEARCH_ARTICLES_PATH, map);
        httpUtils.getStrGET("ArticlesSearch", str);

        map.clear();
        map.put("count", "30");
        map.put("offset", String.valueOf(userOffset));
        map.put("q", searchStr);
        map.put("type", "all");

        str = StringUtils.getGetUrl(Contants.SEARCH_USER_PATH, map);
        httpUtils.getStrGET("UserSearch", str);


    }

    private void entitySearch(String str) {
        Gson gson = GsonUtils.getGson();
        entityBean = gson.fromJson(str, SearchEntityBean.class);
        if (entityBean != null && entityBean.getEntity_list().size() != 0) {
            entityAdapter = new SearchEntityAdapter(SearchActivity.this, entityBean.getEntity_list());
            entityFragment.setAdapter(entityAdapter);
        }
        entityFragment.setComplete();
    }

    private void updateEntity(String str) {
        Gson gson = GsonUtils.getGson();
        SearchEntityBean new_bean = gson.fromJson(str, SearchEntityBean.class);
        if (new_bean != null && new_bean.getEntity_list().size() != 0) {
            entityBean.getEntity_list().addAll(new_bean.getEntity_list());
            entityAdapter.notifyDataSetChanged();
        }
        entityFragment.setComplete();
    }

    private void articlesSearch(String str) {
        Gson gson = GsonUtils.getGson();
        articlesBean = gson.fromJson(str, SearchArticlesBean.class);
        if (articlesBean != null && articlesBean.getArticles().size() != 0) {
            articlesAdapter = new SearchArticlesAdapter(articlesBean.getArticles(),SearchActivity.this);
            articlesFragment.setAdapter(articlesAdapter);
        }
        articlesFragment.setComplete();
    }

    private void updateArticlse(String str) {
        Gson gson = GsonUtils.getGson();
        SearchArticlesBean new_bean = gson.fromJson(str, SearchArticlesBean.class);
        if (new_bean != null && new_bean.getArticles().size() != 0) {
            articlesBean.getArticles().addAll(new_bean.getArticles());
            articlesAdapter.notifyDataSetChanged();
        }
        articlesFragment.setComplete();
    }

    private void userSearch(String str) {
    }

    private void updateUser(String str) {
    }


    @Override
    public void upDate(int type) {
        Map<String, String> map = new TreeMap<>();
        switch (type) {
            case SearchListFragment.ENTITYFRAGMENT:
                entityOffset += 30;
                map.clear();
                httpUtils = new HttpUtils();
                httpUtils.setCallBack(this);
                map.put("count", "30");
                map.put("offset", String.valueOf(entityOffset));
                map.put("q", search);
                map.put("type", "all");
                String str = StringUtils.getGetUrl(Contants.SEARCH_ENTITY_PATH, map);
                httpUtils.getStrGET("EntitySearchUpdate", str);
                break;
            case SearchListFragment.ARTICLESFRAGMENT:
                articlesPage++;
                map.clear();
                map.put("q", search);
                map.put("page", String.valueOf(articlesPage));
                map.put("size", "30");
                str = StringUtils.getGetUrl(Contants.SEARCH_ARTICLES_PATH, map);
                httpUtils.getStrGET("ArticlesSearchUpdate", str);
                break;
            case SearchListFragment.CATEGORYFRAGMENT:

                break;
            case SearchListFragment.USERFRAGMENT:
                userOffset += 30;
                map.clear();
                map.put("count", "30");
                map.put("offset", String.valueOf(userOffset));
                map.put("q", search);
                map.put("type", "all");
                str = StringUtils.getGetUrl(Contants.SEARCH_USER_PATH, map);
                httpUtils.getStrGET("UserSearchUpdate", str);
                break;
        }
    }


    @Override
    public void sendStr(String type, String str) {
        switch (type) {
            case "EntitySearch":
                entitySearch(str);
                break;
            case "ArticlesSearch":
                articlesSearch(str);
                break;
            case "UserSearch":
                userSearch(str);
                break;
            case "EntitySearchUpdate":
                updateEntity(str);
                break;
            case "ArticlesSearchUpdate":
                updateArticlse(str);
                break;
            case "UserSearchUpdate":
                updateUser(str);
                break;
        }
    }

    @Override
    public void sendStrbefore(String type) {
    }

    @Override
    public void sendStrAfter(String type) {
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_anim, R.anim.alpha_out);
    }
}

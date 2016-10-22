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

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.MyGoodsAdapter;
import com.zzh.dell.guoku.callback.SearchListCallBack;
import com.zzh.dell.guoku.fragment.SearchListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity implements SearchListCallBack {

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

    void searchString(String str){

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
        entityFragment.init();
        articlesFragment = new SearchListFragment(SearchListFragment.ARTICLESFRAGMENT);
        articlesFragment.setCallBack(this);
        articlesFragment.init();
        categoryFragment = new SearchListFragment(SearchListFragment.CATEGORYFRAGMENT);
        categoryFragment.setCallBack(this);
        categoryFragment.init();
        userFragment = new SearchListFragment(SearchListFragment.USERFRAGMENT);
        userFragment.setCallBack(this);
        userFragment.init();
    }

    @Override
    public void upDate(int type) {
        switch (type) {
            case SearchListFragment.ENTITYFRAGMENT:

                break;
            case SearchListFragment.ARTICLESFRAGMENT:

                break;
            case SearchListFragment.CATEGORYFRAGMENT:

                break;
            case SearchListFragment.USERFRAGMENT:

                break;
        }
    }

    @Override
    public void init(int type) {
        switch (type) {
            case SearchListFragment.ENTITYFRAGMENT:

                break;
            case SearchListFragment.ARTICLESFRAGMENT:

                break;
            case SearchListFragment.CATEGORYFRAGMENT:

                break;
            case SearchListFragment.USERFRAGMENT:

                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_anim,R.anim.alpha_out);
    }
}

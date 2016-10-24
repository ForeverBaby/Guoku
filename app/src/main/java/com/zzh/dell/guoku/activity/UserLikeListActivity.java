package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.LikeGridAdapter;
import com.zzh.dell.guoku.adapter.TagTextAdapter;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.bean.Entity2;
import com.zzh.dell.guoku.bean.LikeBean;
import com.zzh.dell.guoku.bean.MeEntity;
import com.zzh.dell.guoku.bean.Tag;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.fragment.MeFragment;
import com.zzh.dell.guoku.utils.CategoryDBInfo;
import com.zzh.dell.guoku.utils.CategoryDBManager;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CostumDialog;
import com.zzh.dell.guoku.view.ScrollViewWithGridView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserLikeListActivity extends AppCompatActivity implements HttpCallBack {
    HttpUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_like_list);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
        }
        utils = new HttpUtils();
        utils.setCallBack(this);
        setupData();
        init();
        initComment();
    }

    @BindView(R.id.list_tag)
    ListView listTag;
    @BindView(R.id.tv_tag_select)
    TextView tv_tag_select;


    TagTextAdapter tagAdapter;
    List<Tag> list;

    @OnClick(R.id.tv_check_net)
    void onCheckNetClick(View paramView) {
        getLikeData("1001");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && listTag.getVisibility() == View.VISIBLE) {
            hideSearchWhat();
            return true;

        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick(R.id.view_back_black)
    void backlack() {
        if (listTag.getVisibility() == View.VISIBLE) {
            hideSearchWhat();
        }
    }

    @OnClick(R.id.layout_comment_title)
    void clicke() {
        if (listTag.getVisibility() == View.VISIBLE) {
            hideSearchWhat();
        } else {
            showSearchWhat();
        }
    }
    int count = 0;
    private void initComment() {
        list = new ArrayList<>();
        CategoryDBManager dbManager = CategoryDBManager.getDbManager(this);
        Cursor cursor = dbManager.queryNoSelection();
        Tag tag = new Tag();
        tag.setTitle("所有");
        tag.setGroup_id(0);
        list.add(tag);
        while (cursor.moveToNext()&&count <12) {
            Tag a = new Tag();
            a.setGroup_id(cursor.getInt(cursor.getColumnIndex(CategoryDBInfo.GROUP_ID)));
            a.setTitle(cursor.getString(cursor.getColumnIndex(CategoryDBInfo.GROUP_TITLE)));
            list.add(a);
            count++;
        }
        this.tagAdapter = new TagTextAdapter(this, list);
        this.listTag.setAdapter(this.tagAdapter);
        DisplayMetrics m = new DisplayMetrics();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        defaultDisplay.getMetrics(m);
        ViewGroup.LayoutParams localLayoutParams = this.listTag.getLayoutParams();
        localLayoutParams.height = (m.heightPixels / 3);
        this.listTag.setLayoutParams(localLayoutParams);
        this.listTag.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
                tv_tag_select.setText(tagAdapter.getItem(paramInt).getTitle());
                cidTag = String.valueOf(tagAdapter.getItem(paramInt).getGroup_id());
                getLikeData("1001");
                hideSearchWhat();
            }
        });
    }


    @BindView(R.id.sv)
    PullToRefreshScrollView sv;
    LikeGridAdapter adapter;
    List<LikeBean.EntityListBean> listBeen;
    @BindView(R.id.tab_gv)
    ScrollViewWithGridView tab_gv;

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    private void getShopInfo(String paramString, String type) {
        Map<String, String> map = new ArrayMap<>();
        map.put("entity_id", paramString);
        String getUrl = StringUtils.getGetUrl("http://api.guoku.com/mobile/v4/entity/" + paramString + "/", map);
        Log.e("===","==="+getUrl);
        utils.getStrGET(type, getUrl);
    }

    int countValue = 30;

    @OnClick(R.id.title_bar_left_iv)
    void back() {
        finish();
    }

    private void init() {
        DisplayMetrics m = new DisplayMetrics();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        defaultDisplay.getMetrics(m);
        listBeen = new ArrayList<>();
        adapter = new LikeGridAdapter(listBeen, this, m.widthPixels, 3);
        if (adapter != null) {
            this.tab_gv.setAdapter(adapter);
        }
        this.tab_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
                getShopInfo(String.valueOf(adapter.getItem(paramInt).getEntity_id()), "Entity");
            }
        });
        this.sv.setMode(PullToRefreshBase.Mode.BOTH);
        this.sv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {
            public void onPullDownToRefresh(PullToRefreshBase paramPullToRefreshBase) {
                countValue = 30;
                getLikeData(1001 + "");
            }

            public void onPullUpToRefresh(PullToRefreshBase paramPullToRefreshBase) {
                UserLikeListActivity localUserLikeListAct = UserLikeListActivity.this;
                localUserLikeListAct.countValue = (30 + localUserLikeListAct.countValue);
                getLikeData(1003 + "");
            }
        });
    }

    Account.UserBean user;
    @BindView(R.id.layout_data)
    View layoutData;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    protected void setupData() {
        Bundle data = getIntent().getBundleExtra("data");
        String str = data.getString(MeFragment.class.getName());
        user = data.getParcelable("INTENT_CODE");
        title_bar_centrt_tv.setText(str);
        title_bar_left_iv.setImageResource(R.drawable.back_selector);
        if (data.getBoolean("IS_EMPTY")) {
            isDataEmpty(true, this.layoutData, this.tvEmpty);
            TextView localTextView = this.tvEmpty;
            Resources localResources = getResources();
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = StringUtils.setSubstring(str, -2 + str.length(), str.length());
            localTextView.setText(localResources.getString(R.string.tv_empty_other, arrayOfObject));
        } else {
            getLikeData(1001 + "");
        }

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


    private String cidTag = "0";

    private void getLikeData(String paramInt) {
        String str = "http://api.guoku.com/mobile/v4/user/" + this.user.getUser_id() + "/" + "like" + "/";
        Map<String, String> map = new ArrayMap<>();
        map.put("count", String.valueOf(countValue));
        map.put("timestamp", System.currentTimeMillis() / 1000L + "");
        map.put("cid", cidTag);
        String getUrl = StringUtils.getGetUrl(str, map);
        utils.getStrGET(paramInt, getUrl);
    }

    @Override
    public void sendStr(String type, String str) {
        sv.onRefreshComplete();
        Gson gson = new Gson();
        switch (type) {
            case 1001 + "":
                if (str != null) {
                    listBeen.clear();
                    LikeBean likeBean = gson.fromJson(str, LikeBean.class);
                    listBeen.addAll(likeBean.getEntity_list());
                    adapter.notifyDataSetChanged();
                }
                break;
            case "1003":
                if (str != null) {
                    listBeen.clear();
                    sv.getRefreshableView().smoothScrollTo(0, 0);
                    LikeBean likeBean = gson.fromJson(str, LikeBean.class);
                    listBeen.addAll(listBeen.size(), likeBean.getEntity_list());
                    adapter.notifyDataSetChanged();
                }
                break;
            case "Entity":
               Intent intent = new Intent();
                intent.setClass(this, GoodsChildActivity.class);
                MeEntity entityListBean = gson.fromJson(str, MeEntity.class);
                intent.putExtra("cid", entityListBean.getEntity().getCategory_id());
                intent.putExtra("id", entityListBean.getEntity().getEntity_id());
                intent.putExtra("imagePath", entityListBean.getEntity().getChief_image());
                startActivity(intent);
                break;
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

    public Animation animationllHide;
    public Animation animationllShow;

    public void hideSearchWhat() {
        if (view_back_black != null)
            hideBackBlack();
        if (this.animationllHide == null)
            this.animationllHide = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
        this.animationllHide.setDuration(300L);
        listTag.startAnimation(this.animationllHide);
    }

    public Animation animationBackHide;
    public Animation animationBackShow;

    public void hideBackBlack() {

        if (this.animationBackHide == null) {
            this.animationBackHide = new AlphaAnimation(1.0F, 0.0F);
            this.animationBackHide.setAnimationListener(this.animationHideListener);
        }
        this.animationBackHide.setDuration(300L);
        view_back_black.startAnimation(this.animationBackHide);
    }

    public void showBackBlack() {
        if (this.animationBackShow == null) {
            view_back_black.setVisibility(View.VISIBLE);
            this.animationBackShow = new AlphaAnimation(0.0F, 1.0F);
            this.animationBackShow.setAnimationListener(this.animationShowListener);
        }
        this.animationBackShow.setDuration(300L);
        view_back_black.startAnimation(this.animationBackShow);
    }

    @BindView(R.id.view_back_black)
    View view_back_black;
    boolean animIsRunning;
    Animation.AnimationListener animationHideListener = new Animation.AnimationListener() {
        public void onAnimationEnd(Animation paramAnimation) {
            view_back_black.setVisibility(View.INVISIBLE);
            listTag.setVisibility(View.INVISIBLE);
            animIsRunning = false;
        }

        public void onAnimationRepeat(Animation paramAnimation) {
        }

        public void onAnimationStart(Animation paramAnimation) {
            animIsRunning = true;
        }
    };

    public void showSearchWhat() {
        if ( view_back_black!= null) {
            showBackBlack();
        }
        if (this.animationllShow == null)
            this.animationllShow = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
        this.animationllShow.setDuration(300L);
       listTag.startAnimation(this.animationllShow);
    }


    Animation.AnimationListener animationShowListener = new Animation.AnimationListener() {
        public void onAnimationEnd(Animation paramAnimation) {
            animIsRunning = false;
        }

        public void onAnimationRepeat(Animation paramAnimation) {
        }

        public void onAnimationStart(Animation paramAnimation) {
            animIsRunning = true;
            view_back_black.setVisibility(View.VISIBLE);
            listTag.setVisibility(View.VISIBLE);
        }
    };

}

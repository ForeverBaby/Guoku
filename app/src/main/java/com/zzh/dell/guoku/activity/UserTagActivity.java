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
import com.zzh.dell.guoku.adapter.UserTagListAdapter;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.bean.UserTagBean;
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

public class UserTagActivity extends AppCompatActivity implements HttpCallBack {
    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    @BindView(R.id.pull_listview)
    PullToRefreshListView pull_listview;

    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    HttpUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tag);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
        }
        utils = new HttpUtils();
        utils.setCallBack(this);
        init();



    }

    UserTagListAdapter adapter;
    List<UserTagBean.TagsBean> list;

    private void init() {
        list = new ArrayList<>();
        this.adapter = new UserTagListAdapter(this, list);
        pull_listview.setAdapter(this.adapter);
        pull_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
                Intent localIntent = new Intent(UserTagActivity.this, EntityActivity.class);
                localIntent.putExtra("data", String.valueOf(user.getUser_id()));
                localIntent.putExtra("name", adapter.getItem(paramInt - 1).getTag());
                startActivity(localIntent);
            }
        });
        pull_listview.setPullToRefreshOverScrollEnabled(false);
        pull_listview.setScrollingWhileRefreshingEnabled(false);
        pull_listview.setMode(PullToRefreshBase.Mode.BOTH);
        pull_listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase refreshView) {
                countValue = 30;
                getLikeData("tag");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
                countValue = 30 + countValue;
                getLikeData("tag");
            }
        });
        setupData();
    }

    int countValue = 30;

    private void getLikeData(String type) {
        String str = "http://api.guoku.com/mobile/v4/user/" + user.getUser_id() + "/tag/";
        Map<String, String> map = new ArrayMap<>();
        map.put("count", String.valueOf(this.countValue));
        map.put("timestamp", System.currentTimeMillis() / 1000L + "");
        String getUrl = StringUtils.getGetUrl(str, map);
        utils.getStrGET(type, getUrl);
    }

    Account.UserBean user;

    public void isDataEmpty(boolean paramBoolean, View paramView1, View paramView2) {
        if (paramBoolean) {
            paramView2.setVisibility(View.VISIBLE);
            paramView1.setVisibility(View.GONE);
        } else {
            paramView1.setVisibility(View.VISIBLE);
            paramView2.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.title_bar_left_iv)
    void back() {
        finish();
    }

    protected void setupData() {
        Bundle data = getIntent().getBundleExtra("data");
        String str = data.getString(MeFragment.class.getName());
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
            getLikeData("tag");
        }
    }

    @Override
    public void sendStr(String type, String str) {
        Gson gson = new Gson();
        switch (type) {
            case "tag":
                list.clear();
                UserTagBean userTagBean = gson.fromJson(str, UserTagBean.class);
                list.addAll(userTagBean.getTags());
                adapter.notifyDataSetChanged();
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
        pull_listview.onRefreshComplete();

    }


}

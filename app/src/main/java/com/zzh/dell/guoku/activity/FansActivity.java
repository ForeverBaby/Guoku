package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.FansAdapter;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.bean.AuthorizedUserListBean;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.fragment.MessageFragment;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CostumDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FansActivity extends AppCompatActivity implements HttpCallBack {

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    @BindView(R.id.fans_lv)
    PullToRefreshListView fans_lv;

    private boolean isAuthonUser = false;

    private FansAdapter adapter;

    MainActivity.ChangeListener change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fans);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
        }
        initData();
        initView();
        initListener();
        change = new MainActivity.ChangeListener();
        IntentFilter inr = new IntentFilter();
        inr.addAction("Main.Login.btn.type1");
        inr.addAction("Main.Login.btn.type2");
        registerReceiver(change, inr);

    }

    private void initListener() {
        getFans(page);
        fans_lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase refreshView) {
                page = 1;
                getFans(0);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
                if (adapter.getCount() > 0) {
                    FansActivity localFansAct = FansActivity.this;
                    localFansAct.page = (1 + localFansAct.page);
                    FansActivity.this.getFans(30 * (0 + FansActivity.this.page));
                }
            }
        });
        fans_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
                if (adapter.getCount() > 0) {
                    Intent localIntent = new Intent(FansActivity.this, UserBaseActivity.class);
                    localIntent.putExtra("data", adapter.getItem(paramInt - 1));
                    startActivity(localIntent);
                    finish();
                }
            }
        });
    }


    String name;
    String url;

    @OnClick(R.id.title_bar_left_iv)
    void back() {
        finish();
    }

    List<Account.UserBean> list;
    int type2;

    private void initData() {
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        url = intent.getStringExtra("url");
        type2 = intent.getIntExtra("type", 0);
        this.isAuthonUser = getIntent().getBooleanExtra(MessageFragment.class.getName(), false);
        list = new ArrayList<>();
        adapter = new FansAdapter(this, list);
        fans_lv.setAdapter(adapter);
        fans_lv.setMode(PullToRefreshBase.Mode.BOTH);
        utils = new HttpUtils();
        utils.setCallBack(this);
        guangzhu();

    }

    private void guangzhu() {
        adapter.setGuangClickListener(new FansAdapter.GuangClickListener() {
            @Override
            public void guangListener(int position) {
                Intent intent = new Intent();
                Account.UserBean userBean = adapter.getItem(position);
                if ((userBean.getRelation() == 0) || (userBean.getRelation() == 2)) {
                    utils.getStrPOST("guangzhu", "http://api.guoku.com/mobile/v4/user/" + userBean.getUser_id() + "/follow/1/", new HashMap<String, String>());
                    if (userBean.getRelation() == 2) {
                        userBean.setRelation(3);
                    } else {
                        userBean.setRelation(1);
                    }
                    intent.putExtra("name", "add");
                    intent.setAction("Main.Login.btn.type1");
                    sendBroadcast(intent);
                    return;
                }
                utils.getStrPOST("quxiaoguangzhu", "http://api.guoku.com/mobile/v4/user/" + userBean.getUser_id() + "/follow/0/", new HashMap<String, String>());
                if (userBean.getRelation() == 1) {
                    userBean.setRelation(0);
                } else {
                    userBean.setRelation(2);
                }
                intent.putExtra("name", "add2");
                intent.setAction("Main.Login.btn.type1");
                sendBroadcast(intent);

            }
        });
    }

    int count = 30;
    int page = 0;
//    int paramInt = 0;

    private void getFans(int page) {
        if (url != null) {
            Map<String, String> map = new HashMap<>();
            if (this.isAuthonUser) {
                map.put("count", count + "");
                map.put("page", page + "");
                String getUrl = StringUtils.getGetUrl(url, map);
                utils.getStrGET("isAuthonUser", getUrl);
                return;
            }
            map.put("count", count + "");
            map.put("offset", page + "");
            String getUrl = StringUtils.getGetUrl(url, map);
            Log.e("=========","====getUrl==="+getUrl);
            utils.getStrGET("fans", getUrl);
        }
    }


    HttpUtils utils;

    private void initView() {
        title_bar_centrt_tv.setText(name);
        title_bar_left_iv.setImageResource(R.drawable.back_selector);
    }


    @Override
    public void sendStr(String type, String str) {
        fans_lv.onRefreshComplete();
        Gson gson = new Gson();
        JSONObject json;


        switch (type) {
            case "isAuthonUser":
                if (str != null) {
                    list.clear();
                    AuthorizedUserListBean userb = gson.fromJson(str, AuthorizedUserListBean.class);
                    list.addAll(userb.getAuthorized_user());
                    adapter.notifyDataSetChanged();
                }
                break;
            case "fans":
                Log.e("======","====="+str);
                try{
                 if (str != null) {
                json = new JSONObject(str);
                list.clear();
                if (json.has("like_user_list")) {
                    str = json.getString("like_user_list");
                }
                List<Account.UserBean> users = gson.fromJson(str, new TypeToken<List<Account.UserBean>>() {
                }.getType());

                if (null != users && users.size() > 0) {
                    if (type2 == 1) {
                        Account account = GuokuApp.getIntance().getAccount();
                        Account.UserBean user = account.getUser();
                        user.setFollowing_count(users.size());
                        GuokuApp.getIntance().login(account);
                    }
                    list.addAll(users);
                    adapter.notifyDataSetChanged();
                }
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
                break;
            case "guangzhu":
                try {
                    if (str != null) {
                        Log.e("===", "=str==" + str);
                        json = new JSONObject(str);
                        if (json.has("message")) {
                            Toast.makeText(FansActivity.this, str, Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(FansActivity.this, "关注成功", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case "quxiaoguangzhu":
                try {
                    if (str != null) {
                        Log.e("===", "===" + str);
                        json = new JSONObject(str);
                        if (json.has("message")) {
                            Toast.makeText(FansActivity.this, str, Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(FansActivity.this, "取消关注", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(change);
    }
}

package com.zzh.dell.guoku.fragment;


import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.FansActivity;
import com.zzh.dell.guoku.activity.Picture2Activity;
import com.zzh.dell.guoku.activity.SettingActivity;
import com.zzh.dell.guoku.activity.UserInfoActivity;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.bean.Mebean;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.LayoutItemView;
import com.zzh.dell.guoku.view.ScrollViewWithGridView;
import com.zzh.dell.guoku.view.ScrollViewWithListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements HttpCallBack {

    @BindView(R.id.alibaba_card)
    ImageView alibaba_card;

    @BindView(R.id.alibaba_wang)
    ImageView alibaba_wang;

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;
    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    @BindView(R.id.title_bar_rigth_iv)
    ImageView title_bar_rigth_iv;

    public Account accountBean;


    @BindView(R.id.pull_listview)
    PullToRefreshScrollView pull_listview;

    @BindView(R.id.psrson_iv_pic)
    CircleImageView psrson_iv_pic;

    @BindView(R.id.psrson_tv_name)
    TextView psrson_tv_name;

    @BindView(R.id.psrson_iv_sex)
    TextView psrson_iv_sex;

    @BindView(R.id.psrson_tv_sign)
    TextView psrson_tv_sign;

    @BindView(R.id.psrson_tv_guanzhu)
    TextView psrson_tv_guanzhu;

    @BindView(R.id.psrson_tv_fans)
    TextView psrson_tv_fans;

    @BindView(R.id.psrson_tv_btn)
    TextView psrson_tv_btn;

    @BindView(R.id.psrson_ll_btn)
    LinearLayout layout_edit;


    @BindView(R.id.listview_user_article)
    ScrollViewWithListView listArticle;

    @BindView(R.id.psrson_iv_btn)
    ImageView psrson_iv_btn;

    @BindView(R.id.listview_commit)
    ScrollViewWithListView listComment;

    @BindView(R.id.gridview_like)
    ScrollViewWithGridView gridview_like;

    @BindView(R.id.view_stub_user)
    LinearLayout view_stub_user;

    @BindView(R.id.red_round)
    ImageView red_round;

    @BindView(R.id.tv_user_like)
    LayoutItemView userLike;

    @BindView(R.id.psrson_ll_fans)
    LinearLayout psrson_ll_fans;


    public MeFragment() {
    }

    boolean canAdd = false;

    private int userType = 4;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);
        canAdd = true;
        getUserType();



        return view;
    }


    Account.UserBean userBean;

    private void getUserType() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            userBean = bundle.getParcelable("userBean");
            if (this.userBean != null) {
                userType = this.userBean.getRelation();
            }
        }
    }

    HttpUtils utils;

    private void initData() {
        utils = new HttpUtils();
        utils.setCallBack(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        getInitData("like", "4", 1002);
    }


    public void init() {
        Account account = GuokuApp.getIntance().getAccount();

        pull_listview.getLoadingLayoutProxy(true, true).setPullLabel("");
        pull_listview.getLoadingLayoutProxy(true, true).setRefreshingLabel("");
        pull_listview.getLoadingLayoutProxy(true, true).setReleaseLabel("");
        pull_listview.setMode(PullToRefreshBase.Mode.BOTH);
        switch (userType) {
            case 4:
                if (account != null) {
                    title_bar_centrt_tv.setText("我");
                    view_stub_user.setVisibility(View.VISIBLE);
                    accountBean = account;
                    userBean = accountBean.getUser();

                    title_bar_rigth_iv.setImageResource(R.mipmap.setting);
                    red_round.setVisibility(View.GONE);
                    if (!userBean.isMail_verified()) {
                        red_round.setVisibility(View.VISIBLE);
                    }
                    getUserInfo(userBean);

                }
                break;
            case 1:
                title_bar_left_iv.setImageResource(R.drawable.back_selector);
                title_bar_centrt_tv.setText(userBean.getNickname());
                view_stub_user.setVisibility(View.VISIBLE);
                getUserInfo(userBean);
                break;
            case 2:
                title_bar_left_iv.setImageResource(R.drawable.back_selector);
                title_bar_centrt_tv.setText(userBean.getNickname());
                view_stub_user.setVisibility(View.VISIBLE);

                getUserInfo(userBean);
                break;
            case 3:
                title_bar_left_iv.setImageResource(R.drawable.back_selector);
                title_bar_centrt_tv.setText(userBean.getNickname());
                view_stub_user.setVisibility(View.VISIBLE);
                getUserInfo(userBean);
                break;

        }


//
    }

    private void getData2() {
        setInfo(userBean);
        initUnUserAuthon(userBean);
        initUnUser();

    }

    @OnClick(R.id.psrson_iv_pic)
    void showPic() {
        Intent intent = new Intent(getActivity(), Picture2Activity.class);
        intent.putExtra("path", userBean.getAvatar_large());
        startActivity(intent);
    }

    private void setInfo(Account.UserBean user) {
        title_bar_rigth_iv.setVisibility(View.VISIBLE);
        this.psrson_tv_fans.setText(String.valueOf(user.getFan_count()));
        this.psrson_tv_guanzhu.setText(String.valueOf(user.getFollowing_count()));
        this.psrson_tv_name.setText(String.valueOf(user.getNick()));
        this.psrson_tv_sign.setText((String) user.getBio());
        Picasso.with(getActivity()).load(user.getAvatar_small()).fit().centerCrop().into(psrson_iv_pic);
    }

    private void initUnUser() {
    }

    private void setTextRightImg(TextView paramTextView, int paramInt) {
        Drawable localDrawable = getResources().getDrawable(paramInt);
        localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
        paramTextView.setCompoundDrawables(null, null, localDrawable, null);
    }

    private void initUnUserAuthon(Account.UserBean user) {
        if ("O".equals(user.getGender()) || "M".equals(user.getGender())) {
            this.psrson_iv_sex.setTextColor(Color.rgb(19, 143, 215));
            setTextRightImg(this.psrson_iv_sex, R.mipmap.male);
        } else {
            this.psrson_iv_sex.setTextColor(Color.rgb(253, 189, 217));
            setTextRightImg(this.psrson_iv_sex, R.mipmap.female);
        }
        setUserTab();
        initLike();
        initArticle();
        initConmment();

    }

    private void initConmment() {
    }

    private void initArticle() {

    }

    private void getUserInfo(Account.UserBean user) {
        Map<String, String> map = new ArrayMap<>();
        map.put("timestamp", (System.currentTimeMillis() / 1000L + ""));
        String str = "http://api.guoku.com/mobile/v4/user/" + user.getUser_id() + "/";
        String getUrl = StringUtils.getGetUrl(str, map);
        utils.getStrGET("userBean", getUrl);
    }

    private void getInitData(String paramString1, String paramString2, int paramInt) {
        if (paramInt == 1004) {
            String str2 = "http://api.guoku.com/mobile/v4/user/" + userBean.getUser_id() + "/" + paramString1 + "/";
            Map<String, String> map = new ArrayMap<>();
            map.put("size", paramString2);
            map.put("page", pageArticle + "");
            String getUrl = StringUtils.getGetUrl(str2, map);
            utils.getStrGET(paramString1, getUrl);
            return;
        }
        String str1 = "http://api.guoku.com/mobile/v4/user/" + userBean.getUser_id() + "/" + paramString1 + "/";
        String[] arrayOfString1 = {"count", "timestamp"};
        Map<String, String> map = new ArrayMap<>();
        map.put("count", paramString2);
        map.put("timestamp", (System.currentTimeMillis() / 1000L + ""));
        String getUrl = StringUtils.getGetUrl(str1, map);
        utils.getStrGET(paramString1, getUrl);

    }


    @BindView(R.id.tv_user_article)
    LayoutItemView userArticle;

    @BindView(R.id.tv_user_comment)
    LayoutItemView userComment;

    @BindView(R.id.tv_user_tag)
    LayoutItemView userTag;

    @BindView(R.id.tv_user_article_zan)
    LayoutItemView userArticleZan;

    private void setUserTab() {
        if (userType == 4) {
            String str = getActivity().getResources().getString(R.string.tv_user_my);
            setTab(str);
            refreshUI();
        } else {
            String str = getActivity().getResources().getString(R.string.tv_user_he);
            setTab(str);
            refreshUI();
        }

    }

    private void setTab(String str) {
        this.userLike.tv1.setText(str + getActivity().getResources().getString(R.string.tv_user_like));
        this.userComment.tv1.setText(str + getActivity().getResources().getString(R.string.tv_user_comment));
        this.userArticle.tv1.setText(str + getActivity().getResources().getString(R.string.tv_user_article));
        this.userTag.tv1.setText(str + getActivity().getResources().getString(R.string.tv_user_tag));
        this.userArticleZan.tv1.setText(str + getActivity().getResources().getString(R.string.tv_user_article_zan));
    }

    private void refreshUI() {
        switch (userType) {
            case 4:
                Account.UserBean user = accountBean.getUser();
                getUseInfo(user);
                this.layout_edit.setBackgroundResource(R.drawable.tfz_shap);
                this.psrson_tv_btn.setText("编辑个人资料");
                psrson_iv_btn.setImageResource(R.mipmap.ed);
                this.psrson_tv_btn.setTextColor(getResources().getColor(R.color.like_buy_blue));
                break;
            case 1:
                getUseInfo(userBean);
                this.layout_edit.setBackgroundResource(R.drawable.tfz_shap);
                this.psrson_tv_btn.setText("已关注");
                psrson_iv_btn.setImageResource(R.mipmap.add_to);
                this.psrson_tv_btn.setTextColor(getResources().getColor(R.color.like_buy_blue));
                break;
            case 0:
                getUseInfo(userBean);
                this.layout_edit.setBackgroundResource(R.drawable.blue_shap);
                this.psrson_tv_btn.setText("关注");
                psrson_iv_btn.setImageResource(R.mipmap.hai_to);
                this.psrson_tv_btn.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case 3:
                getUseInfo(userBean);
                this.layout_edit.setBackgroundResource(R.drawable.tfz_shap);
                this.psrson_tv_btn.setText("互相关注");
                psrson_iv_btn.setImageResource(R.mipmap.double1);
                this.psrson_tv_btn.setTextColor(getResources().getColor(R.color.like_buy_blue));
                break;
        }
    }

    private void getUseInfo(Account.UserBean user) {
        this.psrson_tv_guanzhu.setText(String.valueOf(user.getFollowing_count()));
        if (this.userType != 2) {
            if (isUnZero(user.getLike_count()))
                this.userLike.tv2.setText(String.valueOf(user.getLike_count()));
            if (isUnZero(user.getEntity_note_count()))
                this.userComment.tv2.setText(String.valueOf(user.getEntity_note_count()));
            if (isUnZero(user2.getArticle_count()))
                this.userArticle.tv2.setText(String.valueOf(user2.getArticle_count()));
            if (isUnZero(user.getTag_count()))
                this.userTag.tv2.setText(String.valueOf(user.getTag_count()));
            if (isUnZero(user.getDig_count()))
                this.userArticleZan.tv2.setText(String.valueOf(user.getDig_count()));
        }
    }

    private boolean isUnZero(int paramString) {
        if (paramString > 0) {
            return true;
        }
        return false;
    }

    private void initLike() {
//        this.gvAdapter = new GridViewAdapter(getActivity(), 4);
//        this.gridviewLike.setAdapter(this.gvAdapter);
//        this.gridviewLike.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
//                PersonalFragment.this.getShopInfo(((EntityBean) PersonalFragment.this.gvAdapter.getItem(paramInt)).getEntity_id());
//            }
//        });
//        getInitData("like", "4", 1002);
    }


    private void getShopInfo(String paramString, String type) {
        Map<String, String> map = new ArrayMap<>();
        map.put("entity_id", paramString);
        String getUrl = StringUtils.getGetUrl("http://api.guoku.com/mobile/v4/entity/" + paramString + "/", map);
        utils.getStrGET(type, getUrl);
    }

    @OnClick(R.id.title_bar_rigth_iv)
    void toSetting(View view) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getActivity(), SettingActivity.class));
        startActivity(intent);
    }

    @OnClick(R.id.psrson_ll_fans)
    public void psrson_ll_fans(View paramView) {
        Intent localIntent = new Intent(getActivity(), FansActivity.class);
        localIntent.putExtra("url", "http://api.guoku.com/mobile/v4/user/" + userBean.getUser_id() + "/fan/");
        localIntent.putExtra("name", "粉丝");
        startActivity(localIntent);
    }

    @OnClick(R.id.psrson_ll_follow)
    public void psrson_ll_follow(View paramView) {
        Intent localIntent = new Intent(getActivity(), FansActivity.class);
        localIntent.putExtra("url", "http://api.guoku.com/mobile/v4/user/" + userBean.getUser_id() + "/following/");
        localIntent.putExtra("name", "关注");
        localIntent.putExtra("type", 1);
        startActivity(localIntent);
    }

    @OnClick(R.id.psrson_ll_btn)
    public void psrson_ll_btn(View view) {
        if (this.userType == 4) {
            startActivityForResult(new Intent(getActivity(), UserInfoActivity.class), 1001);
            return;
        }

        if ((userType == 0) || (userType == 2)) {
            utils.getStrPOST("guangzhu", "http://api.guoku.com/mobile/v4/user/" + userBean.getUser_id() + "/follow/1/", new HashMap<String, String>());
            return;
        }
        utils.getStrPOST("quxiaoguangzhu", "http://api.guoku.com/mobile/v4/user/" + userBean.getUser_id() + "/follow/0/", new HashMap<String, String>());
    }

    private int pageArticle = 1;


    Mebean.UserBean user2;

    @Override
    public void sendStr(String type, String str) {
        Gson gson = new Gson();
        JSONObject json;

        switch (type) {
            case "userBean":
                if (str != null) {
                    Mebean mebean = gson.fromJson(str, Mebean.class);
                    user2 = mebean.getUser();
                    getData2();
                }

                break;
            case "guangzhu":
                try {
                    if (str != null) {
                        Log.e("===", "=str==" + str);
                        json = new JSONObject(str);
                        if (json.has("message")) {
                            Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
                            return;
                        }
                        userType = json.getInt("relation");
                        refreshUI();
                        Toast.makeText(getActivity(), "关注成功", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case "quxiaoguangzhu":
                try {
                    if (str != null) {
                        Log.e("===", "==str=" + str);
                        json = new JSONObject(str);
                        if (json.has("message")) {
                            Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
                            return;
                        }
                        int relation = json.getInt("relation");
                        Log.e("===", "=json=" + relation);
                        userType = relation;
                        refreshUI();
                        Toast.makeText(getActivity(), "取消关注", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }


    }

    @Override
    public void sendStrbefore(String type) {

    }

    @Override
    public void sendStrAfter(String type) {

    }
}

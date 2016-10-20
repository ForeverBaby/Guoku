package com.zzh.dell.guoku.fragment;


import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.SettingActivity;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.utils.SharedPrefUtils;
import com.zzh.dell.guoku.view.LayoutItemView;
import com.zzh.dell.guoku.view.ScrollViewWithGridView;
import com.zzh.dell.guoku.view.ScrollViewWithListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

    @BindView(R.id.alibaba_card)
    ImageView alibaba_card;

    @BindView(R.id.alibaba_wang)
    ImageView alibaba_wang;

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

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


    public MeFragment() {
    }

    boolean canAdd = false;

    private int userType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);
        canAdd = true;
        init();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }


    public void init() {
        if (GuokuApp.getIntance().getAccount() != null) {
            pull_listview.setMode(PullToRefreshBase.Mode.BOTH);
            pull_listview.getLoadingLayoutProxy(true,true).setPullLabel("");
            pull_listview.getLoadingLayoutProxy(true,true).setRefreshingLabel("");
            pull_listview.getLoadingLayoutProxy(true,true).setReleaseLabel("");
            title_bar_centrt_tv.setText("我");
            view_stub_user.setVisibility(View.VISIBLE);
            accountBean = GuokuApp.getIntance().getAccount();
            Account.UserBean user = accountBean.getUser();
            title_bar_rigth_iv.setVisibility(View.VISIBLE);
            this.psrson_tv_fans.setText(String.valueOf(user.getFan_count()) );
            this.psrson_tv_guanzhu.setText(String.valueOf(user.getFollowing_count()));
            this.psrson_tv_name.setText(String.valueOf(user.getNick()));
            this.psrson_tv_sign.setText((String)user.getBio());
            Picasso.with(getActivity()).load(user.getAvatar_small()).fit().centerCrop().into(psrson_iv_pic);
            title_bar_rigth_iv.setImageResource(R.mipmap.setting);
            red_round.setVisibility(View.GONE);
            if (!user.isMail_verified()) {
                red_round.setVisibility(View.VISIBLE);
            }
            initUnUserAuthon(user);
//            view_stub_user.setVisibility(View.GONE);
            initUnUser();
            initUnUserAuthon(user);

//            pull_listview.setMode(PullToRefreshBase.Mode.BOTH);
//            Account.UserBean user = accountBean.getUser();
//            this.psrson_tv_fans.setText(user.getFan_count());
//            this.psrson_tv_guanzhu.setText(user.getFollowing_count());
//            this.psrson_tv_name.setText(user.getNick());
//            this.psrson_tv_sign.setText((String) user.getBio());
//        this.psrson_iv_pic.setImageURI(Uri.parse(this.uBean.get240()));
//            setConcem(user);
//        getUserInfo();
//        return;
//        this.viewUserList.setVisibility(0);
//        this.uBean = GuokuApplication.getInstance().getBean().getUser();
//        this.iv_set.setVisibility(0);
//        title_bar_rigth_iv.setText("我");
//        this.iv_set.setImageResource(2130838087);
        }
    }

    private void initUnUser() {
    }

    private void setTextRightImg(TextView paramTextView, int paramInt) {
        Drawable localDrawable = getResources().getDrawable(paramInt);
        localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
        paramTextView.setCompoundDrawables(null, null, localDrawable, null);
    }

    private void initUnUserAuthon(Account.UserBean user) {
        if ("O".equals(user.getGender())) {
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

    private void initLike() {
//        gvAdapter = new GridViewAdapter(getActivity(), 4);
//        this.gridviewLike.setAdapter(this.gvAdapter);
//        this.gridviewLike.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
//                PersonalFragment.this.getShopInfo(((EntityBean) PersonalFragment.this.gvAdapter.getItem(paramInt)).getEntity_id());
//            }
//        });
//        getInitData("like", "4", 1002);
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
        if (this.userType == 0) ;
        for (String str = getActivity().getResources().getString(R.string.tv_user_my); ; str = getActivity().getResources().getString(R.string.tv_user_he)) {
            this.userLike.tv1.setText(str + getActivity().getResources().getString(R.string.tv_user_like));
            this.userComment.tv1.setText(str + getActivity().getResources().getString(R.string.tv_user_comment));
            this.userArticle.tv1.setText(str + getActivity().getResources().getString(R.string.tv_user_article));
            this.userTag.tv1.setText(str + getActivity().getResources().getString(R.string.tv_user_tag));
            this.userArticleZan.tv1.setText(str + getActivity().getResources().getString(R.string.tv_user_article_zan));
            refreshUI();
            return;
        }
    }

    private void refreshUI() {
        Account.UserBean user = accountBean.getUser();
        this.psrson_tv_guanzhu.setText(String.valueOf(user.getFollowing_count()));
        if (this.userType != 2) {
            if (isUnZero(user.getLike_count()))
                this.userLike.tv2.setText(String.valueOf(user.getLike_count()));
            if (isUnZero(user.getEntity_note_count()))
                this.userComment.tv2.setText(String.valueOf(user.getEntity_note_count()));
            if (isUnZero(user.getFollowing_count()))
                this.userArticle.tv2.setText(String.valueOf(user.getFollowing_count()));
            if (isUnZero(user.getTag_count()))
                this.userTag.tv2.setText(String.valueOf(user.getTag_count()));
            if (isUnZero(user.getDig_count()))
                this.userArticleZan.tv2.setText(String.valueOf(user.getDig_count()));
        }
        this.layout_edit.setBackgroundResource(R.drawable.tfz_shap);
        this.psrson_tv_btn.setText("编辑个人资料");
        this.psrson_tv_btn.setTextColor(getResources().getColor(R.color.like_buy_blue));
    }

    private boolean isUnZero(int paramString) {
        if (paramString > 0) {
            return true;
        }
        return false;
    }
    @OnClick(R.id.title_bar_rigth_iv)
    void toSetting(View view){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getActivity(), SettingActivity.class));
        startActivity(intent);
    }




}

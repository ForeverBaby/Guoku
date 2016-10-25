package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.bean.MeEntity;
import com.zzh.dell.guoku.bean.Sharebean;
import com.zzh.dell.guoku.bean.ZanEB;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CustomShareBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebShareActivity extends AppCompatActivity implements HttpCallBack {
    private static final int DIG = 1003;
    private static final int INFO_GOOD = 1001;
    private static final int INFO_USER = 1002;
    private static final int UN_DIG = 1004;
    String IF_ARTICLES = "/articles/";
    String IF_ENTITY = "guoku://entity/";
    String IF_TAOBAO = "taobao.com";
    String IF_TMALL = "detail.tmall.com";
    String IF_USER = "guoku://user/";
    CheckBox checkZan;
    Sharebean sharebean = new Sharebean();
    String urls;
    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    @BindView(R.id.title_bar_left_iv1)
    ImageView title_bar_left_iv1;

    @BindView(R.id.view_stub_zan)
    ViewStub view_stub_zan;

    @BindView(R.id.title_bar_rigth_iv)
    ImageView title_bar_rigth_iv;


    HttpUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_share);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
        }
        utils = new HttpUtils();
        utils.setCallBack(this);
        init();
//        initTitleZan();
    }

    static List<String> webViewTitle = new ArrayList<>();
    @BindView(R.id.webview)
    WebView webview;

    private void init() {
        Intent intent = getIntent();
        Bundle data = intent.getBundleExtra("share");
        if (data != null) {
            sharebean = data.getParcelable(WebShareActivity.class.getName());
        }

        WebChromeClient client = new WebChromeClient() {
            public void onReceivedTitle(WebView paramWebView, String paramString) {
                super.onReceivedTitle(paramWebView, paramString);
                webViewTitle.add(paramString);
                title_bar_centrt_tv.setText(paramString);
            }
        };
        webview.setWebChromeClient(client);
        title_bar_left_iv.setImageResource(R.drawable.back_selector);
        title_bar_left_iv1.setVisibility(View.VISIBLE);
        title_bar_left_iv1.setImageResource(R.mipmap.ssdk_auth_title_back);
        title_bar_rigth_iv.setVisibility(View.VISIBLE);
        title_bar_rigth_iv.setImageResource(R.mipmap.more);
        if (TextUtils.isEmpty(this.sharebean.getTitle())) {
            webview.loadUrl(this.sharebean.getAricleUrl());
        }
        if (this.sharebean.getAricleUrl().contains(this.IF_ARTICLES)) {
            initTitleZan();
        }
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUserAgentString("guoku-client");
        webview.getSettings().setSupportZoom(true);
        webview.requestFocus();
        webview.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView paramWebView, String paramString) {
                webViewTitle.add(paramWebView.getTitle());
            }

            public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
                super.onPageStarted(paramWebView, paramString, paramBitmap);
            }

            public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
                title_bar_centrt_tv.setText(paramWebView.getTitle());
                if (paramString.contains(WebShareActivity.this.IF_ENTITY)) {
                    String str2 = StringUtils.isStringId(paramString, IF_ENTITY);
                    Map<String, String> map = new ArrayMap<String, String>();
                    map.put("entity_id", str2);
                    String getUrl = StringUtils.getGetUrl("http://api.guoku.com/mobile/v4/entity/" + str2 + "/", map);
                    utils.getStrGET("1001", getUrl);
                    return true;
//                        WebShareAct.this.sendConnection(, new String[]{"entity_id"}, new String[]{str2}, 1001, true);
//                        WebShareAct.this.umStatistics("article_to_good", str2, WebShareAct.this.IF_ENTITY);
                } else if (paramString.contains(IF_USER)) {

                    String str1 = StringUtils.isStringId(paramString, IF_USER);

                    String getUrl = StringUtils.getGetUrl("http://api.guoku.com/mobile/v4/user/" + str1 + "/", new HashMap<String, String>());
                    utils.getStrGET("1002", getUrl);
//                        WebShareAct.this.umStatistics("article_to_user", str1, WebShareAct.this.IF_USER);
                    return true;
                }
//                    } else if ((!paramString.contains(IF_TMALL)) && (!paramString.contains(IF_TAOBAO))) {
//                        urls = paramString;
//                        if (TextUtils.isEmpty(urls)) {
//
//                        }
//                    }

                return super.shouldOverrideUrlLoading(paramWebView, paramString);
//                    while (true) {
//                        return true;
//
//                        if ((!paramString.contains(WebShareAct.this.IF_TMALL)) && (!paramString.contains(WebShareAct.this.IF_TAOBAO)))
//                            break;
//                        if (StringUtils.isEmpty(WebShareAct.this.urls))
//                            continue;
//                        WebShareActivity.this.showPage(null);
//                        WebShareAct.this.umStatistics("article_to_taobao", WebShareAct.this.urls, WebShareAct.this.IF_TAOBAO);
//                        return true;
//                    }
//                    WebShareActivity.this.setGCenter(true, paramWebView.getTitle());
//                    return super.shouldOverrideUrlLoading(paramWebView, paramString);
            }
        });
        webview.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
                if ((paramKeyEvent.getAction() == 0) && (paramInt == 4) && (WebShareActivity.this.webview.canGoBack())) {
                    title_bar_centrt_tv.setText(goBack(WebShareActivity.this.webview));
                    return true;
                }
                return false;
            }
        });
        title_bar_left_iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramView) {
                title_bar_centrt_tv.setText(goBack(WebShareActivity.this.webview));
            }
        });
        webview.loadUrl("http://m.guoku.com" + this.sharebean.getAricleUrl());
    }


    protected void onDestroy() {
        super.onDestroy();
        webViewTitle.clear();
    }

    @OnClick(R.id.title_bar_rigth_iv)
    void share() {
        postShare();
    }


    public String goBack(WebView paramWebView) {
        if (paramWebView.canGoBack()) {
            paramWebView.goBack();
            if (webViewTitle.size() > 0) {
                webViewTitle.remove(webViewTitle.size() - 1);
                return webViewTitle.get(webViewTitle.size() - 1);
            }
        } else {
            finish();
        }
        return "";
    }

    private void initTitleZan() {

        this.checkZan = setTitleZan();
        if (this.sharebean.is_dig()) {
            this.checkZan.setChecked(true);
        } else {
            checkZan.setChecked(false);
        }

        this.checkZan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GuokuApp.getIntance().getAccount() == null) {
                    checkZan.setChecked(false);
                    Intent intent = new Intent();
                    intent.setClass(WebShareActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    if (!TextUtils.isEmpty(WebShareActivity.this.sharebean.getAricleId())) {
                        if (sharebean.is_dig()) {
                            Map<String, String> map = new ArrayMap<String, String>();
                            map.put("aid", sharebean.getAricleId());
                            utils.getStrPOST("unzan", "http://api.guoku.com/mobile/v4/articles/undig/", map);
                        } else {

//                        WebShareAct.this.umStatistics("article_zan", WebShareAct.this.sharebean.getAricleId(), WebShareAct.this.sharebean.getTitle());
                            Map<String, String> map = new ArrayMap<String, String>();
                            map.put("aid", sharebean.getAricleId());
                            utils.getStrPOST("zan", "http://api.guoku.com/mobile/v4/articles/dig/", map);
                        }
                    }
                }
            }
        });


    }

    CustomShareBoard localCustomShareBoard;
    private void postShare() {
        localCustomShareBoard = new CustomShareBoard(this);
        if (!TextUtils.isEmpty(this.sharebean.getTitle())) {
            localCustomShareBoard.setShareContext(this, "", this.sharebean.getAricleUrl(), this.sharebean.getImgUrl(), this.webview.getTitle());
        }
        localCustomShareBoard.setAnimationStyle(R.style.popwin_anim_style);
        localCustomShareBoard.showAtLocation(getWindow().getDecorView(), 80, 0, 0);
        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        localLayoutParams.alpha = 0.6F;
        getWindow().setAttributes(localLayoutParams);
        localCustomShareBoard.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                WindowManager.LayoutParams localLayoutParams = WebShareActivity.this.getWindow().getAttributes();
                localLayoutParams.alpha = 1.0F;
                WebShareActivity.this.getWindow().setAttributes(localLayoutParams);
                if (localCustomShareBoard.isrefresh) {
                    webview.reload();
                    localCustomShareBoard.isrefresh = false;
                }
            }
        });
        localCustomShareBoard.setShareContext(this, this.sharebean.getContext() + "…… ", "http://www.guoku.com" + this.sharebean.getAricleUrl(), "http://imgcdn.guoku.com/" + this.sharebean.getImgUrl(), this.sharebean.getTitle() + "：");
    }


    public CheckBox setTitleZan() {
        view_stub_zan.inflate();
        return (CheckBox) findViewById(R.id.check_zan);
    }


    @Override
    public void sendStr(String type, String str) {
        Gson gson = new Gson();
        ZanEB localZanEB = new ZanEB();
        if (str != null) {
            switch (type) {
                case "1001":
//                    PInfoBean localPInfoBean = ParseUtil.getPI(paramString);
//                    Intent localIntent2 = new Intent(this, GoodsChildActivity.class);
//                    localIntent2.putExtra("data", JSON.toJSONString(localPInfoBean));
//                    startActivity(localIntent2);
                    Intent intent = new Intent();
                    intent.setClass(this, GoodsChildActivity.class);
                    MeEntity entityListBean = gson.fromJson(str, MeEntity.class);
                    intent.putExtra("cid", entityListBean.getEntity().getCategory_id());
                    intent.putExtra("id", entityListBean.getEntity().getEntity_id());
                    intent.putExtra("imagePath", entityListBean.getEntity().getChief_image());
                    startActivity(intent);
                    break;
                case "1002":
                    if (str != null) {
                        Account localUserBean = gson.fromJson(str, Account.class);
                        Intent localIntent1 = new Intent(this, UserBaseActivity.class);
                        localIntent1.putExtra("data", localUserBean);
                        startActivity(localIntent1);
                        break;
                    }

                case "zan":
                    sharebean.setIs_dig(true);
                    this.checkZan.setChecked(true);
                    Log.e("====","==true==");
//                    localZanEB.setZan(true);
//                    EventBus.getDefault().post(localZanEB);
                    break;
                case "unzan":
                    sharebean.setIs_dig(false);
                    this.checkZan.setChecked(false);
                    Log.e("====","==false==");
//                    localZanEB.setZan(false);
                    break;
            }

//            EventBus.getDefault().post(localZanEB);

        }
    }


    @Override
    public void sendStrbefore(String type) {

    }

    @Override
    public void sendStrAfter(String type) {

    }
}

package com.zzh.dell.guoku.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzh.dell.guoku.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView webview;

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;
    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    private String url;
    private String URL_KAOLA_NEW = "m.kaola.com";
    private String URL_KAOLA_OLD = "www.m.kaola.com";
    public static ArrayList<String> webViewTitle = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        this.url = getIntent().getStringExtra("data");
    }

    private void initView() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(getResources().getColor(R.color.colorbgBlack));
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
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setUseWideViewPort(true);
        this.webview.getSettings().setLoadWithOverviewMode(true);
        this.webview.loadUrl(this.url);
        this.webview.getSettings().setUserAgentString("guoku-client");
        this.webview.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView paramWebView, String paramString) {
                webViewTitle.add(paramWebView.getTitle());
            }

            public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
                if (paramString.contains(WebActivity.this.URL_KAOLA_OLD))
                    paramString = paramString.replace(WebActivity.this.URL_KAOLA_OLD, WebActivity.this.URL_KAOLA_NEW);
                paramWebView.loadUrl(paramString);
                title_bar_centrt_tv.setText(paramString);
                return true;
            }
        });
        this.webview.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
                if ((paramKeyEvent.getAction() == 0) && (paramInt == 4) && (WebActivity.this.webview.canGoBack())) {
                    title_bar_centrt_tv.setText(goBack(webview));
                    return true;
                }
                return false;
            }
        });

        title_bar_left_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_bar_centrt_tv.setText(goBack(webview));
            }
        });
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

    protected void onDestroy() {
        super.onDestroy();
        webViewTitle.clear();
    }

    @OnClick(R.id.title_bar_rigth_iv)
    public void right(View paramView) {
//        postShare();
    }

//    private void postShare() {
//        CustomShareBoard localCustomShareBoard = new CustomShareBoard(this);
////        localCustomShareBoard.setShareContext(this.name, this.url);
//        localCustomShareBoard.setAnimationStyle(2131427433);
//        localCustomShareBoard.showAtLocation(getWindow().getDecorView(), 80, 0, 0);
//        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//        localLayoutParams.alpha = 0.6F;
//        getWindow().setAttributes(localLayoutParams);
//        localCustomShareBoard.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            public void onDismiss() {
//                WindowManager.LayoutParams localLayoutParams = WebActivity.this.getWindow().getAttributes();
//                localLayoutParams.alpha = 1.0F;
//                WebActivity.this.getWindow().setAttributes(localLayoutParams);
//                if (BaseActivity.isRefrech) {
//                    WebActivity.this.webview.reload();
//                }
//            }
//        });
//    }
}

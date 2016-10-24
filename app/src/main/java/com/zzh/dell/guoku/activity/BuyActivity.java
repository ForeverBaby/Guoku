package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zzh.dell.guoku.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuyActivity extends AppCompatActivity {

    @BindView(R.id.buy_web)
    WebView webView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorbgBlack));
        }
        ButterKnife.bind(this);
        setDataToWeb();
    }

    private void setDataToWeb() {
        Intent intent = getIntent();
        String path = intent.getStringExtra("path");
        Log.e("========","======"+path);
        webView.loadUrl("https://item.taobao.com/item.htm?id=533308245373");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    public void back01(View view) {
        finish();
    }

    public void back02(View view) {
        finish();
    }

}

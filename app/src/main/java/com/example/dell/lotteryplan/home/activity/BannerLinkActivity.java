package com.example.dell.lotteryplan.home.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.dell.lotteryplan.R;
import com.example.dell.lotteryplan.base.BaseActivity;

/**
 * Created by DELL on 2017/4/12.
 */

public class BannerLinkActivity extends BaseActivity {

    private WebView     mWebView;
    private TextView    toolbar_title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.activity_banner_link);
        String       title = getIntent().getExtras().getString("title");
        final String url   = getIntent().getExtras().getString("url");
        setTitle(title);
        mWebView = (WebView)findViewById(R.id.webviews);
        toolbar_title   =(TextView)findViewById(R.id.toolbar_title);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return false;
            }
        });
        mWebView.loadUrl(url);
        toolbar_title.setText(title);
    }
}

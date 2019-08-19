package com.example.week1weekendactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebBrowserActivity extends AppCompatActivity {
    WebView browser;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);

        browser = findViewById(R.id.browser);
        url = findViewById(R.id.websiteUrl);
        browser.setWebViewClient(new MyBrowser());
    }

    public void goToUrl(View view){
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser.loadUrl(url.getText().toString());
    }

    private class MyBrowser extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            view.loadUrl(request.toString());
//            return super.shouldOverrideUrlLoading(view, request);
            return true;
        }
    }


}

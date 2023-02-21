package com.android.pythontutorial.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.android.pythontutorial.R;

public class PingPongActivity extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_pong);
//        getSupportActionBar().setTitle("Python Ping Pong Game");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView) findViewById(R.id.webView);

        webView.loadUrl("file:///android_asset/python/projects/pintpong.html");

        webView.getSettings().setJavaScriptEnabled(true);
    }
}
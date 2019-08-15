package com.example.thegioididong.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thegioididong.Model.All;
import com.example.thegioididong.R;

import java.util.ArrayList;

public class BuyAllActivity extends AppCompatActivity {
    public static ArrayList<All> listlaptop = new ArrayList<>();
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        webView = findViewById(R.id.web_buy);
        ReadIntent();
        new Buy().execute(listlaptop.get(0).getLinkSP());
    }

    @Override
    public void onBackPressed() {
        listlaptop.clear();
        finish();
    }

    private void ReadIntent() {
        Intent intent = getIntent();
        listlaptop.clear();
        if (intent != null) {
            if (intent.hasExtra("mua")) {
                All laptop = intent.getParcelableExtra("mua");
                listlaptop.add(laptop);
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    class Buy extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @SuppressLint("SetJavaScriptEnabled")
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(s);
            webView.setWebViewClient(new WebViewClient());
        }
    }
}

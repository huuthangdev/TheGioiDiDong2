package com.example.thegioididong.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thegioididong.Model.Mobile;
import com.example.thegioididong.R;

import java.util.ArrayList;

public class BuyMobileActivity extends AppCompatActivity {
    public static ArrayList<Mobile> listMobile = new ArrayList<>();
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        webView = findViewById(R.id.web_buy);
        ReadIntent();
        new BuyMobile().execute(listMobile.get(0).getLinkSP());
    }

    @Override
    public void onBackPressed() {
        listMobile.clear();
        finish();
    }

    private void ReadIntent() {
        Intent intent = getIntent();
        listMobile.clear();
        if (intent != null) {
            if (intent.hasExtra("muadienthoai")) {
                Mobile Mobile = intent.getParcelableExtra("muadienthoai");
                listMobile.add(Mobile);
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    class BuyMobile extends AsyncTask<String, Void, String> {
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

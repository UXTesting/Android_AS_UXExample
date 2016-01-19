package io.uxtesting.android_as_uxexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import io.uxtesting.UXTesting;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String defaultUrl = "https://tw.yahoo.com/";

        SearchView searchView = (SearchView) findViewById(R.id.sv_url);
        searchView.setSubmitButtonEnabled(false);
        searchView.setQuery(defaultUrl, false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (s.substring(0, 7).equals("http://") && s.substring(0, 8).equals("https://")) {
                    s = "http://" + s;
                }
                ((WebView)findViewById(R.id.wv_content)).loadUrl(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        WebView webViewContent = (WebView)findViewById(R.id.wv_content);
        webViewContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webViewContent.loadUrl(defaultUrl);
    }

    @Override
    public void onStart() {
        super.onStart();
        UXTesting.onStart(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        UXTesting.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UXTesting.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults)  {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        UXTesting.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

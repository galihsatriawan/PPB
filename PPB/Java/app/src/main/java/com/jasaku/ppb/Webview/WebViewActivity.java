package com.jasaku.ppb.Webview;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.jasaku.ppb.MainActivity;
import com.jasaku.ppb.R;
import com.jasaku.ppb.sign_in;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView mWebView;
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.setWebViewClient(new MyBrowser());
        mWebView.loadUrl("https://indonesia.travel");
        CardView btnCall = findViewById(R.id.cont_btn);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tlpn = "+6281235133535";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", tlpn, null));
                startActivity(intent);
            }
        });

    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            WebSettings webSettings = view.getSettings();
            webSettings.setJavaScriptEnabled(true);
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);
        // Setting dialog
        alertDialog2.setTitle("Log Out ");
        alertDialog2.setMessage("Apakah anda yakin ingin keluar?");
        alertDialog2.setIcon(R.drawable.out);
        alertDialog2.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent login = new Intent(alertDialog2.getContext(),sign_in.class);
                        startActivity(login);
                        finish();
                    }
                });
        alertDialog2.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog2.show();

        return super.onOptionsItemSelected(item);
    }
}

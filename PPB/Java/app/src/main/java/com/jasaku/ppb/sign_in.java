package com.jasaku.ppb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jasaku.ppb.Webview.WebViewActivity;

public class sign_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button login = findViewById(R.id.bt_login);
        EditText no_hp = findViewById(R.id.edit_hp);
        TextView daftar = findViewById(R.id.daftar_sekarang);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webview = new Intent(view.getContext(), WebViewActivity.class);
                startActivity(webview);
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webview = new Intent(view.getContext(), WebViewActivity.class);
                startActivity(webview);
            }
        });
    }

}

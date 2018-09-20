package com.jasaku.ppb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.btn_login);
        final EditText edtUsername = findViewById(R.id.edtUsername);
        final EditText edtPass= findViewById(R.id.edtPass);
        final TextView hasil = findViewById(R.id.hasil);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Galih", "onClick: "+edtUsername.getText()+" pass "+edtPass.getText());
                boolean user = ((edtUsername.getText()).toString().equals("galih"));
                boolean pass = ((edtPass.getText()).toString().equals("galih"));
                Log.d("galih", "Username: " + user);
                Log.d("galih", "Password: " + pass);
                if(user && pass){
                    hasil.setText("Galih, Anda Berhasil Login");
                }else{
                    hasil.setText("Akun Anda Tidak Valid");
                }
                hasil.setVisibility(View.VISIBLE);
            }
        });

    }
}

package com.jasaku.ppb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Test_input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_input);
        Button btn_ok = findViewById(R.id.btn_ok);
        final EditText edtNama = findViewById(R.id.edt_nama);
        final TextView txtNama = findViewById(R.id.txtNama);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNama.setText("Nama Anda "+edtNama.getText());
            }
        });
    }
}

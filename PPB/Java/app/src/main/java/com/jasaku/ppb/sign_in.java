package com.jasaku.ppb;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
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
        final EditText no_hp = findViewById(R.id.edit_hp);
        TextView daftar = findViewById(R.id.daftar_sekarang);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webview = new Intent(view.getContext(), WebViewActivity.class);
                startActivity(webview);
                tampilNotifikasi("Berhasil Login",no_hp.getText().toString(),new Intent(getApplication(),MainActivity.class));
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webview = new Intent(view.getContext(), SignUpActivity.class);
                startActivity(webview);
            }
        });
    }
    public static final int notifikasi = 1;
    private void tampilNotifikasi(String s, String s1, Intent intent) {
        // membuat komponen pending IntentActivity
        PendingIntent pendingIntent = PendingIntent.getActivity(this, notifikasi, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // membuat komponen notifikasi
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification;
        notification = builder.setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentTitle(s)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources()
                        , R.mipmap.ic_launcher))
                .setContentText(s1)
                .build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notifikasi, notification);
    }

}

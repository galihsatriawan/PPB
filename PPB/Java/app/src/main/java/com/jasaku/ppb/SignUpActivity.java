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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jasaku.ppb.R;
import com.jasaku.ppb.Webview.WebViewActivity;

import static com.jasaku.ppb.sign_in.notifikasi;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void checkRegister (View v){
        Log.d("Berhasil", "checkRegister");
        final EditText ed_username = (EditText)findViewById(R.id.editNama);
        EditText ed_phone = (EditText)findViewById(R.id.editHP);
        EditText ed_email = (EditText)findViewById(R.id.editEmail);

        Intent webview = new Intent(v.getContext(), WebViewActivity.class);
        startActivity(webview);
        tampilNotifikasi("Berhasil Login",ed_username.getText().toString(),new Intent(getApplication(),MainActivity.class));
    }
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

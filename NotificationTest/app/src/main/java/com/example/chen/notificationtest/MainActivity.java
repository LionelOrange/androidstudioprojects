package com.example.chen.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send= (Button) findViewById(R.id.send_notice);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(MainActivity.this);
                Intent intent=new Intent(MainActivity.this,NotificationActivity.class);
                PendingIntent pi=PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                mBuilder.setContentTitle("This is content title")
                        .setContentIntent(pi)
                        .setContentText("This is content text")
                        .setTicker("This is ticker text")
                        .setWhen(System.currentTimeMillis())
                        .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setSmallIcon(R.drawable.icon);
                manager.notify(1,mBuilder.build());
            }
        });
    }
}

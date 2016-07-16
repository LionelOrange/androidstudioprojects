package com.example.chen.servicetest;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/14.
 */
public class MyService extends Service{
    private DownloadBinder mBinder=new DownloadBinder();
    class DownloadBinder extends Binder{
        public void startDownload(){
           Log.d("MyService","startDownload executed");
        }
        public int getProgress(){
            Log.d("MyService","startDownload executed");
            return 0;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this);
        Intent notificationIntent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,notificationIntent,0);
        mBuilder.setContentTitle("This is title")
                .setContentIntent(pendingIntent)
                .setContentText("This is content")
                .setTicker("Notification comes")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher);
        startForeground(1,mBuilder.build());
        Log.d("MyService","onCreate executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService","onDestroy executed");
    }
}

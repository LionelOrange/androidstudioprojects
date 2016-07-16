package com.example.chen.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/13.
 */
public class MyService extends Service{
    private DownloadBinder mbinder=new DownloadBinder();
    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("MyService","startDownload executed");
        }
        public int getProgress(){
            Log.d("MyService","getProgress executed");
            return 0;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mbinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
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

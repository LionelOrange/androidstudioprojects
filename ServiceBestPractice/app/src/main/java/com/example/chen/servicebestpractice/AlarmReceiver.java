package com.example.chen.servicebestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/6/14.
 */
public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context,LongRunningService.class);
        context.startService(i);
    }
}

package com.example.chen.newsui;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/5/15.
 */
public class ForceOfflineReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Warning");
        dialogBuilder.setMessage("");
    }
}


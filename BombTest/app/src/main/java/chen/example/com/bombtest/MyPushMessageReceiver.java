package chen.example.com.bombtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import cn.bmob.push.PushConstants;

/**
 * Created by Administrator on 2016/7/16.
 */
public class MyPushMessageReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PushConstants.ACTION_MESSAGE)){
            Toast.makeText(context,"客户端收到推送内容:"+intent.getStringExtra("msg"),Toast.LENGTH_SHORT).show();
        }
    }
}

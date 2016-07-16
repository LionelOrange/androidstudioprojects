package com.example.chen.fragmentactivity;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction fragmentTransaction;
    private int[] icon={R.drawable.bluetooth,R.drawable.clound,R.drawable.gesture,R.drawable.gps
    ,R.drawable.info,R.drawable.internet,R.drawable.language,R.drawable.notifycation,R.drawable.theme
    ,R.drawable.volume,R.drawable.wether,R.drawable.wifi};
    private String[][] settingText={{"主题","系统壁纸"},{" 云账户","百度云账户"},{"通知","通知栏推送 "},{"移动数据","便携式WIFI热点"},{"WLAN","更多"}
    ,{"蓝牙","可被发现"},{"天气","温度"},{"通话音量","媒体音量"},{"密码锁定","定位服务"},{"语言","输入法设置"},{"设置快捷手势","触摸反馈"},{"设备名称","存储"}};

    public int[] getIcon() {
        return icon;
    }

    public String[][] getSettingText() {
        return settingText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentContent content=new FragmentContent();
        FragmentIcon fragmentIcon=new FragmentIcon();
        fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.settingcontent,content);
        fragmentTransaction.replace(R.id.settinglist,fragmentIcon);
        fragmentTransaction.commit();
    }
}

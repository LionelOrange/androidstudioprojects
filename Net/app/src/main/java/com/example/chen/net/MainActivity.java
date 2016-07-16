package com.example.chen.net;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private  String[] data=new String[]{
            "打开百度",
            "打开联系人",
            "拨打电话",
            "给10086发内容为“Hello”的短信",
            "发送彩信",
            "发送电子邮件",
            "发送内容为“Hello”的邮件",
            "点击播放音乐小苹果",
            "进入无线网络设置界面",
            "打开照相机",
            "用隐式Intent打开自定义Activity"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.lv);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com/")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel:15945653897")));
                        break;
                    case 3:
                        Intent intent=new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:10086"));
                        intent.putExtra("sms_bady","Hello");
                        startActivity(intent);
                        break;
                    case 4:
                        Uri uri=Uri.parse("content://media/external/images/meida/1");
                        Intent intent1=new Intent(Intent.ACTION_SEND);
                        intent1.putExtra(Intent.EXTRA_STREAM,uri);
                        intent1.putExtra("sms_baby","Hello");
                        intent1.setType("image/*");
                        startActivity(intent1);
                        break;
                    case 5:
                        startActivity(new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:787915859@qq.com")));
                        break;
                    case 6:
                        Intent intent2=new Intent(Intent.ACTION_SEND);
                        intent2.putExtra(Intent.EXTRA_EMAIL,"787915859@qq.com");
                        intent2.putExtra(Intent.EXTRA_SUBJECT,"HelloWorld");
                        intent2.putExtra(Intent.EXTRA_TEXT,"你好");
                        intent2.setType("text/plain");
                        startActivity(intent2);
                        break;
                    case 7:
                        Intent intent3=new Intent(Intent.ACTION_VIEW);
                        Uri uri1=Uri.parse("file:///sdcard/apple.mp3");
                        intent3.setDataAndType(uri1,"audio/mp3");
                        startActivity(intent3);
                        break;
                    case 8:
                        startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                        break;
                    case 9:
                        startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
                        break;
                    case 10:
                        Intent intent4=new Intent("com.example.chen.ACTION");
                        intent4.addCategory("com.example.chen.net.MY");
                        startActivity(intent4);
                        break;
                }
            }
        });
    }
}



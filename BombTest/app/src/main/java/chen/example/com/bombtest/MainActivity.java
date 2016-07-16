package chen.example.com.bombtest;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this,"dbe8559225b3bb231e08ec6ddd67fce1");
        BmobInstallation.getCurrentInstallation().save();
        // 启动推送服务
        BmobPush.startWork(this);
//        Feedback feedbackObj=new Feedback();
//        feedbackObj.setName("Jack");
//        feedbackObj.setFeedback("1");
//        feedbackObj.save(new SaveListener<String>() {
//            @Override
//            public void done(String s, BmobException e) {
//                if (e==null){
//                    Toast.makeText(MainActivity.this,"submit success",Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this,"submit failure",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        BmobQuery<Feedback> query=new BmobQuery<Feedback>();
        query.addWhereEqualTo("name","Jack");
        query.findObjects(new FindListener<Feedback>() {
            @Override
            public void done(List<Feedback> list, BmobException e) {
                if (e==null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Query");
                    String str = "";
                    for (Feedback feedback : list) {
                        str += feedback.getName() + ":" + feedback.getFeedback() + "\n";
                    }
                    builder.setMessage(str);
                    builder.create().show();
                }else {
                    Toast.makeText(MainActivity.this,"query failure",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

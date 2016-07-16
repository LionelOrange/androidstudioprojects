package com.example.chen.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button savaData;
    private Button restoreData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savaData=(Button) findViewById(R.id.save_data);
        restoreData=(Button) findViewById(R.id.restore_data);
        savaData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","chen");
                editor.putInt("age",20);
                editor.putBoolean("married",false);
                editor.commit();
            }
        });
        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
                String name=pref.getString("name","");
                int age=pref.getInt("age",0);
                boolean married=pref.getBoolean("married",false);
                Log.d("MainActivity","name is"+name);
                Log.d("MainActivity","age is"+age);
                Log.d("MainActivity","married is"+married);
            }
        });
    }
}

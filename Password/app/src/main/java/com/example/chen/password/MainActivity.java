package com.example.chen.password;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        cb = (CheckBox) findViewById(R.id.cb_a);
        cb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cb_a:
                if (cb.isChecked() == true) {
                    et.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                et.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
package com.example.chen.password;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv;
    private Button btn1,btn2,btn3,btn_plus,btn4,btn5,btn6,btn_minus,btn7,btn8
            ,btn9,btn_mutiply,btn_0,btn_point,btn_divide,btn_c,btn_back,btn_deng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.tv_show);
        btn1=(Button) findViewById(R.id.btn_1);
        btn2=(Button) findViewById(R.id.btn_2);
        btn3=(Button) findViewById(R.id.btn_3);
        btn_plus=(Button) findViewById(R.id.btn_plus);
        btn4=(Button) findViewById(R.id.btn_4);
        btn5=(Button) findViewById(R.id.btn_5);
        btn6=(Button) findViewById(R.id.btn_6);
        btn_minus=(Button) findViewById(R.id.btn_minus);
        btn7=(Button) findViewById(R.id.btn_7);
        btn8=(Button) findViewById(R.id.btn_8);
        btn9=(Button) findViewById(R.id.btn_9);
        btn_mutiply=(Button) findViewById(R.id.btn_mutiply);
        btn_0=(Button) findViewById(R.id.btn_0);
        btn_point=(Button) findViewById(R.id.btn_point);
        btn_divide=(Button) findViewById(R.id.btn_1);
        btn_c=(Button) findViewById(R.id.btn_c);
        btn_back=(Button) findViewById(R.id.btn_back);
        btn_deng=(Button) findViewById(R.id.btn_deng);
        tv.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_mutiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_deng.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_point.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
                tv.setText("0");
        }
    }
}

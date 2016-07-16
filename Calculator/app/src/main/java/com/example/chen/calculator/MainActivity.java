package com.example.chen.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    Button btn0=null;
    Button btn1=null;
    Button btn2=null;
    Button btn3=null;
    Button btn4=null;
    Button btn5=null;
    Button btn6=null;
    Button btn7=null;
    Button btn8=null;
    Button btn9=null;
    Button btn10=null;
    Button btn11=null;
    Button btn12=null;
    Button btn13=null;
    Button btn14=null;
    Button btn15=null;
    Button btn16=null;
    Button btn17=null;
    private TextView tv=null;
    double num1=0,num2=0;
    double result=0;
    private int op=0;
    private  boolean isClickEql=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=(Button) findViewById(R.id.btn_0);
        btn1=(Button) findViewById(R.id.btn_1);
        btn2=(Button) findViewById(R.id.btn_2);
        btn3=(Button) findViewById(R.id.btn_3);
        btn4=(Button) findViewById(R.id.btn_4);
        btn5=(Button) findViewById(R.id.btn_5);
        btn6=(Button) findViewById(R.id.btn_6);
        btn7=(Button) findViewById(R.id.btn_7);
        btn8=(Button) findViewById(R.id.btn_8);
        btn9=(Button) findViewById(R.id.btn_9);
        btn10=(Button) findViewById(R.id.btn_point);
        btn11=(Button) findViewById(R.id.btn_jia);
        btn12=(Button) findViewById(R.id.btn_jian);
        btn13=(Button) findViewById(R.id.btn_chen);
        btn14=(Button) findViewById(R.id.btn_chu);
        btn15=(Button) findViewById(R.id.btn_clear);
        btn16=(Button) findViewById(R.id.btn_back);
        btn17=(Button) findViewById(R.id.btn_dengyu);
        tv=(TextView) findViewById(R.id.tv_show);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString=tv.getText().toString();
                myString+="0";
                tv.setText(myString);
                break;
            case R.id.btn_1:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString1=tv.getText().toString();
                myString1+="1";
                tv.setText(myString1);
                break;
            case R.id.btn_2:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString2=tv.getText().toString();
                myString2+="2";
                tv.setText(myString2);
                break;
            case R.id.btn_3:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString3=tv.getText().toString();
                myString3+="3";
                tv.setText(myString3);
                break;
            case R.id.btn_4:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString4=tv.getText().toString();
                myString4+="4";
                tv.setText(myString4);
                break;
            case R.id.btn_5:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString5=tv.getText().toString();
                myString5+="5";
                tv.setText(myString5);
                break;
            case R.id.btn_6:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString6=tv.getText().toString();
                myString6+="6";
                tv.setText(myString6);
                break;
            case R.id.btn_7:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString7=tv.getText().toString();
                myString7+="7";
                tv.setText(myString7);
                break;
            case R.id.btn_8:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString8=tv.getText().toString();
                myString8+="8";
                tv.setText(myString8);
                break;
            case R.id.btn_9:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString9=tv.getText().toString();
                myString9+="9";
                tv.setText(myString9);
                break;
            case R.id.btn_point:
                if(isClickEql){
                    tv.setText(null);
                    isClickEql=false;
                }
                String myString10=tv.getText().toString();
                myString10+=".";
                tv.setText(myString10);
                break;
            case R.id.btn_clear:
                tv.setText(null);
                num1=0;num2=0;op=0;isClickEql=false;
                break;
            case R.id.btn_back:
                String mystring11=tv.getText().toString();
                try {
                    tv.setText(mystring11.substring(0,mystring11.length()-1));
                }catch (Exception e){
                    tv.setText("");
                }
                break;
            case R.id.btn_jia:
                String myStringAdd=tv.getText().toString();
                if(myStringAdd.equals(null)){
                    return;
                }
                num1=Double.valueOf(myStringAdd);
                tv.setText(null);
                op=1;
                isClickEql=false;
                break;
            case R.id.btn_jian:
                String myStringMinus=tv.getText().toString();
                if(myStringMinus.equals(null)){
                    return;
                }
                num1=Double.valueOf(myStringMinus);
                tv.setText(null);
                op=2;
                isClickEql=false;
                break;
            case R.id.btn_chen:
                String myStringCheng=tv.getText().toString();
                if(myStringCheng.equals(null)){
                    return;
                }
                num1=Double.valueOf(myStringCheng);
                tv.setText(null);
                op=3;
                isClickEql=false;
                break;
            case R.id.btn_chu:
                String myStringChu=tv.getText().toString();
                if(myStringChu.equals(null)){
                    return;
                }
                num1=Double.valueOf(myStringChu);
                tv.setText(null);
                op=4;
                isClickEql=false;
                break;
            case R.id.btn_dengyu:
                String myStringEqual=tv.getText().toString();
                if(myStringEqual.equals(null)){
                    return;
                }
                num2=Double.valueOf(myStringEqual);
                tv.setText(null);
                switch (op){
                    case 0:
                        result=num2;
                        break;
                    case 1:
                        result=num1+num2;
                        break;
                    case 2:
                        result=num1-num2;
                        break;
                    case 3:
                        result=num1*num2;
                        break;
                    case 4:
                        result=num1/num2;
                        break;
                    default:
                        result=0;
                        break;
                }
                tv.setText(String.valueOf(result));
                isClickEql=true;
                default:
                    break;
        }
    }
}

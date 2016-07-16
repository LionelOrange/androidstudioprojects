package com.example.chen.myfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private LinearLayout course_layout;
    private LinearLayout find_layout;
    private LinearLayout setting_layout;
    private ImageView course_image;
    private ImageView find_image;
    private ImageView setting_image;
    private TextView course_text;
    private TextView find_text;
    private TextView setting_text;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getFragmentManager();
        initViews();
    }
    public void initViews(){
        course_image= (ImageView) findViewById(R.id.course_image);
        find_image=(ImageView) findViewById(R.id.find_image);
        setting_image=(ImageView) findViewById(R.id.setting_image);
        course_text=(TextView) findViewById(R.id.course_text);
        find_text=(TextView) findViewById(R.id.find_text);
        setting_text=(TextView) findViewById(R.id.setting_text);
        course_layout=(LinearLayout) findViewById(R.id.course_layout);
        find_layout=(LinearLayout) findViewById(R.id.find_layout);
        setting_layout=(LinearLayout) findViewById(R.id.setting_layout);
        course_layout.setOnClickListener(this);
        find_layout.setOnClickListener(this);
        setting_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.course_layout:
                setChoiceItem(0);
                break;
            case R.id.find_layout:
                setChoiceItem(1);
                break;
            case R.id.setting_layout:
                setChoiceItem(2);
                break;
        }
    }
    public void setChoiceItem(int index){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index){
            case 0:
                if (fragment1==null){
                    fragment1=new Fragment1();
                    transaction.add(R.id.content,fragment1);
                }else{
                    transaction.show(fragment1);
                }
                break;
            case 1:
                if (fragment2==null){
                    fragment2=new Fragment2();
                    transaction.add(R.id.content,fragment2);
                }else{
                    transaction.show(fragment2);
                }
                break;
            case 2:
                if (fragment3==null){
                    fragment3=new Fragment3();
                    transaction.add(R.id.content,fragment3);
                }else{
                    transaction.show(fragment3);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }
    private void hideFragments(FragmentTransaction transaction){
        if(fragment1!=null){
            transaction.hide(fragment1);
        }
        if(fragment2!=null){
            transaction.hide(fragment2);
        }
        if(fragment3!=null){
            transaction.hide(fragment3);
        }
    }
}

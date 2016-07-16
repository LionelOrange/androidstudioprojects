package com.example.chen.fragmentactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/12.
 */
public class FragmentContent extends Fragment{
    private View view;
    private TextView myTextView1;
    private TextView myTextView2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_content,container,false);
        if (view!=null){
            initView();
        }
        setText(((MainActivity)getActivity()).getSettingText()[0]);
        return view;
    }
    public void initView(){
        myTextView1=(TextView) view.findViewById(R.id.tv1);
        myTextView2=(TextView) view.findViewById(R.id.tv2);
    }
    public void setText(String[] text){
        myTextView1.setText(text[0]);
        myTextView2.setText(text[1]);
    }
}

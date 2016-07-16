package com.example.chen.fragmentactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/6/12.
 */
public class FragmentIcon extends Fragment{
    private View view;
    private int[] settingicon;
    private String[][] settingText;
    private ListView mListView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_icon,container,false);
        MainActivity activity=(MainActivity) getActivity();
        settingicon=activity.getIcon();
        settingText=activity.getSettingText();
        initView();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentContent content=(FragmentContent) ((MainActivity)getActivity()).getFragmentManager().findFragmentById(R.id.settingcontent);
                content.setText(settingText[position]);
            }
        });
        return view;
    }
    private void initView(){
        mListView=(ListView) view.findViewById(R.id.lsd);
        if (settingicon!=null){
            mListView.setAdapter(new MyAdapter());
        }
    }
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return settingicon.length;
        }

        @Override
        public Object getItem(int position) {
            return settingicon[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=View.inflate(getActivity(),R.layout.item,null);
            ImageView Iv=(ImageView) convertView.findViewById(R.id.iv);
            Iv.setImageResource(settingicon[position]);
            return convertView;
        }
    }
}

package com.example.chen.teachshare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chen.teachshare.R;
import com.example.chen.teachshare.bean.Listv;

import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class ListvAdapter extends ArrayAdapter<Listv>{
    private int resourceId;
    public ListvAdapter(Context context, int resource, List<Listv> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Listv listv=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();
            viewHolder.listvimage=(ImageView) view.findViewById(R.id.list_image);
            viewHolder.textName=(TextView) view.findViewById(R.id.list_name);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.listvimage.setImageResource(listv.getImageId());
        viewHolder.textName.setText(listv.getName());
        return view;
    }
    class ViewHolder{
        ImageView listvimage;
        TextView textName;
    }
}

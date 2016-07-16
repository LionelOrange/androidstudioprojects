package com.example.chen.expendablelistview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/4.
 */
public class MyExpandableListAdapter extends BaseExpandableListAdapter{
    private String[] groups=new String[]{"我的好友","家人","同事","黑名单"};
    private  String[][] children=new String[][]{{"李兴华","张三","李四","cst"},{"父亲","母亲"}
            ,{"王五","赵六","王八"},{"票贩子","造假商"}};
    private Context context;
    public MyExpandableListAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getGroupCount() {
        return groups.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return children[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return children[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
    private TextView buildTextView(){
        AbsListView.LayoutParams params=new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,50);
        TextView tv=new TextView(this.context);
        tv.setLayoutParams(params);
        tv.setTextSize(15.0f);
        tv.setGravity(Gravity.LEFT);
        tv.setPadding(60,8,3,3);
        return tv;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView tv=this.buildTextView();
        tv.setText(this.getGroup(groupPosition).toString());
        return tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView tv=this.buildTextView();
        tv.setText(this.getChild(groupPosition,childPosition).toString());
        return tv;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

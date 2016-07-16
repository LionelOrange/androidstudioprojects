package com.example.chen.expendablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView elv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elv= (ExpandableListView) findViewById(R.id.elv);
        elv.setAdapter(new MyExpandableListAdapter(MainActivity.this));
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this,"子选项被选中，groupPositinon="+groupPosition+",childPosition="+childPosition,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(MainActivity.this,"分组被选中，groupPositinon="+groupPosition,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        elv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(MainActivity.this,"打开分组，groupPositinon="+groupPosition,Toast.LENGTH_SHORT).show();
            }
        });
        elv.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(MainActivity.this,"关闭分组，groupPositinon="+groupPosition,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

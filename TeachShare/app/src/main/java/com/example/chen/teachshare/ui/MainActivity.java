package com.example.chen.teachshare.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.example.chen.teachshare.R;
import com.example.chen.teachshare.adapter.FragmentAdapter;
import com.example.chen.teachshare.adapter.ListvAdapter;
import com.example.chen.teachshare.bean.Listv;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {
    private android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private List<Listv> listvList=new ArrayList<Listv>();
    //private String[] lvs={"开通会员","我的收藏","我的文件","个人中心"};
    private ListvAdapter listvAdapter;
    @InjectView(R.id.dl_left)
    DrawerLayout mDrawerLayout;

    @InjectView(R.id.tl_custom)
    Toolbar mToolbar;

    @InjectView(R.id.lv_left_menu)
    ListView lvLeftMenu;

    @InjectView(R.id.pager)
    ViewPager mViewPager;

    @InjectView(R.id.indicator)
    PagerSlidingTabStrip mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initList();
        setActionbar();
        FragmentAdapter mAdapter = new FragmentAdapter(getFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mViewPager);//设置首页tab导航和点击所指向的fragment
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            /*case R.id.action_add:
                Intent i = new Intent(this, PersonActivity.class);
                startActivity(i);
                break;*/
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void setActionbar() {
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.user1);
        //ActionBar mActionbar = getActionBar();
        mToolbar.setLogo(new CircleImageDrawble(mBitmap));
        //mToolbar.setIcon(new CircleImageDrawble(mBitmap));
        mToolbar.setTitle("教学工坊");
        //mActionbar.setTitle("教学工坊");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle=new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        listvAdapter=new ListvAdapter(this,R.layout.list_item,listvList);
        lvLeftMenu.setAdapter(listvAdapter);
        lvLeftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"正在开发中",Toast.LENGTH_SHORT);
            }
        });
        setOverflowShowingAlways();
    }

    // 设置显示Overflow按钮，即使有物理Menu按钮
    private void setOverflowShowingAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initList(){
        Listv people=new Listv("开通会员",R.drawable.contact);
        listvList.add(people);
        Listv hide=new Listv("我的收藏",R.drawable.star);
        listvList.add(hide);
        Listv dictory=new Listv("我的文件",R.drawable.document);
        listvList.add(dictory);
        Listv setting=new Listv("个人中心",R.drawable.stats);
        listvList.add(setting);
    }
}

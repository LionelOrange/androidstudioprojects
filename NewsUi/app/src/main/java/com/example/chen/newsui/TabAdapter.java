package com.example.chen.newsui;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/5/14.
 */
public class TabAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    public TabAdapter(FragmentManager fm,List<Fragment> fragments){
        super(fm);
        this.fragments=fragments;
    }
    public Fragment getItem(int position){
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return MainActivity.tabTitle[position];
    }
}

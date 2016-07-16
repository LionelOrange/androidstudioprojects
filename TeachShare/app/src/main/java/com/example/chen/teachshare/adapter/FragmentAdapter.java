package com.example.chen.teachshare.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.example.chen.teachshare.ui.DiscoverFragment;
import com.example.chen.teachshare.ui.MoveFragment;
import com.example.chen.teachshare.ui.MsgFragment;
import com.example.chen.teachshare.ui.PagerFragment;
import com.example.chen.teachshare.ui.PopularFragment;


/**
 * Created by Administrator on 2016/5/26.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    private String[] pageTitle = {"分享", "发现", "微课堂", "消息"};

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PopularFragment();
            case 1:
                return new DiscoverFragment();
            case 2:
                return new MoveFragment();
            case 3:
                return new MsgFragment();
            default:
                return PagerFragment.newInstance(position + "");
        }
    }

    @Override
    public int getCount() {
        return pageTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }
}

package com.example.chen.teachshare.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chen.teachshare.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/26.
 */
public class DiscoverFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

}

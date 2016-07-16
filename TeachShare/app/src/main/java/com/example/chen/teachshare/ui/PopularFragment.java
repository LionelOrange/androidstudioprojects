package com.example.chen.teachshare.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.example.chen.teachshare.R;
import com.example.chen.teachshare.adapter.StaggerItemAdapter;
import com.example.chen.teachshare.adapter.TopItemAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/5/26.
 */
public class PopularFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    /*private List<StaggerItem> staggerList;*/
    ViewPager imagePager;


    ClumsyIndicator mClumsyIndicator;

    @InjectView(R.id.stagger_view)
    StaggeredGridView mStaggeredGridView;

    @InjectView(R.id.refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private static Handler handler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        ButterKnife.inject(this, view);
        View topView = inflater.inflate(R.layout.top_view, (ViewGroup) view, false);
        imagePager = ButterKnife.findById(topView, R.id.image_pager);
        mClumsyIndicator = ButterKnife.findById(topView, R.id.indicator);
        mStaggeredGridView.addHeaderView(topView);
        initView();
        handler = new Handler();
        return view;
    }

    private void initView() {
        TopItemAdapter adapter = new TopItemAdapter(getActivity());
        imagePager.setAdapter(adapter);
        mClumsyIndicator.setViewPager(imagePager);
        mStaggeredGridView.setAdapter(new StaggerItemAdapter(getActivity()));
        mStaggeredGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
/*                staggerList=getStaggerList();
                StaggerItem item=staggerList.get(position);*/
                Intent intent=new Intent(getActivity(),StaggerContent.class);
                intent.putExtra("TYPE",position);
/*                intent.putExtra("item_image",item.getImageSource());
                intent.putExtra("collect_num",item.getCollectNum());
                intent.putExtra("collect_place",item.getCollectPlace());
                intent.putExtra("destription",item.getDestription());
                intent.putExtra("thumbImage",item.getThumbImage());
                intent.putExtra("user_name",item.getUserName());*/
                startActivity(intent);
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.blue);

        // 解决SwipeRefreshLayout和ViewPager的手势冲突
        // 在ViewPager滑动时使SwipeRefreshLayout失效 停止滑动时使其正常
        imagePager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            boolean isHandled = false;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (!isHandled && positionOffsetPixels > 0) {
                    mSwipeRefreshLayout.setEnabled(false);
                    isHandled = true;
                }
            }

            @Override
            public void onPageSelected(int position) {
                mClumsyIndicator.setSelectedItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        mSwipeRefreshLayout.setEnabled(true);
                        isHandled = false;
                        break;
                }
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            int currentItem = savedInstanceState.getInt("pager_current_item");
            imagePager.setCurrentItem(currentItem, false);
        }
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getActivity(), getString(R.string.refresh_success), Toast.LENGTH_SHORT).show();
            }
        }, 3000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
    }

    // 保存imagePager状态
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pager_current_item", imagePager.getCurrentItem());

    }
}

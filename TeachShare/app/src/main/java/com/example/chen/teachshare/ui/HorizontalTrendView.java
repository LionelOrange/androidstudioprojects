package com.example.chen.teachshare.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chen.teachshare.R;
import com.example.chen.teachshare.bean.TrendItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/26.
 */
public class HorizontalTrendView extends LinearLayout {

    private int[] imageSource = {R.drawable.gallery00, R.drawable.gallery11, R.drawable.gallery22, R.drawable.gallery33,
            R.drawable.gallery44, R.drawable.gallery55};

    private String[] imgDescription = {"指尖上的艺术", "安卓开发微课堂", "C语言微课堂", "Phython视频教程", "Object—C微课堂", "黑客的自我修养"};


    private List<TrendItem> trendList;

    public HorizontalTrendView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData();
        addTrendView();
    }

    private void initData() {
        trendList = new ArrayList<TrendItem>();
        for (int i = 0; i < imageSource.length; i++) {
            TrendItem item = new TrendItem();
            item.setImageSource(imageSource[i]);
            item.setDescription(imgDescription[i]);
            trendList.add(item);
        }
    }

    private void addTrendView() {
        for (int i = 0; i < trendList.size(); i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.trend_item, this, false);
            ImageView imageView = ButterKnife.findById(view, R.id.trend_img);
            TextView textView = ButterKnife.findById(view, R.id.trend_tv);
            Picasso.with(getContext()).load(trendList.get(i).getImageSource()).into(imageView);
            textView.setText(trendList.get(i).getDescription());
            addView(view);
        }
    }
}

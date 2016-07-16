package com.example.chen.europecup;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private static final String[] country=new String[]{"Russian","Poland","Greece","Czech","NetherLands","Germany"
            ,"Portugal","Denmark","Spain","Italy","Ireland","Croatia","England","France","Sweden","Ukraine"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.lv);
        lv.setAdapter(new ImageTextAdapter(MainActivity.this));
    }
    class ImageTextAdapter extends BaseAdapter{
        private Context mcontext;
        private int[] images=new int[]{R.drawable.russian,R.drawable.poland,R.drawable.greece,R.drawable.czech
                ,R.drawable.netherlands,R.drawable.germany
                ,R.drawable.portugal,R.drawable.denmark
                ,R.drawable.spain,R.drawable.italy
                ,R.drawable.ireland,R.drawable.croatia
                ,R.drawable.england,R.drawable.france
                ,R.drawable.sweden,R.drawable.ukraine};
        class ViewHolder{
            public ImageView imageView1;
            public TextView textView1;
            public ImageView imageView2;
            public TextView textView2;
            public ImageView imageView3;
            public TextView textView3;
            public ImageView imageView4;
            public TextView textView4;
        }
        public ImageTextAdapter(Context mcontext){
            this.mcontext=mcontext;
        }
        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView==null){
                convertView= LayoutInflater.from(mcontext).inflate(R.layout.item,null);
                viewHolder=new ViewHolder();
                viewHolder.imageView1= (ImageView) convertView.findViewById(R.id.iv1);
                viewHolder.textView1= (TextView) convertView.findViewById(R.id.tv1);
                viewHolder.imageView2= (ImageView) convertView.findViewById(R.id.iv2);
                viewHolder.textView2= (TextView) convertView.findViewById(R.id.tv2);
                viewHolder.imageView3= (ImageView) convertView.findViewById(R.id.iv3);
                viewHolder.textView3= (TextView) convertView.findViewById(R.id.tv3);
                viewHolder.imageView4= (ImageView) convertView.findViewById(R.id.iv4);
                viewHolder.textView4= (TextView) convertView.findViewById(R.id.tv4);
                convertView.setTag(viewHolder);
            }else{
                viewHolder=(ViewHolder)convertView.getTag();
            }
            viewHolder.imageView1.setImageResource(images[position*4]);
            viewHolder.textView1.setText(country[position*4]);
            viewHolder.imageView2.setImageResource(images[position*4+1]);
            viewHolder.textView2.setText(country[position*4+1]);
            viewHolder.imageView3.setImageResource(images[position*4+2]);
            viewHolder.textView3.setText(country[position*4+2]);
            viewHolder.imageView4.setImageResource(images[position*4+3]);
            viewHolder.textView4.setText(country[position*4+3]);
            return convertView;
        }
    }
}

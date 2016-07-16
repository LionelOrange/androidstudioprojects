package com.example.chen.customadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView lv=null;
    private static  final String[] data=new String[]{"中国","法国","俄罗斯","美国"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.lv);
        lv.setAdapter(new TextImageAdapter(MainActivity.this));
    }
    class TextImageAdapter extends BaseAdapter{
        private Context mcontext;
        private int[] images=new int[]{R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4};
        class ViewHolder{
            public TextView mTextView;
            public ImageView mImageView;
        }
        public TextImageAdapter(){
            super();
        }
        public TextImageAdapter(Context mcontext){
            this.mcontext=mcontext;
        }
        @Override
        public int getCount() {
            return data.length;
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
                viewHolder.mTextView=(TextView) convertView.findViewById(R.id.tv);
                viewHolder.mImageView=(ImageView) convertView.findViewById(R.id.iv);
                convertView.setTag(viewHolder);
            }
            viewHolder=(ViewHolder) convertView.getTag();
            viewHolder.mTextView.setText(data[position]);
            viewHolder.mImageView.setImageResource(images[position]);
            return convertView;
        }
    }
}

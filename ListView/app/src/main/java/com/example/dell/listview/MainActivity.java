package com.example.dell.listview;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private String[] titles = {"桌子","苹果","蛋糕","线衣","猕猴桃","围巾"};

    private String[] prices = {"1800元","10元/kg","300元","350元","10元/kg","280元"};

    private int[] icons = {R.drawable.table,R.drawable.apple,R.drawable.cake,R.drawable.wireclothes,R.drawable.kiwifruit,R.drawable.scarf};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.lv);
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        mListView.setAdapter(mAdapter);
    }

    class ViewHolder{
        TextView title,price;
        ImageView iv;
    }

    class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

//            View view = View.inflate(MainActivity.this,R.layout.list_item,null);
//            TextView title = view.findViewById(R.id.tv_title);
//            TextView price = view.findViewById(R.id.price);
//            ImageView iv = view.findViewById(R.id.iv);
//            title.setText(titles[position]);
//            price.setText(prices[position]);
//            iv.setBackgroundResource(icons[position]);
//
//            return view;

            ViewHolder holder = null;
            if (convertView == null){
                convertView = View.inflate(MainActivity.this,R.layout.list_item,null);
                holder = new ViewHolder();
                holder.title = convertView.findViewById(R.id.tv_title);
                holder.price = convertView.findViewById(R.id.price);
                holder.iv = convertView.findViewById(R.id.iv);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(titles[position]);
            holder.price.setText(prices[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return convertView;
        }
    }
}

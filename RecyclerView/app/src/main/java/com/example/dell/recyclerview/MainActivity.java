package com.example.dell.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private HomeAdapter mAdapter;
    private String[] names = {"小猫", "哈士奇", "小黄鸭", "小鹿", "老虎"};
    private int[] icons = {R.drawable.table, R.drawable.apple, R.drawable.cake, R.drawable.kiwifruit, R.drawable.scarf};
    private int[] introduces = {R.string.cat_intro, R.string.siberriankusky_intro, R.string.yellowduck_intro, R.string.fawn_intro, R.string.tiger_intro};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HomeAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHoler> {

        @Override
        public MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {

            MyViewHoler holer = new MyViewHoler(LayoutInflater.from(MainActivity.this).inflate(R.layout.recycler_item, parent,false));

            return holer;
        }

        @Override
        public void onBindViewHolder(MyViewHoler holder, int position) {
            holder.name.setText(names[position]);
            holder.iv.setImageResource(icons[position]);
            holder.introduce.setText(introduces[position]);
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        class MyViewHoler extends RecyclerView.ViewHolder {

            TextView name;
            ImageView iv;
            TextView introduce;

            public MyViewHoler(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                iv = itemView.findViewById(R.id.iv);
                introduce = itemView.findViewById(R.id.introduce);
            }
        }
    }
}

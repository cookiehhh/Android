package com.example.dell.myevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    private final static String TAG = "Main4Activity";
    private Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
        setListener();
    }
    private void initView(){
        btn_click = findViewById(R.id.btn_click);
    }

    private void setListener(){
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: 按钮点击");
            }
        });

        btn_click.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i(TAG, "onLongClick: 按钮长时间点击");
                return false;
            }
        });
    }

}

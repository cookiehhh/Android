package com.example.dell.myapplication_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {

    public Main5Activity(){
        Log.i("Main5Activity", "Main5Activity: ()....................."+getTaskId());
    }

    private Button btn_close;
    private Button btn_open;
    private Button btn_openself;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Main5Activity", "Main5Activity: onCreate()....................."+getTaskId());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        btn_close = findViewById(R.id.btn_close);
        btn_open = findViewById(R.id.btn_open);
        btn_openself = findViewById(R.id.btn_openself);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        btn_openself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Main5Activity.class);
                startActivity(intent);
            }
        });
    }
}

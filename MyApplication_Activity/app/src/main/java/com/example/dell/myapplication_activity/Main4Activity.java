package com.example.dell.myapplication_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    public Main4Activity(){
        Log.i("Main4Activity", "Main4Activity: ().............................."+getTaskId());
    }

    private Button btn_open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Main4Activity", "Main4Activity: onCreate().............................."+getTaskId());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this,Main5Activity.class);
                startActivity(intent);
            }
        });
    }
}

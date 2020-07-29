package com.example.dell.myapplication_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Button btn_open;
    private TextView tv_name;
    private TextView tv_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findView();
        setTvView();
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                intent.putExtra("name_hong","小红");
                intent.putExtra("score_hong",95);
                startActivity(intent);
            }
        });
    }
    private void findView(){
        btn_open = findViewById(R.id.btn_open);
        tv_name = findViewById(R.id.tv_name);
        tv_score = findViewById(R.id.tv_score);
    }
    private void setTvView(){
        Intent intent = getIntent();
        String name_ming = intent.getStringExtra("name_ming");
        int score_ming = intent.getIntExtra("score_ming",0);
        tv_name.setText("姓名："+name_ming);
        tv_score.setText("分数："+score_ming);
    }
}

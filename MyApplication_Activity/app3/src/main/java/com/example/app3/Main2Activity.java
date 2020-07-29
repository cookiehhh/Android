package com.example.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv_name, tv_pass;
    private Button btn_close;

    private String name = "";
    private String pass = "";
    private String mes = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findView();
        getNP();
        setView();
        onCheck();
        setListener();
    }

    private void getNP(){
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        pass = intent.getStringExtra("pass");
    }

    private void setView(){
        tv_name.setText("您输入的用户名为："+name);
        tv_pass.setText("您输入的密码为："+pass);
    }

    private void onCheck(){
        if ("admin".equals(name)&&"123456".equals(pass)){
            mes = "信息输入正确！";
        }else {
            mes = "信息输入错误！";
        }
    }

    private void setListener(){
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("mes",mes);
                setResult(2,intent);
                finish();
            }
        });
    }

    private void findView(){
        tv_name = findViewById(R.id.tv_name);
        tv_pass = findViewById(R.id.tv_pass);
        btn_close = findViewById(R.id.btn_close);
    }
}

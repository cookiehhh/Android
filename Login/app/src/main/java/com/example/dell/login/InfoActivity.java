package com.example.dell.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {

    private Button btn_name,btn_account,btn_gender,btn_address,btn_sign,btn_logout;
    private String account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        findView();
        init();
        setListener();
    }

    private void init(){
        Bundle bundle = getIntent().getExtras();
        account = bundle.getString("account");
        btn_account.setText("用户名："+account);
    }

    private void setListener(){
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void findView(){
        btn_name = findViewById(R.id.btn_name);
        btn_account = findViewById(R.id.btn_account);
        btn_gender = findViewById(R.id.btn_gender);
        btn_address = findViewById(R.id.btn_address);
        btn_sign = findViewById(R.id.btn_sign);
        btn_logout = findViewById(R.id.btn_logout);
    }
}

package com.example.dell.logintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_pwd;
    private Button btn_login;

    private String username;
    private String userpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();
        Map<String, String> userInfo = SPSave.getUserInfo(this);
        if (userInfo != null) {
            et_name.setText(userInfo.get("account"));
            et_pwd.setText(userInfo.get("password"));
        }
    }

    private void setListener(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et_name.getText().toString().trim();
                userpwd = et_pwd.getText().toString().trim();
                //Toast.makeText(MainActivity.this,"dianji！"+username+userpwd,Toast.LENGTH_SHORT).show();
                if (TextUtils.isEmpty(username)){
                    Toast.makeText(MainActivity.this,"请输入QQ号",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(userpwd)){
                    Toast.makeText(MainActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                }else if("admin".equals(username) && "123".equals(userpwd)){
                    Toast.makeText(MainActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
                    boolean isSaveSuccess = FileSaveQQ.saveUserInfo(MainActivity.this, username,
                            userpwd);

                    if (isSaveSuccess) {
                        Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(MainActivity.this,"输入错误！",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void findView(){
        btn_login = findViewById(R.id.btn_login);
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
    }
}

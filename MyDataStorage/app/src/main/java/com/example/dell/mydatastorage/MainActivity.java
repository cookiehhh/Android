package com.example.dell.mydatastorage;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText et_account,et_password;
    private Button btn_login;
    private Context mContext;
    private Map<String,String> userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findView();
        userInfo = FileSaveQQ.getUserInfo(this);
        if (userInfo!= null){
            et_account.setText(userInfo.get("account"));
            et_password.setText(userInfo.get("password"));
        }
        setListener();
    }

    private void setListener(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = et_account.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                if (TextUtils.isEmpty(account)){
                    Toast.makeText(mContext,"请输入QQ号",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(mContext,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(mContext,"登录成功",Toast.LENGTH_SHORT).show();
                boolean isSaveSuccess = FileSaveQQ.saveUserInfo(mContext,account,password);
                if (isSaveSuccess){
                    Toast.makeText(mContext,"保存成功",Toast.LENGTH_SHORT).show();
                    Toast.makeText(mContext,userInfo.get("account"),Toast.LENGTH_SHORT).show();
                    Toast.makeText(mContext,userInfo.get("password"),Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(mContext,"保存失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void findView(){
        et_account = findViewById(R.id.et_account);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
    }
}

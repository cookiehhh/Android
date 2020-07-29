package com.example.dell.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private UserDataManager userDataManager;

    private EditText et_account,et_password;
    private Button btn_register;

    private String username,userpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userDataManager = new UserDataManager(this);
        findView();
        setListener();
    }

    private void setListener(){
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et_account.getText().toString();
                userpwd = et_password.getText().toString();
                UserData userData = new UserData(username,userpwd);
                int result = userDataManager.findUserByName(username);
                if (result != 0){
                    Toast.makeText(RegisterActivity.this,"用户已存在",Toast.LENGTH_SHORT).show();
                }else {
                    result = userDataManager.insertUserData(userData);
                    if (result != 0){
                        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    private void findView(){
        btn_register = findViewById(R.id.btn_register);
        et_account = findViewById(R.id.et_account);
        et_password = findViewById(R.id.et_password);
    }
}

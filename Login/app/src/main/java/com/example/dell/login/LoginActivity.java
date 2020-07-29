package com.example.dell.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private UserDataManager userDataManager;

    private EditText et_account,et_password;
    private Button btn_login,btn_forget_pass;

    private String username,userpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userDataManager = new UserDataManager(this);
        findView();
        setListener();
    }

    private void setListener(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et_account.getText().toString();
                userpwd = et_password.getText().toString();
                int result = userDataManager.findUserByNameAndPwd(username,userpwd);
                if (result == 0){
                    Toast.makeText(LoginActivity.this,"用户不存在",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,InfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("account",username);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        btn_forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void findView(){
        btn_login = findViewById(R.id.btn_login);
        btn_forget_pass = findViewById(R.id.btn_forget_pass);
        et_account = findViewById(R.id.et_account);
        et_password = findViewById(R.id.et_password);
    }
}

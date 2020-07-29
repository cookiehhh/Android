package com.example.app_login;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private AdminHelper adminHelper;
    private SQLiteDatabase database;
    private ContentValues contentValues;

    private EditText et_account,et_password;
    private Button btn_login,btn_register;

    private String account,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        adminHelper = new AdminHelper(this);
        findView();
        setListener();
    }

    private void select(){
        database = adminHelper.getWritableDatabase();
        Cursor cursor = database.query("information",null,null,null,null,null,null);
        if (cursor.getCount() == 0){
            Toast.makeText(LoginActivity.this,"没有数据",Toast.LENGTH_SHORT).show();
        }else {
            cursor.moveToFirst();
            account = cursor.getString(1);
            password = cursor.getString(2);
            Toast.makeText(LoginActivity.this,"找到数据",Toast.LENGTH_SHORT).show();
        }

        cursor.close();
        database.close();
    }


    private void setListener(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void findView(){
        et_account = findViewById(R.id.et_account);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

    }
}

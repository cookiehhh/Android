package com.example.app3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyHelper myHelper;

    private EditText et_name,et_phone;
    private Button btn_insert,btn_select,btn_update,btn_delete;
    private TextView tv_show;

    private String name , phone;
    private SQLiteDatabase database;
    private ContentValues contentValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHelper = new MyHelper(this);
        findView();
        setListener();
    }

    private void setListener(){
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select();
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }

    private void insert(){
        name = et_name.getText().toString();
        phone = et_phone.getText().toString();
        database = myHelper.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        database.insert("information",null,contentValues);
        Toast.makeText(MainActivity.this,"信息已添加",Toast.LENGTH_SHORT).show();
        database.close();
    }
    private void select(){
        database = myHelper.getWritableDatabase();
        Cursor cursor = database.query("information",null,null,null,null,null,null);
        if (cursor.getCount() == 0){
            tv_show.setText("");
            Toast.makeText(MainActivity.this,"没有数据",Toast.LENGTH_SHORT).show();
        }else {
            cursor.moveToFirst();
            tv_show.setText("Name："+cursor.getString(1)+"\n" +
                                "Phone："+cursor.getString(2));
        }
        while (cursor.moveToNext()){
            tv_show.append("\n"+"Name："+cursor.getString(1)+"\n" +
                    "Phone："+cursor.getString(2));
        }
        cursor.close();
        database.close();
    }
    private void update(){
        name = et_name.getText().toString();
        phone = et_phone.getText().toString();
        database = myHelper.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("phone",phone);
        database.update("information",contentValues,"name=?",new String[]{name});
        Toast.makeText(MainActivity.this,"信息已修改",Toast.LENGTH_SHORT).show();
        database.close();
    }
    private void delete(){
        database = myHelper.getWritableDatabase();
        database.delete("information",null,null);
        Toast.makeText(MainActivity.this,"信息已删除",Toast.LENGTH_SHORT).show();
        tv_show.setText("");
        database.close();
    }



    private void findView(){
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        btn_insert = findViewById(R.id.btn_insert);
        btn_select = findViewById(R.id.btn_select);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);
        tv_show = findViewById(R.id.tv_show);
    }
}

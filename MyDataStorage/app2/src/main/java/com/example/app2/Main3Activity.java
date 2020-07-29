package com.example.app2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main3Activity extends AppCompatActivity {

    private EditText et_text;
    private Button btn_write, btn_read;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findView();
        setListener();
    }

    private void setListener() {
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String text = et_text.getText().toString();

            SharedPreferences sharedPreferences = getSharedPreferences("data",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("text",text);
            editor.commit();

            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            SharedPreferences sharedPreferences = getSharedPreferences("data",Context.MODE_PRIVATE);
            String text = sharedPreferences.getString("text",null);
            Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void findView() {
        et_text = findViewById(R.id.et_text);
        btn_write = findViewById(R.id.btn_write);
        btn_read = findViewById(R.id.btn_read);
    }
}

package com.example.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_name;
    private Button btn_open;
    private TextView tv_gender;

    private String name = "";
    private String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();

    }

    private void setListener(){
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_name.getText().toString();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",name);
                startActivityForResult(intent,1);
            }
        });
    }

    private void setView(){
        tv_gender.setText("您的性别为："+gender);
        tv_gender.setVisibility(View.VISIBLE);

    }

    private void findView(){
        et_name = findViewById(R.id.et_name);
        btn_open = findViewById(R.id.btn_open);
        tv_gender = findViewById(R.id.tv_gender);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==2){
            gender = data.getStringExtra("gender");
            setView();
        }
    }
}

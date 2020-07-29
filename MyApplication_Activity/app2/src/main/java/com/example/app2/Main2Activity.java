package com.example.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv_name;
    private Button btn_close;
    private RadioGroup rdg_geder;
    private RadioButton rd_man;
    private RadioButton rd_weman;

    private String name;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findView();
        setListener();
        setView();
    }

    private void setListener(){
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("gender",gender);
                setResult(2,intent);
                finish();
            }
        });
        rdg_geder.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rd_man){
                    gender = rd_man.getText().toString();
                }else if (checkedId == R.id.rd_weman){
                    gender = rd_weman.getText().toString();
                }
            }
        });
    }

    private void setView(){
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        tv_name.setText("姓名："+name);
    }

    private void findView(){
        tv_name = findViewById(R.id.tv_name);
        btn_close = findViewById(R.id.btn_close);
        rdg_geder = findViewById(R.id.rdg_geder);
        rd_man = findViewById(R.id.rd_man);
        rd_weman = findViewById(R.id.rd_weman);

    }
}

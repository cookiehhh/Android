package com.example.dell.viewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_one;
    private Button btn_two;
    private Button btn_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        btn_three.setOnClickListener(this);
        setListener();
    }

    private void setListener(){

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_two.setText("按钮按下");
                Toast.makeText(MainActivity.this, "按钮2按下!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void click(View v){
        Toast.makeText(MainActivity.this, "按钮1按下!", Toast.LENGTH_LONG).show();
        btn_one.setText("按钮按下");
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_three :
                Toast.makeText(MainActivity.this, "按钮3按下!", Toast.LENGTH_LONG).show();
                btn_three.setText("按钮按下");
                break;
        }
    }

    private void findView(){
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
    }
}

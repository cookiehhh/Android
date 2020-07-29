package com.example.dell.myevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity implements View.OnFocusChangeListener{

    private ImageButton[] buttons = new ImageButton[2];
    private TextView tv_choose,tv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        init();
    }
    private void init(){
        buttons[0] = findViewById(R.id.img_btn1);
        buttons[1] = findViewById(R.id.img_btn2);
        tv_choose = findViewById(R.id.tv_choose);
        tv_info = findViewById(R.id.tv_info);
        tv_info.setText("请选择您喜欢的图片");
        for (ImageButton button : buttons){
            button.setOnFocusChangeListener(this);
        }
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()){
            case R.id.img_btn1:
                tv_choose.setText("您选中了第一张图片");
                break;
            case R.id.img_btn2:
                tv_choose.setText("您选中了第二张图片");
                break;
        }
    }
}

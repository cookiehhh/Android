package com.example.dell.myevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity implements View.OnClickListener,View.OnKeyListener{

    private ImageButton[] buttons = new ImageButton[2];
    private TextView tv_choose,tv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }

    private void init(){
        buttons[0] = findViewById(R.id.img_btn1);
        buttons[1] = findViewById(R.id.img_btn2);
        tv_choose = findViewById(R.id.tv_choose);
        tv_info = findViewById(R.id.tv_info);
        tv_info.setText("请选择按下A或B");
        for (ImageButton button : buttons){
            button.setOnClickListener(this);
            button.setOnKeyListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_btn1:
                tv_choose.setText("您点击了A");
                break;
            case R.id.img_btn2:
                tv_choose.setText("您点击了B");
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_A:
                buttons[0].performClick();
                buttons[0].requestFocus();
                break;
            case KeyEvent.KEYCODE_B:
                buttons[1].performClick();
                buttons[1].requestFocus();
                break;
        }
        return false;
    }
}

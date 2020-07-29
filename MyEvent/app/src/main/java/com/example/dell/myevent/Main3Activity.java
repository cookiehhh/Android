package com.example.dell.myevent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private final static String TAG = "Main3Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
        MyButton button = new MyButton(this);
        button.setText("Hello");
        button.setTextSize(20);
        button.setAllCaps(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: 按钮点击");
            }
        });
        setContentView(button);
    }

    @SuppressLint("AppCompatCustomView")
    class MyButton extends Button {

        public MyButton(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    Toast.makeText(Main3Activity.this,"按钮被按下",Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "按钮被按下: ");
                    break;
                case MotionEvent.ACTION_UP:
                    Toast.makeText(Main3Activity.this,"按钮被弹起",Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "按钮被弹起: ");
                    break;
                case MotionEvent.ACTION_MOVE:
                    Toast.makeText(Main3Activity.this,"在按钮上进行移动",Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "在按钮上进行移动: ");
                    break;
            }
            return super.onTouchEvent(event);
        }
    }
}

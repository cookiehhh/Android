package com.example.dell.onesecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvTime;
    private TextView tvNormal;
    private TextView tvGod;
    private Button btnTest;

    private Long downTime;
    private Long upTime;
    private int normalTimes;
    private int godTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initListener();
    }

    private void initListener() {
        btnTest.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    Toast.makeText(MainActivity.this, "action_down", Toast.LENGTH_SHORT).show();
                    downTime = System.currentTimeMillis();
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    Toast.makeText(MainActivity.this, "action_up", Toast.LENGTH_SHORT).show();
                    upTime = System.currentTimeMillis();
                    double time = calculationTime();
                    tvTime.setText("" + time);
                    if (Math.abs(time-1) > 0.1 ){
                        normalTimes++;
                        tvNormal.setText("凡人：" + normalTimes + "次");
                    }else {
                        godTimes++;
                        tvGod.setText("大神：" + godTimes + "次");
                    }
                }else if (event.getAction() == MotionEvent.ACTION_MOVE){

                }

                return false;
            }
        });
    }

    private double calculationTime() {
        return (double) (upTime - downTime)/1000;
    }

    private void findView() {
        tvTime = findViewById(R.id.tv_time);
        tvNormal = findViewById(R.id.tv_normal);
        tvGod = findViewById(R.id.tv_god);
        btnTest = findViewById(R.id.btn_test);
    }
}

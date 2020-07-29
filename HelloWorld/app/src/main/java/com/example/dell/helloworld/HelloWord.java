package com.example.dell.helloworld;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class HelloWord extends AppCompatActivity {

    TextView tvTarget;
    TextView tvScore;
    TextView tvIndex;
    TextView tvHeihei;

    SeekBar sbBulsseye;

    Button btnOk;
    Button btnHelp;
    Button btnReplay;
    Button btnPlug;

    private int randomScore;
    private int finalScore;
    private int currentScore;
    private int index;
    private int count;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_word);
        mContext = this;
        findView();
        randomOfScore();
        setListener();

    }

    private void setListener() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                setScore();
                setViewText();
                randomOfScore();
            }
        });

        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomOfScore();
                finalScore = 0;
                index = 0;
                setViewText();
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(mContext);
                builder.setTitle("这个游戏的名字叫做测试你的感觉度")
                        .setMessage("请尝试把圆点移动到与数字对应的位置上\n准备好了吗？\n请点击好的！")
                        .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                android.support.v7.app.AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        sbBulsseye.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvHeihei.setText("嘿嘿：" + sbBulsseye.getProgress());
            }
        });

        btnPlug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count % 2 == 0) {
                    tvHeihei.setVisibility(View.VISIBLE);

                }else {
                    tvHeihei.setVisibility(View.INVISIBLE);
                }
                count++;
            }
        });
    }

    private void setViewText(){
        tvScore.setText("分数" + finalScore);
        tvIndex.setText("玩耍次数" + index);
        sbBulsseye.setProgress(0);
    }

    private void randomOfScore() {
        Random random = new Random();
        randomScore =  random.nextInt(99) + 1;
        tvTarget.setText("分数：" + randomScore);
    }
    private void setScore() {
        currentScore = sbBulsseye.getProgress();
        int score = 100 - Math.abs(currentScore-randomScore);
        finalScore += score;
    }

    private void findView() {
        tvTarget = findViewById(R.id.tv_target);
        tvScore = findViewById(R.id.tv_score);
        tvIndex = findViewById(R.id.tv_index);
        tvHeihei = findViewById(R.id.tv_heihei);
        sbBulsseye = findViewById(R.id.sb_bulsseye);
        btnOk = findViewById(R.id.btn_ok);
        btnHelp = findViewById(R.id.btn_help);
        btnReplay = findViewById(R.id.btn_replay);
        btnPlug = findViewById(R.id.btn_plug);
    }
}

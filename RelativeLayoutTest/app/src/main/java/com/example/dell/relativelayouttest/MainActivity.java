package com.example.dell.relativelayouttest;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private RadioGroup rdg_sex;
    private RadioButton rbt_n;
    private RadioButton rbt_nv;
    private CheckBox like_ym;
    private CheckBox like_lan;
    private CheckBox like_pp;
    private String hobbys = "您选择的兴趣爱好为：";
    private TextView tv_like;
    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myContext = this;
        setContentView(R.layout.activity_main);
        findView();
        setListener();
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String motion = buttonView.getText().toString();
        if (isChecked) {
            if (!hobbys.contains(motion)) {
                hobbys = hobbys + motion + "  ";
                tv_like.setText(hobbys);
            }
        }else {
            if (hobbys.contains(motion)){
                hobbys = hobbys.replace(motion,"");
                tv_like.setText(hobbys);
            }
        }
    }

    private void setListener(){

        btn_three.setOnClickListener(this);
        like_ym.setOnCheckedChangeListener(this);
        like_lan.setOnCheckedChangeListener(this);
        like_pp.setOnCheckedChangeListener(this);

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_two.setText("按钮按下");
                Toast.makeText(MainActivity.this, "按钮2按下!", Toast.LENGTH_LONG).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(myContext)
                        .setTitle("普通对话框")
                        .setMessage("是否确定退出应用：")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        rdg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbt_n){
                    Toast.makeText(MainActivity.this, "您的性别是："+rbt_n.getText(), Toast.LENGTH_LONG).show();
                }else if (checkedId == R.id.rbt_nv){
                    Toast.makeText(MainActivity.this, "您的性别是："+rbt_nv.getText(), Toast.LENGTH_LONG).show();
                }
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
        rdg_sex = findViewById(R.id.rdg_sex);
        rbt_n = findViewById(R.id.rbt_n);
        rbt_nv = findViewById(R.id.rbt_nv);
        like_ym = findViewById(R.id.like_ym);
        like_lan = findViewById(R.id.like_lan);
        like_pp = findViewById(R.id.like_pp);
        tv_like = findViewById(R.id.tv_like);
    }


}

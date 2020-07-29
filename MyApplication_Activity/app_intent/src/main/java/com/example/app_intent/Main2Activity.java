package com.example.app_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private EditText et_name;
    private RadioGroup rdg_geder;
    private RadioButton rd_man;
    private RadioButton rd_weman;
    private CheckBox cb_eat;
    private CheckBox cb_sleep;
    private CheckBox cb_play;
    private Button btn_close;

    private String name = "";
    private String hobbys = "";
    private String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findView();
        setListener();
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String motion = buttonView.getText().toString();
        if (isChecked) {
            if (!hobbys.contains(motion)) {
                hobbys = hobbys + motion + "  ";
            }
        }else {
            if (hobbys.contains(motion)){
                hobbys = hobbys.replace(motion,"");
            }
        }
    }

    private void setListener(){

        cb_eat.setOnCheckedChangeListener(Main2Activity.this);
        cb_sleep.setOnCheckedChangeListener(Main2Activity.this);
        cb_play.setOnCheckedChangeListener(Main2Activity.this);

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

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_name.getText().toString();
                Intent intent = new Intent();
//                Bundle bundle = new Bundle();
//                bundle.putString("name",name);
//                bundle.putString("gender",gender);
//                bundle.putString("hobby",hobbys);
//                intent.putExtras(bundle);
                intent.putExtra("name",name);
                intent.putExtra("gender",gender);
                intent.putExtra("hobbys",hobbys);
                setResult(2,intent);
                finish();
            }
        });
    }

    private void findView(){
        et_name = findViewById(R.id.et_name);
        rdg_geder = findViewById(R.id.rdg_geder);
        rd_man = findViewById(R.id.rd_man);
        rd_weman = findViewById(R.id.rd_weman);
        cb_eat = findViewById(R.id.cb_eat);
        cb_sleep = findViewById(R.id.cb_sleep);
        cb_play = findViewById(R.id.cb_play);
        btn_close = findViewById(R.id.btn_close);
    }
}

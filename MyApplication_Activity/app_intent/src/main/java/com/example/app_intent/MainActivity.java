package com.example.app_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_gender;
    private TextView tv_hobby;
    private Button btn_open;

    private String name="";
    private String gender="";
    private String hobbys="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==2){
//            Bundle bundle = data.getExtras();
//            name = bundle.getString("name");
//            gender = bundle.getString("gender");
//            hobbys = bundle.getString("hobbys");
            name = data.getStringExtra("name");
            gender = data.getStringExtra("gender");
            hobbys = data.getStringExtra("hobbys");
            setTvView();
        }
    }

    private void setListener(){
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    private void findView(){
        tv_name = findViewById(R.id.tv_name);
        tv_gender = findViewById(R.id.tv_gender);
        tv_hobby = findViewById(R.id.tv_hobby);
        btn_open = findViewById(R.id.btn_open);
    }

    private void setTvView(){
        tv_name.setText("姓名："+name);
        tv_gender.setText("性别："+gender);
        tv_hobby.setText("爱好："+hobbys);
    }
}

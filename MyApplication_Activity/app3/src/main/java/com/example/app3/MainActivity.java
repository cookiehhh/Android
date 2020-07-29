package com.example.app3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private TextView tv_name, tv_pass;
    private EditText et_name, et_pass;
    private Button btn_open;

    private String name = "";
    private String pass = "";
    private String mes = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();
    }

    private void setListener(){
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_name.getText().toString();
                pass = et_pass.getText().toString();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",name);
                intent.putExtra("pass",pass);
                startActivityForResult(intent,1);
            }
        });
    }

    private void findView(){
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        btn_open = findViewById(R.id.btn_open);
    }

    private void onOpenAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("登录判断")
                .setMessage(mes)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==2){
            mes = data.getStringExtra("mes");
            onOpenAlertDialog();
        }
    }
}

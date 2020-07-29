package com.example.app2;

import android.content.Context;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText et_text;
    private Button btn_write,btn_read;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        ActivityCompat.requestPermissions(this,new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},1);
        findView();
        setListener();
    }

    private void setListener(){
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = et_text.getText().toString();
                String state = Environment.getExternalStorageState();
                if (state.equals(Environment.MEDIA_MOUNTED)){
                    File SDPath = Environment.getExternalStorageDirectory();
                    File file = new File(SDPath,"data.txt");
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(text.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (fileOutputStream!=null){
                            try {
                                fileOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = Environment.getExternalStorageState();
                if (state.equals(Environment.MEDIA_MOUNTED)){
                    File SDPath = Environment.getExternalStorageDirectory();
                    File file = new File(SDPath,"data.txt");
                    FileInputStream fileInputStream = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                        byte[] bytes = new byte[fileInputStream.available()];
                        fileInputStream.read(bytes);
                        String content = new String(bytes);
                        Toast.makeText(mContext,content,Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (fileInputStream!=null){
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    private void findView(){
        et_text = findViewById(R.id.et_text);
        btn_write = findViewById(R.id.btn_write);
        btn_read = findViewById(R.id.btn_read);
    }
}

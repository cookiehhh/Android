package com.example.app2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private EditText et_text;
    private Button btn_write, btn_read;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mContext = this;
        findView();
        setListener();
    }

    private void setListener() {
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String text = et_text.getText().toString();

            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput("data.txt", MODE_PRIVATE);
                fileOutputStream.write(text.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            FileInputStream fileInputStream = null;
            try {
                fileInputStream = openFileInput("data.txt");
                byte[] bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                String content = new String(bytes);
                Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            }
        });
    }

    private void findView() {
        et_text = findViewById(R.id.et_text);
        btn_write = findViewById(R.id.btn_write);
        btn_read = findViewById(R.id.btn_read);
    }
}

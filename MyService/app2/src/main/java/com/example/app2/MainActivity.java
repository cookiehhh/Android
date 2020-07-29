package com.example.app2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyService.MyBinder myBinder;
    private MyConn myConn;
    private Button btn_bind,btn_call,btn_unbind;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        btn_bind = findViewById(R.id.btn_bind);
        btn_call = findViewById(R.id.btn_call);
        btn_unbind = findViewById(R.id.btn_unbind);

        btn_bind.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        btn_unbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bind:
                if (myConn == null){
                    myConn = new MyConn();
                }
                Intent intent = new Intent(MainActivity.this,MyService.class);
                bindService(intent,myConn,BIND_AUTO_CREATE);
                break;
            case R.id.btn_call:
                myBinder.callMethodInService();
                break;
            case R.id.btn_unbind:
                if (myConn != null){
                    unbindService(myConn);
                    myConn = null;
                }
                break;
        }
    }


    private class MyConn implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder)service;
            Log.i(TAG, "onServiceConnected: 服务绑定成功，内存地址为："+myBinder.toString());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}

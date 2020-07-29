package com.example.paintcircle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "------------------onCreate------------------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "------------------onStart:------------------");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "------------------onStop:------------------");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "------------------onDestroy: ------------------");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "------------------onPause: ------------------");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "------------------onResume: ------------------");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "------------------onRestart: ------------------");
        super.onRestart();
    }
}

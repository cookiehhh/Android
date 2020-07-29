package com.example.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView lv_one;

    private String[] name = {"张三","李四","王五"};

    List<Map<String,String>> data = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setManage();

//        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_multiple_choice,name);
//
//        lv_one.setAdapter(adapter);
//        lv_one.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,
                data,
                android.R.layout.simple_list_item_2,
                new String[]{"name","desc"},
                new int[]{android.R.id.text1,android.R.id.text2});

        lv_one.setAdapter(adapter);
    }

    private void setManage(){
        for (int i=1;i<20;i++){
            Map<String,String> map = new HashMap<String,String>();
            map.put("name","第"+i+"个人");
            map.put("desc","是个美女。");

            data.add(map);
        }
    }

    private void findView(){
        lv_one = findViewById(R.id.lv_one);
    }
}

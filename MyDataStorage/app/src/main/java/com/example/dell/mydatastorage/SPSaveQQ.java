package com.example.dell.mydatastorage;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 2019/11/6.
 */

public class SPSaveQQ {
    public static boolean saveUserInfo(Context context,String account,String password){
        SharedPreferences sharedPreferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("account",account);
        editor.putString("password",password);
        editor.commit();
        return true;
    }

    public static Map<String,String> getUserInfo(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String account = sharedPreferences.getString("account",null);
        String password = sharedPreferences.getString("password",null);
        Map<String,String> userMap = new HashMap<String, String>();
        userMap.put("account",account);
        userMap.put("password",password);
        return userMap;
    }
}

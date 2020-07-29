package com.example.dell.mydatastorage;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 2019/11/4.
 */

public class FileSaveQQ {

    public static boolean saveUserInfo(Context context,String account,String password){
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = context.openFileOutput("data.txt",Context.MODE_PRIVATE);

            fileOutputStream.write((account+":"+password).getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String,String> getUserInfo(Context context){
        String content = "";
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = context.openFileInput("data.txt");
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            content = new String(bytes);
            Map<String,String> userMap = new HashMap<String, String>();
            String[] infos = content.split(":");
            userMap.put("account",infos[0]);
            userMap.put("password",infos[1]);
            return userMap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if (fileInputStream!=null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

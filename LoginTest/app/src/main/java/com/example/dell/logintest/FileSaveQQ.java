package com.example.dell.logintest;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 2020/6/24.
 */

public class FileSaveQQ {
    public static boolean saveUserInfo(Context context, String account, String
            password) {
        FileOutputStream fos = null;
        try {

            fos = context.openFileOutput("data.txt",
                    Context.MODE_PRIVATE);

            fos.write((account + ":" + password).getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, String> getUserInfo(Context context) {
        String content = "";
        FileInputStream fis = null;
        try {

            fis = context.openFileInput("data.txt");

            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            content = new String(buffer);
            Map<String, String> userMap = new HashMap<String, String>();
            String[] infos = content.split(":");
            userMap.put("account", infos[0]);
            userMap.put("password", infos[1]);
            return userMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

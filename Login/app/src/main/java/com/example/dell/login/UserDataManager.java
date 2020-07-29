package com.example.dell.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Dell on 2019/11/16.
 */

public class UserDataManager {

    private UserDBHelper userDBHelper;
    private SQLiteDatabase database;
    private ContentValues contentValues;

    private static final String TAG = "UserDataManager";

    public UserDataManager(Context context){
        userDBHelper = new UserDBHelper(context);
    }



    //根据用户名和密码找用户，用于登录
    public int findUserByNameAndPwd(String userName,String userpwd){
        database = userDBHelper.getWritableDatabase();
        Log.i(TAG,"findUserByNameAndPwd");
        int result=0;
        Cursor cursor = database.query("users",null,"username=? and userpwd=?",
                new String[]{userName,userpwd},null,null,null);
        if(cursor!=null){
            result=cursor.getCount();
            Log.i(TAG,"findUserByNameAndPwd , result="+result);
        }
        cursor.close();
        database.close();
        return result;
    }

    //添加新用户，即注册
    public int insertUserData(UserData userData) {
        database = userDBHelper.getWritableDatabase();
        String userName=userData.getUserName();
        String userPwd=userData.getUserPwd();
        contentValues = new ContentValues();
        contentValues.put("userpwd",userPwd);
        contentValues.put("username",userName);
        int result = (int)database.insert("users",null,contentValues);
        database.close();
        return result;
    }

    //根据用户名找用户，可以判断注册时用户名是否已经存在
    public int findUserByName(String userName){
        database = userDBHelper.getWritableDatabase();
        Log.i(TAG,"findUserByName , userName="+userName);
        int result=0;
        Cursor cursor = database.query("users",null,"username=?",
                new String[]{userName},null,null,null);
        if(cursor!=null){
            result=cursor.getCount();
            Log.i(TAG,"findUserByName , result="+result);
        }
        cursor.close();
        database.close();
        return result;
    }
}

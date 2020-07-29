package com.example.app_login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dell on 2019/11/13.
 */

public class AdminHelper extends SQLiteOpenHelper {
    public AdminHelper(Context context) {
        super(context, "admindb.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table admin(id integer primary key autoincrement,account varchar(20),password varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
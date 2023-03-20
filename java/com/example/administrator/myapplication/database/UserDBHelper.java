package com.example.administrator.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2023/3/19.
 */

public class UserDBHelper extends SQLiteOpenHelper {

    public UserDBHelper(Context context){
        super(context,"user.db",null,1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql = "create table userInfo" +
                "(id integer primary key autoincrement," +
                "account varchar(20)," +
                "password varchar(20))";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}

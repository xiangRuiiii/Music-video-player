package com.example.administrator.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2023/3/20.
 *
 * 通讯录的地址
 */

public class MailListHelper extends SQLiteOpenHelper {

    public MailListHelper(Context context){
        super(context,"mailList.db",null,1);
    }

    // 创建或者打开数据库
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE userInfo(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(20),  " +
                "phone VARCHAR(20),  address VARCHAR(20))");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }


}

package com.example.administrator.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;


/**
 * Created by Administrator on 2023/3/15.
 * 1、创建一个类，继承SQLiteOpenHelper
 * 2、重写方法和创建构造方法
 * 3、创建子类对象，再调用getReadableDatabase()/getWriteableDatabase()方法，即可创建数据库
 */

public class MyDataBaseHelper extends SQLiteOpenHelper{

    public static final String CREATE_DATA = "create table Person(" +

            //primary key 将id列设为主键    autoincrement表示id列是自增长的
            "id integer primary key autoincrement," +
            "name text," +
            "age real)";

    private Context mContext;

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，
    // 一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级
    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context, name, cursorFactory, version);
        mContext = context;
    }

    public void onCreate(SQLiteDatabase db){

        // 调用SQLite中的execSQL()执行建表语句
        db.execSQL(CREATE_DATA);

        // 创建成功
        Toast.makeText(mContext, "创建成功", Toast.LENGTH_SHORT).show();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 当版本升级时回调
        // 表示调试信息，可把程序运行时的变量值打印出来，方便跟踪调试。
        Log.d(TAG,"升级数据库...");

        String sql;

        switch (oldVersion){
            case 1:
                sql = "alter Person add phone integer";
                db.execSQL(sql);
                break;
            case 2:
                sql = "alter Person add salary integer";
                db.execSQL(sql);
                break;
        }

    }

}

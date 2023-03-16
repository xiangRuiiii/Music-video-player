package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.administrator.myapplication.R.*;


/**
 * Created by Administrator on 2023/3/16.
 */

public class DatabaseTest extends AppCompatActivity {

    private MyDataBaseHelper dataBaseHelper;


    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(layout.database_test_layout);

        dataBaseHelper = new MyDataBaseHelper(this,"Person.db",null,1);
        Button createDbBtn = findViewById(id.create_db_btn);
        createDbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 创建或者打开现有的数据库
                dataBaseHelper.getWritableDatabase();
            }
        });

        Button updateDBtn = findViewById(id.update_db_btn);
        updateDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.getWritableDatabase();
            }
        });
    }
}

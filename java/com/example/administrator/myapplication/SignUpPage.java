package com.example.administrator.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.myapplication.database.UserDBHelper;

/**
 * Created by Administrator on 2023/3/17.
 */

public class SignUpPage extends AppCompatActivity{

    UserDBHelper userDBHelper;

    EditText editAccount;
    EditText editPassword;
    Button btn_sign_up;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_layout);

        editAccount = findViewById(R.id.editAccount);
        editPassword = findViewById(R.id.editPassword);
        btn_sign_up = findViewById(R.id.btnSignUp);

        userDBHelper = new UserDBHelper(this);
        btn_sign_up.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // 创建或打开现有的数据库
                userDBHelper.getWritableDatabase();

                Log.d("Tag","创建成功");

                int count = 0;
                String Account = editAccount.getText().toString();
                String Password = editPassword.getText().toString();

                SQLiteDatabase db = userDBHelper.getWritableDatabase();
//                db.execSQL("insert into userInfo (account,password) values (?,?)",new Object[]{
//                        Account,Password
//                });
            }

        });


    }



}

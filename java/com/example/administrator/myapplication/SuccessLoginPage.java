package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.administrator.myapplication.R.*;

/**
 * Created by Administrator on 2023/3/15.
 */

public class SuccessLoginPage extends AppCompatActivity {

    TextView text_username;
    TextView text_password;
    Button btn_back;


    protected void  onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success1);



        // 利用布局文件设置用户界面
        text_username = findViewById(R.id.textUsername);
        text_password = findViewById(R.id.textPassword);
        btn_back = findViewById(R.id.btnBack);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentBack = new Intent(SuccessLoginPage.this,LoginPage.class);

                Toast.makeText(SuccessLoginPage.this,"跳转成功",Toast.LENGTH_LONG);

                startActivity(intentBack);


            }
        });

        // 获取意图的内容
        Intent intent = getIntent();

        String Username = intent.getStringExtra("username");
        String Password = intent.getStringExtra("password");

        text_username.setText(Username);
        text_password.setText(Password);
    }


}

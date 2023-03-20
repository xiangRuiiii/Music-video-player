package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.administrator.myapplication.R.*;


/**
 * Created by Administrator on 2023/3/6.
 * 登陆页面
 */

public class LoginPage extends AppCompatActivity{


    EditText username;
    EditText password;
    TextView nickname;
    TextView signup;

    private Button login_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.login_in);

        // 利用布局文件设置用户界面
        username = findViewById(id.account);
        password = findViewById(id.password);
        nickname = findViewById(id.textNickName);

        login_btn = findViewById(id.login_btn);

        signup = findViewById(id.textSignUp);

        // 注册按钮
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginPage.this,"跳转到注册",Toast.LENGTH_SHORT);

                Intent intent_to_sign_up_page = new Intent(LoginPage.this,SignUpPage.class);
                startActivity(intent_to_sign_up_page);
            }
        });


        // 登录按钮
        login_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // 保存用户输入的数据用户名和密码
                String var_username = username.getText().toString();
                String var_password = password.getText().toString();

                // 判断用户名输入是否正确（数据库检测）

                if(var_username.equals("xiangRui") && var_password.equals("123456")){
                    Toast.makeText(LoginPage.this,"登陆成功",Toast.LENGTH_SHORT).show();

                    // 创建意图  参数1：本页面 参数2：跳转页面

                    Intent intent = new Intent(LoginPage.this,SuccessLoginPage.class);



                    // 创建Bundle绑定信息
                    Bundle bundle = new Bundle();
                    bundle.putString("username",var_username);
                    bundle.putString("password",var_password);

                    // 利用意图传递信息
                    intent.putExtras(bundle);
                    // 按照意图启动窗口
                    startActivity(intent);
                }else if(var_username.equals("") || var_password.equals("")){
                    Toast.makeText(LoginPage.this,"账号或密码错误为空，请重新输入",Toast.LENGTH_SHORT).show();
//                    Log.d("Tag","跳转成功");
                }else{
                    Toast.makeText(LoginPage.this,"账号或密码错误错误，登陆失败",Toast.LENGTH_SHORT).show();
                }


            }
        });


        Intent getNickNameIntent = getIntent();
        String NickName = getNickNameIntent.getStringExtra("nickname");

        nickname.setText(NickName);



    }



}

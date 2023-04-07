package cn.itcast.ks.androidks;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.itcast.ks.androidks.adapter.MusicListViewMain;
import cn.itcast.ks.androidks.database.UserDBHelper;
import cn.itcast.ks.androidks.fragment.FragmentMain;
import cn.itcast.ks.androidks.fragment.MusicFragment;


/**
 * Created by Administrator on 2023/3/6.
 * 登陆页面
 */

public class LoginPage extends AppCompatActivity {

    UserDBHelper userDBHelper;
    EditText username;
    EditText password;

    TextView signup;


    Button BtnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_in_layout);

        // 利用布局文件设置用户界面
//        init();
        username = findViewById(R.id.edit_account);
        password = findViewById(R.id.edit_password);
        BtnLogin = findViewById(R.id.btn_login);
        signup = findViewById(R.id.textSignUp);

        userDBHelper = new UserDBHelper(this);  // 实例化userDBHelper

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginPage.this,"跳转到注册",Toast.LENGTH_SHORT);
                Log.i("TAG","跳转");

                Intent intent_to_fragment = new Intent(LoginPage.this,SignUpPage.class);
                startActivity(intent_to_fragment);
            }
        });

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String var_username = username.getText().toString();
                String var_password = password.getText().toString();
                SQLiteDatabase db = userDBHelper.getReadableDatabase();


                if(var_username.equals("") || var_password.equals("")){
                    Toast.makeText(LoginPage.this,"请输入账号密码",Toast.LENGTH_LONG).show();
                    Log.i("TAG","输入信息");
                }


                Cursor cursor = db.query("userInfo",null,"account=? and password=?",
                        new String[]{var_username,var_password},
                        null,null,null);
                if(cursor.getCount() == 0){
                    Toast.makeText(LoginPage.this,"账号密码不存在",Toast.LENGTH_LONG).show();
                }else{
                    // 创建意图  参数1：本页面 参数2：跳转页面
                    Intent intent = new Intent(LoginPage.this,FragmentMain.class);
                    startActivity(intent);
                }
                cursor.close();
                db.close();
            }
        });



    }


}

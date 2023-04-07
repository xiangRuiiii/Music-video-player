package cn.itcast.ks.androidks;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.itcast.ks.androidks.database.UserDBHelper;


/**
 * Created by Administrator on 2023/3/17.
 */

public class SignUpPage extends AppCompatActivity implements View.OnClickListener{

    UserDBHelper userDBHelper;

    private EditText editAccount;
    private EditText editPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_layout);
        userDBHelper = new UserDBHelper(this);
        init();//初始化控件
    }

    public void init(){
        editAccount = findViewById(R.id.editAccount);
        editPassword = findViewById(R.id.editPassword);
    }

    public void onClick(View view){
        String account;
        String password;
        SQLiteDatabase db;
        ContentValues contentValues;

        account = editAccount.getText().toString();
        password = editPassword.getText().toString();
        db = userDBHelper.getWritableDatabase();
        contentValues = new ContentValues();
        if(account.equals("") || password.equals("")){
            Toast.makeText(this,"添加失败，请输入合适信息",Toast.LENGTH_SHORT).show();
        }else{
            contentValues.put("account",account);
            contentValues.put("password",password);

            db.insert("userInfo",null,contentValues);
            Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
            db.close();
        }
    }


}




package com.example.administrator.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.database.MailListHelper;

/**
 * Created by Administrator on 2023/3/20.
 */

public class GreenBeanMailList extends AppCompatActivity implements View.OnClickListener{

    MailListHelper mailListHelper;
    private EditText mEtName;
    private EditText mEtPhone;
    private EditText mEtAddress;
    private TextView mTvShow;
    private Button mBtnAdd;
    private Button mBtnQuery;
    private Button mBtnUpdate;
    private Button mBtnDelete;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.green_bean_layout);
        mailListHelper = new MailListHelper(this);
        init();//初始化控件
    }


    // 初始化控件
    public void init(){
        mEtName = findViewById(R.id.et_name);
        mEtPhone = findViewById(R.id.et_phone);
        mEtAddress = findViewById(R.id.et_address);
        mTvShow = findViewById(R.id.tv_show);
        mBtnAdd = findViewById(R.id.btn_add);
        mBtnQuery = findViewById(R.id.btn_query);
        mBtnUpdate = findViewById(R.id.btn_update);
        mBtnDelete = findViewById(R.id.btn_delete);
        mBtnAdd.setOnClickListener(this);
        mBtnQuery.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
    }

    public void onClick(View v){

        String name;
        String phone;
        String address;
        SQLiteDatabase db;
        ContentValues contentValues;


        switch (v.getId()){
            case R.id.btn_add:   // 添加数据
                name = mEtName.getText().toString();
                phone = mEtPhone.getText().toString();
                address = mEtAddress.getText().toString();
                db = mailListHelper.getReadableDatabase();  // 获取可读写SQLiteDatabase对象
                contentValues = new ContentValues();  // 创建ContentValues对象
                if(name.equals("") || phone.equals("") || address.equals("")){
                    Toast.makeText(this,"添加失败，请输入合适信息",Toast.LENGTH_SHORT).show();
                }else{
                    contentValues.put("name",name);
                    contentValues.put("phone",phone);
                    contentValues.put("address",address);

                    db.insert("userInfo",null,contentValues);
                    Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
                    db.close();
                }
                break;
            case R.id.btn_query:  // 查询数据
                db = mailListHelper.getReadableDatabase();
                Cursor cursor = db.query("userInfo",null,"name=?",
                        new String[]{mEtName.getText().toString()},
                        null,null,null);
                if(cursor.getCount() == 0){
                    mTvShow.setText("");
                    Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
                }else{
                    cursor.moveToFirst();
                    mTvShow.setText("姓名：" + cursor.getString(1) +
                    " 电话：" + cursor.getString(2) +
                    " 地址：" + cursor.getString(3));
                }
                while(cursor.moveToNext()){
                    mTvShow.append("\n" + "姓名：" + cursor.getString(1) +
                            " 电话：" + cursor.getString(2) +
                            " 地址：" + cursor.getString(3));
                }
                cursor.close();
                db.close();
                break;

            case R.id.btn_update:  // 修改数据
                db = mailListHelper.getWritableDatabase();
                contentValues = new ContentValues();       // 要修改的数据
                contentValues.put("phone", mEtPhone.getText().toString());
                contentValues.put("address", mEtAddress.getText().toString());
                db.update("userInfo", contentValues, "name=?",
                        new String[]{mEtName.getText().toString()}); // 更新并得到行数
                Toast.makeText(this, "信息已修改", Toast.LENGTH_SHORT).show();
                db.close();
                break;

            case R.id.btn_delete: //删除数据
                db = mailListHelper.getWritableDatabase();
                db.delete("userInfo", "name=?", new String[]{mEtName.getText().toString()});
                Toast.makeText(this, "信息已删除", Toast.LENGTH_SHORT).show();
                mTvShow.setText("");
                db.close();
                break;
        }

    }

}

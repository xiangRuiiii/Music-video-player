package com.example.administrator.myapplication.bean;

/**
 * Created by Administrator on 2023/3/19.
 */

public class AccountPassword {

    private String account;
    private String password;

    public AccountPassword(){}
    public AccountPassword(String account, String password){
        this.account = account;
        this.password = password;
    }

    public String getAccount(){
        return account;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

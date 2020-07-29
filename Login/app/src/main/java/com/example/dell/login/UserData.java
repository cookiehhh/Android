package com.example.dell.login;

/**
 * Created by Dell on 2019/11/16.
 */

public class UserData {

    private int userId;
    private String userName;
    private String userPassword;

    public UserData(String userName, String userPwd){
        this.userName = userName;
        this.userPassword = userPwd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPassword;
    }

    public void setUserPwd(String userPwd) {
        this.userPassword = userPwd;
    }
}

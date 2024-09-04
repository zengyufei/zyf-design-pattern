package com.zyf.entitys;


import java.io.Serializable;

/**
 * 用户信息
 */
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    public String getUserId() {
        return userId;
    }

    public LoginUser setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public LoginUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}

package com.gyyx.core.model;


import com.gyyx.core.mybatis.annotations.TableId;
import com.gyyx.core.mybatis.annotations.TableName;

import java.io.Serializable;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/17 10:47
 */
@TableName("rbac_user")
public class RbacUser implements Serializable{

    @TableId
    private int userId;
    private String userName;
    private String email;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.zjl.zjl_crm.vo;

import java.io.Serializable;

/**
 * Created by Tony on 2016/8/22.
 */
@SuppressWarnings("serial")
public class UserLoginIdentity implements Serializable {
	
    private String userIdString;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdString() {
        return userIdString;
    }

    public void setUserIdString(String userIdString) {
        this.userIdString = userIdString;
    }
}

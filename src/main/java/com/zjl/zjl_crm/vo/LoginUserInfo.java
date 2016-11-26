package com.zjl.zjl_crm.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginUserInfo implements Serializable {
	
	private String userName;
	private String realName;
	private String roleName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

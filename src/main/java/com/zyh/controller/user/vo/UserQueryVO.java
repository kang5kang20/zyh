package com.zyh.controller.user.vo;

import com.github.pagehelper.PageInfo;

public class UserQueryVO extends PageInfo{
	
	private String userid;
	
	private String username;

	private String openid;
	
	private String phone;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}

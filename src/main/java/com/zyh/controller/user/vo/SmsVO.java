package com.zyh.controller.user.vo;

import java.io.Serializable;

public class SmsVO implements Serializable{
	
	private String phone;
	
	private String code;
	
	private int verifyCode;
	
	public String getPhone() {
		return phone;
	}

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}

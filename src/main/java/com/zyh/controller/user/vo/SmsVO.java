package com.zyh.controller.user.vo;

import java.io.Serializable;

public class SmsVO implements Serializable{
	
	private String phone;
	
	private String code;
	
	private String verifyCode;
	
	private String modelId;
	
	public String getPhone() {
		return phone;
	}


	public String getVerifyCode() {
		return verifyCode;
	}


	public void setVerifyCode(String verifyCode) {
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

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	
	
}

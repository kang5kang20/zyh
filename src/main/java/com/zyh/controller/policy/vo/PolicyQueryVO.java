package com.zyh.controller.policy.vo;

import com.github.pagehelper.PageInfo;

public class PolicyQueryVO extends PageInfo{
	
	private String title;
	
	private String ifground;
	
	private String createuser;
	
	private String userid;
	
	private String policyid;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIfground() {
		return ifground;
	}

	public void setIfground(String ifground) {
		this.ifground = ifground;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPolicyid() {
		return policyid;
	}

	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}
	
	
}

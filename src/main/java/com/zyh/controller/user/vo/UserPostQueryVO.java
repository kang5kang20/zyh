package com.zyh.controller.user.vo;

import com.github.pagehelper.PageInfo;

public class UserPostQueryVO extends PageInfo{
	
	private String id;
	
	private String userid;
	
	private String positionid;
	
	private String companyid;
	
	private String posttype;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPositionid() {
		return positionid;
	}

	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getPosttype() {
		return posttype;
	}

	public void setPosttype(String posttype) {
		this.posttype = posttype;
	}
	
	
}

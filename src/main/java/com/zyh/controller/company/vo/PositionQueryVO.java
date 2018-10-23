package com.zyh.controller.company.vo;

import com.github.pagehelper.PageInfo;

public class PositionQueryVO extends PageInfo{
	
	private String id;
	
	private String companyId;
	
	private String postionName;
	
	private String companyName;
	
	private String workcity;
	
	private float minmoney;
	
	private float maxmoney;
	
	private String posttype;

	public String getId() {
		return id;
	}

	public void setMinmoney(float minmoney) {
		this.minmoney = minmoney;
	}

	public void setMaxmoney(float maxmoney) {
		this.maxmoney = maxmoney;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPostionName() {
		return postionName;
	}

	public void setPostionName(String postionName) {
		this.postionName = postionName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWorkcity() {
		return workcity;
	}

	public void setWorkcity(String workcity) {
		this.workcity = workcity;
	}

	public float getMinmoney() {
		return minmoney;
	}

	public float getMaxmoney() {
		return maxmoney;
	}

	public String getPosttype() {
		return posttype;
	}

	public void setPosttype(String posttype) {
		this.posttype = posttype;
	}

	
}

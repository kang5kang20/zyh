package com.zyh.controller.company.vo;

import java.io.Serializable;

import com.github.pagehelper.PageInfo;

public class TrainQueryVO extends PageInfo implements Serializable{

	private String id;
	
    private String name;
    
    private String companyid;
    
    private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    
}

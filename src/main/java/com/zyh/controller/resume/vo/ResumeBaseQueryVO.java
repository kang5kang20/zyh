package com.zyh.controller.resume.vo;

import com.github.pagehelper.PageInfo;

public class ResumeBaseQueryVO extends PageInfo{

	private String userid;
	
	private String idcheckstate;
	
	private String soldiercheckstate;
	
	private String workstate;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getIdcheckstate() {
		return idcheckstate;
	}

	public void setIdcheckstate(String idcheckstate) {
		this.idcheckstate = idcheckstate;
	}

	public String getSoldiercheckstate() {
		return soldiercheckstate;
	}

	public void setSoldiercheckstate(String soldiercheckstate) {
		this.soldiercheckstate = soldiercheckstate;
	}

	public String getWorkstate() {
		return workstate;
	}

	public void setWorkstate(String workstate) {
		this.workstate = workstate;
	}
	
	
}

package com.zyh.controller.classes.vo;

import com.github.pagehelper.PageInfo;

public class TeacherQueryVO extends PageInfo{
	
	private String name;
	
	private String createuser;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
}

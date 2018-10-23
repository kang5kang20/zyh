package com.zyh.controller.bulletin.vo;

import com.github.pagehelper.PageInfo;


public class BulletinQueryVO extends PageInfo{
	
	private String title;
	
	private String createuser;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}



}

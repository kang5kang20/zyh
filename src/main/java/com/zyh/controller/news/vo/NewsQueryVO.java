package com.zyh.controller.news.vo;

import com.github.pagehelper.PageInfo;


public class NewsQueryVO extends PageInfo{
	
	private String title;
	
	private String ifground;
	
	private String createuser;

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
	
	
}

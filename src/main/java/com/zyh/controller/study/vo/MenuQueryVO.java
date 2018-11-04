package com.zyh.controller.study.vo;

import com.github.pagehelper.PageInfo;

public class MenuQueryVO extends PageInfo{
	private String name;
	
	private String createuser;
	
	private String menuid;
	
	private String ifground;
	
	private String lanmuid;

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

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getIfground() {
		return ifground;
	}

	public void setIfground(String ifground) {
		this.ifground = ifground;
	}

	public String getLanmuid() {
		return lanmuid;
	}

	public void setLanmuid(String lanmuid) {
		this.lanmuid = lanmuid;
	}
	
	
}

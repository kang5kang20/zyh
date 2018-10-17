package com.zyh.controller.ad.vo;

import com.github.pagehelper.PageInfo;

public class AdQueryVO extends PageInfo{
	private String adid;
	
	private String title;
	
	private String createuser;

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

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

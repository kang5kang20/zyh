package com.zyh.controller.classes.vo;

import com.github.pagehelper.PageInfo;

public class CourseQueryVO extends PageInfo{
	private String title;
	
	private String createuser;
	
	private String userid;
	
	private String courseid;
	
	private String ifground;

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getIfground() {
		return ifground;
	}

	public void setIfground(String ifground) {
		this.ifground = ifground;
	}
	
	
}

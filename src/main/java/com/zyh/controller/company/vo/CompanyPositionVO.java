package com.zyh.controller.company.vo;

import com.zyh.entity.company.ZyhCompanyPosition;

public class CompanyPositionVO extends ZyhCompanyPosition{
	
	private String companylabel;
	
	private String ifpost;

	public String getCompanylabel() {
		return companylabel;
	}

	public void setCompanylabel(String companylabel) {
		this.companylabel = companylabel;
	}

	public String getIfpost() {
		return ifpost;
	}

	public void setIfpost(String ifpost) {
		this.ifpost = ifpost;
	}

	
	
}

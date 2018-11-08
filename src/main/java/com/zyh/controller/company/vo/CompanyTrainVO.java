package com.zyh.controller.company.vo;

import com.zyh.entity.company.ZyhCompanyTrain;

public class CompanyTrainVO extends ZyhCompanyTrain{
	
	private String ifpost;

	public String getIfpost() {
		return ifpost;
	}

	public void setIfpost(String ifpost) {
		this.ifpost = ifpost;
	}

	public CompanyTrainVO(ZyhCompanyTrain zyhCompanyTrain) {
		this.setClassdesc(zyhCompanyTrain.getClassdesc());
		this.setCompanyid(zyhCompanyTrain.getCompanyid());
		this.setCompanyname(zyhCompanyTrain.getCompanyname());
		this.setCreatetime(zyhCompanyTrain.getCreatetime());
		this.setId(zyhCompanyTrain.getId());
		this.setLabel(zyhCompanyTrain.getLabel());
		this.setLabeltxt(zyhCompanyTrain.getLabeltxt());
		this.setName(zyhCompanyTrain.getName());
		this.setState(zyhCompanyTrain.getState());
		this.setTrainaddress(zyhCompanyTrain.getTrainaddress());
		this.setWeburl(zyhCompanyTrain.getWeburl());
	}
	
	public CompanyTrainVO(){
		
	}
}

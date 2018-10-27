package com.zyh.dao.company.cus;

import org.apache.ibatis.annotations.Param;

import com.zyh.controller.company.vo.CompanyPositionVO;

public interface ZyhCompanyPositionCusMapper {
	
	public CompanyPositionVO getCompnayPositById(@Param("positionid")String positionid)throws Exception;
}

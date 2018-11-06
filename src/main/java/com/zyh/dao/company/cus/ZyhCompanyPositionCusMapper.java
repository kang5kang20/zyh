package com.zyh.dao.company.cus;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.controller.company.vo.CompanyPositionVO;
import com.zyh.controller.company.vo.FirstQueryVO;

public interface ZyhCompanyPositionCusMapper {
	
	public CompanyPositionVO getCompnayPositById(@Param("positionid")String positionid)throws Exception;
	
	public List<FirstQueryVO> getCompanyByFirstPage(@Param("content")String content)throws Exception;
	
	public List<FirstQueryVO> getCompanyPositionByFirstPage(@Param("content")String content)throws Exception;
	
	public List<FirstQueryVO> getCompanyTrainByFirstPage(@Param("content")String content)throws Exception;
	
}

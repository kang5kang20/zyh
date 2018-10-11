package com.zyh.service.company;

import java.util.List;
import java.util.Map;

import com.zyh.entity.company.ZyhCompanyPosition;
import com.zyh.entity.company.ZyhCompanyPositionExample;

public interface ICompanyPositionService {
	
	public void addCompanyPosition(ZyhCompanyPosition zyhCompanyPosition)throws Exception;
	
	public void updateCompanyPosition(ZyhCompanyPosition zyhCompanyPosition,ZyhCompanyPositionExample zyhCompanyPositionExample)throws Exception;
	
    public void updateCompanyPositionById(ZyhCompanyPosition zyhCompanyPosition)throws Exception;
	
	public List<ZyhCompanyPosition> selectCompanyPositionByExample(ZyhCompanyPositionExample zyhCompanyPositionExample)throws Exception;
	
	public void delCompanyPositionById(String id)throws Exception;
	
	public void delCompanyPositionByExample(ZyhCompanyPositionExample zyhCompanyPositionExample)throws Exception;
	
	public Map<String, Object> selectCompanyPositionByPage(ZyhCompanyPositionExample zyhCompanyPositionExample,int pageNum,int pageSize)throws Exception;
}

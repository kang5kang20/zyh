package com.zyh.service.company.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.company.ZyhCompanyPositionMapper;
import com.zyh.entity.company.ZyhCompanyPosition;
import com.zyh.entity.company.ZyhCompanyPositionExample;
import com.zyh.service.company.ICompanyPositionService;


@Service("companyPositionService")
public class CompanyPositionServiceImpl implements ICompanyPositionService{
	
	@Autowired
	private ZyhCompanyPositionMapper zyhCompanyPositionMapper;

	@Override
	public void addCompanyPosition(ZyhCompanyPosition zyhCompanyPosition) throws Exception {
		zyhCompanyPositionMapper.insertSelective(zyhCompanyPosition);
	}

	@Override
	public void updateCompanyPosition(ZyhCompanyPosition zyhCompanyPosition,
			ZyhCompanyPositionExample zyhCompanyPositionExample) throws Exception {
		zyhCompanyPositionMapper.updateByExampleSelective(zyhCompanyPosition, zyhCompanyPositionExample);
		
	}

	@Override
	public void updateCompanyPositionById(ZyhCompanyPosition zyhCompanyPosition) throws Exception {
		zyhCompanyPositionMapper.updateByPrimaryKeySelective(zyhCompanyPosition);
	}

	@Override
	public List<ZyhCompanyPosition> selectCompanyPositionByExample(ZyhCompanyPositionExample zyhCompanyPositionExample)
			throws Exception {
		return zyhCompanyPositionMapper.selectByExample(zyhCompanyPositionExample);
	}

	@Override
	public void delCompanyPositionById(String id) throws Exception {
		zyhCompanyPositionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delCompanyPositionByExample(ZyhCompanyPositionExample zyhCompanyPositionExample) throws Exception {
		zyhCompanyPositionMapper.deleteByExample(zyhCompanyPositionExample);
	}
	
}

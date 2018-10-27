package com.zyh.service.company.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.controller.company.vo.CompanyPositionVO;
import com.zyh.dao.company.ZyhCompanyPositionMapper;
import com.zyh.dao.company.cus.ZyhCompanyPositionCusMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.common.Page;
import com.zyh.entity.company.ZyhCompanyPosition;
import com.zyh.entity.company.ZyhCompanyPositionExample;
import com.zyh.service.company.ICompanyPositionService;


@Service("companyPositionService")
public class CompanyPositionServiceImpl implements ICompanyPositionService{
	
	@Autowired
	private ZyhCompanyPositionMapper zyhCompanyPositionMapper;
	
	@Autowired
	private ZyhCompanyPositionCusMapper zyhCompanyPositionCusMapper;

	@Override
	public void addCompanyPosition(ZyhCompanyPosition zyhCompanyPosition) throws Exception {
		if (null==zyhCompanyPosition.getId()||"".equals(zyhCompanyPosition.getId())) {
			zyhCompanyPosition.setId(UUidUtil.getUUid());
		}
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

	@Override
	public Map<String, Object> selectCompanyPositionByPage(ZyhCompanyPositionExample zyhCompanyPositionExample,
			int pageNum, int pageSize) throws Exception {
		Map<String, Object> map  = new HashMap<>();
		List<ZyhCompanyPosition> list = zyhCompanyPositionMapper.selectByPage(zyhCompanyPositionExample, pageNum, pageSize);
		map.put("result", list);
		Page page = new Page();
		page.setPageNum(pageNum);
			page.setTotalRowCount(zyhCompanyPositionMapper.countByExample(zyhCompanyPositionExample));
		map.put("pageResult",page);
		return map;
	}

	@Override
	public CompanyPositionVO selectCompanyPositionInfo(String positionid) throws Exception {
		return zyhCompanyPositionCusMapper.getCompnayPositById(positionid);
	}
	
	
}

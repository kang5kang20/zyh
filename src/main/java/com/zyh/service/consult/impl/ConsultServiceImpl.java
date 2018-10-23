package com.zyh.service.consult.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.consult.ZyhConsultMapper;
import com.zyh.dao.consult.cus.ZyhConsultCusMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.common.Page;
import com.zyh.entity.consult.ZyhConsult;
import com.zyh.entity.consult.ZyhConsultExample;
import com.zyh.service.consult.IConsultService;

@Service("consultService")
public class ConsultServiceImpl implements IConsultService {

	@Autowired
	private ZyhConsultMapper zyhConsultMapper;
	
	@Autowired
	private ZyhConsultCusMapper zyhConsultCusMapper;
	
	@Override
	public void addConsult(ZyhConsult zyhConsult) throws Exception {
		if (null ==zyhConsult.getId()||"".equals(zyhConsult.getId())) {
			String id = UUidUtil.getUUid();
			zyhConsult.setId(id);
		}
		zyhConsultMapper.insertSelective(zyhConsult);
	}

	@Override
	public void updateConsult(ZyhConsult zyhConsult) throws Exception {
		zyhConsultMapper.updateByPrimaryKeySelective(zyhConsult);
		
	}

	@Override
	public void deleteConsult(String consultid) throws Exception {
		zyhConsultMapper.deleteByPrimaryKey(consultid);
	}

	@Override
	public ZyhConsult queryConsultById(String consultid) throws Exception {
		return zyhConsultMapper.selectByPrimaryKey(consultid);
	}

	@Override
	public List<ZyhConsult> findConsultList(ZyhConsultExample example)
			throws Exception {
		return zyhConsultMapper.selectByExample(example);
	}

	@Override
	public Map findConsultListByPage(ZyhConsultExample example, int pageNum,
			int pageSize) throws Exception {
		Map map = new HashMap();
		map.put("retlist", zyhConsultCusMapper.selectByPageNumSize(example, pageNum, pageSize));
		Page page = new Page();
		page.setPageNum(pageNum);
		page.setTotalRowCount(zyhConsultMapper.countByExample(example));
		map.put("page", page);
		return map;
	}

}

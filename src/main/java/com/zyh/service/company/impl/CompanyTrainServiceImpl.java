package com.zyh.service.company.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.company.ZyhCompanyTrainMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.common.Page;
import com.zyh.entity.company.ZyhCompanyTrain;
import com.zyh.entity.company.ZyhCompanyTrainExample;
import com.zyh.service.company.ICompanyTrainService;

@Service("companyTrainService")
public class CompanyTrainServiceImpl implements ICompanyTrainService{

	@Autowired
	private ZyhCompanyTrainMapper zyhCompanyTrainMapper;
	
	@Override
	public void addCompanyTrain(ZyhCompanyTrain zyhCompanyTrain) throws Exception {
		if (null==zyhCompanyTrain.getId()||"".equals(zyhCompanyTrain.getId())) {
			String id = UUidUtil.getUUid();
			zyhCompanyTrain.setId(id);
		}
		zyhCompanyTrainMapper.insert(zyhCompanyTrain);
	}


	@Override
	public void updateCompanyTrainByExam(ZyhCompanyTrain zyhCompanyTrain, ZyhCompanyTrainExample zyhCompanyTrainExample)
			throws Exception {
		zyhCompanyTrainMapper.updateByExampleSelective(zyhCompanyTrain, zyhCompanyTrainExample);
	}
	

	@Override
	public List<ZyhCompanyTrain> selectCompanyTrainByExample(ZyhCompanyTrainExample zyhCompanyTrainExample)
			throws Exception {
		return zyhCompanyTrainMapper.selectByExample(zyhCompanyTrainExample);
	}

	@Override
	public void delCompanyTrainById(String id) throws Exception {
		zyhCompanyTrainMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delCompanyTrainByExample(ZyhCompanyTrainExample zyhCompanyTrainExample) throws Exception {
		// TODO Auto-generated method stub
		zyhCompanyTrainMapper.deleteByExample(zyhCompanyTrainExample);
	}


	@Override
	public void updateCompanyTrainById(ZyhCompanyTrain zyhCompanyTrain) throws Exception {
		zyhCompanyTrainMapper.updateByPrimaryKeySelective(zyhCompanyTrain);
	}


	@Override
	public Map<String, Object> selectCompanyTrainByPage(ZyhCompanyTrainExample zyhCompanyTrainExample, int pageNum,
			int pageSize) throws Exception {
		Map<String, Object> map = new HashMap<>();
		List<ZyhCompanyTrain> list = zyhCompanyTrainMapper.selectTrainByPage(zyhCompanyTrainExample, pageNum, pageSize);
		map.put("result", list);
		Page page =new Page();
		page.setPageNum(pageNum);
		page.setTotalRowCount(zyhCompanyTrainMapper.countByExample(zyhCompanyTrainExample));
		map.put("pageResult", page);
		return map;
	}

	
}

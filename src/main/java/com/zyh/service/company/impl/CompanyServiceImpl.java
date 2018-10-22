package com.zyh.service.company.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.company.ZyhCompanyMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.common.Page;
import com.zyh.entity.company.ZyhCompany;
import com.zyh.entity.company.ZyhCompanyExample;
import com.zyh.service.company.ICompanyService;

@Service("companyService")
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private ZyhCompanyMapper zyhCompanyMapper;

	@Override
	public void addCompany(ZyhCompany zyhCompany) throws Exception {
		if (null == zyhCompany.getId() || "".equals(zyhCompany.getId())) {
			String id = UUidUtil.getUUid();
			zyhCompany.setId(id);
		}
		zyhCompanyMapper.insertSelective(zyhCompany);
	}

	@Override
	public void updateCompanyById(ZyhCompany zyhCompany) throws Exception {
		zyhCompanyMapper.updateByPrimaryKeySelective(zyhCompany);
	}

	@Override
	public void updateCompanyByExam(ZyhCompany zyhCompany, ZyhCompanyExample zyhCompanyExample) throws Exception {
		zyhCompanyMapper.updateByExampleSelective(zyhCompany, zyhCompanyExample);

	}

	@Override
	public List<ZyhCompany> selectCompanyByExample(ZyhCompanyExample zyhCompanyExample) throws Exception {
		return zyhCompanyMapper.selectByExample(zyhCompanyExample);
	}

	@Override
	public void delCompanyById(String id) throws Exception {
		zyhCompanyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delCompanyByExample(ZyhCompanyExample zyhCompanyExample) throws Exception {
		zyhCompanyMapper.deleteByExample(zyhCompanyExample);
	}

	@Override
	public Map<String, Object> selectCompanyByExamPage(ZyhCompanyExample zyhCompanyExample, int pageNum, int pageSize)
			throws Exception {
		Map<String, Object> map = new HashMap<>();
		List<ZyhCompany> list = zyhCompanyMapper.selectCompanyByPage(zyhCompanyExample, pageNum, pageSize);
		map.put("result", list);
		Page page =new Page();
		page.setPageNum(pageNum);
		page.setTotalRowCount(zyhCompanyMapper.countByExample(zyhCompanyExample));
		map.put("pageResult", page);
		return map;
	}

}

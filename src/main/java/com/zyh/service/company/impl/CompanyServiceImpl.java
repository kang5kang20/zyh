package com.zyh.service.company.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.zyh.controller.company.vo.FirstQueryVO;
import com.zyh.controller.user.common.UserCom;
import com.zyh.dao.company.ZyhCompanyMapper;
import com.zyh.dao.company.cus.ZyhCompanyPositionCusMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.common.Page;
import com.zyh.entity.company.ZyhCompany;
import com.zyh.entity.company.ZyhCompanyExample;
import com.zyh.service.company.ICompanyService;

@Service("companyService")
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private ZyhCompanyMapper zyhCompanyMapper;
	
	@Autowired
	private ZyhCompanyPositionCusMapper zyhCompanyPositionCusMapper;

	@Override
	public void addCompany(ZyhCompany zyhCompany) throws Exception {
		if (null == zyhCompany.getId() || "".equals(zyhCompany.getId())) {
			String id = UUidUtil.getUUid();
			zyhCompany.setId(id);
		}
		try {
			zyhCompanyMapper.insertSelective(zyhCompany);
		}catch (DuplicateKeyException e) {
			if (e.getMessage().indexOf("name") > 0) {
				throw new Exception(UserCom.ERROR_NAMEEXIST);
			} else{
				throw new Exception(e);
			}
		}catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public void updateCompanyById(ZyhCompany zyhCompany) throws Exception {
		try {
			zyhCompanyMapper.updateByPrimaryKeySelective(zyhCompany);
		} catch (DuplicateKeyException e) {
			if (e.getMessage().indexOf("name") > 0) {
				throw new Exception(UserCom.ERROR_NAMEEXIST);
			}else{
				throw new Exception(e);
			}
		}catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public void updateCompanyByExam(ZyhCompany zyhCompany, ZyhCompanyExample zyhCompanyExample) throws Exception {
		try {
			zyhCompanyMapper.updateByExampleSelective(zyhCompany, zyhCompanyExample);
		} catch (DuplicateKeyException e) {
			if (e.getMessage().indexOf("name") > 0) {
				throw new Exception(UserCom.ERROR_NAMEEXIST);
			}else{
				throw new Exception(e);
			}
		}catch (Exception e) {
			throw new Exception(e);
		}
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
	
	@Override
	public ZyhCompany selectByPrimaryKey(String id) throws Exception{
		return zyhCompanyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<FirstQueryVO> selectFirstQuery(String content) throws Exception {
		content = "%"+content+"%";
		List<FirstQueryVO> list = new ArrayList<>();
		List<FirstQueryVO> companyList = new ArrayList<>();
		companyList = zyhCompanyPositionCusMapper.getCompanyByFirstPage(content);
		List<FirstQueryVO> companyPList = new ArrayList<>();
		companyPList = zyhCompanyPositionCusMapper.getCompanyPositionByFirstPage(content);
		List<FirstQueryVO> companyTList = new ArrayList<>();
		companyTList = zyhCompanyPositionCusMapper.getCompanyTrainByFirstPage(content);
		if (null!=companyList&&companyList.size()>0) {
			for (int i = 0; i < companyList.size(); i++) {
				FirstQueryVO firstQueryVO = companyList.get(i);
				firstQueryVO.setType("0");
				if (null!=firstQueryVO.getLabel()&&!"".equals(firstQueryVO.getLabel())) {
					firstQueryVO.setType("3");
				}else if(null!=firstQueryVO.getTrainlabel()&&!"".equals(firstQueryVO.getTrainlabel())){
					firstQueryVO.setType("4");
				}
				list.add(firstQueryVO);
			}
		}
		if(null!=companyPList&&companyPList.size()>0){
			for (int i = 0; i < companyPList.size(); i++) {
				FirstQueryVO firstQueryVO = companyPList.get(i);
				firstQueryVO.setType("1");
				list.add(firstQueryVO);
			}
		}
		if(null!=companyTList&&companyTList.size()>0){
			for (int i = 0; i < companyTList.size(); i++) {
				FirstQueryVO firstQueryVO = companyTList.get(i);
				firstQueryVO.setType("2");
				list.add(firstQueryVO);
			}
		}
		return list;
	}

	
}

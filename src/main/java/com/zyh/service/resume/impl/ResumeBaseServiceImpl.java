package com.zyh.service.resume.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.resume.ZyhResumeBaseMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.resume.ZyhResumeBase;
import com.zyh.entity.resume.ZyhResumeBaseExample;
import com.zyh.service.resume.IResumeBaseService;

@Service("resumeBaseService")
public class ResumeBaseServiceImpl implements IResumeBaseService{
	
	@Autowired
	private ZyhResumeBaseMapper zyhResumeBaseMapper;

	@Override
	public void addResumeBase(ZyhResumeBase zyhResumeBase) throws Exception {
		if (null ==zyhResumeBase.getId()||"".equals(zyhResumeBase.getId())) {
			String id = UUidUtil.getUUid();
			zyhResumeBase.setId(id);
		}
		zyhResumeBaseMapper.insertSelective(zyhResumeBase);
	}

	@Override
	public void updateResumeBaseById(ZyhResumeBase zyhResumeBase) throws Exception {
		zyhResumeBaseMapper.updateByPrimaryKeySelective(zyhResumeBase);
	}

	@Override
	public void updateResumeBaseByExam(ZyhResumeBase zyhResumeBase, ZyhResumeBaseExample zyhResumeBaseExample)
			throws Exception {
		zyhResumeBaseMapper.updateByExampleSelective(zyhResumeBase, zyhResumeBaseExample);
	}

	@Override
	public List<ZyhResumeBase> selectResumeBaseByExample(ZyhResumeBaseExample zyhResumeBaseExample) throws Exception {
		return zyhResumeBaseMapper.selectByExample(zyhResumeBaseExample);
	}

	@Override
	public void delResumeBaseById(String id) throws Exception {
		zyhResumeBaseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delResumeBaseByExample(ZyhResumeBaseExample zyhResumeBaseExample) throws Exception {
		zyhResumeBaseMapper.deleteByExample(zyhResumeBaseExample);
	}
	
	
}

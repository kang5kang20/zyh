package com.zyh.service.resume.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.resume.ZyhResumeWorkMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.resume.ZyhResumeWork;
import com.zyh.entity.resume.ZyhResumeWorkExample;
import com.zyh.service.resume.IResumeWorkService;

@Service("resumeWorkServicel")
public class ResumeWorkServiceImpl implements IResumeWorkService{

	@Autowired
	private ZyhResumeWorkMapper zyhResumeWorkMapper;
	
	@Override
	public void addResumeWork(ZyhResumeWork zyhResumeWork) throws Exception {
		if (null ==zyhResumeWork.getId()||"".equals(zyhResumeWork.getId())) {
			String id = UUidUtil.getUUid();
			zyhResumeWork.setId(id);
		}
		zyhResumeWorkMapper.insertSelective(zyhResumeWork);
	}

	@Override
	public void updateResumeWorkById(ZyhResumeWork zyhResumeWork) throws Exception {
		zyhResumeWorkMapper.updateByPrimaryKeySelective(zyhResumeWork);
	}

	@Override
	public void updateResumeWorkByExam(ZyhResumeWork zyhResumeWork, ZyhResumeWorkExample zyhResumeWorkExample)
			throws Exception {
		zyhResumeWorkMapper.updateByExampleSelective(zyhResumeWork, zyhResumeWorkExample);
	}

	@Override
	public List<ZyhResumeWork> selectResumeWorkByExample(ZyhResumeWorkExample zyhResumeWorkExample) throws Exception {
		return zyhResumeWorkMapper.selectByExample(zyhResumeWorkExample);
	}

	@Override
	public void delResumeWorkById(String id) throws Exception {
		zyhResumeWorkMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delResumeWorkByExample(ZyhResumeWorkExample zyhResumeWorkExample) throws Exception {
		zyhResumeWorkMapper.deleteByExample(zyhResumeWorkExample);
	}

}

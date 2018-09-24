package com.zyh.service.resume.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.resume.ZyhResumeEducationMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.resume.ZyhResumeEducation;
import com.zyh.entity.resume.ZyhResumeEducationExample;
import com.zyh.service.resume.IResumeEducationService;

@Service("resumeEducationService")
public class ResumeEducationServiceImpl implements IResumeEducationService{

	@Autowired
	private ZyhResumeEducationMapper zyhResumeEducationMapper;
	
	@Override
	public void addResumeEducation(ZyhResumeEducation zyhResumeEducation) throws Exception {
		if (null ==zyhResumeEducation.getId()||"".equals(zyhResumeEducation.getId())) {
			String id = UUidUtil.getUUid();
			zyhResumeEducation.setId(id);
		}
		zyhResumeEducationMapper.insertSelective(zyhResumeEducation);
	}

	@Override
	public void updateResumeEducationById(ZyhResumeEducation zyhResumeEducation) throws Exception {
		zyhResumeEducationMapper.updateByPrimaryKeySelective(zyhResumeEducation);
	}

	@Override
	public void updateResumeEducationByExam(ZyhResumeEducation zyhResumeEducation,
			ZyhResumeEducationExample zyhResumeEducationExample) throws Exception {
		zyhResumeEducationMapper.updateByExampleSelective(zyhResumeEducation, zyhResumeEducationExample);
	}

	@Override
	public List<ZyhResumeEducation> selectResumeEducationByExample(ZyhResumeEducationExample zyhResumeEducationExample)
			throws Exception {
		return zyhResumeEducationMapper.selectByExample(zyhResumeEducationExample);
	}

	@Override
	public void delResumeEducationById(String id) throws Exception {
		zyhResumeEducationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delResumeEducationByExample(ZyhResumeEducationExample zyhResumeEducationExample) throws Exception {
		zyhResumeEducationMapper.deleteByExample(zyhResumeEducationExample);
	}
	
	
}

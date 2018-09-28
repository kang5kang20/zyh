package com.zyh.service.resume.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.resume.ZyhResumeIntentionMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.resume.ZyhResumeIntention;
import com.zyh.entity.resume.ZyhResumeIntentionExample;
import com.zyh.service.resume.IResumeIntentionService;

@Service("resumeIntentionService")
public class ResumeIntentionServiceImpl implements IResumeIntentionService{

	@Autowired
	private ZyhResumeIntentionMapper zyhResumeIntentionMapper;
	
	@Override
	public void addResumeIntention(ZyhResumeIntention zyhResumeIntention) throws Exception {
		if (null ==zyhResumeIntention.getId()||"".equals(zyhResumeIntention.getId())) {
			String id = UUidUtil.getUUid();
			zyhResumeIntention.setId(id);
		}
		zyhResumeIntentionMapper.insertSelective(zyhResumeIntention);
	}

	@Override
	public void updateResumeIntentionById(ZyhResumeIntention zyhResumeEducation) throws Exception {
		zyhResumeIntentionMapper.updateByPrimaryKeySelective(zyhResumeEducation);
	}

	@Override
	public void updateResumeIntentionByExam(ZyhResumeIntention zyhResumeEducation,
			ZyhResumeIntentionExample zyhResumeIntentionExample) throws Exception {
		zyhResumeIntentionMapper.updateByExampleSelective(zyhResumeEducation, zyhResumeIntentionExample);
	}

	@Override
	public List<ZyhResumeIntention> selectResumeIntentionByExample(ZyhResumeIntentionExample zyhResumeIntentionExample)
			throws Exception {
		return zyhResumeIntentionMapper.selectByExample(zyhResumeIntentionExample);
	}

	@Override
	public void delResumeIntentionById(String id) throws Exception {
		zyhResumeIntentionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delResumeIntentionByExample(ZyhResumeIntentionExample zyhResumeIntentionExample) throws Exception {
		zyhResumeIntentionMapper.deleteByExample(zyhResumeIntentionExample);
	}
	
	
}

package com.zyh.service.resume.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zyh.dao.resume.ZyhResumeSpecialityMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.resume.ZyhResumeSpeciality;
import com.zyh.entity.resume.ZyhResumeSpecialityExample;
import com.zyh.service.resume.IResumeSpecialityService;

public class ResumeSpecialityServiceImpl implements IResumeSpecialityService {

	@Autowired
	private ZyhResumeSpecialityMapper zyhResumeSpecialityMapper;

	@Override
	public void addResumeSpeciality(ZyhResumeSpeciality zyhResumeSpeciality) throws Exception {
		if (null == zyhResumeSpeciality.getId() || "".equals(zyhResumeSpeciality.getId())) {
			String id = UUidUtil.getUUid();
			zyhResumeSpeciality.setId(id);
		}
		zyhResumeSpecialityMapper.insertSelective(zyhResumeSpeciality);
	}

	@Override
	public void updateResumeSpecialityById(ZyhResumeSpeciality zyhResumeSpeciality) throws Exception {
		zyhResumeSpecialityMapper.updateByPrimaryKeySelective(zyhResumeSpeciality);

	}

	@Override
	public void updateResumeSpecialityByExam(ZyhResumeSpeciality zyhResumeSpeciality,
			ZyhResumeSpecialityExample zyhResumeSpecialityExample) throws Exception {
		zyhResumeSpecialityMapper.updateByExampleSelective(zyhResumeSpeciality, zyhResumeSpecialityExample);
	}

	@Override
	public List<ZyhResumeSpeciality> selectResumeSpecialityByExample(ZyhResumeSpecialityExample zyhResumeSpecialityExample)
			throws Exception {
		return zyhResumeSpecialityMapper.selectByExample(zyhResumeSpecialityExample);
	}

	@Override
	public void delResumeSpecialityById(String id) throws Exception {
		zyhResumeSpecialityMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delResumeSpecialityByExample(ZyhResumeSpecialityExample zyhResumeSpecialityExample) throws Exception {
		zyhResumeSpecialityMapper.deleteByExample(zyhResumeSpecialityExample);
	}

}
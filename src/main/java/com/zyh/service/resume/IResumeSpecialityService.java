package com.zyh.service.resume;

import java.util.List;

import com.zyh.entity.resume.ZyhResumeSpeciality;
import com.zyh.entity.resume.ZyhResumeSpecialityExample;


public interface IResumeSpecialityService {
	
	public void addResumeSpeciality(ZyhResumeSpeciality zyhResumeSpeciality) throws Exception;

	public void updateResumeSpecialityById(ZyhResumeSpeciality zyhResumeSpeciality) throws Exception;

	public void updateResumeSpecialityByExam(ZyhResumeSpeciality zyhResumeSpeciality, ZyhResumeSpecialityExample zyhResumeSpecialityExample)
			throws Exception;

	public List<ZyhResumeSpeciality> selectResumeSpecialityByExample(ZyhResumeSpecialityExample zyhResumeSpecialityExample) throws Exception;

	public void delResumeSpecialityById(String id) throws Exception;

	public void delResumeSpecialityByExample(ZyhResumeSpecialityExample zyhResumeSpecialityExample) throws Exception;
}

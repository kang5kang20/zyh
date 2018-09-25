package com.zyh.service.resume;

import java.util.List;

import com.zyh.entity.resume.ZyhResumeEducation;
import com.zyh.entity.resume.ZyhResumeEducationExample;


public interface IResumeEducationService {
	
	public void addResumeEducation(ZyhResumeEducation zyhResumeEducation) throws Exception;

	public void updateResumeEducationById(ZyhResumeEducation zyhResumeEducation) throws Exception;

	public void updateResumeEducationByExam(ZyhResumeEducation zyhResumeEducation, ZyhResumeEducationExample zyhResumeEducationExample)
			throws Exception;

	public List<ZyhResumeEducation> selectResumeEducationByExample(ZyhResumeEducationExample zyhResumeEducationExample) throws Exception;

	public void delResumeEducationById(String id) throws Exception;

	public void delResumeEducationByExample(ZyhResumeEducationExample zyhResumeEducationExample) throws Exception;
}

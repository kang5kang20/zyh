package com.zyh.service.resume;

import java.util.List;

import com.zyh.entity.resume.ZyhResumeIntention;
import com.zyh.entity.resume.ZyhResumeIntentionExample;


public interface IResumeIntentionService {
	
	public void addResumeIntention(ZyhResumeIntention zyhResumeIntention) throws Exception;

	public void updateResumeIntentionById(ZyhResumeIntention zyhResumeEducation) throws Exception;

	public void updateResumeIntentionByExam(ZyhResumeIntention zyhResumeEducation, ZyhResumeIntentionExample zyhResumeIntentionExample)
			throws Exception;

	public List<ZyhResumeIntention> selectResumeIntentionByExample(ZyhResumeIntentionExample zyhResumeIntentionExample) throws Exception;

	public void delResumeIntentionById(String id) throws Exception;

	public void delResumeIntentionByExample(ZyhResumeIntentionExample zyhResumeIntentionExample) throws Exception;
}

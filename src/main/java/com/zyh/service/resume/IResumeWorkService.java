package com.zyh.service.resume;

import java.util.List;

import com.zyh.entity.resume.ZyhResumeWork;
import com.zyh.entity.resume.ZyhResumeWorkExample;

public interface IResumeWorkService {
	
	public void addResumeWork(ZyhResumeWork zyhResumeWork) throws Exception;

	public void updateResumeWorkById(ZyhResumeWork zyhResumeWork) throws Exception;

	public void updateResumeWorkByExam(ZyhResumeWork zyhResumeWork, ZyhResumeWorkExample zyhResumeWorkExample)
			throws Exception;

	public List<ZyhResumeWork> selectResumeWorkByExample(ZyhResumeWorkExample zyhResumeWorkExample) throws Exception;

	public void delResumeWorkById(String id) throws Exception;

	public void delResumeWorkByExample(ZyhResumeWorkExample zyhResumeWorkExample) throws Exception;
}

package com.zyh.service.resume;

import java.util.List;
import java.util.Map;

import com.zyh.entity.resume.ZyhResumeBase;
import com.zyh.entity.resume.ZyhResumeBaseExample;

public interface IResumeBaseService {

	public void addResumeBase(ZyhResumeBase zyhResumeBase) throws Exception;

	public void updateResumeBaseById(ZyhResumeBase zyhResumeBase) throws Exception;

	public void updateResumeBaseByExam(ZyhResumeBase zyhResumeBase, ZyhResumeBaseExample zyhResumeBaseExample)
			throws Exception;

	public List<ZyhResumeBase> selectResumeBaseByExample(ZyhResumeBaseExample zyhResumeBaseExample) throws Exception;

	public void delResumeBaseById(String id) throws Exception;

	public void delResumeBaseByExample(ZyhResumeBaseExample zyhResumeBaseExample) throws Exception;
	
	public Map<String, Object> findResumeBaseByPage(ZyhResumeBaseExample zyhResumeBaseExample,int pageNum,int pageSize) throws Exception;
}

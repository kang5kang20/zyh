package com.zyh.service.consult;

import java.util.List;
import java.util.Map;

import com.zyh.entity.consult.ZyhConsult;
import com.zyh.entity.consult.ZyhConsultExample;

public interface IConsultService {

	public void addConsult(ZyhConsult zyhConsult) throws Exception;
	
	public void updateConsult(ZyhConsult zyhConsult) throws Exception;
	
	public void deleteConsult(String consultid) throws Exception;
	
	public ZyhConsult queryConsultById(String consultid) throws Exception;
	
	public List<ZyhConsult> findConsultList(ZyhConsultExample example) throws Exception;
	
	
	public Map findConsultListByPage(ZyhConsultExample example,
			int pageNum, int pageSize) throws Exception;
	
}

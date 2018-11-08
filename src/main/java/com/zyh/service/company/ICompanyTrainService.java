package com.zyh.service.company;

import java.util.List;
import java.util.Map;

import com.zyh.entity.company.ZyhCompanyTrain;
import com.zyh.entity.company.ZyhCompanyTrainExample;

public interface ICompanyTrainService {

	public void addCompanyTrain(ZyhCompanyTrain zyhCompanyTrain) throws Exception;

	public void updateCompanyTrainByExam(ZyhCompanyTrain zyhCompanyTrain, ZyhCompanyTrainExample zyhCompanyTrainExample)
			throws Exception;

	public List<ZyhCompanyTrain> selectCompanyTrainByExample(ZyhCompanyTrainExample zyhCompanyTrainExample) throws Exception;

	public void delCompanyTrainById(String id) throws Exception;
	
	public void updateCompanyTrainById(ZyhCompanyTrain zyhCompanyTrain)throws Exception;

	public void delCompanyTrainByExample(ZyhCompanyTrainExample zyhCompanyTrainExample) throws Exception;
	
	public Map<String, Object> selectCompanyTrainByPage(ZyhCompanyTrainExample zyhCompanyTrainExample,int pageNum,int pageSize)throws Exception;
	
	public long countByExam(ZyhCompanyTrainExample zyhCompanyTrainExample)throws Exception;
	
	public ZyhCompanyTrain selectCompanyTrainById(String id)throws Exception;
}

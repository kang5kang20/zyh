package com.zyh.service.company;

import java.util.List;

import com.zyh.entity.company.ZyhCompany;
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
}
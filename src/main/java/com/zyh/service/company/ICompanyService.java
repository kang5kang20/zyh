package com.zyh.service.company;

import java.util.List;

import com.zyh.entity.company.ZyhCompany;
import com.zyh.entity.company.ZyhCompanyExample;

public interface ICompanyService {
	
	public void addCompany(ZyhCompany zyhCompany)throws Exception;
	
	public void updateCompanyById(ZyhCompany zyhCompany)throws Exception;
	
	public void updateCompanyByExam(ZyhCompany zyhCompany,ZyhCompanyExample zyhCompanyExample)throws Exception;
	
	public List<ZyhCompany> selectCompanyByExample(ZyhCompanyExample zyhCompanyExample)throws Exception;
	
	public void delCompanyById(String id)throws Exception;
	
	public void delCompanyByExample(ZyhCompanyExample zyhCompanyExample)throws Exception;
}

package com.zyh.service.policy;

import java.util.List;
import java.util.Map;

import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.policy.ZyhPolicyExample;

public interface IPolicyService {
	
	public ZyhPolicy queryPolicyById(String policyid) throws Exception;
	
	public List<ZyhPolicy> findPolicyList(ZyhPolicyExample example) throws Exception;
	
	public void addPolicy(ZyhPolicy policy) throws Exception;
	
	public void updatePolicy(ZyhPolicy policy) throws Exception;
	
	public void deletePolicy(String policyid) throws Exception;
	
	public Map findPolicyListByPage(ZyhPolicyExample example,
			int pageNum, int pageSize) throws Exception;
	
	public ZyhPolicy queryPolicyForSave(String policyid) throws Exception;
}

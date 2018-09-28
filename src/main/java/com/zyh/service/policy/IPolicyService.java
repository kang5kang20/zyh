package com.zyh.service.policy;

import java.util.List;

import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.policy.ZyhPolicyExample;

public interface IPolicyService {
	
	public ZyhPolicy queryPolicyById(String policyid) throws Exception;
	
	public List<ZyhPolicy> findPolicyList(ZyhPolicyExample example) throws Exception;
	
	public void addPolicy(ZyhPolicy policy) throws Exception;
	
	public void updatePolicy(ZyhPolicy policy) throws Exception;
	
	public void deletePolicy(String policyid) throws Exception;
}

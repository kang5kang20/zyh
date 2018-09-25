package com.zyh.service.policy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.policy.ZyhPolicyMapper;
import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.policy.ZyhPolicyExample;
import com.zyh.service.policy.IPolicyService;

@Service("policyService")
public class PolicyServiceImpl implements IPolicyService {
	@Autowired
	private ZyhPolicyMapper zyhPolicyMapper;


	@Override
	public ZyhPolicy findPolicyById(String policyid) throws Exception {
		//增加阅读次数
		ZyhPolicy policy = zyhPolicyMapper.selectByPrimaryKey(policyid);
		policy.setReadcount(policy.getReadcount()+1);
		zyhPolicyMapper.updateByPrimaryKeySelective(policy);
		return policy;
	}

	@Override
	public List<ZyhPolicy> findPolicyList(ZyhPolicyExample example)
			throws Exception {
		return zyhPolicyMapper.selectByExample(example);
	}

	@Override
	public void addPolicy(ZyhPolicy policy) throws Exception {
		zyhPolicyMapper.insertSelective(policy);
		
	}

	@Override
	public void updatePolicy(ZyhPolicy policy) throws Exception {
		zyhPolicyMapper.updateByPrimaryKeySelective(policy);
		
	}

	@Override
	public void deletePolicy(String policyid) throws Exception {
		zyhPolicyMapper.deleteByPrimaryKey(policyid);
	}
	
}

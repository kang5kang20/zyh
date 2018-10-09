package com.zyh.service.policy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.controller.policy.vo.PolicyQueryVO;
import com.zyh.dao.policy.ZyhPolicyMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.policy.ZyhPolicyExample;
import com.zyh.service.policy.IPolicyService;

@Service("policyService")
public class PolicyServiceImpl implements IPolicyService {
	@Autowired
	private ZyhPolicyMapper zyhPolicyMapper;


	@Override
	public ZyhPolicy queryPolicyById(String policyid) throws Exception {
		//增加阅读次数
		ZyhPolicy policy = zyhPolicyMapper.selectByPrimaryKey(policyid);
		if(null == policy || "0".equals(policy.getIfground())){
			return null;
		}
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
		if (null ==policy.getId()||"".equals(policy.getId())) {
			String id = UUidUtil.getUUid();
			policy.setId(id);
		}
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

	@Override
	public List<ZyhPolicy> findPolicyListByPage(ZyhPolicyExample example,
			int pageNum, int pageSize) throws Exception {
		return zyhPolicyMapper.selectByPageNumSize(example, pageNum, pageSize);
	}

	@Override
	public ZyhPolicy queryPolicyForSave(String policyid) throws Exception {
		return zyhPolicyMapper.selectByPrimaryKey(policyid);
	}
	
}

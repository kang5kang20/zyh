package com.zyh.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.user.ZyhUserMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;
import com.zyh.entity.user.ZyhUserExample.Criteria;
import com.zyh.service.user.ILoginService;

@Service("loginService")
public class LoginServiceImpl implements ILoginService{

	@Autowired
	ZyhUserMapper zyhUserMapper;
	
	@Override
	public ZyhUser loginAndRegister(ZyhUser zyhUser) throws Exception {
		String type = zyhUser.getType();
		ZyhUserExample zyhUserExample = new ZyhUserExample();
		Criteria criteria = zyhUserExample.createCriteria();
		
		if ("wx".equals(type)) {
			String openid = zyhUser.getOpenid();
			if (null!=openid&&!"".equals(openid)) {
				criteria.andOpenidEqualTo(openid);
			}
		}else if ("dx".equals(type)) {
			String phone = zyhUser.getPhone();
			criteria.andPhoneEqualTo(phone);
		}
		List<ZyhUser> list = zyhUserMapper.selectByExample(zyhUserExample);
		if (null!=list&&list.size()>0) {
			//查询有记录进行关联
			ZyhUser returnUser = new ZyhUser();
			returnUser = list.get(0);
			returnUser.setPassword(null);
			return returnUser;
		}else{
			//查询无记录进行注册
			if (null == zyhUser.getId()||"".equals(zyhUser.getId())) {
				String id = UUidUtil.getUUid();
				zyhUser.setId(id);
			}
			zyhUserMapper.insertSelective(zyhUser);
			zyhUser.setPassword(null);
			return zyhUser;
		}
	}

	@Override
	public ZyhUser loginByMM(ZyhUser zyhUser) throws Exception {
		String phone = zyhUser.getPhone();
		String psword = zyhUser.getPassword();
		if (null==phone||"".equals(phone)) {
			throw new Exception("用户手机号为空");
		}
		if (null==psword||"".equals(psword)) {
			throw new Exception("用户密码为空");
		}
		ZyhUserExample zyhUserExample = new ZyhUserExample();
		Criteria criteria = zyhUserExample.createCriteria();
		criteria.andPasswordEqualTo(psword);
		criteria.andPhoneEqualTo(phone);
		List<ZyhUser> list = zyhUserMapper.selectByExample(zyhUserExample);
		if (null!=list&&list.size()>0) {
			zyhUser = list.get(0);
			zyhUser.setPassword(null);
		}else{
			throw new Exception("errorPassWordOrPhone");
		}
		return zyhUser;
	}
	
	
}

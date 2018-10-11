package com.zyh.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.user.ZyhUserMapper;
import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;
import com.zyh.service.user.IUserService;
import com.zyh.utils.MD5Util;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	ZyhUserMapper zyhUserMapper;

	public void addUser(ZyhUser user) throws Exception {
		if (null!=user.getPassword()&&"".equals(user.getPassword())) {
			String psMd5 = MD5Util.EncoderByMd5(user.getPassword());
			user.setPassword(psMd5);
		}
		zyhUserMapper.insertSelective(user);
	}

	@Override
	public void updateUser(ZyhUser user,ZyhUserExample zyhUserExample) throws Exception {
		zyhUserMapper.updateByExampleSelective(user, zyhUserExample);
	}

	@Override
	public List<ZyhUser> findUser(ZyhUserExample zyhUserExample) throws Exception {
		return zyhUserMapper.selectByExample(zyhUserExample);
	}
	
	
}

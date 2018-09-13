package com.zyh.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.user.ZyhUserMapper;
import com.zyh.entity.user.ZyhUser;
import com.zyh.service.user.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	ZyhUserMapper zyhUserMapper;

	public void addUser(ZyhUser user) throws Exception {
		zyhUserMapper.insert(user);
	}

}

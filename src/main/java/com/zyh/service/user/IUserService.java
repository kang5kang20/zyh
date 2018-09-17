package com.zyh.service.user;

import java.util.List;

import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;

public interface IUserService {
	
	public void addUser(ZyhUser user)throws Exception;

	public void updateUser(ZyhUser user,ZyhUserExample zyhUserExample)throws Exception;
	
	public List<ZyhUser> findUser(ZyhUserExample zyhUserExample)throws Exception;
}

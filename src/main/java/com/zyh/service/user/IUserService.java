package com.zyh.service.user;

import java.util.List;
import java.util.Map;

import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;

public interface IUserService {
	
	public void addUser(ZyhUser user)throws Exception;

	public void updateUser(ZyhUser user,ZyhUserExample zyhUserExample)throws Exception;
	
	public List<ZyhUser> findUser(ZyhUserExample zyhUserExample)throws Exception;
	
	public Map<String, Object> findUserByPage(ZyhUserExample zyhUserExample,int pageNum,int pageSize)throws Exception;
	
	public boolean checkUserBySMS(ZyhUser zyhUser)throws Exception;
}

package com.zyh.service.user;

import java.util.List;

import com.zyh.entity.user.ZyhUserPosition;
import com.zyh.entity.user.ZyhUserPositionExample;

public interface IUserPostService {
	
	public void addUserPost(ZyhUserPosition zyhUserPosition)throws Exception;
	
	public void delUserPostById(String id)throws Exception;
	
	public List<ZyhUserPosition> queryPostByExm(ZyhUserPositionExample zyhUserPositionExample)throws Exception;
}

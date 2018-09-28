package com.zyh.service.usercollect;

import java.util.List;

import com.zyh.entity.usercollect.ZyhUserCollect;
import com.zyh.entity.usercollect.ZyhUserCollectExample;

public interface IUserCollectService {
	/**
	 * 收藏
	 */
	public void addUserCollect(ZyhUserCollect usercollect) throws Exception;
	

	/**
	 * 取消收藏
	 */
	public void deleteUserCollect(String usercollectid) throws Exception;
	
	public List<ZyhUserCollect> findUserCollectList(ZyhUserCollectExample example) throws Exception;
}

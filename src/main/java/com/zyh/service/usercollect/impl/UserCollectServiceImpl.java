package com.zyh.service.usercollect.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.usercollect.ZyhUserCollectMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.usercollect.ZyhUserCollect;
import com.zyh.entity.usercollect.ZyhUserCollectExample;
import com.zyh.service.usercollect.IUserCollectService;

@Service("userCollectService")
public class UserCollectServiceImpl implements IUserCollectService {
	
	@Autowired
	private ZyhUserCollectMapper zyhUserCollectMapper;
	
	/**
	 * 收藏
	 */
	@Override
	public void addUserCollect(ZyhUserCollect usercollect) throws Exception {
		if (null ==usercollect.getId()||"".equals(usercollect.getId())) {
			String id = UUidUtil.getUUid();
			usercollect.setId(id);
		}
		zyhUserCollectMapper.insertSelective(usercollect);
	}
	
	/**
	 * 取消收藏
	 */
	@Override
	public void deleteUserCollect(String usercollectid) throws Exception {
		zyhUserCollectMapper.deleteByPrimaryKey(usercollectid);
	}
	
	
	@Override
	public List<ZyhUserCollect> findUserCollectList(ZyhUserCollectExample example) throws Exception {
		return zyhUserCollectMapper.selectByExample(example);
	}
	
}	

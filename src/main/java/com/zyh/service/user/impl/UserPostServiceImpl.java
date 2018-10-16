package com.zyh.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.controller.user.common.UserCom;
import com.zyh.dao.user.ZyhUserPositionMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.user.ZyhUserPosition;
import com.zyh.entity.user.ZyhUserPositionExample;
import com.zyh.entity.user.ZyhUserPositionExample.Criteria;
import com.zyh.service.user.IUserPostService;

@Service("userPostService")
public class UserPostServiceImpl implements IUserPostService{

	@Autowired
	private ZyhUserPositionMapper zyhUserPositionMapper;
	
	@Override
	public void addUserPost(ZyhUserPosition zyhUserPosition) throws Exception {
		//避免重复投递
		ZyhUserPositionExample zyhUserPositionExample = new ZyhUserPositionExample();
		Criteria criteria = zyhUserPositionExample.createCriteria();
		criteria.andPosttypeEqualTo(zyhUserPosition.getPosttype());
		criteria.andUseridEqualTo(zyhUserPosition.getUserid());
		criteria.andPositionidEqualTo(zyhUserPosition.getPositionid());
		List<ZyhUserPosition> list = zyhUserPositionMapper.selectByExample(zyhUserPositionExample);
		if (null!=list&&list.size()>0) {
			throw new Exception(UserCom.ERROR_POSITIONED);
		}
		if (null==zyhUserPosition.getId()||"".equals(zyhUserPosition.getId())) {
			zyhUserPosition.setId(UUidUtil.getUUid());
		}
		zyhUserPositionMapper.insertSelective(zyhUserPosition);
	}

	@Override
	public void delUserPostById(String id) throws Exception {
		zyhUserPositionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ZyhUserPosition> queryPostByExm(ZyhUserPositionExample zyhUserPositionExample) throws Exception {
		return zyhUserPositionMapper.selectByExample(zyhUserPositionExample);
	}
	
	
}

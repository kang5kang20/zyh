package com.zyh.service.bulletin.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.bulletin.ZyhBulletinMapper;
import com.zyh.dao.bulletin.cus.ZyhBulletinCusMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.bulletin.ZyhBulletin;
import com.zyh.entity.bulletin.ZyhBulletinExample;
import com.zyh.entity.common.Page;
import com.zyh.service.bulletin.IBulletinService;

@Service("bulletinService")
public class BulletinServiceImpl implements IBulletinService {
	
	@Autowired
	private ZyhBulletinMapper zyhBulletinMapper;
	@Autowired
	private ZyhBulletinCusMapper zyhBulletinCusMapper;

	@Override
	public void addBulletin(ZyhBulletin zyhBulletin) throws Exception {
		if (null ==zyhBulletin.getId()||"".equals(zyhBulletin.getId())) {
			String id = UUidUtil.getUUid();
			zyhBulletin.setId(id);
		}
		zyhBulletinMapper.insertSelective(zyhBulletin);
	}

	@Override
	public void updateBulletin(ZyhBulletin zyhBulletin) throws Exception {
		zyhBulletinMapper.updateByPrimaryKeySelective(zyhBulletin);
	}

	@Override
	public void deleteBulletin(String bulletinid) throws Exception {
		zyhBulletinMapper.deleteByPrimaryKey(bulletinid);
	}

	@Override
	public ZyhBulletin queryBulletinById(String bulletinid) throws Exception {
		//记录点击次数
		ZyhBulletin bulletin = zyhBulletinMapper.selectByPrimaryKey(bulletinid);
		if(null == bulletin || !bulletin.getIfsend()){
			return null;
		}
		bulletin.setReadcount(bulletin.getReadcount()+1);
		zyhBulletinMapper.updateByPrimaryKeySelective(bulletin);
		return bulletin;
	}

	@Override
	public List<ZyhBulletin> findBulletinList(ZyhBulletinExample example) throws Exception {
		return zyhBulletinMapper.selectByExample(example);
	}

	@Override
	public List<ZyhBulletin> findBulletinListToHome(ZyhBulletinExample example) throws Exception {
		return zyhBulletinMapper.selectByExample(example);
	}

	@Override
	public Map findBulletinListByPage(ZyhBulletinExample example,
			int pageNum, int pageSize) throws Exception {
		Map map = new HashMap();
		map.put("retlist", zyhBulletinCusMapper.selectByPageNumSize(example, pageNum, pageSize));
		Page page = new Page();
		page.setPageNum(pageNum);
		page.setTotalRowCount(zyhBulletinMapper.countByExample(example));
		map.put("page", page);
		return map;
	}

	@Override
	public ZyhBulletin queryBulletinForSave(String bulletinid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

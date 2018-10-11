package com.zyh.service.bulletin;

import java.util.List;
import java.util.Map;

import com.zyh.entity.bulletin.ZyhBulletin;
import com.zyh.entity.bulletin.ZyhBulletinExample;


public interface IBulletinService {
	
	public void addBulletin(ZyhBulletin zyhBulletin) throws Exception;
	
	public void updateBulletin(ZyhBulletin zyhBulletin) throws Exception;
	
	public void deleteBulletin(String bulletinid) throws Exception;
	
	public ZyhBulletin queryBulletinById(String bulletinid) throws Exception;
	
	public List<ZyhBulletin> findBulletinList(ZyhBulletinExample example) throws Exception;
	
	public List<ZyhBulletin> findBulletinListToHome(ZyhBulletinExample example) throws Exception;
	
	public Map findBulletinListByPage(ZyhBulletinExample example,
			int pageNum, int pageSize) throws Exception;
	
	public ZyhBulletin queryBulletinForSave(String bulletinid) throws Exception;
	
}

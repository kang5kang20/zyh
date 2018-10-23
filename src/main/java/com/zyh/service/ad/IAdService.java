package com.zyh.service.ad;

import java.util.List;
import java.util.Map;

import com.zyh.entity.ad.ZyhAd;
import com.zyh.entity.ad.ZyhAdExample;


public interface IAdService {
	public void addAd(ZyhAd zyhAd) throws Exception;
	
	public void updateAd(ZyhAd zyhAd) throws Exception;
	
	public void deleteAd(String adid) throws Exception;
	
	public ZyhAd queryAdById(String adid) throws Exception;
	
	public List<ZyhAd> findAdList(ZyhAdExample example) throws Exception;
	
	
	public Map findAdListByPage(ZyhAdExample example,
			int pageNum, int pageSize) throws Exception;
}

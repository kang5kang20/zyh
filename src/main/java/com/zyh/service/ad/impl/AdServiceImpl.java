package com.zyh.service.ad.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.ad.ZyhAdMapper;
import com.zyh.dao.ad.cus.ZyhAdCusMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.ad.ZyhAd;
import com.zyh.entity.ad.ZyhAdExample;
import com.zyh.entity.common.Page;
import com.zyh.service.ad.IAdService;

@Service("adService")
public class AdServiceImpl implements IAdService {
	@Autowired
	private ZyhAdMapper zyhAdMapper;
	@Autowired
	private ZyhAdCusMapper zyhAdCusMapper;

	@Override
	public void addAd(ZyhAd zyhAd) throws Exception {
		if (null ==zyhAd.getId()||"".equals(zyhAd.getId())) {
			String id = UUidUtil.getUUid();
			zyhAd.setId(id);
		}
		zyhAdMapper.insertSelective(zyhAd);
	}

	@Override
	public void updateAd(ZyhAd zyhAd) throws Exception {
		zyhAdMapper.updateByPrimaryKeySelective(zyhAd);
	}

	@Override
	public void deleteAd(String Adid) throws Exception {
		zyhAdMapper.deleteByPrimaryKey(Adid);
	}

	@Override
	public ZyhAd queryAdById(String Adid) throws Exception {
		//记录点击次数
		ZyhAd Ad = zyhAdMapper.selectByPrimaryKey(Adid);
		if(null == Ad || "0".equals(Ad.getIfground())){
			return null;
		}
		Ad.setReadcount(Ad.getReadcount()+1);
		zyhAdMapper.updateByPrimaryKeySelective(Ad);
		return Ad;
	}

	@Override
	public List<ZyhAd> findAdList(ZyhAdExample example) throws Exception {
		return zyhAdMapper.selectByExample(example);
	}


	@Override
	public Map findAdListByPage(ZyhAdExample example,
			int pageNum, int pageSize) throws Exception {
		Map map = new HashMap();
		map.put("retlist", zyhAdCusMapper.selectByPageNumSize(example, pageNum, pageSize));
		Page page = new Page();
		page.setPageNum(pageNum);
		page.setTotalRowCount(zyhAdMapper.countByExample(example));
		map.put("page", page);
		return map;
	}
}

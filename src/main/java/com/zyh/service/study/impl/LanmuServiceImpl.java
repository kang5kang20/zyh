package com.zyh.service.study.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.lanmu.ZyhLanmuMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.lanmu.ZyhLanmu;
import com.zyh.entity.lanmu.ZyhLanmuExample;
import com.zyh.service.study.ILanmuService;

@Service("lanmuService")
public class LanmuServiceImpl implements ILanmuService{
	
	@Autowired
	private ZyhLanmuMapper zyhLanmuMapper;

	@Override
	public void addLanmu(ZyhLanmu zyhLanmu) throws Exception {
		if (null ==zyhLanmu.getId()||"".equals(zyhLanmu.getId())) {
			String id = UUidUtil.getUUid();
			zyhLanmu.setId(id);
		}
		zyhLanmuMapper.insertSelective(zyhLanmu);
	}

	@Override
	public void updateLanmu(ZyhLanmu zyhLanmu) throws Exception {
		zyhLanmuMapper.updateByPrimaryKeySelective(zyhLanmu);
	}

	@Override
	public void deleteLanmu(String lanmuid) throws Exception {
		zyhLanmuMapper.deleteByPrimaryKey(lanmuid);
	}

	@Override
	public ZyhLanmu findLanmuById(String lanmuid) throws Exception {
		return zyhLanmuMapper.selectByPrimaryKey(lanmuid);
	}

	@Override
	public List<ZyhLanmu> findLanmuList(ZyhLanmuExample example)
			throws Exception {
		return zyhLanmuMapper.selectByExample(example);
	}

}

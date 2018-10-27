package com.zyh.service.area.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.common.AreasMapper;
import com.zyh.dao.common.CitiesMapper;
import com.zyh.dao.common.ProvincesMapper;
import com.zyh.entity.common.Areas;
import com.zyh.entity.common.AreasExample;
import com.zyh.entity.common.Cities;
import com.zyh.entity.common.CitiesExample;
import com.zyh.entity.common.Provinces;
import com.zyh.entity.common.ProvincesExample;
import com.zyh.service.area.IAreaService;

@Service("areaServiceImpl")
public class AreaServiceImpl implements IAreaService{

	@Autowired
	private CitiesMapper citiesMapper;
	
	@Autowired
	private ProvincesMapper provincesMapper; 
	
	@Override
	public Map<String, Object> findAreaByCity() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

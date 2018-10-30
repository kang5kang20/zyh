package com.zyh.service.area;

import java.util.List;

import com.zyh.controller.area.vo.ProvinceVO;

public interface IAreaService {
	
	public List<ProvinceVO> findAllArea()throws Exception;
	
}

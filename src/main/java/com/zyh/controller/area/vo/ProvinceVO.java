package com.zyh.controller.area.vo;

import java.util.List;

import com.zyh.entity.common.Cities;
import com.zyh.entity.common.Provinces;

public class ProvinceVO {

	
	private Provinces provinces;
	
	private List<CityVO> cityVOs;

	public Provinces getProvinces() {
		return provinces;
	}

	public List<CityVO> getCityVOs() {
		return cityVOs;
	}

	public void setCityVOs(List<CityVO> cityVOs) {
		this.cityVOs = cityVOs;
	}

	public void setProvinces(Provinces provinces) {
		this.provinces = provinces;
	}

	
	
}

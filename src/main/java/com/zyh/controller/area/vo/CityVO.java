package com.zyh.controller.area.vo;

import java.util.List;

import com.zyh.entity.common.Areas;
import com.zyh.entity.common.Cities;

public class CityVO {

	
	private Cities cities ;
	
	private List<Areas> areaslist;

	public Cities getCities() {
		return cities;
	}

	public void setCities(Cities cities) {
		this.cities = cities;
	}

	public List<Areas> getAreaslist() {
		return areaslist;
	}

	public void setAreaslist(List<Areas> areaslist) {
		this.areaslist = areaslist;
	}
	
}

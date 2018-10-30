package com.zyh.service.area.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.controller.area.vo.CityVO;
import com.zyh.controller.area.vo.ProvinceVO;
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
	
	@Autowired
	private AreasMapper areasMapper;

	@Override
	public List<ProvinceVO> findAllArea() throws Exception {
		CitiesExample citiesExample = new CitiesExample();
		List<Cities> citieslist = citiesMapper.selectByExample(citiesExample);
		AreasExample areasExample = new AreasExample();
		List<Areas> areaslist = areasMapper.selectByExample(areasExample);
		ProvincesExample provincesExample = new ProvincesExample();
		List<Provinces> provinceslist = provincesMapper.selectByExample(provincesExample);
		List<ProvinceVO> provinceVOs = new ArrayList<>();
		if (null!=provinceslist) {
			for (int i = 0; i < provinceslist.size(); i++) {
				Provinces provinces = provinceslist.get(i);
				ProvinceVO provinceVO = new ProvinceVO();
				provinceVO.setProvinces(provinces);
				List<CityVO> cityVOs = new ArrayList<>();
				if (null!=citieslist) {
					for (int j = 0; j < citieslist.size(); j++) {
						Cities cities = citieslist.get(j);
						CityVO cityVO = new CityVO();
						if (null!=cities) {
							cityVO.setCities(cities);
							List<Areas> areasList = new ArrayList<>();
							if (null!=areaslist) {
								for (int k = 0; k < areaslist.size(); k++) {
									Areas areas = areaslist.get(k);
									if (null!=areas&&areas.getCityid().equals(cities.getCityid())) {
										areasList.add(areas);
									}
								}
								cityVO.setAreaslist(areasList);
							}
						}
						if (null!=provinces&&provinces.getProvinceid().equals(cityVO.getCities().getProvinceid())) {
							cityVOs.add(cityVO);
						}
					}
					provinceVO.setCityVOs(cityVOs);
				}
				provinceVOs.add(provinceVO);
			}
		}
		return provinceVOs;
	} 
	

}

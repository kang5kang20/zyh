package com.zyh.controller.area;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.controller.area.vo.ProvinceVO;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.service.area.IAreaService;

@RestController
@RequestMapping("/map")
public class AreaController {
	
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IAreaService areaServiceImpl;
	
	@RequestMapping("/getAllMap.act")
	public ResponeToWeb getAllMap(){
		ResponeToWeb responeToWeb  = new ResponeToWeb();
		Map<String, Object> map = new HashMap<>();
		try {
			List<ProvinceVO> list = areaServiceImpl.findAllArea();
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			map.put("result", list);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg("查询失败"+e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
}

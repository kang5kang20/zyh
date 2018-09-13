package com.zyh.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.user.ZyhUser;

@RestController
public class UserLoginController {
	
	private Logger log = Logger.getLogger("error");
	
	@RequestMapping("/test.act")
	public ResponeToWeb login(@RequestBody String json){
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhUser user = om.readValue(json, ZyhUser.class);
			responeToWeb.setMsg("登录成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error("登录失败："+e.getMessage());
			responeToWeb.setMsg("登录失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
}

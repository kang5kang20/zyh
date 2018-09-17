package com.zyh.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.user.ZyhUser;
import com.zyh.service.user.ILoginService;

@RestController
public class UserLoginController {

	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private ILoginService loginService;

	@RequestMapping("/login.act")
	public ResponeToWeb login(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhUser user = om.readValue(json, ZyhUser.class);
			if (null != user && null != user.getType() && !"".equals(user.getType())) {
				user = loginService.loginAndRegister(user);
				map.put("result", user);
				responeToWeb.setMsg("登录成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			} else {
				responeToWeb.setMsg("登录失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("登录失败：" + e.getMessage());
			responeToWeb.setMsg("登录失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
}

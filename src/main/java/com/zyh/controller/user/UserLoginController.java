package com.zyh.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.controller.user.common.UserCom;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.user.ZyhUser;
import com.zyh.service.user.ILoginService;

@RestController
@RequestMapping("/user")
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
				if ("mm".equals(user.getType())) {
					user = loginService.loginByMM(user);
				}else{
					user = loginService.loginAndRegister(user);
				}
				map.put("result", user);
				responeToWeb.setMsg("登录成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_INFORERROR);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("登录失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/sms.act")
	public ResponeToWeb smsServer(@RequestBody String json){
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String phone =  node.get("phone").asText();
			if (null!=phone&&!"".equals(phone)) {
				loginService.smsService(phone);
				responeToWeb.setSuccess(true);
			}else{
				responeToWeb.setSuccess(false);
				responeToWeb.setMsg(UserCom.ERROR_PHONEEMPTY);
			}
		} catch (Exception e) {
			log.error("获取短信失败："+e.getMessage());
			responeToWeb.setSuccess(false);
			responeToWeb.setMsg(e.getMessage());
		}
		return responeToWeb;
	}
	
//	public static void main(String[] args) {
//		ResponeToWeb responeToWeb = new ResponeToWeb();
//		Map<String, Object> map = new HashMap<>();
//		responeToWeb.setMsg("登录成功");
//		responeToWeb.setSuccess(true);
//		ZyhUser zyhUser = new ZyhUser();
//		map.put("result", zyhUser);
//		responeToWeb.setValue(map);
//		ObjectMapper om = new ObjectMapper();
//		try {
//			System.out.println(om.writer().writeValueAsString(responeToWeb));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
}

package com.zyh.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.controller.user.common.UserCom;
import com.zyh.controller.user.vo.SmsVO;
import com.zyh.controller.user.vo.UserQueryVO;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;
import com.zyh.entity.user.ZyhUserExample.Criteria;
import com.zyh.redis.RedisUtil;
import com.zyh.service.user.ILoginService;
import com.zyh.service.user.IUserService;
import com.zyh.service.user.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserLoginController {

	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private IUserService userService;
	
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
			String type = node.get("type").asText();
			if (null==phone||"".equals(phone)) {
				responeToWeb.setSuccess(false);
				responeToWeb.setMsg(UserCom.ERROR_PHONEEMPTY);
				return responeToWeb;
			}
			if (null==type||"".equals(type)) {
				responeToWeb.setSuccess(false);
				responeToWeb.setMsg(UserCom.ERROR_TYPEEMPTY);
				return responeToWeb;
			}
			if (null!=phone&&!"".equals(phone)) {
				loginService.smsService(phone,type);
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
	
	@RequestMapping("/queryUserByPage.act")
	public ResponeToWeb queryUserByPage(@RequestBody String json){
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserQueryVO userQueryVO = om.readValue(json, UserQueryVO.class);
			ZyhUserExample zyhUserExample = new ZyhUserExample();
			Criteria criteria = zyhUserExample.createCriteria();
			criteria.andUsernameEqualTo(userQueryVO.getUsername());
			map = userService.findUserByPage(zyhUserExample, userQueryVO.getPageNum(), userQueryVO.getPageSize());
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg("查询失败:"+e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/checkUBySms.act")
	public ResponeToWeb checkUserBySms(@RequestBody String json){
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhUser zyhUser = om.readValue(json, ZyhUser.class);
			if (null==zyhUser.getPhone()||"".equals(zyhUser.getPhone())) {
				responeToWeb.setMsg(UserCom.ERROR_PHONEEMPTY);
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			if (null==zyhUser.getUsername()||"".equals(zyhUser.getUsername())) {
				responeToWeb.setMsg(UserCom.ERROR_USERNAMEEMPTY);
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			if (null==zyhUser.getVericode()||"".equals(zyhUser.getVericode())) {
				responeToWeb.setMsg(UserCom.ERROR_VERICODENULL);
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			if (userService.checkUserBySMS(zyhUser)) {
				responeToWeb.setMsg("ok");
				responeToWeb.setSuccess(true);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg("失败:"+e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return null;
	}
}

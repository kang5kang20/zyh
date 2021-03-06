package com.zyh.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.controller.user.common.UserCom;
import com.zyh.controller.user.vo.UserQueryVO;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;
import com.zyh.entity.user.ZyhUserExample.Criteria;
import com.zyh.redis.RedisUtil;
import com.zyh.service.user.ILoginService;
import com.zyh.service.user.IUserService;
import com.zyh.utils.MD5Util;

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
				} else {
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
	public ResponeToWeb smsServer(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String phone = node.get("phone").asText();
			String type = node.get("type").asText();
			if (null == phone || "".equals(phone)) {
				responeToWeb.setSuccess(false);
				responeToWeb.setMsg(UserCom.ERROR_PHONEEMPTY);
				return responeToWeb;
			}
			if (null == type || "".equals(type)) {
				responeToWeb.setSuccess(false);
				responeToWeb.setMsg(UserCom.ERROR_TYPEEMPTY);
				return responeToWeb;
			}
			if (null != phone && !"".equals(phone)) {
				loginService.smsService(phone, type);
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setSuccess(false);
				responeToWeb.setMsg(UserCom.ERROR_PHONEEMPTY);
			}
		} catch (Exception e) {
			log.error("获取短信失败：" + e.getMessage());
			responeToWeb.setSuccess(false);
			responeToWeb.setMsg(e.getMessage());
		}
		return responeToWeb;
	}

	@RequestMapping("/queryUserByPage.act")
	public ResponeToWeb queryUserByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserQueryVO userQueryVO = om.readValue(json, UserQueryVO.class);
			ZyhUserExample zyhUserExample = new ZyhUserExample();
			Criteria criteria = zyhUserExample.createCriteria();
			if (null != userQueryVO.getUsername()) {
				criteria.andUsernameEqualTo(userQueryVO.getUsername());
			}
			if (null != userQueryVO.getUserid()) {
				criteria.andIdEqualTo(userQueryVO.getUserid());
			}
			if (null != userQueryVO.getOpenid()) {
				criteria.andOpenidEqualTo(userQueryVO.getOpenid());
			}
			if (null != userQueryVO.getPhone()) {
				criteria.andPhoneEqualTo(userQueryVO.getPhone());
			}
			if (null != userQueryVO.getUsertype()) {
				criteria.andUsertypeEqualTo(userQueryVO.getUsertype());
			}
			map = userService.findUserByPage(zyhUserExample, userQueryVO.getPageNum(), userQueryVO.getPageSize());
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg("查询失败:" + e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/checkUserBySms.act")
	public ResponeToWeb checkUserBySms(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhUser zyhUser = om.readValue(json, ZyhUser.class);
			if (null == zyhUser.getPhone() || "".equals(zyhUser.getPhone())) {
				responeToWeb.setMsg(UserCom.ERROR_PHONEEMPTY);
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			if (null == zyhUser.getUsername() || "".equals(zyhUser.getUsername())) {
				responeToWeb.setMsg(UserCom.ERROR_USERNAMEEMPTY);
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			if (null == zyhUser.getVericode() || "".equals(zyhUser.getVericode())) {
				responeToWeb.setMsg(UserCom.ERROR_VERICODENULL);
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			if (null == zyhUser.getType() || "".equals(zyhUser.getType())) {
				responeToWeb.setMsg(UserCom.ERROR_TYPEEMPTY);
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			if (userService.checkUserBySMS(zyhUser)) {
				responeToWeb.setMsg("ok");
				responeToWeb.setSuccess(true);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg("失败:" + e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/changep.act")
	public ResponeToWeb changep(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhUser zyhUser = om.readValue(json, ZyhUser.class);
			if (userService.checkUserBySMS(zyhUser)) {
				responeToWeb.setMsg("验证成功");
				responeToWeb.setSuccess(true);
			} else {
				responeToWeb.setMsg("验证失败");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg("失败:" + e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/changepassword.act")
	public ResponeToWeb changepassword(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhUser zyhUser = om.readValue(json, ZyhUser.class);
			ZyhUserExample zyhUserExample = new ZyhUserExample();
			if (null == zyhUser.getPassword() || "".equals(zyhUser.getPassword())) {
				throw new Exception(UserCom.ERROR_PWEMPTY);
			}
			String password = MD5Util.EncoderByMd5(zyhUser.getPassword());
			if (null == zyhUser.getId() || "".equals(zyhUser.getId())) {
				boolean flag = false;
				if (null != zyhUser.getUsername() && !"".equals(zyhUser.getUsername())) {
					Criteria criteria = zyhUserExample.createCriteria();
					criteria.andUsernameEqualTo(zyhUser.getUsername());
					flag = true;
				} else if (null != zyhUser.getPhone() && !"".equals(zyhUser.getPhone())) {
					Criteria criteria = zyhUserExample.createCriteria();
					criteria.andPhoneEqualTo(zyhUser.getPhone());
					flag = true;
				}
				if (!flag) {
					throw new Exception(UserCom.ERROR_USERNOTEXIST);
				}
				if (userService.changePassword(zyhUserExample, password) > 0) {
					responeToWeb.setMsg("更新成功!");
					responeToWeb.setSuccess(true);
				} else {
					responeToWeb.setMsg(UserCom.ERROR_USERNOTEXIST);
					responeToWeb.setSuccess(false);
				}
			} else {
				Criteria criteria = zyhUserExample.createCriteria();
				criteria.andIdEqualTo(zyhUser.getId());
				if (userService.changePassword(zyhUserExample, password) > 0) {
					responeToWeb.setMsg("更新成功!");
					responeToWeb.setSuccess(true);
				} else {
					responeToWeb.setMsg(UserCom.ERROR_USERNOTEXIST);
					responeToWeb.setSuccess(false);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg("失败:" + e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/updateUser.act")
	public ResponeToWeb updateUser(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhUser zyhUser = om.readValue(json, ZyhUser.class);
			zyhUser.setUsertype("0");
			zyhUser.setPassword(null);
			if (null != zyhUser.getId() && !"".equals(zyhUser.getId())) {
				ZyhUserExample zyhUserExample = new ZyhUserExample();
				Criteria criteria = zyhUserExample.createCriteria();
				criteria.andIdEqualTo(zyhUser.getId());
				if (userService.updateUser(zyhUser, zyhUserExample) > 0) {
					responeToWeb.setMsg("更新成功!");
					responeToWeb.setSuccess(true);
				} else {
					responeToWeb.setMsg(UserCom.ERROR_USERNOTEXIST);
					responeToWeb.setSuccess(false);
				}
			} else {
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responeToWeb.setMsg("失败:" + e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}

	@RequestMapping("/addUser.act")
	public ResponeToWeb addUser(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhUser zyhUser = om.readValue(json, ZyhUser.class);
			zyhUser.setUsertype("0");
			if (null == zyhUser.getPhone() || "".equals(zyhUser.getPhone())) {
				throw new Exception(UserCom.ERROR_PHONEEMPTY);
			}
			if (null == zyhUser.getUsername() || "".equals(zyhUser.getUsername())) {
				throw new Exception(UserCom.ERROR_USERNAMENULL);
			}
			if (null == zyhUser.getPassword() || "".equals(zyhUser.getPassword())) {
				throw new Exception(UserCom.ERROR_PWEMPTY);
			}
			if (null == zyhUser.getVericode() || "".equals(zyhUser.getVericode())) {
				throw new Exception(UserCom.ERROR_VERICODENULL);
			}
			zyhUser.setType("zc");
			if (userService.checkUserBySMS(zyhUser)) {
				String password = MD5Util.EncoderByMd5(zyhUser.getPassword());
				zyhUser.setPassword(password);
				Date date = new Date();
				zyhUser.setCreatetime(date);
				userService.addUser(zyhUser);
				responeToWeb.setMsg("新增成功");
				responeToWeb.setSuccess(true);
			}
		}catch (Exception e){
			log.error(e.getMessage());
			responeToWeb.setMsg("失败:" + e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
}

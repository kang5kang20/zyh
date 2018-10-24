package com.zyh.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.zyh.controller.user.common.UserCom;
import com.zyh.controller.user.vo.SmsVO;
import com.zyh.dao.user.ZyhUserMapper;
import com.zyh.dao.user.cus.ZyhUserCusMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;
import com.zyh.entity.user.ZyhUserExample.Criteria;
import com.zyh.redis.RedisUtil;
import com.zyh.service.sms.ISmsService;
import com.zyh.service.user.ILoginService;
import com.zyh.utils.DataAccuracyUtil;
import com.zyh.utils.MD5Util;

@Service("loginService")
public class LoginServiceImpl implements ILoginService{

	@Autowired
	ZyhUserMapper zyhUserMapper;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	ZyhUserCusMapper zyhUserCusMapper;
	
	@Autowired
	private ISmsService smsServiceImpl;
	
	@Override
	public ZyhUser loginAndRegister(ZyhUser zyhUser) throws Exception {
		String type = zyhUser.getType();
		ZyhUserExample zyhUserExample = new ZyhUserExample();
		Criteria criteria = zyhUserExample.createCriteria();
		if ("wx".equals(type)) {
			String openid = zyhUser.getOpenid();
			if (null!=openid&&!"".equals(openid)) {
				criteria.andOpenidEqualTo(openid);
			}
		}else if ("dx".equals(type)) {
			String phone = zyhUser.getPhone();
			String key = phone+"zc";
			//查询redis是否有
			if (!redisUtil.exists(key)) {
				//redis没有说明已经过期了
				throw new Exception(UserCom.ERROR_CACHETIMEOUT);
			}
			SmsVO smsVO =(SmsVO) redisUtil.get(key);
			if (null==smsVO||!zyhUser.getVericode().equals(smsVO.getVerifyCode())) {
				throw new Exception(UserCom.ERROR_VERICODEERROR);
			}
			criteria.andPhoneEqualTo(phone);
		}
		List<ZyhUser> list = zyhUserMapper.selectByExample(zyhUserExample);
		if (null!=list&&list.size()>0) {
			//查询有记录进行关联
			ZyhUser returnUser = new ZyhUser();
			returnUser = list.get(0);
			if ("1".equals(returnUser.getIsenable())) {
				//黑名单禁止登陆
				throw new Exception(UserCom.ERROR_USERDISABLE);
			}
			returnUser.setPassword(null);
			return returnUser;
		}else{
			//查询无记录进行注册
			if (null == zyhUser.getId()||"".equals(zyhUser.getId())) {
				String id = UUidUtil.getUUid();
				zyhUser.setId(id);
			}
			Date date = new Date();
			zyhUser.setCreatetime(date);
			zyhUserMapper.insertSelective(zyhUser);
			zyhUser.setPassword(null);
			return zyhUser;
		}
	}

	@Override
	public ZyhUser loginByMM(ZyhUser zyhUser) throws Exception {
		String username = zyhUser.getUsername();
		String psword = zyhUser.getPassword();
		if (null==username||"".equals(username)) {
			throw new Exception(UserCom.ERROR_USERNAMEEMPTY);
		}
		if (null==psword||"".equals(psword)) {
			throw new Exception(UserCom.ERROR_PWEMPTY);
		}
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", MD5Util.EncoderByMd5(psword));
		List<ZyhUser> list = zyhUserCusMapper.selectUserByExample(map);
		if (null!=list&&list.size()>0) {
			zyhUser = list.get(0);
			if ("1".equals(zyhUser.getIsenable())) {
				//黑名单禁止登陆
				throw new Exception(UserCom.ERROR_USERDISABLE);
			}
			zyhUser.setPassword(null);
		}else{
			throw new Exception(UserCom.ERROR_NAMEORPDERROR);
		}
		return zyhUser;
	}
	
	public SmsVO smsService(String phone,String type)throws Exception{
		SmsVO smsVO = new SmsVO();
		smsVO.setPhone(phone);
		//生成4位验证码
		DataAccuracyUtil dataAccuracyUtil = new DataAccuracyUtil();
		int verifyCode = dataAccuracyUtil.getVerifyCode();
		smsVO.setVerifyCode(verifyCode+"");
		if ("zc".equals(type)) {
			//注册模块
			smsVO.setModelId(UserCom.SMS_MODEL_ZC);
		}
		if ("xg".equals(type)) {
			//修改密码
			smsVO.setModelId(UserCom.SMS_MODEL_XG);
			//验证手机号是否存在
			ZyhUserExample zyhUserExample = new ZyhUserExample();
			Criteria criteria = zyhUserExample.createCriteria();
			criteria.andPhoneEqualTo(phone);
			List<ZyhUser> list = zyhUserMapper.selectByExample(zyhUserExample);
			if (null==list||list.size()<=0) {
				throw new Exception(UserCom.ERROR_NOPHONE);
			}
		}
		String key = phone+type;
		//调用sms服务
		SendSmsResponse sendSmsResponse = smsServiceImpl.sendSms(smsVO);
		if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			// 请求成功,将sms返回存入redis
			redisUtil.set(key, smsVO, UserCom.USER_SMSCACHETIME);
		}
		return smsVO;
	}
}

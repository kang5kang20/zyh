package com.zyh.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.controller.user.common.UserCom;
import com.zyh.controller.user.vo.SmsVO;
import com.zyh.dao.user.ZyhUserMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.common.Page;
import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;
import com.zyh.entity.user.ZyhUserExample.Criteria;
import com.zyh.redis.RedisUtil;
import com.zyh.service.user.IUserService;
import com.zyh.utils.MD5Util;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	ZyhUserMapper zyhUserMapper;
	
	@Autowired
	private RedisUtil redisUtil;

	public void addUser(ZyhUser user) throws Exception {
		if (null!=user.getPassword()&&"".equals(user.getPassword())) {
			String psMd5 = MD5Util.EncoderByMd5(user.getPassword());
			user.setPassword(psMd5);
		}
		if (null ==user.getId()||"".equals(user.getId())) {
			String id = UUidUtil.getUUid();
			user.setId(id);
		}
		zyhUserMapper.insertSelective(user);
	}

	@Override
	public int updateUser(ZyhUser user,ZyhUserExample zyhUserExample) throws Exception {
		return zyhUserMapper.updateByExampleSelective(user, zyhUserExample);
	}

	@Override
	public List<ZyhUser> findUser(ZyhUserExample zyhUserExample) throws Exception {
		return zyhUserMapper.selectByExample(zyhUserExample);
	}

	@Override
	public Map<String, Object> findUserByPage(ZyhUserExample zyhUserExample, int pageNum, int pageSize)
			throws Exception {
		Map<String, Object> map = new HashMap<>();
		List<ZyhUser> list = zyhUserMapper.selectUserByPage(zyhUserExample, pageNum, pageSize);
		map.put("result", list);
		Page page = new Page();
		page.setPageNum(pageNum);
		page.setTotalRowCount(zyhUserMapper.countByExample(zyhUserExample));
		map.put("pageResult", page);
		return map;
	}

	/**
	 * 通过短信验证用户信息
	 */
	@Override
	public boolean checkUserBySMS(ZyhUser zyhUser) throws Exception {
		String phone = zyhUser.getPhone();
		String username = zyhUser.getUsername();
		String key = phone+zyhUser.getType();
		if (!redisUtil.exists(key)) {
			//redis没有说明已经过期了
			throw new Exception(UserCom.ERROR_CACHETIMEOUT);
		}
		SmsVO smsVO =(SmsVO) redisUtil.get(key);
		if (null==smsVO||!zyhUser.getVericode().equals(smsVO.getVerifyCode())) {
			throw new Exception(UserCom.ERROR_VERICODEERROR);
		}
		//查询用户是否存在
		if ("xg".equals(zyhUser.getType())) {
			ZyhUserExample zyhUserExample = new ZyhUserExample();
			Criteria criteria = zyhUserExample.createCriteria();
			criteria.andUsernameEqualTo(username);
			List<ZyhUser> list = zyhUserMapper.selectByExample(zyhUserExample);
			if (null==list||list.size()<=0) {
				throw new Exception(UserCom.ERROR_USERNAMENON);
			}
		}
		return true;
	}

	@Override
	public int changePassword(ZyhUserExample zyhUserExample, String password) throws Exception {
		ZyhUser zyhUser = new ZyhUser();
		zyhUser.setPassword(password);
		return zyhUserMapper.updateByExampleSelective(zyhUser, zyhUserExample);
	}
	
	
}

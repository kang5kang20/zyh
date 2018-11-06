package com.zyh.controller.statis;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.controller.user.vo.UserStatisQueryVO;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.user.ZyhUserExample;
import com.zyh.entity.user.ZyhUserExample.Criteria;

@RestController
@RequestMapping("/userstatis")
public class UserStatisController {

	private Logger log = Logger.getLogger("error");

	@RequestMapping("/addUserStatis")
	public ResponeToWeb addUserStatis(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		try {
			UserStatisQueryVO userStatisQueryVO = om.readValue(json, UserStatisQueryVO.class);
			ZyhUserExample zyhUserExample = new ZyhUserExample();
			Criteria criteria = zyhUserExample.createCriteria();
			if (null != userStatisQueryVO.getStartDate() && !"".equals(userStatisQueryVO.getStartDate())) {
				String starttime = userStatisQueryVO.getStartDate()+" 00:00:00";
			}
			if (null != userStatisQueryVO.getEndDate() && !"".equals(userStatisQueryVO.getEndDate())) {
				String endtime = userStatisQueryVO.getEndDate();
			}
			// criteria.andCreatetimeBetween(value1, value2);
		} catch (Exception e) {
			log.error("登录失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
}

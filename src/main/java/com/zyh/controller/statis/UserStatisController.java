package com.zyh.controller.statis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.controller.resume.vo.ResumeBaseQueryVO;
import com.zyh.controller.statis.vo.OperatorStatisVO;
import com.zyh.controller.statis.vo.StatisQueryVO;
import com.zyh.controller.user.common.UserCom;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.company.ZyhCompanyPositionExample;
import com.zyh.entity.company.ZyhCompanyTrainExample;
import com.zyh.entity.operator.ZyhOperatorRecordExample;
import com.zyh.entity.resume.ZyhResumeBaseExample;
import com.zyh.entity.user.ZyhUserExample;
import com.zyh.entity.user.ZyhUserExample.Criteria;
import com.zyh.entity.user.ZyhUserPositionExample;
import com.zyh.service.company.ICompanyPositionService;
import com.zyh.service.company.ICompanyTrainService;
import com.zyh.service.operator.IOperatorService;
import com.zyh.service.resume.IResumeBaseService;
import com.zyh.service.user.IUserPostService;
import com.zyh.service.user.IUserService;
import com.zyh.utils.DateUtil;

@RestController
@RequestMapping("/userstatis")
public class UserStatisController {

	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IResumeBaseService resumeBaseService;
	
	@Autowired
	private IOperatorService operatorServiceImpl;
	
	@Autowired
	private IUserPostService userPostService;
	
	@Autowired
	private ICompanyPositionService companyPositionService;
	
	@Autowired
	private ICompanyTrainService companyTrainService;

	@RequestMapping("/addStatisByType.act")
	public ResponeToWeb addUserStatis(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		long count = 0;
		try {
			StatisQueryVO statisQueryVO = om.readValue(json, StatisQueryVO.class);
			if (null==statisQueryVO.getType()) {
				responeToWeb.setMsg(UserCom.ERROR_TYPEEMPTY);
				responeToWeb.setSuccess(false);
			}else if ("0".equals(statisQueryVO.getType())) {
				//新增用户信息
				ZyhUserExample zyhUserExample = new ZyhUserExample();
				Criteria criteria = zyhUserExample.createCriteria();
				if (null != statisQueryVO.getStartDate() && !"".equals(statisQueryVO.getStartDate())) {
					String starttime = statisQueryVO.getStartDate()+" 00:00:00";
					Date date = DateUtil.formatDate(starttime);
					criteria.andCreatetimeGreaterThanOrEqualTo(date);
				}
				if (null != statisQueryVO.getEndDate() && !"".equals(statisQueryVO.getEndDate())) {
					String endtime = statisQueryVO.getEndDate()+" 23:59:59";
					Date date = DateUtil.formatDate(endtime);
					criteria.andCreatetimeLessThanOrEqualTo(date);
				}
				count = userService.countUserByExam(zyhUserExample);
			}else if ("1".equals(statisQueryVO.getType())) {
				//新增访问统计
				ZyhOperatorRecordExample zyhOperatorRecordExample = new ZyhOperatorRecordExample();
				com.zyh.entity.operator.ZyhOperatorRecordExample.Criteria criteria = zyhOperatorRecordExample.createCriteria();
				if (null != statisQueryVO.getStartDate() && !"".equals(statisQueryVO.getStartDate())) {
					String starttime = statisQueryVO.getStartDate()+" 00:00:00";
					Date date = DateUtil.formatDate(starttime);
					criteria.andOptimeGreaterThanOrEqualTo(date);
				}
				if (null != statisQueryVO.getEndDate() && !"".equals(statisQueryVO.getEndDate())) {
					String endtime = statisQueryVO.getEndDate()+" 23:59:59";
					Date date = DateUtil.formatDate(endtime);
					criteria.andOptimeLessThanOrEqualTo(date);
				}
				count = operatorServiceImpl.countByExam(zyhOperatorRecordExample);
			}else if ("2".equals(statisQueryVO.getType())) {
				//新增投递
				ZyhUserPositionExample example = new ZyhUserPositionExample();
				com.zyh.entity.user.ZyhUserPositionExample.Criteria criteria = example.createCriteria();
				if (null != statisQueryVO.getStartDate() && !"".equals(statisQueryVO.getStartDate())) {
					String starttime = statisQueryVO.getStartDate()+" 00:00:00";
					Date date = DateUtil.formatDate(starttime);
					criteria.andOptimeGreaterThanOrEqualTo(date);
				}
				if (null != statisQueryVO.getEndDate() && !"".equals(statisQueryVO.getEndDate())) {
					String endtime = statisQueryVO.getEndDate()+" 23:59:59";
					Date date = DateUtil.formatDate(endtime);
					criteria.andOptimeLessThanOrEqualTo(date);
				}
				if (null!=statisQueryVO.getPosttype()&&!"".equals(statisQueryVO.getPosttype())) {
					criteria.andPosttypeEqualTo(statisQueryVO.getPosttype());
				}
				count = userPostService.countByExam(example);
			}else if ("3".equals(statisQueryVO.getType())) {
				//新增职位
				ZyhCompanyPositionExample example = new ZyhCompanyPositionExample();
				com.zyh.entity.company.ZyhCompanyPositionExample.Criteria criteria = example.createCriteria();
				if (null != statisQueryVO.getStartDate() && !"".equals(statisQueryVO.getStartDate())) {
					String starttime = statisQueryVO.getStartDate()+" 00:00:00";
					Date date = DateUtil.formatDate(starttime);
					criteria.andOptimeGreaterThanOrEqualTo(date);
				}
				if (null != statisQueryVO.getEndDate() && !"".equals(statisQueryVO.getEndDate())) {
					String endtime = statisQueryVO.getEndDate()+" 23:59:59";
					Date date = DateUtil.formatDate(endtime);
					criteria.andOptimeLessThanOrEqualTo(date);
				}
				count = companyPositionService.countByExam(example);
			}
			else if ("4".equals(statisQueryVO.getType())) {
				//新增培训
				ZyhCompanyTrainExample example = new ZyhCompanyTrainExample();
				com.zyh.entity.company.ZyhCompanyTrainExample.Criteria criteria = example.createCriteria();
				if (null != statisQueryVO.getStartDate() && !"".equals(statisQueryVO.getStartDate())) {
					String starttime = statisQueryVO.getStartDate()+" 00:00:00";
					Date date = DateUtil.formatDate(starttime);
					criteria.andCreatetimeGreaterThanOrEqualTo(date);
				}
				if (null != statisQueryVO.getEndDate() && !"".equals(statisQueryVO.getEndDate())) {
					String endtime = statisQueryVO.getEndDate()+" 23:59:59";
					Date date = DateUtil.formatDate(endtime);
					criteria.andCreatetimeLessThanOrEqualTo(date);
				}
				count = companyTrainService.countByExam(example);
			}
			map.put("result", count);
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error("登录失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/userWorkStatis.act")
	public ResponeToWeb userWorkStatis(@RequestBody String json){
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		try {
			ResumeBaseQueryVO resumeBaseQueryVO = om.readValue(json, ResumeBaseQueryVO.class);
			ZyhResumeBaseExample zyhResumeBaseExample = new ZyhResumeBaseExample();
			com.zyh.entity.resume.ZyhResumeBaseExample.Criteria criteria = zyhResumeBaseExample.createCriteria();
			if (null!=resumeBaseQueryVO.getWorkstate()&&!"".equals(resumeBaseQueryVO.getWorkstate())) {
				criteria.andWorkstateEqualTo(resumeBaseQueryVO.getWorkstate());
			}
			if (null!=resumeBaseQueryVO.getSoldiercheckstate()&&!"".equals(resumeBaseQueryVO.getSoldiercheckstate())) {
				criteria.andSoldiercheckstateEqualTo(resumeBaseQueryVO.getSoldiercheckstate());
			}
			if (null!=resumeBaseQueryVO.getIdcheckstate()&&!"".equals(resumeBaseQueryVO.getIdcheckstate())) {
				criteria.andIdcheckstateEqualTo(resumeBaseQueryVO.getIdcheckstate());
			}
			long count = resumeBaseService.countByExam(zyhResumeBaseExample);
			map.put("result", count);
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error("统计失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/userWorkState.act")
	public ResponeToWeb userWorkState(){
		ResponeToWeb responeToWeb = new ResponeToWeb();
		Map<String, Object> map = new HashMap<>();
		ZyhUserExample zyhUserExample = new ZyhUserExample();
		try {
			long userCount = userService.countUserByExam(zyhUserExample);
			ZyhResumeBaseExample zyhResumeBaseExample = new ZyhResumeBaseExample();
			zyhResumeBaseExample.or().andWorkstateEqualTo("0");
			zyhResumeBaseExample.or().andWorkstateEqualTo("3");
			long workCount = resumeBaseService.countByExam(zyhResumeBaseExample);
			ZyhResumeBaseExample zyhResumeBaseExample2 = new ZyhResumeBaseExample();
			zyhResumeBaseExample2.createCriteria().andWorkstateEqualTo("1");
			long noworkCount = resumeBaseService.countByExam(zyhResumeBaseExample2);
			long weizhiCount = userCount-workCount-noworkCount;
			Map<String, Long> workMap = new HashMap<>();
			workMap.put("zaizhi", workCount);
			workMap.put("lizhi", noworkCount);
			workMap.put("weizhi", weizhiCount);
			map.put("result", workMap);
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error("统计失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/statisOpeatorByDate.act")
	public ResponeToWeb statisOperatorByDay(@RequestBody String json){
		ResponeToWeb responeToWeb = new ResponeToWeb();
		Map<String, Object> map = new HashMap<>();
		ObjectMapper om = new ObjectMapper();
		try {
			String startDate = null;
			String endDate = null;
			JsonNode jsonNode = om.readTree(json);
			if (null!=jsonNode.get("startDate")) {
				startDate = jsonNode.get("startDate").asText();
			}else{
				responeToWeb.setMsg(UserCom.ERROR_NULLSTARTDATE);
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			if (null!=jsonNode.get("endDate")) {
				endDate = jsonNode.get("endDate").asText();
			}else {
				responeToWeb.setMsg(UserCom.ERROR_NULLENDDATE);
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			List<OperatorStatisVO> list = operatorServiceImpl.selectOperatorStatisByDay(startDate, endDate);
			map.put("result",list);
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error("统计失败：" + e.getMessage());
			responeToWeb.setMsg(e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
}

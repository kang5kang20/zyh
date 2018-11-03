package com.zyh.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.controller.user.common.UserCom;
import com.zyh.controller.user.vo.UserPostQueryVO;
import com.zyh.dao.company.ZyhCompanyPositionMapper;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.company.ZyhCompanyPosition;
import com.zyh.entity.user.ZyhUserPosition;
import com.zyh.entity.user.ZyhUserPositionExample;
import com.zyh.entity.user.ZyhUserPositionExample.Criteria;
import com.zyh.service.user.IUserPostService;

@RestController
@RequestMapping("/post")
public class UserPostController {

	private Logger log = Logger.getLogger("error");

	@Autowired
	private IUserPostService userPostService;
	
	@Autowired
	private ZyhCompanyPositionMapper zyhCompanyPositionMapper;

	@RequestMapping("/addPost.act")
	public ResponeToWeb userPost(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhUserPosition zyhUserPosition = om.readValue(json, ZyhUserPosition.class);
			if (null == zyhUserPosition.getUserid() || "".equals(zyhUserPosition.getUserid())) {
				responeToWeb.setSuccess(false);
				responeToWeb.setMsg(UserCom.ERROR_USERIDNULL);
				return responeToWeb;
			}
			if (null == zyhUserPosition.getPositionid() || "".equals(zyhUserPosition.getPositionid())) {
				responeToWeb.setSuccess(false);
				responeToWeb.setMsg(UserCom.ERROR_POSITIONIDNULL);
				return responeToWeb;
			}
			if (null == zyhUserPosition.getPosttype() || "".equals(zyhUserPosition.getPosttype())) {
				responeToWeb.setSuccess(false);
				responeToWeb.setMsg(UserCom.ERROR_POSITIONTYPENULL);
				return responeToWeb;
			}
			zyhUserPosition.setState("0");
			Date date = new Date();
			zyhUserPosition.setOptime(date);
			//设置工作地址
			if("0".equals(zyhUserPosition.getPosttype())){
				ZyhCompanyPosition position = zyhCompanyPositionMapper.selectByPrimaryKey(zyhUserPosition.getPositionid());
				if(null==position){
					responeToWeb.setMsg("公司信息缺失");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				zyhUserPosition.setWorkarea(position.getWorkarea());
				zyhUserPosition.setWorkprovince(position.getWorkprovince());
			}
			userPostService.addUserPost(zyhUserPosition);
			responeToWeb.setMsg("添加成功");
			responeToWeb.setSuccess(true);
		} catch (Exception e) {
			responeToWeb.setMsg("简历投递失败:" + e.getMessage());
			responeToWeb.setSuccess(false);
			log.error("简历投递失败:" + e.getMessage());
		}
		return responeToWeb;
	}

	@RequestMapping("/queryPost.act")
	public ResponeToWeb queryByExam(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		try {
			UserPostQueryVO userPostQueryVO = om.readValue(json, UserPostQueryVO.class);
			ZyhUserPositionExample zyhUserPositionExample = new ZyhUserPositionExample();
			Criteria criteria = zyhUserPositionExample.createCriteria();
			if (null != userPostQueryVO.getId() && !"".equals(userPostQueryVO.getId())) {
				criteria.andIdEqualTo(userPostQueryVO.getId());
				flag = true;
			}
			if (null != userPostQueryVO.getUserid() && !"".equals(userPostQueryVO.getUserid())) {
				criteria.andUseridEqualTo(userPostQueryVO.getUserid());
				flag = true;
			}
			if (null != userPostQueryVO.getCompanyid() && !"".equals(userPostQueryVO.getCompanyid())) {
				criteria.andCompanyidEqualTo(userPostQueryVO.getCompanyid());
				flag = true;
			}
			if (null != userPostQueryVO.getPositionid() && !"".equals(userPostQueryVO.getPositionid())) {
				criteria.andPositionidEqualTo(userPostQueryVO.getPositionid());
				flag = true;
			}
			if (null != userPostQueryVO.getPosttype() && !"".equals(userPostQueryVO.getPosttype())) {
				criteria.andPosttypeEqualTo(userPostQueryVO.getPosttype());
				flag = true;
			}
			if (flag) {
				zyhUserPositionExample.setOrderByClause("optime desc");
				List<ZyhUserPosition> list = userPostService.queryPostByExm(zyhUserPositionExample);
				responeToWeb.setMsg("查询成功");
				map.put("result", list);
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			} else {
				responeToWeb.setMsg(UserCom.ERROR_PARAMERNULL);
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("查询失败:" + e.getMessage());
			responeToWeb.setMsg("查询失败"+e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/queryPostByPage.act")
	public ResponeToWeb queryPostByPage(@RequestBody String json){
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserPostQueryVO userPostQueryVO = om.readValue(json, UserPostQueryVO.class);
			ZyhUserPositionExample zyhUserPositionExample = new ZyhUserPositionExample();
			Criteria criteria = zyhUserPositionExample.createCriteria();
			if (null != userPostQueryVO.getId() && !"".equals(userPostQueryVO.getId())) {
				criteria.andIdEqualTo(userPostQueryVO.getId());
			}
			if (null != userPostQueryVO.getUserid() && !"".equals(userPostQueryVO.getUserid())) {
				criteria.andUseridEqualTo(userPostQueryVO.getUserid());
			}
			if (null != userPostQueryVO.getCompanyid() && !"".equals(userPostQueryVO.getCompanyid())) {
				criteria.andCompanyidEqualTo(userPostQueryVO.getCompanyid());
			}
			if (null != userPostQueryVO.getPositionid() && !"".equals(userPostQueryVO.getPositionid())) {
				criteria.andPositionidEqualTo(userPostQueryVO.getPositionid());
			}
			if (null != userPostQueryVO.getPosttype() && !"".equals(userPostQueryVO.getPosttype())) {
				criteria.andPosttypeEqualTo(userPostQueryVO.getPosttype());
			}
			if (null!=userPostQueryVO.getCompanyname()&&!"".equals(userPostQueryVO.getCompanyname())) {
				criteria.andCompanynameLike("%"+userPostQueryVO.getCompanyname()+"%");
			}
			if (null!=userPostQueryVO.getPositionname()&&!"".equals(userPostQueryVO.getPositionname())) {
				criteria.andPositionnameLike("%"+userPostQueryVO.getPositionname()+"%");
			}
			if (null != userPostQueryVO.getPosttype() && !"".equals(userPostQueryVO.getPosttype())&&"0".equals(userPostQueryVO.getPosttype())) {
				map = userPostService.queryPostPositionInfoByPage(zyhUserPositionExample, userPostQueryVO.getPageNum(), userPostQueryVO.getPageSize());
						
			}else if (null != userPostQueryVO.getPosttype() && !"".equals(userPostQueryVO.getPosttype())&&"1".equals(userPostQueryVO.getPosttype())) {
				map = userPostService.queryPostTrainInfoByPage(zyhUserPositionExample, userPostQueryVO.getPageNum(), userPostQueryVO.getPageSize());
			}else {
				map = userPostService.queryPostByPage(zyhUserPositionExample, userPostQueryVO.getPageNum(), userPostQueryVO.getPageSize());
			}
			responeToWeb.setSuccess(true);
			responeToWeb.setMsg("查询成功");
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error("查询失败:" + e.getMessage());
			responeToWeb.setMsg("查询失败"+e.getMessage());
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
}

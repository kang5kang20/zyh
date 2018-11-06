package com.zyh.controller.consult;

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
import com.zyh.controller.consult.vo.ConsultQueryVO;
import com.zyh.dao.user.ZyhUserMapper;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.consult.ZyhConsult;
import com.zyh.entity.consult.ZyhConsultExample;
import com.zyh.entity.consult.ZyhConsultExample.Criteria;
import com.zyh.entity.user.ZyhUser;
import com.zyh.service.consult.IConsultService;
import com.zyh.service.user.IUserService;

@RestController
@RequestMapping("/consult")
public class ConsultController {
	
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IConsultService consultService;
	
	@Autowired
	private ZyhUserMapper userMapper;
	
	@RequestMapping("/addConsult.do")
	public ResponeToWeb addConsult(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhConsult consult = om.readValue(json, ZyhConsult.class);
			if (null != consult && null!=consult.getUserid() &&
					!"".equals(consult.getUserid()) && null!=consult.getQuestion() &&
					!"".equals(consult.getQuestion())) {
				//设置创建用户名
				ZyhUser user = userMapper.selectByPrimaryKey(consult.getUserid());
				if(null==user){
					responeToWeb.setMsg("新增失败,无此用户");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				consult.setCreateuser(null==user.getUsername()||"".equals(user.getUsername())?"":user.getUsername());
				consult.setCreatetime(new Date());
				//未回复：0
				consult.setState("0");
				consultService.addConsult(consult);
				responeToWeb.setMsg("新增成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(null);
			} else {
				responeToWeb.setMsg("新增失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("新增失败：" + e.getMessage());
			responeToWeb.setMsg("新增失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/replyConsult.do")
	public ResponeToWeb replyConsult(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhConsult consult = om.readValue(json, ZyhConsult.class);
			if (null != consult && null!=consult.getId() && !"".equals(consult.getId()) && 
					null!=consult.getHanduserid() &&
					!"".equals(consult.getHanduserid())) {
				ZyhUser user = userMapper.selectByPrimaryKey(consult.getHanduserid());
				if(null!=user){
					consult.setHanduser(null==user.getUsername()||"".equals(user.getUsername())?"":user.getUsername());
				}
				consult.setState("1");
				consultService.updateConsult(consult);
				responeToWeb.setMsg("修改成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(null);
			} else {
				responeToWeb.setMsg("修改失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("修改失败：" + e.getMessage());
			responeToWeb.setMsg("修改失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/deleteConsult.do")
	public ResponeToWeb deleteConsult(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				consultService.deleteConsult(id);
				responeToWeb.setMsg("删除成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(null);
			} else {
				responeToWeb.setMsg("删除失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("删除失败：" + e.getMessage());
			responeToWeb.setMsg("删除失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/findConsultById.act")
	public ResponeToWeb findConsultById(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				ZyhConsult consult = consultService.queryConsultById(id);
				map.put("result", consult);
				responeToWeb.setMsg("查询成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			} else {
				responeToWeb.setMsg("查询失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("查询失败：" + e.getMessage());
			responeToWeb.setMsg("查询失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	
	@RequestMapping("/findConsultList.act")
	public ResponeToWeb findConsultList(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ConsultQueryVO queryvo = om.readValue(json, ConsultQueryVO.class);
			ZyhConsultExample example = new ZyhConsultExample();
			example.setOrderByClause("createtime desc");
			Criteria criteria = example.createCriteria();
			if(null!=queryvo){
				if(null!=queryvo.getUserid() && !"".equals(queryvo.getUserid())){
					criteria.andUseridEqualTo(queryvo.getUserid());
				}
				if(null!=queryvo.getPhone() && !"".equals(queryvo.getPhone())){
					criteria.andPhoneLike("%"+queryvo.getPhone()+"%");
				}
				if(null!=queryvo.getState() && !"".equals(queryvo.getState())){
					criteria.andStateEqualTo(queryvo.getState());
				}
			}
			List<ZyhConsult> consultlist = consultService.findConsultList(example);
			map.put("result", consultlist);
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error("查询失败：" + e.getMessage());
			responeToWeb.setMsg("查询失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	@RequestMapping("/findConsultByPage.do")
	public ResponeToWeb findConsultByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ConsultQueryVO queryvo = om.readValue(json, ConsultQueryVO.class);
			ZyhConsultExample example = new ZyhConsultExample();
			example.setOrderByClause("createtime desc");
			Criteria criteria = example.createCriteria();
			if(null!=queryvo){
				if(null!=queryvo.getUserid() && !"".equals(queryvo.getUserid())){
					criteria.andUseridEqualTo(queryvo.getUserid());
				}
				if(null!=queryvo.getCreateuser() && !"".equals(queryvo.getCreateuser())){
					criteria.andCreateuserEqualTo(queryvo.getCreateuser());
				}
				if(null!=queryvo.getPhone() && !"".equals(queryvo.getPhone())){
					criteria.andPhoneLike("%"+queryvo.getPhone()+"%");
				}
				if(null!=queryvo.getState() && !"".equals(queryvo.getState())){
					criteria.andStateEqualTo(queryvo.getState());
				}
			}
			Map retmap = 
					consultService.findConsultListByPage(example, queryvo.getPageNum(), 
							queryvo.getPageSize());
			map.put("result", retmap.get("retlist"));
			map.put("pageResult", retmap.get("page"));
			responeToWeb.setMsg("查询成功");
			responeToWeb.setSuccess(true);
			responeToWeb.setValue(map);
		} catch (Exception e) {
			log.error("查询失败：" + e.getMessage());
			responeToWeb.setMsg("查询失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
}

package com.zyh.controller.study;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.zyh.controller.study.vo.MenuQueryVO;
import com.zyh.dao.user.ZyhUserMapper;
import com.zyh.entity.classcourse.ZyhClassCourse;
import com.zyh.entity.classcourse.ZyhClassCourseExample;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.lanmu.ZyhLanmu;
import com.zyh.entity.lanmu.ZyhLanmuExample;
import com.zyh.entity.menu.ZyhMenu;
import com.zyh.entity.menu.ZyhMenuExample;
import com.zyh.entity.menu.ZyhMenuExample.Criteria;
import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.news.ZyhNewsExample;
import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.policy.ZyhPolicyExample;
import com.zyh.entity.user.ZyhUser;
import com.zyh.service.classcourse.IClassCourseService;
import com.zyh.service.news.INewsService;
import com.zyh.service.policy.IPolicyService;
import com.zyh.service.study.ILanmuService;
import com.zyh.service.study.IMenuService;

@RestController
@RequestMapping("/study")
public class StudyController {
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private ZyhUserMapper zyhUserMapper;
	
	@Autowired
	private ILanmuService lanmuService;
	
	@Autowired
	private INewsService newsService;
	
	@Autowired
	private IPolicyService policyService;
	
	@Autowired
	private IClassCourseService classCourseService;
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addMenu.do")
	public ResponeToWeb addMenu(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhMenu menu = om.readValue(json, ZyhMenu.class);
			if (null != menu) {
				//查询创建人
				if(null == menu.getUserid() || "".equals(menu.getUserid())){
					responeToWeb.setMsg("用户信息缺失");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				ZyhUser user = zyhUserMapper.selectByPrimaryKey(menu.getUserid());
				if(null == user){
					responeToWeb.setMsg("用户信息缺失");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				menu.setCreateuser(null == user.getUsername() || "".equals(user.getUsername())?"":user.getUsername());
				menu.setPubtime(new Date());
				menuService.addMenu(menu);
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
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/updateMenu.do")
	public ResponeToWeb updateMenu(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhMenu Menu = om.readValue(json, ZyhMenu.class);
			if (null != Menu && null!=Menu.getId() && !"".equals(Menu.getId())) {
				menuService.updateMenu(Menu);
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
	
	
	@RequestMapping("/deleteMenu.do")
	public ResponeToWeb deleteMenu(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				ZyhLanmuExample example = new ZyhLanmuExample();
				com.zyh.entity.lanmu.ZyhLanmuExample.Criteria criteria =example.createCriteria();
				criteria.andMenuidEqualTo(id);
				List<ZyhLanmu> lanmulist = lanmuService.findLanmuList(example);
				if(null!=lanmulist && lanmulist.size()>0){
					log.error("删除失败：该菜单下还有栏目，不允许删除" );
					responeToWeb.setMsg("删除失败：该菜单下还有栏目，不允许删除");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				menuService.deleteMenu(id);
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
	
	@RequestMapping("/findMenuByPage.do")
	public ResponeToWeb findMenuByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MenuQueryVO queryvo = om.readValue(json, MenuQueryVO.class);
			ZyhMenuExample zyhMenuExample = new ZyhMenuExample();
			Criteria criteria = zyhMenuExample.createCriteria();
			if(null!=queryvo.getName() && "" !=queryvo.getName()){
				criteria.andNameLike("%"+queryvo.getName()+"%");
			}
			if(null!=queryvo.getIfground() && "" !=queryvo.getIfground()){
				criteria.andIfgroundEqualTo(queryvo.getIfground());
			}
			if(null!=queryvo.getCreateuser() && "" !=queryvo.getCreateuser()){
				criteria.andCreateuserLike("%"+queryvo.getCreateuser()+"%");
			}
			Map retmap = 
					menuService.findmenuListByPage(zyhMenuExample, 
							queryvo.getPageNum(), queryvo.getPageSize());
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
	
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addLanmu.do")
	public ResponeToWeb addLanmu(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhLanmu lanmu = om.readValue(json, ZyhLanmu.class);
			if (null != lanmu) {
				//查询创建人
				if(null == lanmu.getUserid() || "".equals(lanmu.getUserid())){
					responeToWeb.setMsg("用户信息缺失");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				ZyhUser user = zyhUserMapper.selectByPrimaryKey(lanmu.getUserid());
				if(null == user){
					responeToWeb.setMsg("用户信息缺失");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				lanmu.setCreateuser(null == user.getUsername() || "".equals(user.getUsername())?"":user.getUsername());
				lanmu.setPubtime(new Date());
				lanmuService.addLanmu(lanmu);
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
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/updateLanmu.do")
	public ResponeToWeb updateLanmu(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhLanmu lanmu = om.readValue(json, ZyhLanmu.class);
			if (null != lanmu && null!=lanmu.getId() && !"".equals(lanmu.getId())) {
				lanmuService.updateLanmu(lanmu);
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
	
	@RequestMapping("/deleteLanmu.do")
	public ResponeToWeb deleteLanmu(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				lanmuService.deleteLanmu(id);
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
	
	@RequestMapping("/findLanmuListByMenuId.act")
	public ResponeToWeb findLanmuListByMenuId(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MenuQueryVO queryvo = om.readValue(json, MenuQueryVO.class);
			if(null==queryvo || null ==queryvo.getMenuid() ||
					"".equals(queryvo.getMenuid())){
				responeToWeb.setMsg("查询失败:查询条件缺失");
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			ZyhLanmuExample example = new ZyhLanmuExample();
			example.setOrderByClause("pubtime desc");
			//上架才允许查
			com.zyh.entity.lanmu.ZyhLanmuExample.Criteria criteria = 
					example.createCriteria();
			criteria.andIfgroundEqualTo("1");
			criteria.andMenuidEqualTo(queryvo.getMenuid());
			List<ZyhLanmu> lanmulist = 
					lanmuService.findLanmuList(example);
			map.put("result", lanmulist);
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
	
	/**
	 * 查询菜单列表
	 * @param json
	 * @return
	 */
	@RequestMapping("/findMenuList.act")
	public ResponeToWeb findMenuList(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhMenuExample example = new ZyhMenuExample();
			example.setOrderByClause("seq");
			//上架才允许查
			Criteria criteria = 
					example.createCriteria();
			criteria.andIfgroundEqualTo("1");
			List<ZyhMenu> menulist = 
					menuService.findmenuList(example);
			map.put("result", menulist);
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
	
	@RequestMapping("/findArtListByLanmuId.act")
	public ResponeToWeb findArtListByLanmuId(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MenuQueryVO queryvo = om.readValue(json, MenuQueryVO.class);
			if(null==queryvo || null ==queryvo.getLanmuid() ||
					"".equals(queryvo.getLanmuid())){
				responeToWeb.setMsg("查询失败:查询条件缺失");
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			ZyhLanmu lanmu = lanmuService.findLanmuById(queryvo.getLanmuid());
			if("0".equals(lanmu.getType())){
				ZyhNewsExample example = new ZyhNewsExample();
				example.setOrderByClause("pubtime desc");
				com.zyh.entity.news.ZyhNewsExample.Criteria criteria = 
						example.createCriteria();
				criteria.andIfgroundEqualTo("1");
				if(null!=lanmu.getArtid()&&!"".equals(lanmu.getArtid())){
					String[] ids = lanmu.getArtid().split(";");
					List<String> idlist = Arrays.asList(ids);
					criteria.andIdIn(idlist);
				}
				List<ZyhNews> retlist = 
						newsService.findNewsList(example);
				map.put("result", retlist);
			}else if("1".equals(lanmu.getType())){
				ZyhPolicyExample example = new ZyhPolicyExample();
				example.setOrderByClause("pubtime desc");
				com.zyh.entity.policy.ZyhPolicyExample.Criteria criteria = 
						example.createCriteria();
				criteria.andIfgroundEqualTo("1");
				if(null!=lanmu.getArtid()&&!"".equals(lanmu.getArtid())){
					String[] ids = lanmu.getArtid().split(";");
					List<String> idlist = Arrays.asList(ids);
					criteria.andIdIn(idlist);
				}
				List<ZyhPolicy> retlist = 
						policyService.findPolicyList(example);
				map.put("result", retlist);
			}else if("2".equals(lanmu.getType())){
				ZyhClassCourseExample example = new ZyhClassCourseExample();
				example.setOrderByClause("createtime desc");
				com.zyh.entity.classcourse.ZyhClassCourseExample.Criteria criteria = 
						example.createCriteria();
				criteria.andIfgroundEqualTo("1");
				if(null!=lanmu.getArtid()&&!"".equals(lanmu.getArtid())){
					String[] ids = lanmu.getArtid().split(";");
					List<String> idlist = Arrays.asList(ids);
					criteria.andIdIn(idlist);
				}
				List<ZyhClassCourse> retlist = 
						classCourseService.findCourseList(example);
				map.put("result", retlist);
			}else{
				responeToWeb.setMsg("类型信息错误");
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
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

package com.zyh.controller.bulletin;

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
import com.zyh.controller.bulletin.vo.BulletinQueryVO;
import com.zyh.entity.bulletin.ZyhBulletin;
import com.zyh.entity.bulletin.ZyhBulletinExample;
import com.zyh.entity.bulletin.ZyhBulletinExample.Criteria;
import com.zyh.entity.common.Page;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.usercollect.ZyhUserCollect;
import com.zyh.entity.usercollect.ZyhUserCollectExample;
import com.zyh.service.bulletin.IBulletinService;
import com.zyh.service.usercollect.IUserCollectService;


@RestController
@RequestMapping("/bulletin")
public class BulletinController {
	
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IBulletinService bulletinService;  
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addBulletin.do")
	public ResponeToWeb addBulletin(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhBulletin Bulletin = om.readValue(json, ZyhBulletin.class);
			if (null != Bulletin) {
				Bulletin.setPubtime(new Date());
				bulletinService.addBulletin(Bulletin);
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
	@RequestMapping("/updateBulletin.do")
	public ResponeToWeb updateBulletin(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhBulletin Bulletin = om.readValue(json, ZyhBulletin.class);
			if (null != Bulletin && null!=Bulletin.getId() && !"".equals(Bulletin.getId())) {
				bulletinService.updateBulletin(Bulletin);
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
	
	
	@RequestMapping("/deleteBulletin.do")
	public ResponeToWeb deleteBulletin(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				bulletinService.deleteBulletin(id);
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
	
	/**
	 * 如果传入userid，返回用户是否收藏
	 * @param json
	 * @return
	 */
	@RequestMapping("/findBulletinById.act")
	public ResponeToWeb findBulletinById(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				ZyhBulletin Bulletin = bulletinService.queryBulletinById(id);
				map.put("result", Bulletin);
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
	
	
	@RequestMapping("/findBulletinList.act")
	public ResponeToWeb findBulletinList(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//标题查询
			String title="";
			if(null!=json && !"".equals(json)){
				JsonNode node = om.readTree(json);
				if(null!=node.get("title") && !"".equals(node.get("title"))){
					title =  node.get("title").asText();
				}
			}
			ZyhBulletinExample zyhBulletinExample = new ZyhBulletinExample();
			zyhBulletinExample.setOrderByClause("pubtime desc");
			//上架才允许查
			Criteria criteria = zyhBulletinExample.createCriteria();
			criteria.andIfsendEqualTo(true);
			if(null!=title && "" !=title){
				criteria.andTitleLike("%"+title+"%");
			}
			List<ZyhBulletin> Bulletinlist =bulletinService.findBulletinList(zyhBulletinExample);
			map.put("result", Bulletinlist);
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
	
	@RequestMapping("/findBulletinListToHome.act")
	public ResponeToWeb findBulletinListToHome() {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhBulletinExample zyhBulletinExample = new ZyhBulletinExample();
			zyhBulletinExample.setOrderByClause("pubtime desc");
			Criteria criteria = zyhBulletinExample.createCriteria();
			criteria.andIfhomeEqualTo("1");
			criteria.andIfsendEqualTo(true);
			List<ZyhBulletin> Bulletinlist = bulletinService.findBulletinList(zyhBulletinExample);
			map.put("result", Bulletinlist);
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
	
	
	
	@RequestMapping("/findBulletinByPage.do")
	public ResponeToWeb findBulletinByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BulletinQueryVO queryvo = om.readValue(json, BulletinQueryVO.class);
			ZyhBulletinExample zyhBulletinExample = new ZyhBulletinExample();
			Criteria criteria = zyhBulletinExample.createCriteria();
			if(null!=queryvo.getTitle() && "" !=queryvo.getTitle()){
				criteria.andTitleLike("%"+queryvo.getTitle()+"%");
			}
			if(null!=queryvo.getCreateuser() && "" !=queryvo.getCreateuser()){
				criteria.andCreateuserLike("%"+queryvo.getCreateuser()+"%");
			}
			Map retmap = 
					bulletinService.findBulletinListByPage(zyhBulletinExample, 
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
}

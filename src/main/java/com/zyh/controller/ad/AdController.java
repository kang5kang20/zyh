package com.zyh.controller.ad;

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
import com.zyh.controller.ad.vo.AdQueryVO;
import com.zyh.entity.ad.ZyhAd;
import com.zyh.entity.ad.ZyhAdExample;
import com.zyh.entity.ad.ZyhAdExample.Criteria;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.usercollect.ZyhUserCollect;
import com.zyh.entity.usercollect.ZyhUserCollectExample;
import com.zyh.service.ad.IAdService;

@RestController
@RequestMapping("/ad")
public class AdController {
	
	
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IAdService adService;  
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addAd.do")
	public ResponeToWeb addAd(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhAd Ad = om.readValue(json, ZyhAd.class);
			if (null != Ad) {
				Ad.setCreatetime(new Date());
				adService.addAd(Ad);
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
	@RequestMapping("/updateAd.do")
	public ResponeToWeb updateAd(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhAd Ad = om.readValue(json, ZyhAd.class);
			if (null != Ad && null!=Ad.getId() && !"".equals(Ad.getId())) {
				adService.updateAd(Ad);
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
	
	
	@RequestMapping("/deleteAd.do")
	public ResponeToWeb deleteAd(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				adService.deleteAd(id);
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
	@RequestMapping("/findAdById.act")
	public ResponeToWeb findAdById(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			AdQueryVO queryvo = om.readValue(json, AdQueryVO.class);
			if (null != queryvo.getAdid() && !"".equals(queryvo.getAdid())) {
				ZyhAd Ad = adService.queryAdById(queryvo.getAdid());
				map.put("result", Ad);
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
	
	
	@RequestMapping("/findAdList.act")
	public ResponeToWeb findAdList(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			AdQueryVO queryvo = om.readValue(json, AdQueryVO.class);
			ZyhAdExample zyhAdExample = new ZyhAdExample();
			zyhAdExample.setOrderByClause("createtime desc");
			//上架才允许查
			Criteria criteria = zyhAdExample.createCriteria();
			if(null!=queryvo){
				if(null!=queryvo.getTitle() && "" !=queryvo.getTitle()){
					criteria.andTitleLike("%"+queryvo.getTitle()+"%");
				}
				if(null!=queryvo.getCreateuser() && "" !=queryvo.getCreateuser()){
					criteria.andCreateuserLike("%"+queryvo.getCreateuser()+"%");
				}
				if(null != queryvo.getIfground() && "" !=queryvo.getIfground()){
					if("1".equals(queryvo.getIfground())){
						criteria.andIfgroundEqualTo(true);
					}else if("0".equals(queryvo.getIfground())){
						criteria.andIfgroundEqualTo(false);
					}
				}
			}
			List<ZyhAd> Adlist = adService.findAdList(zyhAdExample);
			map.put("result", Adlist);
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
	
	
	
	@RequestMapping("/findAdByPage.do")
	public ResponeToWeb findAdByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			AdQueryVO queryvo = om.readValue(json, AdQueryVO.class);
			ZyhAdExample zyhAdExample = new ZyhAdExample();
			Criteria criteria = zyhAdExample.createCriteria();
			if(null!=queryvo.getTitle() && "" !=queryvo.getTitle()){
				criteria.andTitleLike("%"+queryvo.getTitle()+"%");
			}
			if(null!=queryvo.getCreateuser() && "" !=queryvo.getCreateuser()){
				criteria.andCreateuserLike("%"+queryvo.getCreateuser()+"%");
			}
			if(null != queryvo.getIfground() && "" !=queryvo.getIfground()){
				if("1".equals(queryvo.getIfground())){
					criteria.andIfgroundEqualTo(true);
				}else if("0".equals(queryvo.getIfground())){
					criteria.andIfgroundEqualTo(false);
				}
			}
			Map retmap = 
					adService.findAdListByPage(zyhAdExample, 
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

package com.zyh.controller.usercollect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.controller.usercollect.vo.UserCollectSearchVO;
import com.zyh.dao.news.ZyhNewsMapper;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.news.ZyhNewsExample;
import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.usercollect.ZyhUserCollect;
import com.zyh.entity.usercollect.ZyhUserCollectExample;
import com.zyh.entity.usercollect.ZyhUserCollectExample.Criteria;
import com.zyh.service.news.INewsService;
import com.zyh.service.policy.IPolicyService;
import com.zyh.service.usercollect.IUserCollectService;

@RestController
public class UserCollectController {
	
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IUserCollectService userCollectService;  
	
	@Autowired
	private INewsService newsService;
	
	@Autowired
	private IPolicyService policyService;
	
	/**
	 * 收藏文章
	 * @param json
	 * @return
	 */
	@RequestMapping("/addUserCollect.do")
	public ResponeToWeb addUserCollect(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhUserCollect usercollect = om.readValue(json, ZyhUserCollect.class);
			if (null != usercollect) {
				userCollectService.addUserCollect(usercollect);
				responeToWeb.setMsg("收藏成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(null);
			} else {
				responeToWeb.setMsg("收藏失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("收藏失败：" + e.getMessage());
			responeToWeb.setMsg("收藏失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/delUserCollect.do")
	public ResponeToWeb delUserCollect(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			String usercollectid = om.readValue(json, String.class);
			if (null != usercollectid && !"".equals(usercollectid)) {
				userCollectService.deleteUserCollect(usercollectid);
				responeToWeb.setMsg("取消收藏成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(null);
			} else {
				responeToWeb.setMsg("取消收藏失败,信息缺失");
				responeToWeb.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("取消收藏失败：" + e.getMessage());
			responeToWeb.setMsg("取消收藏失败");
			responeToWeb.setSuccess(false);
		}
		return responeToWeb;
	}
	
	
	/**
	 * 查询用户收藏的文章
	 * @param json
	 * @return
	 */
	@RequestMapping("/findUserCollectList.do")
	public ResponeToWeb findUserCollectList(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//标题查询
			String userid = om.readValue(json, String.class);
			ZyhUserCollectExample zyhUserCollectExample = new ZyhUserCollectExample();
			zyhUserCollectExample.setOrderByClause("arttype,pubtime desc");
			Criteria criteria = zyhUserCollectExample.createCriteria();
			criteria.andUseridEqualTo(userid);
			List<ZyhUserCollect> collectlist = userCollectService.findUserCollectList(zyhUserCollectExample);
			map.put("result", collectlist);
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
	 * 查询用户收藏的文章
	 * @param json
	 * @return
	 */
	@RequestMapping("/findUserCollectById.do")
	public ResponeToWeb findUserCollectById(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		List retlist = new ArrayList();
		try {
			UserCollectSearchVO searchvo = om.readValue(json, UserCollectSearchVO.class);
			if(null!=searchvo && null != searchvo.getArttype()
					&& !"".equals(searchvo.getArttype())){
				if("1".equals(searchvo.getArttype())){
					ZyhNews news = newsService.queryNewsById(searchvo.getArticleid());
					retlist.add(news);
				}else if("2".equals(searchvo.getArttype())){
					ZyhPolicy policy = policyService.findPolicyById(searchvo.getArticleid());
					retlist.add(policy);
				}else{
					responeToWeb.setMsg("查询失败,信息缺失");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				retlist.add(searchvo);
				map.put("result", retlist);
				responeToWeb.setMsg("查询成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(map);
			}else {
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
}

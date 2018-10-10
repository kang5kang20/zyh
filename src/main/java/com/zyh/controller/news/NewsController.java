package com.zyh.controller.news;

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
import com.zyh.controller.news.vo.NewsQueryVO;
import com.zyh.entity.common.Page;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.news.ZyhNewsExample;
import com.zyh.entity.news.ZyhNewsExample.Criteria;
import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.usercollect.ZyhUserCollect;
import com.zyh.entity.usercollect.ZyhUserCollectExample;
import com.zyh.service.news.INewsService;
import com.zyh.service.usercollect.IUserCollectService;


@RestController
@RequestMapping("/news")
public class NewsController {
	
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private INewsService newsService;  
	
	@Autowired
	private IUserCollectService userCollectService;
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addNews.do")
	public ResponeToWeb addNews(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhNews news = om.readValue(json, ZyhNews.class);
			if (null != news) {
				news.setPubtime(new Date());
				newsService.addNews(news);
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
	@RequestMapping("/updateNews.do")
	public ResponeToWeb updateNews(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhNews news = om.readValue(json, ZyhNews.class);
			if (null != news && null!=news.getId() && !"".equals(news.getId())) {
				newsService.updateNews(news);
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
	
	
	@RequestMapping("/deleteNews.do")
	public ResponeToWeb deleteNews(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				newsService.deleteNews(id);
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
	@RequestMapping("/findNewsById.act")
	public ResponeToWeb findNewsById(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			NewsQueryVO queryvo = om.readValue(json, NewsQueryVO.class);
			if (null != queryvo.getNewsid() && !"".equals(queryvo.getNewsid())) {
				ZyhNews news = newsService.queryNewsById(queryvo.getNewsid());
				if(null == news ){
					responeToWeb.setMsg("查询失败,信息缺失");
					responeToWeb.setSuccess(false);
				}else{
					map.put("result", news);
					if(null != queryvo.getUserid() && !"".equals(queryvo.getUserid())){
						ZyhUserCollectExample example = new ZyhUserCollectExample();
						com.zyh.entity.usercollect.ZyhUserCollectExample.Criteria criteria = example.createCriteria();
						criteria.andArticleidEqualTo(queryvo.getNewsid());
						criteria.andUseridEqualTo(queryvo.getUserid());
						List<ZyhUserCollect> collected = userCollectService.findUserCollectList(example);
						if(null!=collected && collected.size()>0){
							map.put("ifcollect", "1");
						}else{
							map.put("ifcollect", "0");
						}
					}
					responeToWeb.setMsg("查询成功");
					responeToWeb.setSuccess(true);
					responeToWeb.setValue(map);
				}
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
	
	
	@RequestMapping("/findNewsList.act")
	public ResponeToWeb findNewsList(@RequestBody String json) {
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
			ZyhNewsExample zyhNewsExample = new ZyhNewsExample();
			zyhNewsExample.setOrderByClause("pubtime desc");
			//上架才允许查
			Criteria criteria = zyhNewsExample.createCriteria();
			criteria.andIfgroundEqualTo("1");
			if(null!=title && "" !=title){
				criteria.andTitleLike("%"+title+"%");
			}
			List<ZyhNews> newslist = newsService.findNewsList(zyhNewsExample);
			map.put("result", newslist);
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
	
	@RequestMapping("/findNewsListToHome.act")
	public ResponeToWeb findNewsListToHome() {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhNewsExample zyhNewsExample = new ZyhNewsExample();
			zyhNewsExample.setOrderByClause("pubtime desc");
			Criteria criteria = zyhNewsExample.createCriteria();
			criteria.andIfhomeEqualTo("1");
			criteria.andIfgroundEqualTo("1");
			List<ZyhNews> newslist = newsService.findNewsList(zyhNewsExample);
			map.put("result", newslist);
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
	
	
	
	@RequestMapping("/findNewsByPage.do")
	public ResponeToWeb findNewsByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			NewsQueryVO queryvo = om.readValue(json, NewsQueryVO.class);
			ZyhNewsExample zyhNewsExample = new ZyhNewsExample();
			Criteria criteria = zyhNewsExample.createCriteria();
			if(null!=queryvo.getTitle() && "" !=queryvo.getTitle()){
				criteria.andTitleLike("%"+queryvo.getTitle()+"%");
			}
			if(null!=queryvo.getIfground() && "" !=queryvo.getIfground()){
				criteria.andIfgroundEqualTo(queryvo.getIfground());
			}
			if(null!=queryvo.getCreateuser() && "" !=queryvo.getCreateuser()){
				criteria.andCreateuserLike("%"+queryvo.getCreateuser()+"%");
			}
			Map retmap = 
					newsService.findNewsListByPage(zyhNewsExample, 
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

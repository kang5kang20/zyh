package com.zyh.controller.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.news.ZyhNewsExample;
import com.zyh.entity.news.ZyhNewsExample.Criteria;
import com.zyh.service.news.INewsService;


@RestController
public class NewsController {
	
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private INewsService newsService;  
	
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
			if (null != news) {
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
			String id = om.readValue(json, String.class);
			if (null != id) {
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
	
	@RequestMapping("/findNewsById.act")
	public ResponeToWeb findNewsById(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String newsid = om.readValue(json, String.class);
			if (null != newsid ) {
				ZyhNews news = newsService.findNewsById(newsid);
				map.put("result", news);
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
	
	
	@RequestMapping("/findNewsList.act")
	public ResponeToWeb findNewsList(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//标题查询
			String title = om.readValue(json, String.class);
			ZyhNewsExample zyhNewsExample = new ZyhNewsExample();
			zyhNewsExample.setOrderByClause("pubtime desc");
			if(null!=title || "" !=title){
				Criteria criteria = zyhNewsExample.createCriteria();
				criteria.andTitleLike(title);
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
	public ResponeToWeb findNewsListToHome(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ZyhNewsExample zyhNewsExample = new ZyhNewsExample();
			zyhNewsExample.setOrderByClause("pubtime desc");
			Criteria criteria = zyhNewsExample.createCriteria();
			criteria.andIfhomeEqualTo("1");
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
}

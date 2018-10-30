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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.controller.usercollect.vo.UserCollectSearchVO;
import com.zyh.dao.company.ZyhCompanyMapper;
import com.zyh.entity.classcourse.ZyhClassCourse;
import com.zyh.entity.classteacher.ZyhClassTeacher;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.company.ZyhCompany;
import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.usercollect.ZyhUserCollect;
import com.zyh.entity.usercollect.ZyhUserCollectExample;
import com.zyh.entity.usercollect.ZyhUserCollectExample.Criteria;
import com.zyh.service.classcourse.IClassCourseService;
import com.zyh.service.classteacher.IClassTeacherService;
import com.zyh.service.company.ICompanyService;
import com.zyh.service.news.INewsService;
import com.zyh.service.policy.IPolicyService;
import com.zyh.service.usercollect.IUserCollectService;

@RestController
@RequestMapping("/usercollect")
public class UserCollectController {
	
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IUserCollectService userCollectService;  
	
	@Autowired
	private INewsService newsService;
	
	@Autowired
	private IPolicyService policyService;
	
	@Autowired
	private IClassCourseService classCourseService;
	
	@Autowired
	private IClassTeacherService classTeacherService ;
	
	@Autowired
	private ICompanyService companyService;
	
	@Autowired
	private ZyhCompanyMapper zyhCompanyMapper;
	
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
			if (null != usercollect && null!=usercollect.getArticleid() &&
					!"".equals(usercollect.getArticleid()) &&
					null!=usercollect.getUserid() && !"".equals(usercollect.getUserid()) 
					&& null!=usercollect.getArttype() && !"".equals(usercollect.getArttype())) {
				//根据用户和文章的id进行查询，不允许重复收藏
				ZyhUserCollectExample example = new ZyhUserCollectExample();
				Criteria criteria = example.createCriteria();
				criteria.andArticleidEqualTo(usercollect.getArticleid());
				criteria.andUseridEqualTo(usercollect.getUserid());
				criteria.andArttypeEqualTo(usercollect.getArttype());
				List<ZyhUserCollect> collected = userCollectService.findUserCollectList(example);
				if(null!=collected && collected.size()>0){
					responeToWeb.setMsg("收藏失败,重复收藏");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				//收藏新闻文章、政策解读文章
				//收藏课程
				if("1".equals(usercollect.getArttype())){
					ZyhNews news = newsService.queryNewsForSave(usercollect.getArticleid());
					if(null!=news){
						usercollect.setImgurl((null==news.getImgurl()||"".equals(news.getImgurl()))?"":news.getImgurl());
						usercollect.setTitle(news.getTitle());
						usercollect.setPubtime(news.getPubtime());
					}else{
						responeToWeb.setMsg("收藏失败,信息缺失");
						responeToWeb.setSuccess(false);
						return responeToWeb;
					}
				}else if("2".equals(usercollect.getArttype())){
					ZyhPolicy policy = policyService.queryPolicyForSave(usercollect.getArticleid());
					if(null!=policy){
						usercollect.setImgurl((null==policy.getImgurl()||"".equals(policy.getImgurl()))?"":policy.getImgurl());
						usercollect.setTitle(policy.getTitle());
						usercollect.setPubtime(policy.getPubtime());
					}else{
						responeToWeb.setMsg("收藏失败,信息缺失");
						responeToWeb.setSuccess(false);
						return responeToWeb;
					}
				}else if("3".equals(usercollect.getArttype())){
					ZyhClassCourse course = classCourseService.queryCourseForSave(usercollect.getArticleid());
					if(null!=course){
						usercollect.setImgurl((null==course.getImgurl()||"".equals(course.getImgurl()))?"":course.getImgurl());
						usercollect.setTitle(course.getTitle());
						usercollect.setPubtime(course.getCreatetime());
					}else{
						responeToWeb.setMsg("收藏失败,信息缺失");
						responeToWeb.setSuccess(false);
						return responeToWeb;
					}
				}else if("4".equals(usercollect.getArttype())){
					ZyhCompany company = zyhCompanyMapper.selectByPrimaryKey(usercollect.getArticleid());
					if(null!=company){
						usercollect.setImgurl((null==company.getLogo()||"".equals(company.getLogo()))?"":company.getLogo());
						usercollect.setTitle(company.getName());
					}else{
						responeToWeb.setMsg("收藏失败,信息缺失");
						responeToWeb.setSuccess(false);
						return responeToWeb;
					}
				}else{
					responeToWeb.setMsg("收藏失败,信息缺失");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
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
	 * 取消收藏，可以传入收藏id或者userid加上新闻等id
	 * @param json
	 * @return
	 */
	@RequestMapping("/delUserCollect.do")
	public ResponeToWeb delUserCollect(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			UserCollectSearchVO searchvo = om.readValue(json, UserCollectSearchVO.class);
			if (null != searchvo.getUserCollectid() && !"".equals(searchvo.getUserCollectid())) {
				userCollectService.deleteUserCollect(searchvo.getUserCollectid());
				responeToWeb.setMsg("取消收藏成功");
				responeToWeb.setSuccess(true);
				responeToWeb.setValue(null);
			} else if(null != searchvo.getUserid() && 
					!"".equals(searchvo.getUserid()) && null != searchvo.getArticleid() && 
							!"".equals(searchvo.getArticleid())){
				ZyhUserCollectExample example = new ZyhUserCollectExample();
				Criteria criteria = example.createCriteria();
				criteria.andUseridEqualTo(searchvo.getUserid());
				criteria.andArticleidEqualTo(searchvo.getArticleid());
				userCollectService.deleteUserCollectByExample(example);
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
			JsonNode node = om.readTree(json);
			String userid =  node.get("userid").asText();
			if(null==userid || "".equals(userid)){
				responeToWeb.setMsg("查询失败,信息缺失");
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			ZyhUserCollectExample zyhUserCollectExample = new ZyhUserCollectExample();
			zyhUserCollectExample.setOrderByClause("arttype,pubtime desc");
			Criteria criteria = zyhUserCollectExample.createCriteria();
			criteria.andUseridEqualTo(userid);
			//收藏类似是23是收藏的课程不是文章
			criteria.andArttypeEqualTo("1");
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
	 * 查询用户收藏的课程
	 * @param json
	 * @return
	 */
	@RequestMapping("/findCollectCourseList.do")
	public ResponeToWeb findCollectCourseList(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//标题查询
			JsonNode node = om.readTree(json);
			String userid =  node.get("userid").asText();
			if(null==userid || "".equals(userid)){
				responeToWeb.setMsg("查询失败,信息缺失");
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			ZyhUserCollectExample zyhUserCollectExample = new ZyhUserCollectExample();
			zyhUserCollectExample.setOrderByClause("arttype,pubtime desc");
			Criteria criteria = zyhUserCollectExample.createCriteria();
			criteria.andUseridEqualTo(userid);
			//收藏类似是3是收藏的课程不是文章
//			criteria.andArttypeNotEqualTo("1");
			List<String> typelist = new ArrayList<String>();
			typelist.add("2");
			typelist.add("3");
			criteria.andArttypeIn(typelist);
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
	 * 查询用户收藏的课程
	 * @param json
	 * @return
	 */
	@RequestMapping("/findUserCollectById.do")
	public ResponeToWeb findUserCollectById(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserCollectSearchVO searchvo = om.readValue(json, UserCollectSearchVO.class);
			if(null!=searchvo && null != searchvo.getArttype()
					&& !"".equals(searchvo.getArttype())){
				String teacherid="";
				if("2".equals(searchvo.getArttype())){
					ZyhPolicy policy = policyService.queryPolicyById(searchvo.getArticleid());
					map.put("result", policy);
					if(null!=policy && null!=policy.getTeacherid() && !"".equals(policy.getTeacherid())){
						teacherid = policy.getTeacherid();
					}
				}else if("3".equals(searchvo.getArttype())){
					ZyhClassCourse course = classCourseService.queryCourseById(searchvo.getArticleid());
					map.put("result", course);
					if(null!=course && null!=course.getTeacherid()&& !"".equals(course.getTeacherid())){
						teacherid = course.getTeacherid();
					}
				}else{
					responeToWeb.setMsg("查询失败,信息缺失");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				if(null!=teacherid && !"".equals(teacherid)){
					//查询老师信息
					ZyhClassTeacher teacher = classTeacherService.queryTeacherById(teacherid);
					map.put("teacher", teacher);
				}
				map.put("searchvo", searchvo);
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
	
	
	/**
	 * 查询用户收藏的文章
	 * @param json
	 * @return
	 */
	@RequestMapping("/findCompanyCollectList.do")
	public ResponeToWeb findCompanyCollectList(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//标题查询
			JsonNode node = om.readTree(json);
			String userid =  node.get("userid").asText();
			if(null==userid || "".equals(userid)){
				responeToWeb.setMsg("查询失败,信息缺失");
				responeToWeb.setSuccess(false);
				return responeToWeb;
			}
			ZyhUserCollectExample zyhUserCollectExample = new ZyhUserCollectExample();
			zyhUserCollectExample.setOrderByClause("title");
			Criteria criteria = zyhUserCollectExample.createCriteria();
			criteria.andUseridEqualTo(userid);
			//收藏类似是23是收藏的课程不是文章
			criteria.andArttypeEqualTo("4");
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
}

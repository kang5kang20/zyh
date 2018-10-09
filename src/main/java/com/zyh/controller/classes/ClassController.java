package com.zyh.controller.classes;

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
import com.zyh.controller.classes.vo.CourseQueryVO;
import com.zyh.controller.classes.vo.TeacherQueryVO;
import com.zyh.controller.news.vo.NewsQueryVO;
import com.zyh.entity.classcourse.ZyhClassCourse;
import com.zyh.entity.classcourse.ZyhClassCourseExample;
import com.zyh.entity.classcourse.ZyhClassCourseExample.Criteria;
import com.zyh.entity.classteacher.ZyhClassTeacher;
import com.zyh.entity.classteacher.ZyhClassTeacherExample;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.news.ZyhNewsExample;
import com.zyh.entity.usercollect.ZyhUserCollect;
import com.zyh.entity.usercollect.ZyhUserCollectExample;
import com.zyh.service.classcourse.IClassCourseService;
import com.zyh.service.classteacher.IClassTeacherService;
import com.zyh.service.usercollect.IUserCollectService;

@RestController
@RequestMapping("/teachcourse")
public class ClassController {
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IClassTeacherService classTeacherService;  
	
	@Autowired
	private IClassCourseService classCourseService;  
	
	@Autowired
	private IUserCollectService userCollectService;
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addClassTeacher.do")
	public ResponeToWeb addClassTeacher(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhClassTeacher teacher = om.readValue(json, ZyhClassTeacher.class);
			if (null != teacher) {
				teacher.setCreatetime(new Date());
				classTeacherService.addClassTeacher(teacher);
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
	@RequestMapping("/updateClassTeacher.do")
	public ResponeToWeb updateClassTeacher(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhClassTeacher teacher = om.readValue(json, ZyhClassTeacher.class);
			if (null != teacher && null!=teacher.getId() && !"".equals(teacher.getId())) {
				classTeacherService.updateClassTeacher(teacher);
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
	
	
	@RequestMapping("/deleteClassTeacher.do")
	public ResponeToWeb deleteClassTeacher(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				ZyhClassCourseExample example = new ZyhClassCourseExample();
				Criteria criteria =example.createCriteria();
				criteria.andTeacheridEqualTo(id);
				List<ZyhClassCourse> courselist = classCourseService.findCourseList(example);
				if(null!=courselist && courselist.size()>0){
					log.error("删除失败：该老师还有课程，不允许删除" );
					responeToWeb.setMsg("删除失败：该老师还有课程，不允许删除");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}
				classTeacherService.deleteClassTeacher(id);
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
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/addClassCourse.do")
	public ResponeToWeb addClassCourse(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhClassCourse course = om.readValue(json, ZyhClassCourse.class);
			//教师必填
			if (null != course && null!=course.getTeacherid() && 
					!"".equals(course.getTeacherid())) {
				course.setCreatetime(new Date());
				classCourseService.addClassCourse(course);
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
	@RequestMapping("/updateClassCourse.do")
	public ResponeToWeb updateClassCourse(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			ZyhClassCourse course = om.readValue(json, ZyhClassCourse.class);
			if (null != course && null!=course.getId() && !"".equals(course.getId())) {
				classCourseService.updateClassCourse(course);
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
	
	
	@RequestMapping("/deleteClassCourse.do")
	public ResponeToWeb deleteClassCourse(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode node = om.readTree(json);
			String id =  node.get("id").asText();
			if (null != id && !"".equals(id)) {
				classCourseService.deleteClassCourse(id);
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
	 * 老师分页查询
	 * @param json
	 * @return
	 */
	@RequestMapping("/findTeacherByPage.do")
	public ResponeToWeb findTeacherByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			TeacherQueryVO queryvo = om.readValue(json, TeacherQueryVO.class);
			ZyhClassTeacherExample example = new ZyhClassTeacherExample();
			com.zyh.entity.classteacher.ZyhClassTeacherExample.Criteria criteria = example.createCriteria();
			if(null!=queryvo.getName() && "" !=queryvo.getName()){
				criteria.andNameLike("%"+queryvo.getName()+"%");
			}
			if(null!=queryvo.getCreateuser() && "" !=queryvo.getCreateuser()){
				criteria.andCreateuserLike("%"+queryvo.getCreateuser()+"%");
			}
			List<ZyhClassTeacher> teacherlist = 
					classTeacherService.findTeacherByPage(example, 
							queryvo.getPageNum(), queryvo.getPageSize());
			map.put("result", teacherlist);
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
	 * 课程分页查询
	 * @param json
	 * @return
	 */
	@RequestMapping("/findCourseByPage.do")
	public ResponeToWeb findCourseByPage(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			CourseQueryVO queryvo = om.readValue(json, CourseQueryVO.class);
			ZyhClassCourseExample example = new ZyhClassCourseExample();
			Criteria criteria = example.createCriteria();
			if(null!=queryvo.getTitle() && "" !=queryvo.getTitle()){
				criteria.andTitleLike("%"+queryvo.getTitle()+"%");
			}
			if(null!=queryvo.getCreateuser() && "" !=queryvo.getCreateuser()){
				criteria.andCreateuserLike("%"+queryvo.getCreateuser()+"%");
			}
			List<ZyhClassCourse> courselist = 
					classCourseService.findCourseByPage(example, 
							queryvo.getPageNum(), queryvo.getPageSize());
			map.put("result", courselist);
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
	 * 名师课堂查询列表
	 * @param json
	 * @return
	 */
	@RequestMapping("/findCourseList.act")
	public ResponeToWeb findCourseList(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			CourseQueryVO queryvo = om.readValue(json, CourseQueryVO.class);
			ZyhClassCourseExample example = new ZyhClassCourseExample();
			example.setOrderByClause("createtime desc");
			//上架才允许查
			Criteria criteria = example.createCriteria();
			criteria.andIfgroundEqualTo("1");
			if(null!=queryvo.getTitle() && "" !=queryvo.getTitle() ){
				criteria.andTitleLike("%"+queryvo.getTitle() +"%");
			}
			List<ZyhClassCourse> courselist = classCourseService.findCourseList(example);
			map.put("result", courselist);
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
	 * 查询课程详细
	 * @param json
	 * @return
	 */
	@RequestMapping("/findCourseDet.act")
	public ResponeToWeb findCourseDet(@RequestBody String json) {
		ResponeToWeb responeToWeb = new ResponeToWeb();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			CourseQueryVO queryvo = om.readValue(json, CourseQueryVO.class);
			if (null != queryvo.getCourseid() && !"".equals(queryvo.getCourseid())) {
				ZyhClassCourse course = classCourseService.queryCourseById(queryvo.getCourseid());
				if(null == course ){
					responeToWeb.setMsg("查询失败,信息缺失");
					responeToWeb.setSuccess(false);
					return responeToWeb;
				}else{
					//查询老师信息
					ZyhClassTeacher teacher = classTeacherService.queryTeacherById(course.getTeacherid());
					if(null == teacher ){
						responeToWeb.setMsg("查询失败,信息缺失");
						responeToWeb.setSuccess(false);
						return responeToWeb;
					}
					map.put("course", course);
					map.put("teacher", teacher);
					if(null != queryvo.getUserid() && !"".equals(queryvo.getUserid())){
						ZyhUserCollectExample example = new ZyhUserCollectExample();
						com.zyh.entity.usercollect.ZyhUserCollectExample.Criteria criteria = example.createCriteria();
						criteria.andArticleidEqualTo(queryvo.getCourseid());
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
}

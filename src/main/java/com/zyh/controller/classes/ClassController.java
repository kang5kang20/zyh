package com.zyh.controller.classes;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.entity.classcourse.ZyhClassCourse;
import com.zyh.entity.classcourse.ZyhClassCourseExample;
import com.zyh.entity.classcourse.ZyhClassCourseExample.Criteria;
import com.zyh.entity.classteacher.ZyhClassTeacher;
import com.zyh.entity.common.ResponeToWeb;
import com.zyh.service.classcourse.IClassCourseService;
import com.zyh.service.classteacher.IClassTeacherService;

@RestController
@RequestMapping("/teachcourse")
public class ClassController {
	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IClassTeacherService classTeacherService;  
	
	@Autowired
	private IClassCourseService classCourseService;  
	
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
	
}

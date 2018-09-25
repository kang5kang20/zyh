package com.zyh.service.classcourse;

import java.util.List;

import com.zyh.entity.classcourse.ZyhClassCourse;
import com.zyh.entity.classcourse.ZyhClassCourseExample;


public interface IClassCourseService {
	public void addClassCourse(ZyhClassCourse classCourse) throws Exception;
	
	public void updateClassCourse(ZyhClassCourse classCourse) throws Exception;
	
	public void deleteClassCourse(String courseid) throws Exception;
	
	public ZyhClassCourse findCourseById(String courseid) throws Exception;
	
	public List<ZyhClassCourse> findCourseList(ZyhClassCourseExample example) throws Exception;
}

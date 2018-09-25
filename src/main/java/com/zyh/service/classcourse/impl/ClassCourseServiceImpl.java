package com.zyh.service.classcourse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.classcourse.ZyhClassCourseMapper;
import com.zyh.entity.classcourse.ZyhClassCourse;
import com.zyh.entity.classcourse.ZyhClassCourseExample;
import com.zyh.service.classcourse.IClassCourseService;

@Service("classCourseService")
public class ClassCourseServiceImpl implements IClassCourseService {
	
	@Autowired
	private ZyhClassCourseMapper zyhClassCourseMapper;

	@Override
	public void addClassCourse(ZyhClassCourse classCourse) throws Exception {
		zyhClassCourseMapper.insertSelective(classCourse);
		
	}

	@Override
	public void updateClassCourse(ZyhClassCourse classCourse) throws Exception {
		zyhClassCourseMapper.updateByPrimaryKeySelective(classCourse);
		
	}

	@Override
	public void deleteClassCourse(String courseid) throws Exception {
		zyhClassCourseMapper.deleteByPrimaryKey(courseid);
		
	}

	@Override
	public ZyhClassCourse findCourseById(String courseid) throws Exception {
		return zyhClassCourseMapper.selectByPrimaryKey(courseid);
	}

	@Override
	public List<ZyhClassCourse> findCourseList(ZyhClassCourseExample example)
			throws Exception {
		return zyhClassCourseMapper.selectByExample(example);
	}

}

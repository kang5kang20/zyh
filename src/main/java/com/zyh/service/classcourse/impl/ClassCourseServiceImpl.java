package com.zyh.service.classcourse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.classcourse.ZyhClassCourseMapper;
import com.zyh.dao.classteacher.ZyhClassTeacherMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.classcourse.ZyhClassCourse;
import com.zyh.entity.classcourse.ZyhClassCourseExample;
import com.zyh.entity.classteacher.ZyhClassTeacher;
import com.zyh.service.classcourse.IClassCourseService;

@Service("classCourseService")
public class ClassCourseServiceImpl implements IClassCourseService {
	
	@Autowired
	private ZyhClassCourseMapper zyhClassCourseMapper;
	
	@Autowired
	private ZyhClassTeacherMapper zyhClassTeacherMapper;

	@Override
	public void addClassCourse(ZyhClassCourse classCourse) throws Exception {
		if (null ==classCourse.getId()||"".equals(classCourse.getId())) {
			String id = UUidUtil.getUUid();
			classCourse.setId(id);
		}
		//老师必须存在
		ZyhClassTeacher teacher = zyhClassTeacherMapper.selectByPrimaryKey(classCourse.getTeacherid());
		if(null==teacher){
			throw new Exception("老师不存在");
		}
		zyhClassCourseMapper.insertSelective(classCourse);
		
	}

	@Override
	public void updateClassCourse(ZyhClassCourse classCourse) throws Exception {
		if(null != classCourse.getTeacherid() && !"".equals(classCourse.getTeacherid())){
			ZyhClassTeacher teacher = zyhClassTeacherMapper.selectByPrimaryKey(classCourse.getTeacherid());
			if(null==teacher){
				throw new Exception("老师不存在");
			}
		}
		zyhClassCourseMapper.updateByPrimaryKeySelective(classCourse);
		
	}

	@Override
	public void deleteClassCourse(String courseid) throws Exception {
		zyhClassCourseMapper.deleteByPrimaryKey(courseid);
		
	}

	@Override
	public ZyhClassCourse queryCourseById(String courseid) throws Exception {
		//记录点击次数
		ZyhClassCourse course = zyhClassCourseMapper.selectByPrimaryKey(courseid);
		if(null == course || "0".equals(course.getIfground())){
			return null;
		}
		course.setReadcount(course.getReadcount()+1);
		zyhClassCourseMapper.updateByPrimaryKeySelective(course);
		return course;
	}

	@Override
	public List<ZyhClassCourse> findCourseList(ZyhClassCourseExample example)
			throws Exception {
		return zyhClassCourseMapper.selectByExample(example);
	}

	@Override
	public List<ZyhClassCourse> findCourseByPage(ZyhClassCourseExample example,
			int pageNum, int pageSize) throws Exception {
		return zyhClassCourseMapper.selectByPageNumSize(example, pageNum, pageSize);
	}

	@Override
	public ZyhClassCourse queryCourseForSave(String courseid) throws Exception {
		return zyhClassCourseMapper.selectByPrimaryKey(courseid);
	}

}

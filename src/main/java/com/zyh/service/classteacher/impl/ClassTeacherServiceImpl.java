package com.zyh.service.classteacher.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.classteacher.ZyhClassTeacherMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.classteacher.ZyhClassTeacher;
import com.zyh.entity.classteacher.ZyhClassTeacherExample;
import com.zyh.service.classteacher.IClassTeacherService;

@Service("classTeacherService")
public class ClassTeacherServiceImpl implements IClassTeacherService {
	
	@Autowired
	private ZyhClassTeacherMapper zyhClassTeacherMapper;

	@Override
	public void addClassTeacher(ZyhClassTeacher classTeacher) throws Exception {
		if (null ==classTeacher.getId()||"".equals(classTeacher.getId())) {
			String id = UUidUtil.getUUid();
			classTeacher.setId(id);
		}
		zyhClassTeacherMapper.insertSelective(classTeacher);
	}

	@Override
	public void updateClassTeacher(ZyhClassTeacher classTeacher)
			throws Exception {
		zyhClassTeacherMapper.updateByPrimaryKeySelective(classTeacher);
	}

	@Override
	public void deleteClassTeacher(String teacherid) throws Exception {
		zyhClassTeacherMapper.deleteByPrimaryKey(teacherid);
	}

	@Override
	public ZyhClassTeacher findTeacherById(String teacherid) throws Exception {
		return zyhClassTeacherMapper.selectByPrimaryKey(teacherid);
	}

	@Override
	public List<ZyhClassTeacher> findTeacherList(ZyhClassTeacherExample example)
			throws Exception {
		return zyhClassTeacherMapper.selectByExample(example);
	}

	@Override
	public List<ZyhClassTeacher> findTeacherByPage(
			ZyhClassTeacherExample example, int pageNum, int pageSize)
			throws Exception {
		return zyhClassTeacherMapper.selectByPageNumSize(example, pageNum, pageSize);
	}
	
}

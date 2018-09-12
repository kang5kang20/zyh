package com.zyh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.test.ITestDAO;
import com.zyh.service.ITestService;

/**
 * TODO
 * <p>Title: TestServiceImpl.java</p>
 * @author: zengyong
 * @date 2018年6月23日下午8:09:39
 * 
 */
@Service("testService")
public class TestServiceImpl implements ITestService{
	@Autowired
	ITestDAO testDAO;
	
	@Override
	public String test() {
		// TODO Auto-generated method stub
		return testDAO.test();
	}}

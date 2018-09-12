package com.zyh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.service.ITestService;

/**
 * TODO
 * <p>Title: TestController.java</p>
 * @author: zengyong
 * @date 2018年6月23日下午8:11:53
 * 
 */
@RestController
public class TestController {
	
	@Autowired
	ITestService testService;
	
	@RequestMapping("/test.do")
	public String Test(String id,HttpServletRequest request) {
		String str = null;
				str.substring(0, 2);
		if(id==null) {
			id="000";
		}
		System.out.println("进入方法了,id="+id);
		return testService.test()+"====id="+id;
	}
}

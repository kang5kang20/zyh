package com.zyh.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.user.ZyhUser;
import com.zyh.service.ITestService;
import com.zyh.service.user.IUserService;
import com.zyh.service.user.impl.UserServiceImpl;

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
	
	@Autowired
	IUserService userService; 
	
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
	
	@RequestMapping("/testAddUser.do")
	public String testAddUser(){
		String id = UUidUtil.getUUid();
		ZyhUser zyhUser = new ZyhUser();
		zyhUser.setOpenid("1");
		zyhUser.setPassword("2");
		zyhUser.setPhone("1");
		zyhUser.setId(id);
		try {
			userService.addUser(zyhUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}

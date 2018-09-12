package com.zyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 * <p>Title: PageController.java</p>
 * @author: zengyong
 * @date 2018年6月23日下午8:10:57
 * 
 */
@Controller
public class PageController {
	
	@RequestMapping("/toTest.do")
	public String toTest() {
		return "/index";
	}
}

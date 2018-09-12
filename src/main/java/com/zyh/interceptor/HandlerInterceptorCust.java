package com.zyh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * APP的接口拦截器
 * TODO
 * <p>Title: HandlerInterceptorCust.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * @date 2018年5月24日下午3:18:22
 * @version 1.0
 */

public class HandlerInterceptorCust implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//处理跨域问题
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow -Methods", "GET, POST");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}

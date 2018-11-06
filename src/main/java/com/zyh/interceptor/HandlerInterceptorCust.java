package com.zyh.interceptor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyh.entity.operator.ZyhOperatorRecord;
import com.zyh.service.operator.IOperatorService;

/**
 * APP的接口拦截器
 * TODO
 * <p>Title: HandlerInterceptorCust.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * @date 2018年5月24日下午3:18:22
 * @version 1.0
 */

public class HandlerInterceptorCust implements HandlerInterceptor{

	private Logger log = Logger.getLogger("error");
	
	@Autowired
	private IOperatorService operatorServiceImpl;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//处理跨域问题
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow -Methods", "GET, POST");
        try {
        	 String path = request.getServletPath();
             ZyhOperatorRecord zyhOperatorRecord = new ZyhOperatorRecord();
             zyhOperatorRecord.setRequesturl(path);
             Date date = new Date();
     		zyhOperatorRecord.setOptime(date);
     		operatorServiceImpl.addOperator(zyhOperatorRecord);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
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
//		ZyhOperatorRecord zyhOperatorRecord = new ZyhOperatorRecord();
//        try {
//			BufferedReader streamRead = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
//			StringBuilder responseStrBuilder = new StringBuilder();
//			String inputStr;
//			while ((inputStr = streamRead.readLine()) != null){
//				responseStrBuilder.append(inputStr);
//			}
//			if (null!=responseStrBuilder.toString()&&!"".equals(responseStrBuilder.toString())) {
//				ObjectMapper om = new ObjectMapper();
//				Map<String, Object> map = om.readValue(responseStrBuilder.toString(),Map.class);
//				if (null!=map.get("msg")) {
//					zyhOperatorRecord.setUserid(map.get("msg")+"");
//				}
//			}
//			Date date = new Date();
//			zyhOperatorRecord.setOptime(date);
//			operatorServiceImpl.addOperator(zyhOperatorRecord);
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
	}
	
	
}

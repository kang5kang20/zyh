package com.zyh.custException;

/**
 * 版权所有：重庆长安车联科技有限公司
 * 创建日期: 2018年4月8日 下午11:21:06
 * 创建作者：tanv
 * 类名称 ：a.java
 * 版 本：1.0
 * 功 能：a
 * 最后修改：
 * 修改记录：
 */
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * 
 * @author CatalpaFlat
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
	/** 日志log */
	private static Logger log = LoggerFactory.getLogger(CustomExceptionResolver.class);

	// 系统抛出的异常
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// handler就是处理器适配器要执行的Handler对象(只有method)
		// 解析出异常类型。
		/* 使用response返回 */
		Boolean isApp = request.getRequestURL().toString().endsWith(".do");
		response.setStatus(HttpStatus.OK.value()); // 设置状态码
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 设置ContentType
		response.setCharacterEncoding("UTF-8"); // 避免乱码
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		// 如果该 异常类型是系统 自定义的异常，直接取出异常信息。
		CustomException customException = null;
		try {
			if (ex instanceof CustomException) {
				customException = (CustomException) ex;
				// 错误信息
				response.getWriter().write(ResultUtils.error(customException.getCode(), ex.getMessage()).toString());
			} else
				response.getWriter().write(ResultUtils.error(-1, ex.getMessage()).toString());
		} catch (IOException e) {
			log.error("与客户端通讯异常:" + e.getMessage(), e);
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		if(!isApp) {
			modelAndView.setViewName("redirect:/500");
		}
		return modelAndView;
	}
}

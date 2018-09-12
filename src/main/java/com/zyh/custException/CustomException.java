package com.zyh.custException;

/**
 * 版权所有：重庆长安车联科技有限公司
 * 创建日期: 2018年4月8日 下午11:23:11
 * 创建作者：tanv
 * 类名称 ：CustomException.java
 * 版 本：1.0
 * 功 能：CustomException
 * 最后修改：
 * 修改记录：
 */
/**
 * 自定义异常类型
 * 
 * @author CatalpaFlat
 */
public class CustomException extends Exception {
	private Integer code;

	public CustomException() {
	}

	public CustomException(ResultEnum resultEnum) {
		super((resultEnum.getMsg()));
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}

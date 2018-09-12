package com.zyh.custException;

/**
 * 版权所有：重庆长安车联科技有限公司
 * 创建日期: 2018年4月8日 下午11:26:50
 * 创建作者：tanv
 * 类名称 ：ResultEnum.java
 * 版 本：1.0
 * 功 能：ResultEnum
 * 最后修改：
 * 修改记录：
 */
public enum ResultEnum {
	UNKONW_ERROR(-1, "未知错误"), SUCCESS(0, "成功"), TEST_ERRORR(100, "测试异常"),
	UNKONW_ACTION(404, "未知请求"), SERVER_ERROR(500, "内部错误"), OTHER(2, "业务异常")
	;
	private Integer code;
	private String msg;

	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}

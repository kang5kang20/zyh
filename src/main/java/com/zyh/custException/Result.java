package com.zyh.custException;

import java.util.Map;

public class Result<T> {
	private String msg="";
	private boolean success;
	private Map<String,Object> value ;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Map<String, Object> getValue() {
		return value;
	}
	public void setValue(Map<String, Object> value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ResponeToWeb [msg=" + msg + ", success=" + success + ", value="
				+ value + "]";
	}
}

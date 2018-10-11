package com.zyh.test;

import java.io.IOException;

import org.junit.Test;

import com.zyh.utils.HttpTestUtils;

public class TestPosition {

	
	@Test
	public void testPosition(){
		String request = "{\"pageNum\":1,\"size\":1}";
//		String url = "http://47.92.5.86:8080/zyh/user/login.act";
		String url = "http://127.0.0.1:8080/zyh/company/queryPosition.act";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String request = "{\"companyid\":\"11112312312\",\"compnayname\":\"有限公司\",\"positionname\":\"总经理\",\"workcity\":\"重庆\",\"minmoney\":10000,\"maxmoney\":20000}";
//		String url = "http://47.92.5.86:8080/zyh/user/login.act";
		String url = "http://127.0.0.1:8080/zyh/company/addPosition.act";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

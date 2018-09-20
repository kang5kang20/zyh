package com.zyh.test;

import java.io.IOException;

import org.junit.Test;

import com.zyh.utils.HttpTestUtils;

public class TestSms {
	@Test
	public void testSms(){
		String request = "[{\"phone\":\"1805071000509652\"}]";
		String url = "http://127.0.0.1:8080/zyh/user/sms.act";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

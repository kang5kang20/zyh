package com.zyh.test;

import java.io.IOException;

import org.junit.Test;

import com.zyh.utils.HttpTestUtils;
import com.zyh.utils.MD5Util;

public class Testlogin {

	
	@Test
	public void testLogin(){
//		String request = "[{\"userid\":\"1805071000509652\",\"username\":\"吴念\",\"userphone\":\"136456465655\",\"useradress\":\"重庆市 县 丰都县 dsgdsg\",\"addressCounty\":\"500230\",\"supplierid\":\"1805211000521690\",\"suppliername\":\"成都韩科工程机械配件公司\",\"needinvoice\":0,\"freight\":null,\"payprice\":null,\"orderDetails\":[{\"goodsid\":\"1806111000691014\",\"brandid\":\"1805211000521731\",\"saleprice\":560,\"purchasing\":550,\"count\":1,\"manufacturersid\":null,\"isenable\":0,\"popularizerate\":0.02}]},{\"userid\":\"1805071000509652\",\"username\":\"吴念\",\"userphone\":\"136456465655\",\"useradress\":\"重庆市 县 丰都县 dsgdsg\",\"addressCounty\":\"500230\",\"supplierid\":\"1805281000538760\",\"suppliername\":\"重庆德盟润滑油股份有限公司\",\"needinvoice\":0,\"freight\":0,\"payprice\":90,\"orderDetails\":[{\"goodsid\":\"1806121000695662\",\"brandid\":\"1803251000000088\",\"saleprice\":90,\"purchasing\":71,\"count\":1,\"manufacturersid\":null,\"isenable\":0,\"popularizerate\":0.02,\"logisticsprice\":0}]}]";
		String request = "{\"username\":\"zyhadmin\",\"password\":\"zyhadmin\",\"type\":\"mm\"}";
//		String url = "http://47.92.5.86:8080/zyh/user/login.act";
		String url = "http://127.0.0.1:8080/zyh/user/login.act";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String request = "{\"phone\":\"15215178931\"}";
		String url = "http://127.0.0.1:8080/zyh/user/sms.act";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

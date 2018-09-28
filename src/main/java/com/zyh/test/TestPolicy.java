package com.zyh.test;

import java.io.IOException;

import org.junit.Test;

import com.zyh.utils.HttpTestUtils;

public class TestPolicy {
	
	@Test
	public void testAddPolicy(){
		String request = "{\"createuser\":\"管理员\",\"title\":\"政策标题2\",\"content\":\"<h1>wer rewer<br/></h1><h5>ewr rwe wer r<br/></h5>\",\"imgurl\":\"/data/attchment/abc.jpg\",\"videourl\":\"/data/attchment/policy.mp4\",\"ifground\":1}";
		String url = "http://127.0.0.1:8081/zyh/policy/addPolicy.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdatePolicy(){
		String request = "{\"id\":\"aa1b0377dc9e48cbb3868b3691237ead\",\"createuser\":\"管理员\",\"title\":\"标题1\",\"content\":\"<h1>安保我问问<br/></h1><h5>ewr rwe wer r<br/></h5>\",\"imgurl\":\"/data/attchment/abc.jpg\",\"videourl\":\"/data/attchment/policy1.mp4\",\"ifground\":0}";
		String url = "http://127.0.0.1:8081/zyh/policy/updatePolicy.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdatePolicyNG(){
		String request = "{\"createuser\":\"1\",\"ifground\":1}";
		String url = "http://127.0.0.1:8081/zyh/policy/updatePolicy.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeletePolicy(){
		String request = "{\"id\":\"371cbdfd9ea9430090a1eaac9a099f30\"}";
		String url = "http://127.0.0.1:8081/zyh/policy/deletePolicy.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeletePolicyNG(){
		String request = "{\"id\":\"\"}";
		String url = "http://127.0.0.1:8081/zyh/policy/deletePolicy.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindPolicyById(){
		String request = "{\"policyid\":\"c7165a836a914285987c92e91e22cc18\"}";
		String url = "http://127.0.0.1:8081/zyh/policy/findPolicyById.act";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindPolicyByIdNG(){
		String request = "{\"id\":\"c7165a836a914285987c92e91e22cc18\"}";
		String url = "http://127.0.0.1:8081/zyh/policy/findPolicyById.act";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindPolicyList(){
		String request = "{\"title\":\"标题\"}";
		String url = "http://127.0.0.1:8081/zyh/policy/findPolicyList.act";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindPolicyList1(){
		String request = "{\"title\":\"aa\"}";
		String url = "http://127.0.0.1:8081/zyh/policy/findPolicyList.act";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindNewsListng(){
		String request = "{\"abc\":\"新闻\"}";
		String url = "http://127.0.0.1:8081/zyh/policy/findPolicyList.act";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

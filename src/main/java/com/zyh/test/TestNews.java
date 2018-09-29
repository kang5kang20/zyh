package com.zyh.test;

public class TestNews {
	
//	@Test
//	public void testAddNews(){
//		String request = "{\"createuser\":\"管理员\",\"title\":\"新闻标题\",\"content\":\"<h1>wer rewer<br/></h1><h5>ewr rwe wer r<br/></h5>\",\"imgurl\":\"/data/attchment/abc.jpg\",\"ifhome\":1,\"ifground\":1}";
//		String url = "http://127.0.0.1:8081/zyh/news/addNews.do";
//		try {
//			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
//			System.out.println(json);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testUpdateNews(){
//		String request = "{\"id\":\"3cfc12d3488849788b5a6a2fd1834b3f\",\"createuser\":\"管理员\",\"title\":\"新闻标题1\",\"content\":\"<h1>安保我问问<br/></h1><h5>ewr rwe wer r<br/></h5>\",\"imgurl\":\"/data/attchment/abc.jpg\",\"ifhome\":1,\"ifground\":0}";
//		String url = "http://127.0.0.1:8081/zyh/news/updateNews.do";
//		try {
//			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
//			System.out.println(json);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testDeleteNews(){
//		String request = "{\"id\":\"29156e28895d465bab91ac86aff618eb\"}";
//		String url = "http://127.0.0.1:8081/zyh/news/deleteNews.do";
//		try {
//			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
//			System.out.println(json);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testDeleteNewsNG(){
//		String request = "{\"id\":\"\"}";
//		String url = "http://127.0.0.1:8081/zyh/news/deleteNews.do";
//		try {
//			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
//			System.out.println(json);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testFindNewsById(){
//		String request = "{\"newsid\":\"3cfc12d3488849788b5a6a2fd1834b3f\"}";
//		String url = "http://127.0.0.1:8081/zyh/news/findNewsById.act";
//		try {
//			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
//			System.out.println(json);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testFindNewsList(){
//		String request = "{\"title\":\"新闻\"}";
//		String url = "http://127.0.0.1:8081/zyh/news/findNewsList.act";
//		try {
//			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
//			System.out.println(json);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testFindNewsList1(){
//		String request = "{\"title\":\"新闻1\"}";
//		String url = "http://127.0.0.1:8081/zyh/news/findNewsList.act";
//		try {
//			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
//			System.out.println(json);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testFindNewsListng(){
//		String request = "{\"abc\":\"新闻\"}";
//		String url = "http://127.0.0.1:8081/zyh/news/findNewsList.act";
//		try {
//			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
//			System.out.println(json);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testFindNewsListToHome(){
//		String request = "";
//		String url = "http://127.0.0.1:8081/zyh/news/findNewsListToHome.act";
//		try {
//			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
//			System.out.println(json);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
}

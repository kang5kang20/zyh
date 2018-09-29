package zyh;

import java.io.IOException;

import org.junit.Test;

import com.zyh.utils.HttpTestUtils;

public class TestClass {
	
	@Test
	public void testAddClassTeacher(){
		String request = "{\"createuser\":\"管理员\",\"name\":\"周老师\",\"introduce\":\"为人民服务\"}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/addClassTeacher.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddClassTeacherNG(){
		String request = "{\"createuser\":\"管理员\",\"introduce\":\"为人民服务\"}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/addClassTeacher.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateClassTeacher(){
		String request = "{\"id\":\"616b60eb24664623b273f06afb77e404\",\"createuser\":\"管理员\",\"name\":\"李老师\",\"introduce\":\"abc\"}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/updateClassTeacher.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateClassTeacheryNG(){
		String request = "{\"createuser\":\"1\",\"introduce\":1}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/updateClassTeacher.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteClassTeacherNG(){
		String request = "{\"id\":\"616b60eb24664623b273f06afb77e404\"}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/deleteClassTeacher.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteClassTeacher(){
		String request = "{\"id\":\"b7f4730b7bdb48bdab25df6adbdb4a36\"}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/deleteClassTeacher.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddClassCourse(){
		String request = "{\"createuser\":\"管理员\",\"title\":\"课程一\",\"content\":\"<h1>wer rewer<br/></h1><h5>ewr rwe wer r<br/></h5>\",\"imgurl\":\"/data/attchment/abc.jpg\",\"videourl\":\"/data/attchment/policy.mp4\",\"ifground\":1,\"introduce\":\"这是课程介绍\",\"teacherid\":\"616b60eb24664623b273f06afb77e404\"}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/addClassCourse.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateClassCourseNG(){
		String request = "{\"id\":\"f309044843b5487e8ab0e2e6ce1a8bbd\",\"createuser\":\"管理员\",\"title\":\"课程一\",\"content\":\"<h1>wer rewer<br/></h1><h5>ewr rwe wer r<br/></h5>\",\"imgurl\":\"/data/attchment/abc.jpg\",\"videourl\":\"/data/attchment/policy.mp4\",\"ifground\":1,\"introduce\":\"这是课程介绍\",\"teacherid\":\"123\"}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/updateClassCourse.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateClassCourse(){
		String request = "{\"id\":\"f309044843b5487e8ab0e2e6ce1a8bbd\",\"createuser\":\"管理用户\",\"title\":\"课程2\",\"content\":\"<h1>wer rewer<br/></h1><h5>ewr rwe wer r<br/></h5>\",\"imgurl\":\"/data/attchment/abc.jpg\",\"videourl\":\"/data/attchment/policy.mp4\",\"ifground\":1,\"introduce\":\"这是课程介绍\"}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/updateClassCourse.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteClassCourse(){
		String request = "{\"id\":\"74c678fdd88247c78991d0efc03122d5\"}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/deleteClassCourse.do";
		try {
			String json = HttpTestUtils.testHttpConnection(url, "POST", request);
			System.out.println(json);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteClassCourseng(){
		String request = "{\"id\":\"\"}";
		String url = "http://127.0.0.1:8081/zyh/teachcourse/deleteClassCourse.do";
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

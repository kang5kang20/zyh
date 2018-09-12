<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
  </head>
  
  <body>
    <span>请输入：</span><input type="text" id= "id" value ="0"><br>
    <input type="button" onclick="test()"><br>
    <span>结果：</span><input type="text" id= "text"><br>
  </body>
  <script >
  	function test(){
  		var id = $("#id").val();
  		$.ajax({
			url: "${pageContext.request.contextPath}/test.do",    
            dataType: "json",   
            data: {"id": id},    
            type: "GET",   
            success: function (data) {
            	$("#text").val(data)	;
            }
		});
  	}
  </script>
</html>

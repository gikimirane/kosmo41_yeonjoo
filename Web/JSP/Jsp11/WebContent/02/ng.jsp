<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet11-2</title>
	</head>
	<body>
	
	<%!
		int age;
	%>
	
	<%
		String str = request.getParameter("age");
		age = Integer.parseInt(str);
	%>
	
	안타깝지만.. 당신은 깔라만시 소주를 마실수 없어욤 ;_;
	
	<br />
	<a href="requestex.html">처음으로 이동</a>
	
	</body>
</html>
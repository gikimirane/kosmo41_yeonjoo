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

	오~ 당신은 맛있는 깔라만시소주를 마실수 있어용♥
	
	<br />
	<a href="requestex.html">처음으로 이동</a>
	
	</body>
</html>
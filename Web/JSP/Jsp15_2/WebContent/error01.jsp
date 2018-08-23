<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet 15-1</title>
	</head>
	<body>
		<%-- 500 에러를 발생시킴 --%>
		<%
			int i = 40/0;
		%>
	</body>
</html>
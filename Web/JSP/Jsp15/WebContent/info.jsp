<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet 15-1</title>
	</head>
	<body>
		<%-- 에러를 일부러 발생시킴 --%>
		<%
			int i = 40/0;
		%>
	</body>
</html>
<%-- 주석 : JSP 주석의 경우 페이지 소스를 봐도 주석이 보이지 않음 --%>

<%@ page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet10-2</title>
	</head>
	<body>

		<!--  <h1> 여기는 HTML 주석 입니다. </h1> -->
		<h1> 여기는 HTML 주석이 아닌 부분입니다. </h1>
		
		<%-- 여기는 JSP 주석입니다. (웹브라우저 소스보기에서 보이지 않음) --%>
		여기는 JSP 주석이 아닌 부분입니다.
	</body>
</html>
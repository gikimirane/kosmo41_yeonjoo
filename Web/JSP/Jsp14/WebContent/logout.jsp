<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet 14-2</title>
	</head>
	<body>
		
		<%-- invalidate() : 세션에서 특정 데이터 제거 --%>
		<%	
	
		session.invalidate();
		
		response.sendRedirect("login.html");
		
		%>
	
	</body>
</html>
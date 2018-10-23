<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
	* {
			background-color: black;
			font-size: large; font-family: fantasy; 
			color: pink;
		}
	</style>	
</head>
<body>
	
	<a href="insert.do">insert</a>
	<hr />
	<a href="http://localhost:8081<%=request.getContextPath() %>/update.do">update</a>
	<hr />
	<a href="http://localhost:8081/jsp25_1/select.do">select</a>
	<hr />
	<a href="<%=request.getContextPath() %>/delete.do">delete</a>
</body>
</html>
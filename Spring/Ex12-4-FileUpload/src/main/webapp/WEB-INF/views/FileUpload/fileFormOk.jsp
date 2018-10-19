<%@page import="java.util.Enumeration" %>
<%@page import="com.oreilly.servlet.multipart.DefauliFileRenamePolicy" %>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getRealPath("resources/fileFolder");
	out.println(path);

%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>fileFormOk</title>
	</head>
	<body>
		fileFormOk.jsp
	</body>
</html>
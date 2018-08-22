<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet09_4</title>
</head>
<body>
<%

	String max = request.getParameter("max");
	if(max != null) {	
		int maxvalue = Integer.parseInt(max);
		
		for(int i=0; i<maxvalue; i++){
			out.println(i + "<br>");
		}
	} else {
		out.println("<h1>You must set 'max' parameter!!</h1>");
	}
	
%>
</body>
</html>
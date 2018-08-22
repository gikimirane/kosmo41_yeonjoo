<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet09_5</title>
</head>
<body>

<%-- 스크립트릿( <% 코드 %> ) 자바코드 사용을 위한 방식 --%>

<%
	int i = 0;
	while(true){
		i++;
		out.println("2 *" + i + " = " + (2*i) + "<br />");
%>
  =======<br />
<%
		if(i >= 9)break;
	}
%>

</body>
</html>
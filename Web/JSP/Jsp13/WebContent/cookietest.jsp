<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet 13-2</title>
	</head>
	<body>
		<%-- getName() : 쿠키 이름을 얻습니다.
			 getValue() : 쿠키의 값을 얻습니다. --%>
		<%
			Cookie[] cookies = request.getCookies();
			
			if(cookies != null){
				for(int i=0; i<cookies.length; i++) {
					out.println(cookies[i].getName() + " : " +
								cookies[i].getValue() + "<br>");
				}
			}

		%>
			
	</body>
</html>
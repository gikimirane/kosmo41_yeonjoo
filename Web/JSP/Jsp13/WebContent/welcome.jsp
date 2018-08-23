<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet 13-2</title>
	</head>
	<body>
		
		<%-- setMaxAge() : 쿠키의 유효기간을 설정
		     addCookie : 쿠키를 생성 --%>
		     
		<%
			Cookie[] cookies = request.getCookies();
			
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("id")) {
				String id = cookies[i].getValue();
				out.println(id + "님 안녕하세요!" + "<br>");
				}
			}
		
		%>
		
		<a href="logout.jsp"> 로그아웃 </a>
		
		<br />
		<a href="cookietest.jsp"> 쿠키테스트 </a>
		
	</body>
</html>
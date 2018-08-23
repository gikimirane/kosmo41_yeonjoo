<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet 13-2</title>
	</head>
	<body>
		
		<%-- 전역변수 선언 --%>
		<%!
			String id,pw, name;
		%>
		
		<%-- setMaxAge() : 쿠키의 유효기간을 설정
		     addCookie : 쿠키를 생성 --%>
		<%
			request.setCharacterEncoding("UTF-8");
		
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			name = request.getParameter("name");
			
			if(id.equals("abcde") && pw.equals("12345")) {
				Cookie cookie = new Cookie("id",id);
				cookie.setMaxAge(60);
				response.addCookie(cookie);
				
				Cookie cookie2 = new Cookie("name",name);
				cookie2.setMaxAge(60);
				response.addCookie(cookie2);
				
				response.sendRedirect("welcome.jsp");
			} else {
				response.sendRedirect("login.html");
			}
		%>
		
	</body>
</html>
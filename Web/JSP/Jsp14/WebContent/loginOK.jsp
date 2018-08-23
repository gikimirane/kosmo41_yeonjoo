<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet 14-2</title>
	</head>
	<body>
		
		<%-- 전역변수 선언 --%>
		<%!
			String id, pw, name;
		%>
		
		<%-- setAttribute : 세션에 데이터를 저장 
			 setMaxInactiveInterval : 세션의 유효시간을 설정(60 << 1분) --%>
		<%
			request.setCharacterEncoding("UTF-8");
		
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			name = request.getParameter("name");
			
			if(id.equals("abcde") && pw.equals("12345")) {
				session.setAttribute("id",id);
				session.setAttribute("name",name);	
				
				session.setMaxInactiveInterval(60 * 10);
				
				response.sendRedirect("welcome.jsp");
			} else {
				response.sendRedirect("login.html");
			}
		%>
		
	</body>
</html>
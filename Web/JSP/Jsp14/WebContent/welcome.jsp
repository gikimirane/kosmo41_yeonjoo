<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet 14-2</title>
	</head>
	<body>
		
		<%-- getAttribute:세션에서 데이터를 얻기
			response.sendRedirect("다음연결페이지") : 원하는 페이지로 넘김 --%>
	
		<%
			request.setCharacterEncoding("UTF-8");
			
			Object obj1 = session.getAttribute("id");
			String myId = (String)obj1;	
			
			if(myId == null) {
				response.sendRedirect("login.html");
			} else {
			out.println(myId + "님 로그인을 환영해요♥" + "<br>");
			}
		%> 
		
		<br><p>
		
		<a href="logout.jsp"> 로그아웃 </a> <br><p>
		
		<a href="sessiontest.jsp"> 세션 테스트 </a>
		
	</body>
</html>
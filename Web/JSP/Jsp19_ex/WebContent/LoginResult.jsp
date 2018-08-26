<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%!
    	String name, id, pw;
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>19 ex 로그인성공</title>
	</head>
	<body>
			
		<%
			request.setCharacterEncoding("UTF-8");
			
			Object obj = session.getAttribute("id");
			String Id = (String)obj;	
			
			if(Id == null) {
				response.sendRedirect("login.jsp");
			} else {
			out.println(Id + "님 로그인을 환영해요♥" + "<br>");
			}
		%> 
			
		
		<a href="modify.jsp">회원정보 수정</a> <br><p>
		
		<a href="sessiontest.jsp"> 세션 테스트 </a>
		
	</body>
</html>
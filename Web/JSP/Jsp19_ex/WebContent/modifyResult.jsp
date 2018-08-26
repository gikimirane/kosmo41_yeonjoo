<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>19 ex 정보수정완료</title>
	</head>
	<body>
		
		<%
			request.setCharacterEncoding("UTF-8");
			
			Object obj = session.getAttribute("id");
			String Id = (String)obj;	
			
			if(Id == null) {
				response.sendRedirect("login.jsp");
			} else {
				
			out.println(Id + "님 회원정보 수정이 완료되었습니다.♥" + "<br>");
			}
		%> 
		
		<a href="logout.jsp">로그아웃</a> &nbsp;&nbsp; <a href="modify.jsp">정보수정</a> 
		
	</body>
</html>
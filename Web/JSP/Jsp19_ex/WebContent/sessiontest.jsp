<%@ page import = "java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>19 ex 세션테스트</title>
	</head>
	
	<%! 
		String key, value; %>
	
	<body>
		
		<%
		request.setCharacterEncoding("UTF-8");
		
		out.println("********************* <br>");
		
		Enumeration enumeration = session.getAttributeNames();
		
		int i = 0;
		
		while(enumeration.hasMoreElements()){
		
			i++;
			
			key = enumeration.nextElement().toString();
			value = session.getAttribute(key).toString();
			
			out.println(key + " : " + value + "<br>");
		}
		
		
		if(i == 0) {
			out.println("해당 세션이 삭제 되었습니다. <br>");
	
		}
	
		out.println("********************* <br>");
		
		%>
		<a href="modify.jsp">회원정보 수정</a><p>
		<a href="logout.jsp">로그아웃</a><p>	
	</body>
</html>
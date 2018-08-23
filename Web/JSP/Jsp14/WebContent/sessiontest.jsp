<%@ page import = "java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet 14-1</title>
	</head>
	<body>
		
		<%-- getAttributeNames() : 세션에 저장되어 있는 모든 데이터의 
								  이름(유니크한 키값)을 얻습니다 
			※ Enumeration : 순서를 가지고 있는 배열의 한 종류 동작방법은 
							nextElement()메소드를 만나면 객체를 가져와서 하나의 열거형요소로 생성을 한다    --%>
		<%
		
		request.setCharacterEncoding("UTF-8");
		
		out.println("********************* <br>");
		
		String myId;
		String myName;
		
		Enumeration enumeration = session.getAttributeNames();
		
		int i = 0;
	
		while(enumeration.hasMoreElements()){
			i++;
			
			myId = enumeration.nextElement().toString();
			myName = session.getAttribute(myId).toString();
			
			out.println("ID  : " + myId + "<br>");
			out.println("NAME : " + myName + "<br>");
		}
		
		if(i == 0)
			out.println("해당 세션이 삭제 되었습니다.");
		
		out.println("********************* <br>");
		
		String sessionID = session.getId();
		out.println("sessionID : " + sessionID + "<br>");
		int sessionInter = session.getMaxInactiveInterval();
		out.println("sessionInter : " + sessionInter + "<br>");
		
		out.println("********************* <br>");
		
		%>
		
		<%-- 

		Object obj1 = session.getAttribute("id");
		String myId = (String)obj1;
		out.println("ID  : " + myId + "<br>");
		
		Object obj2 = session.getAttribute("name");
		String myName = (String)obj2;
		out.println("NAME : " + myName + "<br>");
		
		out.println("********************* <br>");

		--%>
			
	</body>
</html>
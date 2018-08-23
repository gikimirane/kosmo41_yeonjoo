<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet11-1</title>
	</head>
	<body>
		<%!
			String num1, num2, calc;
			
			int num11, num22;
			int result = 0;
		%>
		<%	
		
			num1 = request.getParameter("num1");
			num2 = request.getParameter("num2");
			calc = request.getParameter("calc");
	
		try {
				num11 = Integer.parseInt(num1); 
				num22 = Integer.parseInt(num2);
				
			} catch (NumberFormatException ne) {
		%>
				<h1> 숫자를 입력해 주세요♥ </h1>
		<%		
			}
		%>
		
		<% 
			if(calc.equals("+")) { 
				result = num11 + num22;
				} else if(calc.equals("-")) {
					result = num11 - num22;
				} else if(calc.equals("*")) {
					result = num11 * num22;
				} else if(calc.equals("/")) {
					result = num11 / num22;
				}
				
		%>
		
		연산결과는 <%= result %> 입니다. <br />
	
	</body>
</html>
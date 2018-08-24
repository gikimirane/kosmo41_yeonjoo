<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet19-1</title>
	</head>
	<body>
	
		<form action="JoinProcess" method="post">
			아&nbsp;이&nbsp;디 : <input type="text" name="id" size="10"><br/>
			비밀번호 : <input type="text" name="pw" size="10"><br/>
			이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름 : <input type="text" name="name" size="10"><br/>
			전화번호 :  <select name="phone1">
			 	<option value="010" selected="selected">010</option>
			 	<option value="016">016</option>
			 	<option value="017">017</option>
			 	<option value="018">018</option>
			 	<option value="019">019</option>
			 	<option value="011">011</option>
			 </select> - 
			 <input type="text" name="phone2" size="5"> -
			 <input type="text" name="phone3" size="5"> <br>
			성별구분 : <input type="radio" name="gender" value="woman"> 여 &nbsp;
					   <input type="radio" name="gender" value="man"> 남 <br>
			 <input type="submit" value="회원가입"><input type="reset" value="취소">	 
		</form>
		
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet 22-2</title>
	</head>
	<body>
	
		<form action="fileFormOK.jsp" method="post" enctype="multipart/form-data">
			파일 : <input type="file" name="filename"><br />
			 <input type="submit" value="file Upload">
		</form>
		
</body>
</html>
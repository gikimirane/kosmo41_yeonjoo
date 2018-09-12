<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% if(session.getAttribute("ValidMem") != null) { %>
	<jsp:forward page="main.jsp"></jsp:forward>
<% } %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> JAM#1♥ LOGIN </title>
		
		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<style>
		.test1 {
	
		}
		</style>
	</head>
	
	<%@ include file="header.jsp" %>
	
	<body>
		<p></p>
		<div class="container">
			<table class="table table-bordered width=40%">
			<form action="loginOK.do" method="post">
				<div class="form-group">
  					<label for="id"> 아이디 </label>
  					<input type="text" class="form-control" id="id" name="id" aria-describedby="emailHelp" placeholder="id" 
  					       value="<% if(session.getAttribute("id") != null) 
									    out.println(session.getAttribute("id"));
									%>">
  				</div>
			 <div class="form-group">
  		     	<label for="password"> 비밀번호 </label>
    		 	<input type="password" class="form-control" id="pw" name="pw" placeholder="Password">
			 </div>
		
			 	<button type="submit" class="btn btn-dark"  value="로그인"> 로그인 </button>&nbsp;&nbsp;
			 	<button type="button" class="btn btn-primary" value="회원가입" onclick="javascript:window.location='join.jsp'"> 회원가입 </button>	
			<p></p>
			</form>
			</table>
		</div>
</body>

<%@ include file="footer.jsp" %>

</html>
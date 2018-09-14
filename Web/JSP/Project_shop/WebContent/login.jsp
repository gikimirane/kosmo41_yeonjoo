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
			a:link { color:#000000; text-decoration:none;}
			a:visited { color:#000000; text-decoration:none;}
			a:active { color:#0000000; text-decoration:none;}
 			a:hover { color:#000000; text-decoration:none;}
		
			div.col-sm-10 { 
			width:100%;
			height:90%;
			margin:20%;
			}
		</style>
	</head>
	
	<%@ include file="header.jsp" %>
	
	<body>
		<p></p>
		<div class="container">
		<div class="col-sm-10">
			<div class="col-md-10 col-md-offset-3 col-sm-8 col-sm-offset-2">
		
			<img src="./img/lock.png" width="128px" alt="loginpage" class="img-responsive center-block" />
			<hr style="border:dashed 1px; color:#007BFF;">
			
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
			 <div style="text-align:center;">
			 	<button type="submit" class="btn btn-primary"  value="로그인"> 로그인 </button>&nbsp;&nbsp;
			 	<button type="button" class="btn btn-dark" value="회원가입" onclick="javascript:window.location='join.jsp'"> 회원가입 </button>	
			</div>
			<p></p>
			</form>
			
			<hr style="border:dashed 1px; color:#007BFF;">
			</div>
		</div>
</body>

<%--@ include file="footer.jsp" --%>

</html>
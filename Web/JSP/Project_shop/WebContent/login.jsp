<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% if(session.getAttribute("ValidMem") != null) { %>
	<jsp:forward page="main.jsp"></jsp:forward>
<% } %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>프로젝트_로그인</title>
		<!-- Required meta tags -->
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<!-- Bootstrap CSS -->
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<style>
			body {
		        background: #f8f8f8;
		        padding: 60px 0;
		    }
		    
		    #login-form > div {
		        margin: 15px 0;
		    }
		</style>
</head>
		
	</head>
	<body>
	
	<div class="container">
    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-success">
            <div class="panel-heading">
                <div class="panel-title"><p>I AM 에 오신 것을 환영합니다♥</p></div>
            </div>
            <div class="panel-body">
                <form action="loginOK.do"  method="post" >
                    <div>
                        <input type="text" class="form-control" name="bId" placeholder="ID" autofocus 
                        	   value="<% if(session.getAttribute("id") != null) 
										out.println(session.getAttribute("id"));
									%>"> 
                    </div>
                    <div>
                       <p><input type="password" class="form-control" name="bPw" placeholder="Password"></p>
                    </div>
                    <div>
                        <button type="submit" class="form-control btn btn-primary">로그인</button>
                        </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
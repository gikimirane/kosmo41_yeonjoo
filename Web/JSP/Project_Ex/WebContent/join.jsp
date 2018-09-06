<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> JAM#1♥ JOIN </title>
		
		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		
		<script language="JavaScript" src="members.js"></script>
		
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
	  	    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	        <div class="panel panel-success">
	            <div class="panel-heading">
	            <p></p>
	                <div class="panel-title"><p> ♥회원가입을 하시면 더 많은 정보를 보실 수 있습니다♥ </p></div>
	            </div>
	            <form action="joinOK.do" method="post" name="reg_frm">
	             <div class="form-group">
  		     		<label for="id"> 아이디 </label>
    		 		<input type="text" class="form-control" id="id" name="id" placeholder="id를 입력해 주세요">
				 </div>
				<div class="form-group">
  		     		<label for="password"> 비밀번호 </label>
    		 		<input type="password" class="form-control" id="pw" name="pw" placeholder="Password를 입력해 주세요">
			 	</div>
			 	<div class="form-group">
  		     		<label for="pw_check"> 비밀번호 </label>
    		 		<input type="password" class="form-control" id="pw_check" name="pw_check" placeholder="Password를 한번 더 입력해 주세요">
			 	</div>
				<div class="form-group">
  		     		<label for="name"> 이름 </label>
    		 		<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력해 주세요">
				 </div>
				<div class="form-group">
  		     		<label for="email"> 메일 </label>
    		 		<input type="text" class="form-control" id="eMail" name="email" placeholder="메일을 입력해 주세요">
				 </div>		
				<div class="form-group">
  		     		<label for="address"> 주소 </label>
    		 		<input type="text" class="form-control" id="address" name="address" placeholder="주소를 입력해 주세요">
				 </div>		
					<input type="button" class="btn btn-primary"  value="회원가입" onclick="infoConfirm()"></button>
					</form>
						<p></p>
			</table>
		</div>
	
	</body>
	
	<%@ include file="footer.jsp" %>
	
</html>
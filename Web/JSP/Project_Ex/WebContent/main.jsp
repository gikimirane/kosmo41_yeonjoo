<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% if(session.getAttribute("ValidMem") == null) { %>
	<jsp:forward page="login.jsp" />
<% 
	}

	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> I AM♥ main </title>
		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		   <style>
			div {
				border:1px solid #000040;
				padding:5px; margin:5px;
				text-align:center;
			}
			#wrap {
				width:780px;
				overflow:hidden;
			}
			
			#content {
				width:600px; height:305px;
				float:left;
			}
			
			#login {
				width:135px; height:140px;
				float:left;
			}
			
			#banner {
				width:135px; height:140px;
				float:left;
			}
		   </style>
	</head>
		<%@ include file="header.jsp" %>
	<body>
		<div id="wrap">
			<div id="content"> CONTENT </div>
			<div id="login"> 
				<div class="container">
			    	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			        <div class="panel panel-success">
			            <div class="panel-heading">
            		<p></p>
            		  <div class="panel-body">
             		   <form action="loginOK.do"  method="post" >
				<%
					request.setCharacterEncoding("UTF-8");
					
					Object obj = session.getAttribute("id");
					String Id = (String)obj;	
					
					if(Id == null) {
						out.println("로그인을 해 주세요♥ <br>");
					} else {
						out.println(Id + "님 로그인을 환영해요♥" + "<br>"); %>
		
						<form action="logout.do" method="post">
							 <input type="submit" value="로그아웃">&nbsp;&nbsp;
							 <input type="button" value="정보수정" 
							 		onclick="javascript:window.location='modify.jsp'">	
						</form>
				<% } %>
			</div>
			</form>
			<div id="banner"> BANNER </div>
		</div> 
            </div>
        	</div>
    	</div>	
		</div>
	</body>
		<%@ include file="footer.jsp" %>
</html>
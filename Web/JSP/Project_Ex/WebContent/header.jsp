<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> HEADER </title>

		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<style>
			.navbar-inner {
			backgrond : transparent;
			} 
		</style>
	</head>
	<body>
		<nav class="navbar navbar-expand-sm fixed-top">
		  <a class="navbar-brand" href="main.jsp"><h3>Shooting Star</h3></a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		       <a class="nav-link" href="main.jsp"><img src="./img/home.png" title="home" /></a>
		      </li>
		      <li class="nav-item active">
		   		<a class="nav-link" href="imglist.jsp"><img src="./img/ranking.png" title="Ranking" /></a>
		       </li> 
		       <li class="nav-item active">
		        <a class="nav-link" href="list.do"><img src="./img/board.png" title="board" /></a>	      
		  	  </li>
		    </ul>
		    
		     
    
	   <%	request.setCharacterEncoding("UTF-8");
  			String id =(String)session.getAttribute("id");	
			if(id == null) { %>		
			<a class="nav-link" href="login.jsp"><img src="./img/login.png" width="32px" title="LOGIN" /></a><a class="nav-link" href="join.jsp"><img src="./img/join.png" width="32px" title="JOIN" /></a>
	   <%	} else { %>	
			<%= id %> 님, 안녕하세요 ♥ 
			 <a class="nav-link" href="modify.jsp">정보수정</a>	
			 <form class="form-inline my-2 my-lg-0" name="logout" action="logout.do" method="post">
			 <button class="btn btn-outline-success my-2 my-sm-0" type="submit">로그아웃</button>
			 &nbsp;&nbsp;
			 </form>		 
	   <%   } %>
 
  </div>
</nav>
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 
</body>
</html>

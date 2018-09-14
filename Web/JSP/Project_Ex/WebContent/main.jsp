<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> MAIN </title>
		
		<!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet" /> 
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script> -->
			
		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		
		<style>
		.#slider { margin:0 auto; width:1000px; height:592px;}		
		</style>
			
		</head>
		<%@ include file="header.jsp" %>
	<body>
		<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		  </ol>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100" src="./img/shinhwa1.jpg"  alt="첫번째 슬라이드">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="./img/shinhwa2.jpg" alt="두번째 슬라이드">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="./img/kakao03.jpg" alt="세번째 슬라이드">
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">이전</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">다음</span>
		  </a>
		</div>
		
		
 	 	 <footer class="text-muted">
      <div class="container">
    <% request.setCharacterEncoding("UTF-8");
			if(id != null) { %>		
		<p class="float-left">
     	 <form name="login_form" action="chat.jsp" method="post">
    		<input type="hidden" name="id" value="<%= id %>" >
   		<a href="#" onclick="submit();"> <img src="./img/chat.png"></a>
			</form>
		
	   <% } %>	
		
        </p>
        <p class="float-right">
          <a href="main.jsp">Back to Main</a>
        </p>
        <p>Name of company: Shooting Star|Name of representative: OH YEON JOO|KOSMO41 </p>
      
      </div>
    </footer>
 	
	</body>
		
</html>
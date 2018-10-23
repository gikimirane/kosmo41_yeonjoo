<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List</title>
				
		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		
		<style>			
			div.col-sm-10 { 
			width:100%;
			height:90%;
			margin:10%;	
			}
		</style>
	</head>
	<body>

		<div class="container">
 		<div class="col-sm-10">

		<table class="table table-hover" style="text-align:center;">
		
			<thead>
	 			<tr>
	 				<th scope="col">번호</th>
	 				<th scope="col">이름</th>
	 				<th scope="col">제목</th>
	 				<th scope="col">날짜</th>
					<th scope="col">조회수</th>
	 			</tr>
	 		</thead>
	 		
 			<tbody>
 			  <c:forEach items="${list}" var="dto">
   				<tr>
      				<td>${dto.bId}</td>
      				<td>${dto.bName}</td>
      				<td><a href="contentview?bId=${dto.bId}">${dto.bTitle}</a></td>
   					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
   				</tr>
   			  </c:forEach>
   			  <tr>  
	 			<td colspan="5" align="center" > 
	 			<button class="btn btn-outline-dark"  type="submit"> <a href="writeForm"> 글작성 </a></button>
	 			</td>
			   </tr>
			</table>
		  </div>
		</div>
	</tbody>

	</body>
</html>
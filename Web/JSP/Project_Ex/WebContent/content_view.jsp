<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> JAM#1♥ CONTENT_VIEW </title>
		
		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<style>
			div.col-sm-10 { 
			width:60%;
			height: 90%;
			margin: auto;	 
		}
		</style>
	</head>
	
	<%@ include file="header.jsp" %>
	
	<body>
 		<p></p>
 		
 		<div class="container">
 		<table class="table" width=auto">
 		
 			<tr>
 				<td>번호</td>
 				<td> ${content_view.bId} </td>
 			</tr>
 			<tr>
 				<td>히트</td>
 				<td> ${content_view.bHit} </td>
 			</tr>
 			<tr>
 				<td>이름</td>
 				<td>${content_view.bName}</td>
 			</tr>	
 			<tr>
 				<td>제목</td>
 				<td>${content_view.bTitle}</td>
 			</tr>
 			<tr>
 				<td>내용</td>
 				<td>${content_view.bContent}</td>
 			</tr>
 			<tr>
 				<td colspan="2" style="text-align:center;">
 				<button type="submit" value="수정" class="btn btn-outline-warning"> 
					<a href="modify_view.do?bId=${content_view.bId}">수정</a></button>
 				<button type="submit" value="목록보기" class="btn btn-outline-warning"> 
					<a href="list.do?page=<%= session.getAttribute("cpage")%>">목록보기</a></button>
 				<button type="submit" value="삭제" class="btn btn-outline-warning"> 
					<a href="delete.do?bId=${content_view.bId}">삭제</a></button>
				<button type="submit" value="삭제" class="btn btn-outline-warning"> 
 					<a href="reply_view.do?bId=${content_view.bId}">답변</a></button>
 				</td> 
 			</tr>
 			
 		</table>
		</div>
		
	</body>
	
	<%@ include file="footer.jsp" %>
	
</html>
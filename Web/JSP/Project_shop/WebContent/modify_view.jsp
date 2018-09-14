<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> JAM#1♥ MODIFY </title>
		
		<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>
		
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
	
	<script>
		function form_check() {
			document.modify_form.submit();
		}
	</script>
	<body>
 		<p></p>

 		<div class="container">
 		<div class="col-sm-10">
 		
 		<table class="table" width=auto">
 			
 			<form name="modify_form" action="modify.do" method="post">
 				<input type="hidden" name="bId" value=${content_view.bId} ">
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
	 				<td><input type="text" class="form-control" name="bName" value=${content_view.bName} readonly></td>
	 			</tr>	
	 			<tr>
	 				<td>제목</td>
	 				<td><input type="text" class="form-control" name="bTitle" value=${content_view.bTitle}></td>
	 			</tr>
	 			<tr>
	 				<td>내용</td>
	 				<td>
	 					<textarea name="bContent" id="editor1" rows="10" cols="80">
	               				${content_view.bContent}
	           				</textarea>
	            		<script>
	              	  		// Replace the <textarea id="editor1"> with a CKEditor
	              	  		// instance, using default configuration.
	              	  		CKEDITOR.replace( 'editor1' );
	            		</script>
	            	</td>
	 			</tr>
 			
 				<tr>
	 				<td colspan="2" style="text-align:center;" >
	 				<button type="submit" value="수정완료" class="btn btn-outline-warning"> 
					<a href="javascript:form_check()">수정완료</a></button>
					<button type="submit" value="취소" class="btn btn-outline-warning"> 
					<a href="content_view.do?bId=${content_view.bId}">취소</a></button>
					<button type="submit" value="목록보기" class="btn btn-outline-warning"> 
					<a href="list.do?page=<%= session.getAttribute("cpage")%>">목록보기</a></button></td>
 				</tr>
 			</form>
 		
 		</table>
		</div>
		</div>
		
	</body>
		
</html>
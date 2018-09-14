<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> JAM#1♥ REPLY </title>
		
		<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>
		
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
 		
 		<form action="reply.do" method="post">
 			<input type="hidden" name="bId" value="${reply_view.bId}">
 			<input type="hidden" name="bGroup" value="${reply_view.bGroup}">
 			<input type="hidden" name="bStep" value="${reply_view.bStep}">
 			<input type="hidden" name="bIndent" value="${reply_view.bIndent}">
 				
 				<tr>
 					<td> 번호 </td>
 					<td>${reply_view.bId} </td>
 				</tr>
 				<tr>
 					<td> 히트 </td>
 					<td>${reply_view.bHit} </td>
 				</tr>
 		 <%	request.setCharacterEncoding("UTF-8");
  			String Id =(String)session.getAttribute("id");	
			if(Id != null) { %>	
				<tr>
					<td> 아이디 </td>
					<td><input type="text" class="form-control" name="bName" size="50" value="<%= Id %>" readonly></td>
				</tr>
	  	 <%	} %>	
 				<tr>
 					<td> 제목 </td>
 					<td><input type="text" class="form-control" name="bTitle" value="${reply_view.bTitle}" - > </td>
 				</tr>
 				<tr>
 					<td> 원문내용 </td>
 					<td>${reply_view.bContent}</td>
 				</tr>
 				<tr>
 					<td> 내용 </td>
					<td>
 					<textarea name="bContent" id="editor1" rows="10" cols="80">
               				내용을 입력 하세요
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
 					<button type="submit" value="답변" class="btn btn-outline-warning">답변</button>
 					<button type="submit" value="목록보기" class="btn btn-outline-warning"> 
 					<a href="list.do?page=<%= session.getAttribute("cpage")%>">목록보기</a> 
 					</button></td>
 				</tr>
 			</form>
 		</table>
 		</div>
	
	</body>
	
</html>
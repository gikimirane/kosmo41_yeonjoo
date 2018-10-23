<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>WriteForm</title>
			<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>
	    	<meta charset="utf-8">
	  
			
			<!-- Required meta tags -->
		    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		    <!-- Bootstrap CSS -->
		    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<style>
			div.col-sm-10 { 
			width:70;
			height:90%;	
			margin:10%;	 
		}
		</style>
	</head>
	<body>
		
		<div class="container">
 		<div class="col-sm-10">

			<table class="table" width=auto">
				<form action="write" method="post">
				   <tr>
				      <td>작성자</td>
				      <td><input type="text" class="form-control" name="bName" size="50"></td>
				    </tr>
				    <tr>
						<td> 제목 </td>
						<td><input type="text" class="form-control" name="bTitle" size="50"></td>
					</tr>
				    <tr>
						<td> 내용 </td>
						<td>
							<textarea name="bContent" class="form-control" id="editor1" rows="10" cols="80">
		             				'내용을 입력하세요'
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
					<button type="submit" value="입력" class="btn btn-outline-primary">입력</button>
				
					<button type="submit" value="목록보기" class="btn btn-outline-dark"> 
					<a href="list">목록보기</a></button>
					</td>
				</tr>
				</form>
			</table>
	</body>
</html>
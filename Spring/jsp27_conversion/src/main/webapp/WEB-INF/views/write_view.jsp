<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>
<title>Insert title here</title>
</head>
<style>
* {
		background-color: black;
		font-size: large; font-family: fantasy; 
		color: pink;
	}
</style>	
<body>

	<table  cellpadding="0" cellspacing="0" border="1">
		<%-- <form action="write.do?p=<%= session.getAttribute("page") %>" method="post"> --%>
		<form action="write" method="post">
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="bName" size="50"> </td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="bTitle" size="50"> </td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td>
					<textarea name="bContent" id="editor1" rows="10" cols="80">
	                This is my textarea to be replaced with CKEditor.
	           		 </textarea>
	           	 	<script>
	                // Replace the <textarea id="editor1"> with a CKEditor
	                // instance, using default configuration.
	                CKEDITOR.replace( 'editor1' );
            		</script>
            	</td>
			</tr>
			<tr>
				<td colspan="2">
					 <input type="submit" value="입력"> &nbsp;&nbsp;
					 <a href="list.do?p=<%= session.getAttribute("page") %>"> 목록보기 </a>
				</td>
			</tr>				
		</form>	
	</table>
</body>
</html>
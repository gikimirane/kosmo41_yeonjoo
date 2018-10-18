<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>27 content_view</title>
		<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>
	</head>
	<script>
		function form_check() {
			document.modify_form.submit();
		}
	</script>
	<body>
 	
 		<table width="500" cellpadding="0" cellspacing="0", border="1">
 			<form name="modify_form" action="modify" method="post">
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
 				<td><input type="text" name="bName" value=${content_view.bName}></td>
 			</tr>	
 			<tr>
 				<td>제목</td>
 				<td><input type="text" name="bTitle" value=${content_view.bTitle}></td>
 			</tr>
 			<tr>
 				<td>내용</td>
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
 				<a href="javascript:form_check()">수정완료</a> &nbsp;&nbsp;
 				<a href="content_view?bId=${content_view.bId}">취소</a>&nbsp;&nbsp;
 				<a href="list?page=<%= session.getAttribute("cpage")%>">목록보기</a>&nbsp;&nbsp;
 			</tr>
 		</table>
	
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./sEditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<title>Insert title here</title>
<style>
	* {
			background-color: black;
			font-size: large; font-family: fantasy; 
			color: pink;
		}
</style>	
</head>
<script>
	function form_check() {
	    oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
	    
		document.modify_form.submit();
	}
</script>
<body>
 	
 	<table width="810" cellpadding="0" cellspacing="0" border="1">
			<form action="modify" method="post">
			<input type="hidden" name="bId" value="${ content_view.bId }">
			<tr>
				<td> 번호 </td>
				<td> ${ content_view.bId } </td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td> ${ content_view.bHit } </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="bName" value="${ content_view.bName }"></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="bTitle" value="${ content_view.bTitle }"></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td>
					<%-- <textarea name="bContent" rows="10">${ content_view.bContent }</textarea> --%>
					<textarea name="bContent" id="ir1" rows="10" cols="100" style="color:pink; FONT-FAMILY:fatasy;">
					에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면 됩니다.</textarea>
					<script type="text/javascript">
					var oEditors = [];
					nhn.husky.EZCreator.createInIFrame({
					    oAppRef: oEditors,
					    elPlaceHolder: "ir1",
					    sSkinURI: "./sEditor/SmartEditor2Skin.html",
					    fCreator: "createSEditor2"
					});
					</script>
				</td>			
			</tr>	
			<tr>
				<td colspan="2"><input type="submit" value="수정"> &nbsp;&nbsp;
				<a href="content_view.do?bId=${content_view.bId}">취소</a> &nbsp;&nbsp;
				<a href="list.do?p=<%= session.getAttribute("page") %>">목록보기</a> &nbsp;&nbsp;	
				</td>			
			</tr>				
		</form>	
	</table>
</body>
</html>
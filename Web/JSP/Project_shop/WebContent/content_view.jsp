<%@page import="com.study.jsp.*" %>		
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
			a:link { color:#000000; text-decoration:none;}
			a:visited { color:#000000; text-decoration:none;}
			a:active { color:#0000000; text-decoration:none;}
 			a:hover { color:#000000; text-decoration:none;}
		
			div.col-sm-10 { 
			width:100%;
			height:90%;
			margin:10%;
			}
			
		</style>
	</head>
	
	<%@ include file="header.jsp" %>

	<body>
 		<p></p>
 		
 		<div class="container">
 		<div class="col-sm-10">
 		
 		<hr style="border:dashed 1px; color:#007BFF;">
 		<table class="table">
 		  		
 			<tr>
 				<td>번호</td>
 				<td> ${content_view.bId} </td>
 			</tr>
 			<tr>
 				<td>히트</td>
 				<td> ${content_view.bHit} </td>
 			</tr>
						
 			<tr>
				<td>아이디</td>
				<td> ${content_view.bName} </td>
				
			</tr>
 				
 			<tr>
 				<td>제목</td>
 				<td>${content_view.bTitle}</td>
 			</tr>
		 		<c:choose>	
 				<c:when test="${content_view.fileName eq 'none'}">
 				<tr>
 						<td>파일</td>
 						<td> 첨부하신 파일이 없습니다. </td>
 					</tr>	
		 				</c:when>
		 				
		 				<c:otherwise>
		 			<tr>
 						<td>파일</td>
 						<td><img src="./img/${content_view.fileName}" width="100%"><br />
 						<a href="img/${content_view.fileName}">다운로드</a></td>
 					</tr>
    					</c:otherwise>
    			</c:choose>
 			<tr>
 				<td>내용</td>
 				<td>${content_view.bContent}</td>
 			</tr>
 			
 			 <tr>
 		 <%	request.setCharacterEncoding("UTF-8");
  			String mdId =(String)session.getAttribute("id");
  			String mdbName = request.getParameter("bName");
  			session.setAttribute("bName",mdbName);
  	
  			%>		
 			<c:choose>
 				<c:when test="${content_view.bName == id}">	
 					
 				<td colspan="2" style="text-align:center">	
 				
 				<button type="submit" value="수정" class="btn btn-outline-primary" > 
					<a href="modify_view.do?bId=${content_view.bId}">수정</a></button>
		
				<button type="submit" value="삭제" class="btn btn-outline-primary" > 
					<a href="delete.do?bId=${content_view.bId}">삭제</a></button>
			    <button type="submit" value="답변" class="btn btn-outline-primary"> 
					<a href="reply_view.do?bId=${content_view.bId}">답변</a></button>
				<button type="submit" value="목록보기" class="btn btn-outline-primary"> 
					<a href="list.do?page=<%= session.getAttribute("cpage")%>">리스트</a></button>	
 				
 				</td> 
				</c:when>
				
				<c:when test="${id != null}">
					
				<td colspan="2" style="text-align:center">	
					<button type="submit" value="답변" class="btn btn-outline-primary"> 
					<a href="reply_view.do?bId=${content_view.bId}">답변</a></button>
 				
 				<button type="submit" value="목록보기" class="btn btn-outline-primary"> 
					<a href="list.do?page=<%= session.getAttribute("cpage")%>">리스트</a></button>	
 				</td> 
 					</c:when>
				<c:otherwise>
				<td colspan="2" style="text-align:center">	
				<button type="submit" value="목록보기" class="btn btn-outline-primary"> 
					<a href="list.do?page=<%= session.getAttribute("cpage")%>">리스트</a></button>	
 				</td> 
 				</c:otherwise>
 			
 			</c:choose>
 			</tr>
 			</table>
 			<hr style="border:dashed 1px; color:#007BFF;">
 	</div>
 		
		</div>    		
	</body>
	
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

</html>
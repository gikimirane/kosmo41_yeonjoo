<%@page import="com.study.jsp.*" %>	
<%@page import="com.study.jsp.command.*" %>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> BOARD LIST </title>
			
		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		
		<style>	
		
			a:link { color:#000000; text-decoration:none;}
			a:visited { color:#000000; text-decoration:none;}
			a:active { color:#000000; text-decoration:none;}
 			a:hover { color:#000000; text-decoration:none;}
		
			div.col-sm-10 { 
			width:100%;
			height:90%;
			margin:10%;	
			}
		
		</style>		
	</head>
	
	<%@ include file="header.jsp" %>
	
	 <%	request.setCharacterEncoding("UTF-8");
  			String boardid =(String)session.getAttribute("id");	
  			System.out.println("리스트 아이디" + id);	
  			%>
  			
	<body>
		<p></p>		
 		
 		<div class="container">
 		<div class="col-sm-10">
 		
 		<img src="./img/board_p.png" width="128px" alt="loginpage" class="img-responsive center-block" />
 		   <hr style="border:dashed 1px; color:#007BFF;">
 		   <br />
 		
 		<table>
 		<tr>
		  <form action="list.do" method="post">
		  	<input type="hidden" name="search" value="true">
		  		<td style="align:right;">
					<div class="input-group mb-1">
					<select class="custom-select" id="keyField" name="keyField">
						<option value="0">전체목록</option>
						<option value="1">제목+내용</option>
						<option value="2">제목</option>
						<option value="3">내용</option>
					</select>
				<input type="text" class="form-control" name="keyWord" style="width:30%">
				<input type="submit" class="btn btn-outline-primary" value="검색"> 
					</div>
				</td>
			</form>	
		</tr>
 		   		</table>
 		
 		<table class="table table-hover" style="text-align:center;">


 		<thead>
 			<thead>
 		
	 			<tr>
	 				<th scope="col">번호</th>
	 				<th scope="col">아이디</th>
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
	 				<td>
	 					<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
	 					<a href="content_view.do?bId=${dto.bId}&bName=${dto.bName}" style="color:warning">${dto.bTitle}</a>
	 				</td>
	 				<td>${dto.bDate}</td>
	 				<td>${dto.bHit}</td>
	 			</tr>
	 			</c:forEach>
	 				
	 		   <% request.setCharacterEncoding("UTF-8");
	  		 		
	 	   			String keyField =(String)session.getAttribute("keyField");
	  		 		String keyWord =(String)session.getAttribute("keyWord");
	  		 		
	  		 		session.setAttribute("keyWord",keyWord);
	  		 		session.setAttribute("keyField",keyField);
	  		 		
	  		 		if(keyField != null && keyWord != null){
	  		 			System.out.println("검색 페이징 처리");	
	  		 			%>		
		   
					<tr>
		 			  <td colspan="5" style="text-align:center;"> 
		 				
		 				<!-- 처음버튼 -->
		 				<span class="btn btn-outline-primary btn-sm">
		 				<c:choose>
			 				<c:when test="${(page.curPage - 1) < 1}">
			 					 &lt;&lt; 
			 				</c:when>
			 				<c:otherwise>
								<a href="list.do?page=1&keyField=${keyField}&keyWord=${keyWord}" style="color:warning"> &lt;&lt; </a> 
			 				</c:otherwise>
		 				</c:choose>	
		 				</span>
		
		 				<!-- 이전버튼 -->
		 				<span class="btn btn-outline-primary btn-sm">
		 				<c:choose>
			 				<c:when test="${(page.curPage - 1) < 1}">
			 					 &lt; 
			 				</c:when>
			 				<c:otherwise>
							<a href="list.do?page=${page.curPage - 1}&keyField=${keyField}&keyWord=${keyWord}" style="color:warning"> &lt; </a> 
			 				</c:otherwise>
		 				</c:choose>
		 				</span>
		 				<!-- 개별페이지 -->
		 				<c:forEach var="fEach" begin="${page.startPage}" end="${page.endPage}" step="1">
			 				<span class="btn btn-outline-primary btn-sm">
			 				<c:choose>
				 				<c:when test="${page.curPage == fEach}">
				 					 ${fEach}  &nbsp; 
				 				</c:when>
				 				<c:otherwise>
									<a href="list.do?page=${fEach}&keyField=${keyField}&keyWord=${keyWord}" style="color:warning" > ${fEach} </a> &nbsp; 
				 				</c:otherwise>
			 				</c:choose>
			 				</span>
		 				</c:forEach>
		 				
		 				<!-- 다음버튼 -->
		 				<span class="btn btn-outline-primary btn-sm">
		 				<c:choose>
			 				<c:when test="${(page.curPage + 1) > page.totalPage}">
			 					  &gt;  
			 				</c:when>
			 				<c:otherwise>
								<a href="list.do?page=${page.curPage + 1}&keyField=${keyField}&keyWord=${keyWord}" style="color:warning"> &gt; </a> 
			 				</c:otherwise>
		 				</c:choose>
		 				</span>
		 				<!-- 끝버튼 -->
		 				<span class="btn btn-outline-primary btn-sm">
		 				<c:choose>
			 				<c:when test="${page.curPage == page.totalPage}">
			 					  &gt; 
			 				</c:when>
			 				<c:otherwise>
								<a href="list.do?page=${page.totalPage}&keyField=${keyField}&keyWord=${keyWord}" style="color:warning"> &gt;&gt; </a> 
			 				</c:otherwise>
		 				</c:choose>
		 				</span>
		 			  </td>
		 			</tr>	
		  		 		
		   <%	} else { 
			   System.out.println("검색X 페이징처리");
		   %>				
		   			<tr>
		 				<td colspan="5" style="text-align:center;"> 
		 				<!-- 처음버튼 -->
		 				<span class="btn btn-outline-primary btn-sm">
		 				<c:choose>
			 				<c:when test="${(page.curPage - 1) < 1}">
			 					 &lt;&lt; 
			 				</c:when>
			 				<c:otherwise>
								<a href="list.do?page=1" style="color:warning"> &lt;&lt; </a> 
			 				</c:otherwise>
		 				</c:choose>	
		 				</span>
		
		 				<!-- 이전버튼 -->
		 				<span class="btn btn-outline-primary btn-sm">
		 				<c:choose>
			 				<c:when test="${(page.curPage - 1) < 1}">
			 					 &lt; 
			 				</c:when>
			 				<c:otherwise>
							<a href="list.do?page=${page.curPage - 1}" style="color:warning"> &lt; </a> 
			 				</c:otherwise>
		 				</c:choose>
		 				</span>
		 				<!-- 개별페이지 -->
		 				<c:forEach var="fEach" begin="${page.startPage}" end="${page.endPage}" step="1">
			 				<span class="btn btn-outline-primary btn-sm">
			 				<c:choose>
				 				<c:when test="${page.curPage == fEach}">
				 					 ${fEach}  &nbsp; 
				 				</c:when>
				 				<c:otherwise>
									<a href="list.do?page=${fEach}" style="color:warning" > ${fEach} </a> &nbsp; 
				 				</c:otherwise>
			 				</c:choose>
			 				</span>
		 				</c:forEach>
		 				
		 				<!-- 다음버튼 -->
		 				<span class="btn btn-outline-primary btn-sm">
		 				<c:choose>
			 				<c:when test="${(page.curPage + 1) > page.totalPage}">
			 					  &gt;  
			 				</c:when>
			 				<c:otherwise>
								<a href="list.do?page=${page.curPage + 1}" style="color:warning"> &gt; </a> 
			 				</c:otherwise>
		 				</c:choose>
		 				</span>
		 				<!-- 끝버튼 -->
		 				<span class="btn btn-outline-primary btn-sm">
		 				<c:choose>
			 				<c:when test="${page.curPage == page.totalPage}">
			 					  &gt; 
			 				</c:when>
			 				<c:otherwise>
								<a href="list.do?page=${page.totalPage}" style="color:warning"> &gt;&gt; </a> 
			 				</c:otherwise>
		 				</c:choose>
		 				</span>
		 				</td>
	 				</tr>
		   <% } %>
		    
			<%	request.setCharacterEncoding("UTF-8");	
				if(id != null) { %>		
				<tr>  
	 				<td colspan="5" align="center" > 
	 				<button class="btn btn-outline-dark"  type="submit"> <a href="write_view.do"> 글작성 </a></button>
	 				</td>
		   <%	} else { %>	
					<td colspan="5" align="center" > 
	 					'로그인 후에 글작성이 가능합니다.'
	 				</td>
	 			</tr>
	   		<%   } %>	
	   		
	   		</table> 	
		   <hr style="border:dashed 1px; color:#007BFF;">
	
 <!--	totalCount : ${page.curPage}<br>
 		listCount : ${page.listCount}<br>
 		totalPage : ${page.totalPage}<br>
 		curPage : ${page.curPage}<br>
 		pageCount : ${page.pageCount}<br>
 		startPage : ${page.startPage}<br>
 		endPage : ${page.endPage}<br> -->
 	
	 	<!--Optional JavaScript -->
	    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

  		
	  </div>
	</div>
	</tbody>
	
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>27 게시판 리스트</title>
			
		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<style>
			 #container {
			      width : 70%;
			      margin: 0 auto;     /* 가로로 중앙에 배치 */
			      padding-top: 10%;   /* 테두리와 내용 사이의 패딩 여백 */
			    }
			     
			    #list {
			      text-align: center;
			    }
			   
			    #write {
			      text-align: right;
			    }
			     
			    /* Bootstrap 수정 */
			    .table > thead {
			      background-color: #E1EEF6;
			    }
			    .table > thead > tr > th {
			      text-align: center;
			    }
			    .table-hover > tbody > tr:hover {
			      background-color: #337AB7;
			    }
			    .table > tbody > tr > td {
			      text-align: center;
			    }
			    .table > tbody > tr > #title {
			      text-align: left;
			    }
			     
			    div > #paging {
			      text-align: center;
			    }
			     
			    .hit {
			      animation-name: blink;
			      animation-duration: 1.5s;
			      animation-timing-function: ease;
			      animation-iteration-count: infinite;
			      /* 위 속성들을 한 줄로 표기하기 */
			      /* -webkit-animation: blink 1.5s ease infinite; */
			    }
			     
			    /* 애니메이션 지점 설정하기 */
			    /* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
			    @keyframes blink {
			      from {color: white;}
			      30% {color: yellow;}
			      to {color: red; font-weight: bold;}
			      /* 0% {color:white;}
			      30% {color: yellow;}
			      100% {color:red; font-weight: bold;} */
			    }
		</style>		
	</head>
	<body>
		<%@ include file="header.jsp" %>
 		<div>
   		   <table class="table table-striped table-bordered table-hover">
    	    <thead>
         	 <tr>
	 			<th width="10%">번호</th>
	 			<th width="10%">이름</th>
	 			<th width="50%">제목</th>
	 			<th width="20%">날짜</th>
	 			<th width="10%">조회</th>
	 			</tr>
	 		</thead>
 			<tbody>
 			<c:forEach items="${list}" var="dto">
 			<tr>
 				<td>${dto.bId}</td>
 				<td>${dto.bName}</td>
 				<td>
 					<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
 					<a href="content_view.do?bId=${dto.bId}" style="color:warning">${dto.bTitle}</a>
 				</td>
 				<td>${dto.bDate}</td>
 				<td>${dto.bHit}</td>
 			</tr>
 			</c:forEach>
 			
			<!--  글작성 버튼 -->
 			
 			<tr>
 				<td colspan="5" align="center"> <button type="submit" class="btn btn-center"> <a href="write_view.do" style="color:light">글쓰기</a> </button></td>
 			</tr> 

 			<tr>
 				<td colspan="5" align="center"> 
 				<!-- 처음버튼 -->
 				<span class="btn btn-outline-warning">
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
 				<span class="btn btn-outline-warning">
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
	 				<span class="btn btn-outline-warning">
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
 				<span class="btn btn-outline-warning">
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
 				<span class="btn btn-outline-warning">
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
 			</tbody>				
 		</table>
 		</div>
 		
 		<%@ include file="footer.jsp" %>
 		
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
	</body>
</html>
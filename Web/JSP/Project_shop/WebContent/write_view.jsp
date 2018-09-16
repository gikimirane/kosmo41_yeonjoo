<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<title> WRITE </title>
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
	
	<%@ include file="header.jsp" %>
		
	<body>
		
	<div class="container"> 
	<div class="col-sm-10">

			<img src="./img/board_p.png" width="128px" alt="loginpage" class="img-responsive center-block" />
			<hr style="border:dashed 1px; color:#007BFF;">
		<table class="table" width=auto">
		
			<form action ="write.do" method="post"  enctype="multipart/form-data">
 		
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
           		 <td>파일</td>
            	 <td>
                 <input type="file" name="fileName"><br/>
                 </td>
             </tr>
   	
				<tr>
					<td colspan="2" style="text-align:center;" > 
					<button type="submit" value="입력" class="btn btn-outline-primary">입력</button>
				
					<button type="submit" value="목록보기" class="btn btn-outline-dark"> 
					<a href="list.do?page=<%= session.getAttribute("cpage")%>">목록보기</a></button>
					</td>
				</tr>
		
 			</form>
 		</table>
 		
 		<hr style="border:dashed 1px; color:#007BFF;">
 		
 	</div>
 	</div>
 		
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 		
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
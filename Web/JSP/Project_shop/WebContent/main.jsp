
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>프로젝트_메인</title>
		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		   <style>
		      body {
		        margin: 0px;
		        padding: 0px;
		      }
		      .jbTitle {
		        text-align: center;
		      }
		      .jbMenu {
		        text-align: center;
		        background-color: #337AB7;
		        color: #ffffff;
		        padding: 10px 0px;
		        width: 100%;
		        height: 100px;
		      }
		      .jbContent {
		        height: 2000px;
		      }
		      .jbFixed {
		        position: fixed;
		        top: 0px;
		      }
		    </style>
		    
			<script>
		      $( document ).ready( function() {
		        var jbOffset = $( '.jbMenu' ).offset();
		        $( window ).scroll( function() {
		          if ( $( document ).scrollTop() > jbOffset.top ) {
		            $( '.jbMenu' ).addClass( 'jbFixed' );
		          }
		          else {
		            $( '.jbMenu' ).removeClass( 'jbFixed' );
		          }
		        });
		      } );
		    </script>
	</head>
	<body>
		 <div class="jbTitle">
		      			<%
			request.setCharacterEncoding("UTF-8");
			
			Object obj = session.getAttribute("BId");
			String bId = (String)obj;	
			
			if(bId == null) {
				out.println("♥ 로그인을 해 주세요 ♥");
			%>
			<td colspan="5"> <button type="submit" class="btn btn-center"> <a href="login.jsp" style="color:primary"> 로그인 </a> </button></td> 
			<% 	
			} else {
				out.println(bId + "님 로그인을 환영해요♥" + "<br>");
			}
			%> 
			<td colspan="5"> <button type="submit" class="btn btn-center"> <a href="join.jsp" style="color:primary"> 회원가입 </a> </button></td>
		    
		    </div>
		    <div class="jbMenu">
		      <p>
		       <h1> I AM </h1> 
		      </p>
		    </div>
		    <div class="jbContent">
		    </div>
	
	</body>
</html>
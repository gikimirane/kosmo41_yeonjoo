<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> 사이트 메인</title>
<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<style>
		
			div {
				padding:5px; margin:5px;
				text-align:center;
			}
			
			#nav {
				width:auto; height:100px;
				overflow:hidden;
			}	
			
				#nav ul li {
					width:138px; height:40px;
					line-height:40px;
					text-align:center;
					list-style:none;
					float:left;
					border:1px sold #cccccc;
				}
				
			#wrap {
				width:100%px;
				overflow:hidden;
			}
			
			#content {
				width:600px; height:305px;
				float:left;
			}
			
			#banner {
				width:135px; height:305px;
				float:left;
			}
		</style>
	</head>
		
	<body>
		<%@ include file="header.jsp" %>
	
			<div id="nav">
				<p>NAVIGATION</p>
				<ul>
					<li>menu1</li>
					<li>menu2</li>
					<li>menu3</li>
					<li>menu4</li>
					<li>menu5</li>
				</ul>
			</div>

		<div id="wrap">
			<div id="content"> CONTENT </div>
			<div id="banner"> BANNER </div>
		</div>
		
	</div>
		
	</body>
</html>

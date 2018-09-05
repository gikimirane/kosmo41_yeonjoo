<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> JAM#1♥ MAIN </title>
<style>
		
			div {
				border:1px solid #000040;
				padding:5px; margin:5px;
				text-align:center;
			}
			
			#con {
				width:800px;
				margin:0 auto;
				overflow:hidden;
			}
			
			#header {
				width:780px; height:100px;
				line-height:100px;
			position: relative;
			 top: expression(this.offsetParent.scrollTop);
			 z-index: 20;
			}
			
			#nav {
				width:780px; height:100px;
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
				width:780px;
				overflow:hidden;
			}
			
			#content {
				width:600px; height:305px;
				float:left;
			}
			
			#login {
				width:135px; height:140px;
				float:left;
			}
			
			#banner {
				width:135px; height:140px;
				float:left;
			}
			
			#footer {
				width:780px; height:100px;
				line-height:100px;
			}
	
		</style>
	</head>
		
	<body>
	
		<div id="con">
			<div id="header">
			<a href="login.jsp">로그인</a> <a href="join.jsp">회원가입</a> 
			</div>
			
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
			<div id="login"> 
			<%
			request.setCharacterEncoding("UTF-8");
			
			Object obj = session.getAttribute("id");
			String Id = (String)obj;	
			
			if(Id == null) {
				out.println("로그인을 해 주세요 <br>");
			} else {
				out.println(Id + "님 로그인을 환영해요♥" + "<br>");
			}
		%> 
			
		
			
			</div>
			<div id="banner"> BANNER </div>
		</div>
		
		<div id="footer">
			FOOTER
		</div>
	</div>
		
	</body>
</html>
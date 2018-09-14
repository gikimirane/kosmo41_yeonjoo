<%@page import="com.study.jsp.*" %>	
<%@page import="com.study.jsp.command.*" %>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>chat</title>
		
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
		<div class="container">
 		<div class="col-sm-10">
 		
 		<img src="./img/chatting.png" width="128px" alt="loginpage" class="img-responsive center-block" />
 		<hr style="border:dashed 1px; color:#007BFF;">
 	
		 <div style="text-align:right;">
			<button type="button" class="btn btn-primary btn-sm" onclick="openSocket();">채팅시작</button>
			<button type="button" class="btn btn-dark btn-sm" onclick="closeSocket();">끝내기</button>
		</div>				
		<div>	<%= id %> : <input type="text" class="form-control" id="messageinput"> </div>
			<div style="text-align:right;">
			<button type="button" class="btn btn-primary btn-sm" onclick="send();">보내기</button>
		</div>
		<!-- Server resuponses get written here -->
		<div id="messages"></div>
		<!-- Script to utilise the WebSocket -->
		<script type="text/javascript">
			var webSocket;
			var message = document.getElementById("message");
			
			// 컨넥트를 눌렀을 때 접속되는 부분
			function openSocket() {
				//Ensures only one connection is open at a time
				if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
					writeResponse("webSocket is already opened.");
					return;
				}
				
				// Create a new instance of the websocket
				// webSocket = new WebSocket("ws://localhost/  *ProjectName*  /echo");
				webSocket = new WebSocket("ws://localhost:8081/Project_shop/websocketendpoint3");
											//  ㄴ 다른 곳으로 붙고싶을 경우 localhost 부분에 아이피를 적으면 됨 
				/*
				* Binds functions to the listeners for the websocket.
				*/
				
				// on = ~ 할때 onopen은 오픈되었을 때의 의미
				webSocket.onopen = function(event){
					// For reasons i can't detuermine, onopen gets called twice
					// and the first time event.data is undefined.
					// Leave a comment if you know the answer.
					if (event.data === undefined)
						return;
					
					// 접속했을 때 보내는 메세지
					writeResponse(event.date);
				};
				
				// on = ~ 할때 onemssage은 메세지가 왔을 때
				webSocket.onmessage = function(event){
					
					// 서버에서 나한테 온 메세지
					writeResponse(event.data);
				};
				
				webSocket.onclose = function(event) {
					writeResponse("Connection closed");
					location.href="./main.jsp";
				};
			}
			
			/*
			* Sends the value of the text input to the server
			*/
			function send(){
				var id = "<%= id %>";
				var text = document.getElementById("messageinput").value;
				webSocket.send("[ "+id+" ]" + text);
			}
			function closeSocket(){
				webSocket.close();
			}
			function writeResponse(text){
				// 대화가 길어지면 스크롤이 생기도록 하거나
				// 대화가 길어지면 첫번째줄 자르고 마지막줄 추가하고 ..
				messages.innerHTML += "<br/>" + text;
			}
			
		</script>
		
		<hr style="border:dashed 1px; color:#007BFF;">
	</body>
</html>
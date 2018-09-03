<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
</head>
<body>
<% 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	
		if(id == null) { 
%>
		<jsp:forward page="login.jsp" />
<% 
		} else {
		
			session.setAttribute("uid",id);
		}
		
%>
		<div>				
			사용자 아이디 : <%= id %>
		</div>
		<div>				
			<input type="text" id="messageinput">
		</div>
		<div>	
			<button type="button" onclick="openSocket();">Open</button>
			<button type="button" onclick="send();">Send</button>
			<button type="button" onclick="closeSocket();">Close</button>
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
				webSocket = new WebSocket("ws://localhost:8081/WebSocketEx/websocketendpoint2");
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
				};
			}
			
			/*
			* Sends the value of the text input to the server
			*/
			function send(){
				var id = "<%= id %>";
				var text = document.getElementById("messageinput").value;
				webSocket.send(id + "|" + text);
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

</body>
</html>
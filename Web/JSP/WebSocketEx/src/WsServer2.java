import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*
 * sessions는 각 호출 시 마다 생성되므로 static으로 정해줘야 한다.
 * 브라우저가 websocket을 지원 해야 한다.
 */
@ServerEndpoint("/websocketendpoint2")
// 상속받은게 아닌 그냥 클래스
public class WsServer2 {
	
	//                 해시맵 역할을 하는 아이 : sessions
	private static final java.util.Set<Session> sessions = 
			java.util.Collections.synchronizedSet(new java.util.HashSet<Session>());
	
	
    @OnOpen
	public void onOpen(Session session) {
        System.out.println("Open session id : " + session.getId());
        
        try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("Connection Established");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        
        sessions.add(session);
    }
    
   // 웹소켓 연결 후 별도 close 동작없이 브라우저를 닫을 경우 자동으로 onclose가 호출 된다.
    @OnClose
   	public void onClose(Session session) {
           System.out.println("Session " + session.getId() + " has ended");
           sessions.remove(session);
    }
	
    @OnMessage
   	public void onMessage(String message, Session session) {
        System.out.println("Message from " + session.getId() + " : " + message);
        try {
			final Basic basic = session.getBasicRemote();
			// to : 내가 보내는 메세지
			basic.sendText("to :" + message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        
        sendAllSessionToMessage(session,message);
    }
    /*
     * 모든 사용자에게 메세지를 전달한다.
     */
    private void sendAllSessionToMessage(Session self, String message) {
    	try {

    		// add로 설정해놓은 sessions 를 돌면서
    		for( Session session : WsServer2.sessions ) {
				// 세션과 동일한 아이디가 아닐 경우 메세지를 보냄 
    			if( ! self.getId().equals(session.getId()) )
					session.getBasicRemote().sendText("All : " + message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    // 통신 중 에러 발생 시 호출되는 메소드
    @OnError
   	public void onError(Throwable e, Session session) {
         
    }

}

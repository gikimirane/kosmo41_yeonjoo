import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServerQ {

		ServerSocket serverSocket = null;
		Socket socket = null;
		Map<String,PrintWriter> clientMap;
		
		//생성자
		public MultiServerQ () {
			// 클라이언트의 출력스트림을 저장할 해쉬맵 생성
			clientMap = new HashMap<String,PrintWriter>();
			//해쉬맵 동기화 설정
			Collections.synchronizedMap(clientMap);
		}
		
		public void init() {
		
		try {
			serverSocket = new ServerSocket(9999); //9999포트로 서버소켓 객체생성
			System.out.println("서버가 시작 되었습니다.");
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress()+ ":"+socket.getPort());
				
				Thread msr = new MultiServerT(socket); //쓰레드 생성
				msr.start(); //쓰레드 시동
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	
	public void unicast(String msg,int i) {
	
		List clientMap = new ArrayList();
		List<String> clientmap = new ArrayList<String>();
		
		try {
			PrintWriter it_out2 = (PrintWriter) clientMap.get(i);
			it_out2.println(msg);
			it_out2.flush();
		} catch (Exception e) {
		System.out.println("xxx");
		}
		}
	// 접속된 모든 클라이언트들에게 메시지를 전달
	public void sendAllMsg(String msg) {
			
		// 출력스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
		Iterator it = clientMap.keySet().iterator();
	
		while(it.hasNext()) {
			try {
				
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
				it_out.println(msg);
			} catch (Exception e) {
				System.out.println("예외1:" +e);
			}
		}
	}
	
	
		public static void main(String[] args)
		{
			//서버객체 생성
			MultiServerQ ms = new MultiServerQ();
			ms.init();

		}

		// 내부 클래스
		// 클라이언트로부터 읽어온 메시지를 다른 클라이언트에 보내는 역할을 하는 메서드
		
	class  MultiServerT extends Thread {
		
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;
		
		
		//생성자
		public MultiServerT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(this.socket.getOutputStream(),true);
				in = new BufferedReader(new InputStreamReader(
											this.socket.getInputStream() ));
			} catch (Exception e) {
				System.out.println("예외2:" + e);
			}
		}
		
		
		@Override
		public void run() {

			String name = ""; 
			try {
				name = in.readLine(); 
				
				sendAllMsg(name + "님이 입장하셨습니다.");
				
				clientMap.put(name,out); 
				System.out.println("현재 접속자 수는" + clientMap.size()+ "명 입니다.");
				
				
				
			/*	if (msg.indexof("\to") >=0 ) {
					name = msg.substring(msg.lastIndexOf("<")+1,msg.lastIndexOf(">"));
					for(int i = 0; i System.out.println("name:"+list.elementAt(i)+"//"+msg.substring(msg.indexOf("<")+1,msg.indexOf(">"))+"->"+ name);
							if(name.equals(String)list.elementAt(i) == true) {
								cnt = i;
							}
							}
							System.out.println("cnt ="+ cnt);
							unicast(msg,cnt);
				}*/
			
			
			
				String s ="";
				while (in!=null) {
					s= in.readLine();
					System.out.println(s);
					if(s.equals("q") || s.equals("Q") )
						break;
					sendAllMsg(s);
				}
				} catch (Exception e) {
					System.out.println("예외3:" + e);
				} finally {
				// 예외가 발생할때 퇴장 해쉬맵에서 해당 데이터 제거
				// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
					clientMap.remove(name);
					sendAllMsg(name + "님이 퇴장하셨습니다.");
					System.out.println("현재 접속자 수는 "+clientMap.size()+"명 입니다.");
					
					try {
						in.close();
						out.close();
						
						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}	
		}
	
	}
}


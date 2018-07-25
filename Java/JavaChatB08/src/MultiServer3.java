import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer3 {

		static ServerSocket serverSocket = null;
		static Socket socket = null;
		static PrintWriter out = null;
		static BufferedReader in = null;
		static String s = "";
		
		//생성자
		public MultiServer3 () {
			
		}
		
		public static void init() {
		
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작 되었습니다.");
			
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + ":" + socket.getPort());
			
			// 소켓 생성 > 소켓 허용( IP주소,포트 받기 )
			
			out =new PrintWriter(socket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(
										socket.getInputStream() ));
			
			// 소켓 내용 추출 
			
			while (in != null) {
				s = in.readLine();
				if(s == null)
					break;
				if(s.equals("q")||s.equals("Q") )
					break;
				
				// 사용자 입력 값이 혹시 Null이거나 q 일때는 break
				System.out.println(s);
				//out.println(s);
				sendAllMsg(s);
			}
			
			System.out.println("Bye...");
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				
				socket.close();
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		// 접속된 모든 클라이언트들에게 메시지를 전달
		public static void sendAllMsg(String msg) {
			try {
				out.println(msg);
			} catch (Exception e) {
				System.out.println("예외:" + e);
			}
		}
		public static void main(String[] args)
		{
			init();

		}

}	

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String s = "";
		
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");
			 //소켓 연결
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + ":" + socket.getPort());
			// 소켓허용 IP주소 받아들임
			
			out = new PrintWriter(socket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(
											socket.getInputStream() ));
			//소켓에 저장된 값을 읽어들임
			
			s = in.readLine();
			System.out.println(s);
			out.println(s);
			
			System.out.println("Bye...");
			
			//클라이언트로부터 넘어오는 정보를 출력
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				
				socket.close();
				serverSocket.close(); // 소켓 종료
			} catch (Exception e) {
				e.printStackTrace(); //예외처리
			}
		}

	}

}

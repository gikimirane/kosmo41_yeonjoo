import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String s = "";
		
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작 되었습니다.");
			// 소켓 생성
			
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + ":" + socket.getPort());
			// 소켓 허용 (IP주소, 포트 받기)
			out =new PrintWriter(socket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(
										socket.getInputStream() ));
			
			// 소켓 값을 추출
			
			while (in != null) { // 들어오는 값이 null이 아닐 경우 반복
				s = in.readLine();
				if(s == null)
					break;
				if(s.equals("q")||s.equals("Q") )
					break;
				// 사용자 입력 값이 null 이거나 q 일때 break 걸고 빠져나감	
				System.out.println(s);
				out.println(s);
			} // 아닐경우 사용자 입력값 그대로 출력
			System.out.println("Bye...");
			// break로 빠져나온 후 출력
			
		} catch (Exception e) {
			System.out.println("예외1 :" + e);
			// e.printStackTrace();  
			// 예외 내용 출력
		}

	}

}

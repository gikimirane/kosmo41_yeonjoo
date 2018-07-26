import java.io.*;
import java.net.*;
import java.util.*;

public class MultiClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		System.out.println("이름을 입력해 주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();
	
		try {

			String ServerIP = "localhost";
			if (args.length > 0)
				ServerIP = args[0];
			Socket socket = new Socket(ServerIP, 9999); // 소켓 객체 생성
			System.out.println("서버와 연결 되었습니다..");
			;

			// 서버에서 보내는 메세지를 사용자에게 출력하는 쓰레드
			Thread receiver = new Receiver(socket);
			receiver.start();
			
			new ChatWin(socket, s_name);			
			
		} catch (Exception e) {
			System.out.println("예외[Multiclient class] : " + e);
		}

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

// 서버로 메시지를 전송하는 클래스
public class Receiver3 extends Thread {

	Socket socket;
	BufferedReader in = null;
	
	//Socket을 매개변수로 받는 생성자
	public Receiver3(Socket socket)
	{
		this.socket = socket;
		
		try {
			in = new BufferedReader(new InputStreamReader(
										this.socket.getInputStream() ));
		} catch (Exception e) {
			System.out.println("예외1 :" + e);
		}

	}
	
	//run()메소드의 재정의
	
	@Override
	public void run() {
		while (in!=null) {
			try {
				System.out.println("Thread Receive : " + in.readLine());
			} catch (Exception e) {
				System.out.println("예외2 :" + e);
			}
		}
		
		try {
			in.close();
		} catch (Exception e) {
			System.out.println("예외3 :"+ e);
		}
	}
}

// 자바에서 this는 자기 자신을 말한다.
// this.멤버변수 / 메소드 자신이 가지고 있는 변수/메소드

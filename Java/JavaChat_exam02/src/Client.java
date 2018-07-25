import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

	private Socket soc; //서버에 연결할 소켓
	private BufferedReader br; //서버가 보낸 메세지를 읽을 리더
	private PrintWriter pw; // 서버로 메세지를 보낼 라이터
	private Scanner scan; //사용가자 입력한 데이터를 읽을 스캐너
	
	public Client() {
		init();
	}
	
	public void init() {
		
		try {
			
			soc = new Socket("localhost",9999); //자신의 아이피로 9999 포트를 통해서 서버에 접속시도
			System.out.println("서버 접속 완료");
			
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			// 연결된 서버로부터 데이터를 받아올 준비
			
			pw = new PrintWriter(soc.getOutputStream());
			// 연결된 서버로 데이터를 보낼 준비
			
			scan = new Scanner(System.in);
			//사용자가 입력한 데이터를 읽을 준비를 함
			
			System.out.println("채팅 가능");
			String inputData =""; //사용자가 입력한 데이터를 저장할 공간
			
			while(!inputData.equals("q")) { //사용자가 'q'라고 입력하거나 강제종료 할때까지 while 문 실행
				System.out.print("to Server > ");
				pw.println(scan.nextLine()); 
				//사용자가 입력한 내용을 읽어와 서버로 보냄
				pw.flush(); 
				//프린트라이터 메모리를 초기화 시켜 내부에 있던 데이터를 서버로 전송
				
				System.out.println("from Server > " + br.readLine());
				//서버가 보낸 데이터를 읽어와 화면에 표기
			}
			
			soc.close(); //연결종료시 소켓닫기
		
		} catch (Exception e) {
			e.printStackTrace(); //에러추적
		}
		
	}
	
	public static void main(String[] args) {
		new Client();

	}

}

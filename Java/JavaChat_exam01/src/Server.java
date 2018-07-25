import java.io.*;
import java.net.*;


public class Server {

	private ServerSocket server_Soc; //서버 소켓
	private BufferedReader br; //클라이언트로부터 전달받은 메세지를 읽어들일 버퍼 메모리를 가진 리더
	private PrintWriter pw; //클라이언트로 메세지를 보낼 프린트 라이터
	private Socket soc; //클라이언트 소켓
	
	public Server() {
		init();
	}
	
	public void init() {
		
		
		try {
			
			server_Soc = new ServerSocket(9999); //현재 아이피를 9999포트를 사용하여 서버 오픈
			
			System.out.println("서버가 준비완료되었어요~");
			System.out.println("클라이언트를 기다리고 있어요!");
			
			soc = server_Soc.accept(); // 서버는 클라이언트가 접속할 때까지 대기
			System.out.println("대기대기대기대기...");
			
			br = new BufferedReader(new InputStreamReader(soc.getInputStream())); //클라이언트로부터 데이터를 읽어 올 준비를 한다
			pw = new PrintWriter(soc.getOutputStream()); //클라이언트로 데이터를 보낼 준비를 함
			
			String readData = ""; //클라이언트로부터 읽어올 데이터를 저장할 공간
			String readname = "";
			
			while(!(readData = br.readLine()).equals(null)) {  //상대가 접속을 끊을때까지 while문 
				System.out.println(readname + readData); //클라이언트가 보낸 이름과 메세지를 읽는다
				pw.println(readData); //읽은 메세지 그대로 클라이언트한테 보낸다
				pw.flush(); // 프린트라이터 메모리를 초기화 > 이 메소드가 행햐져야 실질적으로 데이터가 전송됨
			}
			
			soc.close(); //접속이 끊어진 경우, 소켓을 닫는다
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new Server();

	}

}

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SenderQ extends Thread {
	
	Socket socket;
	PrintWriter out = null;
	String name;
	
	//생성자
	public SenderQ(Socket socket,String name)
	{
		this.socket = socket;
		try {
			out = new PrintWriter(this.socket.getOutputStream(),true);
			this.name = name;
		} catch (Exception e) {
			System.out.println("예외S3:" + e);
		}
	}
	
	@Override
	public void run() {
		
		Scanner s = new Scanner(System.in);
			
		try {
			// 서버에 입력한 사용자이름을 보내준다.
			out.println(name);
			
			while (out!=null) {
				  try{
					  String s2 = s.nextLine();
					if(s2.equals("q")||s2.equals("Q") ) {
						break;
					} else {
						out.println(name+"=>"+s2);
					}
					
				} catch (Exception e) {
					System.out.println("예외s1:" + e);
				}
			}
		
			out.close();
			
			socket.close();
			
		} catch (Exception e) {
			System.out.println("예외s2:"+ e);
		}

	}

}

import java.io.*;
import java.net.Socket;

public class Receiver6 extends Thread {

	Socket socket;
	BufferedReader in = null;
	
	public Receiver6(Socket socket) {
		
		this.socket = socket;
		
		try {
			in = new BufferedReader(new InputStreamReader (
										this.socket.getInputStream() ));
		} catch (Exception e) {
			System.out.println( "예외 : " + e );
		}
	}
	
	@Override
	public void run() {
		while (in!=null) {
			try {
				System.out.println(">>" + in.readLine());
			} catch (java.net.SocketException ne) {
				break;
				
			} catch(Exception e) {
				System.out.println("예외 : " + e );
			} 
			
		}
		
		try {
			in.close();
		} catch (Exception e) {
			System.out.println("예외 3 : " + e );
		}

	}

}

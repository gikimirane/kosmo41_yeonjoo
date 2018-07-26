import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer01 {

	public static void main(String[] args) {
		
		try {
			ServerSocket serverSoc = new ServerSocket(9999);
			System.out.println("접속 대기 중...");
			HashMap hm = new HashMap();

			while (true) {
				
				Socket sock = serverSoc.accept();
				ChatThread chatthread = new ChatThread(sock, hm);
				chatthread.start();
			
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("... ... .. ");
	}
}

class ChatThread extends Thread {

	Socket socket;
	String name;
	BufferedReader br;
	PrintWriter pw;
	HashMap hm;

	private boolean initFlag = false;

	public ChatThread(Socket socket, HashMap hm) {
		this.socket = socket;
		this.hm = hm;

		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// System.out.println("11111");
			name = br.readLine();
			// System.out.println("22222");
			broadcast("[ " + name + " ] 님이 접속했습니다.");
			System.out.println("접속한 사용자의 아이디는 [ " + name + " ] 입니다.");

			synchronized (hm) {
				hm.put(this.name, pw);
			}

			initFlag = true;
		} catch (Exception ex) {
			// System.out.println("111111111");
			ex.printStackTrace();
		}
	}

	public void run() {
		try {
			String line = null;
			System.out.println("1111111111");
			while ((line = br.readLine()) != null) {
				broadcast(name + ":" + line);
			}
			System.out.println("22222222222");
		} catch (Exception ex) {
			// System.out.println("2222222");
			ex.printStackTrace();
		} finally {
			synchronized (hm) {
				hm.remove(name);
			}
			try {
				if (socket != null)
					socket.close();
			} catch (Exception ex) {
			}
		}

	}

	public void broadcast(String msg) {
		
		synchronized (hm) {
			Collection col = hm.values();
			Iterator iter = col.iterator();
			
			while (iter.hasNext()) {
				PrintWriter pw = (PrintWriter) iter.next();
				pw.println(msg);
				pw.flush();
			}
		}
	}
}

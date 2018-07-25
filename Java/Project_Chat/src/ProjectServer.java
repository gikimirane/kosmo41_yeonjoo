import java.io.*;
import java.net.*;
import java.util.*;

public class ProjectServer {

	ServerSocket serverSocket = null;
	Socket socket = null;
	Map<String, PrintWriter> clientMap;

	public ProjectServer() {
		clientMap = new HashMap<String, PrintWriter>();
		Collections.synchronizedMap(clientMap);
	}

	public void init() {

		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버 시작");

			while (true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + ":" + socket.getPort());

				Thread msr = new MultiServerT(socket);
				msr.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void sendAllMsg(String msg) {

		Iterator it = clientMap.keySet().iterator();

		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
				it_out.println(msg);
			} catch (Exception e) {
				System.out.println("예외1:" + e);
			}
		}
	}

	public static void main(String[] args) {
		ProjectServer ms = new ProjectServer();
		ms.init();
	}

	class MultiServerT extends Thread {

		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;

		public MultiServerT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			} catch (Exception e) {
				System.out.println("예외2:" + e);
			}
		}

		@Override
		public void run() {

			String name = "";
			try {
				name = in.readLine();

				sendAllMsg("["+ name + "]님 입장 ");

				clientMap.put(name, out);
				System.out.print("현재 접속자 는 [ " + name + " ]님 이고,");
				System.out.println("현재 접속자 수는 [ " + clientMap.size() + " ]명 입니다.");
				

				String s = "";
				while (in != null) {
					s = in.readLine();
					System.out.println(s);
					if (s.equals("bye") || s.equals("BYE"))
						break;
					sendAllMsg(s);
				}

			} catch (Exception e) {
				System.out.println("예외3:" + e);
			} finally {
				clientMap.remove(name);
				sendAllMsg("[ "+ name + " ]님이 퇴장하셨습니다.");
				System.out.println("현재 접속자 수는 [ " + clientMap.size() + " ] 명 입니다.");

				try {
					in.close();
					out.close();

					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

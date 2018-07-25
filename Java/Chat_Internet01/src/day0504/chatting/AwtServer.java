package day0504.chatting;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.security.Provider.Service;

public class AwtServer extends Frame implements Runnable {

	TextArea area;
	ServerSocket serverSocket;
	Socket socket;
	// String nickname;

	// 접속한 클Service저장해 둘 벡터
	Vector<Service> list = new Vector<>();

	public AwtServer(String title) {

		super(title);

		this.setBackground(new Color(253, 228, 153));
		this.setBounds(300, 100, 300, 500);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setDesign();
		this.setVisible(true);

	}

	@Override
	public void run() {

		try {

			serverSocket = new ServerSocket(9999);
			area.append("서버 소켓 생성 \n");

			while (true) {
				socket = serverSocket.accept();
				area.append(socket.getInetAddress().getHostAddress() + "접속함\n");

				Service s = new Service(socket);

				list.add(s);

				s.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class Service extends Thread {

		Socket socket;
		InputStreamReader is;
		BufferedReader br;
		PrintWriter pw;
		String nickName;

		Service(Socket socket) {
			this.socket = socket;
			try {

				is = new InputStreamReader(socket.getInputStream());
				br = new BufferedReader(is);
				pw = new PrintWriter(socket.getOutputStream());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			while (true) {
				try {

					String line = br.readLine();
					StringTokenizer st = new StringTokenizer(line, "|");
					int num = Integer.parseInt(st.nextToken());

					switch (num) {

					case 1: {
						nickName = st.nextToken();
						String allNames = "";
						for (int i = 0; i < list.size(); i++) {
							Service ss = list.get(i);
							allNames += ss.nickName + ",";
						}

						allNames.substring(0, nickName.length() - 1);

						for (int i = 0; i < list.size(); i++) {
							Service ss = list.get(i);
							ss.pw.write("1|" + nickName + "|" + allNames + "\n");
							ss.pw.flush();
						}
						break;
					}

					case 2: {

						String m = st.nextToken();
						for (int i = 0; i < list.size(); i++) {

							Service ss = list.get(i);
							ss.pw.write("2|" + nickName + ">>" + m + "\n");
							ss.pw.flush();
						}
						break;

					}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
	
	public void setDesign() {
		area = new TextArea();
		this.add("Center",area);
	}
	public static void main(String[] args) {
		// new AwtServer("Server창")
		
		AwtServer s = new AwtServer("Server 창");
		new Thread(s).start();

	}

}

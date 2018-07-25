import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class AwtClient extends Frame implements ActionListener, Runnable {

	TextArea area;
	TextField tfMessage;
	Button btnSend;
	Button saveBtn;

	List list;
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	String nickName;

	int nCnt = 0;
	int iMonth = 0, iDate = 0, iHour = 0, iMinute = 0, iSecond = 0;

	String fileName;
	String filePath;
	FileWriter fw;

	public AwtClient(String title) {

		super(title);

		this.setBackground(Color.cyan);
		this.setBounds(600, 100, 400, 400);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		this.setDesign();
	}

	@Override
	public void run() {

		try {

			InputStreamReader is = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(is);
			pw = new PrintWriter(socket.getOutputStream());

			pw.write("1|" + nickName + "\n");
			pw.flush();

			while (true) {

				String line = br.readLine();
				StringTokenizer st = new StringTokenizer(line, "|");
				int num = Integer.parseInt(st.nextToken());

				switch (num) {

				case 1: {

					String msg = st.nextToken();
					area.append(">>" + msg + "님이 로그인 하였습니다. \r\n");

					String names = st.nextToken();
					StringTokenizer st2 = new StringTokenizer(names, ",");

					list.removeAll();

					while (st2.hasMoreTokens()) {

						list.add(st2.nextToken());
					}

					break;
				}
				case 2: {

					String msg = st.nextToken();
					area.append(msg + "\n");
					break;
				}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if(tfMessage == ob || btnSend == ob) {
			
			String msg = tfMessage.getText();
			pw.write("2|" + msg + "\r\n");
			pw.flush();
			
			tfMessage.setText("");
			tfMessage.requestFocus();
			
		}
		
		else if (saveBtn == ob) {
			
			String saveStr = area.getText();
			saveStr.replaceAll("\n","\r\n");
			
			try {
				
				fw = new FileWriter(filePath);
				fw.write(saveStr);
				fw.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		String msg = "대화내용이 저장되었습니다.";
		pw.write("2|" + msg + "\n");
		pw.flush();
		
	}

}
	
	public void setDesign() {
		
		setPath();
		
		try {
			
			fw = new FileWriter(filePath,true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Panel p1 = new Panel();
		p1.setLayout(new BorderLayout());
		this.add("Center",p1);
		
		area = new TextArea();
		list = new List();
		
		this.add("Center", area);
		this.add("East",list);
		
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		this.add("south",p);
		
		tfMessage = new TextField();
		btnSend = new Button("전송");
		saveBtn = new Button("대화내용 저장");
		
		p.add("West", new Label("메세지"));
		p.add("Center", tfMessage);
		p.add("East",btnSend);
		p.add("West",saveBtn);
		
		tfMessage.addActionListener(this);
		btnSend.addActionListener(this);
		saveBtn.addActionListener(this);
		
	}

	public void setPath() {
		
		Calendar cal = Calendar.getInstance();
		
		iMonth = cal.get(Calendar.MONTH) + 1;
		iDate = cal.get(Calendar.DATE);
		iHour = cal.get(Calendar.HOUR_OF_DAY);
		iMinute = cal.get(Calendar.MINUTE);
		iSecond = cal.get(Calendar.SECOND);
		
		fileName = String.format("%02d%02d_%02d%02d%02d", iMonth,iDate,iHour,iMinute,iSecond);
		
		filePath = String.format("d:/java/%s.txt", fileName);
		
	}
	
	/*
	 * public static void main(String[] args) {
	 
		// new AwtServer("Frame 기본창")
	
	} */

}

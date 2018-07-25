
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class AwtLogin extends Frame implements ActionListener {

	TextField tfNickname, tfIp;
	Button btnLogin;

	Socket socket;
	AwtClient client = new AwtClient("채팅");
	String nickName;

	public AwtLogin(String title) {

		super(title);

		this.setBounds(300, 100, 200, 150);

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
	public void actionPerformed(ActionEvent e) {

		Object ob = e.getSource();
		if (ob == btnLogin) {

			nickName = tfNickname.getText();
			String ip = tfIp.getText();

			try {

				socket = new Socket(ip, 7000);

				client.socket = socket;

				client.nickName = nickName;
				client.setTitle(nickName + "님의 채팅창");

				this.setVisible(false);
				new Thread(client).start();

				client.setVisible(true);

			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public void setDesign() {
		
		this.setLayout(null);
		Label label1,label2;
		
		label1 = new Label("닉네임");
		label2 = new Label("IP 주소");
		
		tfNickname = new TextField("User");
		btnLogin = new Button("로그인");
		tfIp = new TextField("192.168.0.8");
		
		label1.setBounds(20, 40, 50, 25);
		this.add(label1);
		
		label2.setBounds(20, 70, 70, 25);
		this.add(label2);
		
		tfNickname.setBounds(100, 40, 60, 25);
		this.add(tfNickname);
		
		tfIp.setBounds(100, 70, 80, 25);
		this.add(tfIp);
		
		btnLogin.setBounds(70, 110, 60, 25);
		this.add(btnLogin);
		
		btnLogin.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new AwtLogin("채팅로그인");
	
	}

}

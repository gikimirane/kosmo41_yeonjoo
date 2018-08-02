import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/* 09 단계 : GUI를 입히는 작업 */

// 인터페이스의 정의

interface INIT_MENU {

	int INPUT = 1, EXIT = 2;
}

interface INPUT_SELECT {

	int NOR = 1, UNIV = 2, COM = 3;

}

// 메뉴 선택을 잘못 입력 했을 경우 실행

class MenuChoiceException extends Exception {

	int wrongChoice;

	public MenuChoiceException(int choice) {

		super("잘못된 선택이 이뤄졌습니다");
		wrongChoice = choice;
	}

	public void showWrongChoice() {
		System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
	}
}

class PhoneInfo implements Serializable {

	String name, phoneNum;

	public PhoneInfo(String name, String num) {

		this.name = name;
		phoneNum = num;

	}

	public void showPhoneInfo() {

		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNum);

	}

	public String toString() {
		return "name : " + name + '\n' + "phone : " + phoneNum + '\n';
	}

	public int hashcode() {

		return name.hashCode();

	}

	public boolean equals(Object obj) {
		PhoneInfo cmp = (PhoneInfo) obj;
		if (name.compareTo(cmp.name) == 0)
			return true;
		else
			return false;
	}

}

class PhoneUnivInfo extends PhoneInfo { // name,num 상속

	String major;
	int year;

	public PhoneUnivInfo(String name, String num, String major, int year) {

		super(name, num); // 자신을 가리키는 키워드가 this 라면 부모를 가리키는 키워드는 super
		this.major = major;
		this.year = year;

	}

	public void showPhoneInfo() {

		super.showPhoneInfo();
		System.out.println("major : " + major);
		System.out.println("year  : " + year);

	}

	public String toString() {
		return super.toString() + "major : " + major + '\n' + "year : " + year + '\n';
	}

}

class PhoneCompanyInfo extends PhoneInfo {

	String company;

	public PhoneCompanyInfo(String name, String num, String company) {

		super(name, num);
		this.company = company;

	}

	public void showPhoneInfo() {

		super.showPhoneInfo();
		System.out.println("company : " + company);
	}

	public String toString() {
		return super.toString() + "company : " + company + '\n';
	}
}

// 흐름 구성 클래스

class PhoneBookManager {

	private final File dataFile = new File("PhoneBook.dat"); // 데이터를 저장할 파일 생성
	HashSet<PhoneInfo> infoSt = new HashSet<PhoneInfo>();

	static PhoneBookManager inst = null;

	public static PhoneBookManager createManagerInst() {
		if (inst == null)
			inst = new PhoneBookManager();

		return inst;
	}

	private PhoneBookManager() {
		readFromFile();
	}

	private PhoneInfo i_Info() {

		System.out.print("이    름 : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuV.keyboard.nextLine();

		return new PhoneInfo(name, phone);

	}

	private PhoneInfo u_Info() {

		System.out.print("이    름 : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuV.keyboard.nextLine();
		System.out.print("전    공 : ");
		String major = MenuV.keyboard.nextLine();
		System.out.print("학    년 : ");
		int year = MenuV.keyboard.nextInt();
		MenuV.keyboard.nextLine();

		return new PhoneUnivInfo(name, phone, major, year);

	}

	private PhoneInfo c_Info() {

		System.out.print("이    름 : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuV.keyboard.nextLine();
		System.out.print("회 사 명 : ");
		String company = MenuV.keyboard.nextLine();

		return new PhoneCompanyInfo(name, phone, company);
	}

	public void inputdata() throws MenuChoiceException {

		System.out.println("<< 데이터 입력 >>");
		System.out.println("1.일반 2.대학 3.회사 ");
		System.out.println("선택 값 입력 : ");

		int choice = MenuV.keyboard.nextInt();
		MenuV.keyboard.nextLine();

		PhoneInfo info = null;

		if (choice < INPUT_SELECT.NOR || choice > INPUT_SELECT.COM)
			throw new MenuChoiceException(choice);

		switch (choice) {
		case INPUT_SELECT.NOR:
			info = i_Info();
			break;
		case INPUT_SELECT.UNIV:
			info = u_Info();
			break;
		case INPUT_SELECT.COM:
			info = c_Info();
			break;
		}

		boolean isAdded = infoSt.add(info);
		if (isAdded == true)
			System.out.println("데이터 입력이 완료되었습니다.\n");
		else
			System.out.println("이미 저장된 데이터입니다.\n");

	}

	public String searchData(String name) {

		PhoneInfo info = search(name);
		if (info == null)
			return null;
		else
			return info.toString();
	}

	public boolean deleteData(String name) {

		Iterator<PhoneInfo> itr = infoSt.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.name) == 0) {
				itr.remove();
				return true;
			}
		}
		return false;

	}

	private PhoneInfo search(String name) {

		Iterator<PhoneInfo> itr = infoSt.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.name) == 0)
				return curInfo;
		}

		return null;
	}

	public void storeToFile() {
		try {
			FileOutputStream file = new FileOutputStream(dataFile);
			ObjectOutputStream out = new ObjectOutputStream(file);

			Iterator<PhoneInfo> itr = infoSt.iterator();
			while (itr.hasNext())
				out.writeObject(itr.next());

			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readFromFile() {
		if (dataFile.exists() == false)
			return;
		try {
			FileInputStream file = new FileInputStream(dataFile);
			ObjectInputStream in = new ObjectInputStream(file);

			while (true) {
				PhoneInfo info = (PhoneInfo) in.readObject();
				if (info == null)
					break;
				infoSt.add(info);

			}
			in.close();

		} catch (IOException e) {
			return;
		} catch (ClassNotFoundException e) {
			return;
		}
	}
}


class MenuV {

	public static Scanner keyboard = new Scanner(System.in);

	public static void showMenu() {

		System.out.println("");
		System.out.println("원하시는 메뉴를 선택 하세요");
		System.out.println("1. 데이터 입력 ");
		System.out.println("2. 프로그램 종료 ");
		System.out.println("선택 값 입력 :");

	}
}

class SearchEventHandler implements ActionListener{
	
	JTextField searchField;
	JTextArea textArea;
	
	public SearchEventHandler(JTextField field, JTextArea area) {
		searchField = field;
		textArea = area;
	}
	public void actionPerformed(ActionEvent e)
	{
		String name = searchField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		String srchResult = manager.searchData(name);
		if(srchResult == null) {
			textArea.append(" << 해당 데이터가 존재하지 않음>> ");
		}
		else
		{
			textArea.append(" << 검색 데이터 정보 >> \n");
			textArea.append(srchResult);
			textArea.append("\n");
		}

	}
	
}


class DeleteEventHandler implements ActionListener {
	
	JTextField delField;
	JTextArea textArea;
	
	public DeleteEventHandler(JTextField field, JTextArea area) {
		delField = field;
		textArea = area;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String name = delField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		boolean isDeleted = manager.deleteData(name);
		if(isDeleted) 
			textArea.append(" << 해당 데이터 삭제 완료>> ");
		else
			textArea.append(" << 해당 데이터가 존재하지 않음>> \n");
		}

	}
	
	class SearchDelFrame extends JFrame {
		
		JTextField srchField = new JTextField(15);
		JButton srchBtn = new JButton("SEARCH");
		
		JTextField delField = new JTextField(15);
		JButton delBtn = new JButton("DEL");
		
		JTextArea textArea = new JTextArea(20,25);
		
		public SearchDelFrame(String title) {
			
			super(title);
			setBounds (100,200,330,450);
			setLayout (new BorderLayout());
			Border border = BorderFactory.createEtchedBorder();
			
			Border srchBorder = BorderFactory.createTitledBorder(border,"Search");
			JPanel srchPanel = new JPanel();
			srchPanel.setBorder(srchBorder);
			srchPanel.setLayout(new FlowLayout());
			srchPanel.add(srchField);
			srchPanel.add(srchBtn);
			
			Border delBorder = BorderFactory.createTitledBorder(border,"Delete");
			JPanel delPanel = new JPanel();
			srchPanel.setBorder(delBorder);
			srchPanel.setLayout(new FlowLayout());
			srchPanel.add(delField);
			srchPanel.add(delBtn);
			
			JScrollPane scrollTextArea = new JScrollPane(textArea);
			Border textBorder = BorderFactory.createTitledBorder(border,"Infomation Board");
			scrollTextArea.setBorder(textBorder);
			
			add(srchPanel,BorderLayout.NORTH);
			add(delPanel,BorderLayout.SOUTH);
			add(scrollTextArea, BorderLayout.CENTER);
			
			srchBtn.addActionListener(new SearchEventHandler(srchField,textArea));
			delBtn.addActionListener(new DeleteEventHandler(delField,textArea));
			
			setSize(600, 500);
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}
	}

// 실행(메인) 클래스

class PhoneBookVer09 {

	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		SearchDelFrame winFrame = new SearchDelFrame("PhoneBookVer09");
		int choice;

		while (true) {

			try {

				MenuV.showMenu(); // 상단 메뉴클래스 호출
				choice = MenuV.keyboard.nextInt();
				MenuV.keyboard.nextLine();

				if (choice < INIT_MENU.INPUT || choice > INIT_MENU.EXIT)
					throw new MenuChoiceException(choice);

				switch (choice) {
				
				case INIT_MENU.INPUT:
					manager.inputdata();
					break;
					
				case INIT_MENU.EXIT:
					manager.storeToFile();
					System.out.println("[ 프로그램 종료 ] ");
					System.out.println("[  사 요 나 라  ] ");
					System.exit(0);
					return;
				}

			} catch (MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("[ 메뉴 선택 재진행 ] ");

			}

		}

	}

}
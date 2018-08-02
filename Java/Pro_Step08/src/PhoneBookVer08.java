import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/* 08 단계 : 프로그램종료 후에도 데이터가 남아있도록 저장하는 기능 추가 */




// 인터페이스의 정의

interface INIT_MENU {

	int INPUT = 1, SEARCH = 2, DEL = 3, EXIT = 4;
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

class PhoneInfo {

	String name, phoneNum;

	public PhoneInfo(String name, String num) {

		this.name = name;
		phoneNum = num;

	}

	public void showPhoneInfo() {

		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNum);

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

	String major, year;

	public PhoneUnivInfo(String name, String num, String major, String year) {

		super(name, num); // 자신을 가리키는 키워드가 this 라면 부모를 가리키는 키워드는 super
		this.major = major;
		this.year = year;

	}

	public void showPhoneInfo() {

		super.showPhoneInfo();
		System.out.println("[전    공] : " + major);
		System.out.println("[학    년] : " + year);

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
		System.out.println("[회 사 명] : " + company);
		                  
	}

} // 흐름 구성 클래스

class PhoneBookManager {

	private final File dataFile=new File("PhoneBook.dat"); 
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

		System.out.print("[이    름] : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("[전화번호] : ");
		String phone = MenuV.keyboard.nextLine();

		return new PhoneInfo(name, phone);

	}

	private PhoneInfo u_Info() {

		System.out.print("[이    름] : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("[전화번호] : ");
		String phone = MenuV.keyboard.nextLine();
		System.out.print("[전    공] : ");
		String major = MenuV.keyboard.nextLine();
		System.out.print("[학    년] : ");
		String year = MenuV.keyboard.nextLine();

		return new PhoneUnivInfo(name, phone, major, year);

	}

	private PhoneInfo c_Info() {

		System.out.print("[이    름] : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("[전화번호] : ");
		String phone = MenuV.keyboard.nextLine();
		System.out.print("[회 사 명] : ");
		String company = MenuV.keyboard.nextLine();

		return new PhoneCompanyInfo(name, phone, company);
	}

	public void inputdata() throws MenuChoiceException {

		System.out.println("[데이터 입력]");
		System.out.println("[1] 일반 [2] 대학 [3] 회사 ");
		System.out.print("[선택 값 입력] : ");

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
			System.out.println("[데이터 입력이 완료] ");
		else
			System.out.println("[이미 저장된 데이터입니다.] ");

	}

	public void searchData() {

		System.out.println("[데이터 검색] ");

		System.out.print("[검색할 이름 입력] : ");
		String name = MenuV.keyboard.nextLine();
		
		PhoneInfo info = search(name);
		if (info == null) {
			System.out.println("<< 해당하는 데이터없음 >> \n");
		} else {
			info.showPhoneInfo();
			System.out.println("<< 데이터 검색 완료 >>");
		}
	}

	public void delData() {

		System.out.println("<< 데이터 삭제 >>");

		System.out.print("이름으로 검색 후 삭제 : ");
		String name = MenuV.keyboard.nextLine();

		Iterator<PhoneInfo> itr = infoSt.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.name) == 0) {
				itr.remove();
				System.out.println(" << 데이터 삭제 완료 >> \n");
				return;
			}
		}
		System.out.println("<< 해당하는 데이터 없음 >> \n");
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
	
	public void storeToFile()
	{
		try {
			FileOutputStream file = new FileOutputStream(dataFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			Iterator<PhoneInfo> itr = infoSt.iterator();
			while(itr.hasNext())
				out.writeObject(itr.next());
			
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		public void readFromFile()
		{
			if(dataFile.exists() == false)
				return;
			try {
				FileInputStream file = new FileInputStream(dataFile);
				ObjectInputStream in = new ObjectInputStream(file);
				
				while(true) {
					PhoneInfo info = (PhoneInfo)in.readObject();
					if(info==null)
						break;
					infoSt.add(info);
					
				}
				in.close();
				
			} catch (IOException e) {
				return;
			}
			  catch(ClassNotFoundException e)
			{
				  return;
			}
		}
}

class MenuV {

	public static Scanner keyboard = new Scanner(System.in);

	public static void showMenu() {

		System.out.println("");
		System.out.println("원하시는 메뉴를 선택 하세요");
		System.out.println("데 이 터 입력  : 1 ");
		System.out.println("데 이 터 검색  : 2 ");
		System.out.println("데 이 터 삭제  : 3 ");
		System.out.println("프로그램 종료  : 4 ");
		System.out.println("");
		System.out.println("선택 값 입력 :");

	}
}

// 실행(메인) 클래스

class PhoneBookVer08 {

	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.createManagerInst();
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
				case INIT_MENU.SEARCH:
					manager.searchData();
					break;
				case INIT_MENU.DEL:
					manager.delData();
					break;
				case INIT_MENU.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				}

			} catch (MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행 합니다.");

			}

		}

	}
}

import java.util.*;

/* 07 단계 : HashSet<E>를 사용하여 동명이인이면 동일 데이터로 인식하게 하기 */

// 인터페이스의 정의

interface INIT_MENU {

	int INPUT = 1, SEARCH = 2, DEL = 3, EXIT = 4;
}

interface INPUT_SELECT {

	int NOR = 1, UNIV = 2, COM = 3;

}

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

	public boolean eequals(Object obj) {
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
		System.out.println("major : " + major);
		System.out.println("year  : " + year);

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

} // 흐름 구성 클래스

class PhoneBookManager {

	// final int MAX = 100; // final 메소드가 더이상 오버라이딩 되지 않아야 할 때 사용
	// PhoneInfo[] infoSt = new PhoneInfo[MAX];
	// int Count = 0;

	HashSet<PhoneInfo> infoSt = new HashSet<PhoneInfo>();

	static PhoneBookManager inst = null;

	public static PhoneBookManager createManagerInst() {
		if (inst == null)
			inst = new PhoneBookManager();

		return inst;
	}

	private PhoneBookManager() {
	}

	private PhoneInfo i_Info() {

		System.out.println("<< 일반 데이터 입력 >>");

		System.out.print("이    름 : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuV.keyboard.nextLine();

		return new PhoneInfo(name, phone);

	}

	private PhoneInfo u_Info() {

		System.out.println("<< 대학동기 데이터 입력 >>");

		System.out.print("이    름 : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuV.keyboard.nextLine();
		System.out.print("전    공 : ");
		String major = MenuV.keyboard.nextLine();
		System.out.print("학    년 : ");
		String year = MenuV.keyboard.nextLine();

		return new PhoneUnivInfo(name, phone, major, year);

	}

	private PhoneInfo c_Info() {

		System.out.println("<< 회사동료 데이터 입력 >>");

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

		// infoSt[Count] = info;
		boolean isAdded = infoSt.add(info);
		if (isAdded == true)
			System.out.println("데이터 입력이 완료되었습니다.\n");
		else
			System.out.println("이미 저장된 데이터입니다.\n");

	}

	public void searchData() {

		System.out.println("<< 데이터 검색 >> ");

		System.out.print(" 이름으로 검색 : ");
		String name = MenuV.keyboard.nextLine();

		/*
		 * int dataIdx = search(name);
		 * 
		 * if (dataIdx < 0) { System.out.println("<< 해당하는 데이터없음 >> \n"); } else {
		 * infoSt[dataIdx].showPhoneInfo(); System.out.println(" << 데이터 검색 완료 >> \n"); }
		 * }
		 */
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

		/*
		 * int dataIdx = search(name);
		 * 
		 * 
		 * if (dataIdx < 0) { System.out.println("<< 해당하는 데이터없음 >> \n"); } else {
		 * 
		 * for (int idx = dataIdx; idx < (Count - 1); idx++) infoSt[idx] = infoSt[idx +
		 * 1];
		 * 
		 * Count--; System.out.println("<< 데이터 삭제 완료 >> \n"); }
		 */

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

		/*
		 * for (int idx = 0; idx < Count; idx++) { PhoneInfo curInfo = infoSt[idx]; if
		 * (name.compareTo(curInfo.name) == 0) return idx; }
		 */
		Iterator<PhoneInfo> itr = infoSt.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.name) == 0)
				return curInfo;
		}

		return null;
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

class PhoneBookVer07 {

	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		int choice;

		while (true) {

			try {

				MenuV.showMenu(); // 상단 메뉴클래스 호출
				choice = MenuV.keyboard.nextInt();
				MenuV.keyboard.nextLine();

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

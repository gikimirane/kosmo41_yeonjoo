import java.util.Scanner;

/* 04 단계 : 전화번호 관리 프로그램 
             ㄴ birth와 관련된 코드 - 삭제 
             ㄴ 대학동기 전화번호 및 회사동료 전화번호 저장 - 추가 */

//데이터 저장 클래스

class PhoneInfo {

	String name, phoneNum;

	public PhoneInfo(String name, String num) {

		this.name = name;
		phoneNum = num; 

	}

	public void showPhoneInfo() {

		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNum);

		System.out.println("");
	}

}
	

class PhoneUnivInfo extends PhoneInfo {  // name,num 상속

	String major, year;

	public PhoneUnivInfo(String name,String num,String major, String year) {

		super(name,num);      // 자신을 가리키는 키워드가 this 라면 부모를 가리키는 키워드는 super
 		this.major = major;
		this.year = year;

	}

	
class PhoneCompanyInfo extends PhoneInfo {  

		String company;

		public PhoneCompanyInfo(String name,String num,String company) {

			super(name,num);
			this.company = company;

		}	
		
	
//흐름 구성 클래스

class PhoneBookManager {

	final int MAX = 100;                      //final 메소드가 더이상 오버라이딩 되지 않아야 할 때 사용 
	PhoneInfo[] infoSt = new PhoneInfo[MAX];

	int Count = 0;

	public void inputData() {

		System.out.println("<< 일반 데이터 입력 >>");

		System.out.print("이    름 : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuV.keyboard.nextLine();

		infoSt[Count++] = new PhoneInfo(name, phone);
		System.out.println("<< 일반 데이터 입력 완료 >>");
	}

	public void U_inputData() {

		System.out.println("<< 대학동기 데이터 입력 >>");

		System.out.print("이    름 : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuV.keyboard.nextLine();
		System.out.print("전    공 : ");
		String major = MenuV.keyboard.nextLine();
		System.out.print("학    년 : ");
		String year = MenuV.keyboard.nextLine();

		//infoSt[Count++] = new PhoneInfo(name, phone, major, year);
		
		System.out.println("<< 데이터 입력 완료 >>");
	}
	
	public void C_inputData() {

		System.out.println("<< 데이터 입력 >>");

		System.out.print("이름 : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuV.keyboard.nextLine();

		infoSt[Count++] = new PhoneInfo(name, phone);
		System.out.println("<< 데이터 입력 완료 >>");
	}
	public void searchData() {

		System.out.println("<< 데이터 검색 >> ");

		System.out.print(" 이름으로 검색 : ");
		String name = MenuV.keyboard.nextLine();

		int dataIdx = search(name);
		if (dataIdx < 0) {
			System.out.println("<< 해당하는 데이터없음 >> \n");
		} else {
			infoSt[dataIdx].showPhoneInfo();
			System.out.println(" << 데이터 검색 완료 >> \n");
		}
	}

	public void delData() {
		
		System.out.println("<< 데이터 삭제 >>");

		System.out.print("이름으로 검색 후 삭제 : ");
		String name = MenuV.keyboard.nextLine();

		int dataIdx = search(name);

		if (dataIdx < 0) {
			System.out.println("<< 해당하는 데이터없음 >> \n");
		} else {

			for (int idx = dataIdx; idx < (Count - 1); idx++)
				infoSt[idx] = infoSt[idx + 1];

			Count--;
			System.out.println("<< 데이터 검색 완료 >> \n");
		}
	}

	private int search(String name) {

		for (int idx = 0; idx < Count; idx++) {
			PhoneInfo curInfo = infoSt[idx];
			if (name.compareTo(curInfo.name) == 0)
				return idx;
		}
		return -1;
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
	
class PhoneBookVer03 {

		public static void main(String[] args) {

			PhoneBookManager manager = new PhoneBookManager();
			int choice;

			while (true) {

				MenuV.showMenu(); // 상단 메뉴클래스 호출
				choice = MenuV.keyboard.nextInt();
				MenuV.keyboard.nextLine();

				switch (choice) {
				case 1:
					manager.inputData();
					break;
				case 2:
					manager.searchData();
					break;
				case 3:
					manager.delData();
					break;
				case 4:
					System.out.println("프로그램을 종료합니다.");
					return;
				}

			}

		}

	}


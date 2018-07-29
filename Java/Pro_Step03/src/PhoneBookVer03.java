import java.util.Scanner;

/* 03 단계 : 배열을 이용한 데이터 입력,검색,삭제 */

// 데이터 저장 클래스

class PhoneInfo {

	String name, phoneNum, birth;

	public PhoneInfo(String name, String num, String birth) {

		this.name = name;
		phoneNum = num; // 전화번호는 변수명을 변경해야 하기 때문에 this를 쓰지 않음
		this.birth = birth;

	}

	public PhoneInfo(String name, String num) {

		this.name = name;
		phoneNum = num;
		this.birth = null; // 공백 값에도 넘어가야 하기 때문에 null값으로 초기화

	}

	public void showPhoneInfo() {

		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNum);

		if (birth != null)
			System.out.println("birth : " + birth);

		System.out.println("");
	}

}

// 흐름 구성 클래스

class PhoneBookManager {

	final int MAX = 100;                      //final 메소드가 더이상 오버라이딩 되지 않아야 할 때 사용 
	PhoneInfo[] infoSt = new PhoneInfo[MAX];

	int Count = 0;

	public void inputData() {

		System.out.println("<< 데이터 입력 >>");

		System.out.print("이름 : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuV.keyboard.nextLine();
		System.out.print("생년월일 : ");
		String birth = MenuV.keyboard.nextLine();

		infoSt[Count++] = new PhoneInfo(name, phone, birth);
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


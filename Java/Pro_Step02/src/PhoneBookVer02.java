import java.util.Scanner;

/* 02 단계 : 전화번호 관리 프로그램 
 *            ㄴ 사용자로부터 데이터 입력 */

class PhoneInfo {

	String name;
	String phoneNum;
	String birth;

	public PhoneInfo(String name, String num, String birth) {

		this.name = name;
		phoneNum = num;
		this.birth = birth;

	}

	public PhoneInfo(String name, String num) {

		this.name = name;
		phoneNum = num;
		this.birth = null;

	}

	public void showPhoneInfo() {

		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNum);

		if (birth != null)
			System.out.println("birth : " + birth);

		System.out.println("");
	}
}

class PhoneBookVer02 {

	static Scanner keyboard = new Scanner(System.in);

	public static void showMenu() {

		System.out.println("선택 하세요");
		System.out.println("데이터 입력  : Y / 프로그램 종료 : Q ");
		System.out.println("선택 값 입력 : ");

	}

	public static void readData() {

		System.out.print("이름 : ");
		String name = keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = keyboard.nextLine();
		System.out.print("생년월일 : ");
		String birth = keyboard.nextLine();

		PhoneInfo info = new PhoneInfo(name, phone, birth);
		System.out.println("\n입력된 정보 출력...");
		info.showPhoneInfo();

	}

	public static void main(String[] args) {

		int choice;

		while (true) {
			
			showMenu(); // 상단의 showMenu 호출
			
			choice = keyboard.nextInt(); // int형으로 선택 값을 받은 후 
			keyboard.nextLine();         // nextline으로 문자열을 읽어들이는 것으로 변환시켜줌 
                                         // 문자열 입력이 겹치지 않도록 해줌
			switch (choice) {
			case 1:
				readData();
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;
			}

		}

	}

}

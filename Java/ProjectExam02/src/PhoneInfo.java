// 인터페이스 메뉴 정의

interface INIT_MENU {

	int INPUT = 1, SEARCH = 2, DEL = 3, ALL = 4, EXIT = 5;
}

interface INPUT_SELECT {

	int NOR = 1, UNIV = 2, COM = 3;

}


// 메뉴 선택이 잘못되었을 경우

class MenuChoiceException extends Exception {

	int wrongChoice;

	public MenuChoiceException(int choice) {

		super("[ 잘못된 선택입니다. ] \n");
		wrongChoice = choice;
	}

	public void showWrongChoice() {
		System.out.println("[ " + wrongChoice + "에 해당하는 선택은 존재하지 않습니다. ] ");
	}
}


// 항목 정의

class PhoneInfo {

	String name, phoneNum;

	public PhoneInfo(String name, String num) {

		this.name = name;
		phoneNum = num;

	}

	public void showPhoneInfo() {

		System.out.println("[ 이    름 ] : " + name);
		System.out.println("[ 전화번호 ] : " + phoneNum);

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

// PhoneInfo를 상속받은 univ

class PhoneUnivInfo extends PhoneInfo { 
	String major;
	int year;

	public PhoneUnivInfo(String name, String num, String major, int year) {

		super(name, num); 
		this.major = major;
		this.year = year;

	}

	public void showPhoneInfo() {

		super.showPhoneInfo();
		System.out.println("[ 전    공 ] : " + major);
		System.out.println("[ 학    년 ] : " + year);

	}

}

//PhoneInfo를 상속받은 company

class PhoneCompanyInfo extends PhoneInfo {

	String company;

	public PhoneCompanyInfo(String name, String num, String company) {

		super(name, num);
		this.company = company;

	}

	public void showPhoneInfo() {

		super.showPhoneInfo();
		System.out.println("[ 회 사 명] : " + company);
		                  
	}

} 

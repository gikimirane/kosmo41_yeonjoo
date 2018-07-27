import java.util.Scanner;

/* 01 단계 : 전화번호 관리 프로그램 */

class PhoneInfo {

	String name;
	String phoneNum;
	String birth;

	public PhoneInfo(String name,String num, String birth) {
	
		this.name = name;
		phoneNum = num;
		this.birth = birth;
	
	}

	public PhoneInfo (String name, String num) {
		
		this.name = name;
		phoneNum = num;
		this.birth = null;

	}
	
	public void showPhoneInfo() {
		
		System.out.println("name : " + name );
		System.out.println("phone : " + phoneNum );
		
		if(birth != null)
			System.out.println("birth : " + birth );
		
		System.out.println("");
	}
}

class PhoneBookVer01 {
	
	public static void main(String[] args) {
	
		PhoneInfo pInfo1 = new PhoneInfo("박충재","010-1234-1234","80/08/19");
		PhoneInfo pInfo2 = new PhoneInfo("정필교","010-6666-6666"); 
	
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();
		
	}

}

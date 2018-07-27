import java.util.Scanner;

/* 02 단계 : 전화번호 관리 프로그램 
 *            ㄴ 사용자로부터 데이터 입력 (연주.ver) */

class PhoneInfo2_2 {

	String name;
	String phoneNum;
	String birth;

	public PhoneInfo2_2(String name, String num, String birth) {

		this.name = name;
		phoneNum = num;
		this.birth = birth;

	}

	public PhoneInfo2_2(String name, String num) {

		this.name = name;
		phoneNum = num;
		this.birth = null;

	}

	public void showPhoneInfo() {

		if (birth == null) {
			return;
		}
		
		System.out.println("---------- 회원정보 ----------");
		System.out.println("   name : " + name);
		System.out.println("  Phone : " + phoneNum);
		System.out.println("birtday : " + birth);
		
		System.out.println("");
	}

}

public class PhoneBookVer02_2 {

	public static void main(String[] args) {

		Scanner n = new Scanner(System.in);
		
		System.out.println("이름을 입력 하세요");

		String name = n.nextLine();

		System.out.println("전화번호를 입력 하세요");
		String num = n.nextLine();

		System.out.println("생년월일을 입력 하세요");
		String birth = null;
		birth = n.nextLine();

		PhoneInfo2_2 pInfo1 = new PhoneInfo2_2(name, num, birth);

		pInfo1.showPhoneInfo();

	}

}

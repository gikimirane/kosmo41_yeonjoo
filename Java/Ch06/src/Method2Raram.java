
public class Method2Raram {

	public static void main(String[] args) {
		double myheight = 175.9;
		hiEveryone (12, 120.5);
		hiEveryone (13, myheight);
		byEveryone();
	}
	
	public static void hiEveryone(int age,double height) {
		System.out.println(" 제 나이는 " + age + "세 입니다." );
		System.out.println("저의 키는 " + height + "cm 입니다.");
	}
	public static void byEveryone() {
		System.out.println("다음에 뵙겠습니다.");
	
	}

}

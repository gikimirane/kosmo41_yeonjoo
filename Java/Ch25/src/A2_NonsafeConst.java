//
// 열거형 기반으로 수정한 결과와 개선된 부분
//

interface Animal1 {
	int DOG = 1;
	int CAT = 2;
}

interface Person1 {
	int MAN = 1;
	int WOMAN = 2;
}

class A2_NonsafeConst {

	public static void main(String[] args) {
		// 정상적인 메소드 호출
		who(Person1.MAN);
		
		// 비정상적인 메소드 호출 
		// 컴파일 과정에서 자료형 불일치로 인한 오류 발생
		// '남성 손님을 호출한 것이 아니고 DOG를 호출 한것이기 때문에 비정상적인 호출'
		who(Animal1.DOG);
	}
	
	public static void who(int man) {
		switch(man) {
		case Person1.MAN:
			System.out.println("남성 손님입니다.");
			break;
		case Person1.WOMAN:
			System.out.println("여성 손님입니다.");
			break;
		}
		

	}

}

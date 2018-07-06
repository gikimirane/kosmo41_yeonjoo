//
// enum 으로 나눠서 정의하면 호출에 대한 오류가 적어짐.
//

enum Animal2 { DOG,CAT }

enum Person2 { MAN,WOMAN }

class A4_SafeEnum {

	public static void main(String[] args) {
		System.out.println(Animal2.DOG);
		// 정상적인 메소드 호출
		who(Person2.MAN);
		
		//비 정상적인 메소드 호출
	 // who(Animal2.DOG);
	
//      참고 : C처럼 숫자로 비교하면 에러가 난다.
//		 if(Person2.MAN == 0) {
//			
//		}
	
	}
	
	public static void who(Person2 man) {
		switch(man) {
		case MAN:
			System.out.println("남성 손님입니다.");
			break;
		case WOMAN:
			System.out.println("여성 손님입니다.");
			break;
		}
	}
}

// 컴파일 과정에서 자료형 불일치로 인한 오류 발생
// 잘못 사용할 확률이 적어짐.
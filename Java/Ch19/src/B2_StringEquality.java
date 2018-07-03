//
// equals 메소드는 Object클래스에 정의 되어 있고, 
// 다른 클래스에서 상속받아 오버라이딩 되어 있다.
// 일반적으로 '주소값(참조대상)'을 비교하지만, String 클래스에서는 '실제 값(내용)'을 비교한다.

class B2_StringEquality {

	public static void main(String[] args) {
		String str1 = new String("So Simple");
		String str2 = new String("So Simple");
		
		// '참조 대상'을 비교하는 if ~ else문
		if(str1 == str2)
			System.out.println("str1, str2 참조 대상 동일하다.");
		else
			System.out.println("str1, str2 참조 대상 다르다.");
		
		//두 '인스턴스 내용' 비교하는 if ~ else문
		if(str1.equals(str2))
			System.out.println("str1, str2 내용 동일하다.");
		else
			System.out.println("str1, str2 내용 다르다.");
	}

}

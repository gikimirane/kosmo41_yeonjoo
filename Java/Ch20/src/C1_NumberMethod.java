//
// Number 클래스의 추상 메소드 호출의 예
// ㄴ 래퍼 인스턴스에 저장된 값을 원하는 형의 '기본 자료형 값'으로 반환할 수 있다. 
//

public class C1_NumberMethod {

	public static void main(String[] args) {
		
		Integer num1 = new Integer(29);
		System.out.println(num1.intValue());    // int형 값으로 반환
		System.out.println(num1.doubleValue()); // double형 값으로 반환
		
		//double 는 실수형타입이기 때문에 29 뒤에 .0이 붙어서 출력 됨
		
		Double num2 = new Double(3.14);
		System.out.println(num2.intValue());    // int형 값으로 반환
		System.out.println(num2.doubleValue()); // double형 값으로 반환
		
		//int 는 정수형타입이기 때문에 .14는 생략되고 '3'만 출력 됨

	}

}

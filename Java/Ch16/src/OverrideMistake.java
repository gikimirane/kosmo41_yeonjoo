// 
// 오버라이딩 컴파일러오류 케이스
//

class ParentAdder {
	public int add(int a, int b ) {
		System.out.println("부모 add");
		return a + b;
	}
}

class ChildAdder extends ParentAdder {
	  public double add(double a, double b) {
	
	 // @Override
	 // public int add(int a, int b) {    << 오버라이딩 OK
		  
		System.out.println("덧셈을 진행합니다.");
		return a + b;
	}
}

class OverrideMistake {
	public static void main(String[] args) {
		ParentAdder adder = new ChildAdder ();
		System.out.println(adder.add(3, 4));

	}

}

// 오버라이딩 > 메서드명과 파라미터 모두 상위 클래스와 동일 해야 함 (시그너처가 같음)
// 위에 샘플의 경우 상위 클래스는 int 하위클래스는 double 이기 때문에 오버로딩이 됨
// ㄴ 시그니처가 다름

// @Override
// 상위 클래스의 메소드를 오버라이딩 한느 것이 목적이라는 선언!
// 오버라이딩 하는 형태가 아니면 컴파일러 오류 메시지 전달.
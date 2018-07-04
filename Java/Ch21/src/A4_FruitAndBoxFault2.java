//
// 제네릭 이전의 코드가 갖는 문제점 2
// ㄴ 프로그래머의 실수가 컴파일 > 실행 과정에서 조차 발견되지 않는다.

class Apple4 {
	public String toString() {
		return "I am an apple";
	}
}

class Orange4 {
	public String toString() {
		return "I am an orange";
	}
}

class Box4 {
	private Object ob;                 
	
	public void set(Object o) {  // Object로 통합해서 받음
		ob = o;
	}
	public Object get() {
		return ob;
	}
}

public class A4_FruitAndBoxFault2 {

	public static void main(String[] args) {
		Box4 aBox = new Box4();
		Box4 oBox = new Box4();
		
		// 과일을 박스에 담은것일까? 
		// 사과(내용)을 담은게 아니고 'Apple'이라는 '문자열'을 담음
		aBox.set("Apple");
		oBox.set("Orange");
		
		System.out.println(aBox.get()); // 형변환이 없어도 println에 경우 실행에서 
		System.out.println(oBox.get()); // 오류가 나지 않기 때문에 문제 발견이 어려움

	}

}

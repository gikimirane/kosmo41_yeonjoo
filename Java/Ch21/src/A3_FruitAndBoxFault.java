//
// 제네릭 이전의 코드가 갖는 문제점 1
// ㄴ 프로그래머의 실수가 컴파일 과정에서 발견되지 않는다.

class Apple3 {
	public String toString() {
		return "I am an apple";
	}
}

class Orange3 {
	public String toString() {
		return "I am an orange";
	}
}

class Box3 {
	private Object ob;                 
	
	public void set(Object o) {
		ob = o;
	}
	public Object get() {
		return ob;
	}
}

public class A3_FruitAndBoxFault {

	public static void main(String[] args) {
		Box3 aBox = new Box3();
		Box3 oBox = new Box3();
		
		// 과일을 박스에 담은것일까? 
		// 사과 오렌지를 담은게 아니고 'Apple'이라는 '문자열'을 담음
		aBox.set("Apple");
		oBox.set("Orange");
		
		// 박스에서 과일을 꺼낼 수 있을까? 
		// 실제 과일이 아닌 '문자열'을 넣었기 때문에 다시 꺼낼 수 없음
		Apple3 ap = (Apple3)aBox.get();   
		Orange3 og = (Orange3)oBox.get();
		
		System.out.println(ap);    //출력에서 오류발생
		System.out.println(og);    //컴파일 오류가 없기 때문에 문제 발견이 어려움
	}

}

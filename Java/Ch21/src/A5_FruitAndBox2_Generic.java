//
// 제네릭(템플릿) 클래스 기반 인스턴스 생성
// 

class Apple5 {
	public String toString() {
		return "I am an apple";
	}
}

class Orange5 {
	public String toString() {
		return "I am an orange";
	}
}

class Box5 <T> {               // Object로 통합사용이 아닌 T <<Type을 지정할수 있도록 함
	private T ob;                 
	
	public void set(T o) {     // 형 변환을 시켜주면서 저장
		ob = o;
	}
	public T get() {
		return ob;
	}
}
class A5_FruitAndBox2_Generic {

	public static void main(String[] args) {
		Box5<Apple5> aBox = new Box5<Apple5>();
		Box5<Orange5> oBox = new Box5<Orange5>();
		
		// 과일(출력하길원하는결과)를 박스에 담는다. 제네릭으로 타입 지정을 했기때문에 문제 X
		aBox.set(new Apple5());
		oBox.set(new Orange5());
		
		// 사과 오렌지를 담은게 아니고 'Apple'이라는 '문자열'을 담을 경우 
		// 제네릭 이후 코드 타입을 지정하도록 개선이 되었기 때문에 컴파일 에러가 남
		//aBox.set("Apple");
		//oBox.set("Orange");
		
		// 박스에서 과일을 꺼내는데 원래의 형 변환이 불필요
		Apple5 ap = aBox.get();
		Orange5 og = oBox.get();
		
		System.out.println(ap);
		System.out.println(og); //원하는 결과 (I am an apple) 출력
	}

}

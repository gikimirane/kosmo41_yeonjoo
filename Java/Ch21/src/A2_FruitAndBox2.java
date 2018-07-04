//
// 제네릭 이전의 코드 사용의 예 (각각의 박스를 생성하지 않고, 오브젝트로 통합)
//

class Apple2 {
	public String toString() {
		return "I am an apple";
	}
}

class Orange2 {
	public String toString() {
		return "I am an orange";
	}
}

class Box2 {
	private Object ob;                 // 사과하고 오렌지 박스를 나누지 않고 Object에 담음
	
	public void set(Object o) {
		ob = o;
	}
	public Object get() {
		return ob;
	}
}

class A2_FruitAndBox2 {

	public static void main(String[] args) { 
		Box2 aBox = new Box2();               // 과일 담는 박스를 생성할 필요가 없고, 
		Box2 oBox = new Box2();               // Object에서 불러옴
		
		// 과일을 박스에 담는다.
		aBox.set(new Apple2());
		oBox.set(new Orange2());
		
		// 박스에서 과일을 꺼낸다.
		Apple2 ap = (Apple2)aBox.get();
		Orange2 og = (Orange2)oBox.get();
		
		System.out.println(ap);
		System.out.println(og);

	}

}

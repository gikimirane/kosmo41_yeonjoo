//
// 제네릭 메소드의 정의
//

class BoxC<T> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

class BoxFactoryC {
//	public static void main(String[] args) { 
//	ㄴ 기본적인 형태에서 가운데 <T>가 하나 더 들어가 있음 >> 제네릭 메소드
	public static <T> BoxC<T> makeBox(T o) {
		BoxC<T> box = new BoxC<T>();           // 상자를 생성
		box.set(o);                            // 전달 된 인스턴스를 상자에 담는다
 		return box;                            // 상자를 반환
	}
}

class C1_GenericMethodBoxMaker1 {

	public static void main(String[] args) {
	// 제네릭 메소드의 T는 메소드 호출 시점에 결정한다.
		BoxC<String> sBox = BoxFactoryC.makeBox("Sweet");
		System.out.println(sBox.get());
		
	// 다음과 같이 타입인자 생략 가능 앞에 <String>를 쓰면 뒤에는 또 쓸 필요가 없음	
		BoxC<Double> dBox = BoxFactoryC.makeBox(7.59); // 7.59에 대해 오토 박싱 진행
		System.out.println(dBox.get());
	}

}

//
// 와일드카드 
//

class Box4<T> {
	private T ob;
	public void set(T o) { ob = o; }
	public T get() { return ob; }
	
	@Override 
	public String toString() {
		return ob.toString();
	}
 }

class Unboxer4 {
	public static <T> T openBox(Box4<T> box) {
		return box.get();
	}
	
  //public static <T> void peekBox(Box4<T> box) {  제네릭 메소드의 정의
  //    System.out.println(box);
  //}
	
	public static void peekBox(Box4<?> box) { // 와일드카드 기반 메소드 정의
		System.out.println(box);
	}
}

class B2_WildcardUnboxer {

	public static void main(String[] args) { 
		Box4<String> box = new Box4<>();
		box.set("So Simple String");
		Unboxer4.peekBox(box);

	}

}

// 와일드카드 기반 메소드 정의가 더 간결하므로 우선하도록 권고
// 메소드의 정의가 복잡해 질수록 와일드카드 기반 메소드의 정의가 더 간결해 보인다.
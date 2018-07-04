class BoxD<T> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

class UnboxerD {
//	public static void main(String[] args) { 
//	ㄴ 기본적인 형태에서 가운데 <T>가 하나 더 들어가 있음 >> 제네릭 메소드
	
	public static <T> T openBox(BoxD<T> box) {  // 언박싱
		return box.get();
	}
}

class C2_GenericMethodBoxMaker2 {

	public static void main(String[] args) {
		BoxD<String> box = new BoxD<> ();  //앞쪽에 <String>이 적혀있으면 뒤쪽에는 <>만 적어도 알아서 찾음
		box.set("My Generic Method");
		
		String str = UnboxerD.<String>openBox(box); //앞쪽에 지정되어 있지 않으면 뒤에는 꼭 지정해 줘야함
		System.out.println(str);

	}

}

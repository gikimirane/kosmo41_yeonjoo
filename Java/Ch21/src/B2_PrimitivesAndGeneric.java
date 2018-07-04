import javax.swing.Box;

//
// 기본 자료형에 대한 제한 그리고 래퍼 클래스
//

class Box6 <T> {               
	private T ob;                 
	
	public void set(T o) {    
		ob = o;
	}
	public T get() {
		return ob;
	}
}

class B2_PrimitivesAndGeneric {

	public static void main(String[] args) {
		
		// Box6<int> box = new Box6<int>();
		// ㄴ 타입 인자로 기본 자료형(int)이 올 수 없다. >> 컴파일 오류 발생
		
		Box6<Integer> iBox = new Box6<Integer>();
		
		iBox.set(125);; // 오토 박싱 진행
		int num = iBox.get(); // 오토 언박싱 진행
		System.out.println(num);

	}

}

// 래퍼 클래스가 필요한 이유

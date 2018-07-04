import javax.swing.Box;

//
// 타입 인자 제한의 효과
//

class Box7<T extends Number> {       // 인스턴스 생성 시 타입 인자로 
  	private T ob;                    // Number 또는 이를 상속하는 클래스만 올수 있음

	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

public class B4_BoundedBox {

	public static void main(String[] args) {
		
		//Box7<String> iBox = new Box7<>();   Number 관련 인자가 아니기 때문에 오류
		//iBox.set("apple");
	
		Box7<Integer> iBox = new Box7<>();   //Integer기 때문에 별 문제 없이 출력
		iBox.set(24);
		
		Box7<Double> dBox = new Box7<>();
		dBox.set(5.97);

		System.out.println(iBox.get());
		System.out.println(dBox.get());
	}

}

// 
// 다중 매개변수 기반 제네릭 클래스의 정의
//

class DBox<L,R> {
	private L left;  // 왼쪽 수납 공간
	private R right; // 오른쪽 수납 공간
	
	public void set(L o,R r) {
		left = o;
		right = r;
	}
	
	@Override
	public String toString() {
		return left + " & " + right;
	}
}

public class B1_MultiTypeParam {

	public static void main(String[] args) {
		DBox<String,Integer> box = new DBox<String,Integer>();  
		box.set("Apple",25);      //ㄴ왼쪽은 String 오른쪽은 Int로 타입지정
		System.out.println(box); 

	}

}

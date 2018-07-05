import java.util.*;
//
// HashSet<E>인스턴스에 저장할 클래스 정의 예
// ㄴ 클래스를 비교하여 나온 결과

class Num1 {
	private int num;
	
	public Num1(int n) {
		num = n;
	}
	
	@Override
	public String toString() {
		return String.valueOf(num);
	}
}

class B2_HashSetEqualityOne {

	public static void main(String[] args) {
		HashSet<Num1> set = new HashSet<>();
		set.add(new Num1(7799));
		set.add(new Num1(9955));
		set.add(new Num1(7799)); // New를 할 경우 동일한 인스턴스가 아니다.
		// ㄴ내용일 동일하게 7799라고 하더라도  클래스를 비교 했기 때문에 
		// ㄴ마지막 7799가 동일한 내용이더라도 새로운 인스턴스로 인식하여 3개가 출력 됨
		
		System.out.println("인스턴스 수: " + set.size());
		
		for(Num1 n : set)
			System.out.print(n.toString() + '\t');
		
		System.out.println();
		

	}

}

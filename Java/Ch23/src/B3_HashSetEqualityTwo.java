import java.util.*;
//
//HashSet<E>인스턴스에 저장할 클래스 정의 예
//ㄴ 내용을 비교하여 나온 결과

class Num2 {
	private int num;
	
	public Num2(int n) {
		num = n;
	}
	
	@Override
	public String toString() {
		return String.valueOf(num);
	}

	@Override
	public int hashCode() {   // 해쉬 기본 알고리즘 (적용기준)
		return num % 3;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(num == ((Num2)obj).num)
			return true;
		else
			return false;
	}
}

class B3_HashSetEqualityTwo {

	public static void main(String[] args) {
		
		HashSet<Num2> set = new HashSet<>();
		set.add(new Num2(7799));
		set.add(new Num2(9955));
		set.add(new Num2(7799)); 
		// ㄴ오버라이딩으로 클래스 비교가 아닌 내용을 비교하였기 떄문에
		// ㄴ 내용이 동일한 7799를 빼고 두개의 인스턴스만 출력 됨
		
		System.out.println("인스턴스 수: " + set.size());
		
		for(Num2 n : set)
			System.out.print(n.toString() + '\t');
		
		System.out.println();	

	}

}

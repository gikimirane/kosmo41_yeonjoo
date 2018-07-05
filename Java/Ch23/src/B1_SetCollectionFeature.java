import java.util.*;
//
// Set<E>을 구현하는 클래스의 특성과 HashSet<E>클래스
// Set<E> 인터페이스를 구현하는 제네릭 클래스들은 다음 두가지 특성을 갖는다.
// : 저장 순서가 유지되지 않는다.
// : 데이터의 중복저장을 허용하지 않는다
class B1_SetCollectionFeature {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		set.add("Toy"); 
		set.add("Box");
		set.add("robot"); 
		set.add("Box");  // 중복저장이 허용되지 않음으로 한번만 출력 됨
		
		System.out.println("인스턴스 수: " + set.size());
		
		//반복자를 이용한 전체 출력
		for(Iterator<String>itr = set.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');
		System.out.println();
		
		//for-each문을 이용한 전체 출력
		for(String s : set)
			System.out.print(s + '\t');
		System.out.println();

	}

}
// 여기서 중복의 기준은?
// 두 인스턴스가 hashCode 메소드 호출결과로 반환하는 값이 동일해야 한다.
// < 해쉬 알고리즘 >
// 분류 대상을 정해놓은 기준으로 연산하여 연산 결과에 따라 인스턴스를 분류

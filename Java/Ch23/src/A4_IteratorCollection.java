import java.util.*;
//
// Iterator 반복자의 세가지 메소드
//

public class A4_IteratorCollection {

	public static void main(String[] args) {
	List<String> list = new LinkedList<>();
	
	//인스턴스 저장
	list.add("Toy");
	list.add("Box");
	list.add("Robot");
	list.add("Box");
	
	//반복자 획득
	Iterator<String> itr = list.iterator();
	
	//반복자를 이용한 순차적 참조
	while(itr.hasNext())
		System.out.print(itr.next() + '\t');
	
	System.out.println();

	//반복자 다시 획득
	itr = list.iterator();
	
	//"Box"의 삭제
	String str;
	while(itr.hasNext()) {    // hasnext() next 메소드 호출 시 참조 값 반환 가능 여부 확인
		str = itr.next();     // E next() 다음 인스턴스의 참조 값을 반환
				
		if(str.equals("Box"))
			itr.remove();     // remove() next 메소드 호출을 통해 반환했던 인스턴스 삭제
	}
	
	//반복자 다시 획득
	itr = list.iterator();
	
	//삭제후 결과 확인
	while(itr.hasNext())
		System.out.print(itr.next() + '\t');
	
	System.out.println();
	}

}

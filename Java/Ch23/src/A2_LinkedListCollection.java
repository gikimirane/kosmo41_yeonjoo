import java.util.*;
//
//LinkedList<E>클래스
//ㄴ 리스트 기반 자료구조는 열차칸을 더하고 뺴는 형태의 자료 구조
//ㄴ 인스턴스 저장 > 열차 칸을 하나 더한다.
//ㄴ 인스턴스 삭제 > 해당 열차 칸을 삭제한다.
//ㄴ * 데이터의 추가 / 삭제가 많은 경우는 ArrayList 보다는 LinkedList를 사용함

public class A2_LinkedListCollection {

	public static void main(String[] args) {
	List<String> list = new LinkedList<>(); // Array를 Linked로 변경
		
		//컬렉션 인스턴스에 문자열 인스턴스 저장
		list.add("Toy");
		list.add("Box");
		list.add("Box");    //리스트의 특징 : 중복 허용
		list.add("robot");
		
		//저장된 문자열 인스턴스의 참조
		for(int i = 0; i <list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();
		
		list.remove(0); // 첫번째 인스턴스 삭제
		list.add("conan"); // 마지막에 인스턴스 추가 
		
		//첫 번째 인스턴스 삭제 후 나머지 인스턴스들을 참조
		for(int i = 0; i <list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();
	}

}
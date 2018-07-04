import java.util.*;

public class A3_EnhancedForCollection {

	public static void main(String[] args) {
	List<String> list = new LinkedList<>(); 
		
		//컬렉션 인스턴스에 문자열 인스턴스 저장
		list.add("Toy");
		list.add("Box");
		list.add("Box");    
		list.add("robot");
		
		//저장된 인스턴스의 순차적 접근 방법 >> * enhanced for문 사용 *
		for(String s : list)
			System.out.print(s + '\t');
		System.out.println();
		
		list.remove(0); // 첫번째 인스턴스 삭제
		list.add("conan"); // 마지막에 인스턴스 추가 
		
		//첫 번째 인스턴스 삭제 후 나머지 인스턴스들을 참조
		for(int i = 0; i <list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();
	}

}
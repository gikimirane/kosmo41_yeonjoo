import java.util.*;

//
// TreeSet<E>클래스의 이해와 활용
//  ㄴ 트리 자료 구조 기반 / 정렬 상태가 유지 되면서 인스턴스가 저장됨 

class C1_SortedTreeSet {

	public static void main(String[] args) {
		TreeSet<Integer> tree = new TreeSet<Integer>();
		tree.add(3); tree.add(1);
		tree.add(2); tree.add(4);
		System.out.println("인스턴스 수: " + tree.size());
		
		//for-each문에 의한 반복
		for(Integer n : tree) // 데이터의 묶음
			System.out.print(n.toString() + '\t');  //'n'은 변수명 String타입으로 출력해줘
		System.out.println();
		
		//Iterator 반복자에 의한 반복
		for(Iterator<Integer> itr = tree.iterator(); itr.hasNext();)
			System.out.print(itr.next().toString() + '\t');
			System.out.println();
	}

}

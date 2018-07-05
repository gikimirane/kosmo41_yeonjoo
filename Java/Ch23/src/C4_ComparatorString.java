import java.util.*;
//
//Comparator<T> 인터페이스 기반 TreeSet<E>의 예
//ㄴ 문자열의 길이 기준으로 정렬을 원할 때

class StringComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();   // 문자열 길이 기준으로 정렬하라는 기준
	}
}

class C4_ComparatorString {

	public static void main(String[] args) {
	//	TreeSet<String> tree = new TreeSet<>(); // 기본 오름차순 ( abc비교 )
		TreeSet<String> tree = new TreeSet<>(new StringComparator());
		                                //    ㄴ 새로운 기준 문자열 길이로 비교 요청
		tree.add("Box");
		tree.add("Rabbit");
		tree.add("Robot");
		tree.add("Robot1"); // 정렬 기준이 문자열 길이이므로
		// Rabbit과 동일한 길이의 Robot1은 제외하고 나머지 오름차순으로 출력 됨
		
		for(String s : tree)
			System.out.print(s.toString() + '\t');
		
		System.out.println();
	}

}

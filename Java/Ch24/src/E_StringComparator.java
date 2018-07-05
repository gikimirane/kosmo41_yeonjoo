import java.util.*;
//
// 찾기 : Comparator<T> 기반의 예
//

class StrComp implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return s1.compareToIgnoreCase(s2); // 대,소문자 구분없이 비교
	}
}

class E_StringComparator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ROBOT");
		list.add("APPLE");
		list.add("BOX");
		
		//정렬과 탐색의 기준
		StrComp cmp = new StrComp(); 
		
		//정렬
		Collections.sort(list, cmp);
		
		//탐색
		int idx = Collections.binarySearch(list, "Robot", cmp); 
		System.out.println(list.get(idx));
	}

}

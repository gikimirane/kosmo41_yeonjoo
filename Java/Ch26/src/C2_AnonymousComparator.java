//
//익명 클래스 사용의 예 2
//

import java.util.*;

public class C2_AnonymousComparator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ROBOT");
		list.add("APPLE");
		list.add("BOX");
		
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		};
		
		Collections.sort(list, cmp);
		System.out.println(list);
	}

}

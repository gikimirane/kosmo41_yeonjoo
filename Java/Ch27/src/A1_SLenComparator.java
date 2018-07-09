import java.util.*;

/*
 * 인스턴스 보다 기능 하나가 필요한 상황을 위한 람다
 */

class SLenComp implements Comparator<String>{
	@Override
	public int compare(String s1,String s2) {
		return s1.length() - s2.length();
	}
}

class A1_SLenComparator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Robot");
		list.add("Lambda");
		list.add("Box");
		
		Collections.sort(list, new SLenComp()); // 정렬

		for(String s : list)
			System.out.println(s);
	}

}

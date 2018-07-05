import java.util.*;
//
// Comparator<T> 인터페이스 기반 TreeSet<E>의 예
// ㄴ 수를 가지고 비교 기본 오름차순이지만 내림차순 정렬을 원할 때

class Person2 implements Comparable<Person2> {
	String name;
	int age;
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() { return name + " : " + age; }
	
	@Override
	public int compareTo(Person2 p) {
		return this.age - p.age;  // 기본 Tree Set 정렬방법 (오름차순)
	}
}

class PersonComparator implements Comparator<Person2> {
	public int compare(Person2 p1, Person2 p2) {
		return p2.age - p1.age; 
		// p1이 p2보다 크면 양의 정수 반환 
		// p1이 p2보다 작으면 음의 정수 반환
		// p1이 p2가 같다면 0 반환
	}
}

class C3_ComparatorPerson {

	public static void main(String[] args) {
	//	TreeSet<Person2> tree = new TreeSet<>(); 기본이 되는 정렬 방법
		TreeSet<Person2> tree = new TreeSet<>(new PersonComparator());
		                                  //   ㄴ 새로운 정렬 기준을 제시       
		tree.add(new Person2("YOON", 37));
		tree.add(new Person2("HONG", 53));
		tree.add(new Person2("PARK", 22));
		
		for(Person2 p : tree)
			System.out.println(p);


	}

}

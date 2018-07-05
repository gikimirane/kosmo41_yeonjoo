import java.util.TreeSet;
//
//TreeSet<E>클래스의 오름차순 출력
//

class Person implements Comparable<Person> {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + " : " + age;
	}
	
	@Override
	public int compareTo(Person p) {
		//return this.age - p. age;  << 오름차순
		return p.age - this.age;     // 내림차순
	}
}

class C2_ComparablePerson {

	public static void main(String[] args) {
		TreeSet<Person> tree = new TreeSet<>();
		tree.add(new Person("YOON", 37));
		tree.add(new Person("HONG", 53));
		tree.add(new Person("Lee", 22));   
		tree.add(new Person("PARK", 22)); // 현재, 나이를 기준으로 정렬하고 있기 때문에
 //                                          동일한 나이일 경우 뒤에 정보를 제외하고 출력 됨
		
		for(Person p : tree)
			System.out.println(p);

	}

}

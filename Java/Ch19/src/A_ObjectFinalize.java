//
// finalize 메소드의 오버라이딩 예
//

class Person {
	String name;
	public Person (String name) {
		this.name = name;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();   // 상위 클래스의 finalize 메소드 호출  
		System.out.println("destroyed : " + name);
	} 
	
}
class A_ObjectFinalize {

	public static void main(String[] args) {
		Person p1 = new Person("Yoon");
		Person p2 = new Person("Park");
		p1 = null;
		p2 = null;
		// System.gc();           << 가비지 컬렉터 수행을 명령하는 메소드
		// System.runFinalization(); 
		//  ㄴ GC에 의해서 소멸이 결정된 인스턴스를 즉시 소멸 시키는 메소드

		System.out.println("end of program");
	}

}

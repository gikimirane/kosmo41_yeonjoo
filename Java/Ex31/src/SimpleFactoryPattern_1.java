abstract class Human1 {      // <<< 추상클래스 
	abstract void print();  // <<< 추상메서드 
}                           // <<< Human 이라는 클래스가 print라는 행동을 하기 원함 

class Man1 extends Human1 {   

	public void print() {                    // Human 클래스를 상속 받아 
		System.out.println("남자생성");      // print1 라는 추상 메서드에 동작을 오버라이딩
	}
 }

class Woman1 extends Human1 {                 

	public void print() {                    // Human 클래스를 상속 받아 
		System.out.println("여자생성");      // print1 라는 추상 메서드에 동작을 오버라이딩

	}
}

class HumanFactory1 {
	public static Human1 create(String str) {
		
		if (str == "남자") {
			return new Man1();
		} else if (str == "여자") {          // Man과 Woman은 자식 객체이므로 
			return new Woman1();             // Human 부모객체에 대입 가능
		}
		return null;                         // "남자" "여자" 의 값을 휴먼 타입으로 리턴
	}
}
	
public class SimpleFactoryPattern_1 {            // 값을 출력

	public static void main(String[] args) {     
		Human1 h1 = HumanFactory1.create("남자");  //Human 클래스를 상속받은 Man 클래스안의 값
		h1.print();
		
		Human1 h2 = HumanFactory1.create("여자");  //Human 클래스를 상속받은 Woman 클래스안의 값
		h2.print();
	}

}

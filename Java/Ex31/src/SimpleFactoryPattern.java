abstract class Human {      // <<< 추상클래스 
	abstract void print();  // <<< 추상메서드 
}                           // <<< Human 이라는 클래스가 print라는 행동을 하기 원함 

class Man extends Human {   
	String str;
	
	Man(String str) {                       // Human 클래스를 상속 받아 
		this.str = str;                     // print라는 추상 메서드에 생성1,2라는 정의를 함
	}                                           
	
	public void print() {
		System.out.println(str + " 생성1");
		System.out.println(str + " 생성2");
	}
 }

class Woman extends Human {                 
	String str;
	
	Woman(String str) {                    // Human 클래스를 상속 받아
		this.str = str;                    // print라는 추상 메서드에 생성1,2,3라는 정의를 함
	}
	
	public void print() {
		System.out.println(str + " 생성1");
		System.out.println(str + " 생성2");
		System.out.println(str + " 생성3");
	}
}

class HumanFactory {
	public static Human create(String str) {
		
		if (str == "남자") {
			return new Man(str);
		} else if (str == "여자") {             // Man과 Woman은 자식 객체이므로 
			return new Woman(str);              // Human 부모객체에 대입 가능
		}
		return null;                            // "남자" "여자" 일때 값을 리턴함
	}
}
	
public class SimpleFactoryPattern {              // 값을 출력

	public static void main(String[] args) {     
		Human h1 = HumanFactory.create("남자");  //Human 클래스를 상속받은 Man 클래스안의 값
		h1.print();
		
		Human h2 = HumanFactory.create("여자");  //Human 클래스를 상속받은 Woman 클래스안의 값
		h2.print();
	}

}

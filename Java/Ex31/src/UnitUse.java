abstract class Unit {                             // <<< 추상클래스 
	abstract void attack();                       // <<< 추상메서드
}

class Marine extends Unit {
	public void attack() {
		System.out.println("총으로 공격");
		System.out.println("공격력 10으로 공격");  // <<< attack이라는 추상메서드를 
	}                                              //     상속받아 Marine 클래스 안의
 }                                                 //     attack을 "재정의"

class Zealot extends Unit {
	public void attack() {
		System.out.println("손으로 공격");
		System.out.println("공격력 8로 공격");     // <<< attack이라는 추상메서드를 
	}                                              //     상속받아 Zealot 클래스 안의 
}                                                  //     attack을 "재정의"

class Zergling extends Unit {
	public void attack() {
		System.out.println("입으로 공격");         
		System.out.println("공격력 9로 공격");     // <<< attack이라는 추상메서드를 
	}                                              //     상속받아 Zergling 클래스 안의
}                                                  //     attack을 "재정의"

public class UnitUse {

	public static void main(String[] args) {       // 출력
		
		//테란
		Unit unit1 = new Marine();                 // Unit 이라는 부모 클래스 요소를 상속받아
		unit1.attack();                            // 재정의한 attack 들로  
		                                           // 각각 새로운 오브젝트를 생성
		//프로토스
		Unit unit2 = new Zealot();
		unit2.attack();
		
		//저그
		Unit unit3 = new Zergling();
		unit3.attack();

	}

}
